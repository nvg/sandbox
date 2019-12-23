package epi;

public class C00FindTradingMax {

	/**
	 * @param prices Array of triples containing (Low, High, Starting) prices for a
	 *               given day
	 * @return Returns the max profit that can be obtained within the given time
	 *         frame
	 */
	public double findMax(double[][] prices) {
		double result = Double.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				double diff = prices[j][2] - prices[i][2];
				if (diff > result) {
					result = diff;
				}
			}
		}

		return result;
	}

}
