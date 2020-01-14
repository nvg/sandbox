package ctci.arrays;

public class ZeroSetter {

	public int[][] setToZeros(int[][] matrix) {
		boolean[] zeroRows = new boolean[matrix.length];
		boolean[] zeroCols = new boolean[matrix[0].length];

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (matrix[row][col] == 0) {
					zeroRows[row] = true;
					zeroCols[col] = true;
				}
			}
		}

		for (int row = 0; row < zeroRows.length; row++) {
			if (zeroRows[row]) {
				for (int col = 0; col < matrix[0].length; col++) {
					matrix[row][col] = 0;
				}
			}
		}

		for (int col = 0; col < zeroCols.length; col++) {
			if (zeroCols[col]) {
				for (int row = 0; row < matrix.length; row++) {
					matrix[row][col] = 0;
				}
			}
		}
		
		return matrix;
	}

}
