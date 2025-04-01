package Collections;

import java.util.ArrayList;
import java.util.Collections;

public class Arraylist {
    public static void main(String... input) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);
        list.get(1);// gets the element at index 1
        System.out.println(list.get(0));// prints the element at index 0
        list.add(1, 3);// adds element 3 at index 1
        System.out.println(list);
        list.set(1, 19);// replace the element at index 1 with 19
        System.out.println(list);
        list.remove(1);// removes element at index 1
        System.out.println(list);
        int length = list.size();// gives size of list
        System.out.println(length);
        Collections.sort(list);// sort the list in ascending order
        System.out.println(list);
        list.isEmpty();// return true or false
        list.contains(2);// return true or false
        list.indexOf(1);// returns the first index of the element, return -1 if doesn't exsist
        list.lastIndexOf(1);// return last index of element
        // int[] intArray = list.stream().mapToInt(Integer::intValue).toArray();//
        // converts into array
        list.add(5);
        list.addAll(list2);// add all elements of list2 to list

    }
}
