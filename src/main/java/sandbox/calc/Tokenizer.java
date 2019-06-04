package sandbox.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tokenizer {

	private static final Set<Character> OPS = new HashSet<Character>(Arrays.asList(new Character[] { '+', '-', '/', '*', '^' }));

	public List<Token> tokenize(String string) {
		List<Token> result = new ArrayList<Token>();
		StringBuilder buf = new StringBuilder();
		for(int i = 0; i < string.length(); i++) {
			char ch = string.charAt(i);
			if (Character.isDigit(ch)) {
				buf.append(ch);
				continue;
			}
			
			if (OPS.contains(ch)) {
				result.add(parseNumber(buf));				
				result.add(parseOperator(ch));
			}
		}
		
		if (buf.length() != 0) {
			result.add(parseNumber(buf));
		}
		
		return result;
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
