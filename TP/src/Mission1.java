
public class Mission1 extends MissionFile implements Mission {

	public String helpMission() {
		return fileLoad("Mission1.txt");
	}

	public void checkMission() {

	}

	@Override
	public String getMission(int idx) {
		String str = "<Mission 1>" + "\nYou have to go to Farm and get some fruit!"
				+ "\n\nGo to Farm and just enjoy FruitGame!" + "\n_________________________________________"
				+ "\n\nGet " + randomFruitnum + "  " + fruit[randomFruittype] + "!!";
		return str;
	}
	
	public String[] savedMission() {
		String[] myMission = new String[3];
		myMission[0] = "1";//missionNumber
		myMission[1] = ""+randomFruitnum;//fruitNumberYouhaveto
		myMission[2] = fruit[randomFruittype];//fruitNameYouhaveto
		return myMission;
	}

}
