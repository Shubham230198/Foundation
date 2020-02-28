//import java.util.*;
public class Lecture_35{
                                            //DYNAMIC PROGRAGING(continures).
    static int[][] matrixMinCost(int[] arr){
        int[][] global=new int[arr.length-1][arr.length-1];

        for(int gap=0;gap<global.length;gap++){
            for(int r=0;r<global.length-gap;r++){
                int c=r+gap;

                if(gap==0){
                    global[r][c]=0;
                }
                else if(gap==1){
                    global[r][c]=arr[r]*arr[c]*arr[c+1];
                }
                else{
                    int min=Integer.MAX_VALUE;
                    for(int k=0;k<gap;k++){
                        int left=global[r][k+r];
                        int right=global[r+k+1][c];
                        int multCost=arr[r]*arr[c+1]*arr[r+k+1];

                        int totalCost=left+right+multCost;
                        if(totalCost<min)
                            min=totalCost;
                    }

                    global[r][c]=min;
                }
                
            }
        }

        return global;
    }



    


    static int[][] maxAmountCoin(int[] arr2)                        //COIN GAME(to get max amount by picking coins from
    {                                                               //the ends, alternatively with another player).
        int[][] global2=new int[arr2.length][arr2.length];

        for(int gap=0;gap<global2.length;gap++)
        {
            for(int r=0;r<global2.length-gap;r++)
            {
                int c=r+gap;

                if(gap==0)
                {
                    global2[r][c]=arr2[r];
                }
                else if(gap==1)
                {
                    global2[r][c]=Math.max(arr2[r],arr2[c]);
                }
                else if(gap%2!=0)
                {
                    int m1=arr2[c]+Math.min(global2[r][c-2],global2[r+1][c-1]);
                    int m2=arr2[r]+Math.min(global2[r+2][c],global2[r+1][c-1]);

                    global2[r][c]=Math.max(m1,m2);
                }
            }
        }

        return global2;
    }                                                                                //REVIWED.




    public static void main(String[] args){
        
        /*int[] arr={10,20,30,40,50,60};
        int[][] global=matrixMinCost(arr);
        for(int i=0;i<global.length;i++){
            for(int j=0;j<global.length;j++){                                  //{top-right}
                System.out.print(global[i][j] + "\t");
            }
            System.out.println();
        }*/                                                               //REVIEWED.



        /*int[] arr2={20,30,2,2,2,10};                                      //COIN GAME (to get max amount from an array of coins)
        int[][] global2=maxAmountCoin(arr2);
        for(int i=0;i<global2.length;i++){
            for(int j=0;j<global2.length;j++){                                       //{top-right}
                System.out.print(global2[i][j] + "\t");
            }
            System.out.println();
        }*/                                                               //REVIWED.
    }
}
