                                                        //Lecture - 13
                                                        //June 6

#include<iostream>
#include<vector>
#include<string>
using namespace std;

/*vector<string> gsp(int src)                                //TO GET ALL THE WAYS TO GET DOWN 
{                                                          //STAIRS OF HEIGHT 7,(with possible 
    if(src==0)                                             //step size of 1,2,3)
    {
        vector<string> bs;
        bs.push_back("");
        return bs;
    }

    vector<string> s_to_d;

    for(int step=1;step<=3;step++)
    {   
        if(src>=step)
        {
            int nebr=src-step;
            vector<string> n_to_d= gsp(nebr);

            for(int i=0;i< n_to_d.size();i++)
            {
                string n_to_dpath=n_to_d[i];
                string s_to_dpath=to_string(step)+n_to_dpath;
                s_to_d.push_back(s_to_dpath);
            }

        }
    }

    return s_to_d;
}


int main(int argc,char** argv)
{
    vector<string> paths=gsp(7);

    for(int i=0;i<paths.size();i++)
    {
        cout<<paths[i]<<endl;
    }

    return 0;
}*/                                                   //REVIEWED.





/*vector<string> get_maze_path(int srow,int scol,int drow,int dcol)                      //TO GET ALL PATHS FOR MATRIX MAZE
{   
    if(srow==drow&&scol==dcol)
    {
        vector<string> bs;
        bs.push_back("");
        return bs;
    }


    vector<string> h_nebr;
    vector<string> v_nebr;

    if(scol<dcol)
    {
        h_nebr=get_maze_path(srow,scol+1,drow,dcol);
    }

    if(srow<drow)
    {
        v_nebr=get_maze_path(srow+1,scol,drow,dcol);
    }

    vector<string> paths;

    for(int i=0;i<h_nebr.size();i++)
    {
        paths.push_back("h"+ h_nebr[i]);
    }

    for(int i=0;i<v_nebr.size();i++)
    {
        paths.push_back("v"+ v_nebr[i]);
    }

    return paths;
    
}


int main()
{
    int scol,srow,dcol,drow;
    cin>>srow>>scol;
    cin>>drow>>dcol;

    vector<string> path=get_maze_path(0,0,2,2);

    for(int i=0;i<path.size();i++)
    {
        cout<<path[i]<<endl;
    }

    return 0;
}*/                                                         //REVIEWED.





/*vector<string> get_multimaze_path(int srow,int scol,int drow,int dcol)        //TO GET PATHS OF MULTIMAZE.
{   
    if(scol==dcol && srow==dcol)
    {
        vector<string> bs;
        bs.push_back("");
        return bs;
    }

    vector<string> s_to_d;


    //horizontal moves;
    for(int ms=1;ms<=dcol-scol;ms++)
    {
        vector<string> h_nebr=get_multimaze_path(srow,scol+ms,drow,dcol);

        for(int i=0;i<h_nebr.size();i++)
        {
            s_to_d.push_back("h"+to_string(ms)+h_nebr[i]);
        }
    }

    //vertical moves;
    for(int ms=1;ms<=drow-srow;ms++)
    {
        vector<string> v_nebr=get_multimaze_path(srow+ms,scol,drow,dcol);

        for(int i=0;i<v_nebr.size();i++)
        {
            s_to_d.push_back("v"+to_string(ms)+v_nebr[i]);
        }
    }

    //diagonal moves;
    for(int ms=1;ms<=dcol-scol && ms<=drow-srow;ms++)
    {
        vector<string> d_nebr=get_multimaze_path(srow+ms,scol+ms,drow,dcol);

        for(int i=0;i<d_nebr.size();i++)
        {
            s_to_d.push_back("d"+to_string(ms)+d_nebr[i]);
        }
    }

return s_to_d;

}

int main()
{
    vector<string> path=get_multimaze_path(0,0,2,2);

    cout<<path.size()<<endl;
    for(int i=0;i<path.size();i++)
    {
        cout<<path[i]<<endl;

    }
    return 0;
}*/                                                             //REVIEWED.





vector<string> get_array_paths(int arr[],int n,int index)                //ARRAY SRC TO DESTINATION PROBLEM
{                                                                        //to retrun the total possible steps
    if(index==n-1)                                                       //combinations in the form of strings, to reach
    {                                                                    //the last value of the array, from given scr index.
        vector<string> bs;                                               //But from any index only those no. of steps or less
        bs.push_back("");                                                //are possible, equal to value at that index in array.
        return bs;
    }

    if(index>n-1)                                                
    {
        vector<string> false_bs;
        return false_bs;
    }

    vector<string> s_to_d;
    for(int ms=1;ms<=arr[index];ms++)                            //Here we have made reactive calls,
    {                                                            //instead, we should have made proactive calls.
        vector<string> n_to_d=get_array_paths(arr,n,index+ms);
        for(int i=0;i<n_to_d.size();i++)
        {
            s_to_d.push_back(to_string(ms)+n_to_d[i]);
        }
    }

    return s_to_d;

}


int main()
{
    int arr[]={3,2,0,4,1,2,0,2,3,0,1};

    vector<string> path=get_array_paths(arr,11,0);

    for(int i=0;i<path.size();i++)
    {
        cout<<path[i]<<endl;-
    }
    return 0;
}                                                                                      //REVIEWED.