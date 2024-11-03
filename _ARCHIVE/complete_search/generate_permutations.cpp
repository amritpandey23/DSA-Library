#include <iostream>
#include <vector>
using namespace std;

void search(int n, vector<int>& permutation, bool chosen[]) {
    if (permutation.size() == n) {
        return;
    }
    for (int i = 0; i < n; ++i) {
        if (!chosen[i]) {
            chosen[i] = true;
            permutation.push_back(A[i]);
            search(n, permutation, chosen);
            chosen[i] = false;
            permutation.pop_back();
        }
    }
}

int main() {

}
