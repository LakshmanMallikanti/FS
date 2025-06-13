package greedy;

import java.util.*;

class NumberOfCoins {
    static List<Integer> minPartition(int N) {
        int[] denom = new int[] { 2000, 500, 200, 100, 50, 20, 10, 5, 2, 1 }; // Already sorted in descending
        List<Integer> result = new ArrayList<>();

        for (int coin : denom) {
            while (N >= coin) {
                N -= coin;
                result.add(coin);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int N = 1234; // Example amount
        List<Integer> coins = minPartition(N);
        System.out.println("Coins used: " + coins);
    }
}
