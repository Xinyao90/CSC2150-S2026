package lec20Prep;

public class BSTPractice {

    static class BSTNode {
        int key;
        BSTNode left;
        BSTNode right;

        BSTNode(int k) {
            key = k;
            left = null;
            right = null;
        }
    }
    // Recursive search
    static BSTNode search(BSTNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.key == key) {
            return root;
        }
        if (root.key < key) {
            return search(root.right, key);
        } else {
            return search(root.left, key);
        }
    }

    //Insert into BST, key is not in original tree
    static BSTNode insert(BSTNode root, int key) {
        if (root == null) {
            return new BSTNode(key);
        }
        if (root.key < key) {
            root.right = insert(root.right, key);
        } else {
            root.left = insert(root.left, key);
        }
        return root;
    }

    //Find minimum value
    static int findMin(BSTNode root) {
        if (root == null) {
            throw new IllegalArgumentException("Tree is empty");
        }
        while(root.left != null) {
            root = root.left;
        }
        return root.key;
    }

    //Delete
    static BSTNode delete(BSTNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else { // key == root.key, also means this is the node we want to delete.
            // Case 1. This deletion node doesn't have any child.
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2. Deletion node has only one child
            if (root.left == null ^ root.right == null){
                // ^ XOR, exactly one of the operands is true.
                if (root.left == null) {
                    return root.right;
                } else {
                    return root.left;
                }
            }
            // Case 3. Deletion node has two children
            // Replace deletion node with right subtree's minimum value node
            int min = findMin(root.right);
            root.key = min;
            root.right = delete(root.right, min);
        }
        return root;
    }
    
    public static void main(String[] args){

        BSTNode root = null;

        int[] values = {8,3,1,6,4,7,10,14,13};

        for(int v : values)
            root = insert(root, v);

        System.out.println("Original tree:");
        inorder(root);

        // test search
        System.out.println("\n\nSearch tests:");

        BSTNode result = search(root,13);
        System.out.println("search(13): " + (result != null));

        result = search(root,6);
        System.out.println("search(6): " + (result != null));

        result = search(root,5);
        System.out.println("search(5): " + (result != null));

        // test findMin
        System.out.println("\nMinimum value: " + findMin(root));


        // test delete
        root = delete(root,8);
        System.out.println("\nAfter deleting 8:");
        root = delete(root,10);
        System.out.println("\nAfter deleting 10:");


        inorder(root);
    }
}