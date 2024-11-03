#include <bits/stdc++.h>
using namespace std;
#define int 		long long int
#define print(a)	for (auto x : a) cout << x << " "; cout << endl;
#define mod			1e9 + 7

/* 
author: ok-ape 
date: 
*/

int longestCommonSumSpan(int A[], int B[], int n) {
	unordered_map<int, int> m;
	int sum1, sum2, maxLen;
	maxLen = sum1 = sum2 = 0;
	for (int i = 0; i < n; i++) {
		sum1 += A[i] == 0 ? -1 : 1;
		sum2 += B[i] == 0 ? -1 : 1;
		int diff = sum1 - sum2;
		if (diff == 0) {
			maxLen = i + 1;
		}
		if (m.find(diff) == m.end()) {
			m.insert({diff, i});
		}
		maxLen = max(maxLen, i - m[diff]);
	}
	return maxLen;
}

void solve() {
	// code here
	int n;
	cin >> n;
	int A[n], B[n];
	for (int i = 0; i < n; i++) {
		cin >> A[i];
	}
	for (int i = 0; i < n; i++) {
		cin >> B[i];
	}
	cout << longestCommonSumSpan(A, B, n) << endl;
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