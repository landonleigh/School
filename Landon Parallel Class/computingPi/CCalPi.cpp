/*
 ============================================================================
 Name        : CCalPi.c
 Author      : Q. C.
 Version     :
 Copyright   : uncc.cci.cs
 Description : Calculate pi which is
               the summation of 4 * (-1)^i / (2*i+1), where i>=1 and i < n
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <mpi.h>
#include <time.h>
using namespace std;

class PI{
public:
	double computingPiSerial(int n);
	double computingPiByP2PMPI(int n);
	double computingPiByCollectiveMPI(int n);
	double computeLocalSumPi(int n, int rank, int p);
	double computingPiByP2PTreeMPI(int n);
};

int main(int argc, char *argv[]) {
	int n;

	MPI_Init(&argc, &argv);

	//cout << "Please type an integer: " << flush;
	//scanf("%d", &n);
	n = (int) strtol(argv[1], NULL, 10);

	PI pi;
	double sum = pi.computingPiSerial(n);
	printf("Pi is equal to %f\n", sum);

	pi.computingPiByP2PMPI(n);
	pi.computingPiByP2PTreeMPI(n);
	pi.computingPiByCollectiveMPI(n);

	MPI_Finalize();

	return EXIT_SUCCESS;
}

double PI::computeLocalSumPi(int n, int rank, int p){
	double sum = 0;
	double factor;
	int chunk_size = n / p;
	int my_First_Index = rank * chunk_size;


	for (long i = 0; i < chunk_size; i++){
		if ((i + my_First_Index) % 2 == 0){
			factor = 1.0;
		} else {
			factor = -1.0;
		}

		sum += (4 * factor) / (double)(2 * (i + my_First_Index) + 1);
	}

	return sum;
}

double PI::computingPiSerial(int n){
	double sum = 0;
	double factor;

	for (long i = 0; i < n; i++){
		if (i % 2 == 0){
			factor = 1.0;
		} else {
			factor = -1.0;
		}

		sum = sum + 4 * factor / (2*i+1);
	}
	return sum;
}

double PI:: computingPiByP2PMPI(int n){
	double sum = 0;
	int rank, p;

	MPI_Comm_rank(MPI_COMM_WORLD, &rank);
	MPI_Comm_size(MPI_COMM_WORLD, &p);

	int start=clock();

		double my_sum = computeLocalSumPi(n, rank, p);

		int tag = 0;
		if (rank == 0){ // the master task
				sum = my_sum;
				double tmp;
				MPI_Status status;
				for (int source = 1; source < p; source++) {
					MPI_Recv(&tmp, 1, MPI_DOUBLE, source, tag, MPI_COMM_WORLD, &status);
					sum += tmp;
				}
			}
			else{  // worker tasks
				/* create message */
					int dest = 0;
					MPI_Send(&my_sum, 1, MPI_DOUBLE, dest, tag, MPI_COMM_WORLD);
			}

		if(rank == 0){
		int end=clock();
		    cout << "Linear P2P - Time: " << end - start << endl;
		    cout << "Linear P2P - Pi: " << sum << endl;
		}

	return sum;
}

double PI::computingPiByP2PTreeMPI(int n){
	int rank, p;
	MPI_Comm_rank(MPI_COMM_WORLD, &rank);
	MPI_Comm_size(MPI_COMM_WORLD, &p);
	int start=clock();

	double my_sum = computeLocalSumPi(n, rank, p);

	int tag = 1;
	MPI_Status status;
	double sum = my_sum, tmp = 0;

	int iLevel = 0;

	for(int stride = 1; stride < p; stride *= 2){
		if(rank % stride == 0){
			if(rank %(2 *stride) == 0){
				MPI_Recv(&tmp, 1, MPI_DOUBLE, rank + stride, tag,
						MPI_COMM_WORLD, &status);
				sum += tmp;
			} else {
				MPI_Send(&sum, 1, MPI_DOUBLE, rank - stride, tag, MPI_COMM_WORLD);
			}
		}
		iLevel++;
	}
	if(rank == 0){
		int end = clock();

		cout << "Tree P2P - Time: " << end - start << endl;
		cout << "Tree P2P - Pi: " << sum << endl;
	}
	return sum;
}

double PI::computingPiByCollectiveMPI(int n){
	double sum = 0;
	int rank, p;

	int start = clock();

	MPI_Comm_rank(MPI_COMM_WORLD, &rank);
	MPI_Comm_size(MPI_COMM_WORLD, &p);

	double my_sum = computeLocalSumPi(n, rank, p);

	MPI_Reduce(&my_sum, &sum, 1, MPI_DOUBLE, MPI_SUM, 0, MPI_COMM_WORLD);

	if(rank == 0){
		int end = clock();
		cout << "Collective - Time: " << end - start << endl;
		cout << "Collective - Pi: " << sum << endl;
	}

	return sum;
}
