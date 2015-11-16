package com.stekodyne.euler;

import static org.junit.Assert.*;

import org.junit.Test;

public class OneTest {

	@Test
	public void testRun() {
		long solution = One.run(10);
		assertEquals("Should equal 23!", 23, solution);
	}
        
        @Test
	public void testRunBig() {
		long solution = One.run(1000);
		assertEquals("Should equal 233168!", 233168, solution);
	}
}
