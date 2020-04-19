#include <bits/stdc++.h>
using namespace std;
int x = 1;
int y = 1;

int getAnswer(string s, int idx) {
	int i = idx;
	for(; i < s.length() && s[i] != ')'; i++) {
		if(s[i] == 'N') {
			if(y == 1)
				y = 1000000000;
			else
				y--;
		}
		else if(s[i] == 'E') {
			if(x == 1000000000)
				x = 1;
			else
				x++;
		}
		else if(s[i] == 'W') {
			if(x == 1)
				x = 1000000000;
			else
				x--;
		}
		else if(s[i] == 'S') {
			if(y == 1000000000)
				y = 1;
			else
				y++;
			
		}
		else if(s[i] >= '1' && s[i] <= '9') {
			int num = 0;
			while(s[i] != '(') {
				int n = s[i] - '0';
				num = num * 10 + n;
				i++;
			}
			i++;
			int a = 0;
			for(int o = 1; o <= num; o++)
				a = getAnswer(s, i);
			i = a ;
		}
	}

	return i ;
}


int main() {
	int t; cin>>t;
	for(int ct = 1; ct <= t; ct++) {
		string s; cin>>s;
		x = 1;
		y = 1;
		
		getAnswer(s, 0);
		
		cout<<x<<", "<<y<<"\n";
	}
}