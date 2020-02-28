#include<iostream>
#include<vector>
#include<string>
#include<climits>

using namespace std;
                                //GRAPH STARTING


/*class Edge                                   //GRAPH INTRODUCTION
{                                               //HERE, we are just going to create
    public:                                     //a graph data by using class and 
        int nebr;                               //a vector of vector of class.
        int wt; 
};

vector<vector<Edge>> graph;                      //DATA TYPE TO REPRESENT GRAPH.



void addEdge(int v1,int v2, int wt)                    //it will add the edge in the graph data
{                                                    
    Edge e1;
    e1.nebr=v2;
    e1.wt=wt;
    graph[v1].push_back(e1);

    Edge e2;
    e2.nebr=v1;
    e2.wt=wt;
    graph[v2].push_back(e2);    
}


int sd=INT_MAX;                      //Assigning maximun val(plus infinity)
int ld=INT_MIN;                      //Assigning minimum val(minus infinity)

string sdPath="";
string ldPath="";

int fd=INT_MIN;                    //QUALIFIED MAX(minus infinity)
int cd=INT_MAX;                    //QUALIFIED MIN(plus infinity)

string fdPath="";
string cdPath="";

void allPath(int s,int d,vector<bool> &visited,string ans,int weight,int factor)                //TO print all posible paths with weights, 
{                                                                                               //from a given vertex to another
    if(s==d)                                                                                    //given vertex
    {   
        if(weight<sd)               //for shortest path.
        {
            sd=weight;
            sdPath=ans;
        }

        if(weight>ld)               //for largest path
        {
            ld=weight;
            ldPath=ans;
        }

        if(weight<factor)
        {
            fd=weight;
            fdPath=ans;
        }

        if(weight>factor && weight<cd)
        {
            cd=weight;
            cdPath=ans;
        }
        return;
    }

    visited[s]=true;
    for(int i=0;i<graph[s].size();i++)
    {
        Edge ne=graph[s][i];
        if(visited[ne.nebr]==false)
        {   
            weight+=ne.wt;
            allPath(ne.nebr,d,visited,ans+to_string(s)+"->",weight,factor);
            weight-=ne.wt;
        }
    }
    visited[s]=false;
}




void hamil(int src,vector<bool> &visited,string ans,int vsf,int original_src)        //HAMILTON PATHS AND CYCLES.
{
    if(vsf==graph.size()-1)
    {   
        ans=ans+to_string(src);
        cout<<ans<<" ";

        for(int n=0; n<graph[src].size();n++)
        {
            Edge ne=graph[src][n];
            if(ne.nebr==original_src)
                cout<<"*";

        }

        cout<<endl;
    }

    visited[src]=true;
    for(int j=0;j<graph[src].size();j++)
    {
        Edge ne=graph[src][j];
        if(visited[ne.nebr]==false)
        {
            hamil(ne.nebr,visited,ans+ to_string(src),vsf+1,original_src);
        }
    }
    visited[src]=false;
}

vector<bool> visited (7,false);

int main()
{
    graph.push_back(vector<Edge>()); //0
    graph.push_back(vector<Edge>()); //1
    graph.push_back(vector<Edge>()); //2
    graph.push_back(vector<Edge>()); //3
    graph.push_back(vector<Edge>()); //4
    graph.push_back(vector<Edge>()); //5
    graph.push_back(vector<Edge>()); //6

    addEdge(0,1,10);
    addEdge(1,2,10);
    addEdge(2,3,10);
    addEdge(0,3,40);
    addEdge(3,4,2);
    addEdge(4,5,3);
    addEdge(5,6,3);
    addEdge(4,6,8);

   
    //allPath(0,6,visited,"",0,45);                          //to go through all posibble paths along with there total weight.
    
    //cout<<"shortest path "<<sdPath<<" @"<<sd<<endl;        //to get shortest weighted path
    //cout<<"largest path "<<ldPath<<" @"<<ld<<endl;         //to get largest weighted path
    //cout<<"floor path "<<fdPath<<" @"<<fd<<endl;           //to get floor weighted path, wrt a factor.
    //cout<<"ceil path "<<cdPath<<" @"<<cd<<endl;            //to get ceil weighted path, wrt a factor.
    
    hamil(0,visited,"",0,0);                                 //to print all possible hamilton paths from 
                                                             //from a source,and also if they are
                                                             //cycles too.
    return 0;
}*/                                              //REVIEWED.






