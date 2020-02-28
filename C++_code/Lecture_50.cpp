                                                //31 august
#include<iostream>
using namespace std;
                                                //Linked list (4)

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




void removeAtFirst(Node*& head,Node*& tail)                             //To remove the first node.
{
    if(head==NULL)
    {
        cout<<"nothing to remove"<<endl;
    }
    else if(head->next==NULL)
    {
        Node* temp=head;
        head=tail=NULL;
        delete temp;
    }
    else
    {
        Node* temp=head;
        head=head->next;
        delete temp;
    }
    
}                                                           //reviewed.




Node* kRevHelp(Node*th,int k)
{
    Node* prev=NULL;
    Node* curr=th;

    for(int i=0;i<k;i++)
    {
        Node* temp=curr->next;
        curr->next=prev;
        prev=curr;
        curr=temp;
    }
    th->next=curr;
    return prev;
}

void kReverse(Node*& head,Node*& tail,int k)
{
    int sz=getSize(head);
    if(sz<k)
    {
        return;
    }

    int counter=0;
    Node* t1=head;
    Node* t2=kRevHelp(t1,k);
    head=t2;
    counter+=k;
    
    while(sz-counter>=k)
    {
        Node* nt1=t1->next;
        Node* nt2=kRevHelp(nt1,k);
        t1->next=nt2;
        t1=nt1;
        counter+=k;
    }

    if(counter==sz)
    {
        tail=t1;
    }

}




//second kreverse.





// void segregate


// Node* removeDuplicates(Node*& head,Node*& tail)
// {
//     Node* newHead=NULL;
//     Node* newTail=NULL;

//     while(head!=NULL)
//     {   
//         int temp=head->data;
//         removeAtFirst(head,tail);

//         if(temp!=)
        
//     }
// }
 




bool detetactCycle(Node* head)
{
    Node* fast=head;
    Node* slow=head;

    while(fast!=NULL && fast->next!=NULL)
    {
        slow=slow->next;
        fast=fast->next->next;

        if(slow==fast)
            return true;
    }

    return false;
}




void detectAndRemoveCycle(Node* head)
{
    Node* fast=head;
    Node* slow=head;

    while(fast!=NULL && fast->next!=NULL)
    {
        slow=slow->next;
        fast=fast->next->next;

        if(slow == fast)
        {
            cout<<"cycle present"<<endl;
            if(slow==head)
            {
                fast=head;
                while(slow->next!=head)
                {
                    slow=slow->next;
                    fast=fast->next;
                }
                slow->next=NULL;
                display(head);
                break;
            }
            else
            {
                fast=head;
                while(slow->next!=fast->next)
                {
                    slow=slow->next;
                    fast=fast->next;
                }

                slow->next=NULL;
                display(head);
                break;
            }
        }
        
    }

}





// Node* getIntersection(Node* head1,Node* head2)
// {
//     int sz1=getSize(head1);
//     int sz2=getSize(head2);

//     int fact=
// }




2,Node*& otherHead,Node*& otherTail)
{
    Node* i=head1;
    Node* j=head2;

    while(i!=NULL && j!=NULL)
    {
        if(i->data<j->data)
        {
            addLast(otherHead,otherTail,i->data);
            i=i->next;
        }
        else
        {
            addLast(otherHead,otherTail,j->data);
            j=j->next;
        }
    }

    while(j!=NULL)
    {
        addLast(otherHead,otherTail,j->data);
        j=j->next;
    }
    
    while(i!=NULL)
    {
        addLast(otherHead,otherTail,i->data);
        i=i->next;
    }
    
}


int main()
{   
    Node* head=NULL;
    Node* tail=NULL;

    addLast(head,tail,70);
    addLast(head,tail,10);                                //creation of linked list.
    addLast(head,tail,60);
    addLast(head,tail,30);
    addLast(head,tail,20);
    addLast(head,tail,50);
    addLast(head,tail,40);

    

    /*display(head);
    kReverse(head,tail,3);
    display(head);
    */

    // int arrp[]=arr{2,2,2,3,3,4,6,6,6,7,8,8};           for duplicates.



    /*                                                       //to detect the cycle in a link list.
    Node* temp3=getNodeAt(head,3);
    tail->next=temp3;

    cout<<detetactCycle(head,tail);
    */                                                  //reviewed.


    /*Node* temp3=getNodeAt(head,2);                         //to detect and remove the cycle if present in given link list.
    tail->next=temp3;
    detectAndRemoveCycle(head);
    */                                                     //reviewed.



    
    // Node* otherHead=NULL;
    // Node* otherTail=NULL;

    // mergeSortedLists();
    // display(otherHead)

    
    
}