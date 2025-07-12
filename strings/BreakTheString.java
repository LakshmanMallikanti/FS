package strings;

import java.util.*;

public class BreakTheString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int count = 0, ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1')
                ones++;

        }
        if (ones == 0) {
            int res = ((s.length() - 1) * (s.length() - 2)) / 2;
            System.out.print(res);
            return;
        }
        if (ones % 3 == 0) {
            int n = ones / 3;
            int temp = n, freq = ones / n - 1, prev = 1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1' && temp == 0) {

                    prev = prev * (count + 1);
                    count = 0;
                    temp = n - 1;
                    freq--;
                } else if (s.charAt(i) == '1')
                    temp--;
                else if (s.charAt(i) == '0' && temp == 0 && freq > 0)
                    count++;

            }
            if (prev == 1 && count == 0) {
                System.out.print(1);
                return;
            } else {
                System.out.print(prev * (count + 1));
                return;
            }
        }
        System.out.print(2 * count);
    }
}
/*
 * /*
 * Gunith is interested in series and sequence problems in Maths.
 * Gunith is given an array A of integers, he wants to find out
 * a Sequence, which is long and subsequence of given array.
 * 
 * Subsequence AS is the list AS[i], AS[i1], AS[i2], .... AS[ik], from the
 * array,
 * where 0 <= i< i1 < i2 < ..<ik < A.length
 * 
 * The sequence S has to follow this rule, S[i+1] - S[i] are all the same value
 * (for 0 <= i < S.length - 1 ), and Sequence S can be formed from A
 * 
 * Find out the Max possible length of the Longest Sequence.
 * 
 * Input Format:
 * -------------
 * Line-1 -> An integer N, number of array elements
 * Line-2 -> N space separated integers, elements of the array.
 * 
 * Output Format:
 * --------------
 * Print an integer as your result.
 * 
 * 
 * Sample Input-1:
 * ---------------
 * 4
 * 2 6 10 14
 * 
 * Sample Output-1:
 * ----------------
 * 4
 * 
 * 
 * Sample Input-2:
 * ---------------
 * 7
 * 2 5 6 8 10 11 14
 * 
 * Sample Output-2:
 * ----------------
 * 5
 * 
 * Explanation:
 * ------------
 * The longest possible arithmetic series is 2 5 8 11 14.
 */
/*
 * /*
 * Gopal would like to go on Tour, and planned a schedule.
 * Airport authority has created a new way of issuing tickets.
 * Gopal purchased a set of airline tickets,
 * each ticket contains the 'departure from' and 'arrival to'.
 * 
 * Redesign the Gopal's tour schedule in an order.
 * Gopal intially must begin his tour from BZA.
 * Hence the tour schedule's start point should begin with BZA.
 * 
 * You are given a list of flight tickets which Gopal has purchased.
 * Your task is to find out and return the tour schedule that has the least
 * lexical order. Gopal must use all the tickets once and only once.
 * 
 * Note:
 * ------
 * If there are multiple valid schedules, you should return the schedule
 * that has the smallest lexical order when read as a single string.
 * For example, the schedule ["BZA", "LGA"] has a smaller lexical order
 * than ["BZA", "LGB"].
 * 
 * All airports are represented by three capital letters.
 * You may assume all tickets form at least one valid schedule.
 * 
 * Input Format:
 * -------------
 * Single Line of tickets separated by comma, and each ticket separated by
 * space,
 * Gopal's flight tickets.
 * 
 * Output Format:
 * --------------
 * Print the schedule, which is smallest lexical order of tour schedule.
 * 
 * 
 * Sample Input-1:
 * ----------------
 * DEL HYD,BZA DEL,BLR MAA,HYD BLR
 * 
 * Sample Output-1:
 * --------------------
 * [BZA, DEL, HYD, BLR, MAA]
 * 
 * 
 * Sample Input-2:
 * ------------------
 * BZA BLR,BZA CCU,BLR CCU,CCU BZA,CCU BLR
 * 
 * Sample Output-2:
 * ------------------
 * [BZA, BLR, CCU, BZA, CCU, BLR]
 */