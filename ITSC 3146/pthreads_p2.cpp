/*
 @file: pthreads_skeleton.cpp
 
 @author: student name1, student2@uncc.edu
 @author: student name2, student2@uncc.edu
 @author: student name3, student3@uncc.edu
 
 @description: A program that demonstrates processes.
 
 @course: ITSC 3146
 @assignment: in-class activity [n]
 */

#include <pthread.h>
#include <iostream>

using namespace std;

//global array
int arr[10];

//counts negatives in array
void *countNegatives(void*)
{
   int negatives = 0;
   
   for(int x = 0; x < 10; x++)
   {
      if(arr[x] < 0)
      {
         negatives++;
      }
   }
   cout << "Total negative numbers: " << negatives << endl << endl;
}

//calculates average of numbers in array
void *average(void*)
{
   int sum = 0;
   
   for(int x = 0; x < 10; x++)
   {
      sum += arr[x];  
   }
   cout << "Average:" << sum / 10.0 << endl << endl;
}

//prints array in reverse order
void *reverse(void*)
{
   cout <<  "Array in reverse: " << endl;
   for(int x = 9; x >= 0; x--)
   {
      cout << arr[x] << " " << endl;
   }
   cout << endl;
}


int main()
{
   // id is used to store a unique thread identifier,
   // returned by the call to create a new POSIX thread
   pthread_t thread1, thread2, thread3;
   
   // rc is used to store the code returned by the
   // call to create a new POSIX thread. The value is
   // zero (0) if the call succeeds.
   int rc;
   
   for(int x = 0; x < 10; x++)
   {
      cout << "Enter a number: ";
      cin >> arr[x];
   }

   //thread to print in reverse
   rc = pthread_create(&thread3, NULL, reverse, NULL);
   
   //thread to calculate average
   rc = pthread_create(&thread2, NULL, average, NULL);
   
   //thread to count negatives
   rc = pthread_create(&thread1, NULL, countNegatives, NULL);
   
   if (rc){
      cout << "ERROR; return code from pthread_create() is " << rc << endl;
      return -1;
   }


   // NOTE: Using exit here will immediately end execution of all threads
   pthread_exit(0);
}
