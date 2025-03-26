const WebSocket = require('ws');

const server = new WebSocket.Server({ port: 5500 });

let clients = new Set();

server.on('connection', (ws) => {
    clients.add(ws);
    console.log('New client connected. Total clients:', clients.size);

    ws.on('message', (data) => {
        const message = data.toString().trim();  // Convert Buffer to string
        console.log('Received:', message);

        // Broadcast message to all clients
        clients.forEach(client => {
            if (client.readyState === WebSocket.OPEN) {
                client.send(message);
            }
        });
    });

    ws.on('close', () => {
        clients.delete(ws);
        console.log('Client disconnected. Total clients:', clients.size);
    });
});

console.log('WebSocket server is running on ws://192.168.4.206:8080');