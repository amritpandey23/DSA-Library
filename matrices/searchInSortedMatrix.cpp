#include <iostream>
#include <vector>
#define String string
using namespace std;

void search(vector<vector<int> > &, int);

int main() {
    vector<vector<int> > mat{
        {10, 20, 30, 40},
        {15, 25, 35, 45},
        {27, 29, 37, 48},
        {32, 33, 39, 50}
    };
    search(mat, 29);
    return 0;
}

void search(vector<vector<int> > &mat, int x) {
    int i, j;
    i = 0;
    j = mat[0].size() - 1;
    while (i < mat.size() && j >= 0) {
        if (mat[i][j] == x) {
            cout << "(" << i << ", " << j << ")" << endl;
            return;
        }
        if (x < mat[i][j]) {
            j--;
        } else {
            i++;
        }
    }
    cout << "Not Found" << endl;
}
