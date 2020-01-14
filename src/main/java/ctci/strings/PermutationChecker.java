package ctci.strings;

public class PermutationChecker {

	// assume if whitespace is not significant and case sensitive O(len(s1) * len(s2))
	// Space O(1)
	// Can do better if use extra data structures - e.g. sort strings / use a char count array 
	public boolean isPermutationNaive(String string1, String string2) {
		if (string1.length() != string2.length()) {
			return false;
		}

		return isPerm(string1, string2) && isPerm(string2, string1);
	}

	private boolean isPerm(String string1, String string2) {
		for (int i = 0; i < string1.length(); i++) {
			char ch = string1.charAt(i);

			boolean isPresent = false;
			for (int j = 0; j < string2.length(); j++) {
				if (ch == string2.charAt(j)) {
					isPresent = true;
					continue;
				}
			}
			if (!isPresent) {
				return false;
			}
		}
		return true;
	}

	public boolean isPalindromePermutation(String str) {
		// insight - a palindrome must have all chars even, except for one in the middle
		int oddCount = 0;
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		
		for(char c : str.toCharArray()) {
			// assume all lower case ASCII
			int charNumber = Character.getNumericValue(c) - Character.getNumericValue('a');
			table[charNumber]++;
			if (table[charNumber] % 2 == 1) {
				oddCount++;
			} else {
				oddCount--;
			}
		}
		
		return oddCount <= 1;
	}
	
}
