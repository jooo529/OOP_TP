
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
	public String getMission(int idx) {
		String str = "<Mission 2>" + "\nYou have to make some fruitboxes!\n\n"
				+ "You must have each fruits like this :\nApple :      4 or More! makes one AppleBox!"
				+ "Grape :      2 or More!   makes one GrapeBox!\n"
				+ "Orange :     4 or More!   makes one OrangeBox!\n"
				+ "Strawberry : 8 or More!   makes one StrawberryBox!" + "\n_________________________________________"
				+ "\n\nGet" + randomFruitnum + "  " + fruit[randomFruittype]+"Boxes!";
		return str;
	}

	@Override
	public String[] savedMission() {
		String[] myMission = new String[3];
		myMission[0] = "2";//missionNumber
		myMission[1] = ""+randomFruitnum;//fruitNumberYouhaveto
		myMission[2] = fruit[randomFruittype];//fruitNameYouhaveto
		return myMission;
	}

}
