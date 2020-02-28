import java.util.*;
public class test2 {

    static void getSumDuplicate(ArrayList<Integer> arr) {
        int total = 0;

        for(int i = arr.size() - 2; i >= 0; i--) {
            if(arr.get(i) == arr.get(i + 1)) {
                total += arr.remove(i + 1);
            }
            else {
                int temp = arr.get(i + 1);
                arr.set(i + 1, temp + total);
                total = 0;
            }
        }

        int t = arr.get(0);
        arr.set(0, t + total);


    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.addAll(Arrays.asList(2,2,2,3,3,2,2,2,5,6,6,7,7,7,8,8));

        System.out.println(arr);
        getSumDuplicate(arr);
        System.out.println(arr);
    }
}