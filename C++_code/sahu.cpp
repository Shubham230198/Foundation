#include<bits/stdc++.h>
using namespace std;

long hole = 0;
long path = 0;

void getAnswer(int i, int j, int w, int h, int l, int u, int r, int d) {
    if(i == h && j == w) {
        path++;
        return;
    }

    if(i + 1 <= h) {
        if( i + 1 >= u && i + 1 <=d  && j >= l && j <= r) {
            hole++;
        }
        else {
            getAnswer(i + 1, j, w, h, l, u, r, d);
        }
    }

    if(j + 1 <= w) {
        if(j + 1 >= l && j + 1 <= r && i >= u && i <= d ) {
            hole++;
        }
        else {
            getAnswer(i , j + 1, w ,h, l, u, r, d);
        }
    }
}

int main() {
    int t; cin>>t;
    for(int ct = 1; ct <= t; ct++) {
        int w,h,l,u,r,d; cin>>w>>h>>l>>u>>r>>d;

        path = 0;
        hole = 0;
        getAnswer(1, 1, w, h, l, u, r, d);

        cout<<(double)hole / (double)path<<"\n";

    }
}