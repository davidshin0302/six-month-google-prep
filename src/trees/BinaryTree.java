package trees;

import stackQueueAlgorithm.MyLinkedListQueue;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E> {

    public TreeNode<E> root; // The root node of our binary tree

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

        //left -> root -> right
        private void inOrderTraversal(TreeNode<E> node) {
            if (node == null) {
                return;
            }
            // Recursive logic for in-order traversal
            inOrderTraversal(node.left);
            System.out.println(node.data);
            inOrderTraversal(node.right);
        }

        //root -> left -> right
        public void preOrderTraversal() {
            // Call a private helper method
            preOrderTraversal(root);
        }

        private void preOrderTraversal(TreeNode<E> node) {
            // Recursive logic for pre-order traversal
            if(node == null){
                return;
            }
            System.out.println(node.data);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }

        //left -> right -> root
        public void postOrderTraversal() {
            // Call a private helper method
            postOrderTraversal(root);
        }

        private void postOrderTraversal(TreeNode<E> node) {
            // Recursive logic for post-order traversal
            if(node == null){
                return;
            }
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.println(node.data);
        }

    public void levelOrderTraversal() {
        // Implement BFS using a Queue here

        // Steps:
        // 1. Check if the root is null. If so, return.
        // 2. Create a new LinkedList and assign it to a Queue variable.
        // 3. Add the root node to the queue.
        // 4. Loop while the queue is not empty:
        //    a. Dequeue (poll) a node.
        //    b. Print the data of the dequeued node.
        //    c. If the dequeued node has a left child, enqueue (offer) it.
        //    d. If the dequeued node has a right child, enqueue (offer) it.
        if(root == null){
            return;
        }

        Queue<TreeNode<E>> myQueue = new LinkedList<>();

    }
}