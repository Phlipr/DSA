package datastructures.linkedlists;

import datastructures.shared.Node;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        length++;
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (this.head == null) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
        }
        this.tail = newNode;

        this.length++;
    }

    public Node removeLast() {
        if (this.head == null) {
            return null;
        }

        Node temp = this.tail;
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = temp.prev;
            temp.prev = null;
            temp.next = null;
            this.tail.next = null;
        }
        this.length--;
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
    }

    public Node removeFirst() {
        if (this.head == null) {
            return null;
        }

        Node temp = this.head;

        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = temp.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index > this.length - 1) {
            return null;
        }

        if (index == 0) {
            return this.head;
        }

        if (index == this.length - 1) {
            return this.tail;
        }

        Node temp;

        if (index < (this.length / 2)) {
            temp = this.head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = this.tail;
            for (int i = this.length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = this.get(index);

        if (temp == null) {
            return false;
        }

        temp.setValue(value);

        return true;
    }

    public boolean insert(int index, int value) {
        if (index == 0) {
            this.prepend(value);
            return true;
        }

        if (index == this.length) {
            this.append(value);
            return true;
        }

        Node temp = this.get(index);

        if (temp != null) {
            Node newNode = new Node(value);
            newNode.next = temp;
            newNode.prev = temp.prev;
            temp.prev.next = newNode;
            temp.prev = newNode;
            length++;
            return true;
        } else {
            return false;
        }
    }

    public Node remove(int index) {
        if (index == 0) {
            return this.removeFirst();
        }

        if (index == this.length - 1) {
            return this.removeLast();
        }

        Node temp = this.get(index);

        if (temp == null) {
            return null;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = null;
        temp.prev = null;
        length--;
        return temp;
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
