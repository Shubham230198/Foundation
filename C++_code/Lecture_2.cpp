                                                //Lecture-2
                                                //16 June

#include<iostream>
using namespace std;



/**int main(int argc, char** argv)                   //simple interest
{
    int p=1000;
    int r=10;
    int t=2;
    int si=p*r*t/100;
    z
    cout<<"the simple intererst is"<<si;
    return 0;

}  */                                //Reviewed by praveen



/**int main(int argc, char** argv)      //time events overlaping
{   int e1s=0;
    int e1e=0;
    int e2s=0;
    int e2e=0;

    if(e1e<e2s||e2e<e1s)
    {
        cout<<"no overlap"<<endl;
    }

    else if((e1s<e2s && e1e>e2e)||(e1s>e2s && e1e<e2e))
    {
        cout<<"full overlap"<<endl;
    }

    else
    {
        cout<<"partial overlap";
    }

    return 0;
    

}*/                                     //Reviewed by praveen




/** int main(int argc, char** argv)          //loops
{   int n=3,i=1;
    while(i<=n)
    {
        cout<<i<<endl;
        i++;
    }   

    for(i=1;i<=n;i++)
    {   cout<<i<<endl;
    }                                                
} */                                      //Reviewed




/** int main(int argc, char** argv)                  //input
{
    int n;
    cout<<"enter the number";
    cin>>n;
    cout<<n*10;
    return 0;
}*/                                                  //Reviewed





/** int main(int argc, char** argv)                  //Prime or not
{
    int num,i,j;

    cout<<"enter the number ";
    cin>>num;

    for(i=2;i<=num/2;i++)
    {
        if(num%i==0)
        {
            break;
        }

    }

    if(i==num/2+1)
    {
        cout<<"it is prime"<<endl;
    }

    else
    {
        cout<<"not prime"<<endl;
    }

    return 0;
    
}*/                                       //reviewed




int main()                                //Series of prime-or-not
{
    int num, n,i;
    //cout<<"enter the count ";
    cin>>n;

    for(int j=1;j<=n;j++)
    {
        //cout<<"enter the "<<j<<"number ";        
        cin>>num;                                        //commented so that file
        bool flag=true;                                  //input output system could be used
        for(i=2;i*i<=num;i++)                            //with command {test <in >out} in terminal.
        {
            if(num%i==0)
            {
                flag=false;
                break;
            }

        }

        if(flag)
        {
            cout<<num<<" is prime"<<endl;
        }

        else
        {
            cout<<num<<" is not prime"<<endl;
        }

    }

    return 0;

}