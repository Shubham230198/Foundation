//import java.util.*;

public class Lecture_22
{   

    /*public static void isPossible(boolean[][] board,int i,int j,int vsf)                 //TO GET TOTAL POSIBLE WAYS TO 
     {                                                                                   //COVER ALL THE POSITIONS in the
        if(vsf==board.length*board[0].length-1)                                          //CHESSBOARD BY KNIGHT
        {   
            //System.out.println(vsf);
            total++;
            return;
        }
        //total++;
        board[i][j]=true;

        if(i>=1 && j>=2 && board[i-1][j-2]==false )
        {
            isPossible(board, i-1, j-2, vsf+1);
        }
        if( i>=2 && j>=1 && board[i-2][j-1]==false)
        {
            isPossible(board, i-2, j-1, vsf+1);
        }
        if(i>=2 && (j+1)<=board.length-1 && board[i-2][j+1]==false)
        {
            isPossible(board, i-2, j+1, vsf+1);
        }
        if(i>=1 && (j+2)<=board.length-1 && board[i-1][j+2]==false)
        {
            isPossible(board, i-1, j+2, vsf+1);
        }
        if((i+1)<=board.length-1 && (j+2)<=board.length-1 && board[i+1][j+2]==false)
        {
            isPossible(board, i+1, j+2, vsf+1);
        }
        if((i+2)<=board.length-1 && (j+1)<=board.length-1 && board[i+2][j+1]==false)
        {
            isPossible(board, i+2, j+1, vsf+1);
        }
        if((i+2)<=board.length-1 && j>=1 && board[i+2][j-1]==false)
        {
            isPossible(board, i+2, j-1, vsf+1);
        }
        if((i+1)<=board.length-1 && j>=2 && board[i+1][j-2]==false)
        {
            isPossible(board, i+1, j-2, vsf+1);
        }

        board[i][j]=false;

    }
    
    static int total=0;
    public static void main(String[] args)
    {
        boolean[][] board=new boolean[5][5];

        isPossible(board,1,3,0);
        System.out.println(total);

        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                System.out.print(board[i][j]+"\t");
            }
            System.out.println();
        }
    }*/                                                       //REVIEWED





    static int counter=0;                                                //IT WILL PRINT ALL COMBINATIONS OF BOARD
    public static void position(int[][] board,int i,int j,int move)      //THAT ARE POSSIBLE TO COVER ALL THE BOARD
    {                                                                    //POSITIONS BY KNIGHT STARTING FROM (1,3) 
        board[i][j]=move;                                                //IN A 5x5 BOARD.

        if(move==board.length*board[0].length)
        {   
            counter++;
            System.out.println("*********"+counter+"*********");
            for(int r=0;r<board.length;r++)
            {
                for(int c=0;c<board[0].length;c++)
                {
                    System.out.print(board[r][c]+"\t");
                }
                System.out.println();
            }
            System.out.println("*********"+counter+"*********");
        }


        if(i>=1 && j>=2 && board[i-1][j-2]==0 )
        {
            position(board, i-1, j-2, move+1);
        }
        if( i>=2 && j>=1 && board[i-2][j-1]==0)
        {
            position(board, i-2, j-1, move+1);
        }
        if(i>=2 && (j+1)<=board.length-1 && board[i-2][j+1]==0)
        {
            position(board, i-2, j+1, move+1);
        }
        if(i>=1 && (j+2)<=board.length-1 && board[i-1][j+2]==0)
        {
            position(board, i-1, j+2, move+1);
        }
        if((i+1)<=board.length-1 && (j+2)<=board.length-1 && board[i+1][j+2]==0)
        {
            position(board, i+1, j+2, move+1);
        }
        if((i+2)<=board.length-1 && (j+1)<=board.length-1 && board[i+2][j+1]==0)
        {
            position(board, i+2, j+1, move+1);
        }
        if((i+2)<=board.length-1 && j>=1 && board[i+2][j-1]==0)
        {
            position(board, i+2, j-1, move+1);
        }
        if((i+1)<=board.length-1 && j>=2 && board[i+1][j-2]==0)
        {
            position(board, i+1, j-2, move+1);
        }

        board[i][j]=0;
    }

    public static void main(String[] args)
    {
        int[][] board=new int[5][5];


        position(board,1,3,1);
    }



}