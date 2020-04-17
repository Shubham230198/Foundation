#include <bits/stdc++.h>
using namespace std;


bool getAnswer(string s) {
    stack<int> st;
    bool flag = false;

    for(int i = 0; i < s.length(); i++) {
        char ch = s.at(i);

        if(ch != ')') {
            st.push(ch);
        }
        else {
            int counter = 0;
            while(st.top() != '(') {
                st.pop();
                counter++;
            }

            st.pop();
            if(counter == 0) {
                flag = true;
                return flag;
            }
        }
    }

    return flag;
}

int main() {
    // string s = "((a+(b))+(c+d))";
    int t = 0; cin>>t;
    for(int i = 0; i < t; i++) {
        string s;
        // cin>>s;
        getline(cin,s);

        while(s.length() == 0) {
            getline(cin, s);
        }
        bool result = getAnswer(s);
        if(result) cout<<"Duplicates"<<s<<"\n";
        else cout<<"Not Duplicates"<<s<<"\n";
    }
}