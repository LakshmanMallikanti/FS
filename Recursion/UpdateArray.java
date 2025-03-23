package Recursion;

import java.util.*;

public class UpdateArray {
    public static void main(String... input) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        while (!isStable(a)) {
            a = applyChanges(a);
        }

        System.out.println(Arrays.toString(a));
        sc.close();
    }

    static boolean isStable(int[] a) {
        for (int i = 1; i < a.length - 1; i++) {
            if ((a[i] < a[i - 1] && a[i] < a[i + 1]) || (a[i] > a[i - 1] && a[i] > a[i + 1])) {
                return false;
            }
        }
        return true;
    }

    static int[] applyChanges(int[] a) {
        int[] temp = a.clone();
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] < a[i - 1] && a[i] < a[i + 1]) {
                temp[i]++;
            } else if (a[i] > a[i - 1] && a[i] > a[i + 1]) {
                temp[i]--;
            }
        }
        return temp;
    }
}
