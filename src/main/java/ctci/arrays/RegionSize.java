package ctci.arrays;

public class RegionSize {

	public int getRegionsSize(int[][] matrix, int row, int col) {
		// checking bounds here helps keeping the code clean
		boolean isOutOfBounds = row < 0 
				|| col < 0 
				|| row >= matrix.length 
				|| col >= matrix[row].length;
		if (isOutOfBounds) {
			return 0;
		}

		if (matrix[row][col] == 0) {
			return 0;
		}
		matrix[row][col] = 0; // we destory the original matrix 

		int size = 1;
		for (int r = row - 1; r <= row + 1; r++) {
			for (int c = col - 1; c <= col + 1; c++) {
//				if (r == row && r == col) { // avoid counting self
//					continue;
//				}
				
				size += getRegionsSize(matrix, r, c);
			}
		}
		return size;
	}

	public int getLargestRegion(int[][] matrix) {
		int maxRegion = 0;

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (matrix[row][col] == 1) {
					int size = getRegionsSize(matrix, row, col);
					maxRegion = Math.max(maxRegion, size);
				}
			}
		}

		return maxRegion;
	}

}
