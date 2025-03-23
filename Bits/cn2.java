package Bits;

/*Write a program that takes an IP address and subnet mask (in CIDR notation, 
e.g., 192.168.1.1/24) as input and calculates the network and broadcast addresses.

Input Format:
---------------
A String, IPAddress
An integer, CIDR

Output Format:
---------------
Space separated IP addresses, netwrok IP and broadcast IP.


Sample Input-1:
-----------------
192.168.1.10
24

Sample Output-1:
------------------
192.168.1.0 192.168.1.255


Sample Input-2:
-----------------
192.0.2.1
24

Sample Output-2:
------------------
192.0.2.0 192.0.2.255
 */
import java.util.*;

public class cn2 {
    static String con(int cidr) {
        int a = 0xffffffff << (32 - cidr);
        return String.format("%d.%d.%d.%d",
                (a >> 24) & 0xff,
                (a >> 16) & 0xff,
                (a >> 8) & 0xff,
                (a >> 0) & 0xff);
    }

    static String and(String s1, String s2) {
        String[] a1 = s1.split("\\.");
        String[] a2 = s2.split("\\.");

        return String.format("%d.%d.%d.%d",
                Integer.parseInt(a1[0]) & Integer.parseInt(a2[0]),
                Integer.parseInt(a1[1]) & Integer.parseInt(a2[1]),
                Integer.parseInt(a1[2]) & Integer.parseInt(a2[2]),
                Integer.parseInt(a1[3]) & Integer.parseInt(a2[3]));
    }

    static String or(String s1, String s2) {
        String[] a1 = s1.split("\\.");
        String[] a2 = s2.split("\\.");

        return String.format("%d.%d.%d.%d",
                Integer.parseInt(a1[0]) | ((0xff)),
                Integer.parseInt(a1[1]) | ((0xff)),
                Integer.parseInt(a1[2]) | ((0xff)),
                Integer.parseInt(a1[3]) | ((0xff)));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int cidr = sc.nextInt();
        System.out.print(and(con(cidr), s));
        System.out.print(or(s, and(con(cidr), s)));

    }
}