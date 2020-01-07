package hr;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class E01SockCountsTest {

	@Test
	void test() {
		assertEquals(2, E01SockCounts.sockMerchant(10, new int[] { 1, 1, 1, 3, 2, 4, 5, 5, 9, 0 }));
	}

}
