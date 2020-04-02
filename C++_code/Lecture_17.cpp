                                            //Lecture-17
                                            //July - 12

#include<iostream>
#include<string>
using namespace std;


/*bool isSafe(bool ** arr, int n, int r, int c) {                                //nQueens problem.
    for(int i = r - 1; i >= 0; i--) {                                          //(keeping queens at levels, boxes as options)
        if(arr[i][c] == true)
            return false;
    }

    for(int j = c - 1; j >= 0; j--) {
        if(arr[r][j] == true)
            return false;
    }

    for(int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
        if(arr[i][j] == true)
            return false;
    }

    for(int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++) {
        if(arr[i][j] == true) 
            return false;
    }

    return true;
}


int count = 0;
void nQueens(bool ** arr, int n, int qsf, int ci, int cj, string s) {
    if(qsf == n) {
        cout<<++count<<"-> "<<s<<"\n";
        return;
    }

    for(int i = ci; i < n; i++) {
        for(int j = (i == ci ? cj + 1: 0); j < n; j++) {
            if(isSafe(arr, n, i, j) == true) {
                arr[i][j] = true;
                nQueens(arr, n, qsf + 1, i, j, s + to_string(i) + to_string(j) + " ");
                arr[i][j] = false;
            }
        }
    }
} 


int main()
{
    int n=4;
    bool **arr;
    arr = new bool*[n];
    for(int i = 0; i < n; i++) {
        arr[i] = new bool[n];
    }

    for(int i = 0; i < n; i++) {
        fill_n(arr[i], n,false); 
    }

    nQueens(arr, n, 0, 0, -1, "");
    return 0;
}*/                                                                     //REVIEWED.











/*bool isSafe(bool **arr, int n, int r, int c) {                           //nKnights problem.
    if(r - 1 >= 0 && c - 2 >= 0 && arr[r - 1][c - 2] == true)                //(keeping boxes at levels, knights as option)
        return false;
    
    if(r - 2 >= 0 && c - 1 >= 0 && arr[r - 2][c - 1] == true)
        return false;

    if(r - 2 >= 0 && c + 1 < n && arr[r - 2][c + 1] == true) 
        return false;

    if(r - 1 >= 0 && c + 2 < n && arr[r - 1][c + 2] == true) 
        return false;

    return true;
}


int count = 0;
void nKnights(bool **arr, int n, int ksf, int ci, int cj, string s) {
    if(ci == n && cj == 0) {
        if(ksf == n) {
            cout<<++count<<"-> "<<s<<"\n";
        }
        return;
    }

    if(cj == n - 1) {
        nKnights(arr, n, ksf, ci + 1, 0, s);
        if(isSafe(arr, n, ci, cj) == true) {
            arr[ci][cj] = true;
            nKnights(arr, n, ksf + 1, ci + 1, 0, s + to_string(ci) + to_string(cj) + " ");
            arr[ci][cj] = false;
        }
    }
    else {
        nKnights(arr, n, ksf, ci, cj + 1, s);
        if(isSafe(arr, n, ci, cj) == true) {
            arr[ci][cj] = true;
            nKnights(arr, n, ksf + 1, ci, cj + 1, s + to_string(ci) + to_string(cj) + " ");
            arr[ci][cj] = false;
        }
    }
}


int main() {
    int n = 3;
    bool **arr = new bool*[n];

    for(int i = 0; i < n; i++) {
        arr[i] = new bool[n];
    }

    for(int i = 0; i < n; i++) {
        fill_n(arr[i], n, false);
    }

    nKnights(arr, n, 0, 0, 0, "");
}*/                                                           //REVIEWED.