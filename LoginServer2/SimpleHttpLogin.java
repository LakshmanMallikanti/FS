package LoginServer2;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class SimpleHttpLogin {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/login", new LoginHandler());
        server.setExecutor(null); // creates a default executor
        System.out.println("Server started on port 8000...");
        server.start();
    }

    static class LoginHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if (!"POST".equalsIgnoreCase(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(405, -1); // Method Not Allowed
                return;
            }

            // Read request body
            InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            StringBuilder requestBody = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                requestBody.append(line);
            }

            // Parse form data
            Map<String, String> params = parseFormData(requestBody.toString());
            String username = params.get("username");
            String password = params.get("password");

            boolean isValid = validateCredentials(username, password);

            String response;
            int statusCode;

            if (isValid) {
                response = "Login successful";
                statusCode = 200;
            } else {
                response = "Invalid credentials";
                statusCode = 401;
            }

            exchange.sendResponseHeaders(statusCode, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }

        private Map<String, String> parseFormData(String formData) throws UnsupportedEncodingException {
            Map<String, String> params = new HashMap<>();
            for (String pair : formData.split("&")) {
                String[] parts = pair.split("=");
                if (parts.length == 2) {
                    String key = URLDecoder.decode(parts[0], StandardCharsets.UTF_8);
                    String value = URLDecoder.decode(parts[1], StandardCharsets.UTF_8);
                    params.put(key, value);
                }
            }
            return params;
        }

        private boolean validateCredentials(String username, String password) {
            String jdbcUrl = "jdbc:mysql://localhost:3306/restdb";
            String dbUser = "root"; // replace with your MySQL username
            String dbPass = ""; // replace with your MySQL password

            try {
                Connection conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPass);
                String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, username);
                stmt.setString(2, password);

                ResultSet rs = stmt.executeQuery();
                boolean found = rs.next();

                rs.close();
                stmt.close();
                conn.close();

                return found;

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}
