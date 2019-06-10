package sandbox.strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UrlifyTest {

	@Test
	void test() {
		Urlify u = new Urlify();
		assertEquals("Mr%20John%20Smith", new String(u.urlify("Mr John Smith    ".toCharArray(), 13)));
	}

}
