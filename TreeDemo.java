/**
 * @author Yarixa Perez
 * @since 4-7-24
 */

class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

class BinarySearchTree {
    Node root;

    /**
     * Inserts a new node with the specified value into the tree.
     * @param root Represents the root node of the tree.
     * @param value Represents the value to be inserted into the tree.
     * @return The root node of the tree after insertion.
     */
    public Node insert(Node root, int value) {
        // base case
        if (root == null) {
            root = new Node(value);
            return root;
        }

        // recursive step
        if (value < root.value) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        return root;
    }

    /**
     * Performs pre-order traversal of the tree.
     * @param root Represents the root node of the tree.
     */
    public void preOrderTraversal(Node root) {
        if (root != null) {
            // print current node (root)
            System.out.print(root.value + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    /**
     * Performs in-order traversal of the tree.
     * @param root Represents the root node of the tree.
     */
    public void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);

            // print current node (root)
            System.out.print(root.value + " ");
            inOrderTraversal(root.right);
        }
    }

    /**
     * Performs post-order traversal of the tree.
     * @param root Represents the root node of the tree.
     */
    public void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);

            // print current code (root)
            System.out.print(root.value + " ");
        }
    }

    /**
     * Finds the node in the tree with a specific value.
     * @param root
     * @param key
     * @return
     */
    public boolean find(Node root, int key) {
        // implement me
        return false;
    }

    /**
     * Finds the node in the tree with the smallest key.
     * @param root
     * @return
     */
    public int getMin(Node root) {
        // implement me
        return -1;
    }

    /**
     * Finds the node in the tree with the largest key.
     * @param root
     * @return
     */
    public int getMax(Node root) {
        // implement me
        return -1;
    }

    /**
     * Deletes the node with the specified key from the tree.
     * @param root Represents the root node of the tree.
     * @param key Represents the value of the node to be deleted.
     * @return The root node of the tree after deletion.
     */
    public Node delete(Node root, int key) {

        if (root == null) {
            return root;
        } else if (key < root.value) {
            root.left = delete(root.left, key);
        } else if (key > root.value) {
            root.right = delete(root.right, key);
        } else {
            // node has been found
            if (root.left == null && root.right == null) {
                // case #1: leaf node
                root = null;
            } else if (root.right == null) {
                // case #2: only left child
                root = root.left;
            } else if (root.left == null) {
                // case #2: only right child
                root = root.right;
            } else {
                // case #3: 2 children
                root.value = getMax(root.left);
                root.left = delete(root.left, root.value);
            }
        }

        return root;
    }
}

public class TreeDemo {
    public static void main(String[] args) {
        BinarySearchTree t1 = new BinarySearchTree();

        t1.root = t1.insert(t1.root, 24);
        t1.root = t1.insert(t1.root, 80);
        t1.root = t1.insert(t1.root, 18);
        t1.root = t1.insert(t1.root, 9);
        t1.root = t1.insert(t1.root, 90);
        t1.root = t1.insert(t1.root, 22);


        System.out.print("in-order :   ");
        t1.inOrderTraversal(t1.root);
        System.out.println();

        System.out.print("pre-order :   ");
        t1.preOrderTraversal(t1.root);
        System.out.println();

        System.out.print("post-order :   ");
        t1.postOrderTraversal(t1.root);
        System.out.println();
    }
}