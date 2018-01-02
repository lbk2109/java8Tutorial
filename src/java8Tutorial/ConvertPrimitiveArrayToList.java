package java8Tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConvertPrimitiveArrayToList {
	private static List<Integer> convertIntArrayToList(int[] input) {

		List<Integer> list = new ArrayList<>();
		for (int i : input) {
			list.add(i);
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println("21. Java – How to convert a primitive Array to List");

		System.out.println("1. Classic Example");
		int[] number = { 1, 2, 3, 4, 5, 6, 7, 8, 9, -999999999 };
		List<Integer> list = convertIntArrayToList(number);
		System.out.println("list : " + list);
		// Note
		// You can’t use the popular Arrays.asList to convert it directly,
		// because boxing issue.
		//List<int[]> ints = Arrays.asList(number);
		
		System.out.println("2. Java 8 Stream");
        // IntStream.of or Arrays.stream, same output
        list = IntStream.of(number).boxed().collect(Collectors.toList());
        System.out.println("list : " + list);		
        list = Arrays.stream(number).boxed().collect(Collectors.toList());
        System.out.println("list : " + list);		
		
	}
}
