package leetCodeChallenges.stack;


//Definition for a binary tree node.
public class StackTreeNode {
    int val;
    StackTreeNode left;
    StackTreeNode right;

    StackTreeNode() {
    }

    public StackTreeNode(int val) {
        this.val = val;
    }

    public StackTreeNode(int val, StackTreeNode left, StackTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
