
public class Mission4 extends MissionFile implements Mission{

	@Override
	public String helpMission() {
		return fileLoad("Mission4.txt");
	}

	@Override
	public void checkMission() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getMission(int idx) {
		String str = "<Mission 4>" + "\nYou have to make some fruit juice!"
				+ "\nThen read recipe of Juice and make fruit juice"
				+ "\nGo to store read recipe of Juice"
				+ "\nand take some fruitboxes\nout of refrigerator.\n"
				+ "Then make fruit juice."
				+ "\n_________________________________________" + "\n\nJust make one "
				+ fruit[randomFruittype] + "juice and give it to me!";
		return str;
	}

	@Override
	public String[] savedMission() {
		String[] myMission = new String[3];
		myMission[0] = "4";//missionNumber
		myMission[1] = "juice";
		myMission[2] = fruit[randomFruittype];//fruitNameYouhaveto		
		return myMission;
	}



}
