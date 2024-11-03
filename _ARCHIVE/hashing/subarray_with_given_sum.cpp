#include <bits/stdc++.h>
using namespace std;
#define int 		long long int
#define print(a)	for (auto x : a) cout << x << " "; cout << endl;
#define mod			1e9 + 7

/* 
author: ok-ape 
date: 
*/

bool subarrayWithGivenSum(int A[], int n, int k) {
    set<int> s;
    int sum = 0;
    for (int i = 0; i < n; ++i) {
        sum += A[i];
        if (s.count(sum - k)) {
            return true;
        }
        s.insert(sum);
    }
    return false;
}

void solve() {
	// code here
    int n, k;
    cin >> n >> k;
    int A[n];
    for (int i = 0; i < n; i++) {
        cin >> A[i];
    }
    cout << subarrayWithGivenSum(A, n, k) << endl;
}

int32_t main() {
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

	#ifndef ONLINE_JUDGE
	freopen("input.txt",  "r",  stdin);
	freopen("output.txt", "w", stdout);
	#endif

	int t = 1;
	// cin >> t;
	while (t--) solve();

	return 0;
}