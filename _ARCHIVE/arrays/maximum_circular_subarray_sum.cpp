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

int getMaxSum(int A[], int n) {
    int netSum = 0;
    for (int i = 0; i < n; ++i) {
        netSum += A[i];
    }
    int minSum = INT_MAX;
    int sum = 0;
    for (int i = 0; i < n; ++i) {
        sum = min(sum + A[i], A[i]);
        minSum = min(minSum, sum);
    }
    return netSum - minSum;
}

void solve() {
	// code here
    int n;
    cin >> n;
    int A[n];
    for (int i = 0; i < n; ++i) {
        cin >> A[i];
    }
    cout << getMaxSum(A, n) << endl;
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