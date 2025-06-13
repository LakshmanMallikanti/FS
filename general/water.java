import java.util.*;

public class water {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int a[] = new int[s.length];
        for (int i = 0; i < a.length; i++)
            a[i] = Integer.parseInt(s[i]);
        int[] c = a.clone();
        Arrays.sort(c);
        int max = c[a.length - 1];
        int water = 0;
        while (max > 0) {
            int start = -1, end = -1, count = 0;
            for (int i = 0; i < a.length; i++) {
                if (start == -1 && a[i] >= max) {
                    start = i;
                    count++;
                } else if (start != -1 && a[i] >= max && end == -1) {
                    end = i;
                    count++;
                } else if (a[i] >= max) {
                    end = i;
                    count++;
                }
            }
            if (count >= 2)
                water = water + (end - start - 1) - (count - 2);

            max--;
        }
        System.out.print(water);
    }
}