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

6
10 5 2 3 6

*/

int countSubsets(int A[], int n, int sum) {
    if (sum == 0) {
        return 1;
    }
    if (sum < 0 || n == 0) {
        return 0;
    }
    return 
        countSubsets(A, n - 1, sum - A[n - 1]) + 
        countSubsets(A, n - 1, sum);
}

int solveViaMemo(int A[], int n, int sum, vector<vector<int> >memo) {
    if (sum == 0) {
        return 1;
    }
    if (sum < 0 || n == 0) {
        return 0;
    }
    if (memo[n][sum] != -1) {
        return memo[n][sum];
    }
    memo[n][sum] = solveViaMemo(A, n - 1, sum, memo) + solveViaMemo(A, n - 1, sum - A[n - 1], memo);
    return memo[n][sum];
}

int countSubsetsMemo(int A[], int n, int sum) {
    vector<vector<int> >memo(n + 1, vector<int>(sum + 1, -1));
    return solveViaMemo(A, n, sum, memo);
}

int countSubsetsDP(int A[], int n, int sum) {
    vector<vector<int> >dp(n + 1, vector<int>(sum + 1, 0));
    for (int i = 0; i <= n; ++i) {
        for (int j = 0; j <= sum; ++j) {
            if (i == 0 && j == 0) {
                dp[i][j] = 1;
            } else if (i == 0) {
                dp[i][j] = 0;
            } else if (j == 0) {
                dp[i][j] = 1;
            } else {
                dp[i][j] = dp[i - 1][j];
                if (j - A[i - 1] >= 0) {
                    dp[i][j] += dp[i - 1][j - A[i - 1]];
                }
            }
        }
    }
    return dp[n][sum];
}

void solve() {
	// code here
    int n, k;
    cin >> n >> k;
    int A[n];
    for (int i = 0; i < n; ++i) {
        cin >> A[i];
    }
    cout << countSubsets(A, n, k) << endl;
    cout << countSubsetsMemo(A, n, k) << endl;
    cout << countSubsetsDP(A, n, k) << endl;
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