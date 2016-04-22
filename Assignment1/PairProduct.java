/*
   For Assignment: , Oct 2nd, 2015 
   PairProduct.java
   Programming Assignment 1 - Template for PairProduct


   PairProduct.java
   CSC 225 - Fall 2015
   Programming Assignment 1 - Template for PairProduct
   
   This template includes some testing code to help verify the implementation.
   To interactively provide test inputs, run the program with
	java PairProduct
	
   To conveniently test the algorithm with a large input, create a 
   text file containing space-separated integer values and run the program with
	java PairProduct file.txt
   where file.txt is replaced by the name of the text file.

   B. Bird - 05/01/2014
*/

import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.io.File;

//Do not change the name of the PairUp class
public class PairProduct{
	/* PairProduct225()
		The input array A will contain non-negative integers. The function
		will search the array A for a pair of elements which sum to 225.
		If such a pair is found, return true. Otherwise, return false.
		The function may modify the array A.
		Do not change the function signature (name/parameters).
	*/
	public static boolean PairProduct225(int[] A){
		// there are 9 divisors of 225(1, 3, 5, 9, 15, 25, 45, 75, 225)
		int[] divisor = new int[9];

		//specialCase for divisor of 15
		int specialCase = 0;

		//traverse array A to check divisors
		//put them into array divisor
		for(int i = 0; i < A.length - 1; i++) {
			if(A[i] == 1) {
				divisor[0] = A[i];
			} else if(A[i] == 3) {
				divisor[1] = A[i];
			} else if(A[i] == 5) {
				divisor[2] = A[i];
			} else if(A[i] == 9) {
				divisor[3] = A[i];
			} else if(A[i] == 15) {
				specialCase++;
			} else if(A[i] == 25) {
				divisor[4] = A[i];
			} else if(A[i] == 45) {
				divisor[5] = A[i];
			} else if(A[i] == 75) {
				divisor[6] = A[i];
			} else if(A[i] == 225) {
				divisor[7] = A[i];
			} else {
				continue;
			}
		}

		//check array divisor to determine boolean value
		//true for 225, false for otherwise
		if(divisor[0] * divisor[7] == 225 || divisor[1] * divisor[6] == 225 || divisor[2] * divisor[5] == 255
				|| divisor[3] * divisor[4] == 225) {
			return true;
		} else if(specialCase > 1) {
			return true;
		} else {
			return false;
		}
		
	}

	/* main()
	   Contains code to test the PairProduct225 function. Nothing in this function 
	   will be marked. You are free to change the provided code to test your 
	   implementation, but only the contents of the PairProduct225() function above 
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
		
		boolean pairExists = PairProduct225(array);
		
		long endTime = System.currentTimeMillis();
		
		double totalTimeSeconds = (endTime-startTime)/1000.0;
		
		System.out.printf("Array %s a pair of values which multiply to 225.\n",pairExists? "contains":"does not contain");
		System.out.printf("Total Time (seconds): %.4f\n",totalTimeSeconds);
	}
}
