package hhtpheader;

import java.io.*;
import java.net.*;
import java.util.*;

public class HTTPHeaderAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a URL (e.g., https://www.google.com): ");
        String urlString = sc.nextLine();

        try {
            
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
           connection.connect();

  
            System.out.println("\n--- HTTP Header Information ---");
            System.out.println("Request Method: " + connection.getRequestMethod());
            System.out.println("Response Code: " + connection.getResponseCode());
            System.out.println("Response Message: " + connection.getResponseMessage());

         
            System.out.println("\n--- All HTTP Headers ---");
            Map<String, List<String>> headerFields = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

          
            connection.disconnect();
        } 
        catch (MalformedURLException e) {
            System.out.println("❌ Invalid URL format.");
        } 
        catch (IOException e) {
            System.out.println("❌ Error connecting to the URL: " + e.getMessage());
        }

        sc.close();
    }
}

