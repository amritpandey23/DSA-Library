package graph;

import java.util.*;
import java.io.*;
/*
author: @ok-ape
PS:
*/

/* test case:



*/

public class Kosaraju {

    public static void main(String[] args) {
        // code here
        int[][] edges = { { 0, 1 }, { 2, 1 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 3 } };
        int n = 6;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
        }
        runKosaraju(graph);
    }

    public static void runKosaraju(List<Integer>[] graph) {
        int V = graph.length;
        ArrayDeque<Integer> Stack = new ArrayDeque<>();
        boolean[] visited = new boolean[V];
        for (int vtx = 0; vtx < V; vtx++) {
            if (!visited[vtx]) {
                dfs(graph, vtx, visited, Stack);
            }
        }
        List<Integer>[] transposeGraph = transpose(graph);
        visited = new boolean[V];
        while (!Stack.isEmpty()) {
            int src = Stack.pop();
            if (!visited[src]) {
                dfs(transposeGraph, src, visited);
                System.out.println();
            }
        }
    }

    public static List<Integer>[] transpose(List<Integer>[] graph) {
        int V = graph.length;
        List<Integer>[] ans = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            ans[i] = new ArrayList<>();
        }
        for (int vtx = 0; vtx < graph.length; vtx++) {
            for (int nbr : graph[vtx]) {
                ans[nbr].add(vtx);
            }
        }
        return ans;
    }

    public static void dfs(List<Integer>[] graph, int src, boolean[] visited, ArrayDeque<Integer> Stack) {
        visited[src] = true;
        for (int nbr : graph[src]) {
            if (!visited[nbr]) {
                dfs(graph, nbr, visited, Stack);
            }
        }
        Stack.push(src);
    }

    public static void dfs(List<Integer>[] graph, int src, boolean[] visited) {
        visited[src] = true;
        System.out.print(src + " ");
        for (int nbr : graph[src]) {
            if (!visited[nbr]) {
                dfs(graph, nbr, visited);
            }
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