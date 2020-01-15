package ctci.bits;

public class Misc {

	public static boolean isPalindrome(final int n) {
		int reverse = 0;

		int num = n;
		while (num != 0) {
			reverse = reverse * 10 + num % 10;
			num /= 10;
		}

		return reverse == n;
	}

	public int[] swapAdd(int a, int b) {
		a = a + b;
		b = a - b;
		a = a - b;
		return new int[] { a, b };
	}

	public int[] swapXor(int a, int b) {
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		return new int[] { a, b };
	}

	public static boolean isArmstrong(final int n) {
		int check = 0;
		int num = n;
		while (num != 0) {
			int nextDigit = num % 10;
			check += Math.pow(nextDigit, 3);
			num = num / 10;
		}
		return n == check;
	}


}
