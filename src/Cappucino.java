import tools.RandomGenerator;

// Class implementing Coffee interface
public class Cappucino implements Coffee {
	private int energy;
	private String drink = "Cappucino";

	public Cappucino() {
		energy = RandomGenerator.cappucinoEnergy();
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
