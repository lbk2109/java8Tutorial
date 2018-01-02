package java8Tutorial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Map<String, String> map = new HashMap<>();

//
//// 1.Convert all Map keys to a List
// List<String> result = new ArrayList(map.keySet());
//
//// 2.Convert all Map values to a List
// List<String> result2 = new ArrayList(map.values());
//
//// 3.Java 8, Convert all Map keys to a List
// List<String> result3 = map.keySet().stream()
//	 .collect(Collectors.toList());
//
//// 4.Java 8, Convert all Map values  to a List
// List<String> result4 = map.values().stream()
//	 .collect(Collectors.toList());
//
//// 5.Java 8, seem a bit long, but you can enjoy the Stream features like filter and etc.
// List<String> result5 = map.values().stream()
//	 .filter(x -> !"apple".equalsIgnoreCase(x))
//	 .collect(Collectors.toList());
//
//// 6.Java 8, split a map into 2 List, it works!
//// refer example 3 below

public class ConvertMapToList {
	public static void main(String[] args) {

		System.out.println("14. Java 8 – Convert Map to List");
		Map<Integer, String> map = new HashMap<>();
		map.put(10, "apple");
		map.put(20, "orange");
		map.put(30, "banana");
		map.put(40, "watermelon");
		map.put(50, "dragonfruit");
		System.out.println(map);
		System.out.println();

		System.out.println("1. Map To List");
		System.out.println("\n1. Export Map Key to List...");
		List<Integer> result11 = new ArrayList<Integer>(map.keySet());
		result11.forEach(System.out::println);
		
		System.out.println("\n2. Export Map Value to List...");
		List<String> result12 = new ArrayList<String>(map.values());
		result12.forEach(System.out::println);
		System.out.println();

		System.out.println("2.Java 8 – Map To List");
		
		System.out.println("\n1. Export Map Key to List...");
		List<Integer> result21 = map.keySet().stream().collect(Collectors.toList());
		result21.forEach(System.out::println);
		
		System.out.println("\n2. Export Map Value to List...");
		List<String> result22 = map.values().stream().collect(Collectors.toList());
		result22.forEach(System.out::println);
		
		System.out.println("\n3.1 Export Map Value to List..., say no to banana");
		List<String> result231 = map.values().stream().filter(x -> !"banana".equalsIgnoreCase(x))
				.collect(Collectors.toList());
		result231.forEach(System.out::println);
		//아래와동일함
		List<String> result232 = map.entrySet().stream().filter(m -> !m.getValue().equals("banana"))
				.map(m -> m.getValue()).collect(Collectors.toList());
		result232.forEach(System.out::println);
        System.out.println();
		
		System.out.println("3.Java 8 – Convert Map into 2 List");
         System.out.println(map);		
        // split a map into 2 List
        List<Integer> resultSortedKey = new ArrayList<>();
        List<String> resultValues = map.entrySet().stream()
                //sort a Map by key and stored in resultSortedKey
                .sorted(Map.Entry.<Integer, String>comparingByKey().reversed())
                .peek(e -> resultSortedKey.add(e.getKey()))
                .map(x -> x.getValue())
                // filter banana and return it to resultValues
                .filter(x -> !"banana".equalsIgnoreCase(x))
                .collect(Collectors.toList());
        resultSortedKey.forEach(System.out::println);
        resultValues.forEach(System.out::println);

	}
}
