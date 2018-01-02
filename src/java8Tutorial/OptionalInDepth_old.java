package java8Tutorial;

class ScreenResolution_old {

	private int width;
	private int height;

	public ScreenResolution_old(int width, int height) {
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

class DisplayFeatures_old {

	private String size; // In inches
	private ScreenResolution_old resolution;

	public DisplayFeatures_old(String size, ScreenResolution_old resolution) {
		this.size = size;
		this.resolution = resolution;
	}

	public String getSize() {
		return size;
	}

	public ScreenResolution_old getResolution() {
		return resolution;
	}
}

class Mobile_old {

	private long id;
	private String brand;
	private String name;
	private DisplayFeatures_old displayFeatures;
	// Likewise we can see Memory Features, Camera Features etc.

	public Mobile_old(long id, String brand, String name, DisplayFeatures_old displayFeatures) {
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

	public DisplayFeatures_old getDisplayFeatures_old() {
		return displayFeatures;
	}

}

class Mobile_oldService {
	public int getMobile_oldScreenWidth(Mobile_old mobile) {
		if (mobile != null) {
			DisplayFeatures_old dfeatures = mobile.getDisplayFeatures_old();
			if (dfeatures != null) {
				ScreenResolution_old resolution = dfeatures.getResolution();
				if (resolution != null) {
					return resolution.getWidth();
				}
			}
		}
		return 0;
	}
}

public class OptionalInDepth_old {
	public static void main(String[] args) {

		System.out.println("15. Java 8 Optional In Depth");
		System.out.println("6. Without Java 8 Optional");
		Mobile_oldService mService = new Mobile_oldService();

		ScreenResolution_old resolution1 = new ScreenResolution_old(750, 1334);
		DisplayFeatures_old dfeatures1 = new DisplayFeatures_old("4.7", resolution1);
		Mobile_old mobile1 = new Mobile_old(2015001, "Apple", "iPhone 6s", dfeatures1);
		int mobileWidth1 = mService.getMobile_oldScreenWidth(mobile1);
		System.out.println("Apple iPhone 6s Screen Width = " + mobileWidth1);

		ScreenResolution_old resolution2 = new ScreenResolution_old(0, 0);
		DisplayFeatures_old dfeatures2 = new DisplayFeatures_old("0", resolution2);
		Mobile_old mobile2 = new Mobile_old(2015001, "Apple", "iPhone 6s", dfeatures2);
		int mobileWidth2 = mService.getMobile_oldScreenWidth(mobile2);
		System.out.println("Apple iPhone 16s Screen Width = " + mobileWidth2);
	}
}
