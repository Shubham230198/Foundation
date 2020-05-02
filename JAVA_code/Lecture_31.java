                                    //Lecture_31
                                    //July-31

import java.util.*;
public class Lecture_31
{   

    //1. (0-1)_KNAPSACK_PROBLEM

    static int[][] knapSack(int[] wt,int[] prices,int target)
    {                                          
        int[][] global=new int[wt.length][target+1];
        for(int r=0;r<global.length;r++)
        {
            for(int c=0;c<global[0].length;c++)
            {   
                if(r==0 && c==0)
                {
                    global[r][c]=0;
                }
                else if(c==0)
                {
                    global[r][c]=0;
                }
                else if(r==0)
                {
                    if(c>=wt[r])
                        global[r][c]=prices[r];
                }
                else
                {
                    if(c>=wt[r])
                    {
                        if(global[r-1][c] > global[r-1][c-wt[r]]+prices[r])
                        {
                            global[r][c]=global[r-1][c];
                        }
                        else
                            global[r][c]=global[r-1][c-wt[r]]+prices[r];
                    }
                    else
                    {
                        global[r][c]=global[r-1][c];
                    }
                }
            }
        }
        return global;
    }

    //REVIEWED.









    
    //2. 0-1_KNAPSACK_PROBLEM       (with multiple items of any type, can be selected).

    static int[] knapSackDuplicacy(int[] wt,int[] prices,int target)                
    {                                                                               
        int[] global2=new int[target+1];                                            
        global2[0]=0;                                                               

        for(int i=1;i<global2.length;i++)
        {   int max=0;
            for(int m=0;m<wt.length;m++)
            {
                if(i>=wt[m])
                {
                    if(max < global2[i-wt[m]]+prices[m])
                        max=global2[i-wt[m]]+prices[m];
                }
            }
            global2[i]=max;
        }

        return global2;
    }

    //REVIEWED.













    //3. N_FRIENDS_PROBLEM      (to count number of ways, so that
                                //n people could pair up or stay single.
    static int[] pairCount(int people)                           
    {                                                            
        int[] global3=new int[people+1];
        global3[0]=1;
        global3[1]=1;

        for(int i=2;i<global3.length;i++)
        {
            global3[i]=global3[i-1] + (i-1)*global3[i-2];
        }

        return global3;
    }

    //REVIEWED.












    //4. FILL_THE _CARPET_AREA.         (of size n*m with the m*1 sized tiles)

    static int[] carpetTiles(int m,int n)                         //WAYS TO FILL A AREA of (m*n), BY TILES OF AREA (m*1).
    {
        int[] global4=new int[n+1];
        global4[0]=1;
        global4[1]=1;

        for(int i=2;i<global4.length;i++)
        {
            global4[i]=global4[i-1];

            if(i-m>=0)
                global4[i]+=global4[i-m];
        }

        return global4;
    }

    //REVIEWED.











    public static void main(String[] args)
    {

        //1.(0-1 Knapsack Problem)

        /*
        int[] wt={2,5,1,3,4};
        int[] prices={15,14,10,45,30};

        int[][] global=knapSack(wt,prices,7);
        System.out.println("Max profit is " + global[global.length - 1][global[0].length - 1]);
        */

        //REVIEWED.







        //2.(0-1 Knapsack Problem)      (with infinite number of all types of items)
        
        /*
        int[] wt={2,5,1,3,4};                                             //max price item in a bag, with fixed capacity.
        int[] prices={15,14,10,45,30};                                    //but duplicacy of items is allowed.
        
        int[] global2=knapSackDuplicacy(wt, prices,7);
        System.out.println(global2[global2.length -1]);
        */

        //reviewed.







        //3.N_FRIENDS_PROBLEM.      (number of ways so that n people, either colud pair-up or stay single.
        
        /*
        int[] global3=pairCount(5);
        System.out.println(global3[global3.length - 1]);
        */

        //reviewed.






        //4. FILL_THE_AREA      (of size n*m, with tiles of size m*1)
        
        /*
        int[] global4=carpetTiles(2,10);                                    //count to cover a area of (m*n), by tiles of size (m*1).
        System.out.println(global4[global4.length - 1]);
        */
        
        //reviewed.
    }

}