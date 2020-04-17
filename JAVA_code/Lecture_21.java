                                        //Lecture-21
                                        //July-17

                                        //GRAPH IS STARTED.

import java.util.*;
public class Lecture_21
{
    
    static class Edge {        //class for graph 
        int nebr = -1;
        int wt = -1;

        Edge(int nebr, int wt) {
            this.nebr = nebr;
            this.wt = wt;
        }
    }

    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();       





    static void addEdge(int v1, int v2, int wt) {            //add Edge function.
        graph.get(v1).add(new Edge(v2, wt));
        graph.get(v2).add(new Edge(v1, wt));
    }                                                       //REVIEWED.





    static void display() {                                  //Display function
        for(int i = 0; i < graph.size(); i++) {
            System.out.print(i + " -> ");
            for(int j = 0; j < graph.get(i).size(); j++) {
                System.out.print("[" + graph.get(i).get(j).nebr + ", " + graph.get(i).get(j).wt + "], ");
            }
            System.out.println();
        }
    }                                                        //REVIEWED.





    static boolean hasPath(int v1, int v2, boolean[] visited) {           //To check if a path is possible between v1, v2.
        if(v1 == v2) {
            return true;
        }
        visited[v1] = true;
        for(int i = 0; i < graph.get(v1).size(); i++) {
            if(visited[graph.get(v1).get(i).nebr] == false) {
                boolean flag = hasPath(graph.get(v1).get(i).nebr, v2, visited);
                if(flag == true)
                    return true;
            }
        }

        return false;
    }                                                                     //REVIEWED.





    static void allPath(int s, int d, boolean[] visited, String str, int cost) {        //Allpaths function
        if(s == d) {                                                                    //(to get all paths)
            System.out.println(str + d + "@" + cost);                                   //(Inefficient method)
            return;
        }
        
        visited[s] = true;
        for(int i = 0; i < graph.get(s).size(); i++) {
            if(visited[graph.get(s).get(i).nebr] == false) {
                allPath(graph.get(s).get(i).nebr, d, visited, str + s, cost + graph.get(s).get(i).wt);
            }
        }
        visited[s] = false;
    }                                                                                         //REVIEWED.






    static void allPaths2(int s, int d, boolean []visited, StringBuilder str, int cost) {            //To find allpaths (Efficient)
        if(s == d) {
            str.append(d);
            System.out.println(str + "@" + cost);
            str.deleteCharAt(str.length() - 1);
            return;
        }

        visited[s] = true;
        for(int i = 0; i < graph.get(s).size(); i++) {
            if(visited[graph.get(s).get(i).nebr] == false) {
                str.append(s);
                allPaths2(graph.get(s).get(i).nebr, d, visited, str, cost + graph.get(s).get(i).wt);
                str.deleteCharAt(str.length() - 1);
            }
        }
        visited[s] = false;
    }                                                                                              //REVIEWED.




    public static void main(String[] args)
    {
        for(int i = 0; i <= 6; i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(0, 3, 40);
        addEdge(0, 1, 10);
        addEdge(1, 2, 10);
        addEdge(2, 3, 10);
        addEdge(3, 4, 2);
        addEdge(4, 5, 3);
        addEdge(5, 6, 3);
        addEdge(4, 6, 8);

        

        // display();                    //display function of adjancy list

        
        /*boolean[] visited = new boolean[graph.size()];        //hasPath function.
        System.out.println(hasPath(0, 6, visited));          
        */                                                      //reviewed.
        
        
        
        /*boolean[] visited = new boolean[graph.size()];       //allPath function (Inefficient)
        allPath(0, 6, visited, "", 1);    
        */                                                     //reviewed.


        
        /*boolean[] visited = new boolean[graph.size()];        //allPaths fucntion(Efficient), using StringBuilder.
        StringBuilder str = new StringBuilder();
        allPaths2(0, 6, visited, str, 1);
        */                                                      //reviewed.
    }

}