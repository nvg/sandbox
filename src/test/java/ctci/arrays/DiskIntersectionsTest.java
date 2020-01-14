package ctci.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ctci.arrays.DiskIntersections;

class DiskIntersectionsTest {

	@Test
	void shouldComputeNumberOfIntersections() {
		int[] A = new int[6];
		A[0] = 1;
		A[1] = 5;
		A[2] = 2;
		A[3] = 1;
		A[4] = 4;
		A[5] = 0;

		DiskIntersections d = new DiskIntersections();
		assertEquals(11, d.calculate(A));
	}

}
