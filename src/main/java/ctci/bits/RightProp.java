package ctci.bits;

public class RightProp {
		
	public static int rightPropagate(int n) {
		int i = 0;
		for (; i < Integer.BYTES * 8; i++) {
			if (getBit(n, i) == 1) {
				break;
			}
		}
		
		if (i == Integer.BYTES * 8) {
			return n;
		}
		
		int count = 1;
		for(int j = 0; j <= i; j++) {
			n |= count;
			count = count << 1;
		}
		
		return n;
	}

	private static int getBit(int n, int k) {
		return (n >> k) & 1;
	}
}
