package leetcode.easy;

public class Task125 {
    public boolean isPalindrome(String s) {

        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(str);
        String newStr = "";

        if (s.length() == 1) {
            return true;
        }

        if (str.length() % 2 != 0) {
            for (int i = str.length()-1; i > str.length() / 2; i--) {
                newStr += str.charAt(i);
            }
            if (newStr.equals(str.substring(0, str.length()/2))) {
                return true;
            }
        } else {
            for (int i = str.length()-1; i > (str.length() / 2) - 1; i--) {
                newStr += str.charAt(i);
            }
            if (newStr.equals(str.substring(0, str.length()/2))) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Task125 task125 = new Task125();
        System.out.println(task125.isPalindrome("0P"));
    }
}
