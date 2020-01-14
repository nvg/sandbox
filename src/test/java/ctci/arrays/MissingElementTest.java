package ctci.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ctci.arrays.MissingElement;

class MissingElementTest {

	@Test
	void test() {
		int[] A = new int[4];
		A[0] = 2;
		A[1] = 3;
		A[2] = 1;
		A[3] = 5;
		
		MissingElement m = new MissingElement();
		assertEquals(4, m.findMissingInAConsequtiveArray(A));
	}
	
	@Test
	void shouldFindMissingNonConsequtive() {
		 int[] A = new int[] {1, 3, 6, 4, 1, 2};
		 
		 MissingElement m = new MissingElement();
		 assertEquals(5, m.findMissing(A));
	}

}
