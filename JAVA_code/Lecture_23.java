//import java.util.*;
public class Lecture_23
{   
    /*static class point                                      //FIRE-STROM PROBLEM
    {                                                      
            int x;
            int y;
            int t;
    }

    public static void boardCondition(int[][] board,int time)
    {
        ArrayDeque<point> q=new ArrayDeque<>();
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==1)
                {
                    point t0=new point();
                    t0.x=i;
                    t0.y=j;
                    t0.t=1;
                    q.addLast(t0);
                }
            }
        }


        while(q.size()>0)
        {
            point rem=q.getFirst();
            q.removeFirst();

            if(rem.t==time+2)
            {
                break;
            }

            if(board[rem.x][rem.y]<0)
            {
                continue;
            }

            board[rem.x][rem.y]=-rem.t;

            if(rem.x-1>=0 && board[rem.x-1][rem.y]==0)
            {
                point np=new point();
                np.x=rem.x-1;
                np.y=rem.y;
                np.t=rem.t+1;
                q.addLast(np);
            }

            if(rem.y+1<board[0].length && board[rem.x][rem.y+1]==0)
            {
                point np=new point();
                np.x=rem.x;
                np.y=rem.y+1;
                np.t=rem.t+1;
                q.addLast(np);

            }

            if(rem.x+1<board.length && board[rem.x+1][rem.y]==0)
            {
                point np=new point();
                np.x=rem.x+1;
                np.y=rem.y;
                np.t=rem.t+1;
                q.addLast(np);

            }

            if(rem.y-1>=0 && board[rem.x][rem.y-1]==0)
            {
                point np=new point();
                np.x=rem.x;
                np.y=rem.y-1;
                np.t=rem.t+1;
                q.addLast(np);

            }
        }
        
    }

    public static void main(String[] args)
    {
        int[][] board={
            {1,2,0,2,0,0,0},
            {0,2,0,2,0,1,0},
            {0,0,0,2,0,0,0},
            {2,2,2,2,2,2,0},
            {0,2,1,0,0,0,0},
            {0,2,0,0,0,0,0},
            {0,2,0,0,0,0,0},
        };


        boardCondition(board,3);

        for(int r=0;r<board.length;r++)
        {
            for(int c=0;c<board[0].length;c++)
            {
                System.out.print(board[r][c]+ "\t");
            }
            System.out.println();
        }

    }*/                                                     //REVIEWED.


}