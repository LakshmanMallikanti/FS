import java.util.*;

public class prac {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        char[] c = sc.next().toCharArray();
        ArrayList<Integer> b = new ArrayList<>();
        for (char dIST : c) {

            if (dIST + '0' >= 'A' + '0' && dIST + '0' <= 'Z' + '0') {

                opp(b, dIST);
                System.out.println(b);
            } else {
                b.add(dIST + '0');
                System.out.println(b);
            }
        }
        int sum = 0;
        for (Integer i : b) {
            sum = sum + i;
        }
        System.out.print(sum);

    }

    static void opp(ArrayList<Integer> a, char c) {
        if (c == 'A') {
            a.add(a.get(a.size() - 1) + a.get(a.size() - 2));
        }
        if (c == 'D') {
            a.add(2 * (a.get(a.size() - 1)));
        }
        if (c == 'R') {
            a.remove(a.size() - 1);
        }
    }

}