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

int countBST(int n) {
	int dp[n + 1] = {0};
	dp[0] = 1;
	for (int i = 1; i <= n; ++i) {
		for (int j = 0; j < i; ++j) {
			dp[i] += dp[j] * dp[i - j - 1];
		}
	}
	return dp[n];
}

void solve() {
	// code here
	int n;
	cin >> n;
	cout << countBST(n) << endl;
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