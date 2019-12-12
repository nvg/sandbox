package sandbox.arrays;

import java.math.BigInteger;
import java.util.Arrays;

public class MissingElement {

	/*
	 * An array A consisting of N different integers is given. The array contains
	 * integers in the range [1..(N + 1)], which means that exactly one element is
	 * missing.
	 * 
	 * Your goal is to find that missing element.
	 */
	public int findMissingInAConsequtiveArray(int[] A) {
		// deal with the offsets
		BigInteger n = BigInteger.valueOf(A.length + 1);
		BigInteger n1 = BigInteger.valueOf(A.length + 2);

		BigInteger result = n.multiply(n1).divide(BigInteger.TWO);
		for (int i : A) {
			result = result.subtract(BigInteger.valueOf(i));
		}
		return result.abs().intValue();
	}

	/*
	 * Given an array A of N integers, returns the smallest positive integer
	 * (greater than 0) that does not occur in A. *
	 */
	public int findMissing(int[] A) {
		Arrays.parallelSort(A);
		
		int min = 1;
		for (int i : A) {
			if (i == min) {
				min++;
			}
		}
		return min;
	}

}
