
/*import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxSize = 0;

        // Compute digit sums and store counts
        for (int i = 1; i <= n; i++) {
            int digitSum = sumOfDigits(i);
            map.put(digitSum, map.getOrDefault(digitSum, 0) + 1);
            maxSize = Math.max(maxSize, map.get(digitSum));
        }

        // Count groups with maxSize
        int count = 0;
        for (int freq : map.values()) {
            if (freq == maxSize) {
                count++;
            }
        }

        System.out.println(map);
    }

    static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
*//* 
             import java.util.*;
             
             public class test {
               public static int opp(String ops) {
                   Stack<Integer> stack = new Stack<>();
             
                   for (char op : ops.toCharArray()) {
                       if (Character.isDigit(op)) {
                           stack.push(op - '0'); // Convert char to integer and push to stack
                       } else if (op == 'R' && !stack.isEmpty()) {
                           stack.pop(); // Remove last element
                       } else if (op == 'D' && !stack.isEmpty()) {
                           stack.push(stack.peek() * 2); // Double last element
                       } else if (op == 'A' && stack.size() >= 2) {
                           int last = stack.pop();
                           int secondLast = stack.pop();
                           stack.push(secondLast);
                           stack.push(last);
                           stack.push(last + secondLast); // Add last two elements
                       }
                   }
             
                   int sum = 0;
                   for (int num : stack) {
                       sum += num;
                   }
                   return sum;
               }
             
               public static void main(String[] args) {
                   Scanner sc = new Scanner(System.in);
                   String s = sc.next();
                   System.out.println(opp(s));
               }
             }*/

import java.util.*;

public class test {
    public static void main(String... input) {
        Scanner sc = new Scanner(System.in);
        char[] c = sc.next().toCharArray();
        System.out.print(harmonious(c));
    }

    static String harmonious(char[] a) {

        int max = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            ArrayList<Character> list = new ArrayList<>();
            for (int j = i; j < a.length; j++) {
                list.add(a[j]);
                System.out.println(list);
                System.out.println(check(list));
                if (check(list)) {
                    if (max < list.size()) {
                        res = str(list);
                        max = list.size();
                    }
                }
            }

        }
        return res.toString();
    }

    static boolean check(ArrayList<Character> a) {
        for (int i = 0; i < a.size(); i++) {
            if (!a.contains((char) (a.get(i) + 32)) && !a.contains((char) (a.get(i) - 32)))
                return false;
        }
        return true;
    }

    static StringBuilder str(ArrayList<Character> a) {
        StringBuilder k = new StringBuilder();
        for (char d : a) {
            k.append(d);
        }
        return k;
    }
}