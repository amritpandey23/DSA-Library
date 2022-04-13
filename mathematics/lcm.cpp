#include <iostream>
using namespace std;

int gcd(int a, int b)
{
    if (b == 0) {
        return a;
    }

    return gcd(b, a % b);
}

// logarithmic time complexity
int lcm(int a, int b)
{
    return (a * b) / gcd(a, b);
}

int main()
{
    int a, b;
    cin >> a >> b;
    cout << "LCM of " << a << " and " << b << " = " << lcm(a, b) << endl;
    return 0;
}
