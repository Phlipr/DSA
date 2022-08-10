package datastructures.hashtables;

import java.util.ArrayList;

public class HashTable {
    private final int hashSize = 7;
    private final HashNode[] dataNodes;

    public HashTable() {
        this.dataNodes = new HashNode[this.hashSize];
    }

    static class HashNode {
        private final String key;
        private final int value;
        private HashNode next;

        public HashNode(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return "{ " + this.key + ": " + this.value + " }-> ";
        }
    }

    private int hash(String key) {
        int hash = 0;

        char[] keyArray = key.toCharArray();

        for (char c : keyArray) {
            hash = hash + (int) c * 23;
        }

        return hash % this.hashSize;
    }

    public void set(String key, int value) {
        HashNode newNode = new HashNode(key, value);

        int index = this.hash(key);

        HashNode temp = this.dataNodes[index];
        if (temp == null) {
            this.dataNodes[index] = newNode;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key) {
        int index = this.hash(key);

        HashNode temp = this.dataNodes[index];
        while (temp != null) {
            if (temp.key.equals(key)) return temp.value;
            temp = temp.next;
        }
        return 0;
    }

    public ArrayList<String> keys() {
        ArrayList<String> allKeys = new ArrayList<>();

        for (HashNode currNode : this.dataNodes) {
            HashNode temp = currNode;
            while (temp != null) {
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }

        return allKeys;
    }

    public void printHashTable() {
        for (int i = 0; i < hashSize; i++) {
            HashNode temp = this.dataNodes[i];
            System.out.print(i + ": ");
            while (temp != null) {
                System.out.print(temp);
                temp = temp.next;
            }
            System.out.println();
        }
    }
}
