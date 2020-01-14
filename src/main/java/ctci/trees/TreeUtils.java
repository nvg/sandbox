package ctci.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeUtils {

	/**
	 * CTCI6 - 4.5
	 */
	public static boolean isValidBstMinMax(TreeNode root) {
		return isValidBstMinMax(root, null, null);
	}

	private static boolean isValidBstMinMax(TreeNode root, Integer min, Integer max) {
		if (root == null) {
			return true;
		}

		if ((min != null && root.getValue() <= min) || (max != null && root.getValue() > max)) {
			return false;
		}

		if (!isValidBstMinMax(root.getLeft(), min, root.getValue())
				|| !isValidBstMinMax(root.getRight(), root.getValue(), max)) {
			return false;
		}

		return true;
	}

	public static boolean isValidBst2(TreeNode root) {
		return isValidBst2(root, null);
	}

	private static boolean isValidBst2(TreeNode root, Integer last) {
		if (root == null) {
			return true;
		}

		if (!isValidBst2(root.getLeft(), last)) {
			return false;
		}

		if (last != null && root.getValue() <= last) {
			return false;
		}
		last = root.getValue();

		if (!isValidBst2(root.getRight(), last)) {
			return false;
		}

		return true;
	}

	public static boolean isValidBst(TreeNode root) {
		// leverage in-order traversal - assume no duplicates, otherwise
		// in-order traversal won't work
		List<Integer> values = new ArrayList<Integer>();
		toListInOrder(root, values);
		for (int i = 1; i < values.size(); i++) {
			if (values.get(i) <= values.get(i - 1)) {
				return false;
			}
		}
		return true;
	}

	private static void toListInOrder(TreeNode root, List<Integer> values) {
		if (root == null) {
			return;
		}
		toListInOrder(root.getLeft(), values);
		values.add(root.getValue());
		toListInOrder(root.getRight(), values);
	}

	/**
	 * CTCI6 4.4 - efficient - runs in O(N) time / O(H) space by cutting getHeight
	 * by returning an error value
	 */
	public static boolean isBalanced2(TreeNode root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}

	private static int checkHeight(TreeNode root) {
		if (root == null) {
			return -1;
		}

		int leftHeight = checkHeight(root.getLeft());
		if (leftHeight == Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}

		int rightHeight = checkHeight(root.getRight());
		if (rightHeight == Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}

		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1) {
			return Integer.MIN_VALUE;
		}

		return Math.max(leftHeight, rightHeight) + 1;
	}

	/**
	 * CTCI6 4.4 - inefficient - calls getHeight multiple times on same nodes
	 */
	public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}

		int heightDiff = getHeight(root.getLeft()) - getHeight(root.getRight());
		if (Math.abs(heightDiff) > 1) {
			return false;
		}

		return isBalanced(root.getLeft()) && isBalanced(root.getRight());
	}

	private static int getHeight(TreeNode root) {
		if (root == null) {
			return -1;
		}

		return Math.max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1;
	}

	/**
	 * CTCI6 4.3
	 */
	public static List<List<TreeNode>> getLevels(TreeNode root) {
		List<List<TreeNode>> result = new ArrayList<List<TreeNode>>();
		getLevels(root, result, 0);
		return result;
	}

	private static void getLevels(TreeNode root, List<List<TreeNode>> lists, int i) {
		if (root == null) {
			return;
		}

		List<TreeNode> list = null;
		if (lists.size() == i) {
			list = new LinkedList<TreeNode>();
			lists.add(list);
		} else {
			list = lists.get(i);
		}

		list.add(root);
		getLevels(root.getLeft(), lists, i + 1);
		getLevels(root.getRight(), lists, i + 1);
	}

	public static List<TreeNode> getLevel(TreeNode root, int level) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		getLevel(root, level, 0, result);
		return result;
	}

	private static void getLevel(TreeNode node, int requiredLevel, int currentLevel, List<TreeNode> nodes) {
		if (node == null) {
			return;
		}

		if (requiredLevel == currentLevel) {
			nodes.add(node);
			return;
		}

		getLevel(node.getLeft(), requiredLevel, currentLevel + 1, nodes);
		getLevel(node.getRight(), requiredLevel, currentLevel + 1, nodes);
	}

	/**
	 * CTCI6 4.2
	 */
	public static TreeNode toBst(int[] nums) {
		return toBst(nums, 0, nums.length - 1);
	}

	private static TreeNode toBst(int[] nums, int start, int end) {
		if (end < start) {
			return null;
		}

		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(nums[mid]);
		n.setLeft(toBst(nums, start, mid - 1));
		n.setRight(toBst(nums, mid + 1, end));
		return n;
	}

}
