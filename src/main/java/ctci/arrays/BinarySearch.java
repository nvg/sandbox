package ctci.arrays;

public class BinarySearch {

	
	
	public boolean isPresentRecursive(int[] arr, int x) {
		return isPresentRecursive(arr, x, 0, arr.length - 1);
	}

	private boolean isPresentRecursive(int[] arr, int x, int left, int right) {
		if (left > right) {
			return false;
		}

		// int mid = (left + right) / 2 <- this can cause int overflow
		int mid = left + (right - left) / 2;

		if (arr[mid] == x) {
			return true;
		}

		if (arr[mid] > x) {
			return isPresentRecursive(arr, x, left, mid - 1);
		} else {
			return isPresentRecursive(arr, x, mid + 1, right);
		}
	}

	public boolean isPresentIter(int[] arr, int x) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (arr[mid] == x) {
				return true;
			}

			if (arr[mid] > x) {
				right = mid - 1;
				continue;
			} 
			
			left = mid + 1;
		}
		return false;
	}

}
