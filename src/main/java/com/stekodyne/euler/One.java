package com.stekodyne.euler;

public class One {

	public static int run(int upto) {
		Integer sum = 0;

		// Time complexity O(m + n + o)
		if (upto > 0) {

			for (int i = 1; i * 3 < upto; i++) {
				sum += (3 * i);
			}

			for (int i = 1; 5 * i < upto; i++) {
				sum += (5 * i);
			}

			for (int i = 1; 15 * i < upto; i++) {
				sum -= (15 * i);
			}

		}
		
		return sum;
	}

}
