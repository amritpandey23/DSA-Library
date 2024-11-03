#include <iostream>
using namespace std;

int firstOccurance(int[], int, int);

int main() {
    int A[] = {1, 2, 2, 2, 2, 4, 5, 6, 6, 7, 8, 9, 10};
    cout << firstOccurance(A, 13, 2) << endl;
    cout << firstOccurance(A, 13, 6) << endl;
    return 0;
}

int firstOccurance(int A[], int n, int x) {
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
            if (m == 0 || A[m - 1] != A[m]) {
                return m;
            } else {
                h = m - 1;
            }
        }
    }
    return -1;
}
