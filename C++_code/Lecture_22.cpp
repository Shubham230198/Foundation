                                            //Lecture-22
                                            //July-18

#include<iostream>
#include<vector>
#include<string>
#include<climits>
#include<queue>
using namespace std;

//PRE-reqist for the dealing with graph.

class Edge                                   
{                                               
    public:                                     
        int nebr;                              
        int wt; 

        Edge() {

        }

        Edge(int n, int w) {
            this -> nebr = n;
            this -> wt = w;
        }
};
vector<vector<Edge>> graph;                      


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
            cout<<"[ "<<graph[i][j].nebr<<", "<<graph[i][j].wt<<"], ";
        }
        cout<<"\n";
    }
}

//REVIEWED




//1. To get maxCost path, minCost path, ceilCost path, floorCost path.

int sd=INT_MAX;                      //Assigning maximun val(plus infinity)
int ld=INT_MIN;                      //Assigning minimum val(minus infinity)

string sdPath="";
string ldPath="";

int fd=INT_MIN;                    //QUALIFIED MAX(minus infinity)
int cd=INT_MAX;                    //QUALIFIED MIN(plus infinity)

string fdPath="";
string cdPath="";

void allPath(int s,int d,vector<bool> &visited,string ans,int weight,int factor)                //TO get smallest, largest, ceil and floor path, 
{                                                                                               
    if(s==d)                                                                                    
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

        if(weight<factor)            //for floor path
        {
            fd=weight;
            fdPath=ans;
        }

        if(weight>factor && weight<cd)        //for ceil path
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

//REVIWED.




//2. hamiltonian path (and specifing if any one is hamiltonian cycle too)

void hamil(int src,vector<bool> &visited,string ans,int vsf,int original_src)        //HAMILTON PATHS AND CYCLES.
{
    if(vsf==graph.size()-1)
    {   
        ans=ans+to_string(src);
        cout<<ans<<" ";

        for(int n=0; n<graph[src].size();n++)         //checking current hamiltonian path for hamil cycle;
        {
            Edge ne=graph[src][n];
            if(ne.nebr==original_src)
                cout<<"Cycle too";
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

//reviewed.




//3. KNIGHT PROBLEM to cover whole chess board, from given position (r,c)

int counter = 0;
void knightProblem(int board[][5], int rSize, int cSize, int r, int c, int move) {
    board[r][c] = move;
    if(move == rSize * cSize) {
        cout<<"**********"<<++counter<<"**********\n";
        for(int i = 0; i < rSize; i++) {
            for(int j = 0; j < cSize; j++) {
                cout<<board[i][j]<<"\t";
            }
            cout<<endl;
        }
        cout<<"**********"<<counter<<"**********\n";
        board[r][c] = 0;
        return;
    }

    if(r - 2 >= 0 && c - 1 >= 0 && board[r - 2][c - 1] == 0) {
        knightProblem(board, rSize, cSize, r - 2, c - 1, move + 1); 
    }
    if(r - 2 >= 0 && c + 1 < cSize && board[r - 2][c + 1] == 0) {
        knightProblem(board, rSize, cSize, r - 2, c + 1, move + 1); 
    }
    if(r + 1 < rSize && c + 2 < cSize && board[r + 1][c + 2] == 0) {
        knightProblem(board, rSize, cSize, r + 1, c + 2, move + 1); 
    }
    if(r - 1 >= 0 && c + 2 < cSize && board[r - 1][c + 2] == 0) {
        knightProblem(board, rSize, cSize, r - 1, c + 2, move + 1); 
    }
    if(r + 2 < rSize && c + 1 < cSize && board[r + 2][c + 1] == 0)  {
        knightProblem(board, rSize, cSize, r + 2, c + 1, move + 1); 
    }
    if(r + 2 < rSize && c - 1 >= 0 && board[r + 2][c - 1] == 0) {
        knightProblem(board, rSize, cSize, r + 2, c - 1, move + 1); 
    }
    if(r + 1 < rSize && c - 2 >= 0 && board[r + 1][c - 2] == 0) {
        knightProblem(board, rSize, cSize, r + 1, c - 2, move + 1); 
    }
    if(r - 1 >= 0 && c - 2 >= 0 && board[r - 1][c - 2] == 0) {
        knightProblem(board, rSize, cSize, r - 1, c - 2, move + 1);  
    }

    board[r][c] = 0;
} 

//REVIEWED.






//4. Astronaut-Tour-Problem                (implementation of bfs)

vector<vector<Edge>> astroGraph;

void addEdgeAstro(int u, int v, int w) {
    Edge n1(v, w);
    astroGraph[u].push_back(n1);

    Edge n2(u, w);
    astroGraph[v].push_back(n2);
} 


string gscc(int i,vector<bool> &visited)      //helping function(to get selected
{                                             //conected components)/
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

        for(int j=0;j<astroGraph[rem].size();j++)
        {
            Edge n=astroGraph[rem][j];
            
            if(visited[n.nebr]==false)
                q.push(n.nebr);
        }
    }

    return res;
}


vector<string> gcc()          //main function.
{
    vector<string> comps;
    vector<bool> visited(astroGraph.size(),false);

    for(int i=1;i<astroGraph.size();i++)       //index i is started from 1, as 0 is dummy player.
    {
        if(visited[i]==false)
        {
            string comp=gscc(i,visited);
            comps.push_back(comp);
        }

    }

    return comps;
}


void astroTour(int n, vector<int> &v1, vector<int> &v2) {
    for(int i=0;i<=n;i++) {                  //0th index extra, as persons counting start's from 1.
        astroGraph.push_back(vector<Edge>());
    }

    for(int e=0;e<v1.size();e++)
    {
        addEdgeAstro(v1[e],v2[e],1);
    }

    vector<string> nations=gcc();     //nation vector contains strings of nation members.
    int teams=0;

    for(string x : nations) {           //printinf those nation members.
        cout<<x<<" ";
    }
    cout<<"\n";

    for(int i=0;i<nations.size();i++)
    {
        for(int j=i+1;j<nations.size();j++)
        {
            teams+=nations[i].size()*nations[j].size();
        }
    }

    cout<<"total possible ways - "<<teams<<endl;

}

//REVIEWED.




vector<bool> visited (7,false);
int main()
{   
    //pre-requist for graph.
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
    // addEdge(2,5,5);                //for new edge between 2 and 5, with wt = 5.
    addEdge(3,4,2);
    addEdge(4,5,3);
    addEdge(5,6,3);
    addEdge(4,6,8);

    //reviewed.

   
   //1. to get ceilpath, floorPath, maxCost path, minCost path.

    /*allPath(0,6,visited,"",0,45);                          //to go through all posibble paths along with there total weight.
    
    cout<<"shortest path "<<sdPath<<" @"<<sd<<endl;        //to get shortest weighted path
    cout<<"largest path "<<ldPath<<" @"<<ld<<endl;         //to get largest weighted path
    cout<<"floor path "<<fdPath<<" @"<<fd<<endl;           //to get floor weighted path, wrt a factor.
    cout<<"ceil path "<<cdPath<<" @"<<cd<<endl;            //to get ceil weighted path, wrt a factor.
    */

    //reviewed.



    //2. hamiltonian path (cycles too)
    /*hamil(0,visited,"",0,0);                                 //to print all possible hamilton paths from 
    */                                                       //from a source,and also if they are
                                                             //cycles too.
    //reviewed.
    
    

    //3. Knight problem,(to visit all the chessboard)
    
    /*int n = 5;
    int board[5][5];
    for(int i = 0; i < n; i++) {
        fill_n(board[i], n, 0);
    }

    int rSize = n;
    int cSize = n;
    int move = 1;
    int r = 1;          //staring position row.
    int c = 3;          //starting position col.
    knightProblem(board, rSize, cSize, r, c, move);
    */

    //reviewed.




    //4. Astronaut-problem (to get connected components of a graph)
                        //(need it's own graph)
    
    /*int n=9;
    vector<int> v1 {1,2,3,4,8};
    vector<int> v2 {7,6,4,7,2};
    astroTour(n, v1, v2);
    `*/

    //reviewed.


}






