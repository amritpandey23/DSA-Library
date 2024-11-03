#include <iostream>
#include <vector>
#define String string
using namespace std;

/*

4
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16

*/

void printTranspose(vector<vector<int> > &);

int main() {
    vector<vector<int> > arr {{1, 2, 3, 4},
                               {5, 6, 7, 8},
                               {9, 10, 11, 12},
                               {13, 14, 15, 16}};
    printTranspose(arr);
    return 0;
}

void printTranspose(vector<vector<int> > &arr) {
    for (int i = 0; i < arr.size(); i++) {
        for (int j = i; j < arr[i].size(); j++) {
            int temp = arr[i][j];
            arr[i][j] = arr[j][i];
            arr[j][i] = temp;
        }
    }

    for (int i = 0; i < arr.size(); i++) {
        for (int j = 0; j < arr[i].size(); j++) {
            cout << arr[i][j] << " ";
        }
        cout << endl;
    }
}
