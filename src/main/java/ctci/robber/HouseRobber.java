package ctci.robber;

public class HouseRobber {

	public int calculateNaiveRobbery(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		if (nums.length <= 2) {
			return nums[findMaxElement(nums)];
		}

		int result = 0;
		int maxPos = 0;
		while (true) {
			maxPos = findMaxElement(nums);
			if (nums[maxPos] == 0) {
				break;
			}
			result += nums[maxPos];
			nums[maxPos] = 0;
			skipAdjacent(maxPos, nums);
		}
		return result;
	}

	private void skipAdjacent(int maxPos, int[] nums) {
		if (maxPos > 0) {
			nums[maxPos - 1] = 0;
		}

		nums[maxPos] = 0;

		if (maxPos < (nums.length - 1)) {
			nums[maxPos + 1] = 0;
		}
	}

	private int findMaxElement(int[] nums) {
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > nums[max]) {
				max = i;
			}
		}
		return max;
	}

	public int calculateRobbery(int[] num) {
		// max money can get if rob current house
		int rob = 0;
		// max money can get if not rob current house
		int notrob = 0;

		for (int i = 0; i < num.length; i++) {
			int currob = notrob + num[i]; 	// if rob current value, previous house must not be robbed
			notrob = Math.max(notrob, rob); // if not rob ith house, take the max value of robbed
											// (i-1)th house and not rob (i-1)th house
			rob = currob;
		}
		return Math.max(rob, notrob);
	}

}
