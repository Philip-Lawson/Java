package projecteulerproblems;

import java.math.BigInteger;

/**
 * Project Euler - Problem 16 and 20.<br></br>
 * Calculates the sum of the digits in <br>
 * (a) two to the power of <i>n</i> <br>
 * (b) N factorial
 * 
 * @author Phil
 *
 */
public class DigitSum {

	/**
	 * Sums the digits in two to the power of <i>n</i>.
	 * 
	 * @param power the power of two required
	 * @return the sum of the digits in 2^N
	 */
	public static int sumOfDigitsInTwoToPowerOf(int power) {
		return sumDigitsInNumber(calculateTwoToPowerOf(power));
	}

	/**
	 * Sums the digits in a factorial number.
	 * 
	 * @param factorial the factorial number required (e.g. !4)
	 * @return
	 */
	public static int sumOfFactorials(int factorial) {
		return sumDigitsInNumber(calculateFactorialIteratively(factorial));
	}

	/**
	 * Helper Method. Calculates 2^N. 
	 * <br>Only valid for N >= 0.
	 *  
	 * @param power
	 * @return 2^N
	 */
	private static BigInteger calculateTwoToPowerOf(int power) {
		if (power <= 0) {
			return BigInteger.ZERO;
		}

		BigInteger total = BigInteger.ONE;

		for (int count = 1; count <= power; count++) {
			total = total.multiply(BigInteger.valueOf(2));
		}

		return total;
	}

	/**
	 * Calculates the factorial recursively. 
	 * Deprecated as it doesn't scale well. 
	 * 
	 * @param topFactorial
	 * @return
	 */
	@Deprecated
	private static BigInteger calculateFactorial(int topFactorial) {
		if (topFactorial == 1) {
			return BigInteger.ONE;
		} else {
			return BigInteger.valueOf(topFactorial).multiply(
					calculateFactorial(topFactorial - 1));
		}
	}

	/**
	 * Helper method. Calculates !N iteratively as the recursive method didn't
	 * scale well.
	 * 
	 * @param topFactorial the N in !N
	 * @return the answer to !N
	 */
	private static BigInteger calculateFactorialIteratively(int topFactorial) {
		BigInteger total = BigInteger.ONE;

		for (int count = 1; count <= topFactorial; count++) {
			total = total.multiply(BigInteger.valueOf(count));
		}

		return total;
	}

	/**
	 * Helper method sums the digits in a number.
	 * 
	 * @param number
	 * @return the sum of the individual digits in a number.
	 */
	private static int sumDigitsInNumber(BigInteger number) {
		String numberString = number.toString();
		int total = 0;
		Integer currentNumber;

		for (int count = 0; count < numberString.length(); count++) {
			String num = numberString.charAt(count) + "";
			currentNumber = Integer.parseInt(num);
			total += currentNumber;
		}

		return total;
	}

}
