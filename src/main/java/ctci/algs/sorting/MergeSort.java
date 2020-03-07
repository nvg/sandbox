package ctci.algs.sorting;

public class MergeSort {

	public void sort(int[] arr) {
		sort(arr, new int[arr.length], 0, arr.length - 1);
	}

	private void sort(int[] arr, int[] tmp, int left, int right) {
		if (left >= right) {
			return;
		}

		int mid = (left + right) / 2;

		sort(arr, tmp, left, mid);
		sort(arr, tmp, mid + 1, right);
		
		merge(arr, tmp, left, right);
	}

	private void merge(int[] arr, int[] tmp, int leftStart, int rightEnd) {
		int leftEnd = (rightEnd + leftStart) / 2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;

		int left = leftStart;
		int right = rightStart;
		int index = leftStart;

		while (left <= leftEnd && right <= rightEnd) {
			if (arr[left] <= arr[right]) {
				tmp[index] = arr[left];
				left++;
			} else {
				tmp[index] = arr[right];
				right++;
			}
			index++;
		}

		System.arraycopy(arr, left, tmp, index, leftEnd - left + 1);
		System.arraycopy(arr, right, tmp, index, rightEnd - right + 1);
		System.arraycopy(tmp, leftStart, arr, leftStart, size);
	}

}
