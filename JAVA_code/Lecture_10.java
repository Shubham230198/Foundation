                                                    //LECTURE - 10
                                                    //2 - JULY

//import java.util.*;

public class Lecture_10                            //PRINTING THE ELEMENTS OF AN ARRAY IN A SPECIFIC ORDER. 
{
    /*public static void display(int[] arr,int index)
    {
        if(index==arr.length)
            return;

        System.out.println(arr[index]);          //for forward printing of array
        display(arr,index+1);

        // OR                                     //for displaying array in reverse order.
        // display(arr,index+1);
        // System.out.println(arr[index]);
        
    }
    
    public static void main(String[] args)
    {
        int[] arr={10,20,30,40,50,60};
        display(arr,0);
    }*/                                          //REVIEWED.


    
    
    /*public static int maxp(int[] arr,int index)                  //RECURSIVE MAX FUNCTION
    {   
        if(index==arr.length-1)
            return arr[index];
        int misa=maxp(arr,index+1);
        
        if(misa>arr[index])
            return misa;
        else
            return arr[index];
    }

    public static void main(String[] args)
    {   
        int[] arr={10,20,10,48,59,38,29,19};
        System.out.print(maxp(arr,0));
    }*/                                           //REVIEWED.
    
    

    /*public static boolean lsearch(int[] arr,int index,int val)                          //LINEAR SEARCH IN AN ARRAY.(should'nt be used)
    {                                                                                           
        if(index==arr.length-1)                                                             //firstly the whole array is traversed and 
        {   if(val==arr[index])                                                             //the searching is then started from the last
            {    return true;                                                               //element towards the first element.
            }
            else
            {
                return false;
            }            
        }


        boolean flag=lsearch(arr,index+1,val);

        if(val==arr[index])
            flag=true;

        return flag;
    }

    
    public static void main(String[] args)
    {
        int[] arr={10,20,33,40,54,65,76,87};
        System.out.print(lsearch(arr,0,43));
    }*/                                                                           //REVIEWED.





    /*public static boolean lsearch(int[] arr,int index,int val)                       //LINEAR SERACH FOR ELEMENT OF AN ARAY.(should be used)
    {   
        if(index==arr.length)                                                         //Here the searching is started from the very first index
        {                                                                             //of the array, and the moment the val is found, the true
            return false;                                                             //is returned and the seraching is stoped.
        }


        if(arr[index]==val)
        {
            return true;
        }
        else
        {
            boolean misa=lsearch(arr,index+1,val);
            return misa;

        }
    }


    public static void main(String[] args)
    {
        int[] arr={12,22,33,43,3,43,5,66,23,57};
        System.out.print(lsearch(arr,0,21));
    }*/                                                                                 //REVIEWED.



    

    /*public static int fisearch(int[] arr,int index,int val)                           //LINEAR SEARCH FOR A VALUE IN AN ARRAY
    {   
        if(index==arr.length)                                                           //this program returns the very first index
            return -1;                                                                  //of the value found in array.
    
        if(arr[index]==val)                                                             //and this program is very similar to above 
            return index;                                                               //lsearch, just it returns the index of found
        else                                                                            //value, instead of bool values.
        {   int fisa=fisearch(arr,index+1,val);
            return fisa;
        }
    }

    public static void main(String[] args)
    {
        int[] arr={10,22,2,3,2,3,4,5,6,2};
        System.out.print(fisearch(arr,0,2));
    }*/                                                                                   //REVIEWED.





    /*public static int lisearch(int[] arr,int index,int val)                             //LINEAR SEARCH< WHICH RETURNS THE
    {                                                                                     //VERY LAST INDEX OF VALUE IN AN ARRAY.
        if(index==arr.length-1)
        {
            if(arr[index]==val)                                                           //in this code, firstly the whole array
                return index;                                                             //is traversed to the last element then 
            else                                                                          //searching is started from last to first
                return -1;                                                                //element, and the very first moment we
        }                                                                                 //get the value, we will return it's index.
        
        int lisa=lisearch(arr,index+1,val);
        if(lisa!=0)
        {
            return lisa;
        }
        else if(arr[index]==val)
        {
            return index;
        }
        else
        {
            return -1;
        }
    }

    public static void main(String[] args)
    {   
        int[] arr={10,22,2,3,2,3,4,5,6,2};
        System.out.print(lisearch(arr,0,2));
    
    }*/                                                                     //REVIEWED.




public static int[] allindex(int[] arr,int index,int val,int count)            //TO GET AN ARRAY OF ALL INDEX
{   if(index==arr.length)                                                      //WHERE WE GET THE VALUE IN ARRAY.
    {   
        int[] out=new int[count];                                              //in this code, firstly the whole array is
        return out;                                                            //traversed and the total no. of value find
    }                                                                          //in an array is counted in count variable, till
                                                                               //the last element after that, a new array OUT is 
    if(arr[index]==val)                                                        //declared with size of count, thenafter moving 
        count++;                                                               //toward the 0th index, we stores the index value in 
                                                                               //OUT array whenever we found the value at any index.
    int[] out=allindex(arr,index+1,val,count);
    
    if(arr[index]==val)
    {
        out[count-1]=index;
    }
    return out;

}



public static void main(String[] args)
{
    int count=0;
    int[] arr={2,2,32,2,2,56,2,13,2,7,2,1,2,3,2,3,2};
    int[] out=allindex(arr,0,2,count);

    for(int i=0;i<out.length;i++)
    {
        System.out.println(out[i]);
    }
}                                                                        //REVIEWED.


}