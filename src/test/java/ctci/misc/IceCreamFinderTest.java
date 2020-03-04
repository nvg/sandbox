package ctci.misc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IceCreamFinderTest {

	@Test
	void shouldFindIceCreams() {
		int[] iceCreams = new int[] { 3, 2, 3, 4, 5, 6, 7, 8, 9 };

		assertArrayEquals(new int[] { 0, 6 }, new IceCreamFinder().findChoices(iceCreams, 10));
	}

}
