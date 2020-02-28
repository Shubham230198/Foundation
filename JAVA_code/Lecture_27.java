import java.util.*;
public class Lecture_27
{   
    /*static int count_stair_case(int n,int[] qb)              //TO COUNT SIMPLE STAIR_CASE WAYS.
    {   
        if(n==1  || n==0)
            return 1;
        if(n==2)
            return 2;
        if(n==3)
            return 4;

        if(qb[n]!=0)
           return qb[n];
        
        int n1,n2,n3;
        n1=n2=n3=0;
        if(n-1>=0)
            n1=count_stair_case(n-1,qb);
        if(n-2>=0)
            n2=count_stair_case(n-2,qb);
        if(n-3>=0)
            n3=count_stair_case(n-3,qb);

        qb[n]=n1+n2+n3;
        return n1+n2+n3;
        
    }

    public static void main(String[] args)
    {
        int[] qb=new int[7+1];
        Arrays.fill(qb, 0);

        System.out.println(count_stair_case(7,qb));
    }*/                                                    //REVIEWED.




    static int count=0;
    public static int count_stair_case_variable(int n,int[] arr,int[] qb)
    {   
        if(n==arr.length-1)
        {
            count++;
            return 0;
        }

        int sum=0;
        if(qb[n]!=-1)
            return qb[n];
        for(int i=1;i<=arr[n];i++)
        {
            if(n+i<=arr.length-1)
            {
                sum+=count_stair_case_variable(n+i, arr,qb); 
            }
        }

        qb[n]=sum;
        return sum;
    }
    public static void main(String[] args)
    {
        int[] arr={4,2,0,0,2,4,6,3,1,0,1,2,3,1,1};
        int[] qb=new int[arr.length];
        Arrays.fill(qb, -1);
        int n=count_stair_case_variable(0,arr,qb);
        System.out.println(n);
        System.out.println(count);
    }

}