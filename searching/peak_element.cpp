#include <iostream>
using namespace std;

int peakElement(int[], int);

int main() {
    int A[] = {1, 100, 3, 10, 5, 6, 90, 10};
    int n = 8;
    cout << peakElement(A, n) << endl;
}

int peakElement(int A[], int n) {
    int l, h, m;
    l = 0;
    h = n - 1;
    while (l <= h) {
        m = (l + h) / 2;
        if ((m == 0 || A[m] > A[m + 1]) && (m == n - 1 || A[m] > A[m - 1])) {
            return m;
        }
        if (A[m - 1] > A[m]) {
            h = m - 1;
        } else {
            l = m + 1;
        }
    }
    return -1;
}
