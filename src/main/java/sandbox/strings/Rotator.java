package sandbox.strings;

public class Rotator {

	public char[] rotateLeft(char[] chars, int offset) {
		return rotateRight(chars, chars.length - offset);
	}

	public char[] rotateRight(char[] chars, int offset) {
		offset = offset % chars.length;

		if (offset == 0) {
			return chars;
		}

		int len = chars.length;

		reverse(chars, 0, len - offset - 1);
		reverse(chars, len - offset, len - 1);
		reverse(chars, 0, len - 1);

		return chars;
	}

	private void reverse(char[] chars, int start, int end) {
		while (start < end) {
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++;
			end--;
		}
	}

}
