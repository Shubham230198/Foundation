                                        //Lecture-28
                                        //july-26

#include<iostream>
#include<vector>
#include<climits>
using namespace std;


//1.To get min-cost for 2D array traversal   (only two moves are allowed) 

int minCost(vector<vector<int>> arr) {
    vector<vector<int>> dp(arr.size(), vector<int> (arr[0].size()));
    
    for(int i = arr.size() - 1; i >= 0; i--) {
        for(int j = arr[0].size() - 1; j >= 0; j--) {
            if(i == arr.size() - 1 && j == arr[0].size() - 1) {
                dp[i][j] = arr[i][j];
            }
            else if(i == arr.size() - 1) {
                dp[i][j] = dp[i][j + 1] + arr[i][j];
            }
            else if(j == arr[0].size() - 1) {
                dp[i][j] = dp[i + 1][j] + arr[i][j];
            }
            else{
                dp[i][j] = min(dp[i + 1][j], dp[i][j + 1]) + arr[i][j];
            }
        }
    }

    return dp[0][0];
}

//REVIEWED.










//2. To get min-cost path. (using dp to get min-path, and directed recursion to get actual min cost path)

void minCostPath(vector<vector<int>> dp, int i, int j, string psf) {        //directed recursion.
    if(i == dp.size() - 1 && j == dp[0].size() - 1) {
        cout<<psf<<"\n";
        return;
    }
    
    if(i == dp.size() - 1) {
        minCostPath(dp, i, j + 1, psf + 'h');
    }
    else if(j == dp[0].size() - 1) {
        minCostPath(dp, i + 1, j, psf + 'v');
    }
    else {
        if(dp[i + 1][j] < dp[i][j + 1]) {
            minCostPath(dp, i + 1, j, psf + 'v');
        }
        else if(dp[i][j + 1] < dp[i + 1][j]) {
            minCostPath(dp, i, j + 1, psf + 'h');
        }
        else {
            minCostPath(dp, i + 1, j, psf + 'v');
            minCostPath(dp, i, j + 1, psf + 'h');
        }
    }
} 




void minCost2(vector<vector<int>> arr) {                    //(DP function)
    vector<vector<int>> dp (arr.size(), vector<int> (arr[0].size()));

    for(int i = dp.size() - 1; i >= 0; i--) {
        for(int j = dp[0].size(); j >= 0; j--) {
            if(i == dp.size() - 1 && j == dp[0].size() - 1) {
                dp[i][j] = arr[i][j];
            }
            else if(i == dp.size() - 1) {
                dp[i][j] = dp[i][j + 1] + arr[i][j];
            }
            else if(j == dp[0].size() - 1) {
                dp[i][j] = dp[i + 1][j] + arr[i][j];
            }
            else {
                dp[i][j] = min(dp[i][j + 1], dp[i + 1][j]) + arr[i][j];
            }
        }
    }

    minCostPath(dp, 0, 0, "");
}

//REVIEWED.









//3. GOLD_MINE Problem     (with upper diagonal, lower diagonal, horizontal)

int goldProfit(vector<vector<int>> goldArr) {
    vector<vector<int>> dp (goldArr.size(), vector<int> (goldArr[0].size()));

    for(int j = dp[0].size() - 1; j >= 0; j--) {
        for(int i = dp.size() - 1; i >= 0; i--) {
            if(j == dp[0].size() - 1) {
                dp[i][j] = goldArr[i][j];
            }
            else if(i == 0) {
                dp[i][j] = max(dp[i][j + 1], dp[i + 1][j + 1]) + goldArr[i][j];
            }
            else if(i == dp.size() - 1) {
                dp[i][j] = max(dp[i - 1][j + 1], dp[i][j + 1]) + goldArr[i][j];
            }
            else {
                dp[i][j] = max(dp[i - 1][j + 1], max(dp[i][j + 1], dp[i + 1][j + 1])) + goldArr[i][j];
            }
        }
    }

    int maxProfit = INT_MIN;
    for(int x = 0; x < dp.size(); x++) {
        if(maxProfit < dp[x][0])
            maxProfit = dp[x][0];
    }

    return maxProfit;
}

//REVIEWED.








//4. To count number of binary strings, without any consecutive zeroes   (implementation of fibonacci series)

int countBinaryStrings(int n) {
    int a = 1;
    int b = 1;
    int c = -1;

    for(int i = 1; i <= n; i++) {
        c = a + b;
        a = b;
        b = c;
    }

    return c;
}

//REVIEWED.









int main()
{   
    ios_base::sync_with_stdio();
    cin.tie(0);
    
    
    //1.To get min-cost value in maze traversal.     (only two moves are allowed)

    /*
    vector<vector<int>> arr {
        {2,7,3,8,0,3,1},
        {4,0,1,2,4,3,4},
        {3,8,5,9,0,8,1},
        {1,6,0,4,5,5,2},
        {6,2,9,5,7,0,6},
        {0,8,7,9,6,3,0},
        {1,3,5,0,5,1,0}
    };

    cout<<"min cost for traversal is "<<minCost(arr);
    */

   //reviewed.





   
    //2. To print min-cost path in maze traversal, (with only 2 moves)

    /*
    vector<vector<int>> arr {
        {1,5,1,0,3},
        {1,4,0,2,3},
        {4,0,1,3,2},
        {2,4,0,4,1},
        {1,2,3,2,0}
    };

    minCost2(arr);
    */

    //reviewed.







    //3.GOLD_MINE Problem        (to get max profit)
    
    /*
    vector<vector<int>> goldArr {
        {1,5,1,0,3},
        {1,4,0,2,3},
        {4,0,1,3,2},
        {2,4,0,4,1},
        {1,2,3,2,0}
    };

    cout<<"Gold-mine profit is "<<goldProfit(goldArr);
    */

    //reviewed.





    //4.Count number of binary strings without any consecutive zeroes.  (implementation of fibonacci series)

    /*
    int n = 5;
    cout<<"number of binary strings are "<<countBinaryStrings(n);
    */

    //reviewed.



}