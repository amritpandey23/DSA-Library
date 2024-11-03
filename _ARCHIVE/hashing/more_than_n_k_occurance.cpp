#include <bits/stdc++.h>
using namespace std;
#define int 		long long int
#define print(a)	for (auto x : a) cout << x << " "; cout << endl;
#define mod			1e9 + 7

/* 
author: ok-ape 
date: 
*/

int mooreVotingAlgoForNByK(int A[], const int& n, const int& k) {
    unordered_map<int, int> m;
    for (int i = 0; i < n; i++) {
        if (m.find(A[i]) != m.end()) {
            m[A[i]]++;
        } else if (m.size() < k) {
            m[A[i]] = 1;
        } else {
            /* iterate over the elements and decrease the
            count by 1 and remove those elements whoes count
            reaches to 0.
            */
            // for (auto itr = m.begin(); itr != m.end(); ++itr) {
            //     cout << "yes" << endl;
            //     itr->second -= 1;
            //     if (itr->second == 0) {
            //         m.erase(itr->first);
            //     }
            // }
        }
    }
    for (auto itr : m) {
        cout << itr.first << " ";
    }
    cout << endl;
}

int moreThanNByK(int A[], const int& n, const int& k) {
    unordered_map<int, int> m;
    for (int i = 0; i < n; i++) {
        if (m.find(A[i]) == m.end()) {
            m.insert({A[i], 0});
        }
        m[A[i]]++;
        if (m[A[i]] >= n / k) {
            return A[i];
        }
    }
    return -1;
}

void solve() {
	// code here
    int n, k;
    cin >> n >> k;
    int A[n];
    for (int i = 0; i < n; i++) {
        cin >> A[i];
    }
    cout << moreThanNByK(A, n, k) << endl;
    // mooreVotingAlgoForNByK(A, n, k);
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