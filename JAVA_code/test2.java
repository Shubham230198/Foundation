import java.util.*;
public class test2 {

    public static int getSetBitsCount(int n) {
        int count = 0;
        while(n != 0) {
            n = (n & (n - 1));
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while(t-- != 0) {
            int n = scn.nextInt();
            int q = scn.nextInt();
            
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = scn.nextInt();
            }

            for(int i = 0; i < q; i++) {
                int p = scn.nextInt();
                int odd = 0;
                int even = 0;

                for(int j = 0; j < arr.length; j++) {
                    int res = getSetBitsCount(arr[j] ^ p);

                    System.out.println(res);
                    if(res % 2 == 0) {
                        even++;
                    }
                    else {
                        odd++;
                    }
                }
                System.out.println(even + " " + odd);
            }
        }
    }
}