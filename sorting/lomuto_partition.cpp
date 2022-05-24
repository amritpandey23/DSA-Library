#include <iostream>
#include <limits.h>
#include <algorithm>
#define String string
using namespace std;

int lomutoPartition(int[], int);
void swap(int[], int, int);

int main() {
    int A[] = {90, 89, 78, 1, 2, 3, 4, 5, 5};
    int n = 9;
    int peg = lomutoPartition(A, n);
    cout << "Peg = " << peg << endl;
    for (int i : A) {
        cout << i << " ";
    }
    cout << endl;
    return 0;
}

int lomutoPartition(int A[], int n) {
    int i, j, pivot;
    i = -1;
    j = 0;
    pivot = A[n - 1];
    while (j < n - 1) {
        if (A[j] <= pivot) {
            i++;
            swap(A, i, j);
        }
        j++;
    }
    i++;
    swap(A, i, n - 1);
    return i;
}

void swap(int A[], int x, int y) {
    int temp = A[x];
    A[x] = A[y];
    A[y] = temp;
}
