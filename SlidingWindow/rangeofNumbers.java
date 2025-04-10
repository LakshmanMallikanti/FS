package slidingwindow;

/*/*
Nehanth, a bubbly kid playing with digits and creating numbers using them.
The kid is creating the number called successive number. 
A number is called successive number, if and only if 
each digit in the number is one less than the next digit.

You are given two integers, start and end, both are inclusive.
Your task to find and print all the successive numbers in the given range (start, end).

Input Format:
-------------
Two space separated integers, start and end

Output Format:
--------------
Print the list of successive numbers in the range(start, end).


Sample Input-1:
---------------
50 150

Sample Output-1:
----------------
[56, 67, 78, 89, 123]


Sample Input-2:
---------------
100 600

Sample Output-2:
----------------
[123, 234, 345, 456, 567]

*/
import java.util.*;

public class rangeofNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String e = sc.next();
        ArrayList<Integer> a = new ArrayList<>();
        String f = "123456789";
        for (int i = s.length(); i <= e.length(); i++) {
            for (int j = 0; j + i <= f.length(); j++) {
                String k = f.substring(j, j + i);
                if (Integer.parseInt(k) <= Integer.parseInt(e) && Integer.parseInt(k) >= Integer.parseInt(s))
                    a.add(Integer.parseInt(k));
            }
        }
        System.out.print(a);
    }
}
