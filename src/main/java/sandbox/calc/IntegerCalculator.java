package sandbox.calc;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IntegerCalculator {

	private static final Map<Integer, List<String>> OPS = new TreeMap<Integer, List<String>>();
	static {
		OPS.put(0, Arrays.asList(new String[] { "^" }));
		OPS.put(1, Arrays.asList(new String[] { "*", "/" }));
		OPS.put(2, Arrays.asList(new String[] { "+", "-" }));
	}

	public static int eval(String str) {
		Tokenizer t = new Tokenizer();
		List<Token> tokens = t.tokenize(str);

		if (tokens.size() == 0) {
			throw new IllegalArgumentException("Empty expression");
		}

		if (tokens.size() == 1) {
			return tokens.get(0).getValue();
		}

		for (List<String> ops : OPS.values()) {
			for (String op : ops) {
				tokens = reduce(tokens, op);
			}
		}

		NumberTerm result = (NumberTerm) tokens.get(0);
		return result.getNumber();
	}

	private static List<Token> reduce(List<Token> tokens, String op) {
		// TODO take care of brackets
		return reduceExpression(tokens, op);
	}

	private static List<Token> reduceExpression(List<Token> tokens, String op) {
		for (int i = 0; i < tokens.size() - 1;) {
			Operator o = (Operator) tokens.get(i + 1);
			if (o.getOperator().equals(op)) {
				NumberTerm term1 = remove(tokens, i);
				remove(tokens, i);
				NumberTerm term2 = remove(tokens, i);

				NumberTerm res = o.apply(term1, term2);
				tokens.add(i, res);
				continue;
			}

			i += 2;
		}
		return tokens;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static <T> T remove(List l, int pos) {
		if (pos >= l.size()) {
			throw new IllegalStateException("Malformed expression string");
		}

		return (T) l.remove(pos);
	}
}
