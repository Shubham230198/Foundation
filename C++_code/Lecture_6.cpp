                                            //LECTURE-6
                                            //26-june
                                            
#include<iostream>
using namespace std;

/*void swap(int* a,int* b)                 //rotating the array.
{   int temp=*a;
    *a=*b;
    *b=temp;
}

void reverse(int* arr, int l, int r)
{   while(l<r)
    {
        swap(&arr[l],&arr[r]);
        l++;
        r--;
    }

}

void rotate(int* arr,int n,int k)
{   k=k%n;
    k=k<0?n+k:k;

    reverse(arr,0,n-k-1);   //p1->p1'
    reverse(arr,n-k,n-1);   //p2->p2'
    reverse(arr,0,n-1);     //(p1'p2')->(p1'p2')'=(p2p1)
}

void display(int* arr,int n)
{
    for(int i=0;i<n;i++)
    {
        cout<<arr[i]<<" ";
    }
    cout<<endl;
}

int main()
{
    int* arr=new int[7] {2,9,8,1,3,5,4};

    rotate(arr,7,3);
    display(arr,7);

    rotate(arr,7,17);
    display(arr,7);

    rotate(arr,7,-51);
    display(arr,7);
    return 0;
}*/                                   //Reviewed



/*int** getvalue(int r,int c)                 //2-D array declaration.
{
    int** arr=new int*[r];
    for(int i=0;i<r;i++)
    {
        arr[i]=new int[c];
        for(int j=0;j<c;j++)
        {
            cout<<"Enter the value of ["<<i<<","<<j<<"] ";
            cin>>arr[i][j];
        }
    }
    return arr;
}

void display(int** arr,int r, int c)
{
    for(int i=0;i<r;i++)
    {
        for(int j=0;j<c;j++)
        {
            cout<<arr[i][j]<<" ";
        }
        cout<<"\n";
    }
}

int main()
{
    int r=0;
    int c=0;

    cout<<"Enter the number of rows ";
    cin>>r;
    cout<<"Enter the number of columns ";
    cin>>c;

    int** arr=getvalue(r,c);
    display(arr,r,c);
    return 0;
}*/                                    //Reviewed.

