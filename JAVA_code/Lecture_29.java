//import java.util.*;
public class Lecture_29
{   
    public static int countEncodings(int[] arr)                               //COUNT OF ENCODINGS
    {
        int[] global=new int[arr.length];
        if(arr[0]==0)
        {
            return 0;
        }
        
        global[0]=1;
        if(arr[1]!=0)
        {
            global[1]=global[0];
        }

        int num1=arr[0]*10+arr[1];
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




    
    public static int subSequence(String s)                             //COUNT OF SPECIAL TYPE OF SUBSEQUENCE.
    {
        int count_a=0;
        int count_b=0;
        int count_c=0;

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='a')
            {
                count_a=1+count_a*2;
            }
            else if(s.charAt(i)=='b')
            {
                count_b=count_a + count_b*2;
            }
            else
            {
                count_c=count_b + count_c*2;
            }
        }

        return count_c;
    }                                                               //REVIEWED.




    
    public static int[] sharesProfit(int[] cost)                    //MAX PROFIT FROM STOCKMARKET.
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
    }                                                                //REVIEWED.





    public static void main(String[] args)
    {
        /*int[] arr={1,2,1,3,2,6,1,2,0,1,4};                          //COUNT OF ENCODINGS.
        System.out.println(countEncodings(arr));
        */                                                            //REVIEWED.

        
        
        /*String s="abcabc";                                            //TO get desirable subsequence(a..ab..bc..c) of a 
        System.out.println(subSequence(s));                           //string.
        */                                                                              //REVIEWED.
    
        
        int[] cost={9,1,3,10,1,4,6,9};
        int[] global2=(sharesProfit(cost));                               //to get max profit from selling and buying share.
        for(int i=0;i<global2.length;i++)                                                      
        {
            System.out.print(global2[i]+"\t");
        }                                                                               ////REVIEWED.
    }
}