package hashing;

import java.util.*;
import java.io.*;
/*
author: @ok-ape
PS:
*/

/* test case:

gives wrong output to
the following case:

8
2
10 10 11 11 3 4 3 5

*/

public class MoreThanNByKOccurance {

    public static void main(String[] args) {
        // code here
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; ++i) {
            A[i] = sc.nextInt();
        }
        moreThanNByK(A, k);
    }

    private static void moreThanNByK(int[] A, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : A) {
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else if (map.size() < k) {
                map.put(x, 1);
            } else {
                Set<Integer> keys = new HashSet<>();
                for (Integer key : map.keySet()) {
                    map.put(key, map.get(key) - 1);
                    if (map.get(key) == 0) {
                        keys.add(key);
                    }
                }
                for (int key : keys) {
                    map.remove(key);
                }
            }
        }
        for (int key : map.keySet()) {
            System.out.print(key + " ");
        }
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