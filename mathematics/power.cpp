#include <iostream>
using namespace std;

int pow(int, int);

int main() {
    int n;
    cin >> n;
    cout << "Power of 2 base 10 = " << pow(2, 10) << endl;
    return 0;
}

int pow(int n, int x) {
    if (x == 0) {
        return 1;
    }
    if (x % 2 == 0) {
        return pow(n, x / 2) * pow(n, x / 2);
    }
    return pow(n, x / 2) * pow(n, x / 2) * n;
}
