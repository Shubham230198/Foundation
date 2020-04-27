                                        //Lecture_29
                                        //July-27

import java.util.*;
public class Lecture_29
{   
    //1. GET_ENCODINGS_COUNT
    public static int countEncodings(int[] arr)
    {
        int[] global=new int[arr.length];
        if(arr[0]==0)               //if 1st digit is zero, no sequence is possible.
        {
            return 0;
        }
        
        global[0]=1;            //if 0th digit is non-zero, 1 encoding is possible.
        
        if(arr[1]!=0)           //for using 1st digit standing alone.
        {
            global[1]=global[0];
        }

        int num1=arr[0]*10+arr[1];  //for using 1st digit by combining with 0th digit.
        if(num1>=10 && num1<=26)
        {
            global[1]+=1;
        }


        for(int i=2;i<arr.length;i++)
        {
            if(arr[i]!=0)
            {
                global[i]=global[i-1];
            }

            int num2=arr[i-1]*10+arr[i];
            if(num2>=10 && num2<=26)
            {
                global[i]+=global[i-2];
            }
        }
        
        return global[global.length-1];
    }                                                                   //REVIEWED.

    //REVIEWED.









    //2. GET_COUNT_OF_VALID_SUBSEQUENCES        (of form (a^i b^j c^k) )

    public static int subSequence(String s)
    {
        int count_a=0;      //subsequences of type(a^i)
        int count_ab=0;     //subsequences of type(a^i b^j)
        int count_abc=0;    //subsequences of type(a^i b^j c^k)

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='a')
            {
                count_a=1+count_a*2;
            }
            else if(s.charAt(i)=='b')
            {
                count_ab = count_a + count_ab*2;
            }
            else
            {
                count_abc=count_ab + count_abc*2;
            }
        }

        return count_abc;
    }

    //REVIEWED.


    





    //3. SHARE_MARKET_PROBLEM       (to get max profit, by buying and selling shares multiple times)

    public static int[] sharesProfit(int[] cost)         //(can't hold more than 1 share at a time).
    {   
        int[] global2=new int[cost.length];
        global2[0]=0;
        
        for(int i=1;i<global2.length;i++)
        {   
            int maxProfit=0;
            for(int j=0;j<i;j++)
            {   
                int fact=cost[i]-cost[j]-2 + global2[j];
                if(fact>maxProfit)
                {
                    maxProfit=fact;
                }
            }

            global2[i]=Math.max(global2[i-1],maxProfit);
        }

        return global2;
    }

    //REVIEWED.




 



    public static void main(String[] args)
    {
        
        //1. GET_ENCODINGS_COUNT        (to count number of encodings)

        /*
        int[] arr={1,2,1,3,2,6,1,2,0,1,4};
        System.out.println(countEncodings(arr));
        */

        //reviewed.

        
        


        //2. Get-Count-of-valid-subsequences           (of the type (a^i b^j c^k) )
        
        /*
        String s="abcabc";
        System.out.println(subSequence(s));
        */                                                                              //REVIEWED.
        
        //reviewed.





        
        //3.Share-Market-Problem        (to get max profit by buying - selling the stocks multiple times)

        /*
        int[] cost={9,1,3,10,1,4,6,9};
        int[] global2=(sharesProfit(cost));                               //to get max profit from selling and buying share.
        System.out.println("Max-profit from shares is " + global2[global2.length - 1]);
        */

        //reviewed.
    }
}