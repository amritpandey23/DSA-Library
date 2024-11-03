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

saturday
sunday

o/p: 3

*/

int editDistanceRecursive(string s1, string s2, int n, int m) {
    // base conditions:
    if (n == 0) {
        return m;
    }
    if (m == 0) {
        return n;
    }
    // branch conditions
    if (s1[n - 1] == s2[m - 1]) {
        return editDistanceRecursive(s1, s2, n - 1, m - 1);
    }
    return 1 + min(
        editDistanceRecursive(s1, s2, n, m - 1), 
        min(
            editDistanceRecursive(s1, s2, n - 1, m), 
            editDistanceRecursive(s1, s2, n - 1, m - 1)
        )
    );
}

int editDistanceMemo(string s1, string s2, int n, int m, vector<vector<int> > memo) {
    // base conditions:
    if (n == 0) {
        return m;
    }
    if (m == 0) {
        return n;
    }
    if (memo[n][m] != -1) {
        return memo[n][m];
    }
    // branch conditions
    if (s1[n - 1] == s2[m - 1]) {
        memo[n][m] = editDistanceRecursive(s1, s2, n - 1, m - 1);
    } else {
        memo[n][m] = 1 + min(
            editDistanceRecursive(s1, s2, n, m - 1), 
            min(
                editDistanceRecursive(s1, s2, n - 1, m), 
                editDistanceRecursive(s1, s2, n - 1, m - 1)
            )
        );
    }
    return memo[n][m];
}

int solveViaMemo(string s1, string s2, int n, int m) {
    vector<vector<int> > memo(n + 1, vector<int>(m + 1, -1));
    return editDistanceMemo(s1, s2, n, m, memo);
}

int editDistanceDP(string s1, string s2, int n, int m) {
    vector<vector<int> > dp(n + 1, vector<int>(m + 1, -1));
    for (int i = 0; i <= n; ++i) {
        for (int j = 0; j <= m; ++j) {
            if (i == 0) {
                dp[i][j] = j;
            } else if (j == 0) {
                dp[i][j] = i;
            } else {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + min(
                        dp[i - 1][j - 1], 
                        min(
                            dp[i - 1][j],
                            dp[i][j - 1]
                        )
                    );
                }
            }
        }
    }
    return dp[n][m];
}

void solve() {
	// code here
    string s1, s2;
    cin >> s1 >> s2;
    cout << editDistanceRecursive(s1, s2, s1.length(), s2.length()) << endl;
    cout << solveViaMemo(s1, s2, s1.length(), s2.length()) << endl;
    cout << editDistanceDP(s1, s2, s1.length(), s2.length()) << endl;
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