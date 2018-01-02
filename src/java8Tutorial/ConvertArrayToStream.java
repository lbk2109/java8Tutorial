package java8Tutorial;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConvertArrayToStream {
	public static void main(String[] args) {
		
		System.out.println("8.Java – How to convert Array to Stream");
		
		System.out.println("1. Object Arrays");
		String[] array = {"a","b","c","d","e"};
		
		System.out.println("Arrays.stream");
		Stream<String> stream1 = Arrays.stream(array);
		stream1.forEach(x->System.out.println(x));
		
		System.out.println("Arrays.stream");
		Stream<String> stream2 = Stream.of(array);
		stream2.forEach(System.out::println);
        //		
		System.out.println("2. Primitive Arrays");
		int[] intarray = {1, 2, 3, 4, 5};

		System.out.println("2.1. Arrays.stream -> IntStream");
		IntStream intStream1 = Arrays.stream(intarray);
		intStream1.forEach(x->System.out.printf("%d\n", x));
		
		System.out.println("2.2. Stream.of -> Stream<int[]>");
		Stream<int[]> temp = Stream.of(intarray);
		IntStream intStream2 = temp.flatMapToInt(x->Arrays.stream(x));
		intStream2.forEach(x->System.out.println(x));
        //아래와동일
		Stream.of(intarray).flatMapToInt(x->Arrays.stream(x)).forEach(System.out::println);
	}
}
