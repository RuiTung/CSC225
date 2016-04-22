/* 
   For Assignment: , Oct 30, 2015 
   HeapSort.java
   Assignment 3 - Template for Heap Sort

   HeapSort.java
   CSC 225 - Fall 2015
   Assignment 3 - Template for Heap Sort
   
   This template includes some testing code to help verify the implementation.
   To interactively provide test inputs, run the program with
	java HeapSort

   To conveniently test the algorithm with a large input, create a 
   text file containing space-separated integer values and run the program with
	java HeapSort file.txt
   where file.txt is replaced by the name of the text file.

   M. Simpson & B. Bird - 11/16/2015
*/

import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.io.File;
import java.util.Arrays;

//Do not change the name of the HeapSort class
public class HeapSort{
	/* HeapSort(A)
		Sort the array A using heap sort.
		You may add additional functions (or classes) if needed, but the entire program must be
		contained in this file. 

		Do not change the function signature (name/parameters).
	*/
	public static void HeapSort(int[] A){

		int heapSize = 0;
		int[] heapSort = new int[A.length + 1];

		for(int i = 0; i < A.length; i++) {

			// the index of heap is from 1
			heapSort[i + 1] = A[i];

			/*	when insert an element, check values of integer 
			   	inorder to sort the heap
			   	parent index: index / 2
			   	left element index: index * 2
			   	right element index: index * 2 + 1
			*/
			int j = i + 1;
			while(heapSort[j / 2] > heapSort[j] && j / 2 >= 1) {
				int temp = heapSort[j];
				heapSort[j] = heapSort[j / 2];
				heapSort[j / 2] = temp;
				j = j / 2;

			}
			heapSize++;
		}
		
		/*	pop the minimum value which is the top of the heap
			and then add it to the array.
		*/
		for(int i = 0; i < A.length; i++) {
			A[i] = heapSort[1];
			heapSort[1] = heapSort[heapSize];
			heapSort[heapSize] = 0;
			heapSize--;

			/*	after pop the minimum value from the top of the heap
				rearrange the heap according to the value
			*/
			int j = 1;
			while(j * 2 <= heapSize) {
				if(heapSort[j * 2 + 1] < heapSort[j * 2] && j * 2 + 1 <= heapSize) {
					j = (j * 2 + 1) / 2;
				}
				if(heapSort [j * 2] >= heapSort[j]) {
					break;
				} else {
					int temp = heapSort[j];
					heapSort[j] = heapSort[j * 2];
					heapSort[j * 2] = temp;
				}
				j = j * 2;
			}

		}
		
	}

	/* main()
	   Contains code to test the HeapSort function. Nothing in this function 
	   will be marked. You are free to change the provided code to test your 
	   implementation, but only the contents of the HeapSort() function above 
	   will be considered during marking.
	*/
	public static void main(String[] args){
		Scanner s;
		if (args.length > 0){
			try{
				s = new Scanner(new File(args[0]));
			} catch(java.io.FileNotFoundException e){
				System.out.printf("Unable to open %s\n",args[0]);
				return;
			}
			System.out.printf("Reading input values from %s.\n",args[0]);
		}else{
			s = new Scanner(System.in);
			System.out.printf("Enter a list of non-negative integers. Enter a negative value to end the list.\n");
		}
		Vector<Integer> inputVector = new Vector<Integer>();

		int v;
		while(s.hasNextInt() && (v = s.nextInt()) >= 0)
			inputVector.add(v);

		int[] array = new int[inputVector.size()];

		for (int i = 0; i < array.length; i++)
			array[i] = inputVector.get(i);

		System.out.printf("Read %d values.\n",array.length);


		long startTime = System.currentTimeMillis();

		HeapSort(array);

		long endTime = System.currentTimeMillis();

		double totalTimeSeconds = (endTime-startTime)/1000.0;

		//Don't print out the values if there are more than 100 of them
		if (array.length <= 100){
			System.out.println("Sorted values:");
			for (int i = 0; i < array.length; i++)
				System.out.printf("%d ",array[i]);
			System.out.println();
		}

		//Check whether the sort was successful
		boolean isSorted = true;
		for (int i = 0; i < array.length-1; i++)
			if (array[i] > array[i+1])
				isSorted = false;

		System.out.printf("Array %s sorted.\n",isSorted? "is":"is not");
		System.out.printf("Total Time (seconds): %.2f\n",totalTimeSeconds);
	}
}
