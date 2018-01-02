package java8Tutorial;

import java.util.Optional;

class ScreenResolution {

	private int width;
	private int height;

	public ScreenResolution(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}

class DisplayFeatures {

	private String size; // In inches
	private Optional<ScreenResolution> resolution;

	public DisplayFeatures(String size, Optional<ScreenResolution> resolution) {
		this.size = size;
		this.resolution = resolution;
	}

	public String getSize() {
		return size;
	}

	public Optional<ScreenResolution> getResolution() {
		return resolution;
	}

}

class Mobile {

	private long id;
	private String brand;
	private String name;
	private Optional<DisplayFeatures> displayFeatures;
	// Likewise we can see Memory Features, Camera Features etc.

	public Mobile(long id, String brand, String name, Optional<DisplayFeatures> displayFeatures) {
		this.id = id;
		this.brand = brand;
		this.name = name;
		this.displayFeatures = displayFeatures;
	}

	public long getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public String getName() {
		return name;
	}

	public Optional<DisplayFeatures> getDisplayFeatures() {
		return displayFeatures;
	}

}

class MobileService {
	public int getMobileScreenWidth(Optional<Mobile> mobile) {
		return (mobile.flatMap(Mobile::getDisplayFeatures).flatMap(DisplayFeatures::getResolution)
				.map(ScreenResolution::getWidth).orElse(0));
	}
}

public class OptionalInDepth {
	public static void main(String[] args) {

		System.out.println("15. Java 8 Optional In Depth");

		System.out.println("1. Optional Basic example");
		Optional<String> gender1 = Optional.of("MALE");
		//
		System.out.println("Non-Empty Optional:" + gender1);
		System.out.println("Non-Empty Optional: Gender value : " + gender1.get());
		System.out.println("Empty Optional: " + Optional.empty());
		//
		String answer1 = "Yes";
		String answer2 = null;
		System.out.println("ofNullable on Non-Empty Optional: " + Optional.ofNullable(answer1));
		System.out.println("ofNullable on Empty Optional: " + Optional.ofNullable(answer2));
		// java.lang.NullPointerException
		// System.out.println("ofNullable on Non-Empty Optional: " +
		// Optional.of(answer2));
		System.out.println();

		System.out.println("2. Optional.map and flatMap");
		Optional<String> nonEmptyGender2 = Optional.of("male");
		Optional<String> emptyGender2 = Optional.empty();
		//
		System.out.println("Non-Empty Optional:: " + nonEmptyGender2.map(String::toUpperCase));
		System.out.println("Empty Optional    :: " + emptyGender2.map(String::toUpperCase));
		//
		Optional<Optional<String>> nonEmptyOtionalGender = Optional.of(Optional.of("male"));
		System.out.println("Optional value   :: " + nonEmptyOtionalGender);
		System.out.println("Optional.map     :: " + nonEmptyOtionalGender.map(g -> g.map(String::toUpperCase)));
		System.out.println("Optional.flatMap :: " + nonEmptyOtionalGender.flatMap(g -> g.map(String::toUpperCase)));
		System.out.println();

		System.out.println("3. Optional.filter");
		Optional<String> gender3 = Optional.of("MALE");
		System.out.println(gender3.filter(g -> g.equals("male"))); // Optional.empty
		System.out.println(gender3.filter(g -> g.equalsIgnoreCase("MALE"))); // Optional[MALE]
		//
		Optional<String> emptyGender3 = Optional.empty();
		System.out.println(emptyGender3.filter(g -> g.equalsIgnoreCase("MALE"))); // Optional.empty
		System.out.println();

		System.out.println("4. Optional isPresent and ifPresent");
		Optional<String> gender4 = Optional.of("MALE");
		Optional<String> emptyGender4 = Optional.empty();
		//
		if (gender4.isPresent()) {
			System.out.println("Value available.");
		} else {
			System.out.println("Value not available.");
		}
		gender4.ifPresent(g -> System.out.println("In gender4 Option, value available."));
		// condition failed, no output print
		emptyGender4.ifPresent(g -> System.out.println("In emptyGender4 Option, value available."));
		System.out.println();

		System.out.println("5. Optional orElse methods");
		Optional<String> gender5 = Optional.of("MALE");
		Optional<String> emptyGender5 = Optional.empty();
		// NVL()
		System.out.println(gender5.orElse("<N/A>")); // MALE
		System.out.println(emptyGender5.orElse("<N/A>")); // <N/A>
		System.out.println(gender5.orElseGet(() -> "<N/A>")); // MALE
		System.out.println(emptyGender5.orElseGet(() -> "<N/A>")); // <N/A>
		System.out.println();

		System.out.println("6. Without Java 8 Optional");

		ScreenResolution resolution1 = new ScreenResolution(750, 1334);
		DisplayFeatures dfeatures1 = new DisplayFeatures("4.7", Optional.of(resolution1));
		Mobile mobile1 = new Mobile(2015001, "Apple", "iPhone 6s", Optional.of(dfeatures1));

		MobileService mService = new MobileService();

		int mobileWidth1 = mService.getMobileScreenWidth(Optional.of(mobile1));
		System.out.println("Apple iPhone 6s Screen Width = " + mobileWidth1);

		Mobile mobile2 = new Mobile(2015001, "Apple", "iPhone 6s", Optional.empty());
		int mobileWidth2 = mService.getMobileScreenWidth(Optional.of(mobile2));
		System.out.println("Apple iPhone 16s Screen Width = " + mobileWidth2);
	}
}
