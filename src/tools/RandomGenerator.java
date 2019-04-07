package tools;
import java.util.Random;

// Toolkit for all random interactions
public class RandomGenerator {

	// Energy for black coffee, cappucino and latte
	public static int blackEnergy() {
		Random r = new Random();
		int i = r.nextInt(20) + 20;
		return i;
	}
	public static int cappucinoEnergy() {
		Random r = new Random();
		int i = r.nextInt(10) + 20;
		return i;
	}
	public static int latteEnergy() {
		Random r = new Random();
		int i = r.nextInt(10) + 25;
		return i;
	}

	// Returns a random type of coffee
	public static String randomCoffeeType() {
		Random r = new Random();
		int i = r.nextInt(3);
		String type = " ";
		switch (i) {
		case 0:
			type = "BLACK";
			break;
		case 1:
			type = "CAPPUCINO";
			break;
		case 2:
			type = "LATTE";
			break;
		}
		return type;
	}

	// Returns true 1/5 times. Used to decide bonus cups of coffee
	public static boolean bonusCoffeeChance() {
		Random r = new Random();
		int i = r.nextInt(5);
		boolean bool = false;

		switch (i) {
		case 0:
			bool = false;
			break;
		case 1:
			bool = false;
			break;
		case 2:
			bool = false;
			break;
		case 3:
			bool = false;
			break;
		case 4:
			bool = true;
			break;

		}
		return bool;
	}
	
	// Return an integer representing an index in array of names
	public static int randomName(int size) {
		Random r = new Random();
		int i = r.nextInt(size);
		return i;
	}
	
	// Returns a value between 30 and 90
	public static int randomEnergy() {
		Random r = new Random();
		int i = r.nextInt(60) + 30;
		return i;
	}
}
