#include <iostream>
using namespace std;

void getPass( int ele, bool arr[][6]) {
	for(int i = 0;i < ele; i++) {
		for(int j = 0; j < 6; j++) {
			cout<<arr[i][j]<<"\t";
		}
		cout<<"\n";
	}
}

int main() {
	int ele = 3;
	int tar = 6;
	bool arr[ele][tar];
	getPass(3, arr);
}