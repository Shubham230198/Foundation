#include<iostream>
using namespace std;

/* int main()
{   int n=7;
    int nspaces=n/2;                          //*
    int nstars=1;                            //***
                                            //*****
    for(int k=1;k<=n;k++)                  //*******
    {                                       //*****
        for(int i=1;i<=nspaces;i++)          //***
        {    cout<<" ";                       //*
        }
        
        for(int j=1;j<=nstars;j++)
        {    cout<<"#";
        }
        cout<<"\n";

        if(k<=n/2)
        {   nspaces-=1;
            nstars+=2;
        }
        else
        {
            nspaces+=1;
            nstars-=2;
        }
        
    }

    return 0;
}



/* int main()
{   int n=7;                        //### ###
    int nstars=n/2;                 //##   ##
    int nspaces=1;                  //#     #
                                    //
    for(int k=1;k<=n;k++)           //#     #
    {                               //##   ##     
        for(int i=1;i<=nstars;i++)  //### ###
        {    cout<<"#";
        }
        
        for(int j=1;j<=nspaces;j++)
        {    cout<<" ";
        }

        for(int i=1;i<=nstars;i++)
        {
            cout<<"#";
        }
        cout<<"\n";

        if(k<=n/2)
        {   nspaces+=2;
            nstars-=1;
        }
        else
        {
            nspaces-=2;
            nstars+=1;
        }
        
    }

    return 0;
}*/




/*int main() 
{   int n=7;                            //1
    int nspaces=n/2;                   //222
    int nstars=1;                     //33333
    int out=1;                       //4444444
                                      //33333
    for(int k=1;k<=n;k++)              //222
    {                                   //1
        for(int i=1;i<=nspaces;i++)
        {    cout<<" ";
        }
        
        for(int j=1;j<=nstars;j++)
        {    cout<<out;
        }
        cout<<"\n";

        if(k<=n/2)
        {   nspaces-=1;
            nstars+=2;
            out++;
        }
        else
        {
            nspaces+=1;
            nstars-=2;
            out--;
        }
        
    }

    return 0;
}*/





/*int main()                            //1
{   int n=5;                           //234
    int nspaces=n/2;                  //34567
    int nstars=1;                      //456
    int out;                            //5

    for(int k=1;k<=n;k++)
    {
        for(int i=1;i<=nspaces;i++)
        {    cout<<" ";
        }
        
        out=k;
        for(int j=1;j<=nstars;j++)
        {   cout<<out;
            out++;
        }
        cout<<"\n";

        if(k<=n/2)
        {   nspaces-=1;
            nstars+=2;
        }
        else
        {
            nspaces+=1;
            nstars-=2;
        }
        
    }

    return 0;
}*/




/*int main()                              //1
{   int n=7;                             //234
    int nspaces=n/2;                    //34567
    int nstars=1;                        //234
    int start=1;                          //1
    int out;

    for(int k=1;k<=n;k++)
    {
        for(int i=1;i<=nspaces;i++)
        {   cout<<" ";
        }
        
        int out=start;
        for(int j=1;j<=nstars;j++)
        {   cout<<out;
            out++;
        }
        cout<<"\n";

        if(k<=n/2)
        {   nspaces-=1;
            nstars+=2;
            start++;
        }
        else
        {
            nspaces+=1;
            nstars-=2;
            start--;
        }
        
    }

    return 0;
}*/





int main()                              //1
{   int n=7;                           //232
    int nspaces=n/2;                  //32123
    int nstars=1;                    //4321234
    int start=1;                      //32123
    int out;                           //212
                                        //1
    for(int k=1;k<=n;k++)
    {
        for(int i=1;i<=nspaces;i++)
        {   cout<<" ";
        }
        
        int out=start;
        for(int j=1;j<=nstars;j++)
        {   cout<<out;

            if(j<=nstars/2)
                out++;
            else
                out--;
            
        }
        cout<<"\n";

        if(k<=n/2)
        {   nspaces-=1;
            nstars+=2;
            start++;
        }
        else
        {
            nspaces+=1;
            nstars-=2;
            start--;
        }
        
    }

    return 0;
}




/*int main()                                //fibonacci right triangle
    {
        int row;

        cout<<"enter the rows";             //1
        cin>>row;                           //1  2
        int a=0;                            //3  5  8
        int b=1;                            //13 21 34  55
        int c;                             
        for(int i=1;i<=row;i++)
        {
            for(int j=1;j<=i;j++)
            {   cout<<a<<" ";
                c=a+b;
                a=b;
                b=c;
            }
            cout<<endl;

        }

        return 0;
    }*/   




/*int main()                               //pascal triangle right triangle
    {   
        int n=6;

        for(int r=0;r<6;r++)                    //1
        {   int val=1;                          //1   1
            for(int c=0;c<=r;c++)               //1   2   1
            {                                   //1   3   3   1 
                cout<<val<<" ";                 //1   4   6   4   1
                val=val*(r-c)/(c+1);            //1   5   10  10  5  1
            }

            cout<<endl;
        }

        return 0;
    } */                                       