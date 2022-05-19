#include <iostream>
#define String string
using namespace std;

void search(String &, String &);
void search2(String &, String &);

int main() {
    String s1 = "AAAAAAAAA";
    String s2 = "AA";
    String s3 = "ABABAB";
    String s4 = "AB";
    search(s1, s2);
    cout << endl;
    search2(s3, s4);
    return 0;
}

void search(String &s1, String &s2) {
    int n, m;
    n = s1.length();
    m = s2.length();
    for (int i = 0; i < (n - m + 1); i++) {
        if (s1[i] == s2[0]) {
            int j = 0;
            while (s2[j] == s1[i + j]) {
                j++;
            }
            if (j >= m) {
                cout << i << " ";
            }
        }
    }
}

/* optimisation for distinct characters */
void search2(String &s1, String &s2) {
    int n, m;
    n = s1.length();
    m = s2.length();
    for (int i = 0; i < (n - m + 1); i++) {
        if (s1[i] == s2[0]) {
            int j = 0;
            while (s2[j] == s1[i + j]) {
                j++;
            }
            if (j >= m) {
                cout << i << " ";
            }
            if (j > 0) {
                i += j - 1; 
            }
        }
    }
}
