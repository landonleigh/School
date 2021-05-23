/* File:    odd_even_serial.c
 *
 * Purpose: Use odd-even transposition sort to sort a list of ints.
 *
 * Compile: gcc -g -Wall -o odd_even_serial odd_even_serial.c
 * Run:     odd_even_serial <n> <g|i>
 *             n:   number of elements in list
 *            'g':  generate list using a random number generator
 *            'i':  user input list
 *
 * Input:   list (optional)
 * Output:  sorted list
 *
 */
#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#ifdef _OPENMP
#include <omp.h>
#endif

/* Keys in the random list in the range 0 <= key < RMAX */
const int RMAX = 100;

void Usage(char* prog_name);
void Get_args(int argc, char* argv[], int* n_p, char* g_i_p);
void Generate_list(int a[], int n);
void Print_list(int a[], int n, char* title);
void Read_list(int a[], int n);
void Odd_even_sort(int a[], int n);

/*-----------------------------------------------------------------*/
int main(int argc, char* argv[]) {
   int  n;
   char g_i;
   int* a;


   Get_args(argc, argv, &n, &g_i);
   a = (int*) malloc(n*sizeof(int));
   if (g_i == 'g') {
      Generate_list(a, n);
      Print_list(a, n, "Before sort");
   } else {
      Read_list(a, n);
   }

   Odd_even_sort(a, n);

   Print_list(a, n, "After sort");

   free(a);
   return 0;
}  /* main */


/*-----------------------------------------------------------------
 * Function:  Usage
 * Purpose:   Summary of how to run program
 */
void Usage(char* prog_name) {
   fprintf(stderr, "usage:   %s <n> <g|i>\n", prog_name);
   fprintf(stderr, "   n:   number of elements in list\n");
   fprintf(stderr, "  'g':  generate list using a random number generator\n");
   fprintf(stderr, "  'i':  user input list\n");
}  /* Usage */


/*-----------------------------------------------------------------
 * Function:  Get_args
 * Purpose:   Get and check command line arguments
 * In args:   argc, argv
 * Out args:  n_p, g_i_p
 */
void Get_args(int argc, char* argv[], int* n_p, char* g_i_p) {
   if (argc != 3 ) {
      Usage(argv[0]);
      exit(0);
   }
   *n_p = atoi(argv[1]);
   *g_i_p = argv[2][0];

   if (*n_p <= 0 || (*g_i_p != 'g' && *g_i_p != 'i') ) {
      Usage(argv[0]);
      exit(0);
   }
}  /* Get_args */


/*-----------------------------------------------------------------
 * Function:  Generate_list
 * Purpose:   Use random number generator to generate list elements
 * In args:   n
 * Out args:  a
 */
void Generate_list(int a[], int n) {
   int i;

   srand(0);
   for (i = 0; i < n; i++)
      a[i] = rand() % RMAX;
}  /* Generate_list */


/*-----------------------------------------------------------------
 * Function:  Print_list
 * Purpose:   Print the elements in the list
 * In args:   a, n
 */
void Print_list(int a[], int n, char* title) {
   int i;

   printf("%s:\n", title);
   for (i = 0; i < n; i++)
      printf("%d ", a[i]);
   printf("\n\n");
}  /* Print_list */


/*-----------------------------------------------------------------
 * Function:  Read_list
 * Purpose:   Read elements of list from stdin
 * In args:   n
 * Out args:  a
 */
void Read_list(int a[], int n) {
   int i;

   printf("Please enter the elements of the list\n");
   for (i = 0; i < n; i++)
      scanf("%d", &a[i]);
}  /* Read_list */


/*-----------------------------------------------------------------
 * Function:     Odd_even_sort
 * Purpose:      Sort list using odd-even transposition sort
 * In args:      n
 * In/out args:  a
 */
void Odd_even_sort(
      int  arr[]  /* in/out */,
      int  n    /* in     */) {
   int phase, i, temp;
   int sorted = 0;

   for (phase = 0; phase < n; phase++) {
	   sorted = 1;
      if (phase % 2 == 0) { /* Even phase */
#pragma omp parallel for private(i, temp) shared(arr, n) num_threads(4)
         for (i = 1; i < n; i += 2)
            if (arr[i-1] > arr[i]) {
               temp = arr[i];
               arr[i] = arr[i-1];
               arr[i-1] = temp;
               sorted = 0;
            }
      } else { /* Odd phase */
#pragma omp parallel for private(i, temp) shared(arr, n) num_threads(4)
         for (i = 1; i < n-1; i += 2)
            if (arr[i] > arr[i+1]) {
               temp = arr[i];
               arr[i] = arr[i+1];
               arr[i+1] = temp;
               sorted = 0;
            }
      }
      if (sorted) break;
   }
}  /* Odd_even_sort */