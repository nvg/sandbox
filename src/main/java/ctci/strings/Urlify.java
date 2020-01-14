package ctci.strings;

public class Urlify {

	public char[] urlify(char[] chars, int len) {
		int spaceCount = 0;
		for (int i = 0; i < len; i++) {
			if (chars[i] == ' ') {
				spaceCount++;
			}
		}

		int end = len + spaceCount * 2;

		for (int i = len - 1; i >= 0; i--) {
			if (chars[i] == ' ') {
				chars[--end] = '0';
				chars[--end] = '2';
				chars[--end] = '%';
				continue;
			}
			
			chars[--end] = chars[i];
		}
		return chars;
	}

}
