package ctci.rover;

public class Rover {

	private Coordinate location;
	private Direction position;
	private char[] commands;

	public char[] getCommands() {
		return commands;
	}

	public void setCommands(char[] commands) {
		this.commands = commands;
	}

	public Rover(Coordinate location, Direction position) {
		super();
		this.location = location;
		this.position = position;
	}

	public Coordinate getLocation() {
		return location;
	}

	public void setLocation(Coordinate location) {
		this.location = location;
	}

	public Direction getPosition() {
		return position;
	}

	public void setPosition(Direction position) {
		this.position = position;
	}

	public void runMissionStep(int i) {
		if (i >= getCommands().length) {
			return;
		}

		runCommand(getCommands()[i]);
	}

	public void runMission() {
		for (char ch : getCommands()) {
			runCommand(ch);
		}
	}

	private void runCommand(char ch) {
		switch (ch) {
		case 'L':
			setPosition(getPosition().getPrevious());
			break;
		case 'R':
			setPosition(getPosition().getNext());
			break;
		case 'M':
			move();
			break;
		default:
			throw new IllegalArgumentException("Unsupported command " + ch);
		}
	}

	private void move() {
		setLocation(getLocation().move(position));
	}

	@Override
	public String toString() {
		return getLocation() + " " + getPosition();
	}

}
