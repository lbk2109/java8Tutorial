package java8Tutorial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFileLineByLine {
	public static void main(String[] args) {

		System.out.println("18.Java 8 Stream – Read a file line by line");
		System.out.println("1. Java 8 Read File + Stream");
		String fileName = "src/java8Tutorial/lines.txt";
		Stream<String> stream = null;
		try {
			stream = Files.lines(Paths.get(fileName));
			stream.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();

		System.out.println("2. Java 8 Read File + Stream + Extra");
		List<String> list = new ArrayList<>();
		try {
			stream = Files.lines(Paths.get(fileName));
			// stream.filter(line->!line.startsWith("line3")).forEach(System.out::println);
			// stream.filter(line->!line.startsWith("line3")).map(String::toUpperCase).forEach(System.out::println);
			list = stream.filter(line -> !line.startsWith("line3")).map(String::toUpperCase)
					.collect(Collectors.toList());
			list.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("3. BufferedReader + Stream");
		try {
			BufferedReader br = Files.newBufferedReader(Paths.get(fileName));
			list = br.lines().collect(Collectors.toList());
			list.forEach(System.out::println);
			;
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("4. Classic BufferedReader And Scanner");
		try (BufferedReader br = new BufferedReader(new FileReader(fileName));) {
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try (Scanner scanner = new Scanner(new File(fileName))) {
			while(scanner.hasNext())
				System.out.println(scanner.next());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
