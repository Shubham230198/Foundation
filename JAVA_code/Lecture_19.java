//import java.util.*;


public class Lecture_19
{   
    /*static String duplicates(String s1, String s2, String s3)                //CRYPTO PROBLEM.
    {   
        boolean[] check=new boolean[26];
        String ans="";
        for(int i=0;i<s1.length();i++)
        {   
            if(check[s1.charAt(i)-97]==false)
            {   
                ans+=s1.charAt(i);
                check[s1.charAt(i)-97]=true;
            }
        }

        for(int i=0;i<s2.length();i++)
        {   
            if(check[s2.charAt(i)-97]==false)
            {   
                ans+=s2.charAt(i);
                check[s2.charAt(i)-97]=true;
            }
        }

        for(int i=0;i<s3.length();i++)
        {   
            if(check[s3.charAt(i)-97]==false)
            {   
                ans+=s3.charAt(i);
                check[s3.charAt(i)-97]=true;
            }
        }

        return ans;
    }

    static int getnumber(String s,int[] map)
    {
        int num=0;
        int factor=1;

        for(int i=s.length()-1;i>=0;i--)
        {
            num+=factor*map[s.charAt(i)-97];
            factor*=10;
        }

        return num;
    }

    
    static void getmapping(String unique,int[] map, boolean[] check)
    {   
        if(unique.length()==0)
            {
                int n1=getnumber(s1, map);
                int n2=getnumber(s2, map);
                int n3=getnumber(s3, map);

                if(n1+n2==n3)
                {
                    System.out.print( ++counter + ".");
                    for(int j=0;j<map.length;j++)
                    {
                        if(map[j]!=-1)
                        {
                            System.out.print((char)(j+97)+"="+map[j]+" ");
                        }
                    }
                    System.out.println();
                }
                return;
            }


        for(int i=0;i<10;i++)
        {   
            
            //System.out.println(unique.length());
            char ch=unique.charAt(0);
            String roq=unique.substring(1,unique.length());

            if(check[i]==false)
            {
                map[ch-97]=i;
                check[i]=true;

                getmapping(roq, map, check);

                map[ch-97]=-1;
                check[i]=false;
            }
        }
    }

    static int counter=0;
    static String s1,s2,s3;
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        s1=scn.next();
        s2=scn.next();
        s3=scn.next();

        String unique=duplicates(s1,s2,s3);
        int[] map=new int[25];
        Arrays.fill(map, -1);
        boolean[] check=new boolean[10];

        getmapping(unique,map,check);
   
    }*/                                                  //REVIEWED.





    public static boolean issafe(int[][] board,int i, int j, int option)                        //SUDOKU PROBLEM
    {
        for(int jj=0;jj<board[0].length;jj++)
        {
            if(board[i][jj]==option)
                return false;
        }

        for(int ii=0;ii<board.length;ii++)
        {
            if(board[ii][j]==option)
                return false;
        }

        for(int ii=0;ii<3;ii++)
        {
            for(int jj=0;jj<3;jj++)
            {
                int row=(i/3)*3 + ii;
                int col=(j/3)*3 + jj;

                if(board[row][col]==option)
                    return false;
            }
        }

        return true;
    }

    public static void sudoku(int[][] board,int i, int j)
    {
        if(i==board.length && j==0)
        {   
            counter++;
            System.out.println("*********" + counter + "**********");
            
            for(int r=0;r<board.length;r++)
            {
                for(int c=0;c<board[0].length;c++)
                {
                    System.out.print(board[r][c]+" ");
                }
                System.out.println();
            }

            System.out.println("*********" + counter + "**********");

            return;
        }

        else if(j==board[0].length-1)
        {
            if(board[i][j]!=0)
            {
                sudoku(board,i+1,0);
            }
            else
            {   
                for(int option=1;option<10;option++)
                {   
                    if(issafe(board,i,j,option)==true)
                    {
                        board[i][j]=option;
                        sudoku(board,i+1,0);
                        board[i][j]=0;
                    }
                }
            }
        }

        else
        {
            if(board[i][j]!=0)
            {
                sudoku(board,i,j+1);
            }
            else
            {   
                for(int option=1;option<10;option++)
                {   
                    if(issafe(board,i,j,option)==true)
                    {
                        board[i][j]=option;
                        sudoku(board,i,j+1);
                        board[i][j]=0;
                    }
                }
            }
        }
    }

    static int counter=0;
    public static void main(String[] args)
    {
        int[][] board={
            {3, 0, 6, 5, 0, 8, 4, 0, 0},  
            {5, 2, 0, 0, 0, 0, 0, 0, 0},  
            {0, 8, 7, 0, 0, 0, 0, 3, 1},  
            {0, 0, 3, 0, 1, 0, 0, 8, 0},  
            {9, 0, 0, 8, 6, 3, 0, 0, 5},  
            {0, 5, 0, 0, 9, 0, 6, 0, 0},  
            {1, 3, 0, 0, 0, 0, 2, 5, 0},  
            {0, 0, 0, 0, 0, 0, 0, 7, 4},  
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        sudoku(board,0,0);
    }                                                 //REVIEWED.
    
}