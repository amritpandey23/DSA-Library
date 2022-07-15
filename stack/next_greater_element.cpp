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

void printNextGreaterElements(int A[], int n) {
    /* same as previous greater element, only that
    we iterate it in reverse order */
    stack<int> Stack;
    int Ans[n] = {-1};
    for (int i = n - 1; i >= 0; --i) {
        while (Stack.size() > 0 && A[Stack.top()] <= A[i]) {
            Stack.pop();
        }
        Ans[i] = (Stack.size() == 0 ? -1 : A[Stack.top()]);
        Stack.push(i);
    }
    for (int i = 0; i < n; ++i) {
        cout << Ans[i] << " ";
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
    printNextGreaterElements(A, n);
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