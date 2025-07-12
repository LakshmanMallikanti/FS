
/*Basava is interested in playing with digits.
He wants to create a set of integers of length N, using the digits[0-9].
The rules to create the integers are as follows:
	- digits in each integer are like d0,d1,d2...dn-1
	- and |d0-d1| = |d1-d2| = |d2-d3| ... |dn-2 - dn-1|= D

Basava is given two integers N and D, where N is length of the integer and 
D is the difference. Can you help Basava, to create such list of integers 
and print all the possible integers in ascending order


Note:
-----
Integers with leading 0's are not allowed


Input Format:
-------------
Two space separated integers N and K.

Output Format:
--------------
Print all the possible integers in ascending order.


Sample Input-1:
---------------
3 5

Sample Output-1:
----------------
[161, 272, 383, 494, 505, 616, 727, 838, 949]


Sample Input-2:
---------------
2 3

Sample Output-2:
----------------
[14, 25, 30, 36, 41, 47, 52, 58, 63, 69, 74, 85, 96]
 */
import java.util.*;

public class NumberSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> set = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            build(i, n - 1, k, i, set);
        }
        Collections.sort(set);
        System.out.print(set);
    }

    static void build(int prev, int rem, int diff, int num, ArrayList<Integer> set) {
        if (rem == 0) {
            set.add(num);
            return;
        }
        if (prev + diff <= 9)
            build(prev + diff, rem - 1, diff, num * 10 + (prev + diff), set);
        if (diff != 0 && prev - diff >= 0)
            build(prev - diff, rem - 1, diff, num * 10 + (prev - diff), set);
    }
}