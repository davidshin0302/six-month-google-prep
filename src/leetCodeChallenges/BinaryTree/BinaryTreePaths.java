package leetCodeChallenges.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/description/
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(StackTreeNode root) {
        List<String> resultPaths = new ArrayList<>();

        if (root == null) {
            return resultPaths;
        }

        dfs(root, new StringBuilder(), resultPaths);

        return resultPaths;
    }

    public void dfs(StackTreeNode currentNode, StringBuilder currentPath, List<String> resultPaths) {
        if (currentNode == null) {
            return;
        }

        // Capture the path length *before* appending the current node's value.
        // This is the point to which we'll revert (backtrack) later.
        int currentPathLenBeforeAppend = currentPath.length();

        // Append current node's value, adding "->" if it's not the very first node.
        if (currentPath.length() > 0) { // If path is not empty, means it's not the root's first value
            currentPath.append("->");
        }
        currentPath.append(currentNode.val);

        // BASE CASE 1: If it's a leaf node, we've found a complete path.
        if (currentNode.left == null && currentNode.right == null) {
            resultPaths.add(currentPath.toString());
            // NO BACKTRACKING HERE YET! We're about to return from this call.
            // The backtracking for this level will happen *after* this return,
            // when the calling function (its parent) cleans up.
            return;
        }

        // RECURSIVE STEP: If not a leaf, continue exploring children.
        // Make recursive calls for left and right children.
        dfs(currentNode.left, currentPath, resultPaths);
        dfs(currentNode.right, currentPath, resultPaths);

        // BACKTRACKING:
        // After both left and right recursive calls have completed (or returned),
        // we need to remove the part of the path added by the current node
        // (i.e., its value and the preceding "->").
        // This restores `currentPath` to the state it was in *before* this node was processed,
        // allowing its parent to explore other branches or finish its own processing.
        currentPath.setLength(currentPathLenBeforeAppend);
    }

}
