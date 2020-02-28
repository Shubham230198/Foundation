#include <iostream>
#include <algorithm>
using namespace std;

int actualResult = 0;


void recursiveAnswer(int arr1[], int arr2[], int n, int idx, bool check[], int totalSum) {
    if(idx == n) {
        if(actualResult < totalSum) {
        // cout<<"hello"<<" ";
            actualResult = totalSum;
        }
        return;
    }

    for(int i = 0; i < n; i++) {
        if(check[i] == false) {
            check[i] = true;
            recursiveAnswer(arr1, arr2, n, idx + 1, check, totalSum + (arr1[idx] < arr2[i] ? arr1[idx] : arr2[i]));
            check[i] = false;
        }
    }
}

int main(int argc, char** argv) {
    int t;
    cin>>t;

    while(t--) {
        long n;
        cin>>n;

        long arr1[n];
        for(long i = 0; i < n; i++) {
            cin>>arr1[i];
        }

        long arr2[n];
        for(long i = 0; i < n; i++) {
            cin>>arr2[i];
        }
        
        sort(arr1, arr1 + n);
        sort(arr2, arr2 + n);

        int maxValue = 0;
        for(long i = 0; i < n; i++) {
            maxValue += (arr1[i] < arr2[i] ? arr1[i] : arr2[i]);
        }
        cout<<maxValue<<endl;
    }
}