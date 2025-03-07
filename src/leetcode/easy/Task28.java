package leetcode.easy;

public class Task28 {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        Task28 task28 = new Task28();
        System.out.println(task28.strStr("butsad", "sad"));
    }
}
