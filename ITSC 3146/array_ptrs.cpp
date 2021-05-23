#include <iostream>
using namespace std;

int main()
{
    
    int my_ints[4];
    
    //takes input
    for(int x = 0; x < 4; x++)
    {
        cout << "Enter an integer.";
        cin >> my_ints[x];
    }
    
    int *my_ptrs[4];
    
    for(int x = 0; x < 4; x++)
    {
        my_ptrs[x] = &my_ints[x];
    }
    
    //sorts array lowest to highest
    for(int x = 0; x < 4; x++)
    {
        for(int y = x + 1; y < 4; y++)
        {
            if(*my_ptrs[x] > *my_ptrs[y])
            {
                int *temp = my_ptrs[x];
                my_ptrs[x] = my_ptrs[y];
                my_ptrs[y] = temp;
            }
        }
    }
    
    //prints values pointed to
    for(int x = 0; x < 4; x++)
    {
        cout << *my_ptrs[x] << " ";
    }
}