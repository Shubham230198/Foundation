                                                //Lecture_29
                                                //July-27

#include<iostream>
using namespace std;



//1. GET_ENCODINGS_COUNT

int getEncodingCount(int arr[], int n) {
    int dp[n];
    fill_n(dp, n, 0);

    dp[0] = (arr[0] == 0)? 0 : 1;           //for only 0th digit.

    dp[1] = (arr[1] != 0)? dp[0] : 0;       //for using 1th digit standing alone

    int num = arr[0]*10 + arr[1];           //for using 1th digit by combining with 0th digit.
    if(num >= 10 && num <= 26){
        dp[1]++;
    } 


    for(int i = 2; i < n; i++) {
        if(arr[i] != 0) {
            dp[i] = dp[i - 1];
        }

        int num1 = arr[i - 1] * 10 + arr[i];
        if(num1 >= 10 && num1 <= 26) {
            dp[i] += dp[i - 2];
        }
    }

    return dp[n - 1];
}

//REVIEWED.








//2. GET_COUNT_OF_VALID_SUBSEQUENCES         (of form (a^i b^j c^k) with atleast 1 a, 1 b, 1 c)

int getValidSub(string str) {
    int a = 0;              //sub-sequences of type (a^i)  
    int ab = 0;             //sub-sequences of type (a^i b^j) 
    int abc = 0;            //sub-sequences of type (a^i b^j c^k) 

    for(int i = 0; i < str.length(); i++) {
        char ch = str.at(i);

        if(ch == 'a') {
            a = 2*a + 1;
        }
        else if(ch == 'b') {
            ab = 2*ab + a;
        }
        else {
            abc = 2*abc + ab;
        }
    }
    
    return abc;
}

//REVIEWED.








//3. SHARE_MARKET_PROBLEM       (to get max profit, by buying and selling shares multiple times)

int sharesProfit(int arr[] ,int n) {
    int dp[n];
    
    dp[0] = 0;      //no profit till first day.

    for(int i = 1; i < n; i++) {
        int maxProfitTill_i_day = 0;
        for(int j = 0; j < i; j++) {
            int fact = arr[i] - arr[j] - 2 + dp[j];
            if(fact > maxProfitTill_i_day) {
                maxProfitTill_i_day = fact;
            }
        }
        dp[i] = max(maxProfitTill_i_day, dp[i - 1]);
    }

    return dp[n - 1];
}

//REVIEWED.










int main()
{
 
    //1. GET_ENCODINGS_COUNT      (to count number of encodings)

    /*
    int arr[] = {1,2,1,3,2,6,1,2,0,1,4};
    cout<<"count of encodings are "<<getEncodingCount(arr, 11);
    */

    //reviewed







    //2. Get-Count-of-valid-subsequence             (of form (a^i b^j c^k) with atleast 1 a, 1 b, 1 c)

    /*
    string str = "abcabc";
    cout<<"count of desired sub-sequences are "<<getValidSub(str);
    */

    //reviewed.







    //3.Share-Market_Problem        (max profit by buying and selling shares, multiple times)

    /*
    int arr[] = {9,1,3,10,1,4,6,9};
    cout<<"Max-Profit from shares are "<<sharesProfit(arr, 8);
    */

   //reviewed.

}