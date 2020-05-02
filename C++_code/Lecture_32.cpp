                                //Lecture-32
                                //August-2

#include<iostream>
using namespace std;



//1.SHARES_PROFIT_PROBLEM       (to get max profit by buying and selling shares,
                                //without holding more than 1 share, at a time.
int sharesProfit(int arr[], int n, int k) {
    int dp[2][n];
    
    dp[0][0] = -1*arr[0];
    dp[1][0] = 0;

    for(int j = 1; j < n; j++) {
        for(int i = 0; i < 2; i++) {
            dp[i][j] = 0;
            if(i == 0) {                //buying row.
                dp[i][j] = max(dp[i][j - 1], dp[i + 1][j - 1] - arr[j]);
            }
            else {                      //selling row.
                dp[i][j] = max(dp[i][j - 1], dp[i - 1][j - 1] + arr[j] - k);
            }
        }
    }
    return dp[1][n - 1];
}

//REVIEWED.













//2.LONGEST_COMMON_SUBSEQUENCE          (just to find the maximum length of LCS)

int lengthOfLCS(string s1, string s2) {
    int dp[s1.length() + 1][s2.length() + 1];

    for(int i = s1.length(); i >= 0; i--) {
        for(int j = s2.length(); j >= 0; j--) {
            if(i == s1.length() || j == s2.length()) {      //(anyone is empty subsequence)
                dp[i][j] = 0;
            }
            else if(s1.at(i) == s2.at(j)) {             //(row and col character matches)
                dp[i][j] = 1 + dp[i + 1][j + 1];
            }
            else {                              //(row and col charater doesn't matches)
                dp[i][j] = max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
    } 

    return dp[0][0];
}

//REVIEWED.













//3. PRINTING_THE_LCS           (printing the actual LCS)

void getLCS(int dp[][5], int i, int j, string psf, string s1, string s2) {      //recursive function.
    if(i == s1.length() && j == s2.length()) {
        cout<<"The actual LCS is "<<psf;
        return;
    }

    if(s1.at(i) == s2.at(j)) {
        getLCS(dp, i + 1, j + 1, psf + s1.at(i), s1, s2);
    }
    else {
        if(dp[i + 1][j] > dp[i][j + 1]) {
            getLCS(dp, i + 1, j, psf, s1, s1);
        }
        else {
            getLCS(dp, i, j + 1, psf, s1, s2);
        }
    }
}



void printLCS(string s1, string s2) {       //(dp function)
    
    // int dp[s1.length() + 1][s2.length() + 1];        //(this is also correct, but...)
    
    int dp[5][5];       //as we have to pass it to another function, so const size.

    for(int i = s1.length(); i >= 0; i--) {
        for(int j = s2.length(); j >= 0; j--) {
            if(i == s1.length() || j == s2.length()) {
                dp[i][j] = 0;
            }
            else if(s1.at(i) == s2.at(j)) {
                dp[i][j] = 1 + dp[i + 1][j + 1];
            }
            else {
                dp[i][j] = max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
    }
    getLCS(dp, 0, 0, "", s1, s2);
}

//REVIEWED.














//4.LONGEST_PALINDROMIC_SUBSEQUENCE         (to get the length of LPS only)

int lengthOfLPS(string s) {
    int dp[s.length()][s.length()];

    for(int l = 1; l <= s.length(); l++) {
        for(int i = 0, j = l - 1; i < s.length() && j < s.length(); i++, j++) {
            if(l == 1) {
                dp[i][j] = 1;
            }
            else if(l == 2) {
                if(s.at(i) == s.at(j)) {
                    dp[i][j] = 2;
                }
                else {
                    dp[i][j] = 1;
                }
            }
            else {
                if(s.at(i) == s.at(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                }
                else {
                    dp[i][j] = max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
    }

    return dp[0][s.length() - 1];
}

//REVIEWED.










int main()
{
    
    //1.SHARE_PROFIT_PROBLEM       (to get max profit, without holding more than one share at a time.)

    /*   
    int arr[] = {9,1,3,10,1,4,6,9};
    int k = 2;

    cout<<"The max Profit from shares is "<<sharesProfit(arr, 8, k);
    */

    //reviewed.









    //2. LONGEST_COMMON_SUBSEQUENCE     (only the length of LCS)

    /*
    string s1 = "abcd";
    string s2 = "aebd";

    cout<<"The length of LCS is"<<lengthOfLCS(s1, s2);
    */

    //reviewed.










    //3. Printing_the_LCS

    /*
    string s1 = "abcd";
    string s2 = "aebd";

    printLCS(s1, s2);
    */

    //reviewed.









    //4.LONGEST_PALINDROMIC_SUBSEQUENCE        (to find the length of LPS)

    /*
    string s = "abckycbc";
    cout<<"The length of LPS is "<<lengthOfLPS(s);
    */

   //reviewed.


}