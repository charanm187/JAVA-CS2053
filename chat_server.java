package chatclient;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class chatclient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Connect to server (same computer)
            Socket socket = new Socket("localhost", 5000);
            System.out.println("✅ Connected to server.");

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Continuously send messages to server
            String message;
            System.out.println("Type messages to send (type 'exit' to quit):");

            while (true) {
                message = sc.nextLine();
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                writer.println(message);
            }

            // Close connections
            writer.close();
            socket.close();
            sc.close();
        } 
        catch (IOException e) {
            System.out.println("❌ Error in client: " + e.getMessage());
        }
    }
}




//OUTPUT:

🖥️ Server started. Waiting for client connection...
✅ Client connected!
