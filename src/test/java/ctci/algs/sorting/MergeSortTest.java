package ctci.algs.sorting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class MergeSortTest {

	@Test
	void test() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		int[] check = list.stream().mapToInt(i -> i).toArray();
		Collections.shuffle(list);

		MergeSort s = new MergeSort();
		int[] arr = list.stream().mapToInt(i -> i).toArray();
		s.sort(arr);

		assertArrayEquals(arr, check);
	}
}
