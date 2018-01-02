package java8Tutorial;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.lang3.ArrayUtils;

public class JoinArrays {
	static <T> T[] joinArrayGeneric(T[]... arrays) {
		int length = 0;
		for (T[] array : arrays) {
			length += array.length;
		}
		// T[] result = new T[length];
		final T[] result = (T[]) Array.newInstance(arrays[0].getClass().getComponentType(), length);

		int offset = 0;
		for (T[] array : arrays) {
			System.arraycopy(array, 0, result, offset, array.length);
			offset += array.length;
		}
		return result;
	}

	// create other overloaded primitive type - long, double...
	// static long[] joinArray(long[]... arrays)
	static int[] joinArray(int[]... arrays) {
		int length = 0;
		for (int[] array : arrays) {
			length += array.length;
		}

		final int[] result = new int[length];

		int offset = 0;
		for (int[] array : arrays) {
			System.arraycopy(array, 0, result, offset, array.length);
			offset += array.length;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("19. Java – How to join Arrays");

		String[] s1 = new String[] { "a", "b", "c" };
		String[] s2 = new String[] { "d", "g", "f" };
		String[] s3 = new String[] { "g", "h", "i" };
		int[] int1 = new int[] { 1, 2, 3 };
		int[] int2 = new int[] { 4, 5, 6 };
		int[] int3 = new int[] { 7, 8, 9 };

		System.out.println("1. Apache Commons Lang – ArrayUtils");
		String[] result1 = ArrayUtils.addAll(s1, s2);
		System.out.println(Arrays.toString(result1));
		int[] result2 = ArrayUtils.addAll(int1, int2);
		System.out.println(Arrays.toString(result2));

		System.out.println("2. Java API");
		String[] result3 = joinArrayGeneric(s1, s2, s3);
		System.out.println(Arrays.toString(result3));
		int[] result4 = joinArray(int1, int2, int3);
		System.out.println(Arrays.toString(result4));

		System.out.println("3. Java 8 Stream");
		// join object type array
		String[] result5 = Stream.of(s1, s2, s3).flatMap(Stream::of).toArray(String[]::new);
		System.out.println(Arrays.toString(result5));

		// join 2 primitive type array
		int[] result6 = IntStream.concat(Arrays.stream(int1), Arrays.stream(int2)).toArray();
		System.out.println(Arrays.toString(result6));

		// join 3 primitive type array, any better idea?
		int[] result7 = IntStream
				.concat(Arrays.stream(int1), IntStream.concat(Arrays.stream(int2), Arrays.stream(int3))).toArray();
		System.out.println(Arrays.toString(result7));

	}
}
