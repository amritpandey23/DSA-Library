#include <iostream>
#define String string
using namespace std;

bool isAnagram(String &, String &);

int main() {
    String s1 = "Amrit";
    String s2 = "mAirt";
    cout << (isAnagram(s1, s2) ? "YES" : "NO") << endl;
    return 0;
}

bool isAnagram(String &s1, String &s2) {
    if (s1.length() != s2.length()) {
        return false;
    }
    const int CHAR = 265;
    char count[CHAR] = {0};
    for (int i = 0; i < s1.length(); i++) {
        count[s1[i]]++;
        count[s2[i]]--;
    }
    for (int i = 0; i < CHAR; i++) {
        if (count[i] != 0) {
            return false;
        }
    }
    return true;
}
