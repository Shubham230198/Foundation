                                                //Lecture-15
                                                //July - 10

#include<iostream>
#include<vector>
#include<string>
using namespace std;

/*void maze_flood_flow(int sr, int sc, vector<vector<int>>& maze,string ans)                 //MAZE FLOOD FLOW.
{
    if(sr == maze.size() - 1 && sc == maze[0].size() - 1) {
        cout<<ans<<endl;
        return;
    }

    maze[sr][sc] = 2;
    if(sr > 0 && maze[sr - 1][sc] != 1 && maze[sr - 1][sc] != 2) {
        maze_flood_flow(sr - 1, sc, maze, ans + "u");
    }

    if(sc > 0 && maze[sr][sc - 1] != 1 && maze[sr][sc - 1] != 2) {
        maze_flood_flow(sr, sc - 1, maze, ans + "l");
    }

    if(sr < maze.size() - 1 && maze[sr + 1][sc] != 1 && maze[sr + 1][sc] != 2) {
        maze_flood_flow(sr + 1, sc, maze, ans + "d");
    }

    if(sc < maze[0].size() - 1&& maze[sr][sc + 1] != 1 && maze[sr][sc + 1] != 2) {
        maze_flood_flow(sr, sc + 1, maze, ans + "r");
    }

    maze[sr][sc] = 0;
}


int main()
{
    vector<vector<int>> maze {
            {0,1,0,0,0,0,0,1},
            {0,1,0,1,1,1,0,1},
            {0,1,0,1,0,0,0,1},
            {0,0,0,0,0,1,1,1},
            {0,1,0,1,0,0,0,0},
            {0,1,0,1,1,1,1,0},
            {0,1,0,1,1,1,1,0},
            {0,1,0,0,0,0,0,0}
    };

    maze_flood_flow(0, 0, maze, "");
}*/                                                                         //REVIEWED.