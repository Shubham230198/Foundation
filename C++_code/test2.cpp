#include <bits/stdc++.h>
using namespace std;

int getAnswer(int arr[], int n, int d) {
    for(int i = d; i >= 1; i++) {
        int n1 = d;
        bool flag = true;
        for(int j = 0; j < n; j++) {
            int temp = ((n1/arr[j]) + ((n1%arr[j]) != 0) * arr[j]);
            if(temp <= n1) {
                n1 = temp;
            }
            else {
                flag = false;
                break;
            }
        }
        if(flag) {
            return i;
        }
    }
}

int main() {
    int t; cin>>t;
    for(int ct = 1; ct <= t; ct++) {
        int n,d; cin>>n>>d;
        
        int arr[n];
        for(int i = 0; i < n; i++) {
            cin>>arr[i];
        }
        
        int result = getAnswer(arr, n, d);
        cout<<"Case #"<<ct<<": "<<result<<"\n";
    }
}