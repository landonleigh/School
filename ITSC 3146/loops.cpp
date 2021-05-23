#include <iostream>
using namespace std;

int main()
{
    int positive, negative, zero, sum, average, number= 0;
    
    for (int x = 0; x < 10; x++)
    {
        cout << "Enter a number";
        cin >> number;
        
        if (number > 0)
        {
            positive++;
        }
        if (number < 0)
        {
            negative++;
        }
        if (number == 0)
        {
            zero++;
        } 
        
        sum += number;
    }
    
    average = sum / 10;
    
    cout << "Amount of positive numbers: " << positive << endl;
    cout << "Amount of negative numbers: " << negative << endl;
    cout << "Amount of zeros: " << zero << endl;
    cout << "Sum of numbers: " << sum << endl;
    cout << "Average of numbers : " << average;
}