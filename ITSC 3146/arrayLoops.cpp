#include <iostream>
using namespace std;

int main()
{
    int a[10];
    
    //takes input
    for(int x = 0; x < 10; x++)
    {
        cout << "Enter an integer.";
        cin >> a[x];
    }
    
    //prints in reverse order
    for(int x = 9; x >= 0; x--)
    {
        cout << a[x] << " ";
    }
    
    //sorts from highest to lowest
    for(int x = 0; x < 10 - 1; x++)
    {
        for(int y = 0; y < 10 - x - 1; y++)
        {
            if(a[y] > a[y + 1])
            {
                int temp = a[y];
                a[y] = a[y + 1];
                a[y + 1] = temp;
            }
        }
    }
    
    cout << endl;
    
    //prints sorted order
    for(int x = 0; x < 10; x++)
    {
        cout << a[x] << " ";
    }
}