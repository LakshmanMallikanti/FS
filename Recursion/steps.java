
/*
Sharath is playing a game where there are N levels. Inorder to win the game he has to reach Nth level.

The rule book explains "In one step you can either cross one level or two levels".

Return the number of distinct possible ways to win the game.

Constraints:

    1 <= N <= 45

Input Format:
-------------
Line-1: An Integer N represents number of levels.
  
Output Format:
--------------
Print an integer.


Sample Input-1:
---------------
2
  
Sample Output-1:
----------------
2

Explanation:
------------
1. 1-level+ 1-level =2
2. 2 levels in one step.
   
Sample Input-2:
---------------
4
  
Sample Output-2:
----------------
5

Explanation:
------------
1. 1-level + 1-level + 1-level + 1-level = 4
2. 1-level + 1-level + 2-levels = 4
3. 1-level + 2-levels + 1-level = 4
4. 2-levels + 1-level + 1-level = 4
5. 2-levels + 2-levels  = 4
*/

import java.util.*;

public class steps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = count(n);
        System.out.print(k);
    }

    static int count(int n) {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;
        return count(n - 1) + count(n - 2);
    }
}
/*
 * Pavan is playing a game where there are N levels and each level has some
 * points in it. level[i] is the points to spend on ith level(0-indexed) to move
 * forward. Inorder to win the game he has to reach the top level.
 * 
 * The rule book explains
 * "In one step you have to spend the points given on the present level and you can either cross one level or two levels forward"
 * .
 * 
 * Return the minimum number of points to spend to win the game.
 * 
 * Note:You are allowed to start at either level-0 or level-1.
 * 
 * Constraints:
 * 
 * 2 <= N <=1000
 * 0 <= level[i] <= 999
 * 
 * Input Format:
 * -------------
 * Line-1: An Integer N represents number of levels.
 * Line-2: N space seperated integers represents the points in each level.
 * 
 * Output Format:
 * --------------
 * Print an integer.
 * 
 * 
 * Sample Input-1:
 * ---------------
 * 3
 * 20 30 40
 * 
 * Sample Output-1:
 * ----------------
 * 30
 * 
 * Explanation:
 * ------------
 * He can start at index-1 by spending points 30 and he can win.
 * 
 * Sample Input-2:
 * ---------------
 * 7
 * 2 3 50 2 2 50 2
 * 
 * Sample Output-2:
 * ----------------
 * 9
 * 
 * Explanation:
 * ------------
 * Start at index-1:
 * -Spend 3 points and reach to index-3
 * -Spend 2 points and reach to index-4
 * -Spend 2 points and reach to index-6
 * -Spend 2 points and he wins.
 */