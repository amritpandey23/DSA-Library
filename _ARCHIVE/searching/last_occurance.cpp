#include <iostream>
using namespace std;

int lastOccurance(int[], int, int);

int main() {
    int A[] = {1, 2, 3, 3, 3, 3, 4, 5, 6, 6, 6, 7};
    int n = 12;
    int x = 6;
    cout << lastOccurance(A, n, x) << endl;
}

int lastOccurance(int A[], int n, int x) {
    int l, h, m;
    l = 0;
    h = n - 1;
    while (l <= h) {
        m = (l + h) / 2;
        if (A[m] > x) {
            h = m - 1;
        } else if (A[m] < x) {
            l = m + 1;
        } else {
            if (m == n - 1 || A[m] != A[m + 1]) {
                return m;
            } else {
                l = m + 1;
            }
        }
    }
    return -1;
}
