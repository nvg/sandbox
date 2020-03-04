package ctci.misc;

import java.util.Arrays;

public class IceCreamFinder {

	/**
	 * Searches for two different ice creams that can be purchased for the specified
	 * amount.
	 * 
	 * @param menu  Prices of the ice-creams
	 * @param money Amount of money that can be spent
	 * @return Returns indices of two ice creams positions with prices that sum-up
	 *         to the given amount or null if it can't be found
	 */
	public int[] findChoices(int[] menu, int money) {
		int[] sortedMenu = menu.clone();
		Arrays.sort(sortedMenu);

		for (int i = 0; i < sortedMenu.length; i++) {
			int complement = money - menu[i];

			// int location = Arrays.binarySearch(sortedMenu, complement);
			// line above would work, but we can start searching from the i-th
			// position, as otherwise we would end up finding the same
			// ice cream when complement == money - menu[i]

			int start = i + 1;
			int end = sortedMenu.length;
			int location = Arrays.binarySearch(sortedMenu, start, end, complement);

			// location is either the location of the item, or index where it would have
			// been so we need to check for the actual value
			if (location >= 0 && location < menu.length && menu[location] == complement) {
				int[] indices = getIndicesFromValues(menu, menu[i], complement);
				return indices;
			}

		}
		return null;
	}

	private int[] getIndicesFromValues(int[] menu, int value1, int value2) {
		int index1 = indexOf(menu, value1, -1);
		int index2 = indexOf(menu, value2, index1);
		return new int[] { Math.min(index1, index2), Math.max(index1, index2) };
	}

	private int indexOf(int[] menu, int value, int excludeThis) {
		for (int i = 0; i < menu.length; i++) {
			if (menu[i] == value && i != excludeThis) {
				return i;
			}
		}
		return -1;
	}

}
