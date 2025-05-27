package trees;

public class BinaryTree<E> {

    TreeNode<E> root; // The root node of our binary tree

    // Constructor
    public BinaryTree() {
        // Initialize the root for an empty tree
        this.root = null;
    }

    // --- Tree Traversal Methods ---
    // These methods will typically be public wrappers that call a private recursive helper.

    public void inOrderTraversal() {
        // Call a private helper method starting from the root
        // Example: inOrderTraversal(root);
        inOrderTraversal(root);
    }

    private void inOrderTraversal(TreeNode<E> node) {
        // Recursive logic for in-order traversal
    }

    public void preOrderTraversal() {
        // Call a private helper method
    }

    private void preOrderTraversal(TreeNode<E> node) {
        // Recursive logic for pre-order traversal
    }

    public void postOrderTraversal() {
        // Call a private helper method
    }

    private void postOrderTraversal(TreeNode<E> node) {
        // Recursive logic for post-order traversal
    }

    // You might also want a method to "build" a simple tree for testing,
    // but let's focus on structure and traversals first.
}