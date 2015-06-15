/**
 * 
 */
package projecteulerproblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This class contains static methods for generating prime numbers. </br>
 * 
 * It has three different methods to generate prime numbers. All methods are
 * limited to primes lower than Integer.MAX_VALUE. <br>
 * 
 * </br> (1) Outputs all the primes between 1 and a specified upper limit. </br>
 * (2) Returns a list of primes between 1 and a specified upper limit. </br> (3)
 * Returns a list of the first <i>n</i> primes.
 * 
 * @author Phil
 *
 */
public class PrimeNumberGenerator {

	/**
	 * Used to format the output primes method.
	 */
	private static int NO_OF_PRIMES_PER_LINE = 5;

	/**
	 * Outputs the primes between one and the specified upper limit to the
	 * console. This is limited to Integer.MAX_VALUE.
	 * 
	 * @param upperLimit
	 *            all the primes between 1 and the specified upper limit.
	 *            Validation is provided against null and minus numbers.
	 */
	public static void outputPrimesBetweenOneAnd(Integer upperLimit) {
		upperLimit = validateNumberEntered(upperLimit);
		List<Integer> listOfPrimes = generateListOfPrimes(upperLimit);
		outputPrimes(upperLimit, listOfPrimes);
	}

	/**
	 * Returns a list of primes between one and the specified upper limit. This
	 * is limited to Integer.MAX_VALUE.
	 * 
	 * @param upperLimit
	 *            all the primes between 1 and the specified upper limit.
	 *            Validation is provided against null and minus numbers.
	 * 
	 * @return a list of primes between 1 and the specified upper limit.
	 */
	public static List<Integer> getPrimesBetweenOneAnd(Integer upperLimit) {
		upperLimit = validateNumberEntered(upperLimit);
		return generateListOfPrimes(upperLimit);
	}

	/**
	 * Returns a list of the first <i>n</i> primes. This is limited to primes
	 * smaller than Integer.MAX_VALUE.
	 * 
	 * @param numberOfPrimes
	 *            the number of primes to be generated. Validation is provided
	 *            against null and minus numbers.
	 * @return a list of the first <i>n</i> primes.
	 */
	public static List<Integer> getFirstNPrimes(Integer numberOfPrimes) {
		numberOfPrimes = validateNumberEntered(numberOfPrimes);

		/*
		 * since the number of primes is known in advance an ArrayList is used
		 * for optimal use of memory.
		 */
		List<Integer> listOfPrimes = new ArrayList<Integer>(numberOfPrimes);

		/*
		 * This method starts counting at three and increments in twos to avoid
		 * unnecessary checking of even numbers. At the end of calculation the
		 * first prime number(2) is added to the start of the list.
		 *
		 * The use of numberOfPrimes-1 leaves space to add the first prime
		 * number at the end. Checking for count>0 validates against potential
		 * Integer overflow.
		 */
		int count = 3;
		
		while (listOfPrimes.size() < numberOfPrimes - 1 && count > 0) {
			if (isPrime(count, listOfPrimes)) {
				listOfPrimes.add(count);
			}

			count += 2;
		}

		listOfPrimes.add(0, 2);

		return listOfPrimes;
	}

	/**
	 * Helper method converts minus numbers to positive numbers and returns zero
	 * if the integer entered is null.
	 * 
	 * @param numberEntered
	 *            the number to be validated.
	 * @return the sanitised number.
	 */
	private static int validateNumberEntered(Integer numberEntered) {
		if (numberEntered == null) {
			return 0;
		} else {
			return Math.abs(numberEntered);
		}

	}

	/**
	 * 
	 * @param upperLimit
	 * @return
	 */
	private static List<Integer> generateListOfPrimes(int upperLimit) {
		/*
		 * since the number of primes is not known in advance a LinkedList is
		 * used to avoid performance hits from dynamic resizing.
		 */
		LinkedList<Integer> listOfPrimes = new LinkedList<Integer>();

		/*
		 * This method starts counting at three and increments in twos to avoid
		 * unnecessary checking of even numbers. At the end of calculation the
		 * first prime number(2) is added at the start of the list.
		 */
		for (int count = 3; count <= upperLimit; count += 2) {
			if (isPrime(count, listOfPrimes)) {
				listOfPrimes.add(count);
			}
		}

		listOfPrimes.addFirst(2);

		return listOfPrimes;
	}

	/**
	 * Helper method for checking if a number is prime. Returns true if the
	 * number is prime.
	 * 
	 * @param num
	 *            the number to be verified as prime.
	 * @param listOfPrimes
	 *            a list of prime numbers.
	 * @return true if the number is prime.
	 */
	private static boolean isPrime(int num, List<Integer> listOfPrimes) {

		/*
		 * Since every non-prime number is the sum of two prime numbers this
		 * loop only checks that the candidate prime number is divisible with a
		 * prime number.
		 */
		for (Integer primeNumber : listOfPrimes) {
			if (num % primeNumber == 0) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Helper method prints the primes found to the screen.
	 * 
	 * @param upperLimit
	 *            the specified upper limit e.g. primes between one and the
	 *            upper limit.
	 * @param listOfPrimes
	 *            the list of primes generated.
	 */
	private static void outputPrimes(int upperLimit, List<Integer> listOfPrimes) {

		// output the specified number of primes per line
		for (int count = 0; count < listOfPrimes.size(); count++) {
			if (count % NO_OF_PRIMES_PER_LINE == 0 && count != 0) {
				System.out.println();
			}

			System.out.print(listOfPrimes.get(count) + "\t ");
		}

		System.out.println("There are " + listOfPrimes.size()
				+ " primes between 1 and " + upperLimit);

	}

}
