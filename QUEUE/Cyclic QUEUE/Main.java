public class Main {
    public static void main(String[] args) {
        Circular_Queue cq = new Circular_Queue(5);
        try{
            cq.enqueue(1);
            cq.enqueue(2);
            cq.enqueue(3);
            cq.enqueue(4);
            cq.enqueue(5);
            cq.enqueue(6);
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        try{
            System.out.println(cq.dequeue());
            System.out.println(cq.dequeue());
            System.out.println(cq.dequeue());
            System.out.println(cq.dequeue());
            System.out.println(cq.dequeue());
            System.out.println(cq.dequeue());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        cq.enqueue(78);
        try{
            System.out.println(cq.peek());
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        System.out.println(cq.getSize());
    }
}

class Circular_Queue{
    int front, rear, size,capacity;
    int[] arr;

    Circular_Queue(int capacity){
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    boolean isEmpty(){
        return size == 0;
    }
    boolean isFull(){
        return size == capacity;
    }
    void enqueue(int value){
        if(isFull()){
            throw new RuntimeException("Queue is full");
        }
        else{
            rear = (rear + 1) % capacity;
            arr[rear] = value;
            size++;
        }
    }
    int dequeue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        else{
            int value = arr[front];
            front = (front + 1) % capacity;
            size--;
            return value;
        }
    }
    int peek(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        else{
            return arr[front];
        }
    }
    int getSize(){
        return size;
    }
}