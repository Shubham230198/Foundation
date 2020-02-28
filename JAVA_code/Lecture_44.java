                                            //21 AUGUST,2019.
import java.util.*;

import javax.lang.model.util.ElementScanner6;
                                            //Binary Trees.
public class Lecture_44
{   
    static class Node                                    //NODE CLASS
    {
        int data;
        Node left;
        Node right;
    }                                                    //REVIEWED.


     /*Display The Tree*/
     static void display(Node node)
     {
         if(node==null)
         {
             return;
         }
  
        String str="";
        str+=node.left!=null ?node.left.data +" -> " : " . -> ";
        str+=node.data;
        str+=node.right!=null ?" <- "+node.right.data: " <-  .";
        System.out.println(str);
  
        display(node.left); 
        display(node.right); 
     }                                                             //REVIEWED.



     static Node construct3(int[] post,int postStart,int postEnd,int[] in,int inStart,int inEnd)   //to construct a tree from its
     {                                                                                          //inOrder and preOrder.
         if(postStart>postEnd || inStart>inEnd)
             return null;
 
         Node root=null;
         int spot=-1;
         for(int i=inStart;i<=inEnd;i++)
         {
             if(in[i]==post[postEnd])
                 spot=i;
         }
         int leftCount=spot-inStart;
 
         Node left=construct3(post, postStart, (postStart)+(leftCount-1), in, inStart, spot-1);
         Node right=construct3(post, (postStart) + (leftCount-1) +1, postEnd-1, in, spot+1, inEnd);
 
         Node node=new Node();
         node.data=post[postEnd];
         node.left=left;
         node.right=right;
         root=node;
 
         return root;
     }                                                             //REVIEWED.


    // static Node construct4(int[] pre,int preStart,int preEnd,int[] post,int postStart,int postEnd)
    // {   
    //     if(preStart>preEnd || postStart>postEnd)
    //         return null;
            
    //     Node root=null;
    //     int spot=-1;
    //     for(int i=postStart;i<=postEnd;i++)
    //     {
    //         if(post[i]==pre[preStart+1])
    //         {
    //             spot=i;
    //             break;
    //         }
    //     }
    //     int count=spot-postStart;

    //     Node left=construct4(pre, preStart+ 1, preStart+count, post, postStart, postStart+count);
    //     Node right=construct4(pre, preStart+count+1, preEnd, post, postStart+count+1, postEnd);

    //     Node node=new Node();
    //     node.data=pre[preStart];
    //     node.left=left;
    //     node.right=right;
    //     root=node;

    //     return root;
    // }


    
    static class helper
    {
        Node node;
        int status;

        helper()
        {
        }

        helper(Node node,int st)
        {
            this.node=node;
            this.status=st;
        }
    }

    static void printAllOrders(Node root)
    {
        ArrayList<Integer> pre=new ArrayList<>();
        ArrayList<Integer> in=new ArrayList<>();
        ArrayList<Integer> post=new ArrayList<>();

        Stack<helper> stack=new Stack<>();
        helper h=new helper(root,0);
        stack.push(h);

        while(stack.size()>0)
        {   
            helper top=stack.peek();
            
            if(top.status==0)
            {
                pre.add(top.node.data);
                top.status+=1;

                if(top.node.left!=null)
                {
                    helper l=new helper(top.node.left,0);
                    stack.push(l);
                }
            }
            else if(top.status==1)
            {
                in.add(top.node.data);
                top.status+=1;
                if(top.node.right!=null)
                {
                    helper r=new helper(top.node.right,0);
                    stack.push(r);
                }
            }
            else if(top.status==2)
            {
                post.add(top.node.data);
                stack.pop();
            }
        }

        System.out.println("pre -> "+ pre);
        System.out.println("in -> " + in);
        System.out.println("post -> " + post);
    }


    /*Height Of Tree*/
    static int height(Node node)
    {  if(node==null)
        {
            return 0; //For Height in terms of node
           // return -1 : For Height in terms of edges
        }
          
        int lh=height(node.left);
        int rh=height(node.right);
        int max=1+Math.max(lh,rh);

        return max;
    }                                                   //reviewed.


    
    static int diameterOfTree(Node node)
    {   
        if(node==null)
            return 0;

        int lh=height(node.left);
        int rh=height(node.right);
        int factor=lh+rh+1;

        int leftDiameter=diameterOfTree(node.left);
        int rightDiameter=diameterOfTree(node.right);

        return Math.max(factor,Math.max(leftDiameter,rightDiameter));
    }



    // static int diameter2(Node node)
    // {

    // }

    public static void main(String[] args)
    {
        int[] post={12,30,37,25,70,62,87,75,50};
        int[] in={12,25,30,37,50,62,70,75,87};
        int[] pre={50,25,12,37,30,75,62,70,87};

        Node root=construct3(post,0,post.length-1,in,0,in.length-1);       //to create a tree from post and in order.
        //display(root);
        

        // Node root=construct4(pre, 0, pre.length-1, post,0, post.length-1);     //to create a tree from post and pre order.
        // display(root);

        /*Node root=construct3(post,0,post.length-1,in,0,in.length-1);        //to print PRE,IN,POST order of a tree.
        printAllOrders(root);                              
        */                                                                  //reviewed.


        System.out.println(diameterOfTree(root));                //to get the diameter of the tree.
    }
}