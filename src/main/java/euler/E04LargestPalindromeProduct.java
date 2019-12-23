package euler;

/*
 * A palindromic number reads the same both ways. The largest palindrome made from the 
 * product of two 2-digit numbers is 9009 = 91 × 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class E04LargestPalindromeProduct {

	private boolean isPalindrome(String s) {
		for (int start = 0, end = s.length() - 1; start < end; start++, end--) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
		}

		return true;
	}

	public int getLargestPalindromeBruteForce() {
		final int upperBound = 999;
		final int lowerBound = 100;

		int maxPalindrome = 0;
		for (int i = upperBound; i >= lowerBound; i--) {
			for (int j = upperBound; j >= lowerBound; j--) {
				int product = i * j;
				if (isPalindrome(Integer.toString(product))) {
					maxPalindrome = Math.max(maxPalindrome, product);
				}
			}
		}
		return maxPalindrome;
	}

}
