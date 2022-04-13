package graph;

import java.util.*;

/*
 
5 6
0 1 1
0 2 2
1 3 3
2 4 5
3 4 2
2 3 7

*/
public class DijkstraOptimized {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v, e;
        v = sc.nextInt();
        e = sc.nextInt();

        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            int s, d, w;
            s = sc.nextInt();
            d = sc.nextInt();
            w = sc.nextInt();
            graph[s].add(new Edge(s, d, w));
        }

        int[] dist = dijskstraShortestPath(graph, 0);

        for (int d : dist) {
            System.out.print(d + " ");
        }

        sc.close();
    }

    public static int[] dijskstraShortestPath(ArrayList<Edge>[] graph, int source) {
        int v = graph.length;
        int[] dist = new int[v];
        boolean[] fin = new boolean[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return a.wt - b.wt;
            }
        });
        pq.offer(new Node(source, 0));
        int nodesRelaxed = 0;
        // O(V*(LogV + E))
        while (nodesRelaxed != v) {
            Node curr = pq.poll(); // O(logV)
            while (fin[curr.src]) {
                curr = pq.poll();
            }
            dist[curr.src] = curr.wt;
            fin[curr.src] = true;
            for (Edge e : graph[curr.src]) { // O(E)
                pq.add(new Node(e.nbr, e.wt + curr.wt));
            }
            nodesRelaxed++;
        }
        return dist;
    }

    static class Node {
        int src;
        int wt;

        public Node(int src, int wt) {
            this.src = src;
            this.wt = wt;
        }
    }

    static class Edge {
        int src;
        int nbr;
        int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
}
