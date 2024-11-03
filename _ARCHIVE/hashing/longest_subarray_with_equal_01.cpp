#include <bits/stdc++.h>
using namespace std;
#define int 		long long int
#define print(a)	for (auto x : a) cout << x << " "; cout << endl;
#define mod			1e9 + 7

/* 
author: ok-ape 
date: 
*/

int longestSubarrayWithEqual01(int A[], int n) {
    map<int, int> m;
    int sum = 0;
    int maxLen = 0;
    for (int i = 0; i < n; i++) {
        sum += A[i] == 0 ? -1 : 1;
        if (sum == 0) {
            maxLen = i + 1;
        }
        if (m.find(sum) == m.end()) {
            m.insert({sum, i});
        }
        if (m.find(sum) != m.end()) {
            maxLen = max(maxLen, i - m[sum]);
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
    cout << longestSubarrayWithEqual01(A, n) << endl;
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