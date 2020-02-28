                                                     //19 AUGUST, 2019
import java.util.*;
                                                     //Binary tree.
public class Lecture_43
{
    static class Node                                    //NODE CLASS
    {
        int data;
        Node left;
        Node right;
    }                                                    //REVIEWED.


     /* Construction of Tree Start*/
    static Node construct(int[] arr)
    { Node root=null;
       Stack<Node> stack=new Stack<>();
       for(int val:arr)
       {  if(val==-1) //if value is -1,Pop the Value from Stack
          {
              stack.pop();
          }
          else
          { Node node=new Node(); //Make the node 
            node.data=val; //Enter the value on the node
            if(stack.isEmpty())
            {
              root=node;
            }
            else
            { 
                if(stack.peek().left==null)
                { 
                    stack.peek().left=node; 
                }
                else
                {
                    stack.peek().right=node;    
                }

             }
            stack.push(node);
          }

       }   
       return root;     
    }
   /* Construction of Tree End*/  



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


      //Print in range , the path from root to leave node having sum of elements within range.
    static void pir(Node node,int lo,int hi,int ssf,String psf)
    {   if(node==null)
        {  return;
 
        }
        if(node.left == null && node.right==null) 
        {
            if(ssf+node.data>=lo && ssf+node.data<=hi)
            { 
                System.out.println(psf+" "+node.data);
            }
            return;
        }
        pir(node.left, lo, hi, ssf+node.data, psf+" "+node.data+" -> ");
        pir(node.right, lo, hi, ssf+node.data, psf+" "+node.data+" -> ");
    }                                                                       //REVIEWED.

    

    static Node construct2(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd)   //to construct a tree from its
    {                                                                                          //inOrder and preOrder.
        if(preStart>preEnd || inStart>inEnd)
            return null;

        Node root=null;
        int spot=-1;
        for(int i=inStart;i<=inEnd;i++)
        {
            if(in[i]==pre[preStart])
                spot=i;
        }
        int leftCount=spot-inStart;

        Node left=construct2(pre, preStart+1, (preStart)+(leftCount), in, inStart, spot-1);
        Node right=construct2(pre, (preStart) + (leftCount) +1, preEnd, in, spot+1, inEnd);

        Node node=new Node();
        node.data=pre[preStart];
        node.left=left;
        node.right=right;
        root=node;

        return root;
    }                                                             //REVIEWED.


    public static void main(String[] args)
    {
        /*int[] arr={50,25,12,-1,37,30,-1,40,-1,-1,-1,75,62,60,-1,70,-1,-1,87,-1,-1,-1};
        Node root= construct(arr);

        //display(root);                                   //to display the tree.

        //pir(root,150,250,0,"");                            //toget the paths to the roots with node's sum in the range.
        */


        /*int[] pre={50,25,12,37,30,75,62,70,87};                      //construct a tree from its inOrder and preOrder.
        int[] in={12,25,30,37,50,62,70,75,87};

        Node root=construct2(pre,0,pre.length-1,in,0,in.length-1);
        display(root);*/                                                 //reviewed.

    }
}