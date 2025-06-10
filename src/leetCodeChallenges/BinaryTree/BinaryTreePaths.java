package leetCodeChallenges.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/description/
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(StackTreeNode root) {
        //Input: root = [1,2,3,null,5]
        //Output: ["1->2->5","1->3"]
        List<String> output = new ArrayList<>();
        if(root.right == null && root.left == null){

        }

        binaryTreePaths(root.left);
        return output;
    }
}
