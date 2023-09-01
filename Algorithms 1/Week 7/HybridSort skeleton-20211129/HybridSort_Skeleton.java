import java.util.*;

public class HybridSort_Skeleton {

	public static void main(String[] args) {

		// Multiple sets of arrays to test on

		//int[] A = {10, 5, 3, 9, 8, 7, 6};
		//int[] A = {10, -5, 3, -9, 8, 7, 6};
		//int[] A = {2, 2, 2, 2, 2, 2, 2};
		//int[] A = {9, 8, 8, 7, 6};
		int[] A = {9, -8, -8, -7, 6, -10, 5};

		System.out.println("Original array: " + Arrays.toString(A));
		System.out.println();

		A = hybridSort(A);

		System.out.println("Array sorted: " + Arrays.toString(A));
		System.out.println();
	}

	public static int[] hybridSort(int[] A) {

		int n = A.length - 1;
		boolean toSwap = true;
		int temp;
		int j = 0;
		int p = 0;

		while (toSwap) {

			// Starting our insertion sort value after the sorted part on the right
			int minVal = A[j];
			int minIndex = j;
			System.out.println("j is " + j);

				toSwap = false;
				for (int i = 0; i < n; i++) {

					if (A[i] > A[i + 1]) {

						//Swap for bubble sort
						temp = A[i];
						A[i] = A[i + 1];
						A[i + 1] = temp;

						toSwap = true;
						System.out.println("Bubble " + Arrays.toString(A));

						// Checking bubble sort comparisons for minimum value to give to insertion sort
						if (A[i] < A[j]) {
							minVal = A[i];
							minIndex = i;
							System.out.println("Min value is " + minVal + " at index " + minIndex);
						}

					}
				}

				// Swap the smallest element found in the current pass of bubble sort with the element in
				// index position j on the right side of the array

				int temp2 = A[minIndex];
				A[minIndex] = A[j];
				A[j] = temp2;
				System.out.println("Insertion " + Arrays.toString(A));
					j++;
				// J increments only after each pass is complete

				n--;
				p++; //Pass counter
				System.out.println("Pass Number " + p);
		}

		return A;

	}

}
