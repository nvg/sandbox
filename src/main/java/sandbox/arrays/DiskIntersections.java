package sandbox.arrays;

import java.util.HashMap;
import java.util.Map;

public class DiskIntersections {

	private static final int MAX_COUNT = 10000000;

	/*
	 * We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array
	 * A of N non-negative integers, specifying the radiuses of the discs, is given.
	 * The J-th disc is drawn with its center at (J, 0) and radius A[J].
	 * 
	 * We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and
	 * K-th discs have at least one common point (assuming that the discs contain
	 * their borders).
	 */
	public int calculate(int[] A) {
		// treat the problem as a set of start- and endpoints of intervals.
		Map<Integer, Integer> starts = new HashMap<Integer, Integer>();
		Map<Integer, Integer> ends = new HashMap<Integer, Integer>();

		for (int i = 0; i < A.length; i++) {
			int startKey = i - A[i];
			if (!starts.containsKey(startKey)) {
				starts.put(startKey, 1);
			} else {
				starts.put(startKey, starts.get(i - A[i]) + 1);
			}

			int endKey = i + A[i];
			if (!ends.containsKey(endKey)) {
				ends.put(endKey, 1);
			} else {
				ends.put(endKey, starts.get(i - A[i]) + 1);
			}
		}

		//
		// now just scan the intervals from the left
		//
		int active = 0; // active interval that we are looking at right now
		int result = 0;		    
		for (int i = Math.negateExact(A.length); i < A.length; i++) {
			int start = starts.containsKey(i) ? starts.get(i) : 0;
			int end = ends.containsKey(i) ? ends.get(i) : 0;

			System.out.println("Looking at " + start + " " + end);
			
			result += (int) (active * start + (start * (start - 1)) / 2);
			if (result > MAX_COUNT) {
				return -1;
			}
			
			active += start;
			active -= end;
		}
		return result;
	}

}
