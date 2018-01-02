package java8Tutorial;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


class Staff {
	String name;
	int age;
	BigDecimal salary;

	public Staff(String name, int age, BigDecimal salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}

class StaffPublic {
	private String name;
	private int age;
	private String extra;

	public StaffPublic(String name, int age, String extra) {
		this.name = name;
		this.age = age;
		this.extra = extra;
	}

	public String getName() {
		return name;
	}

	public StaffPublic() {
		super();
	}

	public int getAge() {
		return age;
	}

	public String getExtra() {
		return extra;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[").append(name).append(",").append(age).append(",").append(extra).append("]");

		return sb.toString();
	}
}

public class StreamsMap {
	public static void main(String[] args) {
		
		System.out.println("4.Java 8 Streams map() examples");
		
		List<String> alpha = Arrays.asList("a", "b", "c");
		// 1. A List of Strings to Uppercase
		System.out.println("1. A List of Strings to Uppercase");
		System.out.println("Before java8");
		System.out.println("1.1");
		List<String> alphaUpper = new ArrayList<>();
		for (String s : alpha) {
			alphaUpper.add(s.toUpperCase());
		}
		System.out.println(alpha);
		System.out.println(alphaUpper);
		//
		System.out.println("Java8");
		//
		System.out.println("1.2");
		List<String> collects = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(collects);
		//
		System.out.println("1.3");
		List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> collectn = num.stream().map(n -> n * 2).collect(Collectors.toList());
		System.out.println(collectn);

		//
		// 2. List of objects -> List of String
		//
		System.out.println("2. List of objects -> List of String");
		List<Staff> staff = Arrays.asList(new Staff("김유신", 11, new BigDecimal(10000)),
				new Staff("김춘추", 22, new BigDecimal(20000)), new Staff("소정방", 33, new BigDecimal(30000)));
		//
		System.out.println(2.1);
		List<String> result1 = new ArrayList<>();
		for (Staff s : staff) {
			result1.add(s.getName());
		}
		System.out.println(result1);
		//
		System.out.println(2.2);
		List<String> collect1 = staff.stream().map(Staff::getName).collect(Collectors.toList());
		System.out.println(collect1);
		//
		System.out.println(2.3);
		List<String> collect2 = staff.stream().map(x -> x.getName()).collect(Collectors.toList());
		System.out.println(collect2);

		//
		// 3. List of objects -> List of other objects
		//
		System.out.println("3. List of objects -> List of other objects");
		System.out.println(3.1);
		List<StaffPublic> result2 = convertToStaffPublic(staff);
		System.out.println(result2);
		//
		System.out.println(3.2);
		List<StaffPublic> result3 = staff.stream()				
				.map(temp -> {
				StaffPublic obj = new StaffPublic();
				obj.setName(temp.getName());
				obj.setAge(temp.getAge());
				if ("김춘추".equals(temp.getName()))
					obj.setExtra("김춘추만 등록할수 있습니다");
				return obj;
		  }
		).collect(Collectors.toList());
		System.out.println(result3);
	}

	static List<StaffPublic> convertToStaffPublic(List<Staff> staff) {
		List<StaffPublic> result = new ArrayList<>();
		for (Staff temp : staff) {
			StaffPublic obj = new StaffPublic();
			obj.setName(temp.getName());
			obj.setAge(temp.getAge());
			if ("김춘추".equals(temp.getName()))
				obj.setExtra("김춘추만 등록할수 있습니다");
			result.add(obj);
		}
		return result;
	}
}
