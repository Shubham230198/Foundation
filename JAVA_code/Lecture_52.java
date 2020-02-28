                                            //2 september.
import java.util.*;
                                            //time and space(1).
class Lecture_52
{   
    public static int fun(int x,int n)                 //to calculate the sum of series in O(n).
    {   
        int fact=0;
        for(int i=n;i>=1;i--)
        {
            fact+=(i)*(Math.pow(x,n-i+1));
        }

        return fact;
    }                                                          //reviewed.




    public static void getAllPrimeSOE(int n)             //to print all prime numbers till n, in time O(n*log(log(n))).
    {   
        boolean[] arr=new boolean[n+1];
        Arrays.fill(arr,true);

        arr[0]=false;
        arr[1]=false;

        for(int i=2;i*i<=n;i++)
        {   
            if(arr[i]!=false)
            {    
                for(int j=i;j*i<=n;j++)
                {   
                    arr[j*i]=false;
                }
            }
        }

        for(int i=0;i<=n;i++)
        {
            if(arr[i]==true)
                System.out.print(i + "   ");
        }
    }                                                                        //reviewed.




    
    public static int[] getSmallestFactorSOE(int n)             //to get an array of n, containing spf of each index
    {                                                               //,in time O(n*log(log(n))).
        boolean[] arr=new boolean[n+1];
        Arrays.fill(arr,true);
        int[] res=new int[n+1];

        for(int i=0;i<=n;i++)
        {
            res[i]=i;
        }


        arr[0]=false;
        arr[1]=false;

        for(int i=2;i*i<=n;i++)
        {   
            if(arr[i]!=false)
            {    
                for(int j=i;j*i<=n;j++)
                {   
                    if(arr[i*j]==true)
                    {    
                        arr[j*i]=false;
                        res[i*j]=i;
                    }
                }
            }
        }

        return res;
    }                                                   //reviewed.




    public static void getFactorisation(int[] spf,int x)
    {
        while(x>1)
        {
            System.out.print(spf[x] + "*");
            x=x/spf[x];
        }
        System.out.println();
    }



                                                    //Bit manipulation.

    
    
    static void setABit(int x,int k)                       //to set a bit at specific k index,in binary number.
    {    
        int factor=1;  
        int mask=factor<<k;               //creating a mask;
        x=x|mask;

        System.out.println(x +  "=" + Integer.toBinaryString(x));
    }                                                       //reviewed.



    static void unsetABit(int x,int k)                    //To unset a Kth bit in a binary number.
    {
        int factor=1;
        int mask=factor<<k;         //creating a mask.
        mask=~mask;
        x=x&mask;

        System.out.println(x + "=" + Integer.toBinaryString(x));
    }                                                        //reviewed.





    static void toggleABit(int x,int k)                   //To toggle  particular Kth bit, in a binary number.
    {
        int factor=1;
        int mask=factor<<k;                  //creating a mask.
        x=x^mask;

        System.out.println(x + "=" + Integer.toBinaryString(x));
    }                                                       //reviewed.




    static int count=0;
    static void personCapMap(ArrayList[] arr, boolean[] visited,int p,int cap)
    {   
        if(p<0)
        {
            count++;
            return;
        }

        for(int option=0;option<cap;option++)
        {
            if(visited[option]==false && option)
            {
                visited[option]=true;
                personCapMap(visited, p-1, cap);
                visited[option]=false;
            }

        }
    }


    public static void main(String[] args)
    {   
                                            //time complexity.
                                            
        //System.out.println(fun(2,3));                  //to calcutate the sum of a series in O(n).

        //getAllPrimeSOE(30);

        /*int[] spf=getSmallestFactorSOE(10000);
        getFactorisation(spf,142);
        getFactorisation(spf,2050);
        getFactorisation(spf,325);
        */

                                            //bit maniputlation.


        //setABit(8, 2);

        //unsetABit(8, 3);

        /*toggleABit(8, 2);
        toggleABit(12, 2);
        */


        int cap=5;
        int persons=3;

        ArrayList[] arr=new ArrayList[persons];
        boolean[] visited=new boolean[cap];

        personCapMap(arr,visited,0);
    }
}