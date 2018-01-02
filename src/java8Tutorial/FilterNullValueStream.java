package java8Tutorial;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterNullValueStream {
	public static void main(String[] args) {
		
		System.out.println("6.Java 8 – Filter a null value from a Stream");
		
		Stream<String> language1 = Stream.of("java", "python", "node", null, "ruby", null, "php");
		Stream<String> language2 = Stream.of("java", "python", "node", null, "ruby", null, "php");
		Stream<String> language3 = Stream.of("java", "python", "node", null, "ruby", null, "php");
		//
		System.out.println("Java 8 – Filter a null value from a Stream");
		System.out.println("1.전체 출력");
		List<String> result1 = language1.collect(Collectors.toList());
		System.out.println(result1);
		//
		System.out.println("2.null이 아닌 것만 모으기(filter by lambda expression)");
		List<String> result2 = language2.filter(x->(x != null)).collect(Collectors.toList());
		System.out.println(result2);
		//
		System.out.println("3.null이 아닌 것만 모으기(filter by Objects::nonNull)");
		List<String> result3 = language3.filter(Objects::nonNull).collect(Collectors.toList());
		System.out.println(result3);
	}
}
