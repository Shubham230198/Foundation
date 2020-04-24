#include <iostream>
using namespace std :: chrono;
using namespace std;

int main() {

	auto start = high_resolution_clock::now();
	int count = 0;
	for(int i = 0; i < 10000; i++) {
		count++;

	}
	for(int i = 0; i < 10000; i++) {
		count--;
	}

	auto end = high_resolution_clock::now();
	auto duration  = end - start;
	cout<<duration.count();
}