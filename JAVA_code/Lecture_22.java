                                        //Lecture-22
                                        //July-18

import java.util.*;
public class Lecture_22
{   
    //Pre-requist for dealing with graph.
    public static class Edge {
        int nebr = -1;
        int wt = -1;

        Edge(int n, int w) {
            this.nebr = n;
            this.wt = w;
        }
    }
    static ArrayList<ArrayList<Edge> > graph = new ArrayList<>();

    
    static void addEdge(int u, int v, int wt) {
        graph.get(u).add(new Edge(v, wt));
        graph.get(v).add(new Edge(u, wt));
    }


    static void display() {
        for(int i = 0; i < graph.size(); i++) {
            System.out.print(i + " -> ");
            for(int j = 0; j < graph.get(i).size(); j++) {
                System.out.print( "[ " + graph.get(i).get(j).nebr + ", " + graph.get(i).get(j).wt + "], ");
            }
            System.out.println();
        }
    }

    //REVIEWED.


    //1. To get MinmimunCost path, maximumCost path, ceilCost path, floorCost path.

    static int minCost = Integer.MAX_VALUE;
    static String minCostPath = "";
    static int maxCost = Integer.MIN_VALUE;
    static String maxCostPath = "";

    static int ceilCost = Integer.MAX_VALUE;
    static String ceilCostPath = "";
    static int floorCost = Integer.MIN_VALUE;
    static String floorCostPath = "";

    static void getSmallerLargerCeilFloorPath(int u, int v, boolean[] visited, int cost, String path, int factor) {
        if(u == v) {
            if(cost > maxCost) {                 //for maxCost path.
                maxCost = cost;
                maxCostPath = path + v;
            }

            if(cost < minCost) {                //for minCost path.
                minCost = cost;
                minCostPath = path + v;
            }

            if(cost > factor && cost < ceilCost) {         //for ceilCost path.
                ceilCost = cost;
                ceilCostPath = path + v;
            }

            if(cost < factor && cost > floorCost) {        //for floorCost path.
                floorCost = cost;
                floorCostPath = path + v;
            }
        }
        
        visited[u] = true;
        for(int i = 0; i < graph.get(u).size(); i++) {
            Edge e = graph.get(u).get(i);
            if(visited[e.nebr] == false) {
                getSmallerLargerCeilFloorPath(e.nebr, v, visited, cost + e.wt, path + u, factor);
            } 
        }
        visited[u] = false;
    }

    //REVIEWED.



    //2. Hamiltonian path ( cycles too)

    static void hamil(int s, String pathSoFar, int countSoFar, int originalSource, boolean[] visited) {
        if(countSoFar == graph.size() - 1) {
            System.out.print(pathSoFar);

            for(int i = 0; i < graph.get(s).size(); i++) {
                Edge e = graph.get(s).get(i);
                if(e.nebr == originalSource){
                    System.out.print(" cycle too");
                }
            }
            System.out.println();
            return;
        }

        visited[s] = true;
        for(int i = 0; i < graph.get(s).size(); i++) {
            Edge e = graph.get(s).get(i);
            if(visited[e.nebr] == false) {
                hamil(e.nebr, pathSoFar + s, countSoFar + 1, originalSource, visited);
            }
        }
        visited[s] = false;
    }

    //REVIEWED.






    //3. knight to cover whole chess board question. (implementation of hamiltonian path)

    static int counter=0;                                                //IT WILL PRINT ALL permutation OF BOARD
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
            board[i][j] = 0;
            return;
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

    //REVIEWED
    
    
    
    
    
    //4. Astronaut-space team problen (in how many ways 2 astronaut of two different nation could be sent to space)
    
    static ArrayList<ArrayList<Edge>> nations = new ArrayList<>();
    
    static void addEdgeForAstro(int v, int u) {
        nations.get(v).add(new Edge(u, 1));
        nations.get(u).add(new Edge(v, 1));
    }
    
    static String gscc(int s, boolean[] astroVisited) {
        String str = "";
        Queue<Integer> que = new LinkedList<>();
        que.add(s);
        
        astroVisited[s] = true;
        
        while(que.isEmpty() == false) {
            int rem = que.peek();         //get
            
            que.remove();                //remove
            
            astroVisited[rem] = true;     //mark
            
            str += rem;                  //work
            
            for(int i = 0; i < nations.get(rem).size(); i++) {      //add nebr
                Edge e = nations.get(rem).get(i);
                if(astroVisited[e.nebr] == false) {
                    que.add(e.nebr);
                }
            }
        }
        
        return str;
    }
    
    
    static void gcc(boolean[] astroVisited) {
        ArrayList<String> nationList = new ArrayList<>();
        
        for(int i = 1; i < nations.size(); i++) {
            if(astroVisited[i] == false) {
                String str = gscc(i, astroVisited);
                nationList.add(str);
            }
        }
        
        for(String s : nationList) {              //printing nation members
            System.out.print(s + ", ");
        }
        System.out.println();
        
        int teams = 0;
        for(int i = 0; i < nationList.size(); i++) {
            for(int j = i + 1; j < nationList.size(); j++) {
                teams += (nationList.get(i).length() * nationList.get(j).length());
            }
        }
        System.out.println("total number of ways - " + teams);
        
    }
    
    
    static void astronautSpace(int n, ArrayList<Integer> v1, ArrayList<Integer> v2) {
        
        for(int i = 0; i <= n; i++){                //adding all nations(0th index dummy nation)
            nations.add(new ArrayList<Edge>());
        }
        
        for(int i = 0; i < v1.size(); i++) {
            addEdgeForAstro(v1.get(i), v2.get(i));
        }
        
        boolean[] astroVisited = new boolean[nations.size()];      //can't make it global, becoz 
        gcc(astroVisited);                                         //there will be problem in size.
    }
    
    //REVIEWED.




    public static void main(String[] args)
    {
        //pre-requist for graph
        for(int i = 0; i < 7; i++) {
            graph.add(new ArrayList<>());
        }
        
        addEdge(0,1,10);
        addEdge(1,2,10);
        addEdge(2,3,10);
        addEdge(0,3,40);
        addEdge(2,5,5);            //extra edge between 2,5.
        addEdge(3,4,2);
        addEdge(4,5,3);
        addEdge(5,6,3);
        addEdge(4,6,8);
        
        boolean[] visited = new boolean[graph.size()];
        //reviewed.



        //1. to print floorpath, ceilpath, minCost path, maxCost path.

        /*getSmallerLargerCeilFloorPath(0, 6, visited, 0, "", 40);     //taking factor as 40
        
        System.out.println("maxCost path - " + maxCostPath + " @ " + maxCost);
        System.out.println("minCost path - " + minCostPath + " @ " + minCost);
        System.out.println("floorCost path - " + floorCostPath + " @ " + floorCost);
        System.out.println("ceilCost path - " + ceilCostPath + " @ " + ceilCost);
        */

        //reviewed.
        


        //2. hamiltonian paths ( cycles too)

        /*int s = 0;
        String pathSoFar = "";
        int countSoFar = 0;
        int originalSource = s;
        hamil(s, pathSoFar, countSoFar, originalSource, visited);
        */

        //reviewed.




        //3. knight problem to cover all the chess board. (implementation of hamiltonian path)
        
        /*int[][] board=new int[5][5];
        position(board,1,3,1);                //startin position (1, 3)
        */
        
        //reviewed.




        //4. ASTRONAUT_PROBLEM                      (implementation of BFS)
                                                    //need its own graph, (nations)
        /*int n = 9;
        ArrayList<Integer> v1 = new ArrayList<>(Arrays.asList(1,2,3,4,8));
        ArrayList<Integer> v2 = new ArrayList<>(Arrays.asList(7,6,4,7,2)); 
        astronautSpace(n, v1, v2);
        */
        
        //reviewed.


    }



}