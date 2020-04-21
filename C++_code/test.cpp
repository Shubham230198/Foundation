#include <bits/stdc++.h>
using namespace std;

long long power(long long a, int b) {
	if(b == 1) {
		return a;
	}

	long long pre = power(a, b/2);
	pre %= 1000000007;
	pre *= pre;
	pre %= 1000000007;

	if(b % 2 != 0) {
		pre *= a;
		pre %= 1000000007;

	}

	return pre;
}


int main() {
	int t; cin>>t;
	while(t--) {
		int n,a; cin>>n>>a;

		long long total = 0;
		long long tci = 1;

		for(int i = 1; i <= n; i++) {
			int m = 2*i - 1;
			long long ci = power(a * tci, m);

			tci *= ci;
			tci %= 1000000007;
			total += (ci);
			total %= 1000000007;
		}

		cout<<total<<"\n";										//511620149
	}

}