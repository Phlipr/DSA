package datastructures;

import datastructures.graphs.Graph;
import datastructures.hashtables.HashTable;
import datastructures.linkedlists.DoublyLinkedList;
import datastructures.linkedlists.LinkedList;
import datastructures.queues.Queue;
import datastructures.stacks.Stack;
import datastructures.trees.BST;

public class Main {
    public static void main(String... args) {
        testLinkedList();
        testDoublyLinkedList();
        testStack();
        testQueue();
        testBST();
        testHashTable();
        testGraph();
    }

    public static void testGraph() {
        System.out.println();
        System.out.println("Testing the Graph Class:");
        System.out.println();

        System.out.println("Creating graph...");
        Graph myGraph = new Graph();

        System.out.println();
        myGraph.printGraph();
        System.out.println();

        System.out.println("Testing 'addVertex' method:");
        System.out.println();

        System.out.println("Adding vertex 'A' to the graph...");
        System.out.println();

        myGraph.addVertex("A");
        myGraph.printGraph();
        System.out.println();

        System.out.println("Testing 'addEdge' method:");
        System.out.println();

        System.out.println("Attempting to add edge between existing vertex 'A' and nonexistent vertex 'B'");
        System.out.println();

        System.out.println("This edge " + (myGraph.addEdge("A", "B") ? "can" : "cannot") + " be added to the graph.");
        System.out.println();

        System.out.println("Graph is now:");
        myGraph.printGraph();
        System.out.println();

        System.out.println("Adding vertex 'B' to graph...");
        System.out.println();
        System.out.println("Vertex 'B' " + (myGraph.addVertex("B") ? "was" : "was not") + " added to the graph.");
        System.out.println();

        System.out.println("Attempting to add edge between existing vertex 'A' and now existing vertex 'B'");
        System.out.println();

        System.out.println("This edge " + (myGraph.addEdge("A", "B") ? "can" : "cannot") + " be added to the graph.");
        System.out.println();

        System.out.println("Graph is now:");
        myGraph.printGraph();
        System.out.println();

        System.out.println("Testing 'removeEdge' method:");
        System.out.println();

        System.out.println("Attempting to remove edge between existing vertex 'A' and nonexistent vertex 'C'");
        System.out.println();

        System.out.println("This edge " + (myGraph.removeEdge("A", "C") ? "can" : "cannot") + " be removed from the graph.");
        System.out.println();

        System.out.println("Graph is now:");
        myGraph.printGraph();
        System.out.println();

        System.out.println("Attempting to remove edge between existing vertex 'A' and existing vertex 'B'");
        System.out.println();

        System.out.println("This edge " + (myGraph.removeEdge("A", "B") ? "can" : "cannot") + " be removed from the graph.");
        System.out.println();

        System.out.println("Graph is now:");
        myGraph.printGraph();
        System.out.println();

        System.out.println("Testing 'removeVertex' method:");
        System.out.println();

        System.out.println("Trying to remove nonexistent vertex 'D' from the graph:");
        System.out.println();

        System.out.println("Vertex 'D' " + (myGraph.removeVertex("D") ? "can" : "cannot") + " be removed from the graph.");
        System.out.println();

        System.out.println("Creating graph with vertices 'A', 'B', 'C', and  'D' with 'A', 'B', and 'C' connected by an edge and 'D' connect to all other vertices.");
        System.out.println();

        myGraph.addVertex("C");
        myGraph.addVertex("D");
        myGraph.addEdge("A", "B");
        myGraph.addEdge("B", "C");
        myGraph.addEdge("A", "C");
        myGraph.addEdge("D", "A");
        myGraph.addEdge("D", "B");
        myGraph.addEdge("D", "C");
        myGraph.printGraph();
        System.out.println();

        System.out.println("Attempting to remove vertex 'D' from this graph:");
        System.out.println();

        System.out.println("Vertex 'D' " + (myGraph.removeVertex("D") ? "can" : "cannot") + " be removed from the graph.");
        System.out.println();

        myGraph.printGraph();
    }

    public static void testHashTable() {
        System.out.println();
        System.out.println("Testing HashTable Class:");
        System.out.println();

        System.out.println("Creating HashTable:");
        System.out.println();

        HashTable myHashTable = new HashTable();

        myHashTable.printHashTable();

        System.out.println();
        System.out.println("Adding items to HashTable using 'set' method:");
        System.out.println();

        String[] keys = {"bolts", "nails", "screws", "lumber", "hammers", "tape", "triangle", "gloves"};
        int[] values = {200, 300, 400, 500, 600, 100, 250, 350};

        for (int i = 0; i < keys.length; i++) {
            System.out.println("Adding item {'" + keys[i] + "': " + values[i] + "}");
            myHashTable.set(keys[i], values[i]);
        }

        System.out.println();
        myHashTable.printHashTable();
        System.out.println();

        System.out.println("Getting items from HashTable using 'get' method:");
        System.out.println();

        String[] getKeys = {"bolts", "screws", "gloves", "lumber", "nails", "apples", "bananas"};

        for (String key : getKeys) {
            System.out.println("Value for " + key + ": " + myHashTable.get(key));
        }

        System.out.println();
        System.out.println("Getting keys from HashTable using 'keys' method:");
        System.out.println();

        System.out.println("Keys in myHashTable: " + myHashTable.keys().toString());
    }

    public static void testBST() {
        System.out.println();
        System.out.println("Testing BST Class:");
        System.out.println();

        System.out.println("Creating BST and testing insert to root...");
        System.out.println();

        BST myBST = new BST();
        myBST.printTree();

        System.out.println("Inserting node with value of 24:");
        myBST.insert(24);
        myBST.printTree();
        System.out.println();

        System.out.println("Inserting node with value of 12:");
        System.out.println();
        myBST.insert(12);
        myBST.printTree();
        System.out.println();

        System.out.println("Inserting node with value of 32:");
        System.out.println();
        myBST.insert(32);
        myBST.printTree();
        System.out.println();

        System.out.println("Inserting node with value of 17:");
        System.out.println();
        myBST.insert(17);
        myBST.printTree();
        System.out.println();

        System.out.println("Inserting node with value of 17:");
        System.out.println();
        myBST.insert(17);
        myBST.printTree();
        System.out.println();

        System.out.println("Inserting node with value of 18:");
        System.out.println();
        myBST.insert(18);
        myBST.printTree();
        System.out.println();

        System.out.println("Inserting node with value of 9:");
        System.out.println();
        myBST.insert(9);
        myBST.printTree();
        System.out.println();

        System.out.println("Inserting node with value of 99:");
        System.out.println();
        myBST.insert(99);
        myBST.printTree();
        System.out.println();

        System.out.println("Testing contains method:");
        System.out.println();

        System.out.println("The BST " + (myBST.contains(9) ? "contains" : "does not contain") + " the value of 9.");
    }

    public static void testQueue() {
        System.out.println();
        System.out.println("Testing Queue class:");
        System.out.println();

        System.out.println("Creating queue with initial value of 1...");
        System.out.println();

        Queue queue1 = new Queue(1);
        queue1.printQueue();

        System.out.println();
        System.out.println("Testing enqueue method:");
        System.out.println();

        System.out.println("Enqueuing node with a value of 2...");
        queue1.enqueue(2);
        System.out.println();

        queue1.printQueue();

        System.out.println();
        System.out.println("Testing dequeue method:");
        System.out.println();

        System.out.println("De-queuing first node...");
        System.out.println("Removing node with value of " + queue1.dequeue().getValue());
        System.out.println();

        System.out.println("New List:");
        queue1.printQueue();
        System.out.println();

        System.out.println("De-queuing first node...");
        System.out.println("Removing node with value of " + queue1.dequeue().getValue());
        System.out.println();

        System.out.println("New List:");
        queue1.printQueue();
        System.out.println();

        System.out.println("De-queuing first node...");
        System.out.println("Removing node with value of " + queue1.dequeue());
        System.out.println();

        System.out.println("New List:");
        queue1.printQueue();
        System.out.println();

        System.out.println("Testing enqueue method on empty list:");
        System.out.println();

        System.out.println("Enqueuing node with value of 1 on empty list...");
        queue1.enqueue(1);

        System.out.println();
        System.out.println("New List:");
        queue1.printQueue();
    }

    public static void testStack() {
        System.out.println();
        System.out.println("Testing Stack class:");
        System.out.println();

        System.out.println("Creating Stack class with initial top value of 1...");
        Stack stack1 = new Stack(1);

        System.out.println();
        stack1.printStack();

        System.out.println();
        System.out.println("Testing push method:");
        System.out.println();

        System.out.println("Pushing 2, 3, 4, and 5 to stack...");
        System.out.println();

        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);

        stack1.printStack();

        System.out.println();
        System.out.println("Testing pop method:");
        System.out.println();

        System.out.println("Popping 5, 4, 3, 2, and 1...");
        System.out.println();

        System.out.println("Removing node with value of " + stack1.pop().getValue());
        System.out.println("New list:");
        stack1.printStack();
        System.out.println();

        System.out.println("Removing node with value of " + stack1.pop().getValue());
        System.out.println("New list:");
        stack1.printStack();
        System.out.println();

        System.out.println("Removing node with value of " + stack1.pop().getValue());
        System.out.println("New list:");
        stack1.printStack();
        System.out.println();

        System.out.println("Removing node with value of " + stack1.pop().getValue());
        System.out.println("New list:");
        stack1.printStack();
        System.out.println();

        System.out.println("Removing node with value of " + stack1.pop().getValue());
        System.out.println("New list:");
        stack1.printStack();
        System.out.println();

        System.out.println("Removing node with value of " + stack1.pop());
        System.out.println("New list:");
        stack1.printStack();
        System.out.println();
    }

    public static void testDoublyLinkedList() {
        System.out.println();
        System.out.println("Testing DoublyLinkedListClass:");
        System.out.println();

        System.out.println("Creating new DoublyLinkedList with one node of value 1...");
        System.out.println();

        DoublyLinkedList doublyLinkedList1 = new DoublyLinkedList(1);
        doublyLinkedList1.printLinkedList();

        System.out.println();
        System.out.println("Appending node with value of 2 to the list...");
        System.out.println();

        doublyLinkedList1.append(2);
        doublyLinkedList1.printLinkedList();

        System.out.println();
        System.out.println("Appending node with value of 3 to the list...");
        System.out.println();

        doublyLinkedList1.append(3);
        doublyLinkedList1.printLinkedList();

        System.out.println();
        System.out.println("Removing last node from the list...");
        System.out.println();

        System.out.printf("Node removed had value of: %d%n", doublyLinkedList1.removeLast().getValue());
        System.out.println("New list is:");
        doublyLinkedList1.printLinkedList();

        System.out.println();
        System.out.println("Removing last node from the list...");
        System.out.println();

        System.out.printf("Node removed had value of: %d%n", doublyLinkedList1.removeLast().getValue());
        System.out.println("New list is:");
        doublyLinkedList1.printLinkedList();

        System.out.println();
        System.out.println("Removing last node from the list...");
        System.out.println();

        System.out.printf("Node removed had value of: %d%n", doublyLinkedList1.removeLast().getValue());
        System.out.println("New list is:");
        doublyLinkedList1.printLinkedList();

        System.out.println();
        System.out.println("Removing last node from the list...");
        System.out.println();

        System.out.println("Node removed had value of: " + doublyLinkedList1.removeLast());
        System.out.println("New list is:");
        doublyLinkedList1.printLinkedList();

        System.out.println();
        System.out.println("Prepending node with value of 3 to the list...");
        System.out.println();

        doublyLinkedList1.prepend(3);
        doublyLinkedList1.printLinkedList();

        System.out.println();
        System.out.println("Prepending node with value of 2 to the list...");
        System.out.println();

        doublyLinkedList1.prepend(2);
        doublyLinkedList1.printLinkedList();

        System.out.println();
        System.out.println("Prepending node with value of 1 to the list...");
        System.out.println();

        doublyLinkedList1.prepend(1);
        doublyLinkedList1.printLinkedList();

        System.out.println();
        System.out.println("Removing first node from the list...");
        System.out.println();

        System.out.printf("Node removed had value of: %d%n", doublyLinkedList1.removeFirst().getValue());
        System.out.println("New list is:");
        doublyLinkedList1.printLinkedList();

        System.out.println();
        System.out.println("Removing first node from the list...");
        System.out.println();

        System.out.printf("Node removed had value of: %d%n", doublyLinkedList1.removeFirst().getValue());
        System.out.println("New list is:");
        doublyLinkedList1.printLinkedList();

        System.out.println();
        System.out.println("Removing first node from the list...");
        System.out.println();

        System.out.printf("Node removed had value of: %d%n", doublyLinkedList1.removeFirst().getValue());
        System.out.println("New list is:");
        doublyLinkedList1.printLinkedList();

        System.out.println();
        System.out.println("Removing first node from the list...");
        System.out.println();

        System.out.println("Node removed had value of: " + doublyLinkedList1.removeFirst());
        System.out.println("New list is:");
        doublyLinkedList1.printLinkedList();

        System.out.println();
        System.out.println("Creating new doubly linked list with values 1-5");
        System.out.println();

        doublyLinkedList1.append(1);
        doublyLinkedList1.append(2);
        doublyLinkedList1.append(3);
        doublyLinkedList1.append(4);
        doublyLinkedList1.append(5);

        System.out.println("Newly made list:");
        doublyLinkedList1.printLinkedList();

        System.out.println();
        System.out.println("Getting node at index 2...");
        System.out.println();

        System.out.printf("Node value at index 2 = %d%n", doublyLinkedList1.get(2).getValue());

        System.out.println();
        System.out.println("Getting node at index 0...");
        System.out.println();

        System.out.printf("Node value at index 0 = %d%n", doublyLinkedList1.get(0).getValue());

        System.out.println();
        System.out.println("Getting node at index 4...");
        System.out.println();

        System.out.printf("Node value at index 4 = %d%n", doublyLinkedList1.get(4).getValue());

        System.out.println();
        System.out.println("Getting node at index -1...");
        System.out.println();

        System.out.println("Node value at index -1 = " + doublyLinkedList1.get(-1));

        System.out.println();
        System.out.println("Getting node at index 5...");
        System.out.println();

        System.out.println("Node value at index 5 = " + doublyLinkedList1.get(5));

        System.out.println();
        System.out.println("Setting node at index 2 to 10...");
        System.out.println();

        System.out.println("Node value at index 2 " + (doublyLinkedList1.set(2, 10) ? "can" : "cannot") + " be set to 10.");
        System.out.println("List:");
        doublyLinkedList1.printLinkedList();

        System.out.println();
        System.out.println("Setting node at index -1 to 10...");
        System.out.println();

        System.out.println("Node value at index -1 " + (doublyLinkedList1.set(-1, 10) ? "can" : "cannot") + " be set to 10.");
        System.out.println("List:");
        doublyLinkedList1.printLinkedList();

        System.out.println();
        System.out.println("Setting node at index 5 to 10...");
        System.out.println();

        System.out.println("Node value at index 5 " + (doublyLinkedList1.set(5, 10) ? "can" : "cannot") + " be set to 10.");
        System.out.println("List:");
        doublyLinkedList1.printLinkedList();

        System.out.println();
        System.out.println("Inserting node with value of 6 at index 3...");
        System.out.println();

        System.out.println("Node with value 6 " + (doublyLinkedList1.insert(3, 6) ? "can" : "cannot") + " be inserted at index 3.");
        System.out.println("List:");
        doublyLinkedList1.printLinkedList();

        System.out.println();
        System.out.println("Inserting node with value of 7 at index 0...");
        System.out.println();

        System.out.println("Node with value 7 " + (doublyLinkedList1.insert(0, 7) ? "can" : "cannot") + " be inserted at index 0.");
        System.out.println("List:");
        doublyLinkedList1.printLinkedList();

        System.out.println();
        System.out.println("Inserting node with value of 8 at index 7...");
        System.out.println();

        System.out.println("Node with value 8 " + (doublyLinkedList1.insert(7, 8) ? "can" : "cannot") + " be inserted at index 7.");
        System.out.println("List:");
        doublyLinkedList1.printLinkedList();

        System.out.println();
        System.out.println("Inserting node with value of 9 at index -1...");
        System.out.println();

        System.out.println("Node with value 9 " + (doublyLinkedList1.insert(-1, 9) ? "can" : "cannot") + " be inserted at index -1.");
        System.out.println("List:");
        doublyLinkedList1.printLinkedList();

        System.out.println();
        System.out.println("Inserting node with value of 9 at index 9...");
        System.out.println();

        System.out.println("Node with value 9 " + (doublyLinkedList1.insert(9, 9) ? "can" : "cannot") + " be inserted at index 9.");
        System.out.println("List:");
        doublyLinkedList1.printLinkedList();

        System.out.println();
        System.out.println("Testing remove method:");

        for (int i = 8; i > -2; i--) {
            System.out.println();
            System.out.println("Removing node at index of " + i + "...");
            System.out.println();

            if (doublyLinkedList1.get(i) != null) {
                System.out.println("Node at index " + i + " removed with a value of " + doublyLinkedList1.remove(i).getValue());
            } else {
                System.out.println("Node at index " + i + " cannot be removed.");
            }

            System.out.println("List:");
            doublyLinkedList1.printLinkedList();
        }
    }

    public static void testLinkedList() {
        System.out.println();
        System.out.println("Testing LinkedList class:");
        System.out.println();

        System.out.println("Creating new LinkedList with one node of value 1...");

        System.out.println();

        LinkedList linkedList1 = new LinkedList(1);

        linkedList1.printLinkedList();

        System.out.println();

        System.out.println("Testing append method:");

        System.out.println();

        linkedList1.append(2);

        linkedList1.printLinkedList();

        System.out.println();

        linkedList1.append(3);

        linkedList1.printLinkedList();

        System.out.println();

        System.out.println("Testing removeLast method:");

        System.out.println();

        System.out.printf("Removed node with value = %d%n", linkedList1.removeLast().getValue());

        linkedList1.printLinkedList();

        System.out.println();

        System.out.printf("Removed node with value = %d%n", linkedList1.removeLast().getValue());

        linkedList1.printLinkedList();

        System.out.println();

        System.out.printf("Removed node with value = %d%n", linkedList1.removeLast().getValue());

        linkedList1.printLinkedList();

        System.out.println();

        System.out.println("Removed node with value = " + linkedList1.removeLast());

        linkedList1.printLinkedList();

        System.out.println();

        System.out.println("Testing prepend method:");

        System.out.println();

        linkedList1.prePend(3);

        linkedList1.printLinkedList();

        System.out.println();

        linkedList1.prePend(2);

        linkedList1.printLinkedList();

        System.out.println();

        linkedList1.prePend(1);

        linkedList1.printLinkedList();

        System.out.println();

        System.out.println("Testing removeFirst method:");

        System.out.println();

        System.out.printf("Removed node value = %d%n", linkedList1.removeFirst().getValue());

        linkedList1.printLinkedList();

        System.out.println();

        System.out.printf("Removed node value = %d%n", linkedList1.removeFirst().getValue());

        linkedList1.printLinkedList();

        System.out.println();

        System.out.printf("Removed node value = %d%n", linkedList1.removeFirst().getValue());

        linkedList1.printLinkedList();

        System.out.println();

        System.out.println("Removed node value = " + linkedList1.removeFirst());

        linkedList1.printLinkedList();

        System.out.println();

        System.out.println("Testing get method:");

        System.out.println();

        linkedList1.append(1);
        linkedList1.append(2);
        linkedList1.append(3);
        linkedList1.append(4);
        linkedList1.append(5);

        linkedList1.printLinkedList();

        System.out.println();

        System.out.printf("The node value at index 0 is %d%n", linkedList1.get(0).getValue());

        System.out.println();

        System.out.printf("The node value at index 1 is %d%n", linkedList1.get(1).getValue());

        System.out.println();

        System.out.printf("The node value at index 2 is %d%n", linkedList1.get(2).getValue());

        System.out.println();

        System.out.printf("The node value at index 3 is %d%n", linkedList1.get(3).getValue());

        System.out.println();

        System.out.printf("The node value at index 4 is %d%n", linkedList1.get(4).getValue());

        System.out.println();

        System.out.println("The node value at index -1 is " + linkedList1.get(-1));

        System.out.println();

        System.out.println("The node value at index 5 is " + linkedList1.get(5));

        System.out.println();

        linkedList1.printLinkedList();

        System.out.println();

        System.out.println("Testing insert method:");

        System.out.println();

        System.out.printf("Inserting a 6 at index -1 %s be done.%n", linkedList1.insert(-1, 6) ? "can" : "cannot");

        System.out.println();

        System.out.printf("Inserting a 6 at index 6 %s be done.%n", linkedList1.insert(-1, 6) ? "can" : "cannot");

        System.out.println();

        System.out.printf("Inserting a 6 at index 0 %s be done.%n", linkedList1.insert(0, 6) ? "can" : "cannot");

        System.out.println("The new list is:");
        linkedList1.printLinkedList();

        System.out.println();

        System.out.printf("Inserting a 7 at index 3 %s be done.%n", linkedList1.insert(3, 7) ? "can" : "cannot");

        System.out.println("The new list is:");
        linkedList1.printLinkedList();

        System.out.println();

        System.out.printf("Inserting a 8 at index 8 %s be done.%n", linkedList1.insert(7, 8) ? "can" : "cannot");

        System.out.println("The new list is:");
        linkedList1.printLinkedList();

        System.out.println();

        System.out.printf("Setting index 5 to 12 %s be done.%n", linkedList1.set(5, 12) ? "can" : "cannot");

        System.out.println("The new list is:");
        linkedList1.printLinkedList();

        System.out.println();

        System.out.printf("Setting index 8 to 12 %s be done.%n", linkedList1.set(8, 12) ? "can" : "cannot");

        System.out.println();

        System.out.printf("Setting index -1 to 12 %s be done.%n", linkedList1.set(-1, 12) ? "can" : "cannot");

        System.out.println();

        System.out.println("Removing node at -1 returns " + linkedList1.remove(-1));

        System.out.println();

        System.out.println("Removing node at -12 returns " + linkedList1.remove(12));

        System.out.println();

        System.out.printf("Removing node at 7 returns %d%n", linkedList1.remove(7).getValue());

        System.out.println();

        System.out.println("New list is:");
        linkedList1.printLinkedList();

        System.out.println();

        System.out.printf("Removing node at 3 returns %d%n", linkedList1.remove(3).getValue());

        System.out.println();

        System.out.println("New list is:");
        linkedList1.printLinkedList();

        System.out.println();

        System.out.printf("Removing node at 0 returns %d%n", linkedList1.remove(0).getValue());

        System.out.println();

        System.out.println("New list is:");
        linkedList1.printLinkedList();

        System.out.println();

        System.out.println("Reversing the list gives:");
        linkedList1.reverse();
        linkedList1.printLinkedList();
    }
}
