public class Main {
    public static void main(String[] args){
        Doubly_Linked_List list = new Doubly_Linked_List();
        list.insert_at_start(10);
        list.insert_at_start(11);
        list.insert_at_start(12);
        list.insert_at_start(13);
        list.insert_at_end(15);
        list.insert_after(10, 15);
        list.insert_at_position(100,0);
        list.insert_at_position(100,3);
        list.sort();

        System.out.println("11 found at index "+ list.find(15));
        System.out.println("Occurance of 15 in the list is : "+ list.countOccurrences(15));

        list.traverse(1);   // Forward traversal
        list.traverse(-1);  // Reverse traversal
    }
}

class Doubly_Linked_List {
    private Node head = null;
    private Node tail = null;

    class Node {
        Node prev;
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    void insert_at_start(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    void insert_at_end(int data) {
        Node newNode = new Node(data);
        if(tail == null){
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void insert_after(int val, int data){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while(current != null){
            if(current.data == val){
                Node newNode = new Node(data);
                newNode.next = current.next;
                newNode.prev = current;
                if(current.next != null){
                    current.next.prev = newNode;
                } else {
                    // We're inserting at the end
                    tail = newNode;
                }
                current.next = newNode;
                return;
            }
            current = current.next;
        }
        System.out.println(val + " is not in the list");
    }

    void delete_from_start(){
        if(head == null){
            return;
        }
        head = head.next;
        if(head != null){
            head.prev = null;
        } else {
            tail = null;
        }
    }

    void delete_from_end(){
        if(tail == null){
            return;
        }
        tail = tail.prev;
        if(tail != null){
            tail.next = null;
        } else {
            head = null;
        }
    }

    void traverse(int order){
        if(head == null){
            System.out.println("Empty List");
            return;
        }

        if(order == 1){
            System.out.println("Forward Traversal:");
            Node current = head;
            while(current != null){
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        } else if (order == -1){
            System.out.println("Reverse Traversal:");
            Node current = tail;
            while(current != null){
                System.out.print(current.data + " ");
                current = current.prev;
            }
            System.out.println();
        } else {
            System.out.println("Invalid traversal order. Use 1 (forward) or -1 (reverse).");
        }
    }
    void insert_at_position(int data, int position) {
        if (position < 0) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 0) {
            insert_at_start(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        int index = 0;

        while (current != null && index < position - 1) {
            current = current.next;
            index++;
        }

        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }

        newNode.next = current.next;
        newNode.prev = current;

        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode;  // If inserted at the end
        }
        current.next = newNode;
    }

    int find(int value) {
        Node current = head;
        int position = 0;
        while (current != null) {
            if (current.data == value) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1; // Not found
    }

    int countOccurrences(int value) {
        Node current = head;
        int count = 0;
        while (current != null) {
            if (current.data == value) {
                count++;
            }
            current = current.next;
        }
        return count;
    }
    void sort() {
        if (head == null) return;

        boolean swapped;
        do {
            swapped = false;
            Node current = head;

            while (current.next != null) {
                if (current.data > current.next.data) {
                    // Swap nodes by rearranging pointers (not just data)
                    Node nextNode = current.next;
                    Node prevNode = current.prev;
                    Node nextNext = nextNode.next;

                    // Re-link previous node to nextNode
                    if (prevNode != null) {
                        prevNode.next = nextNode;
                    } else {
                        head = nextNode;
                    }
                    nextNode.prev = prevNode;

                    // Link nextNode and current node
                    nextNode.next = current;
                    current.prev = nextNode;

                    // Link current node to nextNext node
                    current.next = nextNext;
                    if (nextNext != null) {
                        nextNext.prev = current;
                    } else {
                        tail = current;
                    }

                    swapped = true;
                } else {
                    current = current.next;
                }
            }
        } while (swapped);
    }

}
