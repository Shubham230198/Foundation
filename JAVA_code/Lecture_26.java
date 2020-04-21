                                            //Lecture_26
                                            //july-22

import java.util.*;
public class Lecture_26
{

    //PRE-REQUIST for graph creation.

    public static class Edge                 //simple edge(data type, for graphs)
    {
        int nebr;
        int wt;

        Edge(int n,int w)
        {
            this.nebr=n;
            this.wt=w;
        }
    }

    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();          //actual graph.
    
    
    static void addEdge(ArrayList<ArrayList<Edge>> graph,int v1,int v2,int wt)       //to add a edge in graph.
    {
        Edge n1= new Edge(v2,wt);
        graph.get(v1).add(n1);
        
        Edge n2= new Edge(v1,wt);
        graph.get(v2).add(n2);

    }

    
    static void display(ArrayList<ArrayList<Edge>> graph)         //to display a graph
    {
        for(int i=0;i<graph.size();i++)
        {   
            System.out.print(i + "->"+ " ");
            for(int j=0;j<graph.get(i).size();j++)
            {   
                Edge n=graph.get(i).get(j);
                System.out.print("[" + n.nebr + "," + n.wt + "] ");
            }
            System.out.println();
        }
    }

    //reviewed.
    
    
    
    
    


    //1. KRUSKAL_ALGO           (to create a mst of graph).

    static ArrayList<ArrayList<Edge>> mst = new ArrayList<>();            //MINIMUM SPANNING TREE(by kruskal)
    
    static public class kEdge implements Comparable<kEdge>          //kruskal edge(data type)
    {
        int v1;
        int v2;
        int wt;
        kEdge(int v1,int v2,int wt)
        {
            this.v1=v1;
            this.v2=v2;
            this.wt=wt;
        }

        public int compareTo(kEdge other)
        {
            return this.wt-other.wt;
        }
    }


    static void merge(int[] pa,int[] ra,int v1sl,int v2sl)            //to merge two sets
    {
        if(ra[v1sl]<ra[v2sl])
        {
            pa[v1sl]=v2sl;
        }
        else if(ra[v2sl]<ra[v1sl])
        {
            pa[v2sl]=v1sl;
        }
        else
        {
            pa[v1sl]=v2sl;
            ra[v2sl]++;
        }
    }


    static int find(int[] pa,int v)               //to find the learder of a set.
    {
        if(pa[v]==v)
        {
            return v;
        }
        else
        {
            return find(pa,pa[v]);
        }
    }


    static void kruskal()                                       //kruskal algo
    {
        int[] pa=new int[graph.size()];        //parent array.
        int[] ra=new int[graph.size()];        //rank array.

        for(int i=0;i<graph.size();i++)
        {
            pa[i]=i;
            ra[i]=1;
            mst.add(new ArrayList<Edge>());
        }

        PriorityQueue<kEdge> pq = new PriorityQueue<>();
        for(int v=0;v<graph.size();v++)
        {
            for(int n=0;n<graph.get(v).size();n++)
            {
                Edge ne=graph.get(v).get(n);
                if(v<ne.nebr)
                {
                    kEdge ke=new kEdge(v,ne.nebr,ne.wt);
                    pq.add(ke);
                }
            }
        }

        while(pq.size()>0)
        {
            kEdge ke = pq.remove();
            int v1=ke.v1;
            int v2=ke.v2;

            int v1sl=find(pa,v1);
            int v2sl=find(pa,v2);

            if(v1sl!=v2sl)
            {
                addEdge(mst,v1,v2,ke.wt);
                merge(pa,ra,v1sl,v2sl);

            }

        }

        display(mst);

    }

    //REVIEWED.






    public static void main(String[] args)
    {
        //pre-requist for graph creation.

        graph.add(new ArrayList<Edge>());
        graph.add(new ArrayList<Edge>());
        graph.add(new ArrayList<Edge>());
        graph.add(new ArrayList<Edge>());
        graph.add(new ArrayList<Edge>());
        graph.add(new ArrayList<Edge>());
        graph.add(new ArrayList<Edge>());
        

        addEdge(graph,0,1,20);
        addEdge(graph,1,2,10);
        addEdge(graph,2,3,20);
        addEdge(graph,0,3,40);
        addEdge(graph,3,4,2);
        addEdge(graph,2,5,5);
        addEdge(graph,4,5,3);
        addEdge(graph,5,6,3);
        addEdge(graph,4,6,8);
        
        // display(graph);                       //to display actual graph.
        
        //reviewed.

    
        





        //1.Kruskal Algo       (to find mst of a graph)

        /*
        kruskal();                            //to apply kruskal algorithm on graph.
        */

        //reviewed.
    
    }
}