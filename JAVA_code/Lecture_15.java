                                                            //Lecture-15
                                                            //July-10

//import java.util.*;
public class Lecture_15
{
    /*public static void maze_flood_flow(int sr,int sc,int[][] maze,String ans)              //FLOOD_FLOW_MAZE PROBLEM
    {   
        if(sr==maze.length-1 && sc==maze[0].length-1)
        {
            System.out.println(ans);
            return;
        }

        maze[sr][sc]=2;
        if(sr>0 && maze[sr-1][sc]!=1 && maze[sr-1][sc]!=2)
        {
            maze_flood_flow(sr-1,sc,maze,ans+"u");
        }   

        if(sc>0 && maze[sr][sc-1]!=1 && maze[sr][sc-1]!=2)
        {
            maze_flood_flow(sr,sc-1,maze,ans+ "l");
        }

        if(sr<maze.length-1 && maze[sr+1][sc]!=1 && maze[sr+1][sc]!=2)
        {
            maze_flood_flow(sr+1,sc,maze,ans+ "d");
        }
        
        if(sc<maze[0].length-1 && maze[sr][sc+1]!=1 && maze[sr][sc+1]!=2)
        {
            maze_flood_flow(sr, sc+1, maze, ans+ "r");
        }
        
        maze[sr][sc]=0;
    }

    public static void main(String[] args)
    {   
        int[][] maze={
            {0,1,0,0,0,0,0,1},
            {0,1,0,1,1,1,0,1},
            {0,1,0,1,0,0,0,1},
            {0,0,0,0,0,1,1,1},
            {0,1,0,1,0,0,0,0},
            {0,1,0,1,1,1,1,0},
            {0,1,0,1,1,1,1,0},
            {0,1,0,0,0,0,0,0}
        };

        maze_flood_flow(0, 0, maze, "");
    }*/                                                   //REVIEWED.




    /*public static void box_permutations(boolean[] boxes, int co, int to,String ans)           //PERMUTATIONS OF OBJECTS IN BOXES.        
    {   
        if(co>to)
        {
            System.out.println(ans);
            return ;
        }

        for(int i=0;i<boxes.length;i++)
        {
            if(boxes[i])
            {   
                
                boxes[i]=false;
                box_permutations(boxes,co+1,to,ans+co+"[" + "b" + i +"] " );
                boxes[i]=true;
            }
           
        }
    }
    public static void main(String[] args)
    {
        boolean[] boxes={true,true,true,true,true};
        box_permutations(boxes,1,2,"");
        System.out.println(boxes.length);
    }*/                                                                        //REVIEWED.





    /*public static void box_combinations(boolean[] boxes, int co, int to,int lob,String ans)        //COMBINATIONs OF OBJECTS INTO BOXES.        //PERMUTATIONS OF OBJECTS IN BOXES.        
    {   
        if(co>to)                                                                    //here lob is the box in which last object is
        {                                                                            //placed, so after that the remaining objects 
            System.out.println(ans);                                                 //would be placed in the boxes with greater 
            return ;                                                                 //indexs, this will lead to production of ans
        }                                                                            //in sorted order, which in turn eliminate the          
                                                                                     //various permutations from the result and will 
        for(int i=lob+1;i<boxes.length;i++)                                          //keep just one from them.
        {
            if(boxes[i])
            {   
                
                boxes[i]=false;
                box_combinations(boxes,co+1,to,i,ans+co+"[" + "b" + i +"] " );
                boxes[i]=true;
            }
           
        }
    }
    public static void main(String[] args)
    {
        boolean[] boxes={true,true,true,true,true};
        box_combinations(boxes,1,2,-1,"");
    }*/                                                                //REVIEWED.

}