
/*You are given an array ar[], find the closed subsequence in which we subtract 
the largest and smallest element in the subsequence, the result is equal to 1.

Your task is to return the length of its greatest closed subsequence among all
its possible subsequences.

A subsequence of array is a sequence that can be taken from the array by removing 
some or no elements without changing the order of the remaining elements.

Input Format:
-------------
Line-1: An integer n number of elements.
Line-2: n space separated integers represent the elements.
 
Output Format:
--------------
Print an integer.
 
Constraints:
 1 <= n <= 10^4
 -10^4 <= ar[i] <= 10^4

 
Sample Input-1:
---------------
6
4 3 5 2 6 3
 
Sample Output-1:
----------------
3

Explanation:
------------
Subsequence is [4,3,3]
 
Sample Input-2:
---------------
7
20 19 19 29 37 35 19

Sample Output-2:
----------------
4

Explanation:
------------
Subsequence is [20 19 19 19]
*/
import java.util.*;

public class closedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[2 * n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            a[i + n] = a[i];
        }
        System.out.print(closed(a));
    }

    static int closed(int[] a) {
        int n = a.length / 2;
        for (int j = n; j > 1; j--) {
            for (int i = 0; i < 2 * n - 1; i++) {
                if (check(Arrays.copyOfRange(a, i, i + j)))
                    return j;
            }

        }
        return -1;
    }

    static boolean check(int[] a) {
        int min = a[0];
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
            if (a[i] < min)
                min = a[i];
        }

        if (max - min == 1)
            return true;
        return false;
    }
}