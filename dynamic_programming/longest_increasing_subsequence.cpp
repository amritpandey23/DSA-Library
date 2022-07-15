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

8
4 10 6 5 8 11 2 20

*/

int longestIncreasingSubsequence(const int A[], int n) {
    /* O(n^2) solution */
    int lis[n] = {INT_MIN};
    lis[0] = 1;
    int len = 0;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < i; ++j) {
            if (A[i] > A[j]) {
                lis[i] = max(lis[i], 1 + lis[j]);
            }
            len = max(len, lis[i]);
        }
    }
    return len;
}

int ceilSearch(const int A[], int n, int x) {
    int low, high, mid, Ans;
    low = 0;
    high = n - 1;
    while (low <= high) {
        mid = (low + high) / 2;
        if (A[mid] == x) {
            return mid;
        }
        if (A[mid] < x) {
            low = mid + 1;
        } else {
            Ans = mid;
            high = mid - 1;
        }
    }
    return Ans;
}

int longestIncreasingSubsequence2(const int A[], int n) {
    int tail[n];
    int len = 0;
    for (int i = 0; i < n; ++i) {
        if (len == 0 || A[i] > tail[len - 1]) {
            tail[len] = A[i];
            len++;
        } else {
            int ceilIdx = ceilSearch(tail, len, A[i]);
            tail[ceilIdx] = A[i];
        }
    }
    return len;
}

void solve() {
	// code here
    int n;
    cin >> n;
    int A[n];
    for (int i = 0; i < n; ++i) {
        cin >> A[i];
    }
    cout << longestIncreasingSubsequence(A, n) << endl;
    cout << longestIncreasingSubsequence2(A, n) << endl;
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