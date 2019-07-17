package sandbox.rover;

public class PlateauBuilder {

	private Plateau plateau;

	public PlateauBuilder buildPlateau(String initialSize) {
		Coordinate coordinate = parseInitialSize(initialSize);
		plateau = new Plateau(coordinate);
		return this;
	}

	private Coordinate parseInitialSize(String initialSize) {
		String[] splits = initialSize.split("\\s");
		return toCoordinate(splits);
	}

	private Coordinate toCoordinate(String[] coordinates) {
		int x = Integer.valueOf(coordinates[0]);
		int y = Integer.valueOf(coordinates[1]);
		return new Coordinate(x, y);
	}

	public PlateauBuilder buildRower(String initialLocation, String commands) {
		Rover rower = parseInitialLocation(initialLocation);
		rower.setCommands(commands.toCharArray());
		plateau.addRower(rower);
		return this;
	}

	private Rover parseInitialLocation(String initialLocation) {
		String[] splits = initialLocation.split("\\s");
		Coordinate coordinate = toCoordinate(splits);
		Direction direction = Direction.valueOf(splits[2]);
		return new Rover(coordinate, direction);
	}

	public Plateau getPlateau() {
		return plateau;
	}

}
