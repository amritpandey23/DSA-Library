package disjoint_set;

public class UnionFindCompression {
    public static void main(String[] args) {
        int n = 6;
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }    
    }    

    // O(Log(n))
    public static void union(int x, int y, int[] parent, int[] rank) {
        int x_rep = find(x, parent);
        int y_rep = find(y, parent);
        if (x_rep == y_rep) {
            return;
        }
        if (rank[x_rep] > rank[y_rep]) {
            parent[y_rep] = x_rep;
        } else if (rank[y_rep] > rank[x_rep]) {
            parent[x_rep] = y_rep;
        } else {
            parent[y_rep] = x_rep;
            // rank will only increase when
            // the rank of both representatives
            // are the same i.e. both their
            // heights are same.
            rank[x_rep]++;
        }
    }

    // path compression in find operation
    public static int find(int x, int[] parent) {
        if (x == parent[x]) {
            return x;
        }
        // setting the parent of x to 
        // it's representative whenever
        // the function is called
        parent[x] = find(parent[x], parent);
        return parent[x];
    }
}