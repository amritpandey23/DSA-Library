#include <iostream>
#include <vector>
using namespace std;

void search(int k, vector<int>& subset) {
    if (k == 0) {
        for (int x : subset) {
            cout << x << " ";
        }
        cout << endl;
        return;
    }
    search(k - 1, subset);
    subset.push_back(k);
    search(k - 1, subset);
    subset.pop_back();
}

int main() {
    int k;
    cin >> k;
    vector<int> v;
    search(k, v);
    return 0;
}
