//import java.util.*;
public class Lecture_28
{   
    public static void minCost(int[][] local,int[][] global)                              //TO PRINT MIN COST IN THE MAZE.
    {
        for(int r=local.length-1;r>=0;r--)
        {
            for(int c=local[0].length-1;c>=0;c--)
            {
                if(r==local.length-1 && c==local[0].length-1)
                {   
                    global[r][c]=local[r][c];
                }
                else if(r==local.length-1)
                {
                    global[r][c]=local[r][c]+global[r][c+1];
                }
                else if(c==local[0].length-1)
                {
                    global[r][c]=global[r+1][c]+local[r][c];
                }
                else
                {
                    global[r][c]=Math.min(global[r][c+1],global[r+1][c])+local[r][c];
                }       
            }
        }

    }                                                                           //REVIEWED.





    public static void minPath(int[][] global2,int i,int j,String ans)            //TO PRINT MIN COST PATHS IN MAZE_PATH.
    {   
        if(i==global2.length-1 && j==global2[0].length-1)
        {   
            System.out.println(ans);
            return;
        }
        else if(i==global2.length-1)
        {
            minPath(global2,i,j+1,ans+"H");
        }
        else if(j==global2[0].length-1)
        {
            minPath(global2,i+1,j,ans+"V");
        }
        else 
        {
            if(global2[i][j+1]==global2[i+1][j])
            {
                minPath(global2,i,j+1,ans+"H");
                minPath(global2,i+1,j,ans+"V");
            }
            else if(global2[i][j+1]<global2[i+1][j])
            {
                minPath(global2, i, j+1, ans+"H");
            }
            else
            {
                minPath(global2, i+1, j, ans+"V");
            }

        }                                                     
    }                                                        //REVIEWED.     
    
    



    public static void maxGold(int[][] goldArr,int[][] global3)                 //TO GET MAX_GOLD IN MAZE.
    {
        for(int c=goldArr[0].length-1;c>=0;c--)
        {
            for(int r=0;r<goldArr.length;r++)
            {
                if(c==goldArr[0].length-1)
                {
                    global3[r][c]=goldArr[r][c];
                }
                else if(r==0)
                {
                    int max=Math.max(global3[r][c+1],global3[r+1][c+1]);
                    global3[r][c]=max+goldArr[r][c];
                }
                else if(r==goldArr.length-1)
                {
                    int max=Math.max(global3[r][c+1],global3[r-1][c+1]);
                    global3[r][c]=max+goldArr[r][c];
                }
                else
                {
                    int max1=Math.max(global3[r][c+1],global3[r+1][c+1]);
                    int max2=Math.max(max1,global3[r-1][c+1]);
                    global3[r][c]=max2+goldArr[r][c];
                }
            }
        }
    }                                                                         //REVIEWED.





    public static int binaryStringCount(int n)                   //TO RETURN COUNT OF BINARY STRINGS WITH 
    {                                                            //NO TWO CONSECUTIVE ZEROES.
        int c0=1;
        int c1=1;

        for(int i=2;i<=n;i++)
        {   
            int temp=c0;
            c0=c1;
            c1=c0+temp;
        }

        return c0+c1;
    }                                                      //REVIEWED. 



    public static void main(String[] args)
    {
        /*int[][] local={                                  //to get min cost in maze traversal.
            {2,7,3,8,0,3,1},
            {4,0,1,2,4,3,4},
            {3,8,5,9,0,8,1},
            {1,6,0,4,5,5,2},
            {6,2,9,5,7,0,6},
            {0,8,7,9,6,3,0},
            {1,3,5,0,5,1,0}
        };

        int[][] global=new int[local.length][local[0].length];

        minCost(local,global);                                   
        for(int i=0;i<global.length;i++)
        {
            for(int j=0;j<global.length;j++)
            {
                System.out.print(global[i][j]+"\t");
            }
            System.out.println();
        }*/                                                         //REVIEWED.


        
  
        /*int[][] local2={                                            //to print minimum cost paths, in maze_path traversal.
            {1,5,1,0,3},
            {1,4,0,2,3},
            {4,0,1,3,2},
            {2,4,0,4,1},
            {1,2,3,2,0}
        };

        int[][] global2=new int[local2.length][local2[0].length];
        minCost(local2,global2);
        minPath(global2,0,0,"");

        for(int i=0;i<global2.length;i++)
        {
            for(int j=0;j<global2.length;j++)
            {
                System.out.print(global2[i][j]+"\t");
            }
            System.out.println();
        }*/                                                             //REVIEWED.




        /*int[][] goldArr={                                            //to get max_gold in maze(gold digger).
            {1,5,1,0,3},
            {1,4,0,2,3},
            {4,0,1,3,2},
            {2,4,0,4,1},
            {1,2,3,2,0}
        };

        int[][] global3=new int[goldArr.length][goldArr[0].length];
        maxGold(goldArr,global3);

        for(int i=0;i<global3.length;i++)
        {
            for(int j=0;j<global3.length;j++)
            {
                System.out.print(global3[i][j]+"\t");
            }
            System.out.println();
        }*/                                                                   //reviewed.


        
        System.out.println(binaryStringCount(5));
    }                    




}