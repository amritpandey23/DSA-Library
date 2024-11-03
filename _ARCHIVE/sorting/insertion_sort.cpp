#include <iostream>
#include <limits.h>
#include <algorithm>
#define String string
using namespace std;

void insertionSort(int[], int);

int main() {
    int A[] = {1, 2, 3, 0, 90, 12, 11, 89};
    int n = 8;
    insertionSort(A, n);
    for (int n : A) {
        cout << n << " ";
    }
    cout << endl;
    return 0;
}

void insertionSort(int A[], int n) {
    for (int i = 0; i < n; ++i) {
        int j = i - 1;
        int key = A[i];
        while (j >= 0 && A[j] > key) {
            A[j + 1] = A[j];
            j--;
        }
        A[j + 1] = key;
    }
}
