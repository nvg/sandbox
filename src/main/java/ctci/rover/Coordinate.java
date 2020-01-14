package ctci.rover;

public class Coordinate {

	private final int x;
	private final int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Coordinate move(Direction direction) {
		int x = this.x;
		int y = this.y;

		switch (direction) {
		case N:
			y++;
			break;
		case S:
			y--;
			break;
		case W:
			x--;
			break;
		case E:
			x++;
			break;
		default:
			throw new IllegalStateException("Unsupported direction " + direction);
		}

		return new Coordinate(x, y);
	}

	@Override
	public String toString() {
		return x + " " + y;
	}
	
	

}
