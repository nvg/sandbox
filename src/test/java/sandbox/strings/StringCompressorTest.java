package sandbox.strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCompressorTest {

	@Test
	void test() {
		StringCompressor c = new StringCompressor();
		assertEquals("a2b1c5a3", c.compress("aabcccccaaa"));
	}

}
