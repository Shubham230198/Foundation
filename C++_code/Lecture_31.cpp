                                    //Lecture-31
                                    //July-31

#include<iostream>
using namespace std;



//1. (0-1)_KNAPSACK_PROBLEM

int knapSack(int wt[], int val[], int n, int w) {
    int dp[n + 1][w + 1];

    for(int i = 0; i < n + 1; i++) {
        for(int j = 0; j < w + 1; j++) {
            if(i == 0 || j == 0) {
                dp[i][j] = 0;
            }
            else {
                dp[i][j] = dp[i - 1][j];

                if(j - wt[i - 1] >= 0) {
                    int fact = dp[i - 1][j - wt[i - 1]] + val[i - 1];
                    dp[i][j] = max(dp[i][j], fact);
                }
            }
        }
    }

    return dp[n][w];
}

//REVIEWED.













//2. 0-1_KNAPSACK_PROBLEM       (with multiple items of any types can be selected)

int knapSackInfinite(int val[], int wt[], int n, int w) {
    int dp[w + 1] {0};

    for(int j = 0; j < w + 1; j++) {
        for(int i = 0; i < n; i++) {
            if(j - wt[i] >= 0) {
                dp[j] = max(dp[j], dp[j - wt[i]] + val[i]);
            }
        }
    }

    return dp[w];
}

//REVIEWED.













//3. N_FRIENDS PROBLEM      (to count number of ways, so that
                            //n people could pair up or stay single)

int nFriends(int n) {
    int dp[n + 1];

    dp[0] = dp[1] = 1;
    for(int j = 2; j < n + 1; j++) {
        dp[j] = dp[j - 1] + (j-1) * dp[j - 2];
    }

    return dp[n];
}

//REVIEWED.












//4. FILL_THE_CARPET_AREA  (carpet-tiles)   (of size n*m with the tiles of size m*1)

int carpetTiles(int m, int n) {
    int dp[n + 1];

    dp[0] = 1;      //one ways, when there is no area at all.

    for(int i = 1; i < n + 1; i++) {
        dp[i] = dp[i - 1];

        if(i - m >= 0) {
            dp[i] += dp[i - m];
        }
    }

    return dp[n];
}

//REVIEWED.











int main()
{
    
    //1.(0-1 KnapSack Problem)

    /*
    int n = 5;
    int val[] = {15,14,10,45,30};
    int wt[] = {2,5,1,3,4};
    int w = 7;
    
    cout<<"Max profit is "<<knapSack(wt, val, n, w);
    */

    //reviewed.








    //2.(0-1 KnapSack Problem)      (with infinite number of all types of items)

    /*
    int n = 5;
    int val[] = {15,14,10,45,30};
    int wt[] = {2,5,1,3,4};
    int w = 7;
    
    cout<<"Max value in profit is "<<knapSackInfinite(val, wt, n, w);
    */

    //reviewed.








    //3.N-Friend Problem        (number of ways so that n people, either
                                //could pair-up or stay single)
    /*
    int n = 7;
    cout<<"The number of ways for n-friends are "<<nFriends(n);
    */

    //reviewed.







    //4.FILL_THE_AREA (carpet-tiles)       (of size n*m, with tiles of size m*1)

    /*
    cout<<"The ways to fill the area are "<<carpetTiles(2,10);
    */

    //reviewed.



    
}           