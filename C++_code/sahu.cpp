#include <bits/stdc++.h>
using namespace std;

int getFactors(long long n) {
    int count = 0;

    for(int i = 1; i * i <= n; i++) {
        if(n % i == 0) {
            if(i * i == n) {
				count++;
				count %= (1000000007);
			}
            else {
				count += 2;
					count %= (1000000007);
			} 
        }
    }
    return count % 1000000007;
}


class node {
	public :
	int v1 = 0;
	long long pdt = 0;

	node(int v, long long p ){
		this->v1 = v;
		this->pdt = p;
	}	
};


int getDfs(vector<int> tree[], int cost[], int u, int v) {	
	unordered_set<int> set;
	set.insert(u);

	queue<node> que;
	node temp = node(u, cost[u]);
	que.push(temp);

	while(que.size() != 0) {
		temp = que.front();
		que.pop();

		if(temp.v1 == v) {
			break;
		}

		for(int i = 0; i < tree[temp.v1].size(); i++) {
			int neig = tree[temp.v1][i];
			if(set.count(neig) == 0) {
				set.insert(neig);
				node ne = node(neig, (temp.pdt * cost[neig]));
				que.push(ne);
			}
		}

	}

	int factors = getFactors(temp.pdt);
	return factors % 1000000007;
}


int main(int argc, char** argv) {
    int t; cin>>t;
    while(t-- != 0) {
        int n; cin>>n;
        vector<int> tree[n];

        for(int i = 1; i < n; i++) {
            int u,v; cin>>u>>v;
            tree[u - 1].push_back(v - 1);
            tree[v - 1].push_back(u - 1);
        }

        int cost[n];
        for(int i = 0; i < n; i++) {
            cin>>cost[i];
        }
    
        int q; cin>>q;
        for(int i = 0; i < q; i++) {
            int u,v; cin>>u>>v;
            cout<<getDfs(tree, cost, u - 1, v - 1)<<"\n";
        }

    }
}