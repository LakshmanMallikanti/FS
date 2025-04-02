const WebSocket = require('ws');

// Create WebSocket server on port 8080
const server = new WebSocket.Server({ port: 8080 });

// In-memory employee storage
let employees = [];
let employeeId = 1;

server.on('connection', (socket) => {
    console.log('New client connected');

    socket.on('message', (message) => {
        console.log(`Received: ${message}`);
        const parts = message.toString().trim().split(' ');
        const command = parts[0].toUpperCase();

        if (command === 'INSERT' && parts.length === 3) {
            const name = parts[1];
            const salary = parseInt(parts[2], 10);
            if (!isNaN(salary)) {
                employees.push({ id: employeeId++, name, salary });
                socket.send('Employee inserted successfully.');
            } else {
                socket.send('Invalid salary value.');
            }
        } else if (command === 'RETRIEVE') {
            if (employees.length === 0) {
                socket.send('No employees found.');
            } else {
                const response = employees.map(emp => `ID: ${emp.id}, Name: ${emp.name}, Salary: ${emp.salary}`).join('\n');
                socket.send(response);
            }
        } else {
            socket.send('Invalid command.');
        }
    });

    socket.on('close', () => {
        console.log('Client disconnected');
    });
});

console.log('WebSocket server running on ws://localhost:8080');
