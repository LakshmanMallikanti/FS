/*/*
Mr Rajendra Tapadia is given a number N as string to Mr Satyam, and ask him 
to find the number of ways to make that number N equal to zero by using 
the following steps:
    - He need to perform either '+' or '-' operation between two adjacent digits
    - You can repeat the above step to make the N value to 0.
    
For example: if N is 454522 then it's possible to perform the '+'/'-' operations 
the following way, 4+5-4-5-2+2, 4-5-4+5-2+2, 4+5-4-5+2-2 or 4-5-4+5+2-2.
A total of 4 ways.

Your task is to help Mr Satyam to find the number of ways possible to make N to 0
using the above steps. Print "invalid", if it is not possible.

Input Format:
-------------
A String, the number N.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
13741

Sample Output-1:
----------------
2

Explanation: 
------------
The ways are, 1+3-7+4-1 and 1-3+7-4-1.


Sample Input-2:
---------------
2351

Sample Output-2:
----------------
invalid*/
package strings;

import java.util.*;

public class MakeItZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if (s.equals("0")) {
            System.out.print(0);
            return;
        }
        int res = count(s, s.charAt(0) - '0', 1);
        if (res == 0)
            System.out.print("Invalid");
        else
            System.out.print(res);
    }

    static int count(String s, int res, int curpos) {
        if (curpos == s.length()) {
            if (res == 0) {
                return 1;
            } else
                return 0;
        }
        int add = count(s, res + (s.charAt(curpos) - '0'), curpos + 1);
        int sub = count(s, res - (s.charAt(curpos) - '0'), curpos + 1);
        return add + sub;
    }
}