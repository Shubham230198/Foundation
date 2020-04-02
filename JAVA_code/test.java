import java.util.*;
public class test {
    public static void main(String[] args) {

        Set<Integer> res =  new HashSet<>(Arrays.asList(new Integer[] {1,2,3,4,5}));
        Set<Integer> res1 =  new TreeSet<>(Arrays.asList(new Integer[] {5,2,3,1, 4}));

        System.out.println(res.equals(res1));
    }
}