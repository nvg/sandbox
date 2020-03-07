package ctci.misc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StepsTest {

	@Test
	void testRecursiveImpl() {
		Steps c = new Steps();
		assertEquals(2, c.countPaths(3));
		assertEquals(149, c.countPaths(10));
	}
	
	@Test
	void testMemoizationImpl() {
		Steps c = new Steps();
		assertEquals(2, c.countPathsMemo(3));
		assertEquals(149, c.countPathsMemo(10));
	}
	
	@Test
	void testDynamicProgrammingImpl() {
		Steps c = new Steps();
		assertEquals(2, c.countPathsDP(3));
		assertEquals(149, c.countPathsDP(10));
	}
	
	@Test
	void testIterativeImpl() {
		Steps c = new Steps();
		assertEquals(2, c.countPathsIter(3));
		assertEquals(149, c.countPathsIter(10));
	}

}
