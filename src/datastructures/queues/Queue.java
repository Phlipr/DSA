package datastructures.queues;

import datastructures.shared.Node;

public class Queue {
    private Node first;
    private Node last;
    private int length;

    public Queue(int value) {
        Node newNode = new Node(value);

        this.first = newNode;
        this.last = newNode;
        this.length = 1;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);

        if (this.first == null) {
            this.first = newNode;
        } else {
            this.last.next = newNode;
        }
        this.last = newNode;

        this.length++;
    }

    public Node dequeue() {
        if (this.first == null) {
            return null;
        }

        Node temp = this.first;

        if (this.first == this.last) {
            this.first = null;
            this.last = null;
        } else {
            this.first = temp.next;
        }
        temp.next = null;
        this.length--;
        return temp;
    }

    public void printQueue() {
        if (this.first == null) {
            System.out.println("This queue is empty.");
            return;
        }

        this.printFirstNodeValue();
        Node temp = this.first;
        System.out.print("First");
        while (temp != null) {
            System.out.print("-> ");
            System.out.print(temp.getValue());
            temp = temp.next;
        }
        System.out.println(" <-Last");
        this.printLastNodeValue();
        this.printLength();
    }

    public void printFirstNodeValue() {
        System.out.println("First node value: " + this.first.getValue());
    }

    public void printLastNodeValue() {
        System.out.println("Last node value: " + this.last.getValue());
    }

    public void printLength() {
        System.out.println("Length: " + this.length);
    }
}
