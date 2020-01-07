package hr;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class E03JumpingOnTheCloudsTest {

	@Test
	void test() {
		assertEquals(3, E03JumpingOnTheClouds.jumpingOnClouds(new int[] { 0, 0, 0, 0, 1, 0 }));
		assertEquals(4, E03JumpingOnTheClouds.jumpingOnClouds(new int[] { 0, 0, 1, 0, 0, 1, 0 }));
	}

}
