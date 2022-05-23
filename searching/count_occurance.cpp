#include <iostream>
using namespace std;

int countOccurances(int[], int, int);

int main() {
    int A[] = {1, 2, 2, 2, 2, 3, 3, 4, 5, 6, 7};
    int n = 11;
    int x = 9;
    cout << countOccurances(A, n, x) << endl;
    return 0;
}

int countOccurances(int A[], int n, int x) {
    int l, h, m, firstOcc, lastOcc;
    firstOcc = lastOcc = -1;
    
    // first occurance index
    l = 0;
    h = n - 1;
    while (l <= h) {
        m = (l + h) / 2;
        if (A[m] > x) {
            h = m - 1;
        } else if (A[m] < x) {
            l = m + 1;
        } else {
            if (m == 0 || A[m] != A[m - 1]) {
                firstOcc = m;
                break;
            } else {
                h = m - 1;
            }
        }
    }

    // last occurance index
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
                lastOcc = m;
                break;
            } else {
                l = m + 1;
            }
        }
    }

    if (firstOcc == -1 && lastOcc == -1) {
        return 0;
    }
    return (lastOcc - firstOcc) + 1;
}
