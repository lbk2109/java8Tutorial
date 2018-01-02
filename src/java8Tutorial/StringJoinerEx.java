package java8Tutorial;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

class Game {
	String name;
	int ranking;

	public Game(String name, int ranking) {
		this.name = name;
		this.ranking = ranking;
	}

	public String getName() {
		return name;
	}
}

public class StringJoinerEx {
	public static void main(String[] args) {

		System.out.println("17.Java 8 – StringJoiner example");
		System.out.println("1. StringJoiner");
		StringJoiner sj = new StringJoiner("/", "prefix-", "-suffix");
		sj.add("2016").add("02").add("26");
		String result = sj.toString(); // prefix-2016/02/26-suffix
		System.out.println(result);

		System.out.println("2. String.join");
		System.out.println(String.join("-", "2015", "10", "31"));
		List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");
		System.out.println(String.join(",", list));

		System.out.println("3. Collectors.joining");
		List<Game> gamers = Arrays.asList(new Game("이병국", 1), new Game("이명훈", 1), new Game("이정훈", 1));
		System.out.println(gamers.stream().map(x -> x.getName()).collect(Collectors.joining(",", "{", "}")));

	}
}
