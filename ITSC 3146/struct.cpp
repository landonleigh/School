#include <iostream>
#include<cmath>
using namespace std;

struct Point
{
    double x;
    double y;
};

double calculateDistance(Point *p1, Point *p2)
{
    double distance;
    
    distance = sqrt(((p2->x - p1->x) * (p2->x - p1->x)) + ((p2->y - p1->y) * (p2->y - p1->y)));
    
    return distance;
}

int main()
{
    Point p1;
    Point p2;
    
    //creates point 1
    cout << "Enter x value for point 1: ";
    cin >> p1.x;
    
    cout << "Enter y value for point 1: ";
    cin >> p1.y;
    
    //creates point 2
    cout << "Enter x value for point 2: ";
    cin >> p2.x;
    
    cout << "Enter y value for point 2: ";
    cin >> p2.y;
    
    //calculates distance
    double distance = calculateDistance(&p1, &p2);
    
    //prints result
    cout << "The distance between the points is: " << distance;
}