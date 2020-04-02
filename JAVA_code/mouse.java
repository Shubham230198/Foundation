import java.util.*;
public class mouse {
    

    static class node implements Comparable<node>{
        int l = 0;
        int q = 0; 
        node(int l, int q) {
            this.l = l;
            this.q = q;
        }

        public int compareTo(node n1) {
            return n1.l - this.l;
        }
    }

    public static void main(String[] args) {
        int[][] list= {
            {5,6},
            {3,2},
            {4,3},
            {6,1}
        };

        
        ArrayList<node> arr = new ArrayList<>();
        for(int i = 0; i < list.length; i++) {
            if(list[i][1] >= 2)
                arr.add(new node(list[i][0], list[i][1]));
        }

        Collections.sort(arr);

        for(int i = 0 ; i < arr.size(); i++) {
            System.out.println(arr.get(i).l + ", " + arr.get(i).q);
        }
        
    }
}