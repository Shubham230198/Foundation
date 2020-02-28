                                            //Lecture-7                                 
                                            //27june

// import java.util.*;
public class Lecture_7
{   
    /*public static void main(String[] args) {                   //ARRAY PLAYER (Exit Point)
        int[][] arr={
            {0,0,1,0},
            {1,1,0,0},
            {0,1,0,0},
            {1,0,1,0}
        };

        int i=0;
        int j=0;

        int dir = 0;          //0123 = (east, south, west, north).

        while(true) {
            dir = (dir + arr[i][j]) % 4;

            if(dir == 0) {
                j++;
                if(j == arr[0].length) {
                    System.out.println(i + "," + (j - 1));
                    break;
                }
            }
            else if(dir == 1) {
                i++;
                if(i == arr.length) {
                    System.out.println((i - 1) + "," + j);
                    break;
                }
            }
            else if(dir == 2) {
                j--;
                if(j == -1) {
                    System.out.println(i + "," + (j + 1));
                    break;
                }
            }
            else {
                i--;
                if(i == -1) {
                    System.out.println((i + 1) + "," + j);
                    break;
                }
            }
        }
    }*/                                               //REVIEWED.




   /* public static void main(String[] args)         //printing wave(up->down thn down->up) of a matrix.
    {
        int[][] arr= {
            {11,12,13,14,15},
            {21,22,23,24,25},
            {31,32,33,34,35}
        };

        int r,c=0;
        boolean dir=true;
        
        while(c<arr[0].length&&c>=0)
        {   
            if(dir)
            {   for(int i=0;i<arr.length;i++)
                {
                    System.out.print(arr[i][c] +" ");
                }
                c++;
                dir=false;
            }
            
            else 
            {   for(int i=arr.length-1;i>=0;i--)
                {
                    System.out.print(arr[i][c]+ " ");
                }
                c++;
                dir=true;
            }
        }


    }*/                                   //Reviewed.



    



    /*public static void main(String[] args)              //box-border printing.(left->bottom->right->top)
    {
        int[][] arr= {
            {11,12,13,14,15},
            {21,22,23,24,25},
            {31,32,33,34,35},
            {41,42,43,44,45}
        };

        int rmax=arr.length-1;
        int rmin=0;
        int cmax=arr[0].length-1;
        int cmin=0;
        int toe=arr.length*arr[0].length;  //total no of elements
        int count=0;                       //to count the printed elements
        
        while(count<toe)
        {
            for(int i=rmin;i<=rmax;i++)              //left wall
            {
                System.out.print(arr[i][cmin]+" ");
                count++;
            }
            cmin++;

            for(int j=cmin;j<=cmax;j++)               //bottom wall
            {
                System.out.print(arr[rmax][j]+" ");
                count++;
            }
            rmax--;

            for(int i=rmax;i>=rmin;i--)                //right wall
            {
                System.out.print(arr[i][cmax]+" ");
                count++;
            }
            cmax--;

            for(int j=cmax;j>=cmin;j--)                //top wall
            {
                System.out.print(arr[rmin][j]+" ");
                count++;
            }
            rmin++;
        }

    } */                                                      //Reviewed.




    /*public static void main(String[] args)             //To rotate a matrix by 90degree.
    {
        int[][] arr={
            {11,12,13,14},
            {21,22,23,24},
            {31,32,33,34},
            {41,42,43,44}
        };

        for(int i=0;i<arr.length;i++)    //transpose
        {
            for(int j=i;j<arr[0].length;j++)
            {   
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }

        for(int i=0;i<arr.length;i++)     //swaping the columns.
        {
            int left=0;
            int right=arr.length-1;
            while(left<right)
            {
                int temp=arr[i][right];
                arr[i][right]=arr[i][left];
                arr[i][left]=temp;
                left++;
                right--;
            }
        }

        for(int i=0;i<arr.length;i++)           //printing the rotated array.
        {
            for(int j=0;j<arr[0].length;j++)
            {
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }

    }*/                                               //Reviewed. 




    /*public static void main(String[] args)            //matrix multiplication.
    {
        int[][] A={
            {10,0,1,1},
            {1,10,2,2}
        };

        int[][] B={
            {2,1},
            {1,3},
            {4,5},
            {10,0}
        };

        int[][] C= new int[A.length][B[0].length];

        if(A[0].length==B.length)
        {
            for(int i=0;i<A.length;i++)
            {   for(int j=0;j<B[0].length;j++)
                {
                    int sum=0;
                    for(int k=0;k<A[0].length;k++)
                    {
                        sum+=A[i][k]*B[k][j];
                    }
                    C[i][j]=sum;

                }
            }

            for(int i=0;i<A.length;i++)
            {
                for(int j=0;j<B[0].length;j++)
                {
                    System.out.print(C[i][j]+" ");
                }
                System.out.println();
            }
        }
        else
        {
            System.out.println("Multiplication of matrix is not possible.");
        }
        
        
    }*/                                              //Reviewed.


}