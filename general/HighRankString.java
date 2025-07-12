/*Prabhath is working on words.  He used to take out every letter that was repeated 
in the word. 
A word W is given to Prabhath. His objective is to eliminate every duplicate 
letter from W such that the resultant word R contains every unique letter from W
and did not contain any duplicate letters. 
And R should be at the top of the dictionary order.

NOTE:
-----
He is not allowed to shuffle the relative order of the letters of the word W to
create the word R.

Input Format:
-------------
A String, the word W.

Output Format:
--------------
Print a String, resultant word R.


Sample Input-1:
---------------
cbadccb

Sample Output-1:
----------------
adcb


Sample Input-2:
---------------
silicosis

Sample Output-2:
----------------
ilcos */

import java.util.*;

public class HighRankString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.next();
        int[] freq = new int[26];
        boolean[] used = new boolean[26];
        for (char c : in.toCharArray()) {
            freq[c - 'a']++;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : in.toCharArray()) {
            freq[c - 'a']--;
            if (used[c - 'a'])
                continue;
            while (!stack.isEmpty() && stack.peekLast() < c && freq[stack.peekLast() - 'a'] > 0) {
                used[stack.pollLast() - 'a'] = false;
            }
            stack.addLast(c);
            used[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack)
            sb.append(c);
        System.out.print(sb.toString());
    }
}