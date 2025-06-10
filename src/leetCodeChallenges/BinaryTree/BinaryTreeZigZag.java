package leetCodeChallenges.BinaryTree;

import java.util.*;

/**
 * 1. Initialization:
 *
 * Use a Queue<TreeNode> (e.g., LinkedList used as a queue) to manage nodes for BFS, similar to standard level-order traversal.
 * Initialize a List<List<Integer>> to store the final result.
 * Introduce a boolean flag, isLeftToRight, initialized to true. This flag will track the current level's traversal direction.
 * Handle the edge case where the root is null by returning an empty list.
 * Add the root to the queue to start the traversal.
 * 2. Level-by-Level Traversal (Main Loop):
 *
 * The main logic resides in a while (!queue.isEmpty()) loop. Each iteration of this loop processes one entire level of the tree.
 * 3. Processing a Single Level (Inner Loop):
 *
 * At the beginning of each main loop iteration, capture the int levelSize = queue.size();. This is crucial because it tells us exactly how many nodes are on the current level.
 * Create a temporary List<Integer> for the values of the current level. Crucially, use a LinkedList for this temporary list. This allows for efficient add(0, element) operations when inserting at the beginning (for right-to-left levels), which an ArrayList would do inefficiently (O(N)).
 * Use a for (int i = 0; i < levelSize; i++) loop to process each node of the current level.
 * poll() a currentNode from the queue.
 * Conditional Value Addition:
 * If isLeftToRight is true, add currentNode.val to the end of the currentLevelValues list (currentLevelValues.add(currentNode.val)).
 * If isLeftToRight is false, add currentNode.val to the beginning of the currentLevelValues list (currentLevelValues.add(0, currentNode.val)). This ensures the right-to-left order for the current level's output.
 * Enqueue Children:
 * If currentNode.left is not null, offer() it to the queue.
 * If currentNode.right is not null, offer() it to the queue. (Note: The order of adding children to the queue here always remains left-then-right. The "zigzag" effect is achieved by how values are added to currentLevelValues, not by altering the queue's order for future levels).
 * 4. After Processing a Level:
 *
 * Once the inner for loop completes, all nodes for the current level have been processed, and their values are in currentLevelValues in the correct zigzag order.
 * Add currentLevelValues to the result list.
 * Toggle Direction: Invert the isLeftToRight flag (isLeftToRight = !isLeftToRight;) to prepare for the next level's alternating direction.
 */
public class BinaryTreeZigZag {
    public List<List<Integer>> zigzagLevelOrder(StackTreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        Queue<StackTreeNode> queue = new ArrayDeque<>();
        boolean isLeftToRight = true;

        if (root == null) {
            return output;
        }

        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> currentLevelVal = new LinkedList<>();
            int level = queue.size();

            for (int i = 0; i < level; i++) {
                StackTreeNode currentNode = queue.poll();
                if (isLeftToRight) {
                    currentLevelVal.add(currentNode.val);
                } else {
                    currentLevelVal.addFirst(currentNode.val);
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            output.add(currentLevelVal);
            isLeftToRight = !isLeftToRight;
        }
        return output;
    }
}
