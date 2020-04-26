#include <bits/stdc++.h>
using namespace std;

class node {
	public:
		int data = -1;
		int idx = -1;

		node(int d, int i) {
			this->data = d;
			this->idx = i;
		}
};

int main() {
	int t; cin>>t;
	while(t--) {
		int n, k; cin>>n>>k;
		vector<pair<int, int>> arr;

		for(int i = 0; i < n; i++) {
			int d; cin>>d;
			arr.push_back(make_pair(d, i));
		}

		sort(arr.begin(), arr.end());

		bool flag = true;
		for(int i = 0; i < arr.size(); i++) {
			if(arr[i].second != i) {
				if((arr[i].second - i) % k != 0) {
					flag = false;
					break;
				}
			} 
		}

		if(flag) {
			cout<<"yes\n";
		}
		else {
			cout<<"no\n";
		}
		
	}
}