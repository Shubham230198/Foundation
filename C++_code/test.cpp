#include <bits/stdc++.h>
using namespace std;

int main() {
    set<int> res;

    res.insert(5);
    res.insert(50);
    res.insert(10);
    res.insert(20);
    res.insert(30);
    res.insert(40);
    res.insert(10);
    res.insert(50);
    res.insert(40);

    
    for(auto itr = res.begin(); itr != res.end(); itr++) {
        cout<<*itr<<" ";
    }

    set<int> res1;
    res1 = res;

    auto itr = res.begin();
    for(itr = res.begin(); itr != res.end(); itr++) {
        cout<<*itr<<" ";
    }
}