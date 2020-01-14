package ctci.bits;

public class BinaryGap {

	public static int findGap(int N) {
		int maxGapCount = 0;
		int gapCount = 0;
		boolean sawOne = false;
		for (int i = 0; i < 32; i++) {
			int nextBit = getBit(N, i);
			if (nextBit == 1) {
				sawOne = true;
				maxGapCount = Math.max(gapCount, maxGapCount);
				gapCount = 0;
			} else {
				if (sawOne) {
					gapCount++;
				}
			}

		}
		return maxGapCount;
	}

	private static int getBit(int n, int k) {
		return (n >> k) & 1;
	}

}
