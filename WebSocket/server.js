const WebSocket = require('ws');

const wss = new WebSocket.Server({ port: 8080 });
const employees = [];
let employeeId = 1;

wss.on('connection', (ws) => {
    console.log('Client connected');

    ws.on('message', (message) => {
        console.log(`Received: ${message}`);
        const response = handleCommand(message.toString());
        ws.send(response);
    });

    ws.on('close', () => {
        console.log('Client disconnected');
    });
});

function handleCommand(command) {
    const parts = command.trim().split(' ');

    if (parts[0] === 'INSERT' && parts.length === 3) {
        const name = parts[1];
        const salary = parseFloat(parts[2]);
        
        if (!isNaN(salary) && salary > 0) {
            employees.push({ id: employeeId++, name, salary });
            return 'Employee inserted successfully.';
        }
    } else if (parts[0] === 'RETRIEVE' && parts.length === 1) {
        if (employees.length === 0) return 'No employees found.';
        return employees.map(emp => `ID: ${emp.id}, Name: ${emp.name}, Salary: ${emp.salary}`).join('\n');
    }

    return 'Invalid command.';
}

console.log('WebSocket Server running on ws://localhost:8080');