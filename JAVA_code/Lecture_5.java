                                            //Lecture_5
                                            //June-22


import java.util.*;
public class Lecture_5
{   
    /*public static void main(String[] args)            //binary search
    {
        Scanner scn= new Scanner(System.in);

        int[] arr={20,40,120,45,90,55,36,23,76};
        Arrays.sort(arr);

        System.out.print("enter the data to search");
        int data=scn.nextInt();

        int left=0;
        int right=arr.length-1;

        while(left<=right)
        {
            int mid=(left+right)/2;

            if(data<arr[mid])
                right=mid-1;
            else if(data>arr[mid])
                left=mid+1;
            else
                System.out.println(data+ " is found at "+ mid+" index.");
                return;
        }

        System.out.print(data+" not found.");
        return;
    }*/                                       //reviewed




    /*public static void main(String[] args)          //binary search to find first or last occurence.
    {   Scanner scn= new Scanner(System.in);
        int result=-1;
        int[] arr={10,10,10,20,20,20,30,30,40,50,50,50};

        System.out.print("enter the data to search");
        int data=scn.nextInt();

        int left=0;
        int right=arr.length-1;

        while(left<=right)
        {
            int mid=(left+right)/2;

            if(data<arr[mid])
                right=mid-1;
            else if(data>arr[mid])
                left=mid+1;
            else
            {
                result=mid;
                right=mid-1;                //to find first occurence.(continously discarding right portion.)
                //left=mid+1;               //to find last occurence.(continously discarding left portion.)
            }
        }

        if(result==-1)
            System.out.println(data+" not found.");
        else
            System.out.println(data+" is found at "+result );
    }*/                                                    //reviewed.




    /*public static void main(String[] args)                //reversing an array
    {
        int[] arr={10,30,40,50,60};
        int left=0;
        int right=arr.length-1;
        
        while(left<right)
        {
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;

            left++;
            right--;
        }

        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }*/                                        //reviewed.




    public static void swap(int[] arr, int left, int right)   //Functions definitions(for reversing an array)
    {   int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    
    }

    public static void rev(int[] arr)
    {   int left=0;
        int right=arr.length-1;

        while(left<right)
        {
            swap(arr,left,right);
            left++;
            right--;
        }

    }

    public static void display(int[] arr)
    {   for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }

    }

    public static void main(String[] args)
    {   int[] arr={10,20,30,40,50,60};
        rev(arr);
        display(arr);

    }                                         //reviewed


}