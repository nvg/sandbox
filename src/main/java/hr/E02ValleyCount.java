package hr;

public class E02ValleyCount {

	// Complete the countingValleys function below.
	static int countingValleys(int n, String s) {
		int currentLevel = 0;
		int valleyCount = 0;
		boolean isBelowSeaLevel = false;
		for (char ch : s.toCharArray()) {
			if (ch == 'D') {
				if (currentLevel == 0 && !isBelowSeaLevel) {
					isBelowSeaLevel = true;
					valleyCount++;
				}
				currentLevel--;
			}

			if (ch == 'U') {
				if (currentLevel == -1 && isBelowSeaLevel) {
					isBelowSeaLevel = false;
				}

				currentLevel++;
			}
		}

		return valleyCount;
	}

}
