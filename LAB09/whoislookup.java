package whoislookup;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class whoisClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter domain name (e.g., example.com): ");
        String domain = sc.nextLine();

        try {
         
            Socket socket = new Socket("whois.internic.net", 43);

            
            OutputStream out = socket.getOutputStream();
            out.write((domain + "\r\n").getBytes());
            out.flush();


            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            System.out.println("\n--- WHOIS Information for " + domain + " ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

           
            reader.close();
            out.close();
            socket.close();
        } 
        catch (IOException e) {
            System.out.println("❌ Error: Unable to connect to WHOIS server or retrieve information.");
        }

        sc.close();
    }
}



//OUTPUT:
Enter domain name (e.g., example.com): google.com











