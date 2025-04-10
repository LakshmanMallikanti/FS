
import java.util.*;

public class ApplesAndBananasHint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String secret = sc.next();
        String guess = sc.next();

        String hint = getHint(secret, guess);
        System.out.println(hint);
    }

    public static String getHint(String secret, String guess) {
        int apples = 0, bananas = 0;
        int[] countSecret = new int[10]; // count of digits in secret
        int[] countGuess = new int[10]; // count of digits in guess

        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                apples++;
            } else {
                countSecret[s - '0']++;
                countGuess[g - '0']++;
            }
        }

        for (int i = 0; i < 10; i++) {
            bananas += Math.min(countSecret[i], countGuess[i]);
        }

        return apples + "A" + bananas + "B";
    }
}
