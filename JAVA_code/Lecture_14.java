//import java.util.*;
public class Lecture_14
{   
    /*static void print_sub_sequence(String ques,String ans)
    {
        if(ques.length()==0)
        {
            System.out.println(ans);
            return ;
        }
        
        char ch=ques.charAt(0);
        String remaining=ques.substring(1,ques.length());

        print_sub_sequence(remaining,ans+"-");
        print_sub_sequence(remaining,ans+ch);
    }


    public static void main(String[] args)
    {
        print_sub_sequence("abc","");
    }*/                                                               //REVIEWED.




    /*public static void stair_case(int ques,String ans)
    {   
        if(ques==0)
        {
            System.out.println(ans);
            return;
        }

        for(int i=1;i<=3;i++)
        {   
            int remaining=ques-i;
            if(remaining>=0)
            {   
                stair_case(remaining, ans+ i);
            }
        }
    }


    public static void main(String[] args)
    {
        stair_case(7,"");
    }*/                                                           //REVIEWED.




    /*static String[] count={                                 //TO GET THE PHONE KEYPAD
        ".",                                           //COMBINATIONS.
        "abc",
        "def",
        "ghi" ,
        "jklm",
        "no",
        "pqrs",
        "tu",
        "vwxy",
        "z"       
    };

    public static void keypad_combi(String ques,String ans)
    {   
        if(ques.length()==0)
        {
            System.out.println(ans);
            return;
        }
        char ch=ques.charAt(0);
        String remaining=ques.substring(1,ques.length());

        String call=count[ch-48];
        for(int i=0;i<call.length();i++)
        {
            keypad_combi(remaining,ans+call.charAt(i));
        }
    }


    public static void main(String[] args)
    {
        keypad_combi("835", "");
    }*/                                              //REVIEWED.




   /*static int[] stair_val={3,2,0,4,1,2,0,2,3,0,1};

   //static int[] stair_val={3,0,1,3,2,3,4};                                   //test case
    public static void stair_case_2(int ques,String ans)
    {   
        if(ques==stair_val.length-1)
        {
            System.out.println(ans);
            return;
        }

        int ch=stair_val[ques];                         //to get the value in the array at stair ques 
        for(int i=1;i<=ch;i++)
        {   
            if(ques+i<=stair_val.length-1)
            {   
                stair_case_2(ques+i,ans+ i);
            }
        }
    }

    public static void main(String[] args)
    {
        stair_case_2(0,"");
    }*/                                                                 //REVIEWED.





    /*public static void maze_1(int srow,int scol,int drow,int dcol,String ans)
    {   
        if(srow==drow && scol==dcol)
        {
            System.out.println(ans);
            return;
        }

        if(srow<drow)
            maze_1(srow+1,scol,drow,dcol,ans+"v");

        if(scol<dcol)
            maze_1(srow,scol+1,drow,dcol,ans+"h");
    }

    public static void main(String[] args)
    {
        maze_1(0,0,3,3,"");
    }*/                                                                //REVIEWED.




    
    /*public static void maze_2(int srow,int scol,int drow,int dcol,String ans)
    {   
        if(srow==drow && scol==dcol)
        {
            System.out.println(ans);
            return;
        }


        int count_r=drow-srow;
        for(int i=1;i<=count_r;i++)
        {  
            maze_2(srow+i,scol,drow,dcol,ans+'v'+i);
        }

        int count_c=dcol-scol;
        for(int i=1;i<=count_c;i++)
        { 
            maze_2(srow,scol+i,drow,dcol,ans+'h'+i);
        }

        
        for(int i=1;i<=count_c && i<=count_r;i++)
        {   
            maze_2(srow+1,scol+1,drow,dcol,ans+'d');
        }

    }


    public static void main(String[] args)
    {
        maze_2(0,0,2,2,"");
    }*/                                                                             //REVIEWED.

}