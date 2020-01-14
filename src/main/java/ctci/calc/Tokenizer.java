package ctci.calc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Tokenizer {

	private static final Set<Character> OPS = new HashSet<Character>(
			Arrays.asList(new Character[] { '+', '-', '/', '*', '^', '(', ')' }));

	private int index;

	public Expression tokenize(String string) {
		index = 0;

		return tokenizeString(string);
	}

	private Expression tokenizeString(String string) {
		Expression result = new Expression();
		StringBuilder buf = new StringBuilder();
		for (; index < string.length(); index++) {
			char ch = string.charAt(index);

			if (ch == '(') {
				index++;
				result.addToken(tokenizeString(string));
				continue;
			}

			if (ch == ')') {
				if (buf.length() != 0) {
					result.addToken(parseNumber(buf));
				}
				return result;
			}

			boolean isStartingNegativeNumber = (buf.length() == 0 && isNegativeNumber(index, string));
			if (Character.isDigit(ch) || isStartingNegativeNumber) {
				buf.append(ch);
				continue;
			}

			if (OPS.contains(ch)) {
				if (buf.length() != 0) {
					result.addToken(parseNumber(buf));
				}
				result.addToken(parseOperator(ch));
			}
		}

		if (buf.length() != 0) {
			result.addToken(parseNumber(buf));
		}

		return result;
	}

	private boolean isNegativeNumber(int i, String string) {
		if (i >= string.length()) {
			return false;
		}
		if (string.charAt(i) != '-') {
			return false;
		}
		return Character.isDigit(string.charAt(i + 1));
	}

	private Token parseOperator(char ch) {
		return new Operator("" + ch);
	}

	private Token parseNumber(StringBuilder buf) {
		Integer integer = Integer.parseInt(buf.toString());
		buf.setLength(0);
		return new NumberTerm(integer);
	}

}
