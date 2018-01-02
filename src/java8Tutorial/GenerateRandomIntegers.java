package java8Tutorial;

import java.util.Random;



public class GenerateRandomIntegers {
	private static int getRandomNumberInRange1(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	private static int getRandomNumberInRange2(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		return (int)(Math.random() * ((max - min) + 1)) + min;
	}
	
	private static int getRandomNumberInRange3(int min, int max) {
		Random r = new Random();
		return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
	}
	
	public static void main(String[] args) {
		System.out.println("16. Java – Generate random integers in a range");
		System.out.println("1. java.util.Random");
		//Full examples to generate 10 random integers in a range between 5 (inclusive) and 10 (inclusive).
		for (int i = 0; i < 10; i++) {
			System.out.println(getRandomNumberInRange1(5, 10));
		}
		System.out.println();
		
		System.out.println("2. Math.random");
		//generate 10 random integers in a range between 5 (inclusive) and 10 (inclusive).
		for (int i = 0; i < 10; i++) {
			System.out.println(getRandomNumberInRange2(5, 10));
		}
		System.out.println();
		
		System.out.println("3. Java 8 Random.ints");
		//generate 10 random integers in a range between 33 (inclusive) and 38 (inclusive).
		for (int i = 0; i < 10; i++) {
			System.out.println(getRandomNumberInRange3(33, 38));
		}
		//Generates random integers in a range between 33 (inclusive) and 38 (exclusive),
		//with stream size of 10. And print out the items with forEach
		System.out.println();			
		new Random().ints(10, 33, 38).forEach(System.out::println);
		
	}
}
