package java8Tutorial;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertStreamToList {
	public static void main(String[] args) {
		
		System.out.println("1.Convert a Stream to a List via Collectors.toList");
		Stream<String>  language = Stream.of("java", "python", "node");		
		List<String>  result1 = language.collect(Collectors.toList());
		System.out.println(result1);
		
		System.out.println("2.filter a number 3 and convert it to a List");
		Stream<Integer> number = Stream.of(1, 2, 3, 4, 5);
		List<Integer> result2 = number.filter(i->i != 3).collect(Collectors.toList());
		System.out.println(result2);
//		result2.forEach(System.out::println);
//		result2.forEach(x->System.out.println(x));
//		result2.forEach(x->System.out.printf("%d ",x));
	}
}
