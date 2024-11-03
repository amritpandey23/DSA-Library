#include <iostream>
#include <limits.h>
#include <algorithm>
#define String string
using namespace std;

void selectionSort(int[], int);

int main() {
    int A[] = {1, 2, 3, 0, 90, 12, 11, 89};
    int n = 8;
    selectionSort(A, n);
    for (int n : A) {
        cout << n << " ";
    }
    cout << endl;
    return 0;
}

void selectionSort(int A[], int n) {
    for (int i = 0; i < n; i++) {
        int min_idx = i;
        for (int j = i + 1; j < n; j++) {
            if (A[j] < A[min_idx]) {
                min_idx = j;
            }
        }
        if (min_idx != i) {
            int temp = A[i];
            A[i] = A[min_idx];
            A[min_idx] = temp;
        }
    }
}
