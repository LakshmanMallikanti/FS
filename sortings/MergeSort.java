package sortings;

import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = { 4, 7, 6, 1, 9, 2, 8, 5, 3 };
        int[] ans = mergesort(a);
        System.out.print(Arrays.toString(ans));
    }

    static int[] mergesort(int[] a) {
        if (a.length == 1)
            return a;
        int mid = a.length / 2;
        int[] left = mergesort(Arrays.copyOfRange(a, 0, mid));
        int[] right = mergesort(Arrays.copyOfRange(a, mid, a.length));
        return merge(left, right);
    }

    static int[] merge(int[] a, int[] b) {
        int i = 0, k = 0, j = 0;
        int n1 = a.length;
        int n2 = b.length;
        int res[] = new int[n1 + n2];
        while (i < a.length && j < b.length) {
            if (a[i] > b[j]) {
                res[k] = b[j];
                j++;
            } else {
                res[k] = a[i];
                i++;
            }
            k++;
        }
        if (i < a.length) {
            while (i < a.length) {
                res[k] = a[i];
                i++;
                k++;
            }
        } else if (j < b.length) {
            while (j < b.length) {
                res[k] = b[j];
                j++;
                k++;
            }
        }
        return res;
    }
}
