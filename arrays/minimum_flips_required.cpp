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

int countFlips(int A[], int n) {
    int fv = -1;
    if (A[n - 1] == A[0]) {
        // flip zeros
        fv = A[n - 1] == 0 ? 1 : 0;
    } else {
        // flip 1
        fv = A[0];
    }
    int start, end;
    start = end = 0;
    bool in = false;
    int count = 0;
    for (end = 0; end < n; ++end) {
        if (!in && A[end] == fv) {
            in = true;
            start = end;
        } else if (in && A[end] != fv) {
            cout << "From " << start << " to " << (end - 1) << endl;
            count++;
            in = false;
        }
    } 
    return count;
}

void solve() {
	// code here
    int n;
    cin >> n;
    int A[n];
    for (int i = 0; i < n; ++i) {
        cin >> A[i];
    }
    cout << countFlips(A, n) << endl;
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