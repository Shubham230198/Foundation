#include <bits/stdc++.h>
using namespace std;
long long ans = 0;

void getMin(unordered_map<int, int>& umap) {

    for(int i = 1; i < 1000000001; i++) {
        if(umap.find(i) == umap.end()) {
            ans += i;
            ans %= 998244353;
            break;
        }
    }
    return;
}

void getSub(int n, int arr[], int i, unordered_map<int, int>& set) {
    if(i == n) {
        getMin(set);
        return;
    }

    getSub(n, arr, i + 1, set);

    if(set.find(arr[i]) == set.end()) {
        set.insert(make_pair(arr[i], 1));
    }
    else {
        set[arr[i]] = set[arr[i]] + 1;
    }

    getSub(n, arr, i + 1, set);
    
    if(set[arr[i]] == 1)
        set.erase(arr[i]);
    else
        set[arr[i]] = set[arr[i]] - 1;
}


int main() {
    int t; cin>>t;
    while(t--) {
        ans = 0;
        int n; cin>>n;
        int arr[n];

        for(int i = 0; i < n; i++) {
            cin>>arr[i];
        }

        unordered_map<int, int> set;
        getSub(n, arr, 0, set);
        cout<<ans<<"\n";
    }
}