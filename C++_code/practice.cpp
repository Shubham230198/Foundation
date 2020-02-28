#include<iostream>
using namespace std;

void pattern(int n) {
    int nsp = (n-3)/2;
    int nspa = 1;
    for(int i=1; i<=n;i++) {
        cout<<"*\t";

        if(i<=n/2 || i == n) {
            for(int j=1; j <= n-2; j++) {
                cout<<"\t";
            }
        }
        else {
            if(i == n/2 + 1) {
                for(int j = 1; j <= nsp; j++){
                    cout<<"\t";
                }
                cout<<"*\t";
                for(int  j=1;j<=nsp; j++){
                    cout<<"\t";
                }
                nsp--;
            }
            else {
                for(int j = 1; j <= nsp; j++){
                    cout<<"\t";
                }
                cout<<"*\t";
                for(int j=1;j<=nspa;j++) {
                    cout<<"\t";
                }
                cout<<"*\t";
                for(int j=1;j<=nsp;j++){
                    cout<<"\t";
                }
                nsp--;
                nspa+=2;
            }
        }
        cout<<"*"<<endl;
    } 
}


int main(int argc, char** argv) {
    int n;
    cin>>n;
    pattern(n);
}