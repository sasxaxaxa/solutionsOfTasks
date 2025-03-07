package leetcode.easy;

public class Task9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int original_x = x;
        int fake_x = 0;

        while (x > 0) {
            fake_x = fake_x * 10 + x % 10;
            x = x / 10;
        }
        return fake_x == original_x;
    }
}
