#include <bits/stdc++.h>
using namespace std;
#define int 		long long int
#define print(a)	for (auto x : a) cout << x << " "; cout << endl;
#define mod			1e9 + 7
#define endl		"\n"

/* 
author: ok-ape 
date: 

We find out the previous smaller and next smaller elements.
And caculate the area taking each index as the smallest 
height.

Time Complexity = O(n)
Space Complexity = O(n)

*/

/* test cases

7
6 2 5 4 1 5 6

*/

void previousSmallerElement(int A[], int ps[], int n) {
    stack<int> s;
    for (int i = 0; i < n; ++i) {
        while (s.size() > 0 && A[s.top()] >= A[i]) {
            s.pop();
        }
        // if not found then keep lower bound
        // as result (-1)
        ps[i] = s.size() == 0 ? -1 : s.top();
        s.push(i);
    }
}

void nextSmallerElement(int A[], int ns[], int n) {
    stack<int> s;
    for (int i = n - 1; i >= 0; --i) {
        while (s.size() > 0 && A[s.top()] >= A[i]) {
            s.pop();
        }
        // if not found then keep the upper bound
        // as result (length of array)
        ns[i] = s.size() == 0 ? n : s.top();
        s.push(i);
    }
}

int largestHistogramArea(int A[], int n) {
    int ps[n] = {0};
    int ns[n] = {0};
    previousSmallerElement(A, ps, n);
    nextSmallerElement(A, ns, n);
    int area = 0;
    for (int i = 0; i < n; ++i) {
        int a = A[i];
        // mind these calculations
        // difficult to visualize
        a += (i - (ps[i] + 1)) * A[i];
        a += ((ns[i] - 1) - i) * A[i];
        area = max(area, a);
    }
    return area;
}

void solve() {
	// code here
    int n;
    cin >> n;
    int A[n];
    for (int i = 0; i < n; i++) {
        cin >> A[i];
    }
    cout << largestHistogramArea(A, n) << endl;
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