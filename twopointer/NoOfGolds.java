package twopointer;

import java.util.*;

public class NoOfGolds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        int gold = 0;
        int sum = c;
        Arrays.sort(a);
        int i = 0, j = a.length - 1;
        int temp = 0;
        while (i <= j) {
            if (a[i] <= sum) {
                gold++;
                sum = sum - a[i];
                i++;
                temp = Math.max(temp, gold);
            } else {
                if (gold > 0) {
                    sum = sum + a[j];
                    j--;
                    gold--;

                }
            }
        }

        System.out.print(temp);

    }

}