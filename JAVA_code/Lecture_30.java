                                                //Lecture-30
                                                //July-29

import java.util.*;
public class Lecture_30
{   

    //1. TARGET_SUM_PROBLEM     (similar to 0-1 knapsack problem)

    public static boolean[][] subarr(int[] arr,int target)
    {
        boolean[][] global=new boolean[arr.length][target+1];

        for(int r=0; r<global.length; r++)
        {
            for(int c=0;c<global[0].length;c++)
            {
                if(c==0 && r==0)
                {
                    global[r][c]=true;
                }
                else if(r==0)
                {
                    if(c==arr[0])
                        global[r][c]=true;
                }
                else if(c==0)
                {
                    global[r][c]=true;
                }
                else
                {
                    if(c<arr[r])
                    {
                        global[r][c]=global[r-1][c];
                    }
                    else
                    {
                        if(global[r-1][c]==true)
                            global[r][c]=true;
                        else if(c>=arr[r] && global[r-1][c-arr[r]]==true)
                            global[r][c]=true;
                    }
                }
            }
        }

        return global;
    }

    //REVIEWED.










    //2. Print-subsets-with-sum-isEqual-target.

    static void printSubsets(int[] arr,boolean[][] global,int i,int j,String ans)
    {   
        if(i==0)
        {   
            if(j==0)
                System.out.println(ans);
            else if(j==arr[0])
                System.out.println(ans+arr[0]);

            return;
        }

        if(global[i-1][j]==true)
        {
            printSubsets(arr, global, i-1, j, ans);
            
            if(j>=arr[i] && global[i-1][j-arr[i]]==true)
                printSubsets(arr, global, i-1, j-arr[i], ans+arr[i]);
        }
        else
        {
            if(j>=arr[i] && global[i-1][j-arr[i]]==true)
                printSubsets(arr, global, i-1, j-arr[i], ans+arr[i]);
        }
        
    }

    //REVIEwED.








    //3. COIN_CHANGE_PERMUTATION        (to get number of permutations of subsets,
                                        //with sum equal to target, with infinte number of all type of coins.
    
    static int[] coinChangePermi(int[] arr,int target)
    {   
        int[] global2=new int[target+1];
        global2[0]=1;

        for(int i=0;i<global2.length;i++)
        {
            for(int j=0;j<arr.length;j++)
            {   
                if(i-arr[j]>=0)
                global2[i]+=global2[i-arr[j]];
            }
        }
        return global2;
    }

    //REVIEWED.













    //4. COIN_CHANGE_COMBINATION        (to get number of combinations of sets, with sum is
                                        //equal to target, with infinite number of coins possible.

    static int[] coinChangeCombi(int[] arr,int target)
    {
        int[] global3=new int[target+1];
        global3[0]=1;

        for(int j=0;j<arr.length;j++)           //outer loop is of coins.
        {
            for(int i=0;i<global3.length;i++)   //inner loop is of the target values.
            {
                if(i-arr[j]>=0)
                global3[i]+=global3[i-arr[j]];
            }
        }

        return global3;
    }

    //REVIEWED.











    public static void main(String[] args)
    {

        //1. Target-Sum-Problem         (similar to 0-1 knapsack problem)
        
        /*
        int[] arr={3,2,5,1,8};
        boolean[][] global=subarr(arr,9);
        
        System.out.println(global[global.length - 1][global[0].length - 1]);
        */

        //reviewed.






        //2. To-print-subsets-with-target-sum.          (it uses function of question number 1).

        /*
        int[] arr={3,2,5,1,8};
        boolean[][] global=subarr(arr,9);       //using function of question 1.

        printSubsets(arr,global,global.length-1,global[0].length-1,"");            
        */

        //REVIEWED.








        //3. Coin-Change-Permutation        (to get number of permutations of sets
                                            //whose sum is equal to target, with infinite number of coins).
        /*
        int[] arr2={2,3,5,6};
        int[] m=coinChangePermi(arr2, 7);

        System.out.println("The total number of permutations are " + m[m.length - 1]);
        */

        //reviewed.







        //4.Coin-Change-Combination     (to get number of combinations of sets whose sum is 
                                        //equal to target, with infinite number of all types of coins.
        /*
        int[] arr2={2,3,5,6};
        int[] n=coinChangeCombi(arr2, 7);  
         
        System.out.println("The number of combinations are " + n[n.length - 1]);
        */

        //reviewed.
    
    
    
    
    }
}