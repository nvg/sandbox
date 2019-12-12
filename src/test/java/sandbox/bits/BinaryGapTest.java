package sandbox.bits;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinaryGapTest {

	@Test
	void shouldFindLongestOfaSingleSequence() {
		assertEquals(2, BinaryGap.findGap(9));
	}

	@Test
	void shouldFindLongestOfaMultipeSequences() {
		assertEquals(5, BinaryGap.findGap(1041));
	}
	
	@Test
	void shouldFindNoSquences() {
		assertEquals(0, BinaryGap.findGap(32));
	}

}
