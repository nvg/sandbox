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
	void test() {
		RegionSize s = new RegionSize();
		assertEquals(7, s.getLargestRegion(matrix));
	}

}
