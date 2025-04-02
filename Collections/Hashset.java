package Collections;

import java.util.HashSet;
import java.util.Iterator;
// search,add,delete takes o(1) time

public class Hashset {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set.contains(1));
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
