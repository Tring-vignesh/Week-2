//Node class represent Node in LinkedlinkedList 
class Node {
    // Value of Node
    int data; 
    // Node of the next Node 
    Node next; 
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedlinkedListImplementation {
    // Head node is the starting node
    Node head;
    
    // Method to insert node
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; 
        } else {
            Node current = head;
            while (current.next != null) { 
                current = current.next;
            }
            current.next = newNode; 
        }
    }
    
    // Method to print node
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
    
    

    // Delete last node
    public void deleteLast() {
        if (head == null) {
            return; // linkedList is empty
        }
        if (head.next == null) {
            head = null; // Only one node in the linkedList
            return;
        }
        Node current = head;
        while (current.next.next != null) { // Find second last node
            current = current.next;
        }
        current.next = null; // Remove last node
    }

    public static void main(String[] args) {
        LinkedlinkedListImplementation linkedlinkedList = new LinkedlinkedListImplementation();
        linkedList.insert(10);
        linkedList.insert(20);
        linkedList.insert(30);
        System.out.println("Linked linkedList:");
        linkedList.display();
        linkedList.deleteLast(); 
        System.out.println("After deleting last node:");
        linkedList.display();
    }
}
