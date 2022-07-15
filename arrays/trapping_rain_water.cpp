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

int getTrappedVolume1(int A[], int n) {
    /* solution using auxilary space */
    int lmax[n];
    int rmax[n];
    lmax[0] = A[0];
    rmax[n - 1] = A[n - 1];
    for (int i = 1; i < n; ++i) {
        lmax[i] = max(lmax[i - 1], A[i]);
    }
    for (int i = n - 2; i >= 0; --i) {
        rmax[i] = max(rmax[i + 1], A[i]);
    }
    int Ans = 0;
    for (int i = 0; i < n; ++i) {
        Ans += min(lmax[i], rmax[i]) - A[i];
    }
    return Ans;
}

int getTrappedVolume2(int A[], int n) {
    int low, high, maxLow, maxHigh, Ans;
    low = 0;
    high = n - 1;
    maxLow = maxHigh = INT_MIN;
    Ans = 0;
    while (low <= high) {
        if (A[low] <= A[high]) {
            if (A[low] >= maxLow) {
                maxLow = A[low];
            } else {
                Ans += maxLow - A[low];
            }
            low++;
        } else {
            if (A[high] >= maxHigh) {
                maxHigh = A[high];
            } else {
                Ans += maxHigh - A[high];
            }
            high--;
        }
    }
    return Ans;
}

void solve() {
	// code here
    int n;
    cin >> n;
    int A[n];
    for (int i = 0; i < n; ++i) {
        cin >> A[i];
    }
    cout << getTrappedVolume1(A, n) << endl;
    cout << getTrappedVolume2(A, n) << endl;
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