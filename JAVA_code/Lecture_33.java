//import java.util.*;
public class Lecture_33
{   
    public static int[][] countAllPalindromicSubSequence(String s)
    {
        int[][] global=new int[s.length()][s.length()];

        for(int gap=0;gap<global.length;gap++)
        {
            for(int r=0;r<global.length-gap;r++)
            {
                int c=r+gap;

                if(gap==0)
                {
                    global[r][c]=1;
                }
                else if(gap==1)
                {
                    if(s.charAt(r)==s.charAt(c))
                        global[r][c]=3;
                    else
                        global[r][c]=2;
                }

                else if(s.charAt(r)==s.charAt(c)) 
                {
                    global[r][c]=global[r][c-1]+global[r+1][c]+1;
                }
                else
                {
                    global[r][c]=global[r][c-1]+global[r+1][c]-global[r+1][c-1];
                }
            }
        }

        return global;
    }





    static int maxGap=0;
    static int countOfPSS=0;

    public static boolean[][] countAllPalindromicSubString(String s)
    {   
        boolean[][] global2=new boolean[s.length()][s.length()];

        for(int gap=0;gap<global2.length;gap++)
        {
            for(int r=0;r<global2.length-gap;r++)
            {
                int c=r+gap;

                if(gap==0)
                {
                    global2[r][c]=true;
                    countOfPSS++;
                }
                else if(gap==1)
                {
                    if(s.charAt(r)==s.charAt(c))
                    {
                        global2[r][c]=true;
                        maxGap=gap;
                        countOfPSS++;
                    }
                }

                else if(s.charAt(r)==s.charAt(c) && global2[r+1][c-1]==true)
                {
                    global2[r][c]=true;
                    maxGap=gap;
                    countOfPSS++;
                }
                else
                {
                    global2[r][c]=false;
                }
            }
        }

        return global2;
    }





    public static int[][] subStringDivisible(String s,int k)
    {
        int[][] global3=new int[s.length()][k];

        for(int j=0;j<global3.length;j++)
        {
            if(j==0 || j==(s.charAt(0)-48)%k)
                global3[0][j]+=1;
        }

        for(int r=0;r<global3.length-1;r++)
        {
            for(int c=0;c<global3[0].length;c++)
            {
                global3[r+1][c]+=global3[r][c];

                int num=c*10 + (s.charAt(r+1)-48);
                num%=k;

                global3[r+1][num]+=global3[r][c];
            }
        }

        return global3;
    }



    public static void main(String[] args)
    {
        /*int[][] global=countAllPalindromicSubSequence("abckycbc");
        for(int i=0;i<global.length;i++)
        {
            for(int j=0;j<global.length;j++)
            {
                System.out.print(global[i][j] + "\t");
            }
            System.out.println();
        }*/



        /*boolean[][] global2=countAllPalindromicSubString("abccbc");
        for(int i=0;i<global2.length;i++)
        {
            for(int j=0;j<global2.length;j++)
            {
                System.out.print(global2[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("longest pallindromic sub string is of length " + (maxGap+1));
        System.out.println("total count of pallindromic sub strings are " + countOfPSS);
        */


        int[][] global3=subStringDivisible("235168", 6);
        for(int i=0;i<global3.length;i++)
        {
            for(int j=0;j<global3.length;j++)
            {
                System.out.print(global3[i][j] + "\t");
            }
            System.out.println();
        }

    }
}