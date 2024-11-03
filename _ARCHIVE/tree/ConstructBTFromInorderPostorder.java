package tree;

import java.util.*;
import java.io.*;
/*
author: @ok-ape
PS:
*/

/* test case:



*/

public class ConstructBTFromInorderPostorder {

    public static void main(String[] args) {
        // code here
        int[] in = { 4, 8, 2, 5, 1, 6, 3, 7 };
        int[] pre = { 8, 4, 5, 2, 6, 7, 3, 1 };
        TreeNode root = buildTree(in, pre, in.length);
        TreeNode.printTree(root);
    }

    static int index = 0;

    static TreeNode buildTree(int in[], int post[], int n) {
        // Your code here
        index = n - 1;
        TreeNode root = build(in, post, 0, n - 1);
        return root;
    }

    static TreeNode build(int[] in, int[] post, int is, int ie) {
        if (is > ie) {
            return null;
        }
        if (index < 0) {
            return null;
        }
        int val = post[index];
        index--;
        TreeNode node = new TreeNode(val);
        int inIndex = -1;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == val) {
                inIndex = i;
                break;
            }
        }
        node.left = build(in, post, is, inIndex - 1);
        node.right = build(in, post, inIndex + 1, ie);
        return node;
    }

    /* boilerplate code - not part of actual logic */
    private static FastReader sc = new FastReader();

    public static void swap(int[] A, int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }

    static void print(Object c) {
        System.out.println(c.toString());
    }

    static void print(int[] A) {
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

    static class Pair<T, S> {
        T x;
        S y;

        public Pair(T x, S y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + this.x + ", " + this.y + ")";
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}