package ctci.stats;

public class StatUtils {

	public static double getArithmeticMean(double[] values) {
		double sum = 0;
		for (double d : values) {
			sum += d;
		}
		return sum / values.length;
	}

	public static double getVariance(double[] values) {
		double mean = getArithmeticMean(values);

		double diffSum = 0;
		for (double d : values) {
			diffSum = Math.pow((d - mean), 2);
		}

		return diffSum / values.length;
	}

	public static double getStandardDeviation(double[] values) {
		return Math.sqrt(getVariance(values));
	}

}