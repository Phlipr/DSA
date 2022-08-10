package datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
    private TreeNode root;
    private int maxHeight;

    class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;
        private int height;
        private int position;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public BST() {
        this.root = null;
        this.maxHeight = 0;
    }

    public boolean insert(int value) {
        TreeNode newNode = new TreeNode(value);
        if (this.root == null) {
            newNode.height = 0;
            newNode.position = 0;
            this.root = newNode;
            this.maxHeight = 0;
            return true;
        }

        TreeNode temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    newNode.height = temp.height + 1;
                    newNode.position = 2 * temp.position;
                    this.maxHeight = Math.max(this.maxHeight, newNode.height);
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    newNode.height = temp.height + 1;
                    newNode.position = 2 * temp.position + 1;
                    this.maxHeight = Math.max(this.maxHeight, newNode.height);
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        TreeNode temp = this.root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public void printTree() {
        if (this.root == null) {
            System.out.println("This tree is empty.");
            return;
        }
        // determine base width of tree
        int midline = (int) (((Math.pow(2,this.maxHeight)) * 3) / 2);
        for (int i = 0; i < midline; i++) {
            System.out.print(" ");
        }
        System.out.println(this.root.value);
        int currLevel = 1;
        Queue<TreeNode> treeNodes = this.nodes();
        while (currLevel <= this.maxHeight) {
            int startLine = (int) (midline - ((Math.pow(2, currLevel)) * 3 / 2));
            Queue<TreeNode> currLevelNodes = new LinkedList<>();
            while (treeNodes.peek() != null && treeNodes.peek().height == currLevel) {
                currLevelNodes.offer(treeNodes.poll());
            }
            Queue<TreeNode> currLevelNodesCopy = new LinkedList<>(currLevelNodes);
            int prevBranchPosition = 0;
            while (currLevelNodes.peek() != null) {
                TreeNode currNode = currLevelNodes.poll();
                int branchPosition = currNode.position * 3 + startLine + (currNode.position % 2 == 0 ? 1 : 2);
                for (int i = prevBranchPosition; i < branchPosition; i++) {
                    System.out.print(" ");
                }
                String branchType = currNode.position % 2 == 0 ? "/" : "\\";
                System.out.print(branchType);
                prevBranchPosition = branchPosition;
            }
            System.out.println();
            prevBranchPosition = 0;
            while (currLevelNodesCopy.peek() != null) {
                TreeNode currNode = currLevelNodesCopy.poll();
                int branchPosition = currNode.position * 3 + startLine + (currNode.position % 2 == 0 ? 0 : 1);
                for (int i = prevBranchPosition; i < branchPosition; i++) {
                    System.out.print(" ");
                }
                System.out.print(currNode.value);
                prevBranchPosition = branchPosition;
            }
            System.out.println();
            currLevel++;
        }
    }

    public Queue<TreeNode> nodes() {
        TreeNode temp = this.root;
        Queue<TreeNode> treeNodes = new LinkedList<>();
        Queue<TreeNode> ret = new LinkedList<>();
        if (this.root != null) {
            treeNodes.offer(root);
        }
        while (!treeNodes.isEmpty()) {
            TreeNode currNode = treeNodes.poll();
            if (currNode.left != null) {
                treeNodes.offer(currNode.left);
                ret.offer(currNode.left);
            }
            if (currNode.right != null) {
                treeNodes.offer(currNode.right);
                ret.offer(currNode.right);
            }
        }
        return ret;
    }
}
