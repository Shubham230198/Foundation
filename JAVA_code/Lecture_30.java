//import java.util.*;
public class Lecture_30
{   
    public static boolean[][] subarr(int[] arr,int target)                  //IF A SUB-ARRAY HAVING SUM EQUAL TO TARGET.
    {
        boolean[][] global=new boolean[arr.length][target+1];

        for(int r=0; r<global.length; r++)
        {
            for(int c=0;c<global[0].length;c++)
            {
                if(c==0 && r==0)
                {
                    global[r][c]=true;
                }
                else if(r==0)
                {
                    if(c==arr[0])
                        global[r][c]=true;
                }
                else if(c==0)
                {
                    global[r][c]=true;
                }
                else
                {
                    if(c<arr[r])
                    {
                        global[r][c]=global[r-1][c];
                    }
                    else
                    {
                        if(global[r-1][c]==true)
                            global[r][c]=true;
                        else if(c>=arr[r] && global[r-1][c-arr[r]]==true)
                            global[r][c]=true;
                    }
                }
            }
        }

        return global;
    }                                                                 //REVIEWED.





    static void allPath(int[] arr,boolean[][] global,int i,int j,String ans)  //print all subsets with sum equals to target.
    {   
        if(i==0)
        {   
            if(j==0)
                System.out.println(ans);
            else if(j==arr[0])
                System.out.println(ans+arr[0]);

            return;
        }

        if(global[i-1][j]==true)
        {
            allPath(arr, global, i-1, j, ans);
            
            if(j>=arr[i] && global[i-1][j-arr[i]]==true)
                allPath(arr, global, i-1, j-arr[i], ans+arr[i]);
            
        }
        else
        {
            if(j>=arr[i] && global[i-1][j-arr[i]]==true)
                allPath(arr, global, i-1, j-arr[i], ans+arr[i]);
        }
        
    }                                                                 //REVIEWED.





    static int[] coinChangePermi(int[] arr,int target)           //Tabulation to GET PERMUTATION OF COINS, SUM EQUAL TO TARGET.
    {   
        int[] global2=new int[target+1];
        global2[0]=1;

        for(int i=0;i<global2.length;i++)
        {
            for(int j=0;j<arr.length;j++)
            {   
                if(i-arr[j]>=0)
                global2[i]+=global2[i-arr[j]];
            }
        }
        return global2;
    }                                                             //REVIEWED.




    static int[] coinChangeCombi(int[] arr,int target)               //Tabulation to GET COMBINATION OF COINS,(sums to target)
    {
        int[] global3=new int[target+1];
        global3[0]=1;

        for(int j=0;j<arr.length;j++)
        {
            for(int i=0;i<global3.length;i++)
            {
                if(i-arr[j]>=0)
                global3[i]+=global3[i-arr[j]];
            }
        }

        return global3;
    }                                                               //REVIEWED.





    public static void main(String[] args)
    {
                                              
        /*int[] arr={3,2,5,1,8};                                           //tabulation of subarray.

        boolean[][] global=subarr(arr,9);
        for(int i=0;i<global.length;i++)                                   
        {
            for(int j=0;j<global[0].length;j++)
            {
                System.out.print(global[i][j]+"\t");
            }
            System.out.println();
        }*/                                                                    //REVIEWED.




        /*int[] arr={3,2,5,1,8};                                                    //to get all subset with target sum.
        boolean[][] global=subarr(arr,9);

        allPath(arr,global,global.length-1,global[0].length-1,"");            
        */                                                                              //REVIEWED.




        /*int[] arr2={2,3,5,6};                                                    //to get coin pemutation.
        int[] m=coinChangePermi(arr2, 7);
        for(int i=0;i<m.length;i++)
        {
            System.out.println(m[i]+"\t");
        }*/                                                                    //REVIEWED.



        /*int[] arr2={2,3,5,6};                                               //to get coin combination.
        int[] n=coinChangeCombi(arr2, 7);  
                                             
        for(int i=0;i<n.length;i++)
        {
            System.out.println(n[i]+"\t");
        }*/                                                                      //REVIEWED.
        
    }
}