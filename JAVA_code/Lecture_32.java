                                        //Lecture-32
                                        //August-2

import java.util.*;
public class Lecture_32
{   
    
    //1.SHARES_PROFIT_PROBLEM       (to get max profit by buying and selling shares
                                    //without holding more than 1 share at a time).
    static int sharesProfit(int[] arr, int k) {
        int[][] dp = new int[2][arr.length];

        dp[0][0] = -1 * arr[0];         //buying the first stock.
        dp[1][0] = 0;                   //nothing to buy.

        for(int j = 1; j < dp[0].length; j++) {
            for(int i = 0; i < dp.length; i++) {
                if(i == 0) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j - 1] - arr[j]);
                }
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - 1] + arr[j] - k);
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    //REVIEWED.












    //2.LONGEST_COMMON_SUBSEQUENCE      (just to find max length of LCS)

    static int[][] longestCommonSubSequence(String s1,String s2)                    //TO GET LENGTH LONGEST COMMON SUBSEQUENCE.
    {
        int[][] global=new int[s1.length()+1][s2.length()+1];

        for(int r=global.length-1;r>=0;r--)
        {
            for(int c=global[0].length-1;c>=0;c--)
            {
                if(r==global.length-1 || c==global[0].length-1)
                {
                    global[r][c]=0;
                }
                else
                {
                    if(s1.charAt(r)==s2.charAt(c))      //if characters are same.
                        global[r][c]=1+global[r+1][c+1];

                    else                                //if characters are not same.
                        global[r][c]=Math.max(global[r+1][c],global[r][c+1]);
                }
            }
        }
        return global;
    }

    //REVIEWED.












    //3.PRINTING_THE_LCS        (it uses the above dp creating function)

    static void longestCommonSubSequencePath(String s1,String s2,int i,int j,int[][] global2,String ans)   //TO GET LONGEST COMMON
    {                                                                                                      //SUBSEQUENCE.
        if(i==global2.length-1 && j==global2.length-1)
        {
            System.out.println(ans);
            return;
        }

        if(s1.charAt(i)==s2.charAt(j))
        {
            ans+=s1.charAt(i);
            longestCommonSubSequencePath(s1, s2, i+1, j+1, global2, ans);
        }
        else
        {
            if(global2[i+1][j]>global2[i][j+1])
            {
                longestCommonSubSequencePath(s1, s2, i+1, j, global2, ans);
            }
            else
            {
                longestCommonSubSequencePath(s1, s2, i, j+1, global2, ans);
            }
        }
    }                                                                                 //REVIEWED.

    //REVEIWED.













    //4.LONGEST_PALINDROMIC_SUBSEQUENCE         (to get the length of LPS)

    static int[][] longestPalindromeSubSequence(String s)
    {
        int[][] global3=new int[s.length()][s.length()];

        for(int gap=0;gap<global3.length;gap++)                  //diagonal loop, (for a matrix).
         {   
            for(int r=0;r<global3.length-gap;r++)
            {   
                int c=r+gap;

                if(gap==0)
                {
                    global3[r][c]=1;
                }
                else if(gap==1)
                {
                    if(s.charAt(r)==s.charAt(c))
                        global3[r][c]=2;
                    else
                        global3[r][c]=1;
                }
                else if(s.charAt(r)==s.charAt(c))
                {
                    global3[r][c]=2+global3[r+1][c-1];
                }
                else
                    global3[r][c]=Math.max(global3[r+1][c],global3[r][c-1]);
            
            }
        }

        return global3;
    }                                                                       //REVIEWED.

    //REVIEWED.













    public static void main(String[] args)
    {
        
        //1.SHARE_PROFIT_PROBLEM        (to get max profit, from shares)

        /*
        int[] arr = {9,1,3,10,1,4,6,9};
        int k = 2;

        System.out.println("The max profit from shares is " + sharesProfit(arr, k));
        */

        //REVIEWED.



        





        //2. LONGEST_COMMON_SUBSEQUENCE         (only the length of LCS)

        /*
        int[][] global= longestCommonSubSequence("abcd","aebd");               //count of longest common subsequence.
        
        System.out.println("The length of LCS is " + global[0][0]);
        */

        //reviewed.
    
    







        //3.Printing_the_LCS        (this function uses DP of LCS)

        /*
        int[][] global2=longestCommonSubSequence("abcd","aebd");                //to get longest common subsequence, by recursion
        longestCommonSubSequencePath("abcd","aebd",0,0,global2,"");             //and DP both.
        */

        //reviewed.









        //4.LONGEST_PALINDROMIC_SUBSEQUENCE         (only the length of LPS)

        /*
        int[][] global3=longestPalindromeSubSequence("abckycbc");                //length of longest palindromic sub sequence.
        
        System.out.println("The length of LPS is " + global3[0][global3[0].length - 1]);
        */

        //reviewed.
    
    
    
    }
}