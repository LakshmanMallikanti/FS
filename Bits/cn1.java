package Bits;

/*Write a program that takes an IP address and subnet mask (in CIDR notation, 
e.g., 192.168.1.1/24) as input and calculates the subnet mask in dotted decimal 
format.

Input Format:
---------------
An integer, CIDR

Output Format:
---------------
String, Subnet's IP Address


Sample Input-1:
---------------
25

Sample Output-1:
----------------
255.255.255.128


Sample Input-2:
---------------
22

Sample Output-2:
----------------
255.255.252.0
*/
import java.util.*;

public class cn1 {
    static String con(int cidr) {
        int a = 0xffffffff << (32 - cidr);
        return String.format("%d.%d.%d.%d",
                (a >> 24) & 0xff,
                (a >> 16) & 0xff,
                (a >> 8) & 0xff,
                (a >> 0) & 0xff);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cidr = sc.nextInt();
        System.out.println(con(cidr));

    }
}