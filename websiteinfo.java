package websiteinfo;

import java.io.*;
import java.net.*;
import java.util.*;

public class websiteinfoviewer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a URL (e.g., https://www.google.com): ");
        String urlString = sc.nextLine();

        try {
          
            URL url = new URL(urlString);

     
            URLConnection connection = url.openConnection();

         
            System.out.println("\n--- Website Information ---");
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Content Type: " + connection.getContentType());
            System.out.println("Content Length: " + connection.getContentLengthLong());
            
            long date = connection.getDate();
            if (date != 0) {
                System.out.println("Date: " + new Date(date));
            } else {
                System.out.println("Date information not available.");
            }

          
            System.out.println("\n--- Webpage Content (First Few Lines) ---");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null && count < 5) { 
                System.out.println(line);
                count++;
            }

            reader.close();
        } 
        catch (MalformedURLException e) {
            System.out.println("❌ Invalid URL format.");
        } 
        catch (IOException e) {
            System.out.println("❌ Error reading from the URL: " + e.getMessage());
        }

        sc.close();
    }
}









//OUTPUT:
Enter a URL (e.g., https://www.google.com): 
