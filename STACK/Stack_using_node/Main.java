class Main{
    public static void main(String[] args){
    Stack stack = new Stack();
    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.push(40);
    stack.push(50);
    stack.push(60);
    System.out.println(stack.pop());
    System.out.println(stack.peek());
    }
}

class Stack{
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            next = null;
        }
    }
    Node top;

    Stack(){
        top = null;
    }

    void push(int data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    int pop(){
        if(top == null){
            throw new RuntimeException("Stack is Empty.");
        }
        int data = top.data;
        top = top.next;
        return data;
    }

    int peek(){
        if(top == null){
            throw new RuntimeException("Stack is Empty.");
        }
        return top.data;
    }
}