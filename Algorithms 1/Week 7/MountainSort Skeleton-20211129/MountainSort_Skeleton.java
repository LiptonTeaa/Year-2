import java.util.Arrays;
import java.util.stream.IntStream;
import java.lang.Math;

public class MountainSort_Skeleton {

	public static void main(String[] args) {

		// Multiple sets of arrays to test the sort function

		//int[] A= {34, 12, 7, 43, 55, 41, 97, 28, 2, 62};
		//int[] A= {-34, -12, -7, -43, -55, -41, -97, -28, -2, -62, -44, -3, -23, -88, -70};
		//int[] A= {12, 12, 12, 12, 12, 12, 12, 12, 12, 12};
		int[] A= {14, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 10};

		System.out.println("Original array: " + Arrays.toString(A));
		System.out.println();

		A = MountainSort(A);

		System.out.println();
		System.out.println("Array sorted: " + Arrays.toString(A));
	}

	public static int[] MountainSort(int[] A) {

		// Error handler for empty array
		if (A.length == 0){

			return A;

		}
		else {
			// Mountain sort below

			//System.out.println(Arrays.toString(array));

			int maxIndex = Arrays.stream(A).max().getAsInt(); // Highest value
			int minIndex = Arrays.stream(A).min().getAsInt(); // Lowest value
			int range = maxIndex - minIndex + 1; // The numbers it has to count between highest and lowest value
			int midPoint = (int) Math.floor(A.length/2); // Mid of array
			int count[] = new int[range];
			int output[] = new int[A.length];

			for (int i = 0; i < A.length; i++) {

				// Counts every number between lowest to the highest value and counts how many times each number appears
				// in that given range.
				count[A[i] - minIndex]++;

				// Counting all the way from the lowest value to the highest
				System.out.println(Arrays.toString(count));

			}

			for (int i = 1; i < count.length; i++) {

				// Decrementing each index value by one to account for index value 0
				count[i] = count[i] + count[i - 1];

			}

			for (int i = A.length - 1; i >= 0; i--) {
				
				output[count[A[i] - minIndex] - 1] = A[i];
				count[A[i] - minIndex]--;

			}

			for (int i = 0; i < A.length; i++) {

				// Putting the output back into the original array
				A[i] = output[i];

			}

			// from the middle of the array, sort largest to smallest

			int j = A.length - 1 ;

			for(int l = midPoint; l < A.length; l++) {

				if (A[j] < A[l]) {

					int temp = A[j];
					A[j] = A[l];
					A[l] = temp;

				}

				j--;
			}
		}

		return A;

	}

	//you can add your own functions if you want

}
