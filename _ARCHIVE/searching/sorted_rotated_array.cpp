#include <iostream>
using namespace std;

int search(int[], int, int);

int main() {
    int A[] = {4, 5, 1, 2, 3};
    int x = 4;
    int n = 5;
    cout << search(A, n, x) << endl;
}

int search(int A[], int n, int x) {
    int l, h, m;
    l = 0;
    h = n - 1;
    while (l <= h) {
        m = (l + h) / 2;
        if (A[m] == x) {
            return m;
        }
        if (A[m] > A[l]) {
            if (x >= A[l] && x < A[m]) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        } else {
            if (x > A[m] && x <= A[h]) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
    } 
    return -1;
}
