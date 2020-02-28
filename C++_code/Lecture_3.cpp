                                        //Lecture 3
                                        //18 June

    #include<iostream>
    #include<math.h>
    using namespace std;

    /*int main()                           //Special reverse with index.
    {
        int num;
        cout<<"enter the number";
        cin>>num;
        double rnum=0.0;
        for(int i=1;num!=0;i++)
        {
            int a;
            double m;
            a=num%10;
            m=a;
            rnum=rnum+ i*pow(10,m-1);
            num/=10;
        }

        cout<<"the output number is "<<rnum;

        return 0;

    }*/                                     //reviewed



     /*int main()                           //fibonacci`
    {
        int num,size;
        cout<<"enter the total count";
        cin>>size;
        int S[size];


        S[0]=0;
        S[1]=1;

        for(int i=2;i<size;i++)
        {
            S[i]=S[i-1]+S[i-2];
        }

        for(auto i:S)
        {
            cout<<i<<endl;
        }

        return 0;
    }*/                                             //REVIEWED.



    /* int main()                                   //greatest common divisor(GCD)
    {
        int num1,num2;
        cout<<"enter the two number ";
        cin>>num1>>num2;
        int a=-1
        while(a!=0)
        {
            a=num2%num1;

            if(a==0)
            {
                cout<<num1<<" is gcd"<<endl;
            }
            num2=num1;
            num1=a;
        }

        return 0;
    }*/                                             //reviewed




    /*int main()                                //fibonacci right triangle
    {
        int row;

        cout<<"enter the rows";
        cin>>row;
        int a=0;
        int b=1;
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
    }*/                                       //Reviewed


    /*int main()                               //pascal triangle right triangle
    {   
        int n=6;

        for(int r=0;r<6;r++)
        {   int val=1;
            for(int c=0;c<=r;c++)
            {   
                cout<<val<<" ";
                val=val*(r-c)/(c+1);
            }

            cout<<endl;
        }

        return 0;
    } */                                       //reviewed



/*int main()                                   //Pattern
{
    int n=7;
    int nspaces=n/2;
    int nstars=1;

    for(int r=1;r<=n;r++)                            //*
    {                                               //***
        for(int j=1;j<=nspaces;j++)                //*****
        {                                         //*******
            cout<<"   ";                           //*****
        }                                           //***
                                                     //*
        for(int j=1;j<=nstars;j++)
        {
            cout<<" * ";
        }
        cout<<endl;

        if(r<n/2)
        {
            nspaces--;
            nstars+=2;
        }
        else
        {
            nspaces++;
            nstars-=2;
        }
        
    }

    return 0;
}*/                                            //reviewed



/*int main()                                         //Pattern
{
    int n=7;                             
    int nstars=n/2;                                  //* * *   * * *
    int nspaces=1;                                   //* *       * *
                                                     //*           *
    for(int r=1;r<=n;r++)                            //
    {                                                //*           *
        for(int j=1;j<=nstars;j++)                   //* *       * *
        {                                            //* * *   * * *
            cout<<" * ";
        }

        for(int j=1;j<=nspaces;j++)
        {
            cout<<"   ";
        }

        for(int j=1;j<=nstars;j++)
        {
            cout<<" * ";
        }

        cout<<endl;

        if(r<=n/2)
        {
            nstars--;
            nspaces+=2;
        }
        else
        {
            nstars++;
            nspaces-=2;
        }
        
    }

    return 0;
}*/











