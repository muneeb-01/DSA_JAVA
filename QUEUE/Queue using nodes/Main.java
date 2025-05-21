public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        reverseQueue(queue);
        queue.printQueue();
        try{
            System.out.println(queue.peek());
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
        PriorityQueue pQueue = new PriorityQueue();
        pQueue.enqueue(12,1);
        pQueue.enqueue(5,2);
        pQueue.enqueue(1,-1);
        pQueue.printQueue();
    }

    static void reverseQueue(Queue q) {
        if (q.front == null) return;

        int frontData = q.dequeue();
        reverseQueue(q); // Recursive call
        q.enqueue(frontData); // Put dequeued item back at rear
    }
}

class Queue {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    Node front, rear;

    Queue() {
        front = rear = null;
    }

    void enqueue(int data) {
        Node newNode = new Node(data);
        if (front == null) {
            front = rear = newNode;
        }
        else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    int dequeue() {
        if (front == null) {
            throw new RuntimeException("Queue is empty");
        }
        int value = front.data;
        front = front.next;
        return value;
    }

    int peek(){
        if (front == null) {
            throw new RuntimeException("Queue is empty");
        }
        return front.data;
    }
    void printQueue() {
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
class PriorityQueue {
    static class Node {
        int data;
        int priority;
        Node next;

        Node(int data, int priority) {
            this.data = data;
            this.priority = priority;
            next = null;
        }
    }

    Node head;

    void enqueue(int data, int priority) {
        Node newNode = new Node(data, priority);

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
        if (head == null) {
            throw new RuntimeException("Priority Queue is empty");
        }
        int value = head.data;
        head = head.next;
        return value;
    }

    boolean isEmpty() {
        return head == null;
    }
    int peek(){
        if (head == null) {
            throw new RuntimeException("Queue is empty");
        }
        return head.data;
    }
    void printQueue() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

}
