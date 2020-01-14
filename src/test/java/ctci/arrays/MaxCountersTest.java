package ctci.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ctci.arrays.MaxCounters;

class MaxCountersTest {

	@Test
	void test() {
		int[] A = new int[7];
		A[0] = 3;
		A[1] = 4;
		A[2] = 4;
		A[3] = 6;
		A[4] = 1;
		A[5] = 4;
		A[6] = 4;
		
		assertArrayEquals(new int[] { 3, 2, 2, 4, 2 }, new MaxCounters().count(5, A));
		assertArrayEquals(new int[] { 3, 2, 2, 4, 2 }, new MaxCounters().countON(5, A));
	}

}
