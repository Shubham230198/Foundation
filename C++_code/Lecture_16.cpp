                                                                //LECTURE-16
                                                                //JULY - 11

#include <iostream>
#include <string>
#include <algorithm>
using namespace std;



/*void combination2(int currentBoxIndx, int totalBoxIdx, int boxSelectedSoFar, int boxRequried, string psf) {        //TO GET COMBINATIONS by second method.

    if(currentBoxIndx == totalBoxIdx + 1) {
        if(boxSelectedSoFar == boxRequried) {
            cout<<psf<<endl;
        }
        return;
    }

    if(boxSelectedSoFar < boxRequried) {
        //to select the current box;
        combination2(currentBoxIndx + 1, totalBoxIdx, boxSelectedSoFar + 1, boxRequried, psf + to_string(boxSelectedSoFar) + "[" + to_string(currentBoxIndx) + "] ");
    }

    //to not select the given box;
    combination2(currentBoxIndx + 1, totalBoxIdx, boxSelectedSoFar, boxRequried, psf);

}*/                                                                    //REVIEWED.





/*void permutation2(bool objects[], int tObjects, int cBoxIdx, int tBoxIdx, int bsf, int rBox, string psf) {       //to get permutation by second method.
    if(cBoxIdx > tBoxIdx) {
        if(bsf == rBox) {
            cout<<psf<<endl;
        }
        return;
    }

    permutation2(objects, tObjects, cBoxIdx + 1, tBoxIdx, bsf, rBox, psf);

    for(int i = 0; i < tObjects; i++) {
        if(objects[i] == false) {
            objects[i] = true;
            permutation2(objects, tObjects, cBoxIdx + 1, tBoxIdx, bsf + 1, rBox, psf + to_string(i) + "[" + to_string(cBoxIdx) + "] ");
            objects[i] = false;
        } 
    }
}*/




int main(int argc, char** argv) {
    
    //combination2(0, 4, 0, 2, "");                        //to get combination by second method.



    /*bool objects[2];                                   //to get permutations by second method.
    fill_n(objects, 2 ,false);
    
    int tObjects = sizeof(objects)/sizeof(*objects);
    permutation2(objects, tObjects,0, 4, 0, 2, "");
    */                                                      //reviewed.
    
    
    return 0;

}