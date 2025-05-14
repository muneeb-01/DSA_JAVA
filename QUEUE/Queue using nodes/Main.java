public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        try{
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }

        queue.enqueue(5);

        try{
            System.out.println(queue.peek());
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
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
}
