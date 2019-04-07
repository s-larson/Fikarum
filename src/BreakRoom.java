import java.util.ArrayList;

import tools.RandomGenerator;

// Singleton class for interactions between coffee machine and persons
public class BreakRoom {
	private static BreakRoom obj;
	private CoffeeMachine machine;
	private ArrayList<String> NAMES = new ArrayList<>();
	
	// Constructor. Called by getBreakRoom()
	private BreakRoom() {
		machine = new CoffeeMachine();
		getNames();
	}
	
	// Method to gather all names from Enum class Names
	public void getNames() {
		for(int i = 0; i < Names.values().length; i++) {
			NAMES.add(Names.values()[i].toString());
		}
	}
	
	// Pick a random name from NAMES array, removes it after so no duplicates
	public String pullName() {
		int size = NAMES.size();
		int number = RandomGenerator.randomName(size);
		String name = NAMES.get(number);
		NAMES.remove(number);
		return name;
	}
	
	// Add bonus coffee to machine
	public void bonusCoffee() {
		machine.bonusCoffee();
	}
	
	// Returns first drink in ArrayList and removes it from "machine"
	public synchronized Coffee serveCoffee() {
		return machine.serveCoffee();
	}
	
	// Get amount of drinks remaining
	public int remainingCoffee() {
		return machine.remainingCoffee();
	}

	// Constructs a BreakRoom if one is not already instantiated
	// "Synchronized" prevents accidental duplicates
	public static synchronized BreakRoom getBreakRoom() {
		if (obj == null) {
			obj = new BreakRoom();
		}
		return obj;
	}
}
