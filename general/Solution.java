
/*
Problem: Write a program to count each word's first index and total occurrences 
in a sentence.

Sample Input: 
apple banana apple orange banana apple

Sample Output:
apple -> first index: 0, count: 3
banana -> first index: 6, count: 2
orange -> first index: 19, count: 1

*/
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder S = new StringBuilder(s);
        String[] str = s.split(" ");
        HashMap<String, int[]> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        for (String st : str) {
            if (!list.contains(st)) {
                list.add(st);
                map.putIfAbsent(st, new int[2]);
                int start = S.indexOf(st);
                map.get(st)[0] = start;
                map.get(st)[1] = 1;
                while (true) {
                    S.delete(start, start + st.length());
                    if (S.indexOf(st) >= 0) {
                        map.get(st)[1]++;
                    }
                    break;
                }
            }
        }
        System.out.print(map);
    }
}
