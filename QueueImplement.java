//This class Represent node in Queue
class Node {
    int data; 
    Node next; 
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
//This class implement queue
class Queue {
    //front of the queue
    private Node front;
    //end of the queue 
    private Node rear; 
    
    public Queue() {
        front = null;
        rear = null;
    }
    //perform enqueue operation
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode; 
            rear = newNode;
        }
        System.out.println(data + " enqueued.");
    }

    //perform dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Queue is empty.");
            return -1;
        }
        int dequeuedData = front.data; 
        front = front.next; 
        if (front == null) {
            rear = null;
        }
        return dequeuedData;
    }

    //get peek element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return front.data;
    }

   
    public boolean isEmpty() {
        return front == null;
    }
    //display each element in queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue elements: ");
            Node current = front;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }
}

public class QueueImplement {
    public static void main(String[] args) {
        //creating queue object 
        Queue queue = new Queue();
        //enqueue three elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        //display the elements
        queue.display(); 
        //display front element
        System.out.println("Front element is: " + queue.peek());
        //perform dequeue
        System.out.println("Dequeued element is : " + queue.dequeue()); 
        //display elements
        queue.display(); 
        //perform enqueue
        queue.enqueue(40);
        queue.enqueue(50);
        queue.display(); 
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }
}