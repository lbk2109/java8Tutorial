package java8Tutorial;

public class ConvertStringToCharArray {
	public static void main(String[] args) {
		System.out.println("20. Java – How to convert String to Char Array");
		
		System.out.println("1. String.toCharArray() to convert a String into a char array.");
        String password = "password123";
        char[] passwordInCharArray = password.toCharArray();
        for (char temp : passwordInCharArray) {
            System.out.printf(" %c",temp);
        }		
        System.out.println();
        
        System.out.println("Java 8 – Convert String to Stream Char");
        password.chars().mapToObj(x -> (char)x).forEach(x->System.out.printf(" %c",x));
	}
}
