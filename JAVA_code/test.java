import java.util.*;
public class test{
    class Solution {
        class help {
            int v = -1;
            int c = -1;
            int s = -1;
    
            help(int v, int c, int s) {
                this.v = v;
                this.c = c;
                this.s = s;
            }
        }
        
        class edge {
            int nebr = -1;
            int c = -1;
            
            edge(int n, int c) {
                this.nebr = n;
                this.c = c;
            }
        }
        
        
        int dikstra(ArrayList<ArrayList<edge>> graph, int src, int dst, int k) {
            PriorityQueue<help> pq = new PriorityQueue<>();
            pq.add(new help(src, 0, -1));
            
            boolean[] visited = new boolean[graph.size()];
            
            while(pq.isEmpty() == false) {
                help rem = pq.poll();
                
                if(rem.s == k + 1) {
                    return -1;
                }
                if(dst == rem.v) {
                    return rem.c;
                }
                
                visited[rem.v] = true;
                for(int i = 0; i < graph.get(rem.v).size(); i++) {
                    edge e = graph.get(rem.v).get(i);
                    if(visited[e.nebr] == false) {
                        pq.add(new help(e.nebr, rem.c + e.wt, rem.s + 1));
                    }
                }
            }
            
            return -1;
        }
        
        
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
            ArrayList<ArrayList<help>> graph = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            
            for(int i = 0; i < flights.length; i++) {
                graph.get(arr[i][0]).add(new edge(arr[i][1], arr[i][2]));
                graph.get(arr[i][1]).add(new edge(arr[i][0], arr[i][2]));
            }
            
            System.out.println(dikstra(graph, src, dst, k));
        }
    }

    public static void main(String[] args) {
        System.out.println(fun());
    }
}