package backtracking;

import java.util.*;

public class TargetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        int target = sc.nextInt();

        ArrayList<String> ans = new ArrayList<>();
        bt(a, 0, new ArrayList<>(), 0, target, ans);
        Collections.sort(ans);
        System.out.println(ans);
    }

    public static void bt(int[] a, int index, List<Integer> path, int sum, int target, ArrayList<String> ans) {
        if (sum > target)
            return;
        if (sum == target) {
            ans.add(format(path));
            return;
        }
        if (index == a.length)
            return;

        // Include a[index] (you can reuse the same index)
        path.add(a[index]);
        bt(a, index, path, sum + a[index], target, ans);
        path.remove(path.size() - 1); // backtrack

        // Skip a[index]
        bt(a, index + 1, path, sum, target, ans);
    }

    public static String format(List<Integer> path) {
        return String.join(",", path.stream().map(String::valueOf).toArray(String[]::new));
    }
}
