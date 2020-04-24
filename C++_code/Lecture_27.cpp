                                                //Lecture-27
                                                //july-25

                                                //DYNAMIC PROGRAMMING
#include <iostream>
using namespace std;



//1. FIBONACCI_MEMOIZATION
int fibo(int n, int memo[]) {
    if(n == 0 || n == 1) {
        return n;
    }

    if(memo[n] != 0) {
        return memo[n];
    }

    int ans = fibo(n - 1, memo) + fibo(n - 2, memo);
    
    memo[n] = ans;
    return ans;
}

//REVIEWED.







//2. SimpleStairCase Path Problem.       (with tabulation, count number of ways, steps 1,2,3)

int simpleStairCase(int n) {
    int dp[n + 1];

    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    for(int i = 4; i < n + 1; i++) {
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }

    return dp[n];
}

//REVIEWED.









//3.COMPLEX_STAIRCASE_PATH count_(0 -> n) problem     (steps are the value at current positon)

int complexStairCase(int n, int arr[]) {
    int dp[n + 1];
    dp[n] = 1;

    for(int i = n - 1; i >= 0; i--) {
        int val = arr[i];
        dp[i] = 0;
        for(int step = 1; step <= val; step++) {
            if(i + step <= n) {
                dp[i] += dp[i + step];
            }
        }
    }

    return dp[0];
}

//REVIEWED.








//4.To find min number of steps in Complex_StairCase problem.

int minComplexStairStep(int n, int arr[]) {
    int dp[n + 1];
    dp[n] = 0;                    //as the meaning to box is,(in how min stpes we reach the nth stair).

    for(int i = n - 1; i >= 0; i--) {
        int val = arr[i];
        dp[i] = __INT_MAX__;

        for(int step = 1; step <= val; step++) {
            if(i + step <= n && dp[i + step] < dp[i]) {
                dp[i] = dp[i + step] + 1;
            }
        }
    }

    return dp[0];
}

//REVIEWED.








int main() {

    //1. fibonacci_memoisation
    
    /*
    int n = 10;
    int memo[n + 1];
    fill_n(memo, n + 1, 0);

    cout<<"nth fibonacci is "<<fibo(n, memo);
    */

    //reviewed.






    //2.Simple_StairCase_Path       (to count number of ways, steps 1,2,3)

    /*
    int n = 7;
    cout<<"number of ways "<<simpleStairCase(n);
    */

    //reviewed.




    //3.Complex_StairCase_Path problem        (to count number of ways) 
    
    /*
    int n = 14;
    int arr[n + 1] = {4,2,0,0,2,4,6,3,1,0,1,2,3,1,1};

    cout<<"number of ways "<<complexStairCase(n, arr);
    */

    //reviewed.





    //4. MIN_STEPS of ComplexStairPath.         (tabulation)
    
    /*
    int n = 14;
    int arr[n + 1] = {4,2,0,0,2,4,6,3,1,0,1,2,3,1,1};

    cout<<"min number of steps "<<minComplexStairStep(n, arr);
    */

    //reviewed.




}