#include <iostream>
using namespace std;

// can be used for splitting a number
// into factors whoes product
// will lead to the actual number

void printFactors(int);

int main()
{
    int n;
    cin >> n;
    printFactors(n);
    return 0;
}

void printFactors(int n)
{
    if (n <= 1)
    {
        return;
    }

    while (n % 2 == 0)
    {
        cout << 2 << " ";
        n = n / 2;
    }

    while (n % 3 == 0)
    {
        cout << 3 << " ";
        n = n / 3;
    }

    for (int i = 5; i * i <= n; i += 6)
    {
        while (n % i == 0)
        {
            cout << i << " ";
            n = n / i;
        }
        while (n % (i + 2) == 0)
        {
            cout << (i + 2) << " ";
            n = n / (i + 2);
        }
    }

    if (n > 3)
    {
        cout << n << " ";
    }
}
