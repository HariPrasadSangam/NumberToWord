
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/*
 * Number to Word Test
 * ~~~~~~~~~~~~~~~~~~~
 *
 * This class is to test the NumberToWords.convert method, which takes
 * an integer (ex. 111) and returns the number in word form (eg "one hundred
 * and eleven").
 *
 */
public class NumberToWordTest {

	private NumberToWord numberToWord;

	@Before
	public void before() {
		numberToWord = new NumberToWord();
	}

	@Test
	public void convertsZero() {
		expectConversion(0, "zero");
	}

	@Test
	public void convertsSingleDigits() {
		expectConversion(1, "one");
		expectConversion(2, "two");
		expectConversion(3, "three");
		expectConversion(4, "four");
		expectConversion(5, "five");
		expectConversion(6, "six");
		expectConversion(7, "seven");
		expectConversion(8, "eight");
		expectConversion(9, "nine");
	}

	@Test
	public void convertsTenToNineteen() {
		expectConversion(10, "ten");
		expectConversion(11, "eleven");
		expectConversion(12, "twelve");
		expectConversion(13, "thirteen");
		expectConversion(14, "fourteen");
		expectConversion(15, "fifteen");
		expectConversion(16, "sixteen");
		expectConversion(17, "seventeen");
		expectConversion(18, "eighteen");
		expectConversion(19, "nineteen");
	}

	@Test
	public void convertsMultiplesOfTenUpToNinety() {
		expectConversion(20, "twenty");
		expectConversion(30, "thirty");
		expectConversion(40, "forty");
		expectConversion(50, "fifty");
		expectConversion(60, "sixty");
		expectConversion(70, "seventy");
		expectConversion(80, "eighty");
		expectConversion(90, "ninety");
	}

	@Test
	public void convertsArbitraryTwoDigitNumbers() {
		expectConversion(63, "sixty three");
	}

	@Test
	public void convertsHundreds() {
		expectConversion(300, "three hundred");
		expectConversion(600, "six hundred");
	}

	@Test
	public void convertsArbitraryThreeDigitNumbers() {
		expectConversion(560, "five hundred and sixty");
		expectConversion(209, "two hundred and nine");
	}

	@Test
	public void convertsThousands() {
		expectConversion(6000, "six thousand");
		expectConversion(8000, "eight thousand");
	}

	@Test
	public void convertsArbitraryFourDigitNumbers() {
		expectConversion(1234, "one thousand two hundred and thirty four");
		expectConversion(9600, "nine thousand six hundred");
		expectConversion(2050, "two thousand fifty");
		expectConversion(7008, "seven thousand eight");
	}

	@Test
	public void convertsArbitraryFiveAndSixDigitNumbers() {
		expectConversion(340000, "three hundred and forty thousand");
		expectConversion(600500, "six hundred thousand five hundred");
		expectConversion(200000, "two hundred thousand");
		expectConversion(12030, "twelve thousand thirty");
	}

	private void expectConversion(final int number, final String expectedWords) {
		assertEquals(expectedWords, numberToWord.convert(number));
	}

	@After
	public void after() {
		numberToWord = null;
	}
}