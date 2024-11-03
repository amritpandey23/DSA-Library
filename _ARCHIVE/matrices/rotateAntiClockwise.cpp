#include <iostream>
#include <vector>
#define String string
using namespace std;

void rotate(vector<vector<int> > &);

int main() {
    vector<vector<int> > arr {{1, 2, 3, 4},
                               {5, 6, 7, 8},
                               {9, 10, 11, 12},
                               {13, 14, 15, 16}};
    rotate(arr);
    return 0;
}

void rotate(vector<vector<int> > &arr) {
    /* transpose */
    for (int i = 0; i < arr.size(); i++) {
        for (int j = i; j < arr[i].size(); j++) {
            int temp = arr[i][j];
            arr[i][j] = arr[j][i];
            arr[j][i] = temp;
        }
    }

    /* reverse columns */
    int W, H;
    W = arr[0].size();
    H = arr.size();

    for (int i = 0; i < W; i++) {
        int j, k;
        j = 0;
        k = H - 1;
        while (j < k) {
            int temp = arr[j][i];
            arr[j][i] = arr[k][i];
            arr[k][i] = temp;
            j++;
            k--;
        }
    }

    for (int i = 0; i < W; i++) {
        for (int j = 0; j < H; j++) {
            cout << arr[i][j] << " ";
        }
        cout << endl;
    }
}
