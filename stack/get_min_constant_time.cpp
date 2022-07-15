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

9
0 20
0 10
2
0 5
2
1
2
1
2

*/

void push(stack<int>& s, stack<int>& minS, int x) {
    s.push(x);
    if (x <= minS.top()) {
        minS.push(x);
    }
}

int pop(stack<int>& s, stack<int>& minS) {
    if (s.size() == 0) {
        return INT_MIN;
    }
    int last = s.top();
    if (last == minS.top()) {
        minS.pop();
    }
    s.pop();
    return last;
}

int getMin(stack<int>& s, stack<int>& minS) {
    if (minS.size() == 0) {
        return INT_MAX;
    }
    return minS.top();  
}

void solve() {
	// code here
    stack<int> s, minS;
    int ops, op;
    cin >> ops;
    for (int i = 0; i < ops; ++i) {
        cin >> op;
        if (op == 0) {
            int x;
            cin >> x;
            push(s, minS, x);
            cout << "PUSH OK" << endl;
        } else if (op == 1) {
            int x = pop(s, minS);
            cout << "POP = " << x << endl;
        } else if (op == 2) {
            int x = getMin(s, minS);
            cout << "MIN = " << x << endl;
        }
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