package java8Tutorial;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamAlreadyClosed {
	public static void main(String[] args) {

		System.out.println("9.Java – Stream has already been operated upon or closed");
		System.out.println("1. Example – Stream is closed!");
		String[] array = { "a", "b", "c", "d", "e" };
		Stream<String> stream = Arrays.stream(array);

		// loop a stream
		stream.forEach(x -> System.out.println(x));

		// reuse it to filter again! throws IllegalStateException
		// long count1 = stream.filter(x -> "b".equals(x)).count();
		// System.out.println(count1);

		System.out.println("2. Example – Reuse a stream");
		Supplier<Stream<String>> streamSupplier = () -> Stream.of(array);
		// get new stream
		streamSupplier.get().forEach(x -> System.out.println(x));
		// get another new stream
		System.out.println();
		long count2 = streamSupplier.get().filter(x -> "b".equals(x)).count();
		System.out.println(count2);
	}
}
