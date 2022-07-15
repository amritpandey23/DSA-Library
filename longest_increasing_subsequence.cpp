#include <iostream>
using namespace std;

int lis(int[], int);
int lisEfficient(int[], int);
int ceilOf(int[], int, int);

int main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);

    int n;
    cin >> n;
    int A[n];
    for (int i = 0; i < n; i++) {
        cin >> A[i];
    }
    // cout << lis(A, n) << endl;
    cout << lisEfficient(A, n) << endl;
}

int lis(int A[], int n) {
    int LIS[n];
    LIS[0] = 1;
    for (int i = 1; i < n; i++) {
        int maxIdx = -1;
        for (int j = 0; j <= i - 1; j++) {
            if (A[j] < A[i] && (maxIdx == -1 || A[j] > A[maxIdx])) {
                maxIdx = j;
            }
        }
        LIS[i] = maxIdx == -1 ? 1 : LIS[maxIdx] + 1;
    }
    int maxSize = 0;
    for (int i = 0; i < n; i++) {
        maxSize = max(maxSize, LIS[i]);
    }
    return maxSize;
}

int lisEfficient(int A[], int n) {
    int tail[n] = {0};
    int len = 1;
    tail[0] = A[0];
    for (int i = 1; i < n; i++) {
        if (A[i] > tail[len - 1]) {
            tail[len] = A[i];
            len++;
        } else {
            int ceilIdx = ceilOf(tail, A[i], len); 
            tail[ceilIdx] = A[i];
        }
    }
    cout << endl;
    return len;
}

int ceilOf(int A[], int x, int n) {
    int m, ans, l, h;
    l = 0;
    h = n - 1;
    ans = -1;
    while (l <= h) {
        m = l + (h - l) / 2;
        if (A[m] == x) {
            return m;
        }
        if (A[m] < x) {
            l = m + 1;
        } else {
            ans = m;
            h = m - 1;
        }
        return ans;
    }
}
