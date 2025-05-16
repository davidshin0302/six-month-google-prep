package leetCodeChallenges.linkedList;


public class RemoveDuplicatesSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode nextNode = head.next;
        while(nextNode != null){
            if(head.next.val == head.val){
                head.next = head;
                head = null;

                nextNode = nextNode.next;
            }
        }

        return head;
    }
}
