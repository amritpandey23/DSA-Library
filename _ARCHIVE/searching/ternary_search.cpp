#include <iostream>
#define String string
using namespace std;

int ternarySearch(int[], int, int);

/*

8 2 
1 2 2 3 4 5 5 9

*/

int main() {
    int n, x;
    cin >> n >> x;
    int A[n];
    for (int i = 0; i < n; ++i) {
        cin >> A[i];
    }
    cout << ternarySearch(A, n, x) << endl;
    return 0;
}

int ternarySearch(int A[], int n, int x) {
    int l, h, m1, m2;
    l = 0;
    h = n - 1;
    while (l <= h) {
        m1 = l + (h - l) / 3;
        m2 = h - (h - l) / 3;
        if (A[m1] == x) {
            return m1;
        }
        if (A[m2] == x) {
            return m2;
        }
        if (x < A[m1]) {
            h = m1 - 1;
        } else if (x > A[m2]) {
            l = m2 + 1;
        } else {
            l = m1 + 1;
            h = m2 - 1;
        }
    }
    return -1;
}
