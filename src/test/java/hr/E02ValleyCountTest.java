package hr;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class E02ValleyCountTest {

	@Test
	void test() {
		assertEquals(1, E02ValleyCount.countingValleys(8, "UDDDUDUU"));
		assertEquals(2, E02ValleyCount.countingValleys(10, "UDDDUDUUDU"));
		assertEquals(2, E02ValleyCount.countingValleys(12, "DDUUDDUDUUUD"));
		assertEquals(5, E02ValleyCount.countingValleys(20, "DDUUDDUUDDUUDDUUDDUU"));
	}

}
