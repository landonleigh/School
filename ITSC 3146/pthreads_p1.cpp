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

#define THREADS 4

const char* my_messages[4] = {"English: Hello!", "French: Bonjour!", "Spanish: Hola!", "German: Guten Tag!"};

//print message in my_messages
void *printMessage(void *arg)
{
   //type cast
   int*index = (int*)arg;
   cout << my_messages[*index] << endl;
   return 0;
}


int main()
{
   // id is used to store a unique thread identifier,
   // returned by the call to create a new POSIX thread
   pthread_t id[THREADS];
   
   // rc is used to store the code returned by the
   // call to create a new POSIX thread. The value is
   // zero (0) if the call succeeds.
   int rc;
   
   int a[] = {0, 1, 2, 3};
   
   for(int x = 0; x < THREADS; x++)
   {
      rc = pthread_create(&id[x], NULL, printMessage, (void*)(a + x));
      
      if (rc){
         cout << "ERROR; return code from pthread_create() is " << rc << endl;
         return -1;
      }
   }
   
   for(int x = 0; x < THREADS; x++)
   {
      pthread_join( id[x], NULL );
   }

   // NOTE: Using exit here will immediately end execution of all threads
   pthread_exit(0);
}
