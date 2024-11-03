#include <iostream>
using namespace std;

void printDivisors(int);

int main() {
  int n;
  cin >> n;
  printDivisors(n);
  return 0;
}

void printDivisors(int n) {
  for (int i = 2; i <= n / 2; i++) {
    if (n % i == 0) {
      cout << i << " ";
    }
  }
}
