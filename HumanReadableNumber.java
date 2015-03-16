/**
 * Generates a human readable number from an int.
 */
import java.lang.StringBuffer;
import java.text.DecimalFormat;
public class HumanReadableNumber {
	private static final String[] numberName = {
		"Zero",
		"One",
		"Two",
		"Three",
		"Four",
		"Five",
		"Six",
		"Seven",
		"Eight",
		"Nine",
		"Ten",
		"Eleven",
		"Twelve",
		"Thirteen",
		"Fourteen",
		"Fifteen",
		"Sixteen",
		"Seventeen",
		"Eighteen",
		"Nineteen"
	};
	private static final String[] tens = {
		"",
		"Ten",
		"Twenty",
		"Thirty",
		"Fourty",
		"Fifty",
		"Sixty",
		"Seventy",
		"Eighty",
		"Ninety"
	};
	private static String[] seperators = {
		"",
		"Thousand",
		"Million",
		"Billion",
		"Trillion"
	};


	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		DecimalFormat formatter = new DecimalFormat("###,###,###,###");
		System.out.println(formatter.format(num));
		System.out.println(humanReadableNumber(num));
	}
	public static String humanReadableNumber(int num) {
		int part = 1;
		StringBuffer output = new StringBuffer();
		if(num == 0)
			return numberName[0];
		int numLength = (int)Math.log10(num);

		int start = (int)(Math.ceil(numLength/3)*3);
		for(int i=start; i>=0; i-=3) {
			part = (num / (int)Math.pow(10,i)) % 1000;

			int hundred = part/100;
			if(hundred>0) {
				output.append(numberName[hundred]);
				output.append(" hundred ");
			}

			int lastTwoDigits = part%100;
			if(part == 0) {
				// will never happen, but otherwise will have to
				// put !=0 in the next two if blocks
			} else {
				if(hundred>0) {
					output.append("and ");
				}
				if(lastTwoDigits < numberName.length) {
				output.append(numberName[lastTwoDigits]);
				output.append(" ");
				} else {
					int ten = (part/10)%10;

					if(ten>0) {
						output.append(tens[ten]);
						output.append(" ");
						part%=10;
					}

					int ones = part%10;

					if(ones>0) {
						output.append(numberName[ones]);
						output.append(" ");
					}
				}
			}
			if(i>0) {
				output.append(seperators[i/3]);
				output.append(", ");
			}
		}
		int padding = part == 0 ? 2 : 1;
		output.deleteCharAt(output.length() - padding);

		return output.toString();
	}

}