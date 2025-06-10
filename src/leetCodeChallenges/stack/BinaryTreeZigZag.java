package leetCodeChallenges.stack;

import java.util.*;

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
