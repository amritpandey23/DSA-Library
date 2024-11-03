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

/*

How would you find the diameter of the tree?

Here you are solving two problems at the same time. First problem if there exist
a leaf node from current node that we are finding. Second problem is the farthest
left or right leaf node. The distance between these two is our answer.

*/

int burnTree(TreeNode* root, int leaf, int& dist) {
    if (!root) {
        return 0;
    }
    if (root->val == leaf) {
        dist = 0;
        return 1;
    }
    int ldist, rdist;
    ldist = rdist = -1;
    lh = burnTree(root->left, leaf, ldist);
    rh = burnTree(root->right, leaf, rdist);
    if (lh != -1) {
        dist = ldist + 1;
        res = max(res, rh + dist); // set the maximum length as answer
    } else if (rh != -1) {
        dist = rdist + 1;
        res = max(res, lh + dist); // set the maximum length as answer
    }
    return 1 + max(rh, lh); // returning the max height
}

void solve() {
	// code here
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