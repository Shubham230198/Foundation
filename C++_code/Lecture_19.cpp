                                                            //Lecture-19
                                                            //July-14

#include<iostream>
#include<vector>
#include<string>
using namespace std;



/*string s1 = "send";                                             //CRYPTO ARTHEMATIC PROBLEM.
string s2 = "more";
string s3 = "money";


string getUnique() {           //to collect all the unique characters of 3 strings, in a new string.
    char arr[26];
    fill_n(arr, 26, false);
    string uni;
    for(int i = 0; i < s1.length(); i++) {
        char ch = s1[i];
        int c = ch - 'a';
        if(arr[c] == false) {
            uni += ch;
            arr[c] = true;
        }
    }

    for(int i = 0; i < s2.length(); i++) {
        char ch = s2[i];
        int c = ch - 'a';
        if(arr[c] == false) {
            uni += ch;
            arr[c] = true;
        }
    }

    for(int i = 0; i < s3.length(); i++) {
        char ch = s3[i];
        int c = ch - 'a';
        if(arr[c] == false) {
            uni += ch;
            arr[c] = true;
        }
    }
    return uni;
}


int getNumber(string s, int mapping[]) {           //to create a number for respective string,
    int fact = 1;                                    //after getting the mappings.
    int num = 0;
    int i = s.length() - 1;
    while(i > -1) {
        int c = s[i] - 'a';
        num = num + mapping[c] * fact;
        i--;
        fact *= 10;
    }
    return num;
}


int counter = 0;
void getMapping(string uni, int idx, bool isOccupied[], int mapping[]) {
    if(idx == uni.length()) {
        int n1 = getNumber(s1, mapping);
        int n2 = getNumber(s2, mapping);
        int n3 = getNumber(s3, mapping);
        if(n1 + n2 == n3) {
            cout<<++counter<<" -> ";
            for(int i = 0; i < 26; i++) {
                if(mapping[i] != -1) {
                    cout<<" ("<<(char)(i + 'a')<<"="<<mapping[i]<<") ";
                }
            }
            cout<<"\n";
        }
        return;
    }

    char ch = uni[idx];
    int c = ch - 'a';
    for(int i = 0; i <= 9; i++) {
        if(isOccupied[i] == false) {
            isOccupied[i] = true;
            mapping[c] = i;
            getMapping(uni, idx + 1, isOccupied, mapping);
            mapping[c] = -1;
            isOccupied[i] = false;
        }
    }
}


int main()
{
    string unique = getUnique();
    int mapping[26];
    fill_n(mapping, 26, -1);

    bool isFree[10];
    fill_n(isFree, 10, false);
    
    getMapping(unique, 0, isFree, mapping);
}*/                                                     //REVIEWED.













/*bool isSafe(int ** arr, int r, int c, int val, int n) {                     //SUDOKU PROBLEM
    for(int j = 0; j < n; j++) {                                                //O(81 ^ 9)
        if(arr[r][j] == val) return false;
    }

    for(int i = 0; i < n; i++) {
        if(arr[i][c] == val) return false;
    }

    for(int i = (r/3)*3; i < (r/3)*3 + 3; i++) {
        for(int j = (c/3)*3; j < (c/3)*3 + 3; j++) {
            if(arr[i][j] == val) {
                return false;
            }
        }
    }

    return true;
}



int counter = 0;
void getSolved(int **arr, int r, int c, int n) {
    if(r == n && c == 0) {
        cout<<"**********"<<++counter<<"**********"<<"\n";
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                cout<<arr[i][j]<<" ";
            }
            cout<<"\n";
        }
        cout<<"**********"<<counter<<"**********"<<"\n";
        return;
    }

    if(c == n - 1) {
        if(arr[r][c] != 0) {
            getSolved(arr, r + 1, 0, n);
        }
        else {
            for(int i = 1; i <= 9; i++) {
                if(isSafe(arr, r, c, i, n) == true) {
                    arr[r][c] = i;
                    getSolved(arr, r + 1, 0, n);
                    arr[r][c] = 0;
                }
            }
        }
    }
    else {
        if(arr[r][c] != 0) {
            getSolved(arr, r, c + 1, n);
        }
        else {
            for(int i = 0; i <= 9; i++) {
                if(isSafe(arr, r, c, i, n) == true) {
                    arr[r][c] = i;
                    getSolved(arr, r, c + 1, n);
                    arr[r][c] = 0;
                }
            }
        }
    }
}



int main(int argc, char** argv) {
    int **arr = new int*[9];          //used a pointer array,
    for(int i = 0; i < 9; i++) {       // so need to fill input from terminal.
        arr[i] = new int[9];
    }

    for(int i = 0; i < 9; i++) {
        for(int j = 0; j < 9; j++) {
            cin>>arr[i][j];
        }
    }

    getSolved(arr, 0, 0, 9);
}*/                                    //REIEWED.