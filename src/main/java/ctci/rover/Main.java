package ctci.rover;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;

public class Main {

	public static void main(String[] args) throws Exception {
		PlateauBuilder builder = new PlateauBuilder();
		try (BufferedReader reader = new BufferedReader(getInput())) {
			builder.buildPlateau(reader.readLine());
			while (true) {
				String initialLocation = reader.readLine();
				if (initialLocation == null) {
					break;
				}
				String commands = reader.readLine();
				builder.buildRower(initialLocation, commands);
			}
		}

		Plateau plateau = builder.getPlateau();
		// plateau.executeSequential();
		plateau.executeConcurrent();

		for (Rover r : plateau.getRowers()) {
			System.out.println(r);
		}

	}

	private static Reader getInput() {
		return new StringReader("5 5\n" + "1 2 N\n" + "LMLMLMLMM\n" + "3 3 E\n" + "MMRMMRMRRM\n");
	}

}
