import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class Main {
    public static void main(String[] args) {
        ArrayTree tree = new ArrayTree(3);
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(12);
    }
}

class ArrayTree {
    int[] tree;
    int size;

    ArrayTree(int level_of_Tree) {
        size = (int) (Math.pow(2, level_of_Tree + 1) - 1);
        tree = new int[size];
        for (int i = 0; i < size; i++) {
            tree[i] = -1;
        }
        System.out.println("Tree with max " + size + " nodes initialized.");
    }

    public void insert(int value) {
        insertAt(0, value); // start from root
    }

    private void insertAt(int index, int value) {
        if (index >= size) {
            System.out.println("Cannot insert " + value + ". Out of bounds.");
            return;
        }

        if (tree[index] == -1) {
            tree[index] = value;
            return;
        }

        if (value < tree[index]) {
            insertAt(2 * index + 1, value); // go left
        } else if (value > tree[index]) {
            insertAt(2 * index + 2, value); // go right
        } else {
            System.out.println("Value " + value + " already exists in tree.");
        }
    }

    public Integer getLeftChild(int index) {
        int left = 2 * index + 1;
        return (left < size) ? tree[left] : null;
    }

    public Integer getRightChild(int index) {
        int right = 2 * index + 2;
        return (right < size) ? tree[right] : null;
    }

    void preorder_traverse() {
        if (tree[0] == -1) {
            System.out.println("Tree is empty.");
            return;
        }
        preOrder(0);
    }

    void preOrder(int index) {
        if (index >= size || tree[index] == -1) {
            return;
        }

        System.out.println(tree[index]);

        preOrder(2 * index + 1);
        preOrder(2 * index + 2);
    }
    void postorder_traverse() {
        if (tree[0] == -1) {
            System.out.println("Tree is empty.");
        }
            postOrder(0);
    }

    void postOrder(int index) {
        if (index >= size || tree[index] == -1) {
            return;
        }
        postOrder(2 * index + 1);
        postOrder(2 * index + 2);
        System.out.println(tree[index]);
    }
    void inorder_traverse() {
        if (tree[0] == -1) {
            System.out.println("Tree is empty.");
            return;
        }
        inorder(0);
    }

    void inorder(int index) {
        if (index >= size || tree[index] == -1) {
            return;
        }
        inorder(2 * index + 1);
        System.out.println(tree[index]);
        inorder(2 * index + 2);
    }
    void bfs_traverse() {
        if (tree[0] == -1) {
            System.out.println("Tree is empty.");
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0); // start from root index

        while (!queue.isEmpty()) {
            int currentIndex = queue.poll();
            if (currentIndex >= size || tree[currentIndex] == -1) continue;

            System.out.println(tree[currentIndex]);

            int left = 2 * currentIndex + 1;
            int right = 2 * currentIndex + 2;

            if (left < size && tree[left] != -1) {
                queue.add(left);
            }
            if (right < size && tree[right] != -1) {
                queue.add(right);
            }
        }
    }

    void dfs_traverse() {
        if (tree[0] == -1) {
            System.out.println("Tree is empty.");
            return;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0); // Start at root index

        while (!stack.isEmpty()) {
            int currentIndex = stack.pop();

            if (currentIndex >= size || tree[currentIndex] == -1)
                continue;

            System.out.println(tree[currentIndex]);

            // Push right first so left is processed first
            int right = 2 * currentIndex + 2;
            int left = 2 * currentIndex + 1;

            if (right < size && tree[right] != -1) {
                stack.push(right);
            }
            if (left < size && tree[left] != -1) {
                stack.push(left);
            }
        }
    }

    void print() {
        System.out.println("\nTree (array):");
        for (int i = 0; i < size; i++) {
            System.out.print(tree[i] + " ");
        }
    }
}
