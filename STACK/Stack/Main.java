import java.util.EmptyStackException;

class Main{
    public static void main(String[] args){
        Stack stack = new Stack(5);

        stack.push(20);
        stack.push(21);
        stack.push(25);

        try{
            System.out.println("Popped value of the stack is : "+stack.pop());
        }catch (Exception e){
            System.out.println("Stack is "+ e.getMessage());
        }

        try{
            System.out.println("Peeked value of the stack is : "+stack.peek());
        }catch (Exception e){
            System.out.println("Stack is "+ e.getMessage());
        }

        Hanoi_Problem();
        reverseString();

    }

    static void Hanoi_Problem(){
        Stack stack1 = new Stack(5);
        Stack stack2 = new Stack(5);
        Stack stack3 = new Stack(5);

        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        stack2.push(stack1.pop());
        stack2.push(stack1.pop());
        stack2.push(stack1.pop());

        stack3.push(stack2.pop());
        stack3.push(stack2.pop());
        stack3.push(stack2.pop());

        System.out.println("Hanoi Problem solved.");

    }

    static void reverseString(){
        Stack stack = new Stack(5);
        Stack stack2 = new Stack(5);

        String str = "Hello";

        for (int i = 0; i < str.length(); i++)
        {
            stack.push(str.charAt(i));
        }

        for (int i = 0; i < str.length(); i++){
            stack2.push(stack.pop());
        }

        System.out.println("String reversed.");

    }

}

class  Stack{
    private int length = -1;
    private final int max_length;
    private final int[] arr;

    Stack(int max_length){
        this.max_length = max_length;
        arr = new int[max_length];
    }
    void push(int val){
        if(isFull()){
            System.out.println("Stack is Full.");
            return;
        }
        length++;
        arr[length] = val;
    }

    int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int val = arr[length];
        length--;
        return  val;
    }

    Object peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return arr[length];
    }
    Boolean isEmpty(){
        return length == -1;
    }
    Boolean isFull(){
        return length == (max_length-1);
    }
}