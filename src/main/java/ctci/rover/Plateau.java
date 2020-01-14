package ctci.rover;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Plateau {

	private Coordinate upperRight;

	private List<Rover> rowers = new ArrayList<>();

	public Coordinate getUpperRight() {
		return upperRight;
	}

	public void setUpperRight(Coordinate upperRight) {
		this.upperRight = upperRight;
	}

	public List<Rover> getRowers() {
		return rowers;
	}

	public void setRowers(List<Rover> rowers) {
		this.rowers = rowers;
	}

	public Plateau(Coordinate upperRight) {
		this.upperRight = upperRight;
	}

	public void addRower(Rover rower) {
		rowers.add(rower);
	}

	public void executeSequential() {
		for (Rover r : rowers) {
			r.runMission();
		}
	}

	public void executeConcurrent() {
		int maxCommandLength = getMaxCommandLenght();
		java.util.Set<String> locations = new HashSet<>();
		for(int i = 0; i < maxCommandLength; i++) {
			locations.clear();
			for(Rover r : getRowers()) {
				r.runMissionStep(i);
				if (locations.contains(r.getLocation().toString())) {
					System.out.println("COLLISION!!!");
				}
			}
		}
	}

	private int getMaxCommandLenght() {
		return getRowers().stream().mapToInt(v -> v.getCommands().length).max().orElse(0);
	}
}
