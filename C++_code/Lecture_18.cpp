#include<iostream>
#include<string>
#include<vector>
#include<unordered_set>
using namespace std;


/*void encodings(string ques, string asf)                   //TO GET COMBINATIONS OF ALL INTEGERS
{                                                         //IN THE FORM OF STRINGS
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
    
    //encodings("1123","");      //test cases
    encodings("1203","");
    //encodings("1321","");
    //encodings("1023","");
    return 0;
}*/                                                 //REVIEWED.






void word_break(string ques,string asf,unordered_set<string> & dictionary)
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
    // dictionary.insert("go");
    dictionary.insert("cream");
    dictionary.insert("ice");
    dictionary.insert("icecream");
    dictionary.insert("sam");
    dictionary.insert("sung");
    dictionary.insert("samsung");
    
    word_break("mangoicecreamsamsung","",dictionary);
    
}