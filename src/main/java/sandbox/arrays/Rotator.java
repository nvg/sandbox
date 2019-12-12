package sandbox.arrays;

public class Rotator {

	private int getGCD(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return getGCD(b, a % b);
		}
	}

	/**
	 * <pre>
	 * Options:
	 *    1. Bubble rotate - O(N^2) - rotate one element and repeat n times 
	 *    2. Temp array - copy the elements 
	 *    3. Reversal algorithm
	 *        rev(a[], l, n);
	 *        rev(a[], 1, n-d); rev(a[], n - d + 1, n); 
	 *    4. Juggling algorithm
	 * </pre>
	 */
	public int[] rotateLeft(int[] array, int d) {
		int i, j, k, temp;
		final int n = array.length;

		int gcd = getGCD(d, n);
		for (i = 0; i < gcd; i++) {
			/* move i-th values of blocks */
			temp = array[i];
			j = i;
			while (true) {
				k = j + d;
				if (k >= n) {
					k = k - n;
				}
				if (k == i) {
					break;
				}
				array[j] = array[k];
				j = k;
			}
			array[j] = temp;
		}
		return array;
	}

	public int[][] rotate(int[][] matrix) {
		// implement rotation in layers
		// perform circular rotation top edge to right,
		// right edge to bottom, bottom to left, left to top
		for (int layer = 0; layer < matrix.length / 2; layer++) {
			int first = layer;
			int last = matrix.length - layer - 1;

			for (int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i]; // save top
				matrix[first][i] = matrix[last - offset][first]; // left -> top
				matrix[last - offset][first] = matrix[last][last - offset]; // bottom -> left
				matrix[last][last - offset] = matrix[i][last]; // right -> bottom
				matrix[i][last] = top; // saved top -> right
			}
		}

		return matrix;
	}

}
