                                            //LECTURE-27
                                            //july-25

                                            //DYNAMIC PROGRAMMING.
                                            
import java.util.*;
public class Lecture_27
{   

    //1. FIBONACCI_TABULATION

    static int fibo(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    //REVIEWED.







    //2.TO COUNT SIMPLE STAIR_CASE WAYS, with memoization.   (from every stair we can take steps of 1,2,3)

    static int count_stair_case(int n,int[] qb)
    {   
        if(n==1  || n==0)
            return 1;
        if(n==2)
            return 2;
        if(n==3)
            return 4;

        if(qb[n]!=0)
           return qb[n];
        
        int n1,n2,n3;
        n1=n2=n3=0;
        if(n-1>=0)                      //making pro-active calls.
            n1=count_stair_case(n-1,qb);
        if(n-2>=0)
            n2=count_stair_case(n-2,qb);
        if(n-3>=0)
            n3=count_stair_case(n-3,qb);

        qb[n]=n1+n2+n3;                 //storing the result
        return n1+n2+n3;
    }

    //REVIEWED.




    



    //3. COMPLEX_STAIRCASE_PATH   count( 0 -> n)        (steps are values at current position)(memoization)

    public static int count_stair_case_variable(int n,int[] arr,int[] qb)
    {   
        if(n==arr.length-1)
        {
            return 1;
        }

        if(qb[n]!=-1)
        return qb[n];
        
        int sum=0;
        for(int i=1;i<=arr[n];i++)
        {
            if(n+i<=arr.length-1)
            {
                sum+=count_stair_case_variable(n+i, arr,qb); 
            }
        }

        qb[n]=sum;
        return sum;
    }

    //REVIEWED.









    //4. MIN-JUMPS for COMPLEX_STAIR_PATH                    (to get min jumps to reach last stair)

    static int minJumpsComplexStair(int idx, int[] arr, int[] memo) {
        if(idx == arr.length - 1)
            return 0;

        if(memo[idx] != 0)                 //(to use dp, by memoisation)
            return memo[idx];

        int min = Integer.MAX_VALUE;

        for(int i = 1; i <= arr[idx]; i++) {
            if(idx + i < arr.length) {
                int temp = minJumpsComplexStair(idx + i, arr, memo);
                if(temp < min) {
                    min = temp;
                }
            }
        }

        if(min == Integer.MAX_VALUE) {
            memo[idx] = min;
            return min;
        }
        else {
            memo[idx] = min + 1;
            return min + 1;
        }
    }









    public static void main(String[] args)
    {

        //1. fibonacci_tabulation 
            
        /*
            int n = 10;
            System.out.println(fibo(n));
            */

        //reviewed.


        




        //2.STAIRCASE_PROBLEM        (to count number of ways to go to 0th stair, steps 0, 1, 2)

        /* 
        int n = 6;
        int[] memo = new int[n + 1];

        System.out.println("total ways" + count_stair_case(n,memo));
        */

        //reviewed.







        //3.Complex_StairCase_Path  count(0 -> n)
        
        /*
        int[] arr={4,2,0,0,2,4,6,3,1,0,1,2,3,1,1};
        int[] memo=new int[arr.length];
        Arrays.fill(memo, -1);
        int n=count_stair_case_variable(0,arr,memo);
        System.out.println(n);
        */
        
        //reviewed.
        
        
        
        

        
        
        //4. MIN-JUMPS for complex stair path.
        
        /*
        int[] arr={2,0,0,2,4,6,3,1,0,1,2,3,1,1};
        int[] memo=new int[arr.length];

        int minJumps = minJumpsComplexStair(0, arr, memo);
        if(minJumps == Integer.MAX_VALUE)
            System.out.println("NOT POSSIBLE");
        else
            System.out.println(minJumps);
        */

        //reviewed.


    }

}