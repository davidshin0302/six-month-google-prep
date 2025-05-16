package leetCodeChallenges.linkedList;

/*
Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/?envType=problem-list-v2&envId=linked-list
 */
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
