#include <iostream>
using namespace std;

bool checkSubsequence(const string &, const string &);
bool checkSubsequenceRecursive(const string &, const string &, int, int);

int main() {
    string s1 = "ABCD";
    string s2 = "ADE";
    cout << (checkSubsequence(s1, s2) == 1 ? "YES" : "NO") << endl;
    cout << (checkSubsequenceRecursive(s1, s2, 0, 0) == 1 ? "YES" : "NO") << endl;
    return 0;
}

bool checkSubsequence(const string &s1, const string &s2) {
    if (s1.length() < s2.length()) {
        return false;
    }
    int i, j;
    i = j = 0;

    while (i < s1.length()) {
        if (s1[i] == s2[j]) {
            j++;
        }
        if (j == s2.length()) {
            return true;
        }
        i++;
    }

    return false;
}

bool checkSubsequenceRecursive(const string &s1, const string &s2, int i, int j) {
    if (j == s2.length()) {
        return true;
    }
    if (s2.length() > s1.length() || i == s1.length()) {
        return false;
    }
    if (s1[i] == s2[j]) {
        return checkSubsequenceRecursive(s1, s2, i + 1, j + 1);
    }
    return checkSubsequenceRecursive(s1, s2, i + 1, j);
}
