package sandbox.calc;

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operator other = (Operator) obj;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		return true;
	}
	
	@Override
	public int getValue() {
		throw new UnsupportedOperationException();
	}

	public NumberTerm apply(NumberTerm term1, NumberTerm term2) {
		int result = 0;
		switch (getOperator()) {
		case "^":
			result = (int) Math.pow(term1.getNumber(), term2.getNumber());
			break;
		case "*":
			result = term1.getNumber() * term2.getNumber();
			break;
		case "/":
			result = term1.getNumber() / term2.getNumber();
			break;
		case "+":
			result = term1.getNumber() + term2.getNumber();
			break;
		case "-":
			result = term1.getNumber() - term2.getNumber();
			break;
		default:
			throw new UnsupportedOperationException("Operator " + getOperator() + " is not supported");
		}
		return new NumberTerm(result);
	}

	
	@Override
	public String toString() {
		return "" + operator;
	}
}
