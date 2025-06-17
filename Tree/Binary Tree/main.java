import java.util.LinkedList;
import java.util.Queue;

public class main {
    public static void main(String[] args) {
        BT tree = new BT();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        System.out.println(tree.isSymmetric());
    }
}

class BT{
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
}
