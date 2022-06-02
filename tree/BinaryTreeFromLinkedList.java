package tree;

import java.util.*;
/*
author: @ok-ape
PS:
*/

/* test case:



*/

public class BinaryTreeNodeFromLinkedList {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // code here
    }

    public static TreeNodeNode convert(ListNode head, TreeNodeNode node) {
        // add code here.}
        ArrayDeque<TreeNode> Q = new ArrayDeque<>();
        TreeNode root = new TreeNode(head.data);
        Q.offer(root);
        while (head != null) {
            int count = Q.size();
            for (int i = 0; i < count && head != null; i++) {
                TreeNode curr = Q.poll();
                head = head.next;
                if (head != null) {
                    TreeNode left = new TreeNode(head.data);
                    curr.left = left;
                    Q.offer(left);
                    head = head.next;
                }
                if (head != null) {
                    TreeNode right = new TreeNode(head.data);
                    curr.right = right;
                    Q.offer(right);
                }
            }
        }
        return root;
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

    static class TreeNodeNode {
        public int val;
        public TreeNodeNode left;
        public TreeNodeNode right;

        public TreeNodeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public TreeNodeNode(int val, TreeNodeNode left, TreeNodeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public static TreeNodeNode generateSampleTreeNode() {
            TreeNodeNode root = new TreeNodeNode(10);
            root.left = new TreeNodeNode(20);
            root.right = new TreeNodeNode(30);
            root.left.right = new TreeNodeNode(50);
            root.right.left = new TreeNodeNode(40);
            root.right.right = new TreeNodeNode(8);
            root.left.right.left = new TreeNodeNode(78);
            root.right.left.right = new TreeNodeNode(-100);
            return root;
        }

        public static TreeNodeNode generateSampleBST() {
            TreeNodeNode root = new TreeNodeNode(60);
            root.left = new TreeNodeNode(55);
            root.right = new TreeNodeNode(65);
            root.left.left = new TreeNodeNode(50);
            root.left.right = new TreeNodeNode(57);
            root.right.right = new TreeNodeNode(70);
            root.right.right.right = new TreeNodeNode(80);
            return root;
        }

        public static void printTreeNode(TreeNodeNode root) {
            if (root == null) {
                return;
            }
            ArrayDeque<TreeNodeNode> Q = new ArrayDeque<>();
            Q.offer(root);
            while (!Q.isEmpty()) {
                int count = Q.size(); // important step
                // do not use Q.size() in loop termination
                // as Q.size() keep variying
                for (int i = 0; i < count; i++) {
                    TreeNodeNode current = Q.poll();
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