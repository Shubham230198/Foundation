class Solution{

    public static boolean checkValidString(String s) {
        Stack <Character> s1=new Stack<>();
        boolean a=rec(s,s1,0);
        return a;
    }

    public static boolean rec(String s,Stack<Character> s1,int idx){
            boolean flag=false;
            if(idx==s.length()){
                if(s1.size()==0){
                    flag=true;
                    return true;
                }
                return false;
            }
            char ch=s.charAt(idx);
            if(ch=='('){
                s1.push(ch);
                flag=rec(s,s1,idx+1);
                if(s1.size()>0){
                s1.pop();}
                if(flag){
                    return true;
                }
                
            }
            else if(ch==')'){
                if(s1.size()>0){
                    s1.pop();
                }
                else{
                    return false;
                }
                flag=rec(s,s1,idx+1);
                s1.push('(');
                if(flag){
                    return true;
                }
                
                
            }
            else if(ch=='*'){
                s1.push('(');
                flag=rec(s,s1,idx+1);
                if(s1.size()>0){
                s1.pop();}
                if(flag){
                    return true;
                }
                
                //s1.push("");
                flag=rec(s,s1,idx+1);
                if(flag){
                    return true;
                }
                
                if(s1.size()>0){
                    s1.pop();
                }
                else{
                    return false;
                }
                flag=rec(s,s1,idx+1);
                s1.push('(');
                if(flag){
                    return true;
                }
                
            }
            return flag;
            
        
    }
}