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

int maxElementInRanges(int L[], int R[], const int& n, const int& limit) {
    int count[limit] = {0};
    for (int i = 0; i < n; ++i) {
        count[L[i]]++; // set to 1
        count[R[i] + 1]--; // next element to ending range is set to -1
    }
    int Ans = -1;
    for (int i = 1; i < limit; ++i) {
        count[i] += count[i - 1];
        if (Ans == -1 || count[i] > count[Ans]) {
            Ans = i;
        }
    }
    return Ans;
}

void solve() {
	// code here
    int n, limit;
    cin >> n >> limit;
    int L[n], R[n];
    for (int i = 0; i < n; ++i) {
        cin >> L[i] >> R[i];
    }
    cout << maxElementInRanges(L, R, n, limit) << endl;
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