                                                        //Lecture 3
                                                        //18 June
import java.util.*;
public class Lecture_3
{
    /*public static void main(String[] args)             //fibonacci
    {   Scanner scn= new Scanner(System.in);
        int size;

        System.out.print("enter the total count");
        size=scn.nextInt();

        int a=0;
        int b=1;

        for(int i=1;i<=size;i++)
        {   System.out.println(a);
            int c=a+b;
            a=b;
            b=c;
        }
    }*/                                                  //reviewed



    public static void main(String[] args)              //GCD.
    {   int a,b,r;
        Scanner scn=new Scanner(System.in);

        System.out.print("enter the num1 ");
        a=scn.nextInt();
        System.out.print("enter the num2");
        b=scn.nextInt();

        while(b%a!=0)
        {
            r=b%a;
            b=a;
            a=r;
        }

        System.out.println(a);
        scn.close();

    }                                                 //REVIEWED.



}