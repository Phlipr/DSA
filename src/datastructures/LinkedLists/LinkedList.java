package datastructures.LinkedLists;

import datastructures.Shared.Node;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);

        this.head = newNode;
        this.tail = newNode;
        this.length++;
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (this.head == null) { // LinkedList is currently empty
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }
        this.tail = newNode;
        this.length++;
    }

    public Node removeLast() {
        // LinkedList is empty
        if (this.head == null) {
            return null;
        }

        Node temp = this.head;
        Node pre = this.head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        pre.next = null;
        this.tail = pre;
        this.length--;
        if (this.length == 0) {
            this.head = null;
            this.tail = null;
        }

        return temp;
    }

    public void prePend(int value) {
        Node newNode = new Node(value);

        // LinkedList is empty
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = head;
            this.head = newNode;
        }
        this.length++;
    }

    public Node removeFirst() {
        if (this.head == null) { // LinkedList is empty
            return null;
        }

        Node temp = this.head;
        this.head = this.head.next;
        temp.next = null;
        this.length--;
        if (length == 0) {
            this.tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if (this.head == null) { // LinkedList is empty
            return null;
        }

        if (index < 0 || index >= this.length) { // index beyond LinkedList index boundaries
            return null;
        }

        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > this.length) {
            return false;
        }

        if (index == 0) {
            this.prePend(value);
        } else if (index == this.length) {
            this.append(value);
        } else {
            Node newNode = new Node(value);
            Node temp = this.get(index - 1);
            newNode.next = temp.next;
            temp.next = newNode;
            length++;
        }

        return true;
    }

    public boolean set(int index, int value) {
        Node temp = this.get(index);

        if (temp != null) {
            temp.setValue(value);
            return true;
        }

        return false;
    }

    public Node remove(int index) {
        if (index < 0 || index >= this.length) {
            return null;
        }

        if (index == 0) {
            return this.removeFirst();
        } else if (index == this.length - 1) {
            return this.removeLast();
        } else {
            Node pre = this.get(index - 1);
            Node temp = pre.next;
            pre.next = temp.next;
            temp.next = null;
            this.length--;
            return temp;
        }
    }

    public void reverse() {
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;
        Node before = null;
        Node after;
        for (int i = 0; i < this.length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public void printLinkedList() {
        // LinkedList is empty
        if (this.head == null) {
            System.out.println("The LinkedList is empty.");
            return;
        }
        Node temp = this.head;
        // print the head of the list
        this.printHeadValue();
        System.out.print("Head -> ");
        // print the middle of the list
        while (temp.next != null) {
            System.out.printf("%d -> ", temp.getValue());
            temp = temp.next;
        }
        // print the tail of the list
        System.out.printf("%d <- Tail%n", temp.getValue());
        this.printTailValue();
        this.printLength();
    }

    private void printHeadValue() {
        System.out.printf("Head node value: %d%n", this.head.getValue());
    }

    private void printTailValue() {
        System.out.printf("Tail node value: %d%n", this.tail.getValue());
    }

    private void printLength() {
        System.out.printf("Length: %d%n", this.length);
    }
}
