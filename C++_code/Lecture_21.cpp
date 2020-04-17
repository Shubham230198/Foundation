                                                    //Lecture-21
                                                    //july-17

                                                    //GRAPH IS STARTED.

#include<iostream>
#include<vector>
#include<string>
using namespace std;
                                //GRAPH STARTING


class Edge                                   //GRAPH INTRODUCTION
{                                               //HERE, we are just going to create
    public:                                     //a graph data by using class and 
        int nebr;                               //a vector of vector of class.
        int wt; 
};
vector<vector<Edge>> graph;



void addEdge(int v1,int v2, int wt)                    //it will add the edge in the graph 
{                                                      //data
    Edge e1;
    e1.nebr=v2;
    e1.wt=wt;
    graph[v1].push_back(e1);

    Edge e2;
    e2.nebr=v1;
    e2.wt=wt;
    graph[v2].push_back(e2);    
}


void display()                                          //it will display all the graph data
{
    for(int i=0;i<graph.size();i++)
    {
        cout<<i<<" ->";
        for(int j=0;j<graph[i].size();j++)
        {
            Edge n=graph[i][j];
            cout<<"["<<n.nebr<<"-"<<n.wt<<"]";
        }
        cout<<endl;
    }
}


bool haspath(int s,int d,vector<bool> & visited)                    //HAS PATH FROM ONE EDGE 
{                                                                   //TO ANOTHER VERTEX.
    if(s==d)
    {
        return true;
    }

    visited[s]=true;
    for(int i=0;i<graph[s].size();i++)
    {
        Edge ne=graph[s][i];
        if(visited[ne.nebr]==false)
        {
            bool path_nebr_to_desti=haspath(ne.nebr,d,visited);
            if(path_nebr_to_desti==true)
            {
                return true;
            }
        }
    }
    return false;
}




void allPath(int s,int d,vector<bool> &visited,string ans,int weight)          //TO print all posible paths 
{                                                                              //from one vertex to another.
    if(s==d)                                                                   //(not efficient method as new
    {                                                                           //string is created with every call).
        cout<<ans<<d<<" @@@ "<<weight<<endl;
        return;
    }
    visited[s]=true;
    for(int i=0;i<graph[s].size();i++)
    {
        Edge ne=graph[s][i];
        if(visited[ne.nebr]==false)
        {   
            weight+=ne.wt;
            allPath(ne.nebr,d,visited,ans+to_string(s)+"->",weight);
            weight-=ne.wt;
        }
    }
    visited[s]=false;
}                                                                       //REVIWED.




void allPath2(int s,int d,vector<bool> &visited,string ans,int weight)          //TO print all posible paths 
{                                                                              //from one vertex to another.
    if(s==d)                                                                   //(Efficient method)
    {
        cout<<ans<<d<<" @@@ "<<weight<<endl;
        return;
    }
    visited[s]=true;
    for(int i=0;i<graph[s].size();i++)
    {
        Edge ne=graph[s][i];
        if(visited[ne.nebr]==false)
        {   
            ans+=to_string(s);
            allPath(ne.nebr,d,visited,ans,weight+ne.wt);
            ans.erase(ans.length()-1,1);
        }
    }
    visited[s]=false;
}                                                                             //REVIWED.



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


    //display();                                      //to display graph data.


    //cout<<haspath(3,4,visited);                     //to show if path posibble between two vertex.

    
    //allPath(0,6,visited,"",0);                          //to print all posibble paths along with there total weight.

    
    //string s;                                             //to print all posibble paths along wiht there total weight.
    //allPath2(0,6,visited,s,0);


    return 0;
}                                              //REVIEWED.