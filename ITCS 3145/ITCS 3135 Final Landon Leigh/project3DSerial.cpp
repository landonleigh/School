/*
 * SAXPYSerial1.cpp
 *
 *  Created on: Nov 1, 2020
 *      Author: ITCS 3145
 */
#include <omp.h>
#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <random>
#include <thread>
#include <ctime>
using namespace std;

int randGen(const int& min, const int& max) {
    static thread_local mt19937 generator(hash<thread::id>()(this_thread::get_id())); // @suppress("Ambiguous problem")
    uniform_int_distribution<int> distribution(min, max);
    return distribution(generator);
}

/**
 * Initialize a three-dimension array (matrix3D[dimX][dimY][dimZ]) by random float
 * point values.
 *
 * Input:
 *      float* matrix3D
 *      int dimX:    length of dimension X
 *      int dimY:    length of dimension Y
 *      int dimZ:    length of dimension Z
 * Output:
 *		float* matrix3D
 */
void initial3DSerial(float *matrix3D, int dimX, int dimY, int dimZ) {
	if ((matrix3D == NULL)) return;

	int index;
	for (int x = 0; x < dimX; x++)
		for (int y = 0; y < dimY; y++)
			for (int z = 0; z < dimZ; z++) {
#pragma omp parallel for num_threads(4)
				index = x * dimY * dimZ + y * dimZ + z;//matrix[index] is same as matrix[x][y][z]
				matrix3D[index] = randGen(0, 10);
			}
}

/**
 * Project a three-dimension array (matrix3D[dimX][dimY][dimZ]) to a two-dimension
 * array (project2D[dimX][dimY]) by averaging the matrix3D along the z dimension.
 *
 * Input:
 *      float* matrix3D
 *      int dimX:    length of dimension X
 *      int dimY:    length of dimension Y
 *      int dimZ:    length of dimension Z
 * Output:
 *		float* project2D
 */
void project3DbyZSerial(float *matrix3D, int dimX, int dimY, int dimZ, float* project2D) {
	if ((matrix3D == NULL) || (project2D == NULL)) return;

	float totalXY;
	int index;
	for (int x = 0; x < dimX; x++)
		for (int y = 0; y < dimY; y++) {
			totalXY = 0;
			for (int z = 0; z < dimZ; z++) {
#pragma omp parallel for num_threads(4)
				index = x * dimY * dimZ + y * dimZ + z;//matrix[index] is same as matrix[x][y][z]
				totalXY += matrix3D[index];
			}

			project2D[x * dimY + y] = totalXY / (dimZ + 0.0);
		}
}

/**
 * Print a three-dimension array (matrix3D[dimX][dimY][dimZ])
 *
 * Input:
 *      float* matrix3D
 *      int dimX:    length of dimension X
 *      int dimY:    length of dimension Y
 *      int dimZ:    length of dimension Z
 * Output:
 *		float* matrix3D
 */
void print3DSerial(float *matrix3D, int dimX, int dimY, int dimZ) {
	if ((matrix3D == NULL)) return;

	int index;
	for (int x = 0; x < dimX; x++) {
		for (int y = 0; y < dimY; y++) {
			for (int z = 0; z < dimZ; z++) {
#pragma omp parallel for num_threads(4)
				index = x * dimY * dimZ + y * dimZ + z;//matrix[index] is same as matrix[x][y][z]
				cout << matrix3D[index] << " ";
			}
			cout << endl;
		}
		cout << endl;
	}
}

/**
 * Print a two-dimension array (matrix3D[dimX][dimY][dimZ])
 *
 * Input:
 *      float* matrix2D
 *      int dimX:    length of dimension X
 *      int dimY:    length of dimension Y
 * Output:
 *		float* matrix3D
 */
void print2DSerial(float *matrix2D, int dimX, int dimY) {
	if ((matrix2D == NULL)) return;

	int index;
	for (int x = 0; x < dimX; x++) {
		for (int y = 0; y < dimY; y++) {
#pragma omp parallel for num_threads(4)
			index = x * dimY + y;//matrix[index] is same as matrix[x][y][z]
			cout << matrix2D[index] << " ";
		}
		cout << endl;
	}
}

int main(){
	int dimX, dimY, dimZ;
	float a;
	// Decide the three-dimension array size
	cout << "Please type an integer (less than 10) for dimension X: " << flush;
	scanf("%d", &dimX);

	cout << "Please type an integer (less than 10) for dimension Y: " << flush;
	scanf("%d", &dimY);

	cout << "Please type an integer (less than 10) for dimension Z: " << flush;
	scanf("%d", &dimZ);

	// Generate random vector x and y of n elements
	float *matrix3D = (float *) malloc (dimX * dimY * dimZ * sizeof(float));

	float *project2D = (float *) malloc (dimX * dimY * sizeof(float));

	initial3DSerial(matrix3D, dimX, dimY, dimZ);

	cout << "Matrix 3D:" << endl;
	print3DSerial(matrix3D, dimX, dimY, dimZ);

	project3DbyZSerial(matrix3D, dimX, dimY, dimZ, project2D) ;

	cout << "Average along Z-dimension:" << endl;
	print2DSerial(project2D, dimX, dimY);

	free(matrix3D);
	free(project2D);
	return 0;
}
