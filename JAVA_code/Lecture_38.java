import java.util.*;
public class Lecture_38
{   
    // public class product implements Comparable<product>                            //FRACTIONAL KNAC-SACK.
    // {
    //     int wt;
    //     int price;
    //     double ratio=price/wt;

    //     product()
    //     {
    //         this.wt=0;
    //         this.price=0;
    //     }

    //     product(int wt,int price)
    //     {
    //         this.wt=wt;
    //         this.price=price;
    //     }

    //     public int compareTo(product other)
    //     {
    //         if(this.ratio<other.ratio)
    //             return -1;
    //         else if(this.ratio==other.ratio)
    //             return 0;
    //         else
    //             return 1;
    //     }
    // }




    static int maxPlatforms(int[] arrivals,int[] departures)
    {
        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int i=0;
        int j=0;
        int count=0;
        int max=0;

        while(i<arrivals.length)
        {
            if(i<=j)
            {
                i++;
                count++;
            }
            else
            {
                j++;
                count--;
            }

            max=Math.max(max,count);
        }

        return count;
    }                                                                     //REVIEWED.




    static class work implements Comparable<work>{                           
        public
        int day;
        int profit;
        char name;

        work(int day,int profit,char name)
        {
            this.day=day;
            this.profit=profit;
            this.name=name;
        }

        public int compareTo(work other)
        {
            return this.profit-other.profit;
        }

    }


    public static int workOrderPrint(int[] days,int[] prices,String workNames)
    {   
        int profit=0;
        work[] workOrder=new work[days.length];
        int max=0;
        for(int i=0;i<days.length;i++)
        {   
            work m=new work(days[i],prices[i],workNames.charAt(i));
            workOrder[i]=m;

            max=Math.max(max,days[i] + 1);
        }

        char[] result=new char[max];
        Arrays.sort(workOrder);

        for(int i=workOrder.length-1; i>=0;i--)
        {
            int spot=workOrder[i].day;
            while(spot>0)
            {
                if(result[spot]=='\0')
                {
                    result[spot]=workOrder[i].name;
                    profit+=workOrder[i].profit;
                    break;
                }
                else
                {
                    spot--;
                }
            }

        }

        for(int i=0;i<result.length;i++)
        {
            System.out.print(result[i] + " ");
        }

        return profit;

    }





    public static int[][] largestSquare(int[][] board)                   //TO GET LARGEST SQUARE(made up of all 1's) SIZE. 
    {
        int[][] global=new int[board.length][board.length];

        for(int r=global.length-1;r>=0;r--)
        {
            for(int c=global[0].length-1;c>=0;c--)
            {
                if(r==global.length-1 || c==global[0].length-1)
                {
                    global[r][c]=board[r][c];
                }
                else if(board[r][c]==0)
                {
                    global[r][c]=0;
                }
                else
                {
                    int min=Math.min(global[r][c+1],Math.min(global[r+1][c+1],global[r+1][c]));

                    global[r][c]=min+1;
                }
            }
        }

        return global;
    }                                                             //REVIEWED.




    public static void main(String[] args)
    {
        // int[] wt={10,40,20,30};
        // int[] price={60,40,100,120};
        // product[] pricePerKg=new product[wt.length]; 
        // for(int i=0;i<wt.length;i++)
        // {
        //     pricePerKg[i]=product i(wt[i],price[i]);
        // }



        // int[] arrival={900,940,950,1100};                     //max platforms required.
        // int[] departure={}





        /*int[] lastLimitDay={1,6,5,4,2};                           //workOrder for max profit.
        int[] profits={8,14,3,5,10};
        String workName="abcde";
        System.out.println(workOrderPrint(lastLimitDay,profits,workName));      //reviewed.
        */




        /*int[][] board={                                       //to get largest square size(made of 1's only).
            {1,0,0,1,0,0,1,0},
            {1,1,1,1,1,1,1,1},
            {1,1,0,1,1,1,1,1},
            {1,0,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1},
            {1,0,1,0,1,1,0,1},
            {1,0,0,1,1,1,1,1}
        };

        int[][] global=largestSquare(board);
        for(int i=0;i<global.length;i++)
        {
            for(int j=0;j<global[0].length;j++)
            {
                System.out.print(global[i][j] + "\t");
            }
            System.out.println();
        }*/                                              //reviewed.
    }
}