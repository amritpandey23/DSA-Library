package bst;

import java.util.*;
/*
author: @ok-ape
PS:
*/

/* test case:



*/

public class BottomView {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // code here
        TreeNode root = TreeNode.generateSampleTree();
        bottomView(root);
    }

    public static void bottomView(TreeNode root) {
        ArrayDeque<Pair> Q = new ArrayDeque<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Q.offer(new Pair(root, 0));
        while (!Q.isEmpty()) {
            Pair curr = Q.poll();
            int hd = curr.hd;
            if (!map.containsKey(hd)) {
                map.put(hd, curr.node.val);
            }
            map.put(hd, curr.node.val);
            if (curr.node.left != null) {
                Q.offer(new Pair(curr.node.left, hd - 1));
            }
            if (curr.node.right != null) {
                Q.offer(new Pair(curr.node.right, hd + 1));
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static class Pair {
        TreeNode node;
        int hd;

        public Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void swap(int[] A, int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }

    public static void print(int[] A) {
        for (int n : A) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public static TreeNode generateSampleTree() {
            TreeNode root = new TreeNode(10);
            root.left = new TreeNode(20);
            root.right = new TreeNode(30);
            root.left.right = new TreeNode(50);
            root.right.left = new TreeNode(40);
            root.right.right = new TreeNode(8);
            root.left.right.left = new TreeNode(78);
            root.right.left.right = new TreeNode(-100);
            return root;
        }

        public static TreeNode generateSampleBST() {
            TreeNode root = new TreeNode(60);
            root.left = new TreeNode(55);
            root.right = new TreeNode(65);
            root.left.left = new TreeNode(50);
            root.left.right = new TreeNode(57);
            root.right.right = new TreeNode(70);
            root.right.right.right = new TreeNode(80);
            return root;
        }

        public static void printTree(TreeNode root) {
            if (root == null) {
                return;
            }
            ArrayDeque<TreeNode> Q = new ArrayDeque<>();
            Q.offer(root);
            while (!Q.isEmpty()) {
                int count = Q.size(); // important step
                // do not use Q.size() in loop termination
                // as Q.size() keep variying
                for (int i = 0; i < count; i++) {
                    TreeNode current = Q.poll();
                    System.out.print(current.val + " ");
                    if (current.left != null) {
                        Q.offer(current.left);
                    }
                    if (current.right != null) {
                        Q.offer(current.right);
                    }
                }
                System.out.println();
            }
        }
    }
}