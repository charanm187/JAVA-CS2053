package inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class FindIPAddress {
    public static void main(String[] args) {
        try {
         
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Your Computer Name: " + localHost.getHostName());
            System.out.println("Your IP Address: " + localHost.getHostAddress());

            // 2️⃣ Accept domain name from user
            Scanner sc = new Scanner(System.in);
            System.out.print("\nEnter a domain name (e.g., www.google.com): ");
            String domain = sc.nextLine();

            // 3️⃣ Print all IP addresses of the domain
            InetAddress[] addresses = InetAddress.getAllByName(domain);
            System.out.println("\nIP Addresses for " + domain + ":");
            for (InetAddress addr : addresses) {
                System.out.println(addr.getHostAddress());
            }

            sc.close();
        } 
        catch (UnknownHostException e) {
            System.out.println("❌ Could not find IP address for the given host.");
        }
    }
}





//OUTPUT:

Your Computer Name: RVU-PC-27
Your IP Address: 172.16.45.22

Enter a domain name (e.g., www.google.com): 









