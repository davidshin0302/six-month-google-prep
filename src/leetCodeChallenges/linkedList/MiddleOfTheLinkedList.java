package leetCodeChallenges.linkedList;

public class MiddleOfTheLinkedList {
    public static ListNode middleNode(ListNode head) {
        ListNode slow = new ListNode();
        ListNode fast = new ListNode();

        if (head != null & head.next != null) {
            slow = head.next;
            fast = head.next.next;

            while (fast != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        return slow;
    }
}
