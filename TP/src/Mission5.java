public class Mission5 extends MissionFile implements Mission{

	int randomFruitnum = (int) (Math.random() * 5 + 1);
	int randomConsumer = (int) (Math.random() * 5 + 3);
	int randomJuice = (int) (Math.random()*3 + 1);
	int randomFruittype = (int) (Math.random() * 4);
	
	public String helpMission() {
		return fileLoad("Mission5.txt");
	}

	public Boolean checkMission(int idx, int fruitNum, String str) {
		Boolean success = UserFile.Users.get(idx).getSuccess5();
		return success;
	}

	public String getMission(int idx) {
		String str = "<Mission 5>" + "\nYou have to go to Store and sell juice!"
				+ "\nIn Store, some consumers will be there." + "\nThey want your fruit juice!"
				+ "\nSell them some juice!" + "\n_________________________________________" + "\n\nThere are "
				+ randomConsumer + " cunsumers in store!" + "\nSell juices for all of them!";
		return str;
	}

	public String[] savedMission() {
		String[] myMission = new String[5];
		myMission[0] = "4";//missionNumber
		myMission[1] = ""+randomConsumer;
		myMission[2] = myMission[3] = myMission[4] = "-";
		return myMission;
	}

	public String progressMission() {
		return "There are "+ randomConsumer + " cunsumers in store!" + "\t\tSell juices for all of them";
	}
	
}