#include <iostream>
using namespace std;

void swapInts(int *num1, int *num2)
{
    int temp;
    temp = *num1;
    *num1 = *num2;
    *num2 = temp;
}

int main()
{
    int num1, num2;
    
    cout << "Enter an integer: ";
    cin >> num1;
    
    cout << "Enter another integer: ";
    cin >> num2;

    swapInts(&num1, &num2);
  
    cout << "First number after swap: " << num1 << endl;
    cout << "Second number after swap: " << num2;
}

