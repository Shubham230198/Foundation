                                                //LECTURE - 12
                                                //5 -july

#include<iostream>
#include<string>
#include<vector>

using namespace std;

/*string count[10]={                                 //TO GET THE PHONE KEYPAD
        ".",                                         //COMBINATIONS.
        "abc",
        "def",
        "ghi" ,
        "jklm",
        "no",
        "pqrs",
        "tu",
        "vwx",
        "z"       
    };


vector<string> getkpc(string str)
{   
    if(str.length()==0)
    {
        vector<string> rres;
        rres.push_back("");
        return rres;
    }

    char ch=str[0];
    string res=str.substr(1,str.length()-1);

    vector<string> rres=getkpc(res);
    vector<string> mres;

    string code=count[ch-48];
    for(int i=0;i<code.size();i++)
    {
        char chcode=code[i];
        for(int j=0;j<rres.size();j++)
        {
            string rstr=rres[j];
            mres.push_back(chcode + rstr);
        }
    }

    return mres;
}                                                 //REVIEWED.



int main(int argc,char** argv)                     //STRING INTRODUCTION.
{
      string s;
      s="835";

      vector<string> words=getkpc(s);

      for(int i=0;i<words.size();i++)     
      {
          cout<<words[i]<<" ";

      }
      return 0;
    
}*/                                              //REVIEWED.




