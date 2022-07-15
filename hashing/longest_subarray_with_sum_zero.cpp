#include <bits/stdc++.h>
using namespace std;
#define int 		long long int
#define print(a)	for (auto x : a) cout << x << " "; cout << endl;
#define mod			1e9 + 7

/* 
author: ok-ape 
date: 
*/

int longestSubarrayWithZeroSum(int A[], int n) {
    map<int, int> m;
    int sum = 0;
    int maxLen = 0;
    for (int i = 0; i < n; i++) {
        sum += A[i];
        if (sum == 0) {
            maxLen = i + 1;
        } else {
            if (!m.count(sum)) {
                m[sum] = i;
            } else {
                maxLen = max(maxLen, i - m[sum] + 1);
            }
        }
    }
    return maxLen;
}

void solve() {
	// code here
    int n;
    cin >> n;
    int A[n];
    for (int i = 0; i < n; i++) {
        cin >> A[i];
    }
    cout << longestSubarrayWithZeroSum(A, n) << endl;
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