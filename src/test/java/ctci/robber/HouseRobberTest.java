package ctci.robber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ctci.robber.HouseRobber;

public class HouseRobberTest {

	int[] sampleInput1 = new int[] { 1, 2, 3, 1 };
	int sampleOutput1 = 4;
	
	int[] sampleInput2 = new int[] { 2, 7, 9, 3, 1 };
	int sampleOutput2 = 12;
	
	@Test
	public void shouldCalculateHowMuchCanBeNaivelyRobbedWithoutCallingPolice() {
		HouseRobber h = new HouseRobber();
		assertEquals(sampleOutput1, h.calculateNaiveRobbery(sampleInput1));
		assertEquals(sampleOutput2, h.calculateNaiveRobbery(sampleInput2));
	}
	
	@Test
	public void shouldCalculateHowMuchCanBeRobbedWithoutCallingPolice() {
		HouseRobber h = new HouseRobber();
		assertEquals(sampleOutput1, h.calculateRobbery(sampleInput1));
		assertEquals(sampleOutput2, h.calculateRobbery(sampleInput2));
	}
	
}
