import java.util.*;
                                                    //[Dynamic Programing]
public class Lecture_36{

    public static int[][] optimalBSTCost(int[] arr,int[] frequency)                //TO FIND THE OPTIOMAL TRAVERSAL COST BST
    {                                                                              //with given frequencies of element searched.
        int[][] global=new int[arr.length][arr.length];
        
        int[] prefixSum=new int[arr.length];
        prefixSum[0]=frequency[0];
        for(int i=1;i<prefixSum.length;i++)
        {
            prefixSum[i]=prefixSum[i-1]+frequency[i];
        }

        for(int gap=0;gap<global.length;gap++)
        {
            for(int r=0;r<global.length-gap;r++)
            {
                int c=r+gap;

                if(gap==0)
                {
                    global[r][c]=frequency[r];
                }
                else if(gap==1)
                {
                    global[r][c]=Math.min(frequency[r]+frequency[c]*2,frequency[c]+ frequency[r]*2);
                }
                else
                {   
                    int minCost=Integer.MAX_VALUE;
                    for(int k=0;k<=gap;k++)
                    {
                        int left=k==0?0:global[r][r+k-1];
                        int right=k==gap?0:global[r+k+1][c];

                        minCost=Math.min(left+right,minCost);
                    }


                    global[r][c]=minCost+ prefixSum[c];
                    if(r>0)
                    {
                        global[r][c]-=prefixSum[r-1];
                    }
                }
            }
        }

        return global;
    }                                                                //REVIEWED.





    static int minSquares(int w,int h,int[][] memo)          //TO FIND MINIMUM NO. OF SQUARES, IN WHICH GIVEN RECTANGLE CAN
    {                                                       //CAN BE DIVIDED.
        if(w==0 || h==0)
            return 0;
        else if(w==h)
            return 1;

        if(memo[w][h]!=0)
            return memo[w][h];

        int res=Integer.MAX_VALUE;
        for(int n=1;n<=Math.min(w,h);n++)
        {
            int lvhn=h-n;
            int lvwn=n;
            int rvhn=h;
            int rvwn=w-n;

            int verticle=minSquares(lvwn, lvhn,memo) + minSquares(rvwn, rvhn,memo);

            int lhhn=n;
            int lhwn=w-n;
            int rhhn=h-n;
            int rhwn=w;

            int horizontal=minSquares(lhwn, lhhn,memo) + minSquares(rhwn, rhhn, memo);

            res=Math.min(res,Math.min(verticle,horizontal));
        }

        res++;
        memo[w][h]=res;
        return res;
    }                                                                 //REVIEWED.




    public static void main(String[] args){
    
        /*int[] arr={10,20,30,40,50,60,70};                        //to find cost of, BST with min traversal cost.
        
        int[] frequency={2,1,4,1,1,3,5};                                //searching frequency array.

        int[][] global=optimalBSTCost(arr,frequency);
        for(int i=0;i<global.length;i++)
        {
            for(int j=0;j<global.length;j++)
            {
                System.out.print(global[i][j] + "\t");
            }
            System.out.println();
        }*/                                                           //REVIWED.





        /*long start=System.currentTimeMillis();                    //min count of squares in wich a rectangle can be divided.             
        
        int[][] memo=new int[30+1][36+1];
        System.out.println(minSquares(30, 36,memo));                     //[by memoisation].
        
        long end=System.currentTimeMillis();

        System.out.println("in " + (end-start) + "ms ");            //REVIEWED.
        */
    }
}