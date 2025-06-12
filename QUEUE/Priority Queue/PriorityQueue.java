public class PriorityQueue {
    public static void main(String[] args) {
        PQueue pQueue = new PQueue();
        pQueue.enqueue(12, 1);
        pQueue.enqueue(5, 2);
        pQueue.enqueue(1, -1);

        System.out.print("Priority Queue (high priority first): ");
        pQueue.printQueue();
    }

    }


// Recursively reverse the normal queue
class PQueue {
    static class Node {
        int data, priority;
        Node next;

        Node(int data, int priority) {
            this.data = data;
            this.priority = priority;
        }
    }

    Node head;

    void enqueue(int data, int priority) {
        Node newNode = new Node(data, priority);

        // Insert at the correct position based on priority
        if (head == null || priority > head.priority) {
            newNode.next = head;
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null && temp.next.priority >= priority) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    int dequeue() {
        if (isEmpty()) throw new RuntimeException("Priority Queue is empty");
        int value = head.data;
        head = head.next;
        return value;
    }

    int peek() {
        if (isEmpty()) throw new RuntimeException("Priority Queue is empty");
        return head.data;
    }

    boolean isEmpty() {
        return head == null;
    }

    void printQueue() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "(" + current.priority + ") -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
