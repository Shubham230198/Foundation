import java.util.*;
public class test2 {

    public static void getZigZag(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;
        boolean flag = false;

        for(int l = 1; l <= r + c - 1; l++) {
            if(l <= r) {
                if(flag == false) {
                    for(int i = r - l, j = 0; i < r && j < c; i++, j++) {
                        System.out.print(arr[i][j] + " ");
                    }
                    System.out.println();
                    flag = true;
                }
                else {
                    for(int i = r - 1, j = l - 1; i >= r - l && j >= 0; i-- , j--) {
                        System.out.print(arr[i][j] + " ");
                    }
                    System.out.println();
                    flag = false;
                }
                    
            }
            else {
                if(flag == false) {
                    for(int i = 0, j = l - r; i < r && j < c; i++, j++) {
                        System.out.print(arr[i][j] + " ");
                    }
                    System.out.println();
                    flag = true;
                }
                else {
                    for(int j = c - 1, i = r + c - 1 - l ; i >= 0 && j >= 0; i--, j--) {
                        System.out.print(arr[i][j] + " ");
                    }
                    System.out.println();
                    flag = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        // int[][] arr = {
        //     {1,2,3,4},
        //     {5,6,7,8},
        //     {9,10,11,12},
        //     {13,14,15,16},
        //     {17,18,19,20}
        // };

        int[][] arr = {
            {1,2,3},
            {4,5,6},
            {7,8,9},
            {10,11,12},
            {13,14,15}
        };

        // int[][] arr = {
        //     {1,2,3,4,5,6},
        //     {7,8,9,10,11,12},
        //     {13,14,15,16,17,18}
        // };
        getZigZag(arr);
    }
}