
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class test2 {
    
    public static boolean possible(int[] arr,int mid, int m) {
        System.out.print("hello" + " " + mid + " ->");
        
        int sum = 0;
        int cm = 0;
        for(int i = 0; i < arr.length; i++) {
            if(sum + arr[i] <= mid) {
                sum += arr[i];
            }
            else {
                System.out.print(sum + ", ");
                sum = 0;
                i--;
                cm++;
            }
        }
        System.out.println(sum);

        if(m >= cm) {
            // System.out.println( true);
            return true;
        }
        // System.out.println(false);
        return false;
    }

    public static int binary(int[] arr,int m, int l, int r) {
        int res = -1;
        while(l <= r) {
            int mid = l + (r - l)/2;
            
            if(possible(arr, mid, m) == true) {
                // System.out.println(true);
                r = mid - 1;
                res = mid;
            }
            else {
                // System.out.println(false);
                l = mid + 1;
            }

        }
        return res;
    }

    public static void main(String args[] ) throws Exception {
        
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while(t-- != 0) {
            int n = scn.nextInt();
            int m = scn.nextInt();

            int[] arr = new int[n];
            int min = Integer.MAX_VALUE;
            int sum = 0;
            for(int i =0; i < n; i++) {
                arr[i] = scn.nextInt();
                if(arr[i] < min ) {
                    min = arr[i];
                }
                sum += arr[i];
            }

            // System.out.println(min + ", " + sum);

            System.out.println(binary(arr, m, min, sum));
        }

    }
}
