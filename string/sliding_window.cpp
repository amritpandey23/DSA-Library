#include <iostream>
#define String string
using namespace std;

void print(String &, int);

int main() {
    String t = "Amrit Pandey";
    print(t, 2);
    return 0;
}

void print(String &s, int size) {
    if (size >= s.length()) {
        cout << s << endl;
    }
    for (int i = 0; i < (s.length() - size + 1); i++) {
        // cout << "i = " << i << " size + i = " << (size + i) << " ";
        cout << s.substr(i, size) << endl;
    }
}
