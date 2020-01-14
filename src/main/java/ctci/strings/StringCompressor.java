package ctci.strings;

public class StringCompressor {
	
	public String compress(String string) {
		StringBuilder buf = new StringBuilder();
		char ch = string.charAt(0);
		int charCount = 1;
		for(int i = 1; i < string.length(); i++) {
			if (ch == string.charAt(i)) {
				charCount++;
				continue;
			}
			
			buf.append(ch).append(charCount);
			if (buf.length() > string.length()) {
				return string;
			}
			
			charCount = 1;
			ch = string.charAt(i);
		}
		buf.append(ch).append(charCount);
		
		return buf.toString();
	}

}
