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







    //1. PRIMS_ALGORITHM        (to get minimum spanning tree)

    static class PrimsPair implements Comparable<PrimsPair>{
        int vertex = -1;
        int cost = -1;
        int previousVertex = -1;

        PrimsPair(int v, int pv, int c) {
            this.vertex = v;
            this.cost = c;
            this.previousVertex = pv;
        }

        public int compareTo(PrimsPair other) {
            return this.cost - other.cost;
        }
    }

    
    static ArrayList<ArrayList<Edge>> mst = new ArrayList<>();      //final minimum spanning tree.

    static void addEdge(ArrayList<ArrayList<Edge>> G, int u, int v, int c) {    //add-edge for any graph G
        G.get(u).add(new Edge(v,c));
        G.get(v).add(new Edge(u,c));
    }



    static void display(ArrayList<ArrayList<Edge>> G) {         //display for any graph G.
        for(int i = 0; i < G.size(); i++) {
            System.out.print(i + " -> ");
            for(int j = 0; j < G.get(i).size(); j++) {
                Edge e = G.get(i).get(j);
                System.out.print("[" + e.nebr + ", " + e.wt + "] ");
            }
            System.out.println();
        }
    }



    static void prims() {
        PriorityQueue<PrimsPair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[graph.size()];
        PrimsPair p = new PrimsPair(0, -1, 0);
        pq.add(p);

        while(pq.isEmpty() == false) {
            PrimsPair rem = pq.poll();     //GET and REMOVE

            if(visited[rem.vertex] == true)   //if already visited, thn continue because
                continue;                     //that vertex would already be added in the mst.
            
            visited[rem.vertex] = true;        //MARK

            if(rem.previousVertex != -1) {       //WORK
                addEdge(mst, rem.vertex, rem.previousVertex, rem.cost);
            }
            
            for(int i = 0; i < graph.get(rem.vertex).size(); i++) {       //ADD NEBR
                Edge e = graph.get(rem.vertex).get(i);
                if(visited[e.nebr] == false) {
                    pq.add(new PrimsPair(e.nebr, rem.vertex, e.wt));
                }
            }
        }

        display(mst);               //displaying the mst we just created,for given graph.
    }

    //REVIEWED.








    //2. TOPOLOGICAL_SORT      

    static void addEdgeDirected(ArrayList<ArrayList<Edge>> dag, int u, int v, int c) {
        dag.get(u).add(new Edge(v, c));
    }



    //this is component function like gscc.
    public static void topoSortCompo(ArrayList<ArrayList<Edge>> dag, Stack<Integer> st, boolean[] visited, int v) {
        visited[v] = true;                  //marking visited.

        for(int i = 0; i < dag.get(v).size(); i++) {        //getting the reachable nebrs first.
            Edge e = dag.get(v).get(i);
            if(visited[e.nebr] == false)
                topoSortCompo(dag, st, visited, e.nebr);
        }

        st.push(v);                                     //inserting the vertex in post when all,
    }                                                   //its possible reachable nebrs are already pushed in stack.



    public static void topoSort(ArrayList<ArrayList<Edge>> dag) {       //driving function like gcc.
        
        boolean[] visited = new boolean[dag.size()];
        Stack<Integer> st = new Stack<>();
        
        for(int v = 0; v < dag.size(); v++) {
            if(visited[v] == false)
                topoSortCompo(dag, st, visited, v);
        }

        while(st.size() != 0) {                         //printing the reverse order of stack,
            System.out.print(st.peek() + " ");          //or we can say correct topological sort order.
            st.pop();
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
    
    
        

        //1. PRIMS_ALGORITHM      (to create minimum spanning tree)
        
        /*       
        for(int i = 0; i < graph.size(); i++) {
            mst.add(new ArrayList<Edge>());
        }
        prims();
        */

        //reviewed.





        //2. TOPOLOGICAL_SORT           
        
        /*
        ArrayList<ArrayList<Edge>> dag = new ArrayList<>();
        for(int i = 0; i < 7; i++) {
            dag.add(new ArrayList<Edge>());
        }
        addEdgeDirected(dag, 0, 1, 1);
        addEdgeDirected(dag, 0, 4, 1);
        addEdgeDirected(dag, 1, 2, 1);
        addEdgeDirected(dag, 2, 3, 1);
        addEdgeDirected(dag, 4, 3, 1);
        addEdgeDirected(dag, 5, 4, 1);
        addEdgeDirected(dag, 5, 6, 1);
        addEdgeDirected(dag, 6, 3, 1);

        topoSort(dag);
        */

        //reviewed.


    }

}