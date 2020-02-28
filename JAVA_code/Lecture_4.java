                                                    //Lecture_4
                                                    //21 June

import java.util.*;
class Lecture_4{

    static int maximumOfArray(int[] arr)                             //Bar-Graph dispaly of array elements.
    {   
        int m=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>m)
                m=arr[i];
        }
        return m;
    }

    static void barPattern(int[] arr,int max)
    {
        for(int i=max;i>=1;i--)
        {
            for(int j=0;j<arr.length;j++)
            {
                if(arr[j]>=i)
                    System.out.print(" * ");
                else
                    System.out.print("   ");
            }
            System.out.println();
        }
    }                                                                  //REVIEWED.




    static void addTwoMatrix(int[] n1,int[] n2){                          //To add two matrices cosidering each as a number.
        int[] sum = new int[n1.length >= n2.length? n1.length + 1: n2.length + 1];   //and giving the result also as matirx.
        
        // fill sum array
        int i = n1.length - 1;
        int j = n2.length - 1;
        int k = sum.length - 1;
        int carry = 0;
        
        while(k >= 0)
        {
            int var = carry;
            if(i >= 0)
            {
                var = var + n1[i];
            }
            
            if(j >= 0)
            {
                var = var + n2[j];
            }
            
            int digit = var % 10;
            carry = var / 10;
            
            sum[k] = digit;
            
            i--;
            j--;
            k--;
        }

        
        // Print sum array

        for(i = 0; i < sum.length; i++)
        {
            if(i == 0 && sum[i] == 0)
            continue;
`   
            System.out.print(sum[i]);
        }
        System.out.println();
    }                                                                            //REVIEWED.




    static void duplicacy(int[] arr){                            //To print the duplicate values in an array.

        System.out.print("The duplicate elements in the array are: ");
        for(int i=0;i<arr.length;i++)                                                //just this code cant work with diplcacy of zero.
        {                                                                            //but this could be made to work with it.
            if(arr[Math.abs(arr[i])]>=0)
                arr[Math.abs(arr[i])]*=-1;
            else
                System.out.print(Math.abs(arr[i]) + " ");
        }
    }                                                             //reviewed.




public static void main(String[] args){
    
    //6 Patterns was done firstly.
    
    //To find max in an array.
    
    //Linear Search.
    
    
    /*int[] arr={4,7,2,8,5};                                       //Bar-Graph
    
    int max=maximumOfArray(arr);
    barPattern(arr,max);
    */                                                              //reviewed.
    
    

    /*int[] n1 = {9, 7, 2, 9};                                        //add two matrices as two numbers.
    int[] n2 = {9, 9, 9, 9, 8, 8};

    addTwoMatrix(n1, n2);                                           
    */                                                                //reviewed.



    int[] arr={0,3,2,3,5,4};                                        //to print the duplicate values in an array.
    duplicacy(arr);
    // */                                                                //reviewed.
    }
}