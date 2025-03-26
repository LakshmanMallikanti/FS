 const socket = new WebSocket('ws://localhost:8080');

        socket.onopen = () => console.log('Connected to WebSocket server');

        socket.onmessage = (event) => {
            const chat = document.getElementById('chat');
            const messageElement = document.createElement('p');
            messageElement.textContent = event.data;  // Display received message
            chat.appendChild(messageElement);
            chat.scrollTop = chat.scrollHeight;  // Auto-scroll to latest message
        };

        socket.onclose = () => console.log('Disconnected from WebSocket server');

        function sendMessage() {
            const input = document.getElementById('msg');
            if (input.value.trim() !== '') {
                socket.send(input.value);
                input.value = ''; // Clear input after sending
            }
        }
    