package tree;

import java.util.*;
/*
author: @ok-ape
PS:
*/

/* test case:



*/

public class TraverseInSpiral {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // code here
        TreeNode root = TreeNode.generateSampleTree();
        printTree(root);
        sprialTraversal(root);
        spiralTraversal2(root);
    }

    public static void spiralTraversal2(TreeNode root) {
        /* spiral traversal using one stack and one queue */
        if (root == null) {
            return;
        }
        ArrayDeque<TreeNode> Q = new ArrayDeque<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        Q.offer(root);
        boolean reverse = false;
        while (!Q.isEmpty()) {
            int count = Q.size();
            for (int i = 0; i < count; i++) {
                TreeNode current = Q.poll();
                if (reverse) {
                    stack.push(current);
                } else {
                    System.out.print(current.val + " ");
                }
                if (current.left != null) {
                    Q.offer(current.left);
                }
                if (current.right != null) {
                    Q.offer(current.right);
                }
            }
            if (reverse) {
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop().val + " ");
                }
            }
            reverse = !reverse;
            System.out.println();
        }
    }

    public static void sprialTraversal(TreeNode root) {
        /* spiral traversal using two stacks */
        if (root == null) {
            return;
        }
        ArrayDeque<TreeNode> stack1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> stack2 = new ArrayDeque<>();
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    TreeNode current = stack1.pop();
                    if (current.left != null) {
                        stack2.push(current.left);
                    }
                    if (current.right != null) {
                        stack2.push(current.right);
                    }
                    System.out.print(current.val + " ");
                }
            } else {
                while (!stack2.isEmpty()) {
                    TreeNode current = stack2.pop();
                    if (current.right != null) {
                        stack1.push(current.right);
                    }
                    if (current.left != null) {
                        stack1.push(current.left);
                    }
                    System.out.print(current.val + " ");
                }
            }
            System.out.println();
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
