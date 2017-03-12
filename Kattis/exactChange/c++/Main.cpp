#include <iostream>
#include <algorithm>
#include <stdio.h>
#include <vector>
using namespace std;
typedef long long ll;

int main(){
    int t;
    cin >> t;

    for (int test = 0; test < t; test++){
        int s, n;
        cin >> s >> n;

        vector<long> bills;
        int sum = 0;
        
        for (int i = 0; i < n; i++){
            long temp;
            cin >> temp;
            sum += temp;
            bills.push_back(temp);
        }

        long mem[sum+1][n+1];
        for (int i = 0; i < sum+1; i++){
            for (int j = 0; j < n; j++){
                mem[i][j]+=1;
            }
            mem[i][n] = n+2;
        }
        mem[0][n] = 0;

        for (int i = 1; i < sum+1; i++){
            long min = n+1;
            for (int j = 0; j < n; j++){
                if (bills[j] <= i && mem[i - bills[j]][j] > 0 && 1 + mem[i - bills[j]][n] < min){
                    min = 1 + mem[i - bills[j]][n];
                    mem[i][n] = min;
                    mem[i][j] = mem[i - bills[j]][j] - 1;
                }
            }
            if (i >= s && mem[i][n] != n+2){
                cout << i << " " << mem[i][n] << endl;
                break;
            }
        }

    }
}

