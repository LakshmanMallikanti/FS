import java.util.*;

public class EmphaticPronunciation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String emphatic = sc.nextLine();
        String[] words = sc.nextLine().split(" ");
        int count = 0;

        for (String word : words) {
            if (isStretchy(emphatic, word)) {
                count++;
            }
        }
        System.out.println(count);
    }

    static boolean isStretchy(String emphatic, String word) {
        List<Group> eGroups = getGroups(emphatic);
        List<Group> wGroups = getGroups(word);

        if (eGroups.size() != wGroups.size()) return false;

        for (int i = 0; i < eGroups.size(); i++) {
            Group eg = eGroups.get(i);
            Group wg = wGroups.get(i);
            if (eg.ch != wg.ch) return false;

            if (eg.count == wg.count) continue;

            if (eg.count >= 3 && eg.count >= wg.count) continue;

            return false;
        }

        return true;
    }

    static List<Group> getGroups(String s) {
        List<Group> groups = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            int count = 0;
            while (i < s.length() && s.charAt(i) == ch) {
                i++;
                count++;
            }
            groups.add(new Group(ch, count));
        }
        return groups;
    }

    static class Group {
        char ch;
        int count;

        Group(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
