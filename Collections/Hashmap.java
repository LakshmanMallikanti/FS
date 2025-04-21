package Collections;

import java.util.*;

public class Hashmap {
    static final Map<Character, String> phoneMap = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Cherry", 30);
        System.out.println(map);
        System.out.println("Value for Apple: " + map.get("Apple"));
        map.remove("Cherry");
        map.replace("apple", 15); // Updates the value of "apple" to 15
        System.out.println("Updated Map: " + map);
        System.out.println("Size of the Map: " + map.size());
        boolean containsBanana = map.containsKey("Banana");
        System.out.println("Contains Banana: " + containsBanana);
        boolean containsGrape = map.containsKey("Grape");
        System.out.println("Contains Grape: " + containsGrape);
        boolean hasValue = map.containsValue(10); // Returns true
        System.out.println("Contains Value 10: " + hasValue);
        for (String key : map.keySet()) {
            System.out.println("Key: " + key);
        }
        for (Integer value : map.values()) {
            System.out.println("Value: " + (int) value);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        map.put("Grape", map.getOrDefault("grape", 0) + 1);// will increase the grape valuse by 1
    }
}
