import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class test {
    
    public static class library {
        public
        int n;
        int t;
        int m;
        ArrayList<Integer> bookId = new ArrayList<>();
        
        void takeArray(int n, Scanner scn) {
            for(int i = 0; i < n; i++) {
                int book = scn.nextInt();
                    bookId.add(book);
                }
            }
            
            void takeInput1(int n, int t, int m, Scanner scn) {
                this.n = n;
                this.m = m;
                this.t = t;
                takeArray(n, scn);
            }
        }
        
        
   
        static int b;
        static int l;
        static int d;
        static int numberOfLibrary = 0;
        static ArrayList<library> finalSequence = new ArrayList<>();        
        static ArrayList<Integer> index = new ArrayList<>();
        static ArrayList<Integer> bookScanned = new ArrayList<>();
        
        static void scheduleLibrary(ArrayList<library> lib) {
        while(d > 0) {
            int  min = Integer.MAX_VALUE;
            for(int i = 0; i < lib.size(); i++) {
                if((d - lib.get(i).t >= 1) && (min > lib.get(i).t)) {
                    min = lib.get(i).t;
                }
            }
            
            for(int i = 0; i < lib.size(); i++) {
                if((min == lib.get(i).t)) {
                    // System.out.println("hello");
                    d = d - min;
                    lib.get(i).t = Integer.MAX_VALUE;
                    numberOfLibrary++;
                    index.add(i);
                    int book = (d*lib.get(i).m > lib.get(i).n ? lib.get(i).n : d*lib.get(i).m); 
                    bookScanned.add(book);
                    finalSequence.add(lib.get(i));
                    break;
                }
            }
        }
        
            
    }

    static void bookScheduling(library present, int total, int[] score, Scanner scn) {
            
        while((total-- != 0) && (present.bookId.size() != 0)){
            int max = -1;
                int id = 0;
                for(int i = 0 ; i < present.bookId.size(); i++) {
                    if(max < score[present.bookId.get(i)]) {
                        max = score[present.bookId.get(i)];
                        id = i;
                    }
                }
                
                System.out.print(present.bookId.get(id) + " ");
                present.bookId.remove(id);
            }
            System.out.println();
            // for(int i = 0; i < present.bookId.size(); i++) {
            //     if(max == score[present.bookId.get(i)]) {
            //         System.out.print(present.bookId.get(i) + " ");
            //         present.get
            //     }
            // }
        }

        static void result(int[] score, Scanner scn) {
            System.out.println(numberOfLibrary - 1);

            for(int i = 0; i < finalSequence.size() - 1; i++) {
                System.out.println(index.get(i) + " " + bookScanned.get(i));
                bookScheduling(finalSequence.get(i), bookScanned.get(i), score, scn);
            }
        }
        
        
        public static void main(String[] args) throws FileNotFoundException{
            
           try {
                File file = new File("C:\\Users\\victor frankenstein\\Desktop\\Pep_Coding\\Foundation\\JAVA_code\\c_incunabula.txt");
                Scanner scn = new Scanner(file);

                b = scn.nextInt();
                l = scn.nextInt();
                d = scn.nextInt();
                
                int[] score = new int[b];
                
                for(int i = 0; i < score.length; i++) {
                    score[i] = scn.nextInt();
                }
    
                ArrayList<library> lib = new ArrayList<>();
                
                for(int i = 0; i < l; i++) {
                    // System.out.println("hello");
                    int n = scn.nextInt();
                    int t = scn.nextInt();
                    int m = scn.nextInt();
                    library first = new library();
                    first.takeInput1(n, t, m, scn);
                    lib.add(first);
                }
    
                while(d > 0)
                scheduleLibrary(lib);
    
                result(score, scn);    
            }
            catch(Exception e) {
               System.out.println(e);
            }
        }
}