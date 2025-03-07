package leetcode.easy;

import java.util.HashMap;

//Given a roman numeral, convert it to an integer.

public class Task13 {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            int current = romanMap.get(s.charAt(i));
            if (i != s.length() - 1) {
                if (current < romanMap.get(s.charAt(i+1))) {
                    count -= current;
                }
                else {
                    count += current;
                }
            } else {
                count += current;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Task13 task13 = new Task13();
        System.out.println(task13.romanToInt("I"));
    }
}
