
import tools.RandomGenerator;

public class Person implements Runnable {
	private int mEnergy;
	private String mName;

	private BreakRoom mBreakRoom;

	// Constructor
	public Person(BreakRoom breakRoom) {
		mBreakRoom = breakRoom;
		mEnergy = RandomGenerator.randomEnergy();
		setName();
	}

	// Pulls a random name from shared NAMES array. Does not allow duplicates
	public void setName() {
		mName = mBreakRoom.pullName();
	}

	// Method to adjust energy level, both static loss and gain when drinking coffee
	public void setEnergy(int energy) {
		mEnergy += energy;
	}

	@Override
	public void run() {
		// Program will run until energy reaches 0 or stock of coffee depletes
		while (mEnergy > 0) {
			setEnergy(-1);
			try {
				// Small delay so Thread is not locking program to one person
				Thread.sleep(200);
			} catch (Exception e) {
			}
			
			// Goes to coffee machine IF energy reaches 30 and machine has remaining coffee
			if (mEnergy <= 30 && BreakRoom.getBreakRoom().remainingCoffee() != 0) {
				System.out.println(mName + " goes to get some coffee.");
				
				// Stays at machine until energy reaches 100
				while (mEnergy <= 100 && BreakRoom.getBreakRoom().remainingCoffee() != 0) {
					Coffee coffee = mBreakRoom.serveCoffee();

					setEnergy(coffee.drink());
					System.out.println(mName + " consumes a " + coffee.drinkType() + " and now has " + mEnergy
							+ " energy. Drinks remaining: " + mBreakRoom.remainingCoffee());
					// Delay while drinking
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
					}
					// One in five chance to create 5 bonus cups of coffee
					if (RandomGenerator.bonusCoffeeChance()) {
						mBreakRoom.bonusCoffee();
						System.out
								.println("5 drinks added! Current amount of drinks is " + mBreakRoom.remainingCoffee());
					}
				}
				
				// Goes back to work when energy reaches 100
				if (mEnergy >= 100) {
					System.out.println(mName + " going back to work.");
				}
				// Goes home if there's no more coffee
			} else if (BreakRoom.getBreakRoom().remainingCoffee() <= 0) {
				System.out.println(mName + " notices machine is empty.");
				break;
			}
		}
		// Output depending on how the main loop ended. Either ran out of coffee or
		// energy
		if (mEnergy < 0) {
			System.out.println(mName + " is exhausted and is going home.");
		} else {
			System.out.println("No coffee = no work! " + mName + " is going home.");
		}
	}
}