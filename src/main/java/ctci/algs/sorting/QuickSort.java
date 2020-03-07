package ctci.algs.sorting;

public class QuickSort {

	private void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public void sort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	private void sort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}

		int pivot = arr[(left + right) / 2];
		int index = partition(arr, left, right, pivot);
		sort(arr, left, index - 1);
		sort(arr, index, right);
	}

	private int partition(int[] arr, int left, int right, int pivot) {
		while (left <= right) {
			while (arr[left] < pivot) {
				left++;
			}
			while (arr[right] > pivot) {
				right--;
			}
			if (left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

}
