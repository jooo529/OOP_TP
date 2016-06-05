import java.util.ArrayList;
import java.util.Random;

public class Mission1 extends MissionFile implements Mission {

	public Mission1() {

	}

	public String helpMission() {
		return fileLoad("Mission1.txt");
	}

	public void checkMission() {

	}

	public ArrayList<String> savedMission() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMission(int idx) {
		String str = "<Mission 1>" + "\nYou have to buy following fruitbox!"
				+ "\n\nGo to the Store and Buy following box." + "\n_________________________________________"
				+ "\n\nGet " + randomFruitnum + "  " + fruit[randomFruittype] + " Box";
		return str;
	}

}
