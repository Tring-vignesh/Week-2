//this class implement stack data structure
class Stack {
    //size of the stack
    private int size;
    //stack array
    private int[] stack;
    //top pointer 
    private int top; 
    public Stack(int size) {
        this.size = size;
        this.stack = new int[size];
        this.top = -1; 
    }
    //push the element
    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack is full.");
            return;
        }
        stack[++top] = data; 
        System.out.println(data + " pushed into the stack.");
    }
    //pop the element 
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        int poppedData = stack[top--]; 
        return poppedData;
    }

    //get top element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return stack[top];
    }

    //Empty or not
    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }
    //display all element in stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }
}

public class StackImplement {
    public static void main(String[] args) {
        Stack stack = new Stack(5); 
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display(); 
        System.out.println("Top element : " + stack.peek()); 
        System.out.println("Popped element: " + stack.pop()); 
        stack.display();
        stack.pop();
        stack.pop(); 
        stack.pop(); 
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        stack.push(80);
        //to test overflow
        stack.push(90); 
    }
}