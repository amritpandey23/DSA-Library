#include <iostream>
using namespace std;

/** Recursive solution
*/
int gcd(int a, int b)
{
    if (b == 0) {
        return a;
    }

    return gcd(b, a % b);
}

/** Iterative Solution
*/
int hcf(int a, int b)
{
    while (a != b)
    {
        if (a > b) {
            a = a - b;
        } else {
            b = b - a;
        }
    }

    return a;
}

int main()
{
    int x, y;
    cin >> x >> y;
    cout << "GCD of " << x << " and " << y << " = " << gcd(x, y) << endl;
    cout << "GCD of " << x << " and " << y << " = " << hcf(x, y) << endl;
    return 0;
}
