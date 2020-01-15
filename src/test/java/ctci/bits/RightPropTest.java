package ctci.bits;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RightPropTest {

	@Test
	void test() {
		int x = 0b01010000;
		int check = 0b1011111;

		assertEquals(check, RightProp.rightPropagate(x));
	}

}
