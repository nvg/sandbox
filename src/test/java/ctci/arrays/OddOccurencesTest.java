package ctci.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ctci.arrays.OddOccurences;

class OddOccurencesTest {

	@Test
	void test() {
		int[] A = new int[] {9, 3, 9, 3, 9, 7, 9};
		assertEquals(7,  OddOccurences.findOdd(A));
	}

}
