package leetCodeChallenges.linkedList;

/**
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * Problem Title: Remove Duplicates from Sorted List
 * Problem Description: Given the head of a sorted linked list, delete all duplicates
 * such that each element appears only once. Return the linked list sorted as well.
 * <p>
 * Example 1:
 * Input: head = [1,1,2]
 * Output: [1,2]
 * <p>
 * Example 2:
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * <p>
 * Constraints:
 * - The number of nodes in the list is in the range [0, 300].
 * - -100 <= Node.val <= 100
 * - The list is guaranteed to be sorted in ascending order.
 * <p>
 * This class provides a solution to remove duplicates from a sorted singly-linked list.
 */
public class RemoveDuplicatesSortedList {

    // Note: The ListNode class definition is usually provided by the platform (e.g., LeetCode)
    // or defined as a nested static class. For documentation purposes, we assume it exists.
    // Example:
    // private static class ListNode {
    //     int val;
    //     ListNode next;
    //     ListNode() {}
    //     ListNode(int val) { this.val = val; }
    //     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    // }

    /**
     * Removes duplicates from a sorted singly-linked list such that each element
     * appears only once. The modification is performed in-place.
     * <p>
     * Approach: Iterative Single-Pointer Traversal
     * Since the input linked list is guaranteed to be sorted, all duplicate elements
     * will always appear adjacent to each other. This property simplifies the problem
     * significantly, allowing for an efficient in-place removal process using a single
     * traversal pointer.
     * <p>
     * Algorithm Steps:
     * 1.  **Handle Edge Cases:**
     * -   If the list is empty (`head == null`) or contains only a single node (`head.next == null`),
     * there are no duplicates present. In these cases, the function directly returns the original `head`
     * as there's nothing to modify.
     * 2.  **Initialize Traversal Pointer:**
     * -   A pointer named `currentNode` is created and initialized to the `head` of the list.
     * This pointer will be responsible for iterating through the list and managing modifications.
     * 3.  **Traverse and Compare (Main Loop):**
     * -   A `while` loop is used to iterate through the list. The loop continues as long as two conditions are met:
     * a.  `currentNode` is not `null`: This ensures we haven't processed beyond the end of the list.
     * b.  `currentNode.next` is not `null`: This ensures there's a subsequent node available to compare with,
     * preventing `NullPointerExceptions` when accessing `currentNode.next.val`.
     * -   Inside the loop, the value of the `currentNode` is compared with the value of the node it points to (`currentNode.next`):
     * a.  **If `currentNode.val == currentNode.next.val` (Duplicate Found):**
     * -   This condition indicates that the node pointed to by `currentNode.next` is a duplicate of `currentNode`.
     * -   To "delete" this duplicate node (i.e., remove it from the list's sequence), the `next` pointer of `currentNode`
     * is updated to bypass it: `currentNode.next = currentNode.next.next;`
     * -   **Crucially:** In this scenario, `currentNode` is **not** advanced. This is vital because the *new*
     * `currentNode.next` (the node that `currentNode` now points to after the bypass) might itself
     * still be another duplicate of `currentNode.val` (e.g., in a sequence like `1 -> 1 -> 1`).
     * The loop will re-evaluate `currentNode` with its newly linked `next` pointer in the next iteration.
     * b.  **Else (`currentNode.val != currentNode.next.val`, Unique Value):**
     * -   This condition means that `currentNode`'s value is distinct from its immediate successor's value.
     * -   Since `currentNode` is unique relative to the next element, it is safe to advance `currentNode` to the
     * next node in the list: `currentNode = currentNode.next;`
     * 4.  **Return Head:**
     * -   After the `while` loop terminates (either because `currentNode` became `null` or `currentNode.next` became `null`),
     * all duplicates will have been successfully processed and removed from the list. The modifications were done in place,
     * so the original `head` pointer still correctly points to the beginning of the de-duplicated sorted list.
     * The function then returns this `head` pointer.
     *
     * @param head The head of the sorted singly-linked list.
     * @return The head of the linked list with duplicates removed, still sorted.
     * <p>
     * Complexity Analysis:
     * - **Time Complexity:** O(N), where N is the number of nodes in the linked list.
     * The algorithm iterates through the list at most once. Each node is visited a constant number of times.
     * - **Space Complexity:** O(1), as the solution only uses a constant amount of extra space for pointers
     * (`currentNode`) regardless of the input list size.
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode currentNode = head;

        while (currentNode != null && currentNode.next != null) {
            if (currentNode.val == currentNode.next.val) {
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
        }
        return head;
    }
}