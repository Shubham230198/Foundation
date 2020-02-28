import java.util.*;
public class mouse {

    static void removeDuplicacy(ArrayList<Integer> data) {
        int i = 1;

        while(i < data.size()) {
            if(data.get(i) == data.get(i - 1)) {
                data.remove(i);
            }
            else {
                i++;
            }
        }

        System.out.println(data);


    }
    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<>();
        data.addAll(Arrays.asList(2,2,2,3,3,2,2,2,5,6,6,7,7,7,8,8));
        
        System.out.println(data);
        removeDuplicacy(data);
    }
}