                                                //LECTURE-16
                                                //JULY - 11

//import java.util.*;
public class Lecture_16
{

    /*public static void combi2(int cb_idx,int tb_idx,int tbs, int r,String ans)                   //TO GET COMBINATION of objects among boxes.                        //COMBINATION OF BOXES.
    {   
        if(cb_idx == tb_idx + 1)
        {
            if(tbs==r)
            {
                System.out.println(ans);
            }
            return;
        }

        if(tbs < r) {
            //to select this perticular box.   
            combi2(cb_idx+1,tb_idx,tbs+1,r,ans+ " "+cb_idx );
    
        }

        //to not to select this particular box.
        combi2(cb_idx+1,tb_idx,tbs,r,ans);

    }

    public static void main(String[] args)
    {
        boolean[] box=new boolean[4];
        combi2(0,4,0,2,"");
    }*/                                                                        //REVIEWED





    /*public static void permu(int cb,int n,int isf,int r,String ans,boolean[] items)            //PERMUTATION OF OBJECTS IN BOXES.
    {                                                                                              // using second method
        if(cb>n)
        {
            if(isf==r)
            {
                System.out.println(ans);
            }
            return;
        }

       permu(cb+1,n,isf,r,ans,items);
       for(int i=0;i<items.length;i++)  
       {    
           if(items[i]==false)
           {
               items[i]=true;
               permu(cb+1,n,isf+1,r, ans+i+"["+cb+"]",items);
               items[i]=false;
           }
       }

    }

    public static void main(String[] args)
    {
        boolean[] items={false,false};
        permu(0,4,0,2,"",items);
     
    }*/                                                               //REVIEWED.





    /*public static void money_permu(int total,int so_far,int[] arr,String ans)             //TO get coin change permutation
    {   
        if(so_far==total)
        {
            System.out.println(ans);
            return;
        }

        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<=total-so_far)
            {   
                money_permu(total,so_far + arr[i],arr,ans+ arr[i]);
            }
        }
    }
    
    public static void main(String[] args)
    {
        int[] arr={2,3,5,6};
        money_permu(7,0,arr,"");
    }*/                                                             //REVIEWED.




    
    /*public static void money_combi(int total,int so_far, int idx,int[] arr,String ans)            //TO get coin change combination.
    {
        if(total == so_far) {
            System.out.println(ans);
            return;
        }

        for(int i = idx; i < arr.length; i++) {
            if(so_far + arr[i] <= total) {
                money_combi(total, so_far + arr[i], i, arr, ans + arr[i]);
            }
        }
    }


    public static void main(String[] args)
    {
        int[] arr={2,3,5,6};
        money_combi(7, 0, 0, arr, "");
    }*/                                                       //REVIEWED.
}