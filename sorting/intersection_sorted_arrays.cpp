#include <iostream>
#include <limits.h>
#include <algorithm>
#define String string
using namespace std;

void printIntersection(int[], int[], int, int);

int main() {
    int A[] = {1, 2, 2, 2, 3, 4, 5, 6, 9};
    int B[] = {2, 4, 8, 9};
    printIntersection(A, B, 9, 3);
    return 0;
}

void printIntersection(int A[], int B[], int n, int m) {
    int i, j;
    i = 0;
    j = 0;
    while (i < n && j < m) {
        if (i > 0 && A[i] == A[i - 1]) {
            i++;
            continue;
        }
        if (A[i] > B[j]) {
            j++;
        } else if (A[i] < B[j]) {
            i++;
        } else {
            cout << A[i] << " ";
            i++;
            j++;
        }
    }
    cout << endl;
}
