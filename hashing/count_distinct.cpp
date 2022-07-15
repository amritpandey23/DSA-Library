#include <bits/stdc++.h>
using namespace std;
#define int 		long long int
#define print(a)	for (auto x : a) cout << x << " "; cout << endl;
#define mod			1e9 + 7

/* 
author: ok-ape 
date: 
*/

int countDistinctElements(int A[], int n) {
    set<int> s;
    for (int i = 0; i < n; i++) {
        s.insert(A[i]);
    }
    return s.size();
}

void printDistinctElements(int A[], int n) {
    set<int> s;
    for (int i = 0; i < n; i++) {
        s.insert(A[i]);
    }
    for (auto itr = s.rbegin(); itr != s.rend(); ++itr) {
        cout << *itr << " ";
    }
    cout << endl;
}

void solve() {
	// code here
    int n;
    cin >> n;
    int A[n];
    for (int i = 0; i < n; i++) {
        cin >> A[i];
    }
    cout << countDistinctElements(A, n) << endl;
    printDistinctElements(A, n);
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