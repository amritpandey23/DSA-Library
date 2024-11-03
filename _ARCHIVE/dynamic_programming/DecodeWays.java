package dynamic_programming;

import java.util.*;
import java.io.*;
/*
author: @ok-ape
PS:
*/

/* test case:



*/

public class DecodeWays {

    public static void main(String[] args) {
        // code here
        String num = "123";
        System.out.println(countDecodeWays(num));
    }

    static int countDecodeWays(String num) {
        int n;
        int[] dp;
        n = num.length();
        dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; ++i) {
            char l1 = num.charAt(i);
            char l2 = num.charAt(i - 1);
            if (l1 == '0' && l2 == '0') {
                dp[i] = 0;
            } else if (l1 != '0' && l2 == '0') {
                dp[i] = dp[i - 1];
            } else if (l1 == '0' && l2 != '0') {
                int x = Integer.parseInt(num.substring(i - 1, i + 1));
                if (x <= 26) {
                    dp[i] = dp[i - 2];
                }
            } else {
                dp[i] = dp[i - 1];
                int x = Integer.parseInt(num.substring(i - 1, i + 1));
                if (x <= 26) {
                    if (i > 1) {
                        dp[i] += dp[i - 2];
                    } else {
                        dp[i]++;
                    }
                } 
            }
        }
        return dp[n - 1];
    }

    /** boilerplate code - not part of actual logic */
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
                int count = Q.size();
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