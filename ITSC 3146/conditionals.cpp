#include <iostream>
using namespace std;

int main()
{
    int score;
    
    cout << "Enter a score from 0-100 ";
    cin >> score;
    
    if(score >= 90 && score <= 100)
    {
      cout << "A";  
    }
    else if(score >= 80 && score <= 89)
    {
      cout << "B";  
    }
    else if(score >= 70 && score <= 79)
    {
      cout << "C";  
    }
    else if(score >= 60 && score <= 69)
    {
      cout << "D"; 
    }
    else
    {
        cout << "F";
    }
}