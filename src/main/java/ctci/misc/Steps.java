package ctci.misc;

public class Steps {

	/*
	 * If we can jump 1, 2 or 3 steps on stairs, how many paths are there?
	 * 
	 * Total Steps = Steps w. 1 stair + Steps w. 2 stair + Step w. 3 stair
	 */
	public int countPaths(int steps) {
		if (steps < 0) {
			return 0;
		} else if (steps == 1) {
			return 1;
		}

		return countPaths(steps - 1) + countPaths(steps - 2) + countPaths(steps - 3);
	}

	public int countPathsMemo(int steps) {
		return countPathsMemo(steps, new int[steps + 1]);
	}

	private int countPathsMemo(int steps, int[] memo) {
		if (steps < 0) {
			return 0;
		} else if (steps == 1) {
			return 1;
		}

		if (memo[steps] == 0) {
			memo[steps] = countPathsMemo(steps - 1, memo) + countPathsMemo(steps - 2, memo)
					+ countPathsMemo(steps - 3, memo);
		}

		return memo[steps];
	}

	public int countPathsDP(int steps) {
		if (steps < 0) {
			return 0;
		} else if (steps <= 1) {
			return 1;
		}

		int[] paths = new int[steps + 1];
		paths[0] = 1;
		paths[1] = 1;
		paths[2] = 2;

		for (int i = 3; i <= steps; i++) {
			paths[i] = paths[i - 1] + paths[i - 2] + paths[i - 3];
		}
		
		return paths[steps - 1];
	}
	
	public int countPathsIter(int steps) {
		if (steps < 0) {
			return 0;
		} else if (steps <= 1) {
			return 1;
		}

		int[] paths = {1, 1, 2};
		for (int i = 3; i <= steps; i++) {
			int count = paths[0] + paths[1] + paths[2];
			paths[0] = paths[1];
			paths[1] = paths[2];
			paths[2] = count;
		}
		
		return paths[1];
	}

}
