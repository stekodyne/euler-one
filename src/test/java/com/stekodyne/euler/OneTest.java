package com.stekodyne.euler;

import static org.junit.Assert.*;

import org.junit.Test;

public class OneTest {

	@Test
	public void testRun() {
		int solution = One.run(10);
		assertEquals("Should equal 23!", 23, solution);
	}

}
