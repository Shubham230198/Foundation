#include <iostream>
using namespace std;

int main() {
    bool arr[5];

    int n = sizeof(arr)/sizeof(*arr);

    cout<<n;
}