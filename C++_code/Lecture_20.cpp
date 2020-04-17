                                        //Lecture-20
                                        //July-20

#include<iostream>
#include<string>
#include<vector>
using namespace std;



//CROSSWORD PROBLEM. (here, during unplacing we have used a dipit string, instead of dipit array as in java).


/*bool canPlaceVertical(char board[][10], int n, int r, int c, string word) {
    for(int i = 0; i < word.length(); i++) {
        if(r + i == n) return false;

        char chBoard = board[r + i][c];
        char chWord = word[i];
        if(chBoard != '0' && chBoard != chWord) return false;
    }

    if( r - 1 >= 0 && board[r - 1][c] != '1') {
        return false;
    }
    if( (r + word.length() < n) && board[r + word.length()][c] != '1') {
        return false;
    }

    return true;
}



string placeVertical(char board[][10], int r, int c, string word) {

    string dipit = "";
    for(int i = 0; i < word.length(); i++) {
        char chBoard = board[r + i][c];
        if(chBoard == '0') {
            board[r + i][c] = word[i];
            dipit += 't';
        }
        else {
            dipit += 'f';
        }
    }

    return dipit;
}



void unPlaceVertical(char board[][10], int r, int c, string dipit) {
    for(int i = 0; i < dipit.length(); i++) {
        if(dipit[i] == 't') {
            board[r + i][c] = '0';
        }
    }
}



bool canPlaceHorizontal(char board[][10], int n, int r, int c, string word) {
    for(int j = 0; j < word.length(); j++) {
        if(c + j == n) return false;

        char chBoard = board[r][c + j];
        char chWord = word[j];
        if(chBoard != '0' && chWord != chBoard) return false;
    }

    if( c - 1 >= 0 && board[r][c - 1] != '1') return false;
    if(c + word.length() < n && board[r][c + word.length()] != '1') return false;

    return true;
}



string placeHorizontal(char board[][10], int r, int c, string word) {
    
    string dipit = "";
    for(int j = 0; j < word.length(); j++) {
        char chBoard = board[r][c + j];
        if(chBoard == '0') {
            board[r][c + j] = word[j];
            dipit += 't';
        }
        else {
            dipit += 'f';
        }
    }    

    return dipit;
}



void unPlaceHorizontal(char board[][10], int r, int c, string dipit) {

    for(int j = 0; j < dipit.length(); j++) {
        if(dipit[j] == 't') {
            board[r][c + j] = '0';
        }
    }
}



int counter = 0;
void crossword(char board[][10], int n, int idx, string words[], int wordsLength) {       //backtracking function
    if(idx == wordsLength) {
        cout<<"**********"<<++counter<<"**********\n";
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                cout<<board[i][j];
            }
            cout<<"\n";
        }
        
        cout<<"**********"<<counter<<"**********\n";
        return;
    }
    
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            if(canPlaceVertical(board, n, i, j, words[idx]) == true) {
                string dipit = placeVertical(board, i, j, words[idx]);
                crossword(board, n, idx + 1, words, wordsLength);
                unPlaceVertical(board, i, j, dipit);
            }

            if(canPlaceHorizontal(board, n, i, j, words[idx]) == true) {
                string dipit = placeHorizontal(board, i, j, words[idx]);
                crossword(board, n, idx + 1, words, wordsLength);
                unPlaceHorizontal(board, i, j, dipit);
            }
        }
    }
}



int main(int argc,char** argv)
{
    char board[10][10] = {
            {'1','1','1','1','1','1','1','1','1','0'},
            {'0','1','1','1','1','1','1','1','1','0'},
            {'0','0','0','0','0','0','0','1','1','0'},
            {'0','1','1','1','1','1','1','1','1','0'},
            {'0','1','1','1','1','1','1','1','1','0'},
            {'0','1','1','1','1','0','0','0','0','0'},
            {'0','0','0','0','0','0','1','1','1','0'},
            {'0','1','1','1','1','1','1','1','1','0'},
            {'1','0','0','0','0','0','0','0','0','0'},
            {'1','1','1','1','1','1','1','1','1','1'}
        };

    string words[] = {"HISTORY", "CHEMISTRY", "MATHS", "PHYSICS", "CIVICS", "GEOGRAPHY"};
    crossword(board, 10, 0, words, 6);
}*/ 


//REVIWED.







//MAGNETS PROBLEM                                 


/*int *top;
int *bottom;
int *lef;
int *rig;



bool canPlaceHorizontal(char arr[][6], int cSize, int r, int c, string option) {
    if(c - 1 >= 0 && arr[r][c - 1] == option.at(0))
        return false;
    else if(r - 1 >= 0 && arr[r - 1][c] == option.at(0))
        return false;
    else if(r - 1 >= 0 && c + 1 < cSize && arr[r - 1][c + 1] == option.at(1))
        return false;
    else if(c + 2 < cSize && arr[r][c + 2] == option.at(1))
        return false;

    return true;
}



bool canPlaceVertical(char arr[][6], int cSize, int r, int c, string option) {
    if(c - 1 >= 0 && arr[r][c - 1] == option.at(0))
        return false;
    else if(r - 1 >= 0 && arr[r - 1][c] == option.at(0))
        return false;
    else if(c + 1 < cSize && arr[r][c + 1] == option.at(0))
        return false;

    return true;
}



void getMagnets(char arr[][6], int rSize, int cSize, int r, int c) {       //rSize, cSize as row size and column size.
    if(r == rSize && c == 0) {

        //checking number of plus and minus in row
        for(int i = 0; i < rSize; i++) {
            int cPlus = 0;
            int cMinus = 0;
            for(int j = 0; j < cSize; j++) {
                if(arr[i][j] == '+')
                    cPlus++;
                else if(arr[i][j] == '-')
                    cMinus++;
            }

            if(cPlus != lef[i] && lef[i] != 0)        //lef as left array
                return;
            
            if(cMinus != rig[i] && rig[i] != 0)       //rig as right array
                return;
        }

        //checking number of plus and minus in column.
        for(int j = 0; j < cSize; j++) {
            int cPlus = 0;
            int cMinus = 0;
            for(int  i = 0; i < rSize; i++) {
                if(arr[i][j] == '+')
                    cPlus++;
                else if(arr[i][j] == '-')
                    cMinus++;
            }

            if(cPlus != top[j] && top[j] != 0){
                return;
            }

            if(cMinus != bottom[j] && bottom[j] != 0) {
                return;
            }
        }

        //printing
        for(int i = 0; i < rSize; i++) {
            for(int j = 0; j < cSize; j++) {
                cout<<arr[i][j]<<" ";
            }
            cout<<"\n";
        }

        return;
    }


    if(c == cSize - 1) {
        if(arr[r][c] == 't') {
            //option1 (+-)
            if(canPlaceVertical(arr, cSize, r, c, "+-")) {
                arr[r][c] = '+';
                arr[r + 1][c] = '-';
                getMagnets(arr, rSize, cSize, r + 1, 0);
                arr[r][c] = 't';
                arr[r + 1][c] = 'b';
            }

            //option2 (-+) 
            if(canPlaceVertical(arr, cSize, r, c, "-+")){
                arr[r][c] = '-';
                arr[r + 1][c] = '+';
                getMagnets(arr, rSize, cSize, r + 1, 0);
                arr[r][c] = 't';
                arr[r + 1][c] = 'b';
            }

            //option3 (**)
            arr[r][c] = '*';
            arr[r + 1][c] = '*';
            getMagnets(arr, rSize, cSize, r + 1, 0);
            arr[r][c] = 't';
            arr[r + 1][c] = 'b';
        }
        else {
            getMagnets(arr, rSize, cSize, r + 1, 0);
        }
    }
    else {
        if(arr[r][c] == 'l') {
            //option1 (+-)
            if(canPlaceHorizontal(arr, cSize, r, c, "+-")) {
                arr[r][c] = '+';
                arr[r][c + 1] = '-';
                getMagnets(arr, rSize, cSize, r, c + 1);
                arr[r][c] = 'l';
                arr[r][c + 1] = 'r';
            }

            //option2 (-+)
            if(canPlaceHorizontal(arr, cSize, r, c, "-+")) {
                arr[r][c] = '-';
                arr[r][c + 1] = '+';
                getMagnets(arr, rSize, cSize, r, c + 1);
                arr[r][c] = 'l';
                arr[r][c + 1] = 'r';
            }

            //option3 (**)
            arr[r][c] = '*';
            arr[r][c + 1] = '*';
            getMagnets(arr, rSize, cSize, r, c + 1);
            arr[r][c] = 'l';
            arr[r][c + 1] = 'r';
        }
        else if(arr[r][c] == 't') {
            //option1 (+-)
            if(canPlaceVertical(arr, cSize, r, c, "+-")) {
                arr[r][c] = '+';
                arr[r + 1][c] = '-';
                getMagnets(arr, rSize, cSize, r, c + 1);
                arr[r][c] = 't';
                arr[r + 1][c] = 'b';
            }

            //option2 (-+)
            if(canPlaceVertical(arr, cSize, r, c, "-+")) {
                arr[r][c] = '-';
                arr[r + 1][c] = '+';
                getMagnets(arr, rSize, cSize, r, c + 1);
                arr[r][c] = 't';
                arr[r + 1][c] = 'b';
            }

            //option3 (**)
            arr[r][c] = '*';
            arr[r + 1][c] = '*';
            getMagnets(arr, rSize, cSize, r, c + 1);
            arr[r][c] = 't';
            arr[r + 1][c] = 'b';
        }
        else {
            getMagnets(arr, rSize, cSize, r, c + 1);
        }
    }
}



int main() {
    top = new int[6] {1, 0, 0, 2, 1, 0};
    bottom = new int[6] {2, 0, 0, 2, 0, 3};
    lef = new int[5] {2, 3, 0, 0, 0};       //can't name it left, as there is already keyword in namespace, as left.
    rig = new int[5] {0, 0, 0, 1, 0};       //can't name it left, as there is already keyword in namespace, as right.

    char arr[][6] = {
        {'l', 'r', 'l', 'r', 't', 't'},
        {'l', 'r', 'l', 'r', 'b', 'b'},
        {'t', 't', 't', 't', 'l', 'r'},
        {'b', 'b', 'b', 'b', 't', 't'},
        {'l', 'r', 'l', 'r', 'b', 'b'}
    };

    getMagnets(arr, 5, 6, 0, 0);

}*/



//REVIEWED.