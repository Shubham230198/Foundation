import java.util.*;
public class test {

    public static int getAns(int[] arr, int amt, int lcu) {
        if(amt == 0) {
            return 1;
        }

        int sum = 0;
        for(int i = lcu; i < arr.length; i++) {
            if(amt - arr[i] >= 0) {
                sum += getAns(arr, amt - arr[i], i);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7};
        int amt = 10;
        int[] memo = new
        System.out.println(getAns(arr, amt, 0));
    }
}