package chatserver;

import java.io.*;
import java.net.*;

public class chatserver {
    public static void main(String[] args) {
        try {
          
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("🖥️ Server started. Waiting for client connection...");

          
            Socket socket = serverSocket.accept();
            System.out.println("✅ Client connected!");

            // Set up input stream to receive messages
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

           
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Client: " + message);
                // Optionally echo back to client
                writer.println("Server received: " + message);
            }

         
            reader.close();
            writer.close();
            socket.close();
            serverSocket.close();
        } 
        catch (IOException e) {
            System.out.println("❌ Error in server: " + e.getMessage());
        }
    }
}


//OUTPUT:














