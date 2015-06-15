package projecteulerproblems;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import projecteulerproblems.DigitSum;

public class PowerDigitSumTest {

	private static final int TIMEOUT_THRESHOLD = 800;
	private static final int NO_OF_CYCLES = 20;

	int powerOfTwo, topFactorial, expectedPowerOfTwoSum, expectedFactorialSum;

	@Before
	public void setUp() throws Exception {

		powerOfTwo = 1000;
		topFactorial = 10000;
		expectedPowerOfTwoSum = 1366;
		expectedFactorialSum = 27;

	}

	@Test
	public void testSumOfDigitsInTwoToPowerOf() {		
		int actual = DigitSum.sumOfDigitsInTwoToPowerOf(powerOfTwo);

		assertEquals(expectedPowerOfTwoSum, actual);
	}

	@Test
	public void testSumOfDigitsInFactorial(){		
		int actual = DigitSum.sumOfFactorials(10);
		
		assertEquals(expectedFactorialSum, actual);
	}

	/**
	 * Tests the time taken to calculate the sum of the digits in a large
	 * factorial number.
	 */
	@Test(timeout = TIMEOUT_THRESHOLD)
	public void testTimeToSumDigitsInLargeFactorial() {
		DigitSum.sumOfFactorials(topFactorial);
	}

	/**
	 * Tests the sumOFFactorials method over a number of cycles to determine an
	 * average summing time.
	 */
	@Test(timeout = TIMEOUT_THRESHOLD * NO_OF_CYCLES)
	public void testAverageSummingTime() {
		for (int count = 0; count < NO_OF_CYCLES; count++) {
			testTimeToSumDigitsInLargeFactorial();
		}
	}

}
