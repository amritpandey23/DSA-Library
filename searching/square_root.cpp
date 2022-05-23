#include <iostream>
using namespace std;

int sqrt(int);

int main() {
    int n;
    cin >> n;
    cout << sqrt(n) << endl;
}

int sqrt(int n) {
    int l, h, m, ans;
    l = 0;
    h = n;
    while (l <= h) {
        m = (l + h) / 2;
        if (m * m == n) {
            return m;
        }
        if (m * m > n) {
            h = m - 1;
        } else if (m * m < n) {
            ans = m;
            l = m + 1;
        }
    }
    return ans;
}
