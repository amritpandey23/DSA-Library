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

6 3 
1 8 30 -5 20 7

*/

int maxSumSubarrayOfSize(int A[], int n, int k) {
    int Ans = 0;
    int windowSum = 0;
    for (int i = 0; i < k; ++i) {
        windowSum += A[i];
    }
    Ans = max(Ans, windowSum);
    for (int i = 0; i < n - k; ++i) {
        windowSum -= A[i];
        windowSum += A[i + k];
        Ans = max(Ans, windowSum);
    }
    return Ans;
}

void solve() {
	// code here
    int n, k;
    cin >> n >> k;
    int A[n];
    for (int i = 0; i < n; ++i) {
        cin >> A[i];
    }
    cout << maxSumSubarrayOfSize(A, n, k) << endl;
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