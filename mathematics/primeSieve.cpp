#include <iostream>
using namespace std;

void printAllPrimesInRange(int);

int main() {
  int n;
  cin >> n;
  printAllPrimesInRange(n);
  return 0;
}

void printAllPrimesInRange(int n) {
  int primes[n + 1];
  for (int i = 0; i <= n; i++) {
    if (i == 0 || i == 1) {
      primes[i] = 0;
    } else {
      primes[i] = i;
    }
  }
  for (int i = 0; i <= n; i++) {
    if (primes[i] != 0) {
      for (int j = i + i; j <= n; j += i) {
        primes[j] = 0;
      }
    }
  }
  for (int i = 0; i <= n; i++) {
    if (primes[i] != 0) {
      cout << i << " ";
    }
  }
}