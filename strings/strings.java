package strings;

public class strings {
    public static void main(String... args) {
        String a = "hai";
        String b = "hai";
        // a and b point to same memory
        String c = new String("hai");
        System.out.println(a == b);// gives true
        System.out.println(a == c);// gives false
        System.out.println(a.equals(c));// gives true as it checks the value but not referencing addresses
        char h = a.charAt(0);
        System.out.println(Character.toString('a') + "a");// print aa
        a = a.toUpperCase();
        StringBuilder s = new StringBuilder("madam");
        System.out.println(s.equals(s.reverse()));
        System.out.println(a.substring(0, 1));// excludes 1,if 0,0 then print empty string
        System.out.println(s.substring(0));
    }
}
