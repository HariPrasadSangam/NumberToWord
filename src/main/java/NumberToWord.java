import java.util.Scanner;


/*
 * Number to Word
 * ~~~~~~~~~~~~~~
 *
 * This class is to convert number to word, which takes
 * an integer (ex. 333) and returns the number in word form (eg "three hundred
 * and thirty three").
 *
 */
public class NumberToWord

{
	private static final String[] specialNames = { "", " thousand", " million" };

	private static final String[] tensNames = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty",
			" seventy", " eighty", " ninety" };

	private static final String[] numNames = { "", " one", " two", " three", " four", " five", " six", " seven",
			" eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen",
			" seventeen", " eighteen", " nineteen" };

	private String convertLessThanOneThousand(int number) {
		String currentValue;
		String returnValue;

		if (number % 100 < 20) {
			currentValue = numNames[number % 100];
			number /= 100;
		} else {
			currentValue = numNames[number % 10];
			number /= 10;

			currentValue = tensNames[number % 10] + currentValue;
			number /= 10;
		}
		if (number == 0) {
			return currentValue;
		} else {
			returnValue = currentValue.trim().equals("") ? numNames[number] + " hundred" : numNames[number] + " hundred and" + currentValue;
		}
		return returnValue;
	}

	
	/**
	 * Method to convert number to word
	 * @param number
	 * @return
	 */
	public String convert(int number) {

		if (number == 0) {
			return "zero";
		}

		if (number < 0) {
			System.out.println("Please enter a valid number");
			return null;
		}

		String current = "";
		int place = 0;

		do {
			int n = number % 1000;
			if (n != 0) {
				String s = convertLessThanOneThousand(n);
				current = s + specialNames[place] + current;
			}
			place++;
			number /= 1000;
		} while (number > 0);

		return (current).trim();
	}

	public static void main(String[] args) {
		int number = 0;
		NumberToWord obj = new NumberToWord();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please type a number(max upto 9 digits)");
		try {
			// read the number
			number = scanner.nextInt();
			if (number == 0) {
				System.out.print("0 = Zero");
			} else {
				System.out.print(number + " = " + obj.convert(number));
			}
		} catch (Exception e) {
			System.out.println("Please enter a valid number");
		} finally {
			// close the reader
			scanner.close();
		}
	}
}