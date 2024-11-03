#include <iostream>
#include <limits.h>
#include <algorithm>
#define String string
using namespace std;

void bubbleSort(int[], int);

int main() {
    int A[] = {1, 2, 3, 0, 90, 12, 11, 89};
    int n = 8;
    bubbleSort(A, n);
    for (int n : A) {
        cout << n << " ";
    }
    cout << endl;
    return 0;
}

void bubbleSort(int A[], int n) {
    for (int i = 0; i < n; i++) {
        bool doneSwap = false;
        for (int j = 0; j < n - i; j++) {
            if (A[j] > A[j + 1]) {
                int temp = A[j];
                A[j] = A[j + 1];
                A[j + 1] = temp;
                doneSwap = true;
            }
        }
        if (!doneSwap) {
            break;
        }
    }
}
