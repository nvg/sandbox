package ctci.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RegionSizeTest {

	private static int[][] matrix = {
			{0, 0, 0, 1, 1, 0, 0},
			{0, 1, 0, 0, 1, 1, 0},
			{1, 1, 0, 1, 0, 0, 1},
			{0, 0, 0, 0, 0, 1, 0},
			{1, 1, 0, 0, 0, 0, 0},
			{0, 0, 1, 0, 0, 0, 0}
	};
	
	@Test
	void testRegion() {
		RegionSize s = new RegionSize();
		assertEquals(7, s.getLargestRegion(matrix));
	}
	
	@Test
	void testAll() {
		RegionSize s = new RegionSize();
		assertEquals(4, s.getLargestRegion(new int[][] { { 1, 1 }, { 1, 1 } }));
		assertEquals(1, s.getLargestRegion(new int[][] { { 1 } }));
	}
	
	@Test
	void testNone() {
		RegionSize s = new RegionSize();
		assertEquals(0, s.getLargestRegion(new int[][] { { 0, 0 }, { 0, 0 } }));
		assertEquals(0, s.getLargestRegion(new int[][] { { 0 } }));
	}

}
