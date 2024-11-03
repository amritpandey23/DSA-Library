package graph;

import java.util.*;
import java.io.*;
/*
author: @ok-ape
PS:
*/

/* test case:



*/

public class KruskalMST {

    public static void main(String[] args) {
        // code here
        int[][] edges = {{0, 1, 2}, {1, 2, 3}, {2, 0, 1}};
        List<Edge> edgs = new ArrayList<>();
        for (int[] e : edges) {
            edgs.add(new Edge(e[0], e[1], e[2]));
        }
        System.out.println(mst(edgs, 3));
    }

    public static int mst(List<Edge> edges, int V) {
        int cost = 0;
        int[] parent = new int[V];
        for (int vtx = 0; vtx < V; vtx++) {
            parent[vtx] = vtx;
        }
        Collections.sort(edges, (e1, e2) -> e1.wt - e2.wt);
        int count = 0;
        for (int e = 0; e < edges.size() && count < V; e++) {
            Edge edg = edges.get(e);
            if (find(parent, edg.src) != find(parent, edg.dest)) {
                union(parent, edg.src, edg.dest);
                cost += edg.wt;
                count++;
            }
        }
        for (int p : parent) {
            System.out.print(p + " ");
        }
        System.out.println();
        return cost;
    }

    public static void union(int[] parent, int x, int y) {
        int x_repr = find(parent, x);
        int y_repr = find(parent, y);
        parent[x_repr] = y_repr;
    }

    public static int find(int[] parent, int src) {
        if (parent[src] == src) {
            return src;
        }
        return find(parent, parent[src]);
    }

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
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