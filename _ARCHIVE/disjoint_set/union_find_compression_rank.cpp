#include <bits/stdc++.h>
using namespace std;
#define int 		long long int
#define print(a)	for (auto x : a) cout << x << " "; cout << endl;
#define mod			1e9 + 7
#define endl		"\n"

/* 
author: ok-ape 
date: 
*/

/* test cases


*/

class Edge {
public:
    int src;
    int dest;
    int wt;
    Edge() {
        this->src = 0;
        this->dest = 0;
        this->wt = 0;
    }
};

int find(int x, int parent[]) {
    if (x == parent[x]) {
        return x;
    }
    parent[x] = find(parent[x], parent);
    return parent[x];
}

void union_op(int x, int y, int parent[], int rank[]) {
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
        rank[x_rep]++;
        parent[y_rep] = x_rep;
    }
}

int kruskal(Edge edges[], int n, int v) {
    sort(edges, edges + n, [](const auto& p1, const auto& p2) {
        return p1.wt - p2.wt;
    });
    int parent[n];
    int rank[n];
    for (int i = 0; i < n; ++i) {
        parent[i] = i;
        rank[n] = 0;
    }
    int cost = 0;
    for (int i = 0; i < n && v > 1; i++) {
        Edge e = edges[i];
        if (find(e.src, parent) != find(e.dest, parent)) {
            union_op(e.src, e.dest, parent, rank);
            cost += e.wt;
            v--;
        }
    }
    return cost;
}

void solve() {
	// code here
    int n, v;
    cin >> n >> v;
    Edge edges[n];
    for (int i = 0; i < n; ++i) {
        cin >> edges[i].src;
        cin >> edges[i].dest;
        cin >> edges[i].wt; 
    }
    cout << kruskal(edges, n, v) << endl;
}

int32_t main() {
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

	#ifndef ONLINE_JUDGE
	freopen("input.txt",  "r",  stdin);
	freopen("output.txt", "w", stdout);
	freopen("error.txt", "w", stderr);
	#endif

	int t = 1;
	// cin >> t;
	while (t--) solve();

	return 0;
}