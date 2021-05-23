//
//  QuickSort_Skeleton.cpp
//
//  Created by Bahamon, Julio on 6/25/19.
//  UNC Charlotte
//  Copyright © 2019 Bahamon, Julio. All rights reserved.
//

#include <iostream>
#include <cstdlib>
#include <cstring>

using namespace std;

//  Declaring a new struct to store patient data
struct patient {
    int age;
    char name[20];
    float balance;
};

//FUNCTION THAT DISPLAYS INFORMATION IN THE ARRAY
void display(patient pat[], int length)
{
    for(int x = 0; x < length; x++)
    {
        cout<<"Age: " << pat[x].age << " Name: " << pat[x].name << " Balance Due $: " << pat[x].balance << endl;
    }
}

//  IMPLEMENT A FUNCTION THAT COMPARES TWO PATIENTS BY AGE
int sortAge(const void *first,const void *second)
{
    int x = ((struct patient *)first) -> age;
    int y = ((struct patient *)second) -> age;
    
    if(x < y)
    {
        return -1;
    }
    else if(x == y)
    {
        return 0;
    }
    else 
    {
        return 1;
    }
}

//  IMPLEMENT A FUNCTION THAT COMPARES TWO PATIENTS BY BALANCE DUE
int sortBalance(const void *first,const void *second)
{
    int x = ((struct patient *)first) -> balance;
    int y = ((struct patient *)second) -> balance;
    
    if(x < y)
    {
        return -1;
    }
    else if(x == y)
    {
        return 0;
    }
    else 
    {
        return 1;
    }
}

//  IMPLEMENT A FUNCTION THAT COMPARES TWO PATIENTS BY NAME
int sortName(const void *first,const void *second)
{
    patient *ifirst = ((struct patient *)first);
    patient *isecond = ((struct patient *)second);
    if(strcmp(ifirst -> name, isecond -> name) < 0)
    {
       return -1;
    }
    else if(strcmp(ifirst -> name, isecond -> name) == 0)
    {
        return 0;
    }
    else
    {
        return 1;
    }
}


//  The main program
int main()
{
    int total_patients = 5;
    
    //  Storing some test data
    struct patient patient_list[5] = {
        {25, "Juan Valdez   ", 1250},
        {15, "James Morris  ", 2100},
        {32, "Tyra Banks    ", 750},
        {62, "Maria O'Donell", 375},
        {53, "Pablo Picasso ", 615}
    };
    
    
    cout << "Patient List: " << endl;
    
    display(patient_list, total_patients);
    
    cout << endl;
    
    
    cout << "Sorting..." << endl;
    
    //  CALL THE qsort FUNCTION TO SORT THE ARRAY BY PATIENT AGE
    qsort(patient_list, total_patients, sizeof(patient_list[0]), sortAge);
    
    cout << "Patient List - Sorted by Age: " << endl;
    
    display(patient_list, total_patients);
    
    cout << endl;
    
    
    cout << "Sorting..." << endl;

    //  CALL THE qsort FUNCTION TO SORT THE ARRAY BY PATIENT BALANCE
    qsort(patient_list, total_patients, sizeof(patient_list[0]), sortBalance);
    
    cout << "Patient List - Sorted by Balance Due: " << endl;
    
    display(patient_list, total_patients);
    
    cout << endl;
    
    
    cout << "Sorting..." << endl;

    //  CALL THE qsort FUNCTION TO SORT THE ARRAY BY PATIENT NAME
    qsort(patient_list, total_patients, sizeof(patient_list[0]), sortName);
    
    cout << "Patient List - Sorted by Name: " << endl;
    
    display(patient_list, total_patients);
    
    cout << endl;
    
    return 0;
}
