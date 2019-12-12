package sandbox.arrays;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class RotatorTest {

	@Test
	public void shouldRotateMatrix() {
		Rotator r = new Rotator();
		int[][] source = new int[][] { new int[] { 1, 2 }, new int[] { 3, 4 } };
		int[][] target = new int[][] { new int[] { 3, 1 }, new int[] { 4, 2 } };
		assertTrue(Arrays.deepEquals(target, r.rotate(source)));

		source = new int[][] { new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 }, new int[] { 7, 8, 9 } };
		target = new int[][] { new int[] { 7, 4, 1 }, new int[] { 8, 5, 2 }, new int[] { 9, 6, 3 } };
		assertTrue(Arrays.deepEquals(target, r.rotate(source)));
	}
	
	@Test
	public void shouldRotateArray() {
		Rotator r = new Rotator();
		
		int[] source = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int[] target = new int [] {4, 5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3};
		
		assertArrayEquals(target, r.rotateLeft(source, 3));
		
		source = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		target = new int [] {4, 5, 6, 7, 8, 9, 10, 11, 1, 2, 3};
		
		assertArrayEquals(target, r.rotateLeft(source, 3));
		
		source = new int[] {3, 8, 9, 7, 6};
		target = new int[] {9, 7, 6, 3, 8};
		
		assertArrayEquals(target, r.rotateLeft(source, 2));

	}

}
