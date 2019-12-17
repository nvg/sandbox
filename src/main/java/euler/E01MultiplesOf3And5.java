package euler;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9. The sum of these multiples is 23.
 * 
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class E01MultiplesOf3And5 {

	private int sum(int k) {
		return k * (k + 1) / 2;
	}
	
	public int countMultiples(int n) {
		int countOf3s = (n - 1) / 3;
		int countOf5s = (n - 1) / 5;
		int countOf3sAnd5s = (n - 1) / 15;

		int result = 0;
		
		result = 3 * sum(countOf3s);
		result += 5 * sum(countOf5s);
		result -= 15 * sum(countOf3sAnd5s);

		return result;
	}

	public int bruteForceCount(int n) {
		int result = 0;

		for (int i = 3; i < n; i++) {
			boolean divisibleBy3 = i % 3 == 0;
			boolean divisibleBy5 = i % 5 == 0;

			if (divisibleBy3 && divisibleBy5) {
				continue;
			}

			if (divisibleBy3 || divisibleBy5) {
				result += i;
			}
		}

		return result;
	}

}
