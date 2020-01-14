package ctci.strings;

public class OneAwayChecker {

	public boolean isOneAway(String s1, String s2) {
		if (s1.length() == s2.length()) {
			return isOneReplace(s1, s2);
		} else if (s1.length() + 1 == s2.length()) {
			return isOneInsert(s1, s2);
		} else if (s1.length() - 1 == s2.length()) {
			return isOneInsert(s2, s1);
		}
		return false;
	}

	private boolean isOneInsert(String s1, String s2) {
		int index1 = 0, index2 = 0;
		while(index1 < s1.length() && index2 < s2.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {
				if (index1 != index2) {
					return false;
				}
				index2++;
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}

	private boolean isOneReplace(String s1, String s2) {
		boolean foundDiff = false;
		for(int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (foundDiff) {
					return false;
				}
				foundDiff = true;
			}
		}
		return true;
	}

}
