package datastructures.stacks;

import datastructures.shared.Node;

public class Stack {
    private Node top;

    private int height;

    public Stack(int value) {
        this.top = new Node(value);
        this.height++;
    }

    public void push(int value) {
        Node newNode = new Node(value);

        newNode.next = this.top;
        this.top = newNode;
        this.height++;
    }

    public Node pop() {
         if (this.top == null) {
             return null;
         }

         Node temp = this.top;
         this.top = this.top.next;
         temp.next = null;
         this.height--;
         return temp;
    }

    public void printStack() {
        if (this.top == null) {
            System.out.println("This stack is empty.");
            return;
        }
        printTopValue();
        Node temp = this.top;
        System.out.print("Top");
        while (temp != null) {
            System.out.print("-> ");
            System.out.print(temp.getValue());
            temp = temp.next;
        }
        System.out.println(" <-Bottom");
        printLength();
    }

    public void printTopValue() {
        System.out.println("Top node value: " + this.top.getValue());
    }

    public void printLength() {
        System.out.println("Length: " + this.height);
    }
}
