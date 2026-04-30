
/**
 * @author Lucas Larry
 *
 */
public class NumToWordsUsingMethod {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// complete the code to print text value of 8, 9 and 10
		printMyWord(8);
		printMyWord(9);
		printMyWord(10);
	}

	private static void printMyWord(int i) {
		final String numText;

		if (i == 1) {
			numText = "ONE";
		} else if (i == 2) {
			numText = "TWO";
		} else if (i == 3) {
			numText = "THREE";
		} else if (i == 4) {
			numText = "FOUR";
		} else if (i == 5) {
			numText = "FIVE";
		} else if (i == 6) {
			numText = "SIX";
		} else if (i == 7) {
			numText = "SEVEN";
		} else if (i == 8) {
			numText = "EIGHT";
		} else if (i == 9) {
			numText = "NINE";
		} else if (i == 10) {
			numText = "TEN";
		} else {
			numText = "NUMBER " + i;
		}

		System.out.println(numText);
	}
}