// Class for creating one instance of desired coffee
public class CoffeeFactory {

	public Coffee getCoffee(String coffeeType) {
		if (coffeeType == null) {
			return null;
		} else if (coffeeType.equalsIgnoreCase("BLACK")) {
			return new Black();
		} else if (coffeeType.equalsIgnoreCase("LATTE")) {
			return new Latte();
		} else if (coffeeType.equalsIgnoreCase("CAPPUCINO")) {
			return new Cappucino();
		}
		return null;
	}
}