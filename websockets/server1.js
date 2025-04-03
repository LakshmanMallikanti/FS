const WebSocket = require('ws');

// Create a WebSocket server
const server = new WebSocket.Server({ port: 8080 });

server.on('connection', (socket) => {
    console.log('Client connected');

    // Send a welcome message to the client
    socket.send('Hello from server!');

    // Handle messages from clients
    socket.on('message', (message) => {
        console.log(`Received: ${message}`);
        socket.send(`Server received: ${message}`);
    });

    // Handle client disconnection
    socket.on('close', () => {
        console.log('Client disconnected');
    });
});

console.log('WebSocket server is running on ws://localhost:8080');



