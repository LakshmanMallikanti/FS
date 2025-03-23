package Bits;
public class BinaryDifference {
    public static int minChangesToMakeEqual(int num1, int num2) {
        // Convert numbers to binary strings
        String binary1 = Integer.toBinaryString(num1);
        String binary2 = Integer.toBinaryString(num2);
        
        // Pad with leading zeros to make both strings of equal length
        while (binary1.length() < binary2.length()) binary1 = "0" + binary1;
        while (binary2.length() < binary1.length()) binary2 = "0" + binary2;
        
        int changes = 0;
        
        // Compare both binary strings and count mismatches
        for (int i = 0; i < binary1.length(); i++) {
            if (binary1.charAt(i) != binary2.charAt(i)) {
                changes++;
            }
        }
        
        return changes;
    }
    
    public static void main(String[] args) {
        int num1 = 5; // Binary: 101
        int num2 = 6; // Binary: 110
        
        int result = minChangesToMakeEqual(num1, num2);
        System.out.println("Minimum changes required: " + result);
    }
}
