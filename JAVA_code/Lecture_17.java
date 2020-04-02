                                            //Lecture-17
                                            //July - 12

import java.util.*;
public class Lecture_17
{
                                                                            
    /*public static boolean issafe(boolean[][] arr,int ci,int cj)                                   //N_QUEENS chess board problem(queens at levels, boxes as option)
    {                                                                                                  //1.keeping queens at levels, and boxes as options
        for(int j=cj-1;j>=0;j--)                                                                       //2.This is just combination.
        {   
            if(arr[ci][j]==true)
                return false;
        }
        for(int i=ci-1;i>=0;i--)
        {
            if(arr[i][cj]==true)
                return false;
        }

        for(int i=ci-1, j=cj-1; i>=0 && j>=0; i--,j--)
        {
            if(arr[i][j]==true)
                return false;
        }

        for(int i=ci-1,j=cj+1; i>=0 && j<=arr[0].length-1; i--, j++)
        {
            if(arr[i][j]==true)
                return false;
        }

        return true;
    }

    static int counter = 0;
    public static void queen(boolean[][] arr,int cq,int tq,String ans,int lqi,int lqj)
    {
        if(cq==tq)
        {
            System.out.println(++counter +". "+ ans);
            return;
        }


        for(int i=lqi;i<arr.length;i++)
        {
            for(int j=(i==lqi?lqj + 1:0);j<arr[0].length;j++)
            {
                if(arr[i][j]==false && issafe(arr,i,j))
                {
                    arr[i][j]=true;
                    queen(arr, cq+1, tq, ans+ i + j+" ",i,j);
                    arr[i][j]=false;
                }
            }
        }
    }

    public static void main(String[] args) 
    {
        int n=4;
        boolean[][] arr = new boolean[n][n];
        queen(arr,0,n,"",0,-1);
    }*/                                                                    //REVIEWED.







    /*public static boolean issafe_knight(boolean[][] arr,int ci,int cj)                             //N_KNIGHTS in chess board problem(knights at levels, boxes as option).
    {                                                                   
        if(ci>=1 && cj>=2 && arr[ci-1][cj-2]==true)
            return false;
        else if(ci>=2 && cj>=1 && arr[ci-2][cj-1]==true)
            return false;
        else if(ci>=2 && cj<=arr[0].length-2 && arr[ci-2][cj+1]==true)
            return false;
        else if(ci>=1 && cj<=arr[0].length-3 && arr[ci-1][cj+2]==true)
            return false;
        else
            return true;
    }

    static int counter = 0;
    public static void knight(boolean[][] arr,int cq,int tq,String ans,int lqi,int lqj)
    {
        if(cq==tq)
        {
            System.out.println(++counter +". "+ ans);
            return;
        }


        for(int i=lqi;i<arr.length;i++)
        {
            for(int j=(i==lqi?lqj + 1:0);j<arr[0].length;j++)
            {
                if(arr[i][j]==false && issafe_knight(arr,i,j))
                {
                    arr[i][j]=true;
                    knight(arr, cq+1, tq, ans+ i + j+" ",i,j);
                    arr[i][j]=false;
                }
            }
        }
    }

    public static void main(String[] args) 
    {
        int n=4;
        boolean[][] arr = new boolean[n][n];
        knight(arr,0,n,"",0,-1);
    }*/                                                                                 //REVIEWED.








    /*public static boolean isSafe(boolean[][] chess, int r, int c) {                       //N_QUEEN problem.
                                                                                             //(keeping boxes at levels, queens as options)
        for(int i = r - 1; i >= 0; i--) {
            if(chess[i][c] == true) {
                return false;
            }
        }

        for(int j = c - 1; j >= 0; j--) {
            if(chess[r][j] == true) {
                return false;
            }
        }

        for(int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if(chess[i][j] == true) {
                return false;
            }
        }

        for(int i = r - 1, j = c + 1; i >= 0 && j < chess[0].length; i--, j++) {
            if(chess[i][j] == true) {
                return false;
            }
        }
        
        return true;
    }
    
    static int count = 0;
    public static void n_queens(boolean[][] chess, int i, int j, int qsf, String s) {
        if(i == chess.length && j == 0) {
            if(qsf == chess.length) {
                System.out.println(++count + "->" + s);
            }
            return;
        }
        
        if(j == chess[0].length - 1) {
            n_queens(chess, i + 1, 0, qsf, s);
            if(isSafe(chess, i , j) == true) {
                chess[i][j] = true;
                n_queens(chess, i + 1, 0, qsf + 1, s + i + j + " ");
                chess[i][j] = false;
            }
        }
        else {
            n_queens(chess, i, j + 1, qsf, s);
            if(isSafe(chess, i, j) == true) {
                chess[i][j] = true;
                n_queens(chess, i, j + 1, qsf + 1, s + i + j + " ");
                chess[i][j] = false;
            }
        }
    }


    public static void main(String[] args) {
        int n = 4;
        boolean[][] chess = new boolean[n][n];
        n_queens(chess, 0, 0, 0, "");
    }*/                                                                         //REVIEWED.








    
    /*public static boolean issafe_knight(boolean[][] arr,int ci,int cj)                             //N_KNIGHTS in chess board problem(boxes at levels, queens as options).
    {
        if(ci>=1 && cj>=2 && arr[ci-1][cj-2]==true)
            return false;
        else if(ci>=2 && cj>=1 && arr[ci-2][cj-1]==true)
            return false;
        else if(ci>=2 && cj<=arr[0].length-2 && arr[ci-2][cj+1]==true)
            return false;
        else if(ci>=1 && cj<=arr[0].length-3 && arr[ci-1][cj+2]==true)
            return false;
        else
            return true;
    }

    static int count=0;
    public static void knight(boolean[][] arr,int i, int j,int ksf ,String ans)
    {
        if(i==arr.length && j==0)
        {   
            if(ksf==arr.length)
                System.out.println(++count + "-> " + ans);
            return;
        }
        else if(j==arr[0].length-1)
        {
            knight(arr,i+1,0,ksf,ans);
            if(issafe_knight(arr,i,j)==true)
            {
                arr[i][j]=true;
                knight(arr,i+1,0,ksf+1,ans+i+j+" ");
                arr[i][j]=false;
            }
        }
        else
        {
            knight(arr,i,j+1,ksf,ans);
            if(issafe_knight(arr,i,j)==true)
            {
                arr[i][j]=true;
                knight(arr,i,j+1,ksf+1,ans+i+j+" ");
                arr[i][j]=false;
            }
        }
    
    }
    public static void main(String[] args)
    {
        int n=4;
        boolean[][] arr=new boolean[3][3];
        knight(arr,0,0,0,"");
    }*/                                                                    //REVIEWED.
}