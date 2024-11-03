#include <iostream>
#include <limits.h>
#define String string
using namespace std;

int leftmostRepeating(String &);
int leftmostRepeating2(String &);

int main() {
    String s1 = "GeeksforGeeks";
    String s2 = "abccbd";
    cout << s1 << " = " << leftmostRepeating(s1) << endl;
    cout << s2 << " = " << leftmostRepeating(s2) << endl;
    return 0;
}

int leftmostRepeating(String &s) {
    const int CHAR = 256;
    int count[CHAR] = {0};
    fill(count, count + 256, -1);
    int res = INT_MAX;
    for (int i = 0; i < s.length(); i++) {
        if (count[s[i]] != -1) {
            res = min(res, count[s[i]]);
        } else {
            count[s[i]] = i;
        }
    }
    return (res == INT_MAX ? -1 : res); 
}

int leftmostRepeating2(String &s) {
    bool visited[
}
