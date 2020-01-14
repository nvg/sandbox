package ctci.strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ctci.strings.Rotator;

public class RotatorTest {

	@Test
	void test() {
		Rotator r = new Rotator();
		assertEquals("bca", new String(r.rotateLeft("abc".toCharArray(), 1)));
		assertEquals("cab", new String(r.rotateRight("abc".toCharArray(), 1)));
		assertEquals("cdab", new String(r.rotateRight("abcd".toCharArray(), 2)));
		assertEquals("cdeab", new String(r.rotateRight("abcde".toCharArray(), 3)));
	}

}
