import java.util.*;
public class sample{

    static class node implements Comparable<node>{
        int data;
        int idx;

        node(int d, int i) {
            this.data = d;
            this.idx = i;
        }

        public int compareTo(node d1) {
            return this.data - d1.data;
        }
    }


    public static int getAnswer(int e, node[] power, int[] bonus) {
        boolean[] check = new boolean[power.length];
        int r = 0;

        for(int i = 0 ; i < power.length; i++) {
            if(power[i].data > e) {
                return r;
            }

            
            while(power[i].data == power[i + 1].data)


            r++;
            e += bonus[power[i].idx];
        }

        return r;
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int e = scn.nextInt();

        node[] power = new node[n];

        for(int i = 0; i < n; i++) {
            int temp = scn.nextInt();
            power[i] = new node(temp, i);
        }

        int[] bonus = new int[n];
        for(int i = 0; i < n; i++) {
            bonus[i] = scn.nextInt();
        }

        Arrays.sort(power);

        int result = getAnswer(e, power, bonus);

        System.out.println(result);
    }
}















