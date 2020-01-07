package hr;

import java.util.HashSet;
import java.util.Set;

public class E01SockCounts {

	static int sockMerchant(int n, int[] ar) {
		Set<Integer> counts = new HashSet<Integer>();
		int result = 0;
		for (int i : ar) {
			if (counts.remove(i)) {
				result++;
			} else {
				counts.add(i);
			}
		}
		return result;
	}
}
