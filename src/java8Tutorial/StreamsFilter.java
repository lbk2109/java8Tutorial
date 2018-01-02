package java8Tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		return sb.append("[").append(name).append(",").append(age).append("]").toString();
	}
}

public class StreamsFilter {
	public static void main(String[] args) {

		System.out.println("3.Java 8 Streams filter examples");
		//
		// 1.Streams filter() and collect()
		//
		System.out.println("1.Streams filter() and collect()");
		List<String> list = Arrays.asList("spring", "node", "설현");
		//
		System.out.println("1.1");
		List<String> result = getFilterOutput(list);
		result.forEach(l -> System.out.println(l));
		System.out.println();

		// java8
		System.out.println("1.2");
		list.stream().filter(l -> !l.equals("설현")).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println();

		//
		// 2.Streams filter(), findAny() and orElse()
		//
		System.out.println("2.Streams filter(), findAny() and orElse()");
		List<Person> persons = Arrays.asList(new Person("홍길동", 51), new Person("임꺽정", 52), new Person("황진희", 53),
				new Person("이성계", 54), new Person("홍길동", 20));
		System.out.println("2.1");
		persons.forEach(l -> System.out.println(l));
		System.out.println();
		//
		System.out.println("2.2");
		Person result1 = persons.stream().filter(l -> "홍길동".equals(l.getName())).findAny().orElse(null);
		System.out.println(result1);
		System.out.println("2.3");
		Person result2 = persons.stream().filter(l -> "설현".equals(l.getName())).findAny().orElse(null);
		System.out.println(result2);
		System.out.println();
		System.out.println("2.4");
		Person result3 = persons.stream().filter(l -> "홍길동".equals(l.getName()) && 20 == l.getAge()).findAny()
				.orElse(null);
		System.out.println(result3);
		//
		System.out.println("2.5");
		Person result4 = persons.stream().filter(l -> {
			if ("홍길동".equals(l.getName()) && 20 == l.getAge())
				return true;
			return false;
		}).findAny().orElse(null);
		System.out.println(result4);
		System.out.println();
		
		//
		// 3. Streams filter() and map()
		//
		System.out.println("3. Streams filter() and map()");
		System.out.println("3.1");
		String name = persons.stream().filter(l->"홍길동".equals(l.getName())).map(Person::getName).findAny().orElse(null);
		System.out.println(name);
		
		System.out.println("3.2");
		List<String> collect = persons.stream().map(Person::getName).collect(Collectors.toList());
		collect.forEach(System.out::println);
	}

	static List<String> getFilterOutput(List<String> list) {
		List<String> result = new ArrayList<>();
		for (String l : list) {
			if (!l.equals("설현"))
				result.add(l);
		}
		return result;
	}
}
