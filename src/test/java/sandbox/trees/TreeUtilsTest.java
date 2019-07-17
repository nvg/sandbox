package sandbox.trees;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class TreeUtilsTest {

	@Test
	void shouldConvertToBst() {
		TreeNode n = TreeUtils.toBst(new int[] { 1, 2, 3, 4, 5 });
		assertNotNull(n);
		assertEquals(3, n.getValue());

		n = TreeUtils.toBst(new int[] { 1, 2, 3, 4, 5, 6 });
		assertNotNull(n);
		assertEquals(3, n.getValue());

	}
	
	@Test
	void shouldGetNodesAtLevelN() {
		TreeNode n = TreeUtils.toBst(new int[] { 1, 2, 3, 4, 5 });
		List<TreeNode> ns = TreeUtils.getLevel(n, 0);
		assertEquals(3, ns.get(0).getValue());
		ns = TreeUtils.getLevel(n, 1);
		assertEquals(1, ns.get(0).getValue());
		assertEquals(4, ns.get(1).getValue());
		assertNotNull(TreeUtils.getLevels(n));
	}
	
	@Test
	void shouldCheckBalanced() {
		TreeNode n = TreeUtils.toBst(new int[] { 1, 2, 3, 4, 5 });
		assertTrue(TreeUtils.isBalanced(n));
		assertTrue(TreeUtils.isBalanced2(n));
		
		TreeNode n2 = TreeUtils.toBst(new int[] {99});
		n2.setLeft(n);
		assertFalse(TreeUtils.isBalanced(n2));
		assertFalse(TreeUtils.isBalanced2(n2));
	}
	
	@Test
	void shouldCheckBst() {
		TreeNode n = TreeUtils.toBst(new int[] { 1, 2, 3, 4, 5 }); 
		assertTrue(TreeUtils.isValidBst(n));
		TreeNode n1 = new TreeNode(99);
		n1.setRight(n);
		assertFalse(TreeUtils.isValidBst(n1));
	}

	@Test
	void shouldCheckBst2() {
		TreeNode n = TreeUtils.toBst(new int[] { 1, 2, 3, 4, 5 }); 
		assertTrue(TreeUtils.isValidBst2(n));
		TreeNode n1 = new TreeNode(99);
		n1.setRight(n);
		assertFalse(TreeUtils.isValidBst2(n1));
	}
	
	@Test
	void shouldCheckBstMinMax() {
		TreeNode n = TreeUtils.toBst(new int[] { 1, 2, 3, 4, 5 }); 
		assertTrue(TreeUtils.isValidBstMinMax(n));
		TreeNode n1 = new TreeNode(99);
		n1.setRight(n);
		assertFalse(TreeUtils.isValidBstMinMax(n1));
	}
}
