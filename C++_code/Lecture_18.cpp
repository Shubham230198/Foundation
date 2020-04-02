                                                    //LECTURE-18
                                                    //JULY-13

#include<iostream>
#include<string>
#include<vector>
#include<unordered_set>
using namespace std;


/*void encodings(string ques, string asf)                   //TO GET COMBINATIONS OF ALL INTEGERS
{                                                               //possible in the form of strings.
   if(ques.length()==0)
   {
       cout<<asf<<endl;
   }
   else if(ques.length()==1)
   {
       char ch0=ques[0];
       string roq0=ques.substr(1,ques.length()-1);

       if(ch0!='0')
       {    
           char code =ch0-48+ 'a' -1;
           encodings(roq0,asf+code);
       }
   }
   else
   {    
        char ch0=ques[0];
       string roq0=ques.substr(1,ques.length()-1);

       if(ch0!='0')
       {    
           char code =ch0-48+ 'a' -1;
           encodings(roq0,asf+code);
       }

       char ch1=ques[1];
       string roq1=ques.substr(2,ques.length()-2);
       if(ch0!='0')
       {
           int num=(ch0-48)*10 + (ch1-48);
           if(num>=10 && num<=26)
           {
               char code='a' + num-1;
               encodings(roq1,asf+code);
           }
       }
   }
}


int main()
{
    
    encodings("1123","");       //test cases 1

    // encodings("1203","");       //test case 2
    // encodings("1023","");        
    
    // encodings("1321","");        //test case 3
    
    // encodings("1003", "");       //test case 4

    return 0;
}*/                                                 //REVIEWED.











/*void word_break(string ques,string asf,unordered_set<string> & dictionary)                //WORD BREAK PROBLEM.(void return type)
{
    if(ques.length()==0)
    {
        cout<<asf<<endl;
        return ;
    }

    for(int i=1;i<=ques.length();i++)
    {   
        string prefix=ques.substr(0,i);

        if(dictionary.count(prefix)==1)
        {
            string roq=ques.substr(i,ques.length()-prefix.length());
            word_break(roq, asf+prefix+"-" ,dictionary);
        }
    }
}



int main()
{
    unordered_set<string> dictionary;
    dictionary.insert("man");
    dictionary.insert("mango");
    dictionary.insert("go");
    dictionary.insert("cream");
    dictionary.insert("ice");
    dictionary.insert("icecream");
    dictionary.insert("sam");
    dictionary.insert("sung");
    dictionary.insert("samsung");
    
    word_break("mangoicecreamsamsung","",dictionary);

    word_break("mangoicecreamCHECKsamsung","",dictionary);             //contain word not present in dictionary, 
                                                                        //thus there won't be any answer.
    
}*/                                                  //REVIEWED.











/*vector<string> getWordBreak(string ques, unordered_set<string> &dictionary) {                    //Word Break Problem(vector return type)
    if(ques.length() == 0) {
        vector<string> bs;
        bs.push_back("");
        return bs;
    }
    
    vector<string> myAns;
    for(int i = 1; i <= ques.length(); i++) {
        string prefix = ques.substr(0, i);

        if(dictionary.count(prefix) == 1) {
            vector<string> pre = getWordBreak(ques.substr(i, ques.length() - prefix.length()), dictionary);
            for(string str : pre) {
                myAns.push_back(prefix + "-" + str);
            }
        }
    }
    return myAns;
}


int main() {
    unordered_set<string> dictionary;
    dictionary.insert("man");
    dictionary.insert("mango");
    dictionary.insert("go");
    dictionary.insert("cream");
    dictionary.insert("ice");
    dictionary.insert("icecream");
    dictionary.insert("sam");
    dictionary.insert("sung");
    dictionary.insert("samsung");

    vector<string> ans = getWordBreak("mangoicecreamsamsung", dictionary);
    for(string s : ans) {
        cout<<s<<"\n";
    }

    vector<string> ans = getWordBreak("mangoicecreamsamsung", dictionary);          //test case with word, not present in dictionary
    for(string s : ans) {                                                           //therefore there won't be any solution.
        cout<<s<<"\n";
    }
}*/                                                             //REVIEWED.
