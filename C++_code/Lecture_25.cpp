#include<iostream>
#include<string>
#include<vector>
#include<queue>
#include<stack>
using namespace std;

class Edge                                   
{                                               //HERE, we are just going to create
    public:                                     //a graph data by using class and 
        int nebr;                               //a vector of vector of class.
        int wt; 
};

vector<vector<Edge>> graph;                      //DATA TYPE TO REPRESENT GRAPH.

/*void addEdge(int v1,int v2, int wt)                    //it will add the edge in the graph data
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

void addEdge(vector<vector<Edge>>& mst,int v,int av,int c)            //PRIMS ALGORITHM.
{
    Edge e1;
    e1.nebr=av;
    e1.wt=c;
    mst[v].push_back(e1);
    
    Edge e2;
    e2.nebr=v;
    e2.wt=c;
    mst[av].push_back(e2);
}

class pPair
{
    public:
    int vertex;
    int aVertex;
    int cost;

    pPair(int v,int av,int c)
    {
        this->vertex=v;
        this->aVertex=av;
        this->cost=c;
    }

    pPair()
    {
        this->vertex=0;
        this->aVertex=0;
        this->cost=0;
    }

    bool operator>(const pPair& other) const
    {
        return this->cost > other.cost;
    }

};

void display(vector<vector<Edge>> mst)            //to display a specific graph.                                          //it will display all the graph data
{
    for(int i=0;i<mst.size();i++)
    {
        cout<<i<<" ->";
        for(int j=0;j<mst[i].size();j++)
        {
            Edge n=mst[i][j];
            cout<<"["<<n.nebr<<"-"<<n.wt<<"]";
        }
        cout<<endl;
    }
}


void prims()                                      //prims algorithm.(to find 
{                                                 //minimum spanning tree)
    vector<bool> visited (graph.size(), false);
    vector<vector<Edge>> mst (graph.size(),vector<Edge>());
    pPair pp;
    pp.vertex=0;
    pp.aVertex=-1;
    pp.cost=0;

    priority_queue<pPair, vector<pPair>, greater<pPair>> q;
    q.push(pp);

    while(q.size()>0)
    {
        pPair rem=q.top();
        q.pop();

        if(visited[rem.vertex]==true)
        {
            continue;
        }
        visited[rem.vertex]=true;

        if(rem.aVertex!=-1)
            addEdge(mst,rem.vertex,rem.aVertex,rem.cost);

        for(int i=0;i<graph[rem.vertex].size();i++)
        {
            Edge n=graph[rem.vertex][i];
            if(visited[n.nebr]==false)
            {
                pPair p(n.nebr,rem.vertex,n.wt);
                q.push(p);
            }
        }
    }

    display(mst);
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

    addEdge(0,1,20);
    addEdge(1,2,10);
    addEdge(2,3,20);
    addEdge(0,3,40);
    addEdge(3,4,2);
    addEdge(4,5,3);
    addEdge(5,6,3);
    addEdge(4,6,8);

    prims();
}*/                                         //REVIEWED.





                             //TOLOGICAL
vector<vector<Edge>> topoGraph;                     //graph for topological sort.

void addEdge(vector<vector<Edge>>& topoGraph,int s,int r,int c)        //to add edges in directed graph. 
{
    Edge e1;
    e1.nebr=r;
    e1.wt=c;
    topoGraph[s].push_back(e1);
}

void topologicalCompo(int i,vector<bool> &visited,stack<int> &s)       //to get topological 
{                                                                      //sort of graph components.
    for(int j=0;j<topoGraph[i].size();j++)
    {
        Edge n=topoGraph[i][j];
        if(visited[n.nebr]==false)
        {   
            visited[n.nebr]=true;
            topologicalCompo(n.nebr,visited,s);
        }
    }
    s.push(i);
    
}

void topological()                               //to get topological sort of vertices
{                                                //of graph topoGraph
    stack<int> s;
    vector<bool> visited (topoGraph.size(),false);
    for(int i=0;i<topoGraph.size();i++)
    {
        if(visited[i]==false)
        {
            topologicalCompo(i,visited,s);
        }
    }

    while(s.size()!=0)
    {
        cout<<s.top()<<endl;
        s.pop();
    }

}


int main()
{
    topoGraph.push_back(vector<Edge>());   //0
    topoGraph.push_back(vector<Edge>());   //1
    topoGraph.push_back(vector<Edge>());   //2
    topoGraph.push_back(vector<Edge>());   //3
    topoGraph.push_back(vector<Edge>());   //4
    topoGraph.push_back(vector<Edge>());   //5
    topoGraph.push_back(vector<Edge>());   //6
    
    addEdge(topoGraph,0,1,1);
    addEdge(topoGraph,1,2,1);
    addEdge(topoGraph,2,3,1);
    addEdge(topoGraph,0,4,1);
    addEdge(topoGraph,5,4,1);
    addEdge(topoGraph,4,3,1);
    addEdge(topoGraph,5,6,1);
    addEdge(topoGraph,6,3,1);

    topological();

    return 0;
} 