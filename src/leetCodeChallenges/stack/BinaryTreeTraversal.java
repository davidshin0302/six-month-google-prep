package leetCodeChallenges.stack;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * At the beginning of each iteration of your main loop (which processes one level):
 *
 * Get the size() of the queue. This size represents the number of nodes on the current level.
 * Then, use a second, inner loop that runs size times.
 *
 * Inside this inner loop:
 * poll() (dequeue) a node from the queue.
 * Add its value to a temporary list that will hold all values for the current level.
 * Crucially: If the dequeued node has a left child, add it to the queue. If it has a right child, add it to the queue. These children will be processed in the next level.
 * Once the inner loop finishes, you've processed all nodes for the current level. You can then add the temporary list of values for that level to your overall result list.
 */
public class BinaryTreeTraversal {
    public List<List<Integer>> levelOrder(StackTreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        Queue<StackTreeNode> queue = new ArrayDeque<>();

        if (root == null) {
            return output;
        }

        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> currentLevelValues = new ArrayList<>();
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                StackTreeNode currentNode = queue.poll();
                currentLevelValues.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            if (!currentLevelValues.isEmpty()) {
                output.add(currentLevelValues);
            }
        }
        return output;
    }
}
