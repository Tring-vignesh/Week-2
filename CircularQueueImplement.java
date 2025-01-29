// This class represents a node in the circular queue
class Node {
    int data; 
    Node next; 
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// This class implements a circular queue
class CircularQueue {
    private Node front;
    private Node rear; 

    public CircularQueue() {
        front = null;
        rear = null;
    }

    // Perform enqueue operation
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (front == null) {
            front = rear = newNode;
            rear.next = front; // Link back to front for circular structure
        } else {
            rear.next = newNode;
            rear = newNode;
            rear.next = front; // Maintain circular connection
        }
        System.out.println(data + " enqueued.");
    }

    // Perform dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Queue is empty.");
            return -1;
        }
        int dequeuedData = front.data;
        if (front == rear) { // Only one element
            front = rear = null;
        } else {
            front = front.next;
            rear.next = front; // Maintain circular connection
        }
        return dequeuedData;
    }

    // Get peek element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return front.data;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Display each element in the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        Node current = front;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != front); // Stop when we reach front again
        System.out.println("(Back to front)");
    }
}

// Main class for testing the circular queue
public class CircularQueueImplement {
    public static void main(String[] args) {
        // Creating queue object 
        CircularQueue circularQueue = new CircularQueue();
        // Enqueue elements
        circularQueue.enqueue(10);
        circularQueue.enqueue(20);
        circularQueue.enqueue(30);
        circularQueue.display(); 
        // Display front element
        System.out.println("Front element is: " + queue.peek());
        // Perform dequeue
        System.out.println("Dequeued element is: " + queue.dequeue());
        circularQueue.display(); 
        // Perform enqueue
        circularQueue.enqueue(40);
        circularQueue.enqueue(50);
        circularQueue.display();
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.display();
    }
}
