package ctci.arrays;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import ctci.arrays.ZeroSetter;

class ZeroSetterTest {

	@Test
	void test() {
		ZeroSetter s = new ZeroSetter();
		int[][] source = new int[][] { new int[] { 1, 2 }, new int[] { 3, 0 } };
		int[][] target = new int[][] { new int[] { 1, 0 }, new int[] { 0, 0 } };
		assertTrue(Arrays.deepEquals(target, s.setToZeros(source)));

	}

}
