//import java.util.*;
public class Lecture_31
{   
    static int[][] knapSack(int[] wt,int[] prices,int target)               //TO GET TABULATION FOR GETIING MAX PRICE IN
    {                                                                       //INSIDE A BAG (of fixed capacity).
        int[][] global=new int[wt.length][target+1];

        for(int r=0;r<global.length;r++)
        {
            for(int c=0;c<global[0].length;c++)
            {   
                if(r==0 && c==0)
                {
                    global[r][c]=0;
                }
                else if(c==0)
                {
                    global[r][c]=0;
                }
                else if(r==0)
                {
                    if(c>=wt[r])
                        global[r][c]=prices[r];
                }
                else
                {
                    if(c>=wt[r])
                    {
                        if(global[r-1][c] > global[r-1][c-wt[r]]+prices[r])
                        {
                            global[r][c]=global[r-1][c];
                        }
                        else
                            global[r][c]=global[r-1][c-wt[r]]+prices[r];
                    }
                    else
                    {
                        global[r][c]=global[r-1][c];
                    }
                }
            }
        }

        return global;
    }                                                                          //REVIEWED.






    static int[] knapSackDuplicacy(int[] wt,int[] prices,int target)                //SAME AS ABOVE,(but any element could be
    {                                                                               //put inside the bag, any number of times).
        int[] global2=new int[target+1];                                            //[permutation method is used]
        global2[0]=0;                                                               //[but combination method could also be used].

        for(int i=1;i<global2.length;i++)
        {   int max=0;
            for(int m=0;m<wt.length;m++)
            {
                if(i>=wt[m])
                {
                    if(max < global2[i-wt[m]]+prices[m])
                        max=global2[i-wt[m]]+prices[m];
                }
            }
            global2[i]=max;
        }

        return global2;
    }                                                                             //REVIEWED.




    static int[] pairCount(int people)                           //TO COUNT NO. OF WAYS SO THAT, n PEOPLE COULD GROUPED,
    {                                                            //EITHER BY PAIRING INTO TWO, OR BEING SINGLE.
        int[] global3=new int[people+1];
        global3[0]=1;
        global3[1]=1;

        for(int i=2;i<global3.length;i++)
        {
            global3[i]=global3[i-1] + (i-1)*global3[i-2];
        }

        return global3;
    }                                                             //REVIEWED.





    static int[] carpetTiles(int m,int n)                         //WAYS TO FILL A AREA of (m*n), BY TILES OF AREA (m*1).
    {
        int[] global4=new int[n+1];
        global4[0]=1;
        global4[1]=1;

        for(int i=2;i<global4.length;i++)
        {
            global4[i]=global4[i-1];

            if(i-m>=0)
                global4[i]+=global4[i-m];
        }

        return global4;
    }                                                             //REVIEWED.


    public static void main(String[] args)
    {
        /*int[] wt={2,5,1,3,4};                                                    //max price item in a bag, with fixed capacity.
        int[] prices={15,14,10,45,30};

        int[][] global=knapSack(wt,prices,7);

        for(int i=0;i<global.length;i++)
        {
            for(int j=0;j<global[0].length;j++)
            {
                System.out.print(global[i][j] + "\t");
            }
            System.out.println();
        }*/                                                                   //REVIEWED.


        /*int[] wt={2,5,1,3,4};                                             //max price item in a bag, with fixed capacity.
        int[] prices={15,14,10,45,30};                                    //but duplicacy of items is allowed.
        int[] global2=knapSackDuplicacy(wt, prices,7);
        for(int i=0;i<global2.length;i++)
        {
            System.out.print(global2[i] + "\t");
        }*/                                                                //REVIEWED.



        /*int[] global3=pairCount(5);                                        //to get count of ways in which n people, could
        for(int i=0;i<global3.length;i++)                                  //pair up with each other(only 2 people) or could
        {                                                                  //stay single.
            System.out.print(global3[i] + "\t");
        }*/                                                                    //REVIEWED.
    
        

        /*int[] global4=carpetTiles(2,10);                                    //count to cover a area of (m*n), by tiles of size (m*1).

        for(int i=0;i<global4.length;i++)
        {
            System.out.print(global4[i] + "\t");
        }*/                                                                  //REVIEWED.
    }

}