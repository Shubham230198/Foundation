#include<iostream>
#include<string>
using namespace std;

void queens(bool * arr , int n, int queen, string ans)
{   
    if(queen==0)
    {
        cout<<ans<<endl;
        return;
    }

    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(*arr[i][j]==false)
            {
                for(int k=0;k<n;k++)
                {
                    arr[i][k]=true;
                }

                for(int l=0;l<n;l++)
                {
                    arr[l][j]=true;
                }

                int m=i;
                int o=j;
                while(m!=n && o!=n)
                {
                    arr[m][o]==true;
                    m++;
                    o++;
                }
                m=i;
                o=j;
                while(m!=-1 && o!=-1)
                {
                    arr[m][o]==true;
                    m--;
                    o++;
                }

                queens(arr,n,queen-1,ans+to_string(i)+to_string(j)+" ");


            }
        }
    }
}

int main()
{
    int n=4;
    //cin>>n;
    bool arr[n][n]{false};
    
    queens(& arr,n,n,"");


    return 0;
}