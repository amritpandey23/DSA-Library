package disjoint_set;

import java.util.*;

/*

5 7
0 1 4
0 4 2
1 4 1
1 2 5
4 2 1
4 3 3
2 3 6

*/

public class Kruskals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();       
        int e = sc.nextInt();
        Edge[] edges = new Edge[e];
        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            int w = sc.nextInt();
            edges[i] = new Edge(s, d, w);
        }
        System.out.println();
        System.out.println("MST = " + mst(edges, v));
        sc.close();
    } 

    public static int mst(Edge[] edges, int v) {
        Arrays.sort(edges);
        int cost = 0;
        int[] parent = new int[v];
        int[] rank = new int[v];
        for (int i = 0; i < v; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        for (int i = 0, s = 0; s < v - 1; i++) {
            Edge e = edges[i];
            int x = find(e.src, parent);
            int y = find(e.dest, parent);
            if (x != y) {
                System.out.println(e);
                union(e.src, e.dest, parent, rank);
                cost += e.wt;
                s++;
            }
        }
        return cost;
    }

    public static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        public int compareTo(Edge e) {
            return this.wt - e.wt;
        }

        public String toString() {
            return src + " " + dest + " " + wt;
        }
    }

    public static void union(int x, int y, int[] parent, int[] rank) {
        int x_rep = find(x, parent);
        int y_rep = find(y, parent);
        if (x_rep == y_rep) {
            return;
        }
        if (rank[x_rep] > rank[y_rep]) {
            parent[y_rep] = x_rep;
        } else if (rank[y_rep] > rank[x_rep]) {
            parent[x_rep] = parent[y_rep];
        } else {
            parent[y_rep] = x_rep;
            rank[x_rep]++;
        }
    }

    public static int find(int x, int[] parent) {
        if (x == parent[x]) {
            return x;
        }
        parent[x] = find(parent[x], parent);
        return parent[x];
    }
}
