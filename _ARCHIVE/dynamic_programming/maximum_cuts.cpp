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

5
1 2 3

o/p: 5

*/

int maxCutsRecursive(int n, int a, int b, int c) {
    if (n < 0) {
        return -1;
    }
    if (n == 0) {
        return 0;
    }
    return 1 + max(
        maxCutsRecursive(n - a, a, b, c),
        max(
            maxCutsRecursive(n - b, a, b, c),
            maxCutsRecursive(n - c, a, b, c)
        )
    );
}

int solveViaMemo(int n, int a, int b, int c, vector<int> memo) {
    if (n < 0) {
        return -1;
    }
    if (n == 0) {
        return 0;
    }
    if (memo[n] != -1) {
        return memo[n];
    }
    memo[n] = 1 + max(
        solveViaMemo(n - a, a, b, c, memo),
        max(
            solveViaMemo(n - b, a, b, c, memo),
            solveViaMemo(n - c, a, b, c, memo)
        )
    );
    return memo[n];
}

int maxCutsMemo(int n, int a, int b, int c) {
    vector<int> memo(n + 1, -1);
    return solveViaMemo(n, a, b, c, memo);
}

int maxCutsDP(int n, int a, int b, int c) {
    int dp[n + 1] = {-1};
    dp[0] = 0;
    for (int len = 0; len <= n; ++len) {
        if (a <= len) {
            dp[len] = max(dp[len], 1 + dp[len - a]);
        }
        if (b <= len) {
            dp[len] = max(dp[len], 1 + dp[len - b]);
        }
        if (c <= len) {
            dp[len] = max(dp[len], 1 + dp[len - c]);
        }
    }
    return dp[n];
}

void solve() {
	// code here
    int n, a, b, c;
    cin >> n >> a >> b >> c;
    cout << maxCutsRecursive(n, a, b, c) << endl;
    cout << maxCutsMemo(n, a, b, c) << endl;
    cout << maxCutsDP(n, a, b, c) << endl;
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