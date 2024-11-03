#include <iostream>
#include <cmath>
#define String string
#define M 101
using namespace std;

void rh(String &, int);
void search(const String &, const String &);

int main() {
    String s = "Amrit Pandey is a cool boy!";
    rh(s, 3);
    String pat = "Pandey";
    search(s, pat);
    return 0;
}

void rh(String &s, int size) {
    int h = 0;
    int d = 10;
    for (int i = 0; i < size; i++) {
        h = (h * d) + s[i];
        h = h % M;
    }
    cout << "First Hash = " + h << endl;
    for (int i = size; i < s.length(); i++) {
        // cout << "Delete = " << s[i - size] << " Append = " << s[i] << " ";
        h -= (int)(pow(d, size - 1) * s[i - size]) % M;
        h += ((h * d + s[i]) % M + M) % M;
        // cout << h << endl;
    }
}

void search(const String &s, const String &pat) {
    int h = 0;
    int d = 10;
    int size = pat.length() - 1;
    int mh = 0;
    for (int i = 0; i < size + 1; i++) {
        mh = (((mh * d) + pat[i]) % M + M) % M;
    }
    cout << "Hash for Pandey = " << mh << endl;
    for (int i = 0; i < size; i++) {
        h = ((h * d) + s[i] % M + M) % M;
    }
    cout << h << endl;
    for (int i = size; i < s.length(); i++) {
        h -= ((int)(pow(d, size - 1) * s[i - size]) % M);
        h += ((h * d + s[i]) % M + M) % M;
        // if (i == 6) {
        //     for (int k = i - size + 1; k <= i; k++) {
        //         cout << s[k];
        //     }
        //     cout << endl;
        //     cout << "Hash value = " << h << endl;
        // }
        cout << h << " ";
        for (int k = i - size; k <= i; k++) {
            cout << s[k];
        }
        cout << endl;
        if (h == mh) {
            bool found = true;
            for (int j = 0; j < size; j++) {
                if (s[i + j] != pat[j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                cout << i << endl;
            }
        }
    }
}

