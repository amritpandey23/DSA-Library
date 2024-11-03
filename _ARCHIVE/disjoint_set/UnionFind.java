package disjoint_set;

public class UnionFind {
    public static void main(String[] args) {
        int n = 5;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        union(0, 1, parent);
        union(2, 4, parent);
        union(3, 1, parent);
        
        System.out.println("Find(1) = " + find(1, parent));

        for (int a : parent) {
            System.out.print(a + " ");
        }
    }

    public static void union(int x, int y, int[] parent) {
        int x_rep = parent[x];
        int y_rep = parent[y];
        if (x_rep == y_rep) {
            return;
        }
        parent[y_rep] = x_rep;
    }

    public static int find(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        }

        return find(parent[x], parent);
    }
}
