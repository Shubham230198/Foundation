                                                //30 august
#include<iostream>
using namespace std;
                                                //Linked list (3)

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




int getSize(Node* head)                       //To get the size of the linked list.
{
    int j=0;
    Node* temp=head;
    while(temp!=NULL)
    {
        temp=temp->next;
        j++;
    }

    return j;
}                                             //reviewed.






void fold(Node*& tail,Node*& left, Node*right,int floor,int& size)     //to fold the link list.
{
    if(right==NULL)
        return;
    
    size++;
    fold(tail,left,right->next,floor+1,size);

    if(floor>size/2)
    {
        Node* temp=left->next;
        left->next=right;
        right->next=temp;

        left=temp;
    }
    else if(floor==size/2)
    {
        right->next=NULL;
        tail=right;
    }
}                                                //reviewed.





// bool isPalindrome(Node*&left,Node* right,int floor,int& size)
// {
//     if(right==NULL)
//     {
//         return true;
//     }
//     size++;

//     bool flag=isPalindrome(left,right->next,floor+1,size);

//     if(floor>=size/2)
//     {
//         flag=flag && left->data == right->data;
//         left->next;
//     }

//     return flag;
// }





void addAfterTail(Node*& tail,Node*& node)                    //To unfold the folded link list. 
{                                                                  //(just to add given node after the tail)
    Node* temp=tail->next;                                    
    tail->next=node;
    node->next=temp;
}

void unFold(Node*& head,Node*& tail)                      //(actual function to unfold.)
{   
    int sz=getSize(head);
    for(Node* i=head;(sz%2==0?(i->next!=tail):(i!=tail));i=i->next)
    {
        Node* ip1=i->next;
        i->next=ip1->next;
        addAfterTail(tail,ip1);
    }

    Node* j=tail;
    while(j->next!=NULL)
    {
        j=j->next;
    }
    tail=j->next;
}                                             //reviewed.





Node* findMid(Node*head)                                   //To find the mid node of a link list.
{   
    if(head==NULL)
        return NULL;

    Node* i=head;                                             //(with complexity of O(n))
    Node* j=head;

    while(i->next!=NULL && i->next->next!=NULL)
    {
        i=i->next->next;
        j=j->next;
    }

    return j;
}                                                          //reviewed.




Node* kFromLast(Node* head,int k)                    //To get Kth node from last
{
    Node* fast=head;                                    //In time complexity of O(n).
    Node* slow=head;
    int count=0;

    while(count!=k)
    {
        fast=fast->next;
        count++;
    }

    while(fast!=NULL)
    {
        fast=fast->next;
        slow=slow->next;
    }

    return slow;
}                                                           //reviewed.




int main()
{   
    Node* head=NULL;
    Node* tail=NULL;

    addLast(head,tail,10);                                //creation of linked list.
    addLast(head,tail,20);
    addLast(head,tail,30);
    addLast(head,tail,40);
    addLast(head,tail,50);
    // addLast(head,tail,60);


    /*display(head);                                      //To fold the link list
    Node* left=head;
    Node* right=head;
    int size=0;
    int floor=0;
    fold(tail,left,right,floor,size);
    display(head);
    */                                                     //reviewed.


    
    /*unFold(head,tail);                                   //to unfold the link list.
    display(head);
    */                                                      ///reviewed.

    // Node* left=head;
    // Node* right=head;
    // int size=0;
    // int floor=0;
    // cout<<isPalindrome(left,right,floor,size);


    /*Node* mid=findMid(head);                               //To find mid element of a link list.
    cout<<mid->data<<" ";
    */                                                       //reviewed.                                    
    

    Node* kth=kFromLast(head,3);
    cout<<kth->data<<" ";
}         


