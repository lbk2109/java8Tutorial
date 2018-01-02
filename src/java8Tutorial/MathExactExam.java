package java8Tutorial;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class MathExactExam {

	public static boolean contains(final int[] array, final int v) {
		boolean result = false;
		for (int i : array) {
			if (i == v) {
				result = true;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("22. Java 8 – Math Exact examples");
		// Java – Check if Array contains a certain value?

		String[] alphabet = new String[] { "A", "B", "D" };

		System.out.println("1. String Arrays");
		System.out.println("1.1 Check if a String Array contains a certain value “A”.");
		// Convert String Array to List
		List<String> list = Arrays.asList(alphabet);
		if (list.contains("A")) {
			System.out.println("Hello A");
		}
		// In Java 8, you can do this :
		// Convert to stream and test it
		boolean result1 = Arrays.stream(alphabet).anyMatch("A"::equals);
		if (result1) {
			System.out.println("Hello A");
		}
		System.out.println("1.2 Example to check if a String Array contains multiple values :");
		// A or B
		if (list.contains("A") || list.contains("B")) {
			System.out.println("Hello A or B");
		}
		// A and B
		if (list.containsAll(Arrays.asList("A", "B"))) {
			System.out.println("Hello A and B");
		}
		// A and C
		if (list.containsAll(Arrays.asList("A", "C"))) {
			System.out.println("Hello A and C");
		}

		System.out.println("2. Primitive Arrays");
		long[] lNumber = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] inumber = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println("2.1 For primitive array like int[], you need to loop it and test the condition manually :");
		if (contains(inumber, 2)) {
			System.out.println("Hello 2");
		}

		System.out.println("2.2 With Java 8, coding is much simpler ~");
		//Java 8
        boolean result2 = IntStream.of(inumber).anyMatch(x -> x == 4);
        if (result2) {
            System.out.println("Hello 4");
        } else {
            System.out.println("Where is number 4?");
        }
        boolean result3 = LongStream.of(lNumber).anyMatch(x -> x == 10);
        if (result3) {
            System.out.println("Hello 10");
        } else {
            System.out.println("Where is number 10?");
        }
	}
}
