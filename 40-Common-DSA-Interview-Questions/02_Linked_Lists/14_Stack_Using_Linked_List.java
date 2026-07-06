

class Node {
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class StackUsingLinkedList {
    Node top;
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }
    public void pop() {
        if(top = null){
            System.out.println("stack is empty");
            return -1;
        }
        int value = top.data;
        top = top.next;
        return value;
    }
    public void peek() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return top.data;
    }
    public boolean isEmpty() {

        return top == null;

    }
    public void display() {

        Node current = top;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack:");
        stack.display();
        System.out.println("Peek = " + stack.peek());
        System.out.println("Pop = " + stack.pop());
        System.out.println("Stack after pop:");
        stack.display();
    }

}