                                                //Lecture-30
                                                //July-29

#include<iostream>
using namespace std;



//1. TARGET_SUM_PROBLEM     (similar to 0-1 knapsack)

int isTargetPossible(int arr[], int target, int n) {
    bool dp[n][target + 1];

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < target + 1; j++) {
            if(j == 0) {               //if current target is 0.
                dp[i][j] = true;
            }
            else if(i == 0) {          //if only first element of array is selected.
                dp[i][j] = (arr[i] == j)? true : false;
            }
            else {
                if(dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }
                else if(j - arr[i] >= 0 && dp[i - 1][j - arr[i]] == true) {
                    dp[i][j] = true;
                }
                else {
                    dp[i][j] = false;
                }
            }
        }
    }

    return dp[n - 1][target];
}

//REVIEWED.







//2. Print-subsets-with-sum-isEqual-target.                (uses directed recursion, on DP)

void printSubsets(int arr[], bool dp[5][10], int i, int j, string psf) {      //(reverse engineering function)
    if(j == 0) {
        cout<<psf<<"\n";
        return;
    }
    
    if(dp[i - 1][j] == true) {
        printSubsets(arr, dp, i - 1, j, psf);       //present element is not selected.
    }

    if(j - arr[i] >= 0 && dp[i - 1][j - arr[i]] == true) {
        printSubsets(arr,dp, i - 1, j - arr[i], to_string(arr[i]) + psf);   //present element is selected.
    }
}



void isSubsetPossible(int arr[], int n, int target) {           //(DP function)
    bool dp[5][10];     //had to declare the variables with size as const values, because we need to pass it.
    
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < target + 1; j++) {
            if(j == 0) {
                dp[i][j] = true;
            }
            else if(i == 0) {
                dp[i][j] = (j == arr[i])? true : false;
            }
            else {
                if(dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }
                else if(j - arr[i] >=  0 && dp[i - 1][j - arr[i]] == true) {
                    dp[i][j] = true;
                }
                else {
                    dp[i][j] = false;
                }
            }
        }
    }

    printSubsets(arr, dp, n - 1, target, "");
}

//REVIEWED.









//3. COIN_CHANGE_PERMUTATION        (to get count of permutations of sets, with
                                    //sum equal to target, with infinite number of all coins).

int getPermiCount(int arr[], int n, int target) {
    int dp[target + 1];

    dp[0] = 1;
    for(int currTarget = 1; currTarget < target + 1; currTarget++) {       //outer loop as current targets.
        dp[currTarget] = 0;
        for(int ele = 0; ele < n; ele++) {            //inner loop as elements of arr.
            if(currTarget - arr[ele] >= 0)
                dp[currTarget] += dp[currTarget - arr[ele]];
        }
    }

    return dp[target];
}

//REVIEWED.











//4. COIN_CHANGE_COMBINATION        (to get count of combinations of sets, with
                                    //sum equal to target, with infinte number of all coins).

int getCombiCount(int arr[], int n, int target) {
    int dp[target + 1] {0};

    dp[0] = 1;

    for(int ele = 0; ele < n; ele++) {        //outer loop as of elements of arr.
        for(int currTarget = 1; currTarget < target + 1; currTarget++) {    //inner loops as current targets.
            if(currTarget - arr[ele] >= 0)
                dp[currTarget] += dp[currTarget - arr[ele]];
        }
    }

    return dp[target];
}

//reviewed.













int main()
{

    //1. Target-Sum-Problem     (similar to 0-1 Knapsack)

    /*
    int arr[] = {2,1,6,5,9};
    int target = 8;

    cout<<"If target is achiveable : "<<isTargetPossible(arr, target, 5);
    */

    //reviewed.






    //2. To-print-subsets-with-target-sum.

    /*
    int arr[] = {3,2,5,1,8};
    int target = 9;

    isSubsetPossible(arr, 5, target);
    */

    //reviewed.







    //3. Coin-Change-Permutation        (to get the number of permutations of sets,
                                        //whose sum is equal to target, with infinite coins of all types.
    /*
    int arr[] = {2,3,5,6};
    int target = 7;

    cout<<"The number of permutations are "<<getPermiCount(arr, 4, target);
    */

   //reviewed.







   //4.Coin-Change-Combination      (to get the number of combinations of sets,
                                    //whose sum is equal to target, with infinite coins of every type.
    /*
    int arr[] = {2,3,5,6};
    int target = 7;

    cout<<"The number of combinations are "<<getCombiCount(arr, 4, target);
    */

    //reviewed.





}
