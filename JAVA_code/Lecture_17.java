//import java.util.*;


public class Lecture_17
{
    
    /*public static boolean issafe(boolean[][] arr,int ci,int cj)                                   //N_QUEENS chess board problem
    {
        for(int j=cj-1;j>=0;j--)
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





    /*public static boolean issafe_knight(boolean[][] arr,int ci,int cj)                             //N_KNIGHTS in chess board problem.
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
    }*/                                                                                  //REVIEWED.





    public static boolean issafe_knight(boolean[][] arr,int ci,int cj)                             //N_KNIGHTS in chess board problem.
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
                System.out.println(ans);
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
        boolean[][] arr=new boolean[n][n];
        knight(arr,0,0,0," ");
    }
}