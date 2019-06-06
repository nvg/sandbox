package sandbox.strings;

public class UniquenessChecker {

	public boolean testAllUniqueASCIIViaTable(String string) {
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

	public boolean testAllUniqueInplace(String string) {
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
