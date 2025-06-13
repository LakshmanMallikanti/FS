package Bits;

import java.util.*;

public class DiffInCombinations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] a = new int[s.length];
        int n = a.length;
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = a[i] ^ a[j];
                while (temp != 0) {
                    if ((temp & 1) == 1)
                        count++;
                    temp = temp >> 1;
                }

            }
        }
        System.out.print(count);
    }
}