package sandbox.arrays;

public class Rotator {

	public int[][] rotate(int[][] matrix) {
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
