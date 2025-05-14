public class Main {
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);

        try{
            System.out.println(  "Dequeued Value of the queue : " +q.dequeue());
            System.out.println(  "Dequeued Value of the queue : " +q.dequeue());
            System.out.println(  "Dequeued Value of the queue : " +q.dequeue());
        }
        catch(RuntimeException e){
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Peeked Value of the queue : "+q.peek());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}

class Queue{
    int front = -1;
    int rear = -1;
    int[] queue;
    int size;

    Queue(int size){
        queue = new int[size];
        this.size = size;
    }

    void enqueue(int data){
        if(isFull()){
            System.out.println("Queue is full");
            front = rear = -1;
        }else{
            if(isEmpty()){
                front = 0;
            }
            rear++;
            queue[rear] = data;
        }
    }

    int peek(){
        if(isEmpty()){
            front = rear = -1;
            throw new RuntimeException("Queue is empty");
        }
        return queue[front];
    }

     int dequeue(){
        if(isEmpty()){
            front = rear = -1;
            throw new RuntimeException("Queue is empty");
        }
            int data = queue[front];
            front++;
            return data;

    }

    boolean isEmpty(){
        return front == -1 || front > rear;
    }

    boolean isFull(){
        return rear == size-1;
    }

}