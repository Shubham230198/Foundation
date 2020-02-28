                                        //1-JULY
                                        //Lecture-9

                                        //(RECURSION IS STARTED)
#include<iostream>
using namespace std;

/*void fun(int n)                         //Recursion
{                                        
    if(n==0)                            //to print 1,2,3,4,5.
        return;
    fun(n-1);
    cout<<n<<", ";
}

int main(int argc,char** argv)
{
    int n=5;
    fun(n);
    return 0;
}*/                                       //REVIEWED.


/*void fun(int n)                          //to print 5 4 3 2 1 1 2 3 4 5
{
    if(n==0)
        return;

    cout<<n<<" ";
    fun(n-1);
    cout<<n<<" ";

}

int main(int argc,char** argv)
{
    int n=5;
    fun(n);
    return 0;
}*/                                       //REVIEWED.



/*int fun(int n)                            //ZIG_ZAG (twice recursion call within a function.)
{   
    if(n==0)
        return 0;
    cout<<n<<endl;
    fun(n-1);
    cout<<n<<endl;
    fun(n-1);
    cout<<n<<endl;
}

int main()
{
    int n=3;
    fun(n);
    return 0;
}*/                                       //REVIEWED.



/*int factorial(int n)                           //factorial function using recursion.
{  
    if(n==1)
        return 1;

    return n*factorial(n-1);
}

int main()
{
    int n=5;
    cout<<factorial(n)<<endl;
    return 0;
}*/                                             //REVIEWED.



/*int power(int a,int b)                        //power function with recursion.
{                                               //O(n)
    if(b==1)
        return a;
    
    return a*power(a,b-1);
}

int main()
{
    int a=2,b=4;
    cout<<power(a,b);

    return 0;
}*/                                             //REVIEWED.




/*int power(int a,int b)                        //power function with recursion.
{   int val;                                    //O(log(b))
    if(b==1)
        return a;
    
    val=power(a,b/2);
    val*=val;
    
    if(b%2==0)
        return val;
    else
        return a*val;
}

int main()
{
    int a=2,b=3;
    cout<<power(a,b);

    return 0;
}*/






void towerOfHanoi(string src,string help, string des, int n) {                  //TOWER OF HANOI.
    if(n == 0) {
        return;
    }

    towerOfHanoi(src, des, help, n-1);
    cout<<"move "<<n<<"th ring from "<<src<<" to "<<des<<endl;
    towerOfHanoi(help, src, des, n-1);
}


int main()
{
    string des = "destination";
    string help = "helper";
    string src = "source";
    int n = 3;

    towerOfHanoi(src, help, des, n);

    return 0;
}                                                                         //REVIEWED






