package leetCodeChallenges.BinaryTree;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthBinaryTree {
    public int maximumDepthBinaryTree(StackTreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] container = {1, 1};

        maxDepth(root, container);

        return Math.max(container[0], container[1]);
    }

    public void maxDepth(StackTreeNode currentNode, int[] container) {
        if (currentNode == null) {
            return;
        }

        if (currentNode.left != null) {
            container[0]++;
            maxDepth(currentNode.left, container);
        }
        if (currentNode.right != null) {
            container[1]++;
            maxDepth(currentNode.right, container);
        }
        if (currentNode.left == null && currentNode.right == null) {
            return;
        }
    }

}
