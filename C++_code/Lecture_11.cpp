                                                //LECTURE - 11
                                                //3 - JULY

#include<iostream>
#include <vector>
using namespace std;

int main()
{
    vector<int> data {12,13,14,1,4,5};                         //THE METHOD TO TRAVERSE OVER VECTOR
                                                               //BY USING ITERATOR (itr)
    for(auto itr = data.begin(); itr != data.end(); itr++) {
        cout<<*itr<<" ";
    }
    return 0;
}                                                               //REVIEWED.