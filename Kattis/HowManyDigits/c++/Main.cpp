#include <stdio.h>
#include <math.h>
#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

int main(){
    int n;
    vector<double> mem;
    mem.push_back(0);
    mem.push_back(0);
    for (int i = 2; i < 1000001; i++){
        mem.push_back(log10(i) + mem[i-1]);
    }
    while (cin >> n){
        double total = mem[n];

        total = floor(total) + 1;
        cout << total << endl;
    }
}
