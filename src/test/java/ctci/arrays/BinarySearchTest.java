package ctci.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinarySearchTest {

	@Test
	void shouldFindX() {
		int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		BinarySearch bs = new BinarySearch();
		assertTrue(bs.isPresentRecursive(nums, 9));
		assertFalse(bs.isPresentRecursive(nums, 99));
		
		assertTrue(bs.isPresentIter(nums, 9));
		assertFalse(bs.isPresentIter(nums, 90));
	}

}
