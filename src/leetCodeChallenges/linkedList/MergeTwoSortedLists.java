package leetCodeChallenges.linkedList;

/**
 * Link: https://leetcode.com/problems/merge-two-sorted-lists/?envType=problem-list-v2&envId=linked-list
 * Problem Title: Merge Two Sorted Lists (LeetCode 21)
 * Problem Description: Given the heads of two sorted singly linked lists, list1 and list2,
 * merge the two lists into one sorted list. The list should be made by splicing together
 * the nodes of the first two lists. Return the head of the merged linked list.
 * <p>
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * <p>
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 * <p>
 * Example 3:
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 * <p>
 * Constraints:
 * - The number of nodes in both lists is in the range [0, 50].
 * - -100 <= Node.val <= 100.
 * - Both list1 and list2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedLists {

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
     * Merges two sorted singly linked lists into a single sorted linked list.
     * The merge is done by splicing (re-pointing) the nodes from the original lists.
     * <p>
     * Approach: Iterative with Dummy Head (or Sentinel Node)
     * This approach simplifies the process of building a new linked list by
     * eliminating the need for special handling of the very first node.
     * <p>
     * Algorithm Steps:
     * 1.  **Create a Dummy Head Node:**
     * -   Initialize a new `ListNode` (e.g., with value 0 or -1, its value doesn't matter)
     * called `dummyHead`. This node will serve as a temporary placeholder that
     * simplifies attaching the first actual node of the merged list.
     * `ListNode dummyHead = new ListNode(0);`
     * 2.  **Initialize a Current Pointer:**
     * -   Create another `ListNode` pointer called `current` and initialize it to `dummyHead`.
     * -   The `current` pointer will always point to the last node that has been added
     * to our new merged list (or the `dummyHead` itself initially). It acts as the
     * "traveling tail" of the list being built.
     * `ListNode current = dummyHead;`
     * 3.  **Iteratively Merge Nodes:**
     * -   Use a `while` loop that continues as long as *both* `list1` and `list2` have nodes.
     * `while (list1 != null && list2 != null)`
     * -   Inside the loop:
     * a.  **Compare Values:** Check `list1.val` against `list2.val`.
     * b.  **Append Smaller Node:** Attach the node with the smaller value to `current.next`.
     * -   If `list1.val <= list2.val`: `current.next = list1;`
     * -   Else: `current.next = list2;`
     * *The power of dummyHead:* Because `current` always points to a valid `ListNode` (either `dummyHead` or a previously attached real node), the `current.next = ...` operation never needs an `if` check for the very first real node. It uniformly appends to the end.
     * c.  **Advance Pointers:**
     * -   Move `current` forward to the node that was just attached: `current = current.next;` (or `current = list1;` or `current = list2;` depending on which was chosen). This updates `current` to be the new "end" of the merged list.
     * -   Advance the pointer of the list from which the node was taken (e.g., `list1 = list1.next;` or `list2 = list2.next;`).
     * 4.  **Attach Remaining Nodes:**
     * -   After the `while` loop, one of the lists (`list1` or `list2`) might still have remaining nodes (because the loop condition `list1 != null && list2 != null` ensures it stops as soon as *one* list becomes empty).
     * -   Since both original lists were sorted, all remaining nodes in the non-empty list are already greater than or equal to all nodes already merged. Therefore, simply attach the rest of the non-empty list to `current.next`.
     * `if (list1 != null) { current.next = list1; }`
     * `else { current.next = list2; }` (This covers cases where `list2` has remaining nodes, or both were initially empty).
     * 5.  **Return the Merged List Head:**
     * -   The `dummyHead` was just a temporary starting point. The actual merged list begins at `dummyHead.next`.
     * `return dummyHead.next;`
     *
     * @param list1 The head of the first sorted singly linked list.
     * @param list2 The head of the second sorted singly linked list.
     * @return The head of the newly merged, sorted singly linked list.
     * <p>
     * Complexity Analysis:
     * -   **Time Complexity:** O(M + N), where M is the number of nodes in `list1` and N is the number of nodes in `list2`.
     * Each node from both lists is visited and processed exactly once.
     * -   **Space Complexity:** O(1), as the solution uses a constant amount of extra space for the `dummyHead`, `current`, `list1`, and `list2` pointers, regardless of the input list sizes. No additional data structures are used.
     */
    public static ListNode mergeList(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode(99);
        ListNode currentNode = mergedList;
        ListNode l1 = list1;
        ListNode l2 = list2;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                currentNode.next = l1;
                currentNode = currentNode.next;
                l1 = l1.next;
            } else {
                currentNode.next = l2;
                currentNode = currentNode.next;
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            currentNode.next = l2;
        } else {
            currentNode.next = l1;
        }

        return mergedList.next;
    }
}
