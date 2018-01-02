package java8Tutorial;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;


class Item {
	private String name;
	private int qty;
	private BigDecimal price;

	public Item(String name, int qty, BigDecimal price) {
		this.name = name;
		this.qty = qty;
		this.price = price;
	}

	public Item() {
	}

	public String getName() {
		return name;
	}

	public int getQty() {
		return qty;
	}

	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "[name=" + name + ",qty=" + qty + ",price=" + price + "]";
	}

}

public class StreamCollectorsGroupingBy {
	public static void main(String[] args) {
		
		System.out.println("5. Java 8 – Stream Collectors groupingBy examples");
		
		List<String> items1 = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
		System.out.println(items1);
		//
		System.out.println("1. Group By, Count and Sort");
		System.out.println("1.1");
		Map<String, Long> result1 = items1.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(result1);
		//
		System.out.println("1.2 Add sorting");
		Map<String, Long> finalMap = new LinkedHashMap<>();
		result1.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
				.forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
		System.out.println(finalMap);
		//
		System.out.println("2. List Objects");
		System.out.println("2.1 A Pojo.");
		List<Item> items2 = Arrays.asList(new Item("apple", 10, new BigDecimal("9.99")),
				new Item("banana", 20, new BigDecimal("19.99")), new Item("orang", 10, new BigDecimal("29.99")),
				new Item("watermelon", 10, new BigDecimal("29.99")), new Item("papaya", 20, new BigDecimal("9.99")),
				new Item("apple", 10, new BigDecimal("9.99")), new Item("banana", 10, new BigDecimal("19.99")),
				new Item("apple", 20, new BigDecimal("9.99")));
		//
		System.out.println("2.2 Group by the name + Count or Sum the Qty");
		Map<String, Long> counting = items2.stream()
				.collect(Collectors.groupingBy(Item::getName, Collectors.counting()));
		System.out.println(counting);
		//
		Map<String, Integer> sum = items2.stream()
				.collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));
		System.out.println(sum);
		//
		System.out.println("2.3 Group by Price – Collectors.groupingBy and Collectors.mapping");
		// group by price
		Map<BigDecimal, List<Item>> groupByPriceMap = items2.stream().collect(Collectors.groupingBy(Item::getPrice));
		System.out.println(groupByPriceMap);
		// group by price, uses 'mapping' to convert List<Item> to Set<String>
		Map<BigDecimal, Set<String>> result2 = items2.stream()
				.collect(Collectors.groupingBy(Item::getPrice, Collectors.mapping(Item::getName, Collectors.toSet())));
		System.out.println(result2);
	}
}
