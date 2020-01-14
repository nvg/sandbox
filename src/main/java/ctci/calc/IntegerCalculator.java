package ctci.calc;

public class IntegerCalculator {

	public static int eval(String str) {
		Tokenizer t = new Tokenizer();
		Expression expression = t.tokenize(str);
		return expression.getValue();
	}

}
