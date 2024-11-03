#include <iostream>
using namespace std;

long pow(long, long);

int main() {
  long a, b;
  cin >> a >> b;
  cout << a << " POWER " << b << " = " << pow(a, b) << endl;
  return 0;
}

long pow(long a, long b) {
  long ans = 1;
  while (b > 0) {
    if ((b & 1) == 1) {
      ans *= a;
    }
    a *= a;
    b = b >> 1;
  }
  return ans;
}
