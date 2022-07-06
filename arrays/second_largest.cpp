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
1 2 -1 3 4 6

*/

int secondLargest(int A[], int n) {
    int max, secondMax;
    max = secondMax = INT_MIN;
    for (int i = 0; i < n; ++i) {
        if (A[i] >= max) {
            secondMax = max;
            max = A[i];
        } else if (A[i] >= secondMax) {
            secondMax = A[i];
        }
    }
    return secondMax;
}

void solve() {
	// code here
    int n;
    cin >> n;
    int A[n];
    for (int i = 0; i < n; ++i) {
        cin >> A[i];
    }
    cout << secondLargest(A, n) << endl;
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