package java8Tutorial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//2.Java 8 forEach examples
public class ForEachListAndMap {

	public static void main(String[] args) {
		
		System.out.println("2.Java 8 forEach examples");
		
		//forEach and Map
		Map<String, Integer> map = new HashMap<>();
		map.put("A", 10);
		map.put("B", 20);
		map.put("C", 30);
		map.put("D", 40);
		map.put("E", 50);
		map.put("F", 60);
		//
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(map.get(entry.getKey()));
		}
		//java8
		map.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
		
		map.forEach((k,v) -> {
			System.out.println("Item : " + k + " Count : " + v);
			if("E".equals(k))
				System.out.println("Helow E");;
		}
		);
		System.out.println();
		
		//forEach and List
		
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		//
		for (String str : list) {
			System.out.println(str);
		}
		System.out.println();
		//lambda 
		list.forEach(l->System.out.println(l));
		System.out.println();
		// output:C
		list.forEach(l->{
			System.out.println(l);
			if("C".equals(l)) 
				System.out.println("Helow C");
		});
		System.out.println();
		
		//method referrence
		list.forEach(System.out::println);
		System.out.println();
		
		//Stream and filter
		list.stream().filter(s->s.contains("E")).forEach(System.out::println);
		
	}
}
