import java.util.*;
public class test {

    static int n;
    static List<Integer> res;
    public static List<Integer> lexicalOrder(int x) {
        n = x;
        res = new ArrayList<>();
        for (int i = 1; i < 10; i ++) {
            if (i > n) break;
            dfs(i);
        }
        return res;
    }

    private static void dfs(int st) {
        res.add(st);
        st *= 10;
        for (int i = 0; i < 10; i++){
            if (st + i > n) return;
            dfs(st + i); 
        }
    }

    public static void main(String[] args) {
        System.out.println(lexicalOrder(13));
    }
    
}