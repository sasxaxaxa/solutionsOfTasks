package leetcode.medium;

public class Task2 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);

        ListNode current = dummyHead;

        int carry = 0;
        //Это условие проверяет, есть ли еще элементы в списке (l1-2).
        //Если указатель на текущий узел первого списка не равен null, значит,
        // в списке есть еще элементы, и мы можем продолжать их обрабатывать.

        //Это условие проверяет, есть ли перенос (если на предыдущем шаге сумма двух цифр была больше 9).
        // Перенос возникает, если сумма двух цифр (вместе с переносом) больше 9.
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummyHead.next;
    }
}
class ListNode {
    int val; //значение узла (цифра)
    ListNode next; // ссылка на следующий узел

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}