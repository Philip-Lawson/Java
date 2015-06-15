package projecteulerproblems;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

import projecteulerproblems.EvenFibonacciSummer;

/**
 * Unit test for the EvenFibonacciSummer class.
 * 
 * @author Phil
 *
 */
public class EvenFibonacciSummerTest {

	int expected, upperLimit, numberOfFibonaccis;
	
	@Before
	public void setUp() throws Exception {
				
		// The answer was found manually to avoid self-referential testing.		 
		expected = 4613732;
		upperLimit = 4000000;
		
		// there are 11 even Fibonacci numbers between 1 - 4,000,000
		numberOfFibonaccis = 11;
	}
	
	@Test
	public void testSumOfEvenFibonacciNumbersUpTo() {			
		int actual =  EvenFibonacciSummer.sumOfEvenFibonacciNumbersUpTo(upperLimit);		
		assertEquals(expected, actual);				
	}
	
	@Test
	public void testSumOfTheFirstNFibonaccis() {
		BigInteger actual = EvenFibonacciSummer.sumOfTheFirstNEvenFibonacciNumbers(numberOfFibonaccis);
		assertEquals(BigInteger.valueOf(expected), actual);		
	}

}
