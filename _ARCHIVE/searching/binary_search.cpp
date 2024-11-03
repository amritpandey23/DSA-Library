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

int binarySearch(int A[], int n, int x) {
    int l, h, m;
    l = 0;
    h = n - 1;
    while (l <= h) {
        m = l + (h - l) / 2;
        if (A[m] == x) {
            return m;
        }
        if (A[m] < x) {
            l = m + 1;
        } else {
            h = m - 1;
        }
    }
    return -1;
}

void solve() {
	// code here
    int n, x;
    cin >> n >> x;
    int A[n];
    for (int i = 0; i < n; ++i) {
        cin >> A[i];
    }
    sort(A, A + n);
    cout << binarySearch(A, n, x) << endl;
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