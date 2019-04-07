
public class main {

	public static void main(String[] args) {
		BreakRoom breakRoom = BreakRoom.getBreakRoom();

		Thread t1 = new Thread(new Person(breakRoom));
		Thread t2 = new Thread(new Person(breakRoom));
		Thread t3 = new Thread(new Person(breakRoom));
		Thread t4 = new Thread(new Person(breakRoom));
		Thread t5 = new Thread(new Person(breakRoom));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();		
	}
}

/*
 * CHANGES:
 * 
 * 1. created random functions for name and energy in RandomGenerator
 * 2. moved responsibility of names to breakroom. otherwise every person gets an unique array of names, 
 * which makes it possible to get duplicate names
 * 3. moved all interactions with the array of coffee to coffee machine. Breakroom now only has set/get methods to interact
 * 4. commentzzz
 */
