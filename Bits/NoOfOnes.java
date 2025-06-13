package Bits;

import java.util.*;

public class NoOfOnes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = 0;
        int count;
        for (int i = 0; i <= n; i++) {
            temp = i;
            count = 0;
            while (temp != 0) {
                if ((temp & 1) == 1) {
                    count++;
                }
                temp = temp >> 1;
            }
            System.out.print(count + " ");
        }

    }

}
