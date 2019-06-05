package sandbox.calc;

public interface Token {

	public int getValue();

	public default int size() {
		return 1;
	}

}
