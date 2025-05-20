package leetCodeChallenges.linkedList;

/**
 * Link: https://leetcode.com/problems/middle-of-the-linked-list/submissions/1639366068/
 * Problem Title: Middle of the Linked List (LeetCode 876)
 * Problem Description: Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes (i.e., an even number of nodes), return the second middle node.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5] (Node 3 is the middle node)
 *
 * Example 2:
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6] (Node 4 is the second middle node)
 *
 * Constraints:
 * - The number of nodes in the list is in the range [1, 100].
 * - 1 <= Node.val <= 100.
 */
public class MiddleOfTheLinkedList {
    // Assuming ListNode definition is accessible (e.g., provided by LeetCode or a nested class)
    // Example ListNode definition for reference:
    // public static class ListNode {
    //     int val;
    //     ListNode next;
    //     ListNode() {}
    //     ListNode(int val) { this.val = val; }
    //     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    // }


    /**
     * Finds the middle node of a singly linked list using the Fast and Slow Pointer (Tortoise and Hare) algorithm.
     * This method efficiently finds the middle in a single pass. It correctly handles both odd and even
     * length lists, returning the second middle node for even-length lists as per the problem's requirement.
     *
     * Approach: Fast and Slow Pointers
     * This technique involves using two pointers that traverse the linked list at different speeds.
     * The 'fast' pointer moves twice as fast as the 'slow' pointer. By the time the 'fast' pointer
     * reaches the end of the list, the 'slow' pointer will naturally be positioned at the middle.
     *
     * Algorithm Steps:
     * 1.  **Initialize Pointers:**
     * -   Create two `ListNode` pointers: `slow` and `fast`.
     * -   Initialize both `slow` and `fast` to point to the `head` of the linked list.
     * ```java
     * ListNode slow = head;
     * ListNode fast = head;
     * ```
     * 2.  **Traverse with Different Speeds:**
     * -   Use a `while` loop to advance the pointers. The loop condition is crucial for correctness and preventing `NullPointerExceptions`:
     * `while (fast != null && fast.next != null)`
     * -   `fast != null`: Ensures that the `fast` pointer itself hasn't gone past the end of the list.
     * -   `fast.next != null`: Ensures that `fast` has at least one more node to point to, which is necessary
     * before attempting to take two steps (`fast.next.next`). If `fast.next` is `null`, then `fast.next.next`
     * would cause an `NullPointerException`.
     * -   Inside the loop, advance the pointers:
     * -   `slow = slow.next;`         (The `slow` pointer moves one step at a time.)
     * -   `fast = fast.next.next;`    (The `fast` pointer moves two steps at a time.)
     * 3.  **Determine Middle Node (Loop Termination Logic):**
     * -   The loop terminates when `fast` either becomes `null` or `fast.next` becomes `null`.
     * -   At the point of termination, the `slow` pointer will be correctly positioned at the middle node.
     * -   **How it handles different list lengths:**
     * -   **Odd Length List (e.g., [1,2,3,4,5]):**
     * `fast` will stop when it points to the very last node. At this exact moment, `slow` will be pointing
     * to the true middle node (e.g., node 3 for [1,2,3,4,5]).
     * -   **Even Length List (e.g., [1,2,3,4,5,6]):**
     * `fast` will stop when it becomes `null` (after having taken its last two steps, moving past the end).
     * In this scenario, `slow` will be pointing to the *second* of the two middle nodes (e.g., node 4 for [1,2,3,4,5,6]),
     * which directly matches the problem's requirement.
     * 4.  **Return Result:**
     * -   Return the `slow` pointer, as it now points to the middle node as defined by the problem.
     *
     * @param head The head of the singly linked list.
     * @return The middle node of the linked list. If two middle nodes, returns the second.
     *
     * Complexity Analysis:
     * -   **Time Complexity:** O(N), where N is the number of nodes in the linked list.
     * The `fast` pointer traverses the list, effectively visiting each node roughly once. Since `fast` moves twice as fast,
     * it will cover the entire list in approximately N/2 iterations.
     * -   **Space Complexity:** O(1), as the solution uses only a constant amount of extra space for the `slow` and `fast` pointers,
     * regardless of the input list's size. No auxiliary data structures are used.
     */
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
