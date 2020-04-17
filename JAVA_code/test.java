import java.util.*;
public class test{
    public static boolean fun() {

        int[] count = new int[10];

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        for(int i = 0; i < n ; i++) {
            int temp = scn.nextInt();
            count[temp]++;
        }

        int teamSize = -1;

        for(int i = 0; i < count.length; i++) {
            if(count[i] == 1) {
                return false;
            }
            else if(count[i] != 0) {
                if(teamSize == -1) {
                    teamSize = count[i];
                }
                else {
                    if(teamSize != count[i]) {
                        return false;
                    }
                }

            }
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(fun());
    }
}