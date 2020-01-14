package ctci.arrays;

public class Paths {

	/**
	 * If can only travel down / right compute number of paths
	 * 
	 * <pre>
	 * S A E
	 * B C G
	 * D F X
	 * </pre>
	 * 
	 * Number of paths from S to X is pahts(A, X) + paths(B, X). This approach 
	 * runs in O(2^(N^2)). If we use memoization, this can run in N^2
	 * 
	 */
	public int countPaths(int[][] grid, int row, int col) {
		if (!validSquare(grid, row, col)) {
			return 0;
		}
		if (isAtTheEndOfTheGrid(grid, row, col)) {
			return 1;
		}

		return countPaths(grid, row + 1, col) + countPaths(grid, row, col + 1);
	}

	private boolean isAtTheEndOfTheGrid(int[][] grid, int row, int col) {
		return grid.length == (row - 1) && grid[row].length == (col - 1);
	}

	private boolean validSquare(int[][] grid, int row, int col) {
		if (row >= grid.length) {
			return false;
		}
		if (col >= grid[row].length) {
			return false;
		}

		return grid[row][col] == 1;
	}

}
