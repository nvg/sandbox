package sandbox.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public class Expression implements Token {

	private static final List<String> OPS = new ArrayList<>(Arrays.asList(new String[] { "^", "*", "/", "-", "+" }));

	private List<Token> tokens = new ArrayList<Token>();

	public Expression addToken(Token t) {
		tokens.add(t);
		return this;
	}

	public int size() {
		int result = 0;
		for (Token t : tokens) {
			result += t.size();
		}
		return result;
	}

	public Token get(int i) {
		return tokens.get(i);
	}

	@Override
	public int getValue() {
		for (String op : OPS) {
			reduce(op);
		}

		return tokens.get(0).getValue();
	}

	public void reduce(String op) {
		for (int i = 0; i <= tokens.size() - 2; i += 2) {
			Operator o = (Operator) tokens.get(i + 1);
			if (o.getOperator().equals(op)) {
				int value1 = tokens.remove(i).getValue();
				tokens.remove(i);
				int value2 = tokens.remove(i).getValue();

				int res = o.apply(value1, value2);
				tokens.add(i, new NumberTerm(res));
				reduce(op);
			}
		}
	}

}
