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

4
10 5 15 20

6
10 5 15 20 2 30

*/

int maxSumWithNoConsecutive(int A[], int n) {
    int dp[n];
    dp[0] = A[0];
    dp[1] = max(dp[0], A[1]);
    for (int i = 2; i < n; ++i) {
        dp[i] = max(dp[i - 1], dp[i - 2] + A[i]);
    }
    return dp[n - 1];
}

int maxSumWithNoConsecutiveNoAuxSpace(int A[], int n) {
    int i1 = A[0];
    int i2 = max(A[1], i1);
    for (int i = 2; i < n; ++i) {
        int tmp = max(i2, i1 + A[i]);
        i1 = i2;
        i2 = tmp;
    }
    return i2;
}

int maxSumWithNoConsecutiveRecursive(int A[], int n) {
    if (n == 1) {
        return A[n - 1];
    }
    if (n == 2) {
        return max(A[n - 1], A[n - 2]);
    }
    return max(
        maxSumWithNoConsecutiveRecursive(A, n - 1),
        maxSumWithNoConsecutiveRecursive(A, n - 2) + A[n - 1]
    );
}

void solve() {
	// code here
    int n;
    cin >> n;
    int A[n];
    for (int i = 0; i < n; ++i) {
        cin >> A[i];
    }
    cout << maxSumWithNoConsecutive(A, n) << endl;
    cout << maxSumWithNoConsecutiveRecursive(A, n) << endl;
    cout << maxSumWithNoConsecutiveNoAuxSpace(A, n) << endl;
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