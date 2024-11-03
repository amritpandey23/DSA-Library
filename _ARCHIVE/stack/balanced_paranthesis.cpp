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

bool isBalanced(string exp) {
    /* [({ })] */
    stack<char> s;
    for (int i = 0; i < exp.length(); ++i) {
        char ch = exp[i];
        if (ch == '(' || ch == '[' || ch == '{') {
            s.push(ch);
        } else if (ch == ')' || ch == ']' || ch == '}') {
            if (s.size() == 0) {
                return false;
            }
            if (
                (ch == ')' && s.top() != '(') ||
                (ch == ']' && s.top() != '[') ||
                (ch == '}' && s.top() != '{')
            ) {
                return false;
            } else {
                s.pop();
            }
        }
    }
    return s.size() == 0;
}

void solve() {
	// code here
    string exp;
    cin >> exp;
    cout << isBalanced(exp) << endl;
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