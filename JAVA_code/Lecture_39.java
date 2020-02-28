                                             //14 August,2019
import java.util.*;
                                            //GENERIC TREES
public class Lecture_39
{   
    public class Node                                        //creation of node of a generic tree, by dynamic growing
    {                                                        //data structure.
        int data=0;
        ArrayList<Node> children=new ArrayList<>();

        Node()
        {
            this.data=0;
            this.children=null;
        }
        Node(int data)
        {
            this.data=data;
            this.children=null;
        }

    }

    static Node getTree(int[] order)
    {   
        Node root=new Node();
        root.data=order[0];
        
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        return root;
    }
    public static void main(String[] args)
    {
        int[] order={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

        Node tree=getTree(order);
    }
}