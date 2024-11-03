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
public class DijkstraSPA {
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

    /**
     * Dijkstra shortest path algorithm (non-optimized)
     * time complexity: O(V*(V + E))
     * @param           graph[]
     * @param           source - for single source
     * @return          dist[]
     */
    public static int[] dijskstraShortestPath(ArrayList<Edge>[] graph, int source) {
        int v = graph.length;
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] fin = new boolean[v];

        dist[source] = 0;

        // O(V*(V + E))
        for (int count = 0; count < v; count++) {
            int u = -1;
            // O(V)
            for (int i = 0; i < v; i++) {
                if ((u == -1 || dist[i] < dist[u]) && !fin[i]) {
                    u = i;
                }
            }
            fin[u] = true;
            // O(E)
            for (Edge e : graph[u]) {
                int nbr = e.nbr;
                int wt = e.wt;

                if (!fin[nbr] && dist[nbr] > wt + dist[u]) {
                    dist[nbr] = wt + dist[u];
                }
            }
        }
        return dist;
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
