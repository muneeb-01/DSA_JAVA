class BinaryTree {
    public class Node {  // <-- make public here
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }
    Node root;

    private Node head = null;
    private Node prev = null;

    public Node bstToDoublyLinkedList() {
        head = null;
        prev = null;
        convertBSTtoDLL(root);
        return head;
    }

    private void convertBSTtoDLL(Node curr) {
        if (curr == null) return;

        convertBSTtoDLL(curr.left);

        if (prev == null) {
            head = curr;
        } else {
            prev.right = curr;
            curr.left = prev;
        }
        prev = curr;

        convertBSTtoDLL(curr.right);
    }

    public void printDoublyLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.right != null) System.out.print(" <-> ");
            curr = curr.right;
        }
        System.out.println();
    }

    public void insert(int val) {
        root = insertRec(root, val);
    }

    private Node insertRec(Node node, int val) {
        if (node == null) return new Node(val);
        if (val < node.data) node.left = insertRec(node.left, val);
        else if (val > node.data) node.right = insertRec(node.right, val);
        return node;
    }
}

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] values = {10, 5, 15, 2, 8, 12, 20};
        for (int v : values) {
            tree.insert(v);
        }

        BinaryTree.Node head = tree.bstToDoublyLinkedList();
        tree.printDoublyLinkedList(head);
    }
}
