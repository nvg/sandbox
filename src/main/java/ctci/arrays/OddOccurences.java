package ctci.arrays;

public class OddOccurences {

	public static int findOdd(int[] A) {
		// there are three strategies
		// - naive - O(N^2) - loop through the array
		// - hashing - use a map element counts
		// - best - XOR each element
		int result = 0;
		for (int i = 0; i < A.length; i++) {
			result = result ^ A[i];
		}
		return result;
	}

}
