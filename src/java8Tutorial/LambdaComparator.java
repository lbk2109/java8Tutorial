package java8Tutorial;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class Developer {
	String name;
	BigDecimal salary;
	int age;

	public Developer(String name, BigDecimal salary, int age) {
		super();
		this.name = name;
		this.salary = salary;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		return (sb.append("[").append(name).append(",").append(salary).append(",").append(age).append("]").toString());
	}

}

public class LambdaComparator {

	public static void main(String[] args) {

		System.out.println("1. Java 8 Lambda : Comparator example");
		
		List<Developer> listDevs = getDevelopers();

		System.out.println("Before Sort");
		listDevs.forEach((developer) -> System.out.println(developer));

		System.out.println();
		System.out.println("After Sort");
		// lambda here!
		listDevs.sort((Developer o1, Developer o2) -> o1.getAge() - o2.getAge());
		// listDevs.sort((Developer o1, Developer
		// o2)->o1.getName().compareTo(o2.getName()));
		// listDevs.sort((Developer o1, Developer
		// o2)->o1.getSalary().compareTo(o2.getSalary()));

		// java 8 only, lambda also, to print the List
		listDevs.forEach((developer) -> System.out.println(developer));
	}

	private static List<Developer> getDevelopers() {
		List<Developer> result = new ArrayList<Developer>();
		result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
		result.add(new Developer("alvin", new BigDecimal("80000"), 20));
		result.add(new Developer("jason", new BigDecimal("100000"), 10));
		result.add(new Developer("iris", new BigDecimal("170000"), 55));
		return result;
	}
}