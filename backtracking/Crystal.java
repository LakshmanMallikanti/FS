package backtracking;

import java.util.*;

public class Crystal {
    static ArrayList<ArrayList<Integer>> a = new ArrayList<>();

    public static void main(String[] haha) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> s = new ArrayList<>();
        bt(n, s, 2, 1);
        System.out.print(a);
    }

    static void bt(int n, ArrayList<Integer> s, int i, int pro) {
        if (pro > n || i > n) {
            return;
        }
        if (pro == n) {
            if (s.size() > 1) {
                a.add(new ArrayList<>(s));
            }
            return;
        }
        s.add(i);
        bt(n, s, i, pro * i);
        s.remove(s.size() - 1);
        bt(n, s, i + 1, pro);
    }

}