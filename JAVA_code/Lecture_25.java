                                                    //Lecture_25
                                                    //July-21

import java.util.*;
public class Lecture_25
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
        // addEdge(2,5,5);            //extra edge between 2,5.
        addEdge(3,4,2);
        addEdge(4,5,3);
        addEdge(5,6,3);
        addEdge(4,6,8);
    
        boolean[] visited = new boolean[graph.size()];
        //reviewed.


}