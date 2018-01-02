package java8Tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//2.1 A student POJO
class Student {
	private String name;
	private Set<String> book;

	public void addBook(String book) {
		if (this.book == null)
			this.book = new HashSet<>();
		this.book.add(book);
	}

	public String getName() {
		return name;
	}

	public Set<String> getBook() {
		return book;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBook(Set<String> book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return String.format("Student [name=%s, book=%s]", name, book);
	}

}

// In Java 8, Stream can hold different data types, for examples:
// Stream<String[]>
// Stream<Set<String>>
// Stream<List<String>>
// Stream<List<Object>>
//
// But, the Stream operations (filter, sum, distinct…) and collectors do not
// support it,
// so, we need flatMap() to do the following conversion :
// Stream<String[]> -> flatMap -> Stream<String>
// Stream<Set<String>> -> flatMap -> Stream<String>
// Stream<List<String>> -> flatMap -> Stream<String>
// Stream<List<Object>> -> flatMap -> Stream<Object>
//
// How flatMap() works :
// { {1,2}, {3,4}, {5,6} } -> flatMap -> {1,2,3,4,5,6}
// { {'a','b'}, {'c','d'}, {'e','f'} } -> flatMap -> {'a','b','c','d','e','f'}

public class FlatMap {
	public static void main(String[] args) {
		System.out.println("13. Java 8 flatMap example");
        System.out.println();

		String[][] data = new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" } };

		System.out.println("1. Stream + String[] + flatMap");

		System.out.println(
				"1.1 The below example will print an empty result, because filter() has no idea how to filter a stream of String[]");
		// Stream<String[]>
		Stream<String[]> temp1 = Arrays.stream(data);
		// 1. filter a stream of string[], and return a string[] ?
		Stream<String[]> stream1 = temp1.filter(x -> "a".equals(x.toString()));
		stream1.forEach(System.out::println); // empty
		System.out.println("empty");

		System.out.println(
				"1.2 In above example, we should use flatMap() to convert Stream<String[]> to Stream<String>.");
		// Stream<String[]>
		Stream<String[]> temp2 = Arrays.stream(data);
		// Stream<String>, GOOD!
		Stream<String> stringStream2 = temp2.flatMap(x -> Arrays.stream(x));
		Stream<String> stream2 = stringStream2.filter(x -> "a".equals(x.toString()));
		stream2.forEach(System.out::println);
		// 아래와 동일
		Stream<String> stream3 = Arrays.stream(data).flatMap(x -> Arrays.stream(x))
				.filter(x -> "a".equals(x.toString()));
		stream3.forEach(System.out::println);
        System.out.println();

		System.out.println("2. Stream + Set + flatMap");
		Student obj1 = new Student();
		obj1.setName("mkyong");
		obj1.addBook("Java 8 in Action");
		obj1.addBook("Spring Boot in Action");
		obj1.addBook("Effective Java (2nd Edition)");
		Student obj2 = new Student();
		obj2.setName("zilap");
		obj2.addBook("Learning Python, 5th Edition");
		obj2.addBook("Effective Java (2nd Edition)");

		List<Student> list = new ArrayList<>();
		list.add(obj1);
		list.add(obj2);
		System.out.println(list);
		
		List<String> collect = list.stream().map(x -> x.getBook()) // Stream<Set<String>>
				.flatMap(x -> x.stream()) // Stream<String>
				.distinct().collect(Collectors.toList());
		collect.forEach(x -> System.out.println(x));
        System.out.println();
		
		System.out.println("3. Stream + Primitive + flatMapToInt");
		
        int[] intArray = {1, 2, 3, 4, 5, 6};
        //1. Stream<int[]>
        Stream<int[]> streamArray = Stream.of(intArray);
        //2. Stream<int[]> -> flatMap -> IntStream
        IntStream intStream = streamArray.flatMapToInt(x -> Arrays.stream(x));
        intStream.forEach(x->System.out.printf(" %d", x));
        System.out.println();
		
	}
}
