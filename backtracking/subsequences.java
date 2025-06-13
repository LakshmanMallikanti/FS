package backtracking;

import java.util.*;

public class subsequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        ArrayList<String> ans = new ArrayList<>();
        bt(arr, 0, "", ans);
        Collections.sort(ans);
        System.out.println(ans);
    }

    public static void bt(int arr[], int index, String path, ArrayList<String> ans) {
        if (index == arr.length) {
            ans.add(path);
            return;
        }
        bt(arr, index + 1, path + arr[index], ans);
        bt(arr, index + 1, path, ans);
    }
}