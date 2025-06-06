package leetCodeChallenges.stack;

import trees.TreeNode;

import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return null;
        }

        if(root.left != null){
            levelOrder(root.left);
        }else if(root.right != null){
            levelOrder(root.right);
        }else{
            return null;
        }
    }
}
