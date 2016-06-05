import java.util.ArrayList;

public class Mission2 extends MissionFile implements Mission{

	@Override
	public String helpMission() {
		return fileLoad("Mission2.txt");
	}

	@Override
	public void checkMission() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public ArrayList<String> savedMission() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMission(int idx) {
		String str = "<Mission 2>" + "\nYou have to go to Farm and get following fruit!"
				+ "\nGo to Farm and get followng fruits." + "\n_________________________________________"
				+ "\n\nGet" + randomFruitnum + "  " + fruit[randomFruittype];
		return str;
	}

}
