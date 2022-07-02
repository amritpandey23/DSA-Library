#include <bits/stdc++.h>
using namespace std;
#define int 		long long int
#define print(a)	for (auto x : a) cout << x << " "; cout << endl;
#define mod			1e9 + 7

/* 
author: ok-ape 
date: 
*/

void countDistinctInEveryWindow(int A[], const int& n, const int& k) {
	unordered_map<int, int> m;
	for (int i = 0; i < k; ++i) {
		if (m.find(A[i]) == m.end()) {
			m.insert({A[i], 0});
		}
		m[A[i]]++;
	}
	cout << m.size() << " ";
	for (int i = 0; i < n - k; ++i) {
		m[A[i]]--;
		if (m[A[i]] == 0) {
			m.erase(A[i]);
		}
		if (m.find(A[i + k]) == m.end()) {
			m.insert({A[i + k], 0});
		}
		m[A[i + k]]++;
		cout << m.size() << " ";
	}
	cout << endl;
}

void solve() {
	// code here
	int n, k;
	cin >> n >> k;
	int A[n];
	for (int i = 0; i < n; i++) {
		cin >> A[i];
	}
	countDistinctInEveryWindow(A, n, k);
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