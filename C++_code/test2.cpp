#include <iostream>
using namespace std;

int main(int argc, char** argv) {
    int arr[4];
    fill(arr, arr + 3, 10);

    for(int i = 0; i < 4; i++) {
        cout<<arr[i];
    }
    return 0;
}