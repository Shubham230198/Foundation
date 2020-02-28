                                                //29 August
#include<iostream>
using namespace std;
                                                //linked list  (2).

class Node{                                                  //nodes for the linked list.
    public:
        int data;
        Node* next;

    Node()
    {
        this->data=0;
        this->next=NULL;
    }

    Node(int data,Node* next) 
    {
        this->data=data;
        this->next=next;
    }
};                                                         //reviewed.



void addLast(Node*& head,Node*& tail,int data)               //TO ADD A NODE AT ENDING OF LINKED LIST.
{
    if(head==NULL)
    {
        head=tail=new Node(data,NULL);
    }

    else
    {
        Node* nn=new Node(data,NULL);
        tail->next=nn;
        tail=nn;
    }    
}                                                           //REVIEWED.




void display(Node* head)                                     //To display the whole linked list.
{
    for(Node* i=head;i!=NULL;i=i->next)
    {
        cout<<i->data<<" ";
    }

    cout<<endl;
}                                                            //reviewed.




Node* getNodeAt(Node* head,int idx)                         //To get the whole node at given index.
{
    if(head==NULL)
        return NULL;
    else
    {   
        int j=0;
        for(Node* i=head;i!=NULL;i=i->next)
        {
            if(j==idx)
                return i;
            j++;
        }
    }

    return NULL;
}                                                         //REVIEWED.




int getSize(Node* head)                           //To get the size of link list.
{
    int j=0;
    Node* temp=head;
    while(temp!=NULL)
    {
        temp=temp->next;
        j++;
    }

    return j;
}                                                //reviewed.




void reverseDataIterator(Node* head,Node* tail)                      //to reverse the data inside the link list, by iterator.
{
    int li=0;
    int ri=getSize(head)-1;

    
    while(li<ri)
    {   
        Node* left=getNodeAt(head,li);
        Node* right=getNodeAt(head,ri);
        int temp=left->data;
        left->data=right->data;
        right->data=temp;

        li++;
        ri--;
    }
}                                                //reviewed.




void reversePointer(Node*& head,Node*& tail)                       //To reverse the link list(by changing the pointers).
{
    Node* pre=NULL;
    Node* curr=head;

    while(curr!=NULL)
    {
        Node* next= curr->next;
        curr->next=pre;

        pre=curr;
        curr=next;
    }

    Node* temp=tail;
    tail=head;
    head=temp;
}                                             //reviewed.




void displayReverseRecursive(Node* node)                    //to display the list data in reverse order only.
{   
    if(node==NULL)
        return;
    displayReverseRecursive(node->next);

    cout<<node->data<<" ";
}                                                                //reviewed.




void reverseDataRecursive(Node*& left,Node* right,int floor,int& size)   //to reverse the data recursively
{
    if(right==NULL)
    {
        return;
    }
    size++;
    reverseDataRecursive(left,right->next,floor+1,size);

    if(floor>=size/2)
    {
        int temp=left->data;
        left->data=right->data;
        right->data=temp;

        left=left->next;
    }

}                                                 //reviewed.




// void reversePointerRecursion(Node*& head,Node*& tail,Node* curr,Node* pre)
// {   
//     if(left->next=NULL)
//     {

//     }
// }


int main()
{   
    Node* head=NULL;
    Node* tail=NULL;

    addLast(head,tail,10);                                //creation of linked list.
    addLast(head,tail,20);
    addLast(head,tail,30);
    addLast(head,tail,40);
    // addLast(head,tail,50);



    /*display(head);
    reverseDataIterator(head,tail);                     //to reverse a linked list(by reversing the data  only, bu iterator)
    display(head);
    */                                                   //REVIEWED.



    /*display(head);                                  //to reverse the linked list by reversing the nodes arows(pointers).
    reversePointer(head,tail);
    display(head);          
    */                                                //reviewed.



    /*display(head);                                //To display the reverse link list(not to actually reverse).
    displayReverse(head);
    */                                              //reviewed.



   /*display(head);                        //to reverse the data among the nodes, recursively.
   Node* left=head;
   Node* right=head;
   int size=0;
   int floor=0;
   reverseDataRecursive(left,right,floor,size);
   display(head);
   */                                           //reviewed.




}