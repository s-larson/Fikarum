import tools.RandomGenerator;

// Class implementing Coffee interface
public class Black implements Coffee {
	private int energy;
	private String drink = "Black coffee";

	public Black() {
		energy = RandomGenerator.blackEnergy();
	}

	@Override
	public int drink() {
		return energy;
	}

	@Override
	public String drinkType() {
		return drink;
	}

}
