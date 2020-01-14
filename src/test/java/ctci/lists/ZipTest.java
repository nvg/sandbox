package ctci.lists;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ctci.lists.LinkedListNode;
import ctci.lists.Zip;

class ZipTest {

	@Test
	void test() {
		LinkedListNode list = LinkedListNode.build(0, 1, 2, 3, 4);
		LinkedListNode check = LinkedListNode.build(0, 4, 1, 3, 2);
		Zip z = new Zip();

		assertEquals(check, z.zip(list));
	}

}
