package leetcode.easy;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Task217 {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());
        if (set.size() == nums.length) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 0};
        System.out.println(containsDuplicate(array));
    }
}
