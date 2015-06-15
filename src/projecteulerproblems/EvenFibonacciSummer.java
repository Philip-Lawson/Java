/**
 * 
 */
package projecteulerproblems;

import java.math.BigInteger;

/**
 * Project Euler - Problem 2 This class sums even Fibonacci numbers. <br> It can be
 * used to find - <br> (a) the sum of even Fibonacci numbers up to <i>n</i>
 * <br> (b) the sum of the first <i>n</i> even Fibonacci numbers
 * 
 * @author Phil
 *
 */
public class EvenFibonacciSummer {

	/**
	 * Sums all the even Fibonacci numbers between one and <i>n</i>.
	 * 
	 * @param upperLimit 
	 * @return the sum of all even numbers between one and <i>n</i>.
	 */
	public static int sumOfEvenFibonacciNumbersUpTo(int upperLimit) {
		
		/* set the first and second non-zero Fibonacci numbers
		 * to allow the calculation to work	
		 */
		int previousFibonacci = 1;
		int fibonacci = 2;
		int total = 0;

		while (fibonacci <= upperLimit) {
			if (fibonacci % 2 == 0) {
				total += fibonacci;
			}

			fibonacci += previousFibonacci;
			previousFibonacci = fibonacci - previousFibonacci;
		}

		return total;
	}

	/**
	 * Sums the first <i>n</i> even Fibonacci numbers.
	 * 
	 * @param n
	 * @return the sum of the first <i>n</i> even Fibonacci numbers.
	 */
	public static BigInteger sumOfTheFirstNEvenFibonacciNumbers(
			int n) {
		BigInteger total = BigInteger.valueOf(0);
		BigInteger fibonacci = BigInteger.valueOf(2);
		BigInteger previousFibonacci = BigInteger.valueOf(1);

		
		// The first even fibonacci number has been preset above.		 
		int currentPosition = 1;
		// changed to aid readability
		int positionInSequence = n;

		while (currentPosition <= positionInSequence) {
			if (fibonacci.mod(BigInteger.valueOf(2)).equals(
					BigInteger.valueOf(0))) {
				total = total.add(fibonacci);

				currentPosition++;
			}

			fibonacci = fibonacci.add(previousFibonacci);
			previousFibonacci = fibonacci.subtract(previousFibonacci);

		}

		return total;
	}
}
