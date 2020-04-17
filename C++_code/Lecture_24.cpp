                                            //LECTURE-24
                                            //JULY-20

#include<iostream>
#include<vector>
#include<string>
#include<queue>
using namespace std;

// PRE-REQUIST for graph

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

//REVIEWED.






//1.IS_CONNECTED.                   (to check if the graph is connected)

string gscc(int s, vector<bool>& visited) {              //helping gscc function.
    string str = "";
    queue<int> que;
    que.push(s);

    while(que.size() != 0) {
        int rem = que.front();       //GET
        que.pop();                   //REMOVE

        visited[rem] = true;        //MARK

        str += rem;                 //work

        for(int i = 0; i < graph[rem].size(); i++) {        //add nebr.
            Edge e = graph[rem][i];
            if(visited[e.nebr] == false) {
                que.push(e.nebr);
            }
        }
    }
    
    return str;
}


bool isConnected(vector<bool>& visited) {
    string component1 = gscc(0, visited);                  //calling the component, containing the 0th vertex.

    for(int i = 1; i < graph.size(); i++) {
        if(visited[i] == false)                           //after 1 conponent, if anyone is left unvisited, 
            return false;                                  //graph is not connected.
    }

    return true;
} 

//REVIEWED.








//2. IS_CYCLIC , (to check if a graph contains a cycle)

bool isComponentCyclic(int p,vector<bool> &visited)           //TO CHECK IF GRAPH'S component IS CYCLIC.
{
    queue<int> q;                       //here, we did't used proactive method,(as that won't work here)
    q.push(p);                          //so queue will have duplicate.

    while(q.size()>0)
    {
        int rem = q.front();                    //GET
        q.pop();                                //REMOVE

        if(visited[rem]==true)                  //WORK (if any item of que, is already visited
        {                                       //this indicates a cycle)
            return true;
        }

        visited[rem]=true;                      //MARK

        for(int i=0;i<graph[rem].size();i++)    //ADD NEBR
        {
            Edge n=graph[rem][i];
            if(visited[n.nebr]==false)
            {
                q.push(n.nebr);
            }
        }
    }

    return false;
}



bool isCyclic(vector<bool>& visited)                                   //to check if graph is cyclic.
{   
    for(int i=0;i<graph.size();i++)                      
    {
        if(visited[i]==false)
        {
            bool flag=isComponentCyclic(i,visited);
            if(flag==true)
            {
                return true;
            }
        }
    }

    return false;
}                                                  //REVIEWED.








//3. IS_BIPARTITE         (to check if a graph bigraph)

class BiPolar                                       //TO CHECK IF GRAPH'S COMPONENT IS BIPARTITE.
{
    public:
        int vertex;
        int level;
};


bool isComponentBiPartite(int p,vector<int> &visited)      //to check over a specific component
{   
    BiPolar bp;
    bp.vertex=p;
    bp.level=1;                                            //starting the level from 1.

    queue<BiPolar> q;
    q.push(bp);

    while(q.size()>0)                               //this should be done pro-actively.
    {
        BiPolar rem=q.front();          //GET
        q.pop();                        //REMOVE

        if(visited[rem.vertex]!=0)          //WORK
        {   
            int oldLevel=visited[rem.vertex];
            int newLevel=rem.level;

            if(oldLevel%2 != newLevel%2)
                return false;
        }

        visited[rem.vertex]=rem.level;          //MARK

        for(int i=0;i<graph[rem.vertex].size();i++)        //ADD NEBR
        {   
                Edge n=graph[rem.vertex][i];

                if(visited[n.nebr]==false)
                {   
                    BiPolar np;
                    np.vertex=n.nebr;
                    np.level=rem.level+1;
                    q.push(np);
                }
        }

    }
    return true;
}


bool isBiPartite()                                      //to check if graph is bipartite.
{
    vector<int> visited (graph.size(),0);

    for(int i=0;i<graph.size();i++)
    {
        if(visited[i]==0)
        {
            bool isBi=isComponentBiPartite(i,visited);
            if(isBi==false)
            {
                return false;
            }
        }
    }
    return true; 
}

//REVIEWED.





// class bPair
// {
//     public:
//         int vertex;
//         int cost;
//         string path;

//         bPair(int v,int c,string p)
//         {
//             this->vertex=v;
//             this->cost=c;
//             this->path=p;
//         }

//         bool operator<(const bPair& other) const
//         {
//             return this->cost<other.cost;
//         }

//         bool operator>(const bPair& other) const
//         {
//             return this->cost>other.cost;
//         }
// };


// void dikshtra(int src)
// {   
//     vector<bool> visited (graph.size(),false);
//     bPair bp(src,0,to_string(src));

//     priority_queue<bPair, vector<bPair>, greater<bPair>> q;
//     q.push(bp);

//     while(q.size()>0)
//     {
//         bPair rem=q.top();
//         q.pop();

//         if(visited[rem.vertex]==true)
//         {
//             continue;
//         }
//         visited[rem.vertex]=true;
        
//         cout<<rem.vertex<<"@"<<rem.cost<<", "<<rem.path<<endl;

//         for(int i=0;i<graph[rem.vertex].size();i++)
//         {
//             Edge n=graph[rem.vertex][i];
//             if(visited[n.nebr]==false)
//             {
//                 bPair bp(n.nebr,rem.cost+n.wt,rem.path+to_string(n.nebr));
//                 q.push(bp);
//             }
//         }
//     }

// }








int main()
{
    //PRE_REQUIST for graph

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
    // addEdge(4,6,8);

    vector<bool> visited (graph.size(), false);

    //reviewed.
    


    


    //1. IS_CONNECTED                                       (using gscc as helping function)
    
    /*
    cout<<"the graph is connected = "<<isConnected(visited);
    */

    //reviewed.




    
    //2. IS_CYCLIC, (to check if a graph contains a cycle)
                    //(implements BSF, but can't use its pro-active method).    
    /*   
    cout<<"this graph contains cycle = "<<isCyclic(visited); 
    */

    //reviewed.



    //3. IS_BIPARTITE     (to check if graph is bigraph, without being pro-active)

    cout<<"this graph is bi-graph = "<<isBiPartite();     //this could be done proactively.

    //reviewed.




    // dikshtra(0);
    return 0;
}