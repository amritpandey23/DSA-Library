#include <iostream>
#include <limits.h>
#include <algorithm>
#include <vector>
#define String string
using namespace std;

struct Point {
    int x;
    int y;
};

bool myCmp(Point p1, Point p2) {
    return p1.x - p2.x;
}

int main() {
    int A[] = {1, 8, 2, 10, 1, 4};
    vector<int> arr {1, 8, 2, 10, 1, 4};
    int n = 6;

    /* sort is general purpose function to
    sort objects */
    sort(A, A + n); // sort in ascending order
    for (int a : A) {
        cout << a << " ";
    }
    cout << endl;
    sort(A, A + n, greater<int>()); // sort in descending order
    for (int a : A) {
        cout << a << " ";
    }
    cout << endl;
    sort(arr.begin(), arr.end());
    for (int a : arr) {
        cout << a << " ";
    }
    cout << endl;
    sort(arr.begin(), arr.end(), greater<int>());
    for (int a : arr) {
        cout << a << " ";
    }
    cout << endl;

    // sorting using custom comparator
    Point coordinates[] = {{1, 2}, {2, 3}, {-1, 0}};
    sort(coordinates, coordinates + 3, myCmp); 

    for (Point p : coordinates) {
        cout << p.x << " " << p.y << ", ";
    }
    cout << endl;
    return 0;
}
