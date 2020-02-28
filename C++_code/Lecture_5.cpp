                                            //Lecture_5
                                            //June 22

#include<iostream>
using namespace std;

/*void swap(int* drr, int left,int right)           //reversing an array
{   int temp=drr[left];
    drr[left]=drr[right];
    drr[right]=temp;
}

void rev(int* crr,int n)
{   int left=0;
    int right=n-1;
    while(left<right)
    {
        swap(crr,left,right);
        left++;
        right--;
    }
}

void display(int* brr,int n)
{   for(int i=0;i<n;i++)
        cout<<brr[i]<<" ";
}

int main(int argc,char** argv)
{   
    int* arr=new int[6] {10,20,30,40,50,60};
    rev(arr,6);
    display(arr,6);
    return 0;
}*/                                        //reviewed



                                        //PARAMETER PASSING

void exp1(int exv1, int exv2)                         //Value-type  &  call by value
{
    cout << exv1 << " " << exv2 << endl;

    int temp = exv1;
    exv1 = exv2;
    exv2 = temp;

    cout << exv1 << " " << exv2 << endl;
}



void exp2(int* e2v1, int* e2v2)                     //Value-type  &  call by reference
{
    cout << *e2v1 << " " << *e2v2 << endl;

    int temp = *e2v1;
    *e2v1 = *e2v2;
    *e2v2 = temp;

    cout << *e2v1 << " " << *e2v2 << endl;
}



void exp3(int* e3r1, int* e3r2)                     //reference-type  &  call by value 
{
    cout << *e3r1 << " " << *e3r2 << endl;

    int temp = *e3r1;
    *e3r1 = *e3r2;
    *e3r2 = temp;

    cout << *e3r1 << " " << *e3r2 << endl;
}



void exp4(int** e4r1, int** e4r2)                   //reference-type  &  call by reference
{
    cout << **e4r1 << " " << **e4r2 << endl;

    int* temp = *e4r1;
    *e4r1 = *e4r2;
    *e4r2 = temp;

    cout << **e4r1 << " " << **e4r2 << endl;
}




int main(int argc, char** argv)
{
                                            // value and ref type
    // int x = 10; // value
    // int* y = &x; // ref
    // int* z = new int(5); // ref
    // int* a = new int[5]; // ref


    
                                    // exp1 - value type, call by value
    // int exv1 = 10;
    // int exv2 = 20;

    // cout << exv1 << " " << exv2 << endl;
    // exp1(exv1, exv2);
    // cout << exv1 << " " << exv2 << endl;



                                    // exp2 - value types, call by ref
    // int e2v1 = 10;
    // int e2v2 = 20;

    // cout << e2v1 << " " << e2v2 << endl;
    // exp2(&e2v1, &e2v2);
    // cout << e2v1 << " " << e2v2 << endl;



                                    // exp3 - ref type, call by val
    // int e3v1 = 10;
    // int e3v2 = 20;
    // int* e3r1 = &e3v1;
    // int* e3r2 = &e3v2;

    // cout << e3v1 << " " << e3v2 << endl;
    // exp3(e3r1, e3r2);   
    // cout << e3v1 << " " << e3v2 << endl;



                                    // exp4 - ref type, call by ref
    int e4v1 = 10;
    int e4v2 = 20;
    int* e4r1 = &e4v1;
    int* e4r2 = &e4v2;

    cout << e4v1 << " " << e4v2 << endl;
    cout << *e4r1 << " " << *e4r2 << endl;
    exp4(&e4r1, &e4r2);
    cout << e4v1 << " " << e4v2 << endl;
    cout << *e4r1 << " " << *e4r2 << endl;
}

















