                                                //LECTURE - 11
                                                //3 - JULY


import java.util.*;
public class Lecture_11
{   

    /*public static void reverseArray(int[] arr,int left,int right)               //TO REVERSE PRINTING AN ARRAY, WITH RECURSION.
    {   
        if(left==right)
        {
            System.out.print(arr[left]+" ");
            return;
        }
        else if(left>right)
        {
            return;
        }

        if(left<right)
        {   System.out.print(arr[right]+" ");            
            reverseArray(arr,left+1,right-1);
            System.out.print(arr[left]+" ");
        }
    }
    public static void main(String[] args)
    {
        int[] arr={10,20,30,50,60,70};
        int left=0;
        int right=arr.length-1;

        reverseArray(arr,left,right);
    }*/                                                       //REVIEWED.




    /*public static void reverseArray(int[] arr, int i ) {                //To reverse an array, using recursion.
        if(i <= arr.length / 2) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;

            reverseArray(arr, i + 1);
        }
    }

    public static void main(String[] args)
    {
        int[] arr={01,10,20,30,50,60,70};
        int left=0;

        reverseArray(arr,left);

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }*/                                                           //REVIEWED.




    /*static boolean checkPalindromic(int[] arr, int i) {                     //Check palindromic arr through recursion

        boolean flag = false;
        if(arr[i] == arr[arr.length - i - 1]) {
            flag = true;
            if(i <= arr.length/2)
                flag = checkPalindromic(arr, i + 1);
        }

        return flag;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,2,1};
        System.out.println(checkPalindromic(arr, 0));
    }*/                                                             //REVIEWED.



                                                            //ARRAYLIST IS STARTED.

    //1. A function to filter the elements of arraylist, which are greater than 50.
    
    

    /*public static void printRotations(ArrayList<Integer> arr, int k) {             //TO PRINT SPECIAL ROTATED ARRAYLIST
        int idx = 0;

        while( k-- != -1) {
            System.out.println(arr);

            int temp = arr.remove(arr.size() - 1);
            arr.add(idx, temp);
            idx++;
        }
    }

    public static void main(String[] args)                      
    {                                                             
        ArrayList<Integer> list=new ArrayList<>();

        for(int i=0;i<8;i++)                                            
        {
            list.add((i+1)*10);
        }

        printRotations(list, 3);

    }*/                                                                    //REVIEWED.




    /*static void removeDuplicacy(ArrayList<Integer> data) {               //TO REMOVE DUPLICACY FROM AN ARRAYLIST
        int i = 1;

        while(i < data.size()) {
            if(data.get(i) == data.get(i - 1)) {
                data.remove(i);
            }
            else {
                i++;
            }
        }

        System.out.println(data);
    }


    // static void removeDuplicacy(ArrayList<Integer> arr) {            //SAME AS ABOVE FUNCTION,
    //                                                                         //just the traversal is started from the last.
    //     for(int i = arr.size() - 2; i >= 0; i--) {                          //This traversal is recommended, if we are removeing
    //         if(arr.get(i) == arr.get(i + 1)){                               //any element during traversal.
    //             arr.remove(i + 1);
    //         }
    //     } 
    // }


    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<>();
        data.addAll(Arrays.asList(2,2,2,3,3,2,2,2,5,6,6,7,7,7,8,8));
        
        System.out.println(data);
        removeDuplicacy(data);
        System.out.println(data);
    }*/                                                              //REVIWED.






    /*static void getSumDuplicate(ArrayList<Integer> arr) {                //TO GET THE SUM OF ADJACENT DUPLICATES.
        int total = 0;                                                         //(in the same aaraylist)

        for(int i = arr.size() - 2; i >= 0; i--) {
            if(arr.get(i) == arr.get(i + 1)) {
                total += arr.remove(i + 1);
            }
            else {
                int temp = arr.get(i + 1);
                arr.set(i + 1, temp + total);
                total = 0;
            }
        }

        int t = arr.get(0);
        arr.set(0, t + total);
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.addAll(Arrays.asList(3,2,2,2,3,3,2,2,2,5,6,6,7,7,7,8,8));

        System.out.println(arr);
        getSumDuplicate(arr);
        System.out.println(arr);
    }*/                                                                 //REVIEWED.

}