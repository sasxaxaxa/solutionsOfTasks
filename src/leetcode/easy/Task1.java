package leetcode.easy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array of integers nums and an integer target,
//return indices of the two numbers such that they add up to target.

//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//Example 2:
//
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//Example 3:
//
//Input: nums = [3,3], target = 6
//Output: [0,1]


public class Task1 {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        int[] arr1 = new int[]{2, 7, 11, 15};
        int[] arr2 = new int[]{3, 2, 4};
        int[] arr3 = new int[]{3, 3};
        int[] arrItog = task1.twoSum(arr3, 6);
        for (int i : arrItog) {
            System.out.println(i);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        List<Integer> indexArray = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indexArray.add(i);
                    indexArray.add(j);
                }
            }
        }
        int[] arr = new int[indexArray.size()];
        for (int i = 0; i < indexArray.size(); i++) {
            arr[i] = indexArray.get(i);
        }
        return arr;
    }
}
