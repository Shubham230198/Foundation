import java.util.*;
public class test {

    public static int getAnswer(String str) {
        boolean[][] dp = new boolean[str.length()][str.length()];
        int ans = 0;

        for(int d = 0; d < dp.length; d++) {
            int sp = 0;
            int ep = d;
            boolean flag = false;

            while(ep < dp.length) {
                if(d == 0) {
                    dp[sp][ep] = true;
                    if(flag == false) {
                        ans = 1;
                        flag = true;
                    }
                }
                else if(d == 1) {
                    dp[sp][ep] = str.charAt(sp) == str.charAt(ep) ? true : false;
                    if(dp[sp][ep] == true && flag == false) {
                        ans = 2;
                        flag = true;
                    }
                }
                else {
                    dp[sp][ep] = str.charAt(sp) == str.charAt(ep) ? dp[sp + 1][ep - 1] : false;
                    if(dp[sp][ep] == true && flag == false) {
                        ans = (ep - sp + 1);
                        flag = true;
                    } 
                }
                sp++;
                ep++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "abaabcba";
        System.out.println(getAnswer(str));
    }
}