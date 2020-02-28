                                                //5 September, 2019
import java.util.*;

import javax.lang.model.util.ElementScanner6;
                                                //Time and Space(2).
class Lecture_53
{   

    public static void sort01(int[] arr)                          //to Seprate Zeroes And Ones.
    {   
        int j=0;
        for(int i=0;i<arr.length;)
        {   
            if(arr[i]==1)
                i++;
            else
            {
                swap(arr,i,j);
                i++;
                j++;
            }

        }

    }



    static void sort012(int[] arr)                              //to sort the 0,1,2 elements from an array,
    {                                                               //such that all 0 comes first,then all 1,
        int i=0;                                                    //thenafter all 2s.
        int j=0;
        int k=arr.length-1;

        for(i=0;i<=k;)
        {
            if(arr[i]==1)
            {
                i++;
            }
            else if(arr[i]==0)
            {
                swap(arr,i,j);
                j++;
                i++;
            }
            else
            {
                swap(arr,i,k);
                k--;
            }
        }

    }                                                              //reviewed.




    static int inversionCount=0;

    static int[] mergeSortedArrays(int[] arr1,int[] arr2)
    {   
        int[] sortedArray=new int[arr1.length + arr2.length];

        int i=0;
        int j=0;
        int k=0;

        while(i<arr1.length && j<arr2.length)
        {
            if(arr1[i]<arr2[j])
            {
                sortedArray[k++]=arr1[i++];
            }
            else
            {
                sortedArray[k++]=arr2[j++];

                inversionCount+=arr1.length-i;                      //counted in O(n);
            }
        }

        while(i<arr1.length)
        {
            sortedArray[k++]=arr1[i++];
        }

        while(j<arr2.length)
        {
            sortedArray[k++]=arr2[j++];
        }

        return sortedArray;
    }



    static int[] mergeSortArray(int[] arr,int low,int high)
    {   
        if(low==high)
        {
            int[] bc=new int[1];
            bc[0]=arr[low];
            return bc;
        }

        int mid=(low+high)/2;
        int[] firstHalf=mergeSortArray(arr, low, mid);
        int[] secondHalf=mergeSortArray(arr, mid+1, high);

        int[] fullArray=mergeSortedArrays(firstHalf,secondHalf);

        return fullArray;

    }


    static void swap(int[] arr,int i,int j)                              //to swap two numbers.
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }




    public static int partitioning(int[] arr,int low,int high)
    {
        int k=high;;
        int i=low;
        int j=low;
        int pivot=arr[k];
        
        while(i<=k)
        {
            if(arr[i]<=pivot)
            {
                swap(arr,i,j);
                i++;
                j++;
            }
            else
            {
                i++;
            }
        }

        return j-1;
    }



    public static int quickSelect(int[] arr,int low,int high,int position)
    {   
        int p=partitioning(arr,low,high);
        
        if(p==position-1)
        {
            return arr[p];
        }
        
        while(p!=position-1)
        {
            if(position-1>p)
            {
                int p1=quickSelect(arr, p+1, high, position-1-p);
                return p1;
            }
            else
            {
                int p2=quickSelect(arr, low, p-1, p-position-1);
                return p2;
            }
        }

        return -1;
        
    }


    public static void main(String[] args)
    {
        /*int[] arr={1,1,0,1,1,0,1,1,0};
        sort01(arr);

        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i] + " ");
        }*/



        /*int[] arr2={0,0,1,1,1,2,0,1,2,2,0,1,0,1};
        sort012(arr2);

        for(int i=0;i<arr2.length;i++)
        {
            System.out.print(arr2[i] + " ");
        }*/



        /*int[] arr3={2,5,1,8,6,3,7,4};
        int[] sortedArray=mergeSortArray(arr3, 0, arr3.length-1);

        for(int i:sortedArray)
        {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(inversionCount);
        */


        int[] arr={20,30,110,50,40,80,70,90};

        System.out.println(quickSelect(arr, 0, arr.length-1, 3));

    }
}