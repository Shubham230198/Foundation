                                                    //Lecture-2
                                                    //16 June

import java.util.*;

/** public class Lecture_2
{
    public static void main(String[] args)
    {
        int p=1000;
        int r=10;
        int t=2;
        int si=p*r*t/100;
        System.out.print("the simple interest is"+si);

    }
}  */                                //Reviewd by praveen




/** public class Lecture_2{                  //time events overlaping
    public static void main(String[] args)
    {
        int e1s=0;
        int e1e=5;
        int e2s=7;
        int e2e=12;

    if(e1e<e2s||e2e<e1s)
    {
        System.out.print("no overlap");
    }

    else if((e1s<e2s && e1e>e2e)||(e1s>e2s && e1e<e2e))
    {
        System.out.print("Full overlap");
    }

    else
    {
        System.out.print("partial overlap");
    }
    }
} */                                           //Reviewed by praveen 




/** public class Lecture_2                            //loops
{
    public static void main(String[] args)
    {   int n=3,i=1;
        while(i<=n)
        {
            System.out.println(i);
            i++;
        }  

        for(i=1;i<=n;i++)
        {
            System.out.println(i);
        }

    }
} */                                             //reviewed




/** public class Lecture_2                       //input
{
    public static void main(String[] args)
    {   Scanner scn= new Scanner(System.in);
        
        int n;
        System.out.print("enter a number");
        n=scn.nextInt();

        System.out.print(n*10);

    }
}*/                                      //reviewed




/*public class Lecture_2               //prime-or-not
{
    public static void main(String[] args)
    {   Scanner scn= new Scanner(System.in);
        int num;
        System.out.println("enter the number");
        num=scn.nextInt();

        boolean flag=true;
        for(int i=2;i*i<=num;i++)
        {
            if(num%i==0)
                flag=false;
                
        }

        if(flag)
            System.out.println(num+" is prime.");

        else
            System.out.println(num+ " is not prime.");

        scn.close();
    }
    
}*/                                          //REVIEWED.




public class Lecture_2{                            //bulbs on-off toggle problem
    public static void main(String[] args){
        int n=25;                            //no. of bulbs.

        for(int i=1;i*i<=n;i++){
            System.out.println(i*i);                 //to print the on bulbs only.
        }
    }
}                                                     //REVIEWED.

