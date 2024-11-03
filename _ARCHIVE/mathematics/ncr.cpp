#include <iostream>
#define String string
using namespace std;

long ncr (int, int);

int main() {
    int n = 5;
    int r = 2;
    cout << ncr(5, 2) << endl;
}

long ncr(int n, int r) {
    if (r == 0) {
        return 1;
    }
    return ncr(n, r - 1) * (n - r + 1) / r;
}
