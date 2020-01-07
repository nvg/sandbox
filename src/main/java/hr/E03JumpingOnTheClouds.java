package hr;

public class E03JumpingOnTheClouds {

	static int jumpingOnClouds(int[] c) {
		int jumps = 0;

		int i = 0;
		while (i < c.length - 3) // goes through all clouds up until the last jump
		{
			i += (c[i + 2] == 0) ? 2 : 1;
			jumps++;
		}

		jumps++; // last jump
		return jumps;
	}

}
