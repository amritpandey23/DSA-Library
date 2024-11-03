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

void reverse(int A[], int l, int h) {
    while (l < h) {
        int temp = A[l];
        A[l] = A[h];
        A[h] = temp;
        h--;
        l++;
    }
}

void rotateByK(int A[], int n, int k) {
    k = k % n;
    if (k == 0) {
        return;
    }
    reverse(A, 0, k - 1);
    reverse(A, k, n - 1);
    reverse(A, 0, n - 1);
}

void solve() {
	// code here
    int n, k;
    cin >> n >> k;
    int A[n];
    for (int i = 0; i < n; ++i) {
        cin >> A[i];
    }
    rotateByK(A, n, k);
    for (int i = 0; i < n; ++i) {
        cout << A[i] << " ";
    }
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