package ua.nure.garmash.Practice3;


import java.util.HashMap;

/**
 * Created by User on 11/20/2017.
 */
public class Part5 {
    public static void main(String[] args) {

        System.out.println(decimal2Roman(99));
        System.out.println(roman2Decimal("XCVIII"));
    }

    public static final int[] DECIMAL = {1, 4, 5, 9, 10, 40, 50, 90, 100};
    public static final String[] ROMAN = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};
    public static  HashMap<String, Integer> store = new HashMap<>();



    public static String decimal2Roman(int decimal) {
        if (decimal > 100) {
            throw new IllegalArgumentException("Please specify proper number. Allowed range: 0-100;" +
                    System.lineSeparator() + "Your value: " + decimal);
        }
        if (decimal == 0) return "null";
        StringBuilder result = new StringBuilder();
        int i = DECIMAL.length - 1;
        while (decimal != 0) {
            int temp = decimal / DECIMAL[i];
            while (temp != 0) {
                temp--;
                result.append(ROMAN[i]);
            }
            decimal = decimal % DECIMAL[i];
            i--;
        }
        return result.toString();
    }

    public static int roman2Decimal(String s) {
        initializeStore();
        int result = 0;
        int i = 0;
        while (i < s.length()) {
            String letter = String.valueOf(s.charAt(i));
            int number = store.get(letter);
            i++;
            if (i != s.length()) {
                int nextNumber = store.get(String.valueOf(s.charAt(i)));
                if (nextNumber > number) {
                    number = nextNumber - number;
                    i++;
                }
            }
            result += number;
        }
        return result;
    }

    public static void initializeStore () {
        for (int i =0; i<  DECIMAL.length; i ++) {
            store.put(ROMAN[i],(DECIMAL[i]));
        }
    }



}

