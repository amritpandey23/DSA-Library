#include <bits/stdc++.h>
using namespace std;
#define int 		long long int
#define print(a)	for (auto x : a) cout << x << " "; cout << endl;
#define mod			1e9 + 7

/* 
author: ok-ape 
date: 
*/

void printPreviousGreaterElements(int A[], int n) {
    stack<int> Stack;
    for (int i = 0; i < n; ++i) {
        while (Stack.size() > 0 && A[Stack.top()] <= A[i]) {
            Stack.pop();
        }
        cout << (Stack.size() == 0 ? -1 : A[Stack.top()]) << " ";
        Stack.push(i);
    }
    cout << endl;
}

void solve() {
	// code here
    int n;
    cin >> n;
    int A[n];
    for (int i = 0; i < n; ++i) {
        cin >> A[i];
    }
    printPreviousGreaterElements(A, n);
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