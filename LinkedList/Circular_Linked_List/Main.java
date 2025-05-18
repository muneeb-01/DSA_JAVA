public class Main {
    public static void main(String[] args){
        Doubly_Linked_List list = new Doubly_Linked_List();
        list.insert_at_start(10);
        list.insert_at_start(11);
        list.insert_at_start(12);
        list.insert_at_start(13);
        list.insert_at_end(20);
        list.insert_after(10, 15);
        list.delete_from_end();
        list.delete_from_start();
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
            // Circular links
            head.next = head.prev = head;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        }
    }

    void insert_at_end(int data) {
        Node newNode = new Node(data);
        if(tail == null){
            head = tail = newNode;
            // Circular links
            head.next = head.prev = head;
        } else {
            newNode.prev = tail;
            newNode.next = head;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }
    }

    void insert_after(int val, int data){
        if(head == null){
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        // Loop must stop if it comes back to head
        do {
            if(current.data == val){
                Node newNode = new Node(data);
                newNode.next = current.next;
                newNode.prev = current;
                current.next.prev = newNode;
                current.next = newNode;

                // Update tail if inserted at the end
                if(current == tail){
                    tail = newNode;
                }
                return;
            }
            current = current.next;
        } while(current != head);

        System.out.println(val + " is not in the list");
    }

    void delete_from_start(){
        if(head == null){
            return;
        }

        if(head == tail){
            head = tail = null;
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
    }

    void delete_from_end(){
        if(tail == null){
            return;
        }

        if(head == tail){
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
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
            do {
                System.out.print(current.data + " ");
                current = current.next;
            } while(current != head); // Loop until we circle back
            System.out.println();
        } else if(order == -1){
            System.out.println("Reverse Traversal:");
            Node current = tail;
            do {
                System.out.print(current.data + " ");
                current = current.prev;
            } while(current != tail); // Loop until we circle back
            System.out.println();
        } else {
            System.out.println("Invalid traversal order. Use 1 (forward) or -1 (reverse).");
        }
    }
}
