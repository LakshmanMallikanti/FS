package Recursion;

import java.util.*;

public class pascal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            System.out.print(pas(i, n) + " ");
        }

    }

    static int pas(int i, int n) {
        if (i == 0)
            return 1;
        if (i == n)
            return 1;
        else
            return pas(i - 1, n - 1) + pas(i, n - 1);
    }
}