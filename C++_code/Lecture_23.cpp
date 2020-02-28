#include<iostream>
#include<vector>
#include<string>
#include<queue>

using namespace std;

class Edge                                   
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


/*vector<bool> visited (graph.size(),false);
bool BSF_traversal(int src,int des)
{
    queue<int> q;
    q.push(src);
    while(q.size()>0)
    {
        int rem=q.front();
        q.pop();
        visited[rem]=true;

        if(rem==des)
            return true;

        for(int i=0;i<graph[rem].size();i++)
        {
            Edge n=graph[rem][i];
            if(visited[n.nebr]==false)
                q.push(n.nebr);
        }
    }

    return false;

}*/





/*vector<string> gcc()
{
    vector<string> comps;
    vector<bool> visited(graph.size(),false);

    for(int i=0;i<graph.size();i++)
    {
        if(visited[i]==false)
        {
            string comp=gscc(i,visited);
            comps.push_back(comp);
        }

    }

    return comps;
}

string gscc(int i,vector<bool> &visited)
{   
    string res="";
    queue<int> q;
    q.push(i);

    while(q.size()>0)
    {
        int rem=q.front();
        q.pop();

        if(visited[rem]==true)
        {    
            continue;
        }

        visited[rem]=true;
        res+=to_string(rem);

        for(int j=0;j<graph[rem].size();j++)
        {
            Edge n=graph[rem][j];
            
            if(visited[n.nebr]==false)
                q.push(n.nebr);
        }
    }

    return res;
}

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

    //cout<<BSF_traversal(0,6);
    

    vector<string> comps=gcc();
    for(int i=0;i<comps.size();i++)
    {
        cout<<comps[i]<<endl;
    }
}*/                                           //REVIEWED.





/*string gscc(int i,vector<bool> &visited)
{   
    string res="";
    queue<int> q;
    q.push(i);

    while(q.size()>0)
    {
        int rem=q.front();
        q.pop();

        if(visited[rem]==true)
        {    
            continue;
        }

        visited[rem]=true;
        res+=to_string(rem);

        for(int j=0;j<graph[rem].size();j++)
        {
            Edge n=graph[rem][j];
            
            if(visited[n.nebr]==false)
                q.push(n.nebr);
        }
    }

    return res;
}


vector<string> gcc()
{
    vector<string> comps;
    vector<bool> visited(graph.size(),false);

    for(int i=0;i<graph.size();i++)
    {
        if(visited[i]==false)
        {
            string comp=gscc(i,visited);
            comps.push_back(comp);
        }

    }

    return comps;
}


int main()
{   
    int n=10;
    vector<int> v1 {2,3,8,1,6,4};
    vector<int> v2 {9,8,7,7,5,2};

    for(int i=0;i<n;i++)
    {   
        graph.push_back(vector<Edge>());
    }

    for(int e=0;e<v1.size();e++)
    {
        addEdge(v1[e],v2[e],1);
    }

    vector<string> nations=gcc();
    int teams=0;

    for(int i=0;i<nations.size();i++)
    {
        for(int j=i+1;j<nations.size();j++)
        {
            teams+=nations[i].size()*nations[j].size();
        }
    }

    cout<<teams<<endl;

    return 0;
}*/