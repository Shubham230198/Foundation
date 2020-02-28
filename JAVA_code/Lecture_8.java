                                                //28-June
                                                //Lecture-8

import java.util.*;
public class Lecture_8
{
    public static void main(String[] args)             //TO ROTATE THE GIVEN SHELL (in a given 2D square array).
    {   
        Scanner scn=new Scanner(System.in);
        int[][] arr={
            {10,11,12,13,14},
            {20,21,22,23,24},
            {30,31,32,33,34},
            {40,41,42,43,44},
            {50,51,52,53,54}
        };
    
        int rmin=0;
        int rmax=arr.length-1;
        int cmin=0;
        int cmax=arr[0].length-1;

        System.out.print("Enter the shell ");
        int shell=scn.nextInt();
        
        rmin += (shell - 1);
        rmax -= (shell - 1);
        cmin += (shell - 1);
        cmax -= (shell - 1);
        
        System.out.print("enter the number of times");
        int times=scn.nextInt();
        
        for(int t = 0; t < times; t++) {

            int temp1 = arr[rmin][cmin];
            int temp2 = arr[rmax][cmin];
            int temp3 = arr[rmax][cmax];
            int temp4 = arr[rmin][cmax];
    
            for(int i = rmax; i >= rmin + 2; i--){
                arr[i][cmin] = arr[i - 1][cmin];
            }
            arr[rmin + 1][cmin] = temp1;
    
            for(int i = cmax; i >= cmin + 2; i--){
                arr[rmax][i] = arr[rmax][i - 1];
            }
            arr[rmax][cmin + 1] = temp2;
    
            for(int i = rmin; i <= rmax - 2; i++){
                arr[i][cmax] = arr[i + 1][cmax];
            }
            arr[rmax - 1][cmax] = temp3;
    
            for(int i = cmin; i <= cmax - 2; i++){
                arr[rmin][i] = arr[rmin][i + 1];
            }
            arr[rmin][cmax - 1] = temp4;
        }

        scn.close();                                                     //REVIEWED.


        for(int row = 0; row < arr.length; row++) {
            for(int col = 0; col < arr[0].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }


}