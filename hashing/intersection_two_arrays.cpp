#include <bits/stdc++.h>
using namespace std;
#define int 		long long int
#define print(a)	for (auto x : a) cout << x << " "; cout << endl;
#define mod			1e9 + 7

/* 
author: ok-ape 
date: 
*/

void printIntersection(int A[], int B[], int n, int m) {
    set<int> s;
    set<int> Ans;
    for (int i = 0; i < n; i++) {
        s.insert(A[i]);
    }
    for (int j = 0; j < m; j++) {
        if (s.count(B[j]) > 0) {
            Ans.insert(B[j]);
        }
    }
    for (auto itr = Ans.begin(); itr != Ans.end(); ++itr) {
        cout << (*itr) << " ";
    }
    cout << endl;
}

void solve() {
	// code here
    int n, m;
    cin >> n >> m;
    int A[n];
    int B[m];
    for (int i = 0; i < n; i++) {
        cin >> A[i];
    }
    for (int j = 0; j < m; j++) {
        cin >> B[j];
    }
    printIntersection(A, B, n, m);
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