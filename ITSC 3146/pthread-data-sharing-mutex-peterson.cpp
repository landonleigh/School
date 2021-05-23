#include <iostream>
#include <pthread.h>
#include <stdlib.h>

#define TOTAL_THREADS 2

int count;
int turn;                  // Shared variable, indicates
                           // whose turn it is to execute

bool interested[TOTAL_THREADS];  // Shared variable, indicates
                                 // processes interested in executing

// The thread_id will be either 0 or 1
void enter_region(int thread_id)
{
   int other;                       // ID of the other thread
   
   other = 1 - thread_id;           // The oposite of thread_id
   
   
   //thread's interest to execute
   interested[thread_id] = 1;
   
   //thread's turn to execute next
   turn = thread_id;
   
   //Busy wait until it is the thread's turn to execute
   while(turn == thread_id && interested[other] == 1);
   
}


void leave_region(int thread_id)
{
   //thres exited critical region
   interested[thread_id] = 0;
   
}


void* myFunction(void* arg)
{
	int thread_id = *((int*) arg);
    
	for(unsigned int i = 0; i < 10; ++i) {
        
      //Make sure that the thread waits for its turn
      enter_region(thread_id);
      
      //  Beginning of the critical region
        
      count++;
      std::cout << "Thread #" << thread_id << " count = " << count << std::endl;
      
      //  Random wait - This code is just to ensure that the threads
      //  show data sharing problems
      int max = rand() % 100000;
      
      for (int x = 0; x < max; x++);
      
      // End of random wait code
      
        
      //  End of the critical region
      
      
      //other thread gets a turn
      leave_region(thread_id);  
	}
    
	pthread_exit(NULL);
}


//  HINT: It is not necessary to make any changes in main()
int main()
{
    int rc[TOTAL_THREADS];
    pthread_t ids[TOTAL_THREADS];
    int args[TOTAL_THREADS];
    
    count = 0;
    for(unsigned int i = 0; i < TOTAL_THREADS; ++i) {
        args[i] = i;
        rc[i] = pthread_create(&ids[i], NULL, myFunction, (void*) &args[i]);
    }
    
    for(unsigned int i = 0; i < TOTAL_THREADS; ++i) {
        pthread_join(ids[i], NULL);
    }
    
    std::cout << "Final count = " << count << std::endl;
    pthread_exit(NULL);
}
