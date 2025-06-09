package leetCodeChallenges.stack;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeTraversal {
    public List<List<Integer>> levelOrder(StackTreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        Queue<StackTreeNode> queue = new ArrayDeque<>();

        if (root == null) {
            return output;
        }

        queue.add(root);

        while(!queue.isEmpty()){
            while()
        }
    }


}
