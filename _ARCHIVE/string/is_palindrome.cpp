#include <iostream>
#define String string
using namespace std;

bool isPalindrome(const string &);

int main() {
    String a = "Amrit";
    cout << (isPalindrome(a) ? "YES" : "NO") << endl;
    return 0;
}

bool isPalindrome(const String &s) {
    int i, j;
    i = 0;
    j = s.length() - 1;
    while (i < j) {
        if (s[i] != s[j]) {
            return false;
        }
    }
    return true;
}
