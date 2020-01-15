package tw.rover;

public enum Direction {
	N, E, S, W;

	private static Direction[] directions = values();

	public Direction getNext() {
		return directions[(this.ordinal() + 1) % directions.length];
	}

	public Direction getPrevious() {
		return directions[(this.ordinal() + directions.length - 1) % directions.length];
	}

}
