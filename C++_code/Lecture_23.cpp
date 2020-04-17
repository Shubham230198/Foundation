                                            //LECTURE-23
                                            //july-19

#include<iostream>
#include<vector>
#include<string>
#include<queue>
using namespace std;


//PRE- requist for graph

class Edge                                   
{                                               
    public:                                     
        int nebr;                               
        int wt; 
};

vector<vector<Edge>> graph;             //DATA TYPE TO REPRESENT GRAPH.

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

void display() {
    for(int i = 0; i < graph.size(); i++) {
        cout<<i<<" -> ";
        for(int j = 0; j < graph[i].size(); j++) {
            cout<<"[ "<<graph[i][j].nebr<<", "<<graph[i][j].wt<<"] ";
        }
        cout<<"\n";
    }
}

//REVIEWED.





//1. BFS traversal, over the graph.

vector<bool> visited (7, false);               //we have to give const. size to visited vector, as
bool BSF_traversal(int src,int des)            //if we use graph.size(), it may not have initialize it's size.
{
    queue<int> q;
    q.push(src);
    while(q.size()>0)
    {
        int rem=q.front();          //GET
        
        q.pop();                    //REMOVE
        
        visited[rem]=true;          //MARK

        if(rem==des)                //WORK
            return true;

        for(int i=0;i<graph[rem].size();i++)     //ADD NEIGHBOUR.
        {
            Edge n=graph[rem][i];                  //here, some of vertices will be added multiple times.
            if(visited[n.nebr]==false)
                q.push(n.nebr);
        }
    }

    return false;
}

//REVIEWED.







//2. Get-Connected-Components.     (for a graph), (gscc is a helping function)

string gscc(int i,vector<bool> &visited)        //Get-selected-connnected-conponents.
{   
    string res="";
    queue<int> q;
    visited[i] = true;
    q.push(i);

    while(q.size()>0)
    {
        int rem=q.front();       //get
        q.pop();                 //remove
                                 //No need to mark, as we have done marking pro-actively.

        res+=to_string(rem);     //work

        for(int j=0;j<graph[rem].size();j++)      //add nebr
        {
            Edge n=graph[rem][j];
            if(visited[n.nebr]==false) {
                visited[n.nebr] = true;
                q.push(n.nebr);
            }
        }
    }
    return res;
}



vector<string> gcc()            //actual function to get connected components.
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

//REVIEWED.







//3. FIRE_STROM_PROBLEM        (implementation of bfs) 

class point {
    public:
        int x = -1;
        int y = -1;
        int t = -1;

        point(int x, int y, int t) {
            this -> x = x;
            this -> y = y;
            this -> t = t;
        }
};


void fireStrom(int board[][5], int rSize, int cSize) {
    queue<point> que;                                   //here, que will have multiple dupliacte
    for(int i = 0; i < rSize; i++) {                    //items, as we did'nt mark and check pro-actively.
        for(int j = 0; j < cSize; j++) {
            if(board[i][j] == 2) {
                point p1(i, j, 0);
                que.push(p1);
            }
        }
    }    

    int totalTime = -1;          //variable to get total time for buring max.

    while(que.size() != 0) {
        point p = que.front();                 //GET
        que.pop();                             //REMOVE

        board[p.x][p.y] = 2;                    //MARK

        totalTime = p.t;                       //work 

        if(p.x - 1 >= 0 && board[p.x - 1][p.y] == 1) {              //add nebrs
            point temp(p.x - 1, p.y, p.t + 1);
            que.push(temp);
        }
        if(p.y + 1 < cSize && board[p.x ][p.y + 1] == 1) {
            point temp(p.x, p.y + 1, p.t + 1);
            que.push(temp);
        }
        if(p.x + 1 < rSize && board[p.x + 1][p.y] == 1) {
            point temp(p.x + 1, p.y, p.t + 1);
            que.push(temp);
        }
        if(p.y - 1 >= 0 && board[p.x][p.y - 1] == 1) {
            point temp(p.x, p.y - 1, p.t + 1);
            que.push(temp);
        }

    }

    cout<<"Time requried for max burning = "<<totalTime<<"\n";

    for(int i = 0; i < rSize; i++) {             //printing the last condition of board.
        for(int j = 0; j < cSize; j++) {
            cout<<board[i][j]<<" ";
        }
        cout<<"\n";
    }
}

//REVIEWED.






int main()
{
    //pre-requist for graph

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
    // addEdge(2,5,5);
    addEdge(4,5,3);
    addEdge(5,6,3);
    addEdge(4,6,8);

    // display();
    
    //reviewed.



    //1. BFS searching.
    
    /*
    cout<<BSF_traversal(0,6)<<"\n";
    */

   //reviewed.
    



    //2. GET_CONNECTED_COMPONENTS of a graph. 
    
    /*vector<string> comps = gcc();
    for(int i=0;i<comps.size();i++)
    {
        cout<<comps[i]<<endl;
    }
    */

    //reviewed.



    
    //3. FIRE_STROM_PROBLEM               (implementation of bfs) 
    
    /*
    int board[][5] = {
        {2,1,0,2,1},
        {1,0,1,2,1},
        {1,0,0,2,1}
    };
    fireStrom(board, 3, 5);
    */

    //reviewed.




}
