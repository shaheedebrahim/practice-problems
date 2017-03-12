#include<stdio.h>
#include<iostream>
#include<array>
#include<algorithm>
using namespace std;

int main(){
    int n;
    int m;
    int q;
    int s;
    cin >> n;
    cin >> m;
    cin >> q;
    cin >> s;

    while (n!=0){
        long long map[n][n];
        long long max = 1000000000;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                map[i][j] = max;
            }
        }
        for (int i = 0; i < m; i++){
            int u;
            int v;
            int w;
            cin >> u >> v >> w;
            map[u][v] = w;
        }

        for (int k = 0; k < n; k++){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    map[i][j] = min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        for (int i = 0; i < q; i++){
            int query;
            cin >> query;
            if (map[query][query] < 0){
                cout << "-Infinity\n";
            }else if (map[s][query] == max){
                cout << "Impossible\n";
            }else{
                cout << map[s][query] << "\n";
            }
        }
        cout <<"\n";
        cin >> n >> m >> q >> s;
    }
}
