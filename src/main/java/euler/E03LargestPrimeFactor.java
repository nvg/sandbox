package euler;

public class E03LargestPrimeFactor {

	private boolean isPrime(long number) {
		for (long divider = 2; divider <= number / 2; divider++) {
			if (number % divider == 0) {
				return false;
			}

		}
		return true;
	}

	public long maxPrimeFactorEfficient(long n) {
		long factor = -1;
		for (int i = 2; i * i <= n; i++) {
			if (n == 1) {
				break;
			}
			if (n % i != 0) {
				continue;
			}
			factor = i;
			while (n % i == 0) {
				n /= i;
			}
		}
		return n == 1 ? factor : n;
	}

	public long getLargestPrimeFactor(long x) {
		long largestPrimeFactor = 0;

		for (long factor = 3; factor <= x / 2; factor = factor + 2) {
			if (x % factor == 0 & factor > largestPrimeFactor & isPrime(factor)) {
				largestPrimeFactor = factor;
			}
		}
		return largestPrimeFactor;
	}

}
