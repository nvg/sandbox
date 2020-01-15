package ctci.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatricesTest {

	@Test
	void test() {
		int[][] A = new int[][] {
				new int[] {1, 1, 1, 1}
		};
		int[][] B = new int[][] {
			new int[] {1},
			new int[] {1},
			new int[] {1},
			new int[] {1}
		};
		
		assertArrayEquals(new int[][] {new int[] {4}}, Matrices.multiply(A, B));
	}

}
