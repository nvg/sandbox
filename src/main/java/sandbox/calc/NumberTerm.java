package sandbox.calc;

public class NumberTerm implements Token {

	public NumberTerm() {
		super();
	}

	public NumberTerm(int number) {
		this();
		this.number = number;
	}

	private int number;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
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
		NumberTerm other = (NumberTerm) obj;
		if (number != other.number)
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "" + number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public int getValue() {
		return getNumber();
	}

}
