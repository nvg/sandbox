package ctci.calc;

/**
 * Solution taken from
 * 
 * https://stackoverflow.com/questions/3422673/how-to-evaluate-a-math-expression-given-in-string-form
 */
public class Calculator {

	private int pos = -1;
	private int ch;
	private String str;

	public static double eval(final String expression) {
		Calculator calc = new Calculator(expression);
		return calc.parse();
	}

	private Calculator(String expression) {
		this.str = expression;
	}

	private void nextChar() {
		ch = (++pos < str.length()) ? str.charAt(pos) : -1;
	}

	private boolean eat(int charToEat) {
		while (ch == ' ') {
			nextChar();
		}

		if (ch == charToEat) {
			nextChar();
			return true;
		}

		return false;
	}

	private double parse() {
		nextChar();
		double x = parseExpression();
		if (pos < str.length()) {
			throw new RuntimeException("Unexpected: " + (char) ch);
		}
		return x;
	}

	/*-

	 Grammar:
		 expression = term | expression `+` term | expression `-` term
		 term = factor | term `*` factor | term `/` factor
		 factor = `+` factor | `-` factor | `(` expression `)` | number | functionName factor | factor `^` factor
		 
	*/
	private double parseExpression() {
		double x = parseTerm();
		while (true) {
			if (eat('+')) {
				x += parseTerm(); // addition
			} else if (eat('-')) {
				x -= parseTerm(); // subtraction
			} else {
				return x;
			}
		}
	}

	private double parseTerm() {
		double x = parseFactor();
		while (true) {
			if (eat('*'))
				x *= parseFactor(); // multiplication
			else if (eat('/'))
				x /= parseFactor(); // division
			else
				return x;
		}
	}

	private double parseFactor() {
		if (eat('+')) {
			return parseFactor(); // unary plus
		}

		if (eat('-')) {
			return -parseFactor(); // unary minus
		}

		double x;
		int startPos = this.pos;
		if (eat('(')) { // parentheses
			x = parseExpression();
			eat(')');
		} else if (Character.isDigit(ch) || ch == '.') { // numbers
			while (Character.isDigit(ch) || ch == '.') {
				nextChar();
			}
			x = Double.parseDouble(str.substring(startPos, this.pos));
		} else if (Character.isLetter(ch)) { // functions
			while (Character.isLetter(ch)) {
				nextChar();
			}
			String func = str.substring(startPos, this.pos).toLowerCase();
			x = parseFactor();
			if (func.equals("sqrt")) {
				x = Math.sqrt(x);
			} else if (func.equals("sin")) {
				x = Math.sin(Math.toRadians(x));
			} else if (func.equals("cos")) {
				x = Math.cos(Math.toRadians(x));
			} else if (func.equals("tan")) {
				x = Math.tan(Math.toRadians(x));
			} else {
				throw new RuntimeException("Unknown function: " + func);
			}
		} else {
			throw new RuntimeException("Unexpected: " + (char) ch);
		}

		if (eat('^')) {
			x = Math.pow(x, parseFactor());
		}

		return x;
	}

}
