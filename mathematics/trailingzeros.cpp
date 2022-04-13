#include <iostream>
using namespace std;

int fact(int n)
{
    if (n == 0) {
        return 1;
    }
    return n * fact(n - 1);
}

int trailing_zeros(int n)
{
    int res = 0;
    for (int i = 5; i <= n; i = i * 5) {
        if (n / i == 0) {
            break;
        }
        res += (n / i);
    }
    return res;
}

int main()
{
    int n;
    cin >> n;
    cout << "Trailing zeros in factorial of " << n << " = " << trailing_zeros(fact(n)) << endl;
    return 0;
}
