import java.util.LinkedList;
import java.util.Queue;

public class main {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(10);
        bst.insert(9);
        bst.insert(8);
        bst.insert(7);
        bst.insert(6);
        bst.insert(5);
        bst.insert(4);
        bst.insert(12);
        bst.insert(18);
        bst.insert(23);
        bst.insert(21);
        bst.insert(51);
        bst.insert(15);

        System.out.println(bst.isBinarySearchTree());
    }
}
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

class BT{
    Node root;
    void insert(int data){
        if(root == null){
            root = new Node(data);
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp.left == null){
                temp.left = new Node(data);
                break;
            }else {
                q.add(temp.left);
            }
            if(temp.right == null){
                temp.right = new Node(data);
                break;
            }else{
                q.add(temp.right);
            }
        }
    }
    boolean isBalance(){
        return height(root) != -1;
    }
    void inOrder(Node root){
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    private int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        if(leftHeight == -1){
            return -1;
        }
        int rightHeight = height(root.right);
        if(rightHeight == -1){
            return -1;
        }
        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
    boolean isSymmetric(){
        return root == null || ismirror(root.left, root.right);
    }
    private boolean ismirror(Node left , Node right){
        if(left == null && right == null){
            return  true;
        }
        if(left == null || right == null){
            return false;
        }
        return (left.data == right.data) && ismirror(left.left, right.right) && ismirror(right.left, left.right);
    }
    boolean isBinarySearchTree(){
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    boolean isBST(Node root, Integer min, Integer max){
        if(root == null) return true;
        if(root.data > min && root.data < max){
            return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
        }
        return false;
    }
}

class BST extends BT{
    @Override
    void insert(int data){
        root = insertRec(root, data);
    }

    Node insertRec(Node root, int data) {
        if(root == null){
            return new Node(data);
        }
        if(data < root.data){
            root.left = insertRec(root.left, data);
        }
        else if(data > root.data){
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    Integer get_max(){
        if(root == null){
            System.out.println("Tree is empty");
            return null;
        }
        Node temp = root;
        while(temp.right != null){
            temp = temp.right;
        }
        return temp.data;
    }
    Integer get_min(){
        if(root == null){
            System.out.println("Tree is empty");
            return null;
        }
        Node temp = root;
        while(temp.left != null){
            temp = temp.left;
        }
        return temp.data;
    }

}