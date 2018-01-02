package java8Tutorial;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterMap {
	public static void main(String[] args) {
		System.out.println("12. Java 8 – Filter a Map examples");
		Map<Integer, String> HOSTING = new HashMap<>();
		HOSTING.put(1, "linode.com");
		HOSTING.put(2, "heroku.com");
		HOSTING.put(3, "digitalocean.com"); // digitalocean.com
		HOSTING.put(4, "aws.amazon.com");
		System.out.println(HOSTING);
		//
		System.out.println("1.Before Java 8");
		String result1 = null;
		for (Map.Entry<Integer, String> entry : HOSTING.entrySet()) {
			if ("aws.amazon.com".equals(entry.getValue()))
				result1 = entry.getValue();
		}
		System.out.println(result1);
		System.out.println();

		System.out.println("2.Map -> Stream -> Filter -> String");
		result1 = HOSTING.entrySet().stream().filter(m -> !m.getValue().equals("aws.amazon.com")).map(m -> m.getValue())
				.collect(Collectors.joining(","));
		System.out.println(result1);

		System.out.println("3.Map -> Stream -> Filter -> MAP");
        //filter by value
		Map<Integer, String> collect1 = HOSTING.entrySet().stream().filter(m -> m.getValue().equals("aws.amazon.com"))
				.collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
		System.out.println(collect1);
		// filter by key
		Map<Integer, String> collect2 = HOSTING.entrySet().stream().filter(m->m.getKey() == 4)
				.collect(Collectors.toMap(p->p.getKey(), p->p.getValue()));
		System.out.println(collect2);
	}
}
