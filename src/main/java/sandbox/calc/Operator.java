package sandbox.calc;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Operator implements Token {

	private String operator;

	public Operator() {
		super();
	}

	public Operator(String operator) {
		this();
		this.operator = operator;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Override
	public int getValue() {
		throw new UnsupportedOperationException();
	}

	public int apply(int val1, int val2) {
		int result = 0;
		switch (getOperator()) {
		case "^":
			result = (int) Math.pow(val1, val2);
			break;
		case "*":
			result = val1 * val2;
			break;
		case "/":
			result = val1 / val2;
			break;
		case "+":
			result = val1 + val2;
			break;
		case "-":
			result = val1 - val2;
			break;
		default:
			throw new UnsupportedOperationException("Operator " + getOperator() + " is not supported");
		}
		return result;
	}

	
	@Override
	public String toString() {
		return operator;
	}
}
