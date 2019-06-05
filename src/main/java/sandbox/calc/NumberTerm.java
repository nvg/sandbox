package sandbox.calc;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class NumberTerm implements Token {

	private int number;
	
	public NumberTerm() {
		super();
	}

	public NumberTerm(int number) {
		this();
		this.number = number;
	}

	
	@Override
	public String toString() {
		return "" + number;
	}

	@Override
	public int getValue() {
		return getNumber();
	}

}
