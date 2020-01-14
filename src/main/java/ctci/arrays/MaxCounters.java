package ctci.arrays;

import java.util.Arrays;

public class MaxCounters {

	/*
	 * You are given N counters, initially set to 0, and you have two possible
	 * operations on them:
	 * 
	 * increase(X) − counter X is increased by 1, max counter − all counters are set
	 * to the maximum value of any counter. A non-empty array A of M integers is
	 * given. This array represents consecutive operations:
	 * 
	 * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X), if A[K] =
	 * N + 1 then operation K is max counter.
	 */
	public int[] count(int N, int[] A) {
		int[] result = new int[N];
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] >= 1 && A[i] <= N) {
				result[A[i] - 1] += 1;
				max = Math.max(max, result[A[i] - 1]);
			} else if (A[i] == N + 1) {
				Arrays.fill(result, max); // makes it O(N^2) in the worst case
			} else {
				throw new IllegalArgumentException("Unexpected operator " + i);
			}
		}
		return result;
	}

	public int[] countON(int N, int[] A) {
		int currentMax = 0;
		int lastUpdate = 0;
		int result[] = new int[N];

		for (int i = 0; i < A.length; i++) {
			int currentValue = A[i];

			if (currentValue == N + 1) {
				lastUpdate = currentMax;
				continue;
			}
			
			int position = currentValue - 1;
			if (result[position] < lastUpdate) {
				result[position] = lastUpdate + 1;
			} else {
				result[position]++;
			}
			
			currentMax = Math.max(result[position], currentMax);
		}

		for (int i = 0; i < N; i++) {
			if (result[i] < lastUpdate) {
				result[i] = lastUpdate;
			}
		}

		return result;
	}

}
