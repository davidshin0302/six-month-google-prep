package trees;

public class BinarySearchTree<E extends Comparable<E>> {
    TreeNode<E> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(E element) {
        this.root = insert(root, element);
        System.out.println(root.data);
    }

    private TreeNode<E> insert(TreeNode<E> current, E element) {
        if (current == null) {
            current = new TreeNode<>(element);
            return current;
        }

        if (element.compareTo(current.data) < 0) {
            current.left = insert(current.left, element);
        } else if (element.compareTo(current.data) > 0 || element.compareTo(current.data) == 0) {
            current.right = insert(current.right, element);
        }
        return current;
    }

    public void search(E element) {
        boolean result = search(root, element);

        if (!result) {
            System.out.println("The element doesn't not exit");
        } else {
            System.out.println("Found the element from the storage: " + element);
        }
    }

    private boolean search(TreeNode<E> current, E element) {
        if (current == null) {
            return false;
        } else if (element.compareTo(current.data) == 0) {
            return true;
        }

        if (element.compareTo(current.data) < 0) {
            return search(current.left, element);
        } else if (element.compareTo(current.data) > 0) {
            return search(current.right, element);
        } else {
            return search(current.right, element);
        }
    }

    public void delete(E element) {
        this.root = delete(root, element);
    }

    private TreeNode<E> delete(TreeNode<E> current, E element) {
        if (current == null) {
            return null;
        }

        int cmp = element.compareTo(current.data);

        if (cmp < 0) {
            current.left = delete(current.left, element);
        } else if (cmp > 0) {
            current.right = delete(current.right, element);
        } else {
            if (current.left == null && current.right == null) {
                return null;
            } else if (current.left != null && current.right == null) {
                return current.left;
            } else if (current.right != null && current.left == null) {
                return current.right;
            } else {
                TreeNode<E> successor = findMin(current.right);
                current.data = successor.data;
            }
        }
        return current;
    }

    private TreeNode<E> findMin(TreeNode<E> node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
