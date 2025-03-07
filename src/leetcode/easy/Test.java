package leetcode.easy;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        // Создаем второй связный список: 1 -> 3 -> 4
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        // Создаем объект класса Solution
        Task21 task21 = new Task21();

        // Сливаем два списка
        ListNode mergedList = task21.mergeTwoLists(list1, list2);

        printList(mergedList);
    }


    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
