                                        //Lecture-26
                                        //july-22

#include<iostream>
#include<string>
#include<vector>
#include<queue>
using namespace std;


// PRE-REQUIST for graph

class Edge                                   
{                                               //HERE, we are just going to create
    public:                                     //a graph data by using class and 
        int nebr;                               //a vector of vector of class.
        int wt; 
};



void addEdge(vector<vector<Edge>>& graph, int v1,int v2, int wt)                    //it will add the edge in the graph data
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






//1. Kruskal's Algorihtm          (to find mst of a graph)

class Kedge {
    public:
        int v1 = -1;
        int v2 = -1;
        int wt = -1;

        Kedge(int v1, int v2, int wt) {
            this->v1 = v1;
            this->v2 = v2;
            this->wt = wt;
        }

        bool operator>(const Kedge& other) const {     //operator overloading for PQ, (for
            return this->wt > other.wt;                //a min PQ, > operator should be overloaded
        }                                              //and wise versa.
};



void display(vector<vector<Edge>>& G) {
    for(int i = 0; i < G.size(); i++) {
        cout<<i<<" -> ";
        for(int j = 0; j < G[i].size(); j++) {
            cout<<"["<<G[i][j].nebr<<", "<<G[i][j].wt<<"] ";
        }
        cout<<"\n";
    }
}



void merge(int parent[], int rank[], int v1sl, int v2sl) {     //function to merge of two sets.
                                                               
    if(rank[v1sl] < rank[v2sl]) {          //set leader of grater rank is made
        parent[v1sl] = v2sl;               //parent of other.
    }
    else if(rank[v2sl] < rank[v1sl]) {
        parent[v2sl] = v1sl;
    }
    else {                          //if rank of both set leaders are same,
        parent[v1sl] = v2sl;        //anyone can be act as leader of other,
        rank[v2sl]++;                     //but the rank of parent will increase by 1.
    }
}



int find(int parent[], int v1) {            //function to find the set leader(sl)
    if(parent[v1] == v1){
        return v1;
    }
    else {
        return find(parent, parent[v1]);
    }
}



void kruskal(vector<vector<Edge>>& graph) {
    vector<vector<Edge>> mst;
    int rank[graph.size()];
    int parent[graph.size()];

    for(int i = 0; i < graph.size(); i++) {
        mst.push_back(vector<Edge>());
        rank[i] = 1;
        parent[i] = i;
    }

    priority_queue<Kedge, vector<Kedge>, greater<Kedge>> pq;        //creating a min PQ.(by default PQ in cpp is max type)
    for(int i = 0; i < graph.size(); i++) {
        for(int j = 0; j < graph[i].size(); j++) {
            Edge e = graph[i][j];
            if(i < e.nebr) {                    //to prevent duplication of edges in PQ.
                Kedge kp(i, e.nebr, e.wt);
                pq.push(kp);
            }
        }
    }

    while(pq.size() > 0) {
        Kedge kp = pq.top();             
        pq.pop();

        int v1sl = find(parent, kp.v1);
        int v2sl = find(parent, kp.v2);
        if(v1sl != v2sl) {
            addEdge(mst, kp.v1, kp.v2, kp.wt);
            merge(parent, rank, v1sl, v2sl);
        }
    }

    display(mst);
}

//REVIEWED.









int main()
{
    //Pre-requist for graph creation.

    vector<vector<Edge>> graph;                      
    for(int i = 0; i < 7; i++) {
        graph.push_back(vector<Edge>());
    }

    addEdge(graph, 0, 3, 40);
    addEdge(graph, 0, 1, 20);
    addEdge(graph, 1, 2, 10);
    addEdge(graph, 2, 3, 20);
    addEdge(graph, 3, 4, 2);
    addEdge(graph, 4, 5, 3);
    addEdge(graph, 4, 6, 8);
    addEdge(graph, 5, 6, 3);

    //reviewed.






    //1.Kruskal_algo      (to find mst of given graph)
    
    /*
    kruskal(graph);
    */

   //reviewed.



}
