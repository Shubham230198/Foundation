#include <bits/stdc++.h>
using namespace std;

int result(int n) {
    int count = 0;

    while(n > 0) {
        n = (n & (n-1));
        count++;
    }
    return count;
}

int main() {
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL);

    int t;
    cin>>t;

    while(t--) {
        int n,q;
        cin>>n>>q;

        int arr[n];
        for(int i = 0; i < n; i++) {
            cin>>arr[i];
        }

        for(int j = 0; j < q; j++) {
            int p;
            cin>>p;
            int odd = 0;
            int even = 0;

            for(int i = 0; i < n; i++) {
                int res = result(p ^ arr[i]);
                if(res % 2 == 0) {
                    even++;
                }
                else
                {
                    odd++;
                }
            }
            cout<<even<<" "<<odd<<"\n";
        }
    }
    return 0;
}