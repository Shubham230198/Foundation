                                                    //26 august
#include<iostream>
using namespace std;
                                                    //LINKED LIST (1).


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




void addFirst(Node*& head,Node*& tail,int data)              //TO ADD A NODE AT STARTING OF LINKED LIST.
{
    if(head==NULL)
    {
        head=tail=new Node(data,NULL);
    }
    else
    {
        Node* nn=new Node(data,head);
        head=nn;
    }
    
}                                                            //REVIEWED.





int getFirst(Node* head)                                    //To get the data of first element.
{
    if(head==NULL)
    {
        return -1;
    }
    else
    {
        return head->data;
    }
}                                                         //REVIEWED.





int getLast(Node* tail)                                    //TO get the last node data.
{
    if(tail==NULL)
        return -1;
    else
    {
        return tail->data;
    }
}                                                         //REVIEWED.





int getDataAt(Node* head,int idx)                         //TO get data of any specific node, with given index.
{
    if(head==NULL)
        return -1;
    else
    {   
        int j=0;
        for(Node* i=head;i!=NULL;i=i->next)
        {
            if(j==idx)
                return i->data;
            j++;
        }
    }

    return -1;
}                                                          //REVIEWED.




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




int getSize(Node* head)                             //To get the size of link list.
{
    int j=0;
    Node* temp=head;
    while(temp!=NULL)
    {
        temp=temp->next;
        j++;
    }

    return j;
}                                                    //reviewed.




void addAt(Node*& head,Node*& tail,int data,int idx)         //To add a node at any given index.
{   
    int sz=getSize(head);

    if(idx<0 || idx>sz)
    {
        cout<<"invalid idx"<<endl;
    }
    else if(idx==0)
    {
        addFirst(head,tail,data);
    }
    else if(idx==sz)
    {
        addLast(head,tail,data);
    }
    else
    {
        Node* nml=getNodeAt(head,idx-1);
        nml->next=new Node(data,nml->next);
    }
    
}                                                            //reviewed.




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




void removeAtLast(Node* head,Node* tail)                               //To remove from last.
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
        int sz=getSize(head);
        Node* sl=getNodeAt(head,sz-2);
        sl->next=NULL;
        delete tail;
        tail=sl;
    }
    
}                                                          //reviewed.




void removeAt(Node*& head,Node*& tail,int idx)                          //To remove at any index.
{
    int sz=getSize(head);

    if(idx<0 || idx>=sz)
    {
        cout<<"invalid index"<<endl;
    }
    else if(idx==0)
    {
        removeAtFirst(head,tail);
    }
    else if(idx==sz-1)
    {
        removeAtLast(head,tail);
    }
    else
    {
        Node* nm1=getNodeAt(head,idx-1);
        Node* n=nm1->next;
        nm1->next=n->next;
        delete n;
    }
    
}                                                             //reviewed.





void display(Node* head)                                     //To display the whole linked list.
{
    for(Node* i=head;i!=NULL;i=i->next)
    {
        cout<<i->data<<" ";
    }
}                                                            //reviewed.




int main()
{
    Node* head=NULL;
    Node* tail=NULL;

    addAt(head,tail,100,0);
    removeAtLast(head,tail);
    addFirst(head,tail,70);
    addLast(head,tail,10);                                //creation of linked list.
    addLast(head,tail,20);
    addLast(head,tail,30);
    addLast(head,tail,40);
    addLast(head,tail,50);
    addFirst(head,tail,60);

    //addAt(head,tail,1000,8);                          //this case to give "index not valid" as indx is much greater.
    addAt(head,tail,200,3);

    removeAtFirst(head,tail);                                  //to remove node from first.

    removeAtLast(head,tail);                                  //to remove from last.

    removeAt(head,tail,2);                                    //to remove at any index.
    display(head);

    return 0;
}
