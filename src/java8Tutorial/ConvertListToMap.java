package java8Tutorial;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Hosting {
	private int id;
	private String name;
	private long websites;

	public Hosting(int id, String name, long websites) {
		this.id = id;
		this.name = name;
		this.websites = websites;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getWebsites() {
		return websites;
	}

	@Override
	public String toString() {
		return String.format("Hosting [id=%s, name=%s, websites=%s]", id, name, websites);
	}

}

public class ConvertListToMap {
	public static void main(String[] args) {
		System.out.println("11. Java 8 – Convert List to Map");

		List<Hosting> list = new ArrayList<>();
		list.add(new Hosting(1, "liquidweb.com", 80000));
		list.add(new Hosting(2, "linode.com", 90000));
		list.add(new Hosting(3, "digitalocean.com", 120000));
		list.add(new Hosting(4, "aws.amazon.com", 200000));
		list.add(new Hosting(5, "mkyong.com", 1));
		list.forEach(x -> System.out.printf("%s %s %s\n", x.getId(), x.getName(), x.getWebsites()));
		System.out.println();
		//
		System.out.println("1. List to Map – Collectors.toMap()");
		// key = id, value - websites
		Map<Integer, String> m1 = list.stream().collect(Collectors.toMap(Hosting::getId, Hosting::getName));
		System.out.println(m1);
		// Same with m1, just different syntax
		Map<Integer, String> m2 = list.stream().collect(Collectors.toMap(x -> x.getId(), x -> x.getName()));
		System.out.println(m2);
		// key = name, value - websites
		Map<String, Long> m3 = list.stream().collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites));
		System.out.println(m3);
		System.out.println();
		//
		System.out.println("2. List to Map – Duplicated Key!");
		list.add(new Hosting(6, "linode.com", 100000)); // new line
		list.forEach(x -> System.out.printf("%s %s %s\n", x.getId(), x.getName(), x.getWebsites()));

		// key = name, value - websites , but the key 'linode' is duplicated!?
		// Map<String, Long> m4 =
		// list.stream().collect(Collectors.toMap(Hosting::getName,
		// Hosting::getWebsites));
		// System.out.println(m4);
		// duppicated data -> oldvalue
		Map<String, Long> m5 = list.stream()
				.collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites, (oldvalue, newvalue) -> oldvalue));
		System.out.println(m5);
		// duppicated data -> newvalue
		Map<String, Long> m6 = list.stream()
				.collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites, (oldvalue, newvalue) -> newvalue));
		System.out.println(m6);
		System.out.println();
		//

		System.out.println("3. List to Map – Sort & Collect");

		// returns a LinkedHashMap, keep order
		// key = name, value = websites
		// returns a LinkedHashMap, keep order
		Map<String, Long> m7 = list.stream().sorted(Comparator.comparingLong(Hosting::getWebsites).reversed())
				.collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites, (oldvalue, newvalue) -> oldvalue,
						LinkedHashMap::new));
		System.out.println(m7);
		// 아래와 같이 해도 동일함.
		Map<String, Long> m8 = m6.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
						LinkedHashMap::new));
		System.out.println(m8);

	}
}
