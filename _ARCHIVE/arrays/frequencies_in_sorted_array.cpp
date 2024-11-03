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

void printFrequency(int A[], int n) {
    int i, j;
    i = j = 0;
    while (i < n) {
        if (A[i] != A[j]) {
            cout << A[j] << " : " << (i - j) << endl;
            j = i;
        }
        i++;
    }
    if (i != j) {
        cout << A[j] << " : " << (i - j) << endl;
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
    printFrequency(A, n);
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