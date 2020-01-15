package ctci.arrays;

public class Matrices {

	public static int[][] multiply(int[][] A, int[][] B) {
		int[][] res = new int[A.length][B[0].length];

		for (int row = 0; row < res.length; row++) {
			for (int col = 0; col < res[row].length; col++) {
				for (int i = 0; i < B.length; i++) {
					res[row][col] += A[row][i] * B[i][col];
				}
			}
		}

		return res;
	};

}
