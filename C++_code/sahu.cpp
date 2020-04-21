#include <bits/stdc++.h>
using namespace std;

int main() {
    int t; cin>>t;
    for(int ct = 1; ct <= t; ct++) {
        int r,s; cin>>r>>s;

        int i = r;
        int j = r*s - 1;

        while(true) {
            cout<<i<<j;
            j--;
        }

    }
}