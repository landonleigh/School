/*
 * GlobalSum.cpp
 *
 *  Created on: Oct 11, 2020
 *      Author: Qiong
 */

#include <iostream>
#include <mpi.h>
#include <ctime>

using namespace std;

class Sum{
public:
	int globalSumSerial(int first, int end);
	int MPIGlobalSum(int first, int end);
	int globalSumMPIReduce(int first, int last);
	int globalSumMPITree(int first, int last);

private:
	int calculateLocalSum(int first, int last, int rank, int p);
};

int Sum::globalSumSerial(int first, int last){
	int start=clock();

	int sum = 0;
	for (int i = first; i <= last; i++)
		sum += i;

	int end=clock();

	 cout << "Global Sum in serial takes " << (end - start)
	            << " clicks (" << ((end-start)/CLOCKS_PER_SEC) << " seconds)\n";

	return sum;
}

int Sum::calculateLocalSum(int first, int last, int rank, int p){
	int sum = 0;
	int chunk_size = (last - first + p) / p;
	int my_First_Index = rank * chunk_size;
	//int my_Last_Index = my_First_Index + chunk_size - 1;
	int my_first = first + my_First_Index;
	int my_last = (my_first + chunk_size - 1 > last) ? last: my_first + chunk_size - 1;

	for(int i = my_first; i <= my_last; i++){
		sum += i;
	}

	//cout << "chunk_size: " << chunk_size << " my_first: " << my_first
			//<< " my_last: " << my_last << " my_sum: " << sum << endl;

	return sum;
}

int Sum::MPIGlobalSum(int first, int last){
	int sum = 0;
	int rank, p;
	MPI_Init(NULL, NULL);
	MPI_Comm_rank(MPI_COMM_WORLD, &rank);
	MPI_Comm_size(MPI_COMM_WORLD, &p);

	int start=clock();

	int my_sum = calculateLocalSum(first, last, rank, p);

	int tag = 0;
	if (rank == 0){ // the master task
			printf("Hello From process 0: Num processes: %d\n",p);
			sum = my_sum;
			int tmp;
			MPI_Status status;
			for (int source = 1; source < p; source++) {
				MPI_Recv(&tmp, 1, MPI_INT, source, tag, MPI_COMM_WORLD, &status);
				sum += tmp;
			}
			cout << "Rank: " << rank << " Global sum (parallel version) from " << first
					<< " to " << last << ": " << sum << endl;
		}
		else{  // worker tasks
			/* create message */
				int dest = 0;
				MPI_Send(&my_sum, 1, MPI_INT, dest, tag, MPI_COMM_WORLD);
		}

	if(rank == 0){
	int end=clock();
	    cout << "Global Sum in parallel (linear) takes " << (end - start)
	        << " clicks (" << ((end-start)/CLOCKS_PER_SEC)
	        << " seconds, " << ((end-start)/CLOCKS_PER_SEC*1000) << "milliseconds)\n";
	}
	MPI_Finalize();

	return sum;
}

int Sum::globalSumMPITree(int first, int last){
	int rank, p;
	MPI_Comm_rank(MPI_COMM_WORLD, &rank);
	MPI_Comm_size(MPI_COMM_WORLD, &p);
	int start=clock();
	int my_sum = calculateLocalSum(first, last, rank, p);

	int tag = 1;
	MPI_Status status;
	int sum = my_sum, tmp = 0;

	int iLevel = 0;

	for(int stride = 1; stride < p; stride *= 2){
		if(rank % stride == 0){
			if(rank %(2 *stride) == 0){
				MPI_Recv(&tmp, 1, MPI_INT, rank + stride, tag,
						MPI_COMM_WORLD, &status);
				sum += tmp;
			} else {
				MPI_Send(&sum, 1, MPI_INT, rank - stride, tag, MPI_COMM_WORLD);
			}
		}
		iLevel++;
	}
	if(rank == 0){
		cout << "Sum in parallel (tree) from " << first << " to " << last
				<< " is equal to " << sum << endl;
		int end = clock();
		cout << "Global Sum in parallel (linear) takes " << (end - start)
				<< " clicks(" << ((end-start) * 1000 / (CLOCKS_PER_SEC + 0.0))
				<< " milliseconds)\n";
	}
	return sum;
}

int Sum::globalSumMPIReduce(int first, int last){
	int sum = 0;

	MPI_Init(NULL, NULL);

	time_t start = clock();
	int rank, p;
	MPI_Comm_rank(MPI_COMM_WORLD, &rank);
	MPI_Comm_size(MPI_COMM_WORLD, &p);

	int my_sum = calculateLocalSum(first, last, rank, p);

	MPI_Reduce(&my_sum, &sum, 1, MPI_INT, MPI_SUM, 0, MPI_COMM_WORLD);

	if(rank == 0){
		time_t end = clock();
		cout << "Global sum (MPI Reduce) takes " << (end - start) << "clock clicks" << endl;
		cout << "Sum = " << sum << endl;
	}

	MPI_Finalize();

	return sum;
}

int main(int argc, char *argv[]){
	// Preparation
	int first = (int) strtol(argv[1], NULL, 10);
	int last = (int) strtol(argv[2], NULL, 10);

	Sum sum;
	//cout << "Sum in serial from " << first << " to " << last
			//<< " is equal to " << sum.globalSumSerial(first, last) << endl;
	sum.MPIGlobalSum(first, last);

	return 0;
}
