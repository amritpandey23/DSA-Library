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

int longestCommonSubsequence(string s1, string s2) {
    int n, m;
    n = s1.length();
    m = s2.length();
    int dp[n + 1][m + 1];
    fill(dp[0], dp[0] + n * m, -1);
    for (int i = 0; i <= n; ++i) {
        for (int j = 0; j <= m; ++j) {
            if (i == 0 || j == 0) {
                dp[i][j] = 0;
            } else {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
    }
    return dp[n][m];
}

int longestCommonSubsequenceMemo(string s1, string s2, int n, int m, vector<vector<int> > dp) {
    if (n == 0 || m == 0) {
        dp[n][m] = 0;
        return dp[n][m];
    }
    if (dp[n][m] != -1) {
        return dp[n][m];
    }
    if (s1[n - 1] == s2[m - 1]) {
        dp[n][m] = 1 + longestCommonSubsequenceMemo(s1, s2, n - 1, m - 1, dp);
    } else {
        dp[n][m] = max(
            longestCommonSubsequenceMemo(s1, s2, n - 1, m, dp),
            longestCommonSubsequenceMemo(s1, s2, n, m - 1, dp)
        );
    }
    return dp[n][m];
}

int solveViaMemo(string s1, string s2) {
    int n, m;
    n = s1.length();
    m = s2.length();
    vector<vector<int> > dp(n, vector<int> (m, -1));
    return longestCommonSubsequenceMemo(s1, s2, n, m, dp);
}

void solve() {
	// code here
    string s1, s2;
    cin >> s1 >> s2;
    cout << longestCommonSubsequence(s1, s2) << endl;
    cout << solveViaMemo(s1, s2) << endl;
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