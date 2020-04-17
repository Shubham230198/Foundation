                                        //Lecture-20
                                        //July-15

import java.util.*;
public class Lecture_20
{   
    //CROSSWORD PROBLEM

    
    /*public static boolean canPlaceVertically(char[][] board, int r, int c, String word ) {     //to check if it is possible to place vertically
        for(int i = 0; i < word.length(); i++) {                                               //the word, starting from this position.
            if(r + i >= board.length) return false;
            
            char chWord = word.charAt(i);
            char chBoard = board[r + i][c];

            if(chBoard != '0' && chBoard != chWord) 
                return false;
        }

        if( r - 1 >= 0 && board[r - 1][c] != '1') return false;
        
        if( r + word.length() < board.length && board[r + word.length()][c] != '1') return false;

        return true;
    }



    public static boolean[] placeVertically(char[][] board, int r, int c, String word) {     //function to place a word.(only where current is '0')
        boolean[] dipit = new boolean[word.length()];

        for(int i = 0; i < word.length(); i++) {
            char chWord = word.charAt(i);

            if(board[r + i][c] == '0') {
                board[r + i][c] =  chWord;
                dipit[i] = true;
            }
        }

        return dipit;
    }



    public static void unPlacevertically(char[][] board, int r, int c, boolean[] dipit) {   //to unplace the placed word(only the placed part).
        for(int i = 0; i < dipit.length; i++) {
            if(dipit[i] == true) {
                board[r + i][c] = '0';
            }
        } 
    }



    public static boolean canPlaceHorizontally(char[][] board, int r, int c, String word) {     //to check if it is possible to place
        for(int j = 0; j < word.length(); j++) {                                                //the word, starting from this position.
            if(c + j >= board[0].length) return false;

            char chWord = word.charAt(j);
            char chBoard = board[r][c + j];

            if(chBoard != '0' && chWord != chBoard) return false;
        }

        if(c - 1 >= 0 && board[r][c - 1] != '1') return false; 

        if(c + word.length() < board[0].length && board[r][c + word.length()] != '1') return false;

        return true;
    }



    public static boolean[] placeHorizontally(char[][] board, int r, int c, String word) {   //function to place a word.(only where current is '0')
        boolean[] dipit = new boolean[word.length()];

        for(int j = 0; j < word.length(); j++) {
            if(board[r][c + j] == '0') {
                char chWord = word.charAt(j);
                board[r][c + j] = chWord;
                dipit[j] = true;
            }
        }

        return dipit;
    }



    public static void unPlaceHorizontally(char[][] board, int r, int c, boolean[] dipit) {  //to unplace the placed word(only the placed part).
        for(int j = 0; j < dipit.length; j++) {
            if(dipit[j] == true) {
                board[r][c + j] = '0';
            }
        }
    }



    static int counter = 0;
    public static void crossword(char[][] board, int wordIdx, String[] words) {   //backtracking function
        if(wordIdx == words.length) {
            System.out.println("**********" + ++counter + "**********");
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            
            System.out.println("**********" + counter + "**********");
            return;
        }

        for(int i = 0; i <board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(canPlaceVertically(board, i, j, words[wordIdx]) == true) {
                    boolean[] dipit = placeVertically(board, i, j, words[wordIdx]);
                    crossword(board, wordIdx + 1, words);
                    unPlacevertically(board, i, j, dipit);
                }

                if(canPlaceHorizontally(board, i, j, words[wordIdx]) == true) {
                    boolean[] dipit = placeHorizontally(board, i, j, words[wordIdx]);
                    crossword(board, wordIdx + 1, words);
                    unPlaceHorizontally(board, i, j, dipit);
                }
            }
        }
    }



    public static void main(String[] args)
    {
        char[][] board={
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
        String[] words={"HISTORY","CHEMISTRY","MATHS","PHYSICS","CIVICS","GEOGRAPHY"}; 
  
        crossword(board, 0, words);
    }*/        
    
    
    //REVIEWED.












    
    //MAGNETS PROBLEM. 
    
    /*static int[] top;
    static int[] bottom;
    static int[] left;
    static int[] right;



    static boolean canPlaceHorizontal(char[][] arr, int r, int c, String option) {      //will check both (-+) (+-), horizontally.
        if(c - 1 >= 0 && arr[r][c - 1] == option.charAt(0))
            return false;
        else if(r - 1 >= 0 && arr[r - 1][c] == option.charAt(0))
            return false;
        else if(r - 1 >= 0 && c + 1 < arr[0].length && arr[r - 1][c + 1] == option.charAt(1))
            return false;
        else if(c + 2 < arr[0].length && arr[r][c + 2] == option.charAt(1))
            return false;

        return true;
    }



    static boolean canPlaceVertical(char[][] arr, int r, int c, String option) {       ////will check both (-+) (+-), veritially.
        if(c - 1 >= 0 && arr[r][c - 1] == option.charAt(0))
            return false;
        else if(r - 1 >= 0 && arr[r - 1][c] == option.charAt(0))
            return false;
        else if(c + 1 < arr[0].length && arr[r][c + 1] == option.charAt(0)) 
            return false;
            
        return true;
    }
    
    
    
    public static void getMagnets(char[][] arr, int r, int c) {      //keeping boxes at levels, (+-) (-+) (**) as options.
        if(r == arr.length && c == 0) {
            
            //checking numbers of (+) and (-) each row
            for(int i = 0; i < arr.length; i++) {
                int cPlus = 0;
                int cMinus = 0;
                for(int j = 0; j < arr[0].length; j++) {
                    if(arr[i][j] == '+')
                        cPlus++;
                    else if(arr[i][j] == '-')
                        cMinus++;
                }
                
                if(cPlus != left[i] && left[i] != 0) {
                    return;
                }
                
                if(cMinus != right[i] && right[i] != 0) {
                    return;
                }
            }
            
            //checking number of (+) and (-) in columns
            for(int j = 0; j < arr[0].length; j++) {
                int cPlus = 0;
                int cMinus = 0;
                for(int i = 0; i < arr.length; i++) {
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
            
            //Printing
            for(int i = 0; i < arr.length; i++) {
                for(int j = 0; j < arr[0].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            
            return;
        }
        
        if(c == arr[0].length - 1) {
            if(arr[r][c] == 't') {
                //option1 (+-)
                if(canPlaceVertical(arr, r, c, "+-")) {
                    arr[r][c] = '+';
                    arr[r + 1][c] = '-';
                    getMagnets(arr, r + 1, 0);
                    arr[r][c] = 't';
                    arr[r + 1][c] = 'b';
                }
                
                //option2 (-+)
                if(canPlaceVertical(arr, r, c, "-+")) {
                    arr[r][c] = '-';
                    arr[r + 1][c] = '+';
                    getMagnets(arr, r + 1, 0);
                    arr[r][c] = 't';
                    arr[r + 1][c] = 'b'; 
                }

                //option3 (**)
                arr[r][c] = '*';
                arr[r + 1][c] = '*';
                getMagnets(arr, r + 1, 0);
                arr[r][c] = 't';
                arr[r + 1][c] = 'b';
            }
            else {
                getMagnets(arr, r + 1, 0);
            }
        }
        else {
            if(arr[r][c] == 'l') {
                //option1 (+-)
                if(canPlaceHorizontal(arr, r, c, "+-")) {
                    arr[r][c] = '+';
                    arr[r][c + 1] = '-';
                    getMagnets(arr, r, c + 1);
                    arr[r][c] = 'l';
                    arr[r][c + 1] = 'r';
                }
                
                //option2 (-+)
                if(canPlaceHorizontal(arr, r, c, "-+")) {
                    arr[r][c] = '-';
                    arr[r][c + 1] = '+';
                    getMagnets(arr, r, c + 1);
                    arr[r][c] = 'l';
                    arr[r][c + 1] = 'r';
                }

                //option3 (**)
                arr[r][c] = '*';
                arr[r][c + 1] = '*';
                getMagnets(arr, r, c + 1);
                arr[r][c] = 'l';
                arr[r][c + 1] = 'r';
            }
            else if(arr[r][c] == 't') {
                //option1 (+-)
                if(canPlaceVertical(arr, r, c, "+-")) {
                    arr[r][c] = '+';
                    arr[r + 1][c] = '-';
                    getMagnets(arr, r, c + 1);
                    arr[r][c] = 't';
                    arr[r + 1][c] = 'b';
                }

                //option2 (-+)
                if(canPlaceVertical(arr, r, c, "-+")) {
                    arr[r][c] = '-';
                    arr[r + 1][c] = '+';
                    getMagnets(arr, r, c + 1);
                    arr[r][c] = 't';
                    arr[r + 1][c] = 'b';
                }

                //option3 (**)
                arr[r][c] = '*';
                arr[r + 1][c] = '*';
                getMagnets(arr, r, c + 1);
                arr[r][c] = 't';
                arr[r + 1][c] = 'b';
            }
            else {
                getMagnets(arr, r, c + 1);
            }
        }
    }



    public static void main(String[] args) {
        top = new int[] {1, 0, 0, 2, 1, 0};
        bottom = new int[] {2, 0, 0, 2, 0, 3};
        left = new int[] {2, 3, 0, 0, 0};
        right = new int[] {0, 0, 0, 1, 0};

        char[][] arr = {
            "lrlrtt".toCharArray(),
            "lrlrbb".toCharArray(),
            "ttttlr".toCharArray(),
            "bbbbtt".toCharArray(),
            "lrlrbb".toCharArray(),
        };
        getMagnets(arr, 0, 0);
    }*/




    //REVIEWED.


}