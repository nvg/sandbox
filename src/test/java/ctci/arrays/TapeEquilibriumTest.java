package ctci.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ctci.arrays.TapeEquilibrium;

class TapeEquilibriumTest {

	@Test
	void test() {
		int[] A = new int[5];
		A[0] = 3;
		A[1] = 1;
		A[2] = 2;
		A[3] = 4;
		A[4] = 3;

		TapeEquilibrium t = new TapeEquilibrium();
		assertEquals(1, t.findEquilibrium(A));
	}

}
