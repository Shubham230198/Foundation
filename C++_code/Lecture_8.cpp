                                                    //28- June
                                                    //Lecture-8

#include<iostream>
#include<vector>
using namespace std;

/*bool isood(int num)                               //to introduce vectors
{
    if(num%2!=0)                                    //program to add only odd inputs into vector.
        return true;
    else
        return false;
}


vector<int> check(int n)
{   
    vector<int> res;           //declaring vector.
    for(int i=0;i<n;i++)
    {
        int num;
        cout<<"enter the "<<i<<"th number ";
        cin>>num;

        bool flag=isood(num);

        if(flag)
            res.push_back(num);        //vector.push_back() function to append the value to array.

    }
    return res;              //returning vector.

}


int main()
{
    int n;
    cout<<"enter the count of numbers";
    cin>>n;

    vector<int> v= check(n);           //getting a vector from the 'check' function.

    for(int i=0;i<v.size();i++)         //vector.size() function to get the size of vector.
    {
        cout<<v[i]<<" ";
    }

    return 0;
}*/                                                  //Reviewed.





/*void filter(vector<int>& rcv)                          //to remove all values from the vector which are greater than 50;
{
    for(int i=0;i<rcv.size();i++)
    {
        if(rcv[i]>50)
        {
            rcv.erase(rcv.begin()+i);
            i--;
        }
    }

    // OR
    // for(int i=rcv.size-1;i>=0;i--)
    // {
    //     if(rcv[i]>50)
    //     {
    //         rcv.erase(rcv.begin()+i);
    //     }
    // }
}


int main(int argc,char** argv)                   //Vectorname.erase(address) function to remove the value from the vector, at the given address.
{
    //vector<int> vec {25,2,19,74,6,11,54,26,32,27,89};
    vector<int> vec {51,59,56,55,67};
    filter(vec);

    for(int i=0;i<vec.size();i++)
    {
        cout<<vec[i]<<" ";
    
    }
    return 0;
}*/                                    



/*int main()                                       //train window problem.
{
    vector<int> vec {10,20,30,40,50,60,70,80};
    int ws=3;
    int we=5;

    for(int i=0;i<vec.size();i++)
    {
        for(int j=ws;j<=we;j++)
        {
            cout<<vec[j]<<" ";
        }
        cout<<endl;
        int val=vec.back();             //vectorname.back()    function returns the last value in the vector.
        vec.pop_back();                 //vectorname.pop_back()    function removes the last value from the vector.
        vec.insert(vec.begin(),val);    //vectorname.insert(where_to_add,what_to_add)   function adds the given value into the vector at desired position.
    }                                                  //there is nothing like vectorname.pop_begin()
} */                                             //Reviewed.

 
/*Note:
    1.There is nothing like vectorname.pop_begin().
    2.vectorname.back() gives the last value from the vector.
    3.While vectorname.begin() gives the address, from where the vector is starting.
*/




int main()
{
    vector<int> a {1,1,2,2,2,3,5};
    vector<int> b {1,1,1,2,2,4,5};
    vector<int> c;

    int m=0;
    int n=0;
    while((m<a.size())&&(n<b.size()))
    {
        if(a[m]==b[n])
        {
            c.push_back(a[m]);
            m++;
            n++;
        }
        else if(a[m]>b[n])
        {
            n++;
        }
        else
        {
            m++;
        }   
    }    

    for(int i = 0; i < c.size(); i++) {
        cout<<c[i]<<" ";
    }
    return 0;
}