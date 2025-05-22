public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(2);
        tree.insert(1);
        tree.insert(5);
        tree.insert(3);
        tree.insert(6);

        tree.delete(1);




    }
}

// Node class for each element in the tree


// Binary Tree class
class BinaryTree {
    private class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }
    Node root;

    void insert(int value) {
        root = insertRec(root, value);
    }

    // Recursive BST insert logic
    Node insertRec(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.data)
            root.left = insertRec(root.left, value);
        else if (value > root.data)
            root.right = insertRec(root.right, value);
        return root;
    }

    // Inorder traversal: Left → Root → Right
    void inorder() {
        inorderRec(root);
        System.out.println();
    }

    void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node.data + " ");
            inorderRec(node.right);
        }
    }

    // Preorder traversal: Root → Left → Right
    void preorder() {
        preorderRec(root);
        System.out.println();
    }

    void preorderRec(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderRec(node.left);
            preorderRec(node.right);
        }
    }

    // Postorder traversal: Left → Right → Root
    void postorder() {
        postorderRec(root);
        System.out.println();
    }

    void postorderRec(Node node) {
        if (node != null) {
            postorderRec(node.left);
            postorderRec(node.right);
            System.out.print(node.data + " ");
        }
    }
    void delete(int value) {
        root = deleteRec(root, value);
    }

    Node deleteRec(Node root, int value) {
        if (root == null) return null;

        if (value < root.data) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.data) {
            root.right = deleteRec(root.right, value);
        } else {
            // Node to be deleted found

            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Case 3: Two children
            Node successor = findMin(root.right);
            root.data = successor.data;
            root.right = deleteRec(root.right, successor.data);
        }

        return root;
    }

    Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

}
