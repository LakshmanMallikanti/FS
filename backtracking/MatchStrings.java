/*Given two strings S1 and S2, find if S2 can match S1 or not.

A match that is both one-to-one (an injection) and onto (a surjection), 
i.e. a function which relates each letter in string S1 to a separate and 
distinct non-empty substring in S2, where each non-empty substring in S2
also has a corresponding letter in S1.

Return true,if S2 can match S1.
Otherwise false.

Input Format:
-------------
Line-1 -> Two strings S1 and S2

Output Format:
--------------
Print a boolean value as result.


Sample Input-1:
---------------
abab kmitngitkmitngit

Sample Output-1:
----------------
true


Sample Input-2:
---------------
aaaa kmjckmjckmjckmjc

Sample Output-2:
----------------
true

Sample Input-3:
---------------
mmnn pqrxyzpqrxyz

Sample Output-3:
----------------
false */
package backtracking;

import java.util.*;

public class MatchStrings {
    static boolean res = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        String s1 = s[0];
        String s2 = s[1];
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i - 1 < s2.length() - s1.length(); i++) {
            check(map, s1, s2, i);
            if (res)
                break;
        }
        System.out.print(res);

    }

    static void check(Map<Character, String> map, String s1, String s2, int idx) {
        if (s1.length() == 0) {
            res = true;
            return;
        }
        if (s2.isEmpty())
            return;
        if (map.containsKey(s1.charAt(0))) {
            if (map.get(s1.charAt(0)).equals(s2.substring(0, idx + 1))) {
                for (int i = 1; i - 1 < s2.length() - s1.length(); i++) {
                    check(map, s1.substring(1, s1.length()), s2.substring(idx + 1, s2.length()), i);
                }

            } else
                return;
        }
        map.put(s1.charAt(0), s2.substring(0, idx + 1));
        for (int i = 1; i - 1 < s2.length() - s1.length(); i++) {
            check(map, s1.substring(1, s1.length()), s2.substring(idx + 1, s2.length()), i);
        }
        map.remove(s1.charAt(0));

    }
}
