package graph;

import java.util.*;
import java.io.*;
/*
author: @ok-ape
PS:
*/

/* test case:



*/

public class DetectCycleUndirected {

    public static void main(String[] args) {
        // code here
        int[][] edges = { { 0, 1 }, { 2, 3 }, { 2, 0 }, { 1, 2 } };
        int n = 5;
        List<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        System.out.println(detectCycle(graph));
        System.out.println(detectCycleBFS(graph));
    }

    /**
     * Detect cycle in undirected graph using BFS
     * 
     * @param graph: adjacency list of graph
     * @return true if cycle exists, else false
     */
    public static boolean detectCycleBFS(List<Integer>[] graph) {
        int V = graph.length;
        boolean[] visited = new boolean[V];
        for (int vtx = 0; vtx < V; vtx++) {
            if (!visited[vtx]) {
                if (detectCycleBFS(graph, vtx, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Detect cycle in undirected graph using BFS
     * 
     * @param graph: adjacency list of graph
     * @param src: starting vertex/node
     * @param visited: visited boolean map
     * @return true if cycle exists, else false
     */
    public static boolean detectCycleBFS(List<Integer>[] graph, int src, boolean[] visited) {
        ArrayDeque<Integer> Queue = new ArrayDeque<>();
        int parent = -1;
        Queue.offer(src);
        while (!Queue.isEmpty()) {
            int currentNode = Queue.poll();
            if (visited[currentNode]) {
                return true;
            }
            visited[currentNode] = true;
            for (int vtx : graph[currentNode]) {
                if (vtx != parent && !visited[vtx]) {
                    Queue.offer(vtx);
                }
            }
            parent = currentNode;
        }
        return false;
    }

    /**
     * Detect Cycle in Undirected graph using DFS
     * 
     * @param graph: Adjacency list of graph
     */
    public static boolean detectCycle(List<Integer>[] graph) {
        int V = graph.length;
        boolean[] visited = new boolean[V];
        for (int vtx = 0; vtx < V; vtx++) {
            if (!visited[vtx]) {
                if (detectCycle(graph, vtx, -1, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Detect Cycle in Undirected graph using DFS.
     * 
     * @param graph:   Adjacency list of graph
     * @param src:     starting vertex
     * @param parent:  parent vertex of starting vertex
     * @param visited: visited boolean map
     * @return true if cycle exists, else false
     */
    public static boolean detectCycle(List<Integer>[] graph, int src, int parent, boolean[] visited) {
        if (src != parent && visited[src]) {
            return true;
        }
        visited[src] = true;
        for (int nbr : graph[src]) {
            if (nbr != parent) {
                if (detectCycle(graph, nbr, src, visited)) {
                    return true;
                }
            }
        }
        return false;
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