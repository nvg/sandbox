package ctci.algs.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class QuickSortTest {

	@Test
	void test() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		int[] check = list.stream().mapToInt(i -> i).toArray();
		Collections.shuffle(list);

		QuickSort s = new QuickSort();
		int[] arr = list.stream().mapToInt(i -> i).toArray();
		s.sort(arr);

		assertArrayEquals(arr, check);
	}

}
