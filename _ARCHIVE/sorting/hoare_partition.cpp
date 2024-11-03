#include <iostream>
#include <limits.h>
#include <algorithm>
#define String string
using namespace std;

int hoarePartition(int[], int);
void swap(int[], int, int);

int main() {
    int A[] = {90, 89, 78, 1, 2, 3, 4, 5, 5};
    int n = 9;
    int peg = hoarePartition(A, n);
    cout << "Peg = " << peg << endl;
    for (int i : A) {
        cout << i << " ";
    }
    cout << endl;
    return 0;
}

int hoarePartition(int A[], int n) {
    int i, j, pivot;
    pivot = A[n - 1];
    i = 0;
    j = n - 2;
    while (i < j) {
        while (A[i] < pivot) i++;
        while (A[j] > pivot) j--;
        swap(A, i, j);
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
