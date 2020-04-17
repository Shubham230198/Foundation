                                        //LECTURE_24
                                        //JULY-20

import java.util.*;
public class Lecture_24
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

    





    //1. IS_CONNECTED                  (to check if all vertices of a graph, are connected)

    static String gscc(int s, boolean[] visited) {      //helping component function.
        String str = "";
        Queue<Integer> que = new LinkedList<>();
        que.add(s);

        while(que.isEmpty() == false) {
            int rem = que.peek();       //GET
            que.remove();               //REMOVE

            visited[rem] = true;        //MARK

            str += "rem";               //WORK, (but we don't need that string return, here in IS_CONNECTED)

            for(int i = 0; i < graph.get(rem).size(); i++) {
                Edge e = graph.get(rem).get(i);
                if(visited[e.nebr] == false) {
                    que.add(e.nebr);
                }
            }
        }

        return str;
    }


    static boolean isConnected(boolean[] visited) {
        String str = gscc(0, visited);

        for(int i = 0; i < graph.size(); i++) {
            if(visited[i] == false) 
                return false;
        }

        return true;
    }

    //REVIEWED.








    //2. IS_CYCLIC,  (to check if any part of graph, contains a cycle)
    
    static boolean isCyclicComponent(int s, boolean[] visited) {
        Queue<Integer> que = new LinkedList<>();                   //PRO_ACTIVE addition won't work here.
        que.add(s);

        while(que.isEmpty() == false) {
            int rem = que.poll();        //GET and REMOVE.

            if(visited[rem] == true) {    //WORk
                return true;
            } 

            visited[rem] = true;         //MARK


            for(int i = 0 ; i < graph.get(rem).size(); i++) {           //ADD NEBR.
                Edge e = graph.get(rem).get(i);
                if(visited[e.nebr] == false) {
                    que.add(e.nebr);
                }
           }
        }

        return false;
    }


    static boolean isCyclic(boolean[] visited) {
        boolean flag = false;
        
        for(int i= 0; i < graph.size(); i++) {
            if(visited[i] == false) {
                flag = isCyclicComponent(i, visited);
                if(flag == true) {
                    return true;
                }
            }
        }

        return false;
    }

    //REVIEWED.








    //3. IS_BIPARTITE         (to check if a graph is bi-graph)

    static class BiPair {
        int vertex = -1;
        int level = -1;
        
        BiPair(int v, int l) {
            this.vertex = v;
            this.level = l;
        }
    }


    static boolean isCompBipartite(int s, int[] visited) {        //to check if a component is bipartite
        Queue<BiPair> que = new LinkedList<>();                   //(using pro-active method.)
        que.add(new BiPair(s, 1));

        while(que.isEmpty() == false) {
            BiPair bp = que.poll();             //GET and REMOVE
            
            visited[bp.vertex] = bp.level;      //MARK

            for(int i = 0; i < graph.get(bp.vertex).size(); i++) {     //ADD NEBR, with being pro-active.
                Edge e = graph.get(bp.vertex).get(i);
                if(visited[e.nebr] == 0) {
                    que.add(new BiPair(e.nebr, bp.level + 1));
                }
                else {                                                  //WORK
                    int oldLevel = visited[e.nebr];
                    int newLevel = bp.level + 1;

                    if(oldLevel % 2 != newLevel % 2) 
                        return false;
                }
            }
        }

        return true;
    }


    static boolean isBipartite() {                        //to check if graph is bipartite.
        int[] visited = new int[graph.size()];

        for(int i = 0; i < graph.size(); i++) {         //BEING PRO_ACTIVE HERE(so que, don't face duplicates).
            if(visited[i] == 0) {
                visited[i] = 1;
                boolean flag = isCompBipartite(i, visited);
                if(flag == false) {
                    return false;
                }
            }
        }

        return true;
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



        //1. IS_CONNNECTED       (to check if all the vertices of the graph are connected)
        
        /*       
        System.out.println("this graph is connected = " + isConnected(visited));
        */

        //reviewed.





        //2. IS_CYCLIC             (to check if any part of graph, contains cycle)
                                //(implements BSF, but cannot use pro-active method)
        
        /*
        System.out.println("this graph contains cycle = " + isCyclic(visited));
        */
        
        //reviewed.





        //3. IS_BIPARTITE          (to check if graph is bi-partite)

        /*
        System.out.println("this graph is bipartite = " + isBipartite());
        */

        //reviewed.





        //4. DIKSTRA ALGORITHM      (to find the shortest cost path to all vertices from a source vertex)
               
    }
}