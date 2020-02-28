                                                //1 September
#include<iostream>
using namespace std;
                                                //Linked list (5)

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





void mergeSortedLists(Node* head1,Node* head2,Node*& otherHead,Node*& otherTail)
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



Node* findMidNode(Node*head,Node* tail)                          //To find the mid node of a link list or sub link list.
{   
    if(head==NULL)
        return NULL;

    Node* i=head;                                             //(with complexity of O(n))
    Node* j=head;

    while(i!=tail && i->next!=tail)
    {
        j=j->next;
        i=i->next->next;
    }

    return j;
}                                                          //reviewed.



void mergeSort(Node*& head,Node*& tail)
{   
    if(head==tail)
    {
        Node* nn=new Node(head->data,NULL);
        head=tail=nn;
        return;
    }

    Node* mid=findMidNode(head,tail);
    
    Node* lh=head;
    Node* lt=mid;
    Node* rh=mid->next;
    Node* rt=tail;
    mergeSort(lh,lt);
    mergeSort(rh,rt);

    Node* fullHead=NULL;
    Node* fullTail=NULL;
    mergeSortedLists(lh,rh,fullHead,fullTail);
    head=fullHead;
    tail=fullTail;
}



void itselfMergeSortedLists(Node* lh,Node* lt,Node* &oh,Node* &ot)
{   
    Node* t1=lh;
    Node* t2=rh;
    
    while(t1!=NULL && t2!=NULL)
    {
        Node* rm=NULL;
        if(t1->data<t2->data)
        {
            rm=t1;
            t1=t1->next;
            rm->next=NULL;
        }
        else
        {
            rm=t2;
            t2=t2->next;
            rm->next=NULL;
        }

        if(oh==NULL)
        {
           oh=ot=rm; 
        }
        else
        {
            
        }
        
        
    }
}



void itselfMergeSort(Node* &head,Node* tail)
{   
    if(head==tail)
    {
        return;
    }

    Node* mid=findMidNode(head,tail);

    Node* lh=head;
    Node* lt=mid;
    Node* rh=mid->next;
    Node* rt=tail;

    mid->next=NULL;
    itselfMergeSort(lh,lt);
    itselfMergeSort(rh,rt);
    
    Node* fh=NULL;
    Node* ft=NULL;

    itselfMergeSortedLists(lh,lt,rh,rt,fh,ft);
    head=fh;
    tail=ft;
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


    // display(head);
    Node* testHead=head;
    Node* testTail=tail;
    mergeSort(testHead,testTail);
    display(testHead);

}