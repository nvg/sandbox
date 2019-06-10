package sandbox.strings;

public class UniquenessChecker {
	
	// ASSUME ASCII CHARSET!

	public boolean testAllUniqueASCIIViaTable(String string) {
		if (string.length() > 128) {
			return false;
		}
		
		boolean[] charSet = new boolean[128];
		for (int i = 0; i < string.length(); i++) {
			int val = string.charAt(i);
			if (charSet[val]) {
				return false;
			}
			charSet[val] = true;
		}
		return true;
	}

	// O(n^2) - if sorting can do in O(n log n)!
	public boolean testAllUniqueInplace(String string) {
		if (string.length() > 128) {
			return false;
		}
		
		for (int i = 0; i < string.length(); i++) {
			for (int j = i + 1; j < string.length(); j++) {
				char ith = string.charAt(i);
				char jth = string.charAt(j);

				if (ith == jth) {
					return false;
				}
			}
		}
		return true;
	}

}
