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

4 10
5 4 6 3
10 40 30 50

*/

int knapsack(int wt[], int val[], int w, int n) {
    if (w < 0) {
        return INT_MIN;
    }
    if (w == 0 || n == 0) {
        return 0;
    }
    int pick_it = val[n - 1] + knapsack(wt, val, w - wt[n - 1], n - 1);
    int dont_pick_it = knapsack(wt, val, w, n - 1);
    return max(pick_it, dont_pick_it);
}

int solveViaMemo(int wt[], int val[], int w, int n, vector<vector<int> > memo) {
    if (w < 0) {
        return INT_MIN;
    }
    if (w == 0 || n == 0) {
        return 0;
    }
    if (memo[n][w] != -1) {
        return memo[n][w];
    }
    memo[n][w] = max(
        val[n - 1] + solveViaMemo(wt, val, w - wt[n - 1], n - 1, memo),
        solveViaMemo(wt, val, w, n - 1, memo)
    );
    return memo[n][w];
}

int knapsackMemo(int wt[], int val[], int w, int n) {
    vector<vector<int> > memo(n + 1, vector<int>(w + 1, -1));
    return solveViaMemo(wt, val, w, n, memo);
}

int knapsackDP(int wt[], int val[], int w, int n) {
    int dp[n + 1][w + 1] = {-1};
    for (int i = 0; i <= n; ++i) {
        for (int j = 0; j <= w; ++j) {
            if (i == 0 || j == 0) {
                dp[i][j] = 0;
            } else {
                // pick it, if possible
                if (j - wt[i - 1] >= 0) {
                    dp[i][j] = max(dp[i][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                }
                // dont pick it
                dp[i][j] = max(dp[i][j], dp[i - 1][j]);
            }
        }
    }
    return dp[n][w];
}

void solve() {
	// code here
    int n, w;
    cin >> n >> w;
    int wt[n], val[n];
    for (int i = 0; i < n; ++i) {
        cin >> wt[i];
    }
    for (int i = 0; i < n; ++i) {
        cin >> val[i];
    }
    cout << knapsack(wt, val, w, n) << endl; 
    cout << knapsackMemo(wt, val, w, n) << endl;
    cout << knapsackDP(wt, val, w, n) << endl;
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