const WebSocket = require('ws');
const mongoose = require('mongoose');

// Connect to MongoDB
mongoose.connect('mongodb://127.0.0.1:27017/employeesDB', {
    useNewUrlParser: true,
    useUnifiedTopology: true
}).then(() => console.log("Connected to MongoDB"))
  .catch(err => console.error("MongoDB Connection Error:", err));

// Employee Schema
const employeeSchema = new mongoose.Schema({
    id: Number, // Custom sequential ID
    name: String,
    salary: Number,
    role: String,
    department: String,
    experience: Number
});
const Employee = mongoose.model('Employee', employeeSchema);

// Counter Schema for Sequential ID
const counterSchema = new mongoose.Schema({
    _id: String,
    seq: Number
});
const Counter = mongoose.model('Counter', counterSchema);

// Function to Get Next Sequential ID
async function getNextSequence(name) {
    const counter = await Counter.findByIdAndUpdate(
        name,
        { $inc: { seq: 1 } },
        { new: true, upsert: true }
    );
    return counter.seq;
}

// WebSocket Server
const wss = new WebSocket.Server({ port: 8080 }, () => {
    console.log("WebSocket server started on ws://192.168.4.206:8080");
});

wss.on('connection', (ws) => {
    console.log("Client connected");
    // ws.send("Connected to Employee Management WebSocket Server");

    ws.on('message', async (message) => {
        console.log(`Received: ${message}`);
        const parts = message.toString().split(' ');
        const command = parts[0].toUpperCase();

        try {
            if (command === "INSERT" && parts.length === 6) {
                const [_, name, salary, role, department, experience] = parts;
                const parsedSalary = parseFloat(salary);
                const parsedExp = parseInt(experience);

                if (!isNaN(parsedSalary) && !isNaN(parsedExp)) {
                    const nextId = await getNextSequence("employeeId");
                    const newEmployee = new Employee({ id: nextId, name, salary: parsedSalary, role, department, experience: parsedExp });
                    await newEmployee.save();
                    ws.send("Employee inserted successfully.");
                } else {
                    ws.send("Invalid salary or experience value.");
                }
            } else if (command === "RETRIEVE") {
                const employees = await Employee.find();
                const response = employees.map(`emp => ID: ${emp.id}, Name: ${emp.name}, Salary: ${emp.salary}, Role: ${emp.role}, Department: ${emp.department}, Experience: ${emp.experience} years`).join('\n');
                ws.send(response || "No employees found.");
            } else if (command === "RETRIEVE_BY_DEPT" && parts.length === 2) {
                const department = parts[1];
                const employees = await Employee.find({ department });
                const response = employees.map(`emp => ID: ${emp.id}, Name: ${emp.name}, Salary: ${emp.salary}, Role: ${emp.role}, Department: ${emp.department}, Experience: ${emp.experience} years`).join('\n');
                ws.send(response ||` No employees found in department ${department}`);
            } else {
                ws.send("Invalid command.");
            }
        } catch (error) {
            console.error("Error processing command:", error);
            ws.send("Server error. Please try again.");
        }
    });

    ws.on('close', () => {
        console.log("Client disconnected");
    });
});