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

int longestEvenOddSubarray(int A[], int n) {
    int count, parity, Ans;
    count = Ans = 1;
    parity = (A[0] & 1);
    for (int i = 1; i < n; ++i) {
        parity = (A[i - 1] & 1);
        if ((A[i] & 1) != parity) {
            count++;
        } else {
            Ans = max(Ans, count);
            count = 1;
        }
    }
    Ans = max(Ans, count);
    return Ans;
}

void solve() {
	// code here
    int n;
    cin >> n;
    int A[n];
    for (int i = 0; i < n; ++i) {
        cin >> A[i];
    }
    cout << longestEvenOddSubarray(A, n) << endl;
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