#include <iostream>
#include <limits.h>
#include <algorithm>
#define String string
using namespace std;

void printUnion(int[], int[], int, int);

int main() {
    int n, m;
    n = 6;
    m = 4;
    int A[] = {1, 2, 2, 3, 4, 5};
    int B[] = {1, 1, 8, 9};
    printUnion(A, B, n, m); 
    return 0;
}

void printUnion(int A[], int B[], int n, int m) {
    int i, j;
    i = j = 0;
    while (i < n && j < m) {
        // cout << "i = " << i << ", j = " << j << endl;
        if (i > 0 && A[i] == A[i - 1]) {
            i++;
            continue;
        }
        if (j > 0 && B[j] == B[j - 1]) {
            j++;
            continue;
        }
        if (A[i] < B[j]) {
            cout << A[i] << " ";
            i++;
        } else if (A[i] > B[j]) {
            cout << B[j] << " ";
            j++;
        } else {
            cout << A[i] << " ";
            i++;
            j++;
        } 
    }
    while (i < n) {
        if (A[i] == A[i - 1]) {
            i++;
            continue;
        }
        cout << A[i] << " ";
        i++;
    }
    while (j < m) {
        if (B[j] == B[j - 1]) {
            j++;
            continue;
        }
        cout << B[j] << " ";
        j++;
    }
    cout << endl;
}
