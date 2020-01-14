package ctci.arrays;

public class TapeEquilibrium {

	/*
	 * A non-empty array A consisting of N integers is given. Array A represents
	 * numbers on a tape. Any integer P, such that 0 < P < N, splits this tape into
	 * two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N −
	 * 1].
	 * 
	 * Write a function: that, given a non-empty array A of N integers, returns the
	 * minimal difference that can be achieved.
	 */
	public int findEquilibrium(int[] A) {
		int sum1 = A[0];
		int sum2 = 0;
		
		for (int i = 1; i < A.length; i++) {
			sum2 += A[i];
		}
		int diff = Math.abs(sum1 - sum2);

		for (int P = 1, N = A.length; P < N - 1; P++) {
			sum1 += A[P];
			sum2 -= A[P];

			int newDiff = Math.abs(sum1 - sum2);
			if (newDiff < diff) {
				diff = newDiff;
			}
		}
		return diff;
	}

}
