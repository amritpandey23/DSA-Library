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

void swap(int A[], int x, int y) {
    int temp = A[x];
    A[x] = A[y];
    A[y] = temp;
}

void moveZeros(int A[], int n) {
    int j = n - 1;
    for (int i = n - 1; i >= 0; --i) {
        if (A[i] == 0) {
            swap(A, i, j);
            --j;
        } 
    }
}

void moveZeros2(int A[], int n) {
    int j = 0;
    for (int i = 0; i < n; ++i) {
        if (A[i] != 0) {
            A[j] = A[i];
            if (j != i) {
                A[i] = 0;
            }
            j++;
        }
    }
}

void solve() {
	// code here
    int n;
    cin >> n;
    int A[n];
    for (int i = 0; i < n; ++i) {
        cin >> A[i];
    }
    // moveZeros(A, n);
    moveZeros2(A, n);
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