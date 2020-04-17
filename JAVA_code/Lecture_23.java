                                                //LECTURE-23
                                                //july-

import java.util.*;
public class Lecture_23
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
    
    

    //1. BFS traversal
    
    static boolean bfs(int src, int des, boolean[] visited) {      //here, instead of making visited global,
        Queue<Integer> que = new LinkedList<>();                     //we have passed visited array in function
        que.add(src);                                                //arguments, so during it's size declaration
                                                                     //i dont need to define its size as constant
        while(que.isEmpty() == false) {                              //, as we have to do in cpp.
            int rem = que.poll();           //get and remove

            visited[rem] = true;            //mark

            if(rem == des) {                //work
                return true;
            }

            for(int i = 0; i < graph.get(rem).size(); i++) {     //add nebr.
                Edge e = graph.get(rem).get(i);
                if(visited[e.nebr] == false) {
                    que.add(e.nebr);
                }
            }
        }
        
        return true;
    }

    //REVIEWED.



    

    //2. GET_CONNECTED_COMPONENTS for a graph

    static String gscc(int s, boolean[] visited) {
        String str = "";
        Queue<Integer> que = new LinkedList<>();
        que.add(s);
        
        while(que.isEmpty() == false) {
            int rem = que.poll();           //GET and REMOVE at the same time

                                            //don't need to mark, as already done proactively,(so 
                                            //no duplicate gets added to queue)

            str += rem;                    //WORK

            for(int i = 0; i < graph.get(rem).size(); i++) {      //ADD NEBR
                Edge e = graph.get(rem).get(i);
                if(visited[e.nebr] == false) {
                    visited[e.nebr] = true;
                    que.add(e.nebr);
                }
            }
        }

        return str;
    }



    static void gcc(boolean[] visited) {
        ArrayList<String> components = new ArrayList<>();

        for(int i = 0; i < graph.size(); i++) {
            if(visited[i] == false) {
                visited[i] = true;
                String str = gscc(i, visited);
                components.add(str);
            }
        }

        for(String x : components) {
            System.out.print(x + ", ");
        }

    }
    
    //REVIEWED.
    







    //3. ROTTEN_ORANGES_PROBLEM.               (implementation of bfs)

    static class point {
        int x = -1;
        int y = -1;
        int t = -1;

        point(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }


    static void rottenOranges(int[][] board, int time) {
        Queue<point> que = new LinkedList<>();
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 2) {
                    point p = new point(i, j, 0);
                    que.add(p);   
                }
            }
        }

        while(que.isEmpty() == false) {
            point p1 = que.poll();              //get and remove

            //here, work is done prior to marking. 
            if(p1.t == time + 1){               //WORK
                break;
            }

            board[p1.x][p1.y] = 2;              //mark

            if(p1.x - 1 >= 0 && board[p1.x - 1][p1.y] == 1) {          //add nebr
                que.add(new point(p1.x - 1, p1.y, p1.t + 1));
            }
            if(p1.y + 1 < board[0].length && board[p1.x][p1.y + 1] == 1) {
                que.add(new point(p1.x, p1.y + 1, p1.t + 1));
            }
            if(p1.x + 1 < board.length && board[p1.x + 1][p1.y] == 1) {
                que.add(new point(p1.x + 1, p1.y, p1.t + 1));
            }
            if(p1.y - 1 >= 0 && board[p1.x][p1.y - 1] == 1) {
                que.add(new point(p1.x, p1.y - 1, p1.t + 1));
            }
            
        }

        for(int i = 0; i < board.length; i++) {               //printing conditon of board after time.
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

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



        //1. BFS searching.
        
        /*int src = 0;
        int des = 6;
        System.out.println(bfs(src, des, visited));
        */

        //reviewed.





        //2. GET_CONNECTED_COMPONENTS                   (implementation of bfs)

        /*
        gcc(visited);
        */

        //reviewed.





        //3. ROTTEN_ORANGES_PROBLEM                    (implementation of bfs)
        
        /*
        int[][] board = {
            {2,1,0,2,1},
            {1,0,1,2,1},
            {1,0,0,2,1}
        };

        int time = 1;
        rottenOranges(board, time);
        */

        //reviewed.

    }


}