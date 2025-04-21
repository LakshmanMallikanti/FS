package Recursion;

import java.util.*;

public class diceCombinations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt(); // Target sum
        List<String> result = new ArrayList<>();
        findCombinations("", target, result);
        System.out.println(result);
    }

    public static void findCombinations(String p, int target, List<String> result) {
        if (target == 0) {
            result.add(p);
            return;
        }
        for (int i = 1; i <= target && i <= 6; i++) {
            findCombinations(p + i, target - i, result);
        }
    }
}
