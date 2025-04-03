/*<!--
Employee Management WebSocket Application with MongoDB

Objective:
----------
Your task is to develop a WebSocket-based Employee Management System using Node.js and MongoDB. 
The system should allow multiple clients to interact with a database to perform the following operations:
	1. Insert Employee Records (INSERT <name> <salary> <role> <department> <experience>)
	2. Retrieve Employee List (RETRIEVE)
	3. Retrieve Employee List who belongs to a department (RETRIEVE_BY_DEPT <department>)
	
The WebSocket server should be capable of handling multiple concurrent clients and persist employee data in MongoDB.


// MongoDB Employee Schema
const employeeSchema = new mongoose.Schema({
    name: String,
    salary: Number,
    role: String,
    department: String,
    experience: Number
});

Requirements:
-------------
Implement WebSocket Server
	The server should:
		-> Accept multiple client connections. (give a response as "Connected" )
		-> Process incoming commands from clients as discussed above.
		-> Log each received command on the console.
		-> Ensure proper error handling (e.g., invalid salary, missing name, etc.).
		
Expected Behavior
-----------------

============================================================================================
Client Command			                Server Response
============================================================================================
INSERT Alice 50000 Developer IT 5	    "Employee inserted successfully."
INSERT Bob 60000 Manager IT 5	        "Employee inserted successfully."

RETRIEVE				                "ID: 1, Name: Alice, Salary: 50000, Role: Developer, Department: IT, Experience: 5 years"
                                        "ID: 2, Name: Bob, Salary: 60000, Role: Manager, Department: IT, Experience: 5 years"

RETRIEVE_BY_DEPT IT                     "ID: 1, Name: Alice, Salary: 50000, Role: Developer, Department: IT, Experience: 5 years"
                                        "ID: 2, Name: Bob, Salary: 60000, Role: Manager, Department: IT, Experience: 5 years"


INVALID					                "Invalid command."
============================================================================================

Note: 
-> Your implementation must use MongoDB for data persistence.
-> The server should run on port 8080.
-> The system should allow multiple clients to connect.


EXAMPLE URL value=>   ws://10.11.xx.xx:8080
*/

const WebSocket = require('ws');
const mongoose = require('mongoose');

// Connect to MongoDB
mongoose.connect('mongodb://localhost:27017/employeesDB').then(() => console.log('Connected to MongoDB'))
  .catch(err => console.error('MongoDB connection error:', err));

// Define Employee Schema
const employeeSchema = new mongoose.Schema({
    name: String,
    salary: Number,
    role: String,
    department: String,
    experience: Number
});

const Employee = mongoose.model('Employee', employeeSchema);

// Create WebSocket Server
const server = new WebSocket.Server({ port: 8080 });

server.on('connection', (socket) => {
    console.log('New client connected');
    socket.send('Connected');

    socket.on('message', async (message) => {
        console.log(`Received: ${message}`);
        const parts = message.toString().trim().split(' ');
        const command = parts[0].toUpperCase();

        if (command === 'INSERT' && parts.length === 6) {
            const [_, name, salary, role, department, experience] = parts;
            const salaryNum = parseInt(salary, 10);
            const experienceNum = parseInt(experience, 10);
            
            if (isNaN(salaryNum) || isNaN(experienceNum)) {
                socket.send('Invalid salary or experience value.');
                return;
            }

            const newEmployee = new Employee({ name, salary: salaryNum, role, department, experience: experienceNum });
            await newEmployee.save();
            socket.send('Employee inserted successfully.');
        } 
        else if (command === 'RETRIEVE') {
            const employees = await Employee.find();
            if (employees.length === 0) {
                socket.send('No employees found.');
            } else {
                const response = employees.map(emp => `ID: ${emp._id}, Name: ${emp.name}, Salary: ${emp.salary}, Role: ${emp.role}, Department: ${emp.department}, Experience: ${emp.experience} years`).join('\n');
                socket.send(response);
            }
        } 
        else if (command === 'RETRIEVE_BY_DEPT' && parts.length === 2) {
            const department = parts[1];
            const employees = await Employee.find({ department });
            if (employees.length === 0) {
                socket.send(`No employees found in department: ${department}`);
            } else {
                const response = employees.map(emp => `ID: ${emp._id}, Name: ${emp.name}, Salary: ${emp.salary}, Role: ${emp.role}, Department: ${emp.department}, Experience: ${emp.experience} years`).join('\n');
                socket.send(response);
            }
        } 
        else {
            socket.send('Invalid command.');
        }
    });

    socket.on('close', () => {
        console.log('Client disconnected');
    });
});

console.log('WebSocket server running on ws://localhost:8080');
