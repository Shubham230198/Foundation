//import java.util.*;

public class Lecture_32
{   
    static int[][] longestCommonSubSequence(String s1,String s2)                    //TO GET LENGTH LONGEST COMMON SUBSEQUENCE.
    {
        int[][] global=new int[s1.length()+1][s2.length()+1];

        for(int r=global.length-1;r>=0;r--)
        {
            for(int c=global[0].length-1;c>=0;c--)
            {
                if(r==global.length-1 && c==global[0].length-1)
                {
                    global[r][c]=0;
                }
                else if(r==global.length-1)
                {
                    global[r][c]=0;
                }
                else if(c==global[0].length-1)
                {
                    global[r][c]=0;
                }
                else
                {
                    if(s1.charAt(r)==s2.charAt(c))
                        global[r][c]=1+global[r+1][c+1];

                    else
                        global[r][c]=Math.max(global[r+1][c],global[r][c+1]);
                }
            }
        }
        return global;
    }                                                                       //REVIEWED.




    static void longestCommonSubSequencePath(String s1,String s2,int i,int j,int[][] global2,String ans)   //TO GET LONGEST COMMON
    {                                                                                                      //SUBSEQUENCE.
        if(i==global2.length-1 && j==global2.length-1)
        {
            System.out.println(ans);
            return;
        }

        if(s1.charAt(i)==s2.charAt(j))
        {
            ans+=s1.charAt(i);
            longestCommonSubSequencePath(s1, s2, i+1, j+1, global2, ans);
        }
        else
        {
            if(global2[i+1][j]>global2[i][j+1])
            {
                longestCommonSubSequencePath(s1, s2, i+1, j, global2, ans);
            }
            else
            {
                longestCommonSubSequencePath(s1, s2, i, j+1, global2, ans);
            }
        }
    }                                                                                 //REVIEWED.





    static int[][] longestPalindromeSubSequence(String s)        //TO GET LENGTH OF LONGEST PALINDROMIC SUB SEQUENCE OF A STRING.
    {
        int[][] global3=new int[s.length()][s.length()];

        for(int gap=0;gap<global3.length;gap++)                  //diagonal loop, (for a matrix).
         {   
            for(int r=0;r<global3.length-gap;r++)
            {   
                int c=r+gap;

                if(gap==0)
                {
                    global3[r][c]=1;
                }
                else if(gap==1)
                {
                    if(s.charAt(r)==s.charAt(c))
                        global3[r][c]=2;
                    else
                        global3[r][c]=1;
                }
                else if(s.charAt(r)==s.charAt(c))
                {
                    global3[r][c]=2+global3[r+1][c-1];
                }
                else
                    global3[r][c]=Math.max(global3[r+1][c],global3[r][c-1]);
            
            }
        }

        return global3;
    }                                                                       //REVIEWED.



    public static void main(String[] args)
    {
        
        /*int[][] global= longestCommonSubSequence("abcd","aebd");               //count of longest common subsequence.
        for(int i=0;i<global.length;i++)
        {
            for(int j=0;j<global[0].length;j++)
            {
                System.out.print(global[i][j] + "\t");
            }
            System.out.println();
        }*/                                                                        //reviewed.
    
    

        int[][] global2=longestCommonSubSequence("abcd","aebd");                //to get longest common subsequence, by recursion
        longestCommonSubSequencePath("abcd","aebd",0,0,global2,"");             //and DP both.
                                                                                     //reviewed.


                                                                                     
        /*int[][] global3=longestPalindromeSubSequence("abckycbc");                //length of longest palindromic sub sequence.
        for(int i=0;i<global3.length;i++)
        {
            for(int j=0;j<global3.length;j++)
            {
                System.out.print(global3[i][j] + "\t");
            }
            System.out.println();
        }*/                                                                         //reviewed.
    }
}