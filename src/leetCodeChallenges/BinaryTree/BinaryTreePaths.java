package leetCodeChallenges.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/description/
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(StackTreeNode root) {
        List<String> resultPaths = new ArrayList<>();
        if (root == null) { // Good practice to handle initial null root
            return resultPaths;
        }
        btp(root, new StringBuilder(), resultPaths);
        return resultPaths;
    }

    public void btp(StackTreeNode currentNode, StringBuilder currentPaths, List<String> resultPaths){
        // Base Case 1: If the node is null, simply return.
        if(currentNode == null){
            return;
        }

        // Bookmark the current length of the StringBuilder *before* adding anything for this node.
        // This 'originalLength' is where we will revert to during backtracking for THIS call.
        int originalLength = currentPaths.length(); // Renamed for clarity

        // Always append the current node's value.
        currentPaths.append(currentNode.val);

        // Check for Base Case 2: If the current node is a leaf (no children).
        if(currentNode.left == null && currentNode.right == null){
            // If it's a leaf, this is a complete root-to-leaf path.
            resultPaths.add(currentPaths.toString());
            // IMPORTANT: DO NOT 'return;' here.
            // We want the function to continue to the backtracking step below.
        } else {
            // If it's NOT a leaf, it means we will continue exploring deeper.
            // So, append "->" to separate this node's value from its children's.
            currentPaths.append("->");

            // Make recursive calls for children.
            btp(currentNode.left, currentPaths, resultPaths);
            btp(currentNode.right, currentPaths, resultPaths);
        }

        // BACKTRACKING:
        // This line is guaranteed to execute for EVERY 'btp' call before it returns.
        // It restores 'currentPaths' to the exact state it was in when this 'btp' call began,
        // effectively "undoing" the appending of 'currentNode.val' (and the "->" if added).
        currentPaths.setLength(originalLength);
    }
}
