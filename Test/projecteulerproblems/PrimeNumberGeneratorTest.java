package projecteulerproblems;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import projecteulerproblems.PrimeNumberGenerator;

public class PrimeNumberGeneratorTest {

	private static final int UPPER_LIMIT = 100000;
	private static final int MILLIS_PER_PRIME = 78;
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test (timeout = UPPER_LIMIT * MILLIS_PER_PRIME)
	public void testCalculatePrimesUpTo() {		
		PrimeNumberGenerator.getFirstNPrimes(UPPER_LIMIT);
	}

}
