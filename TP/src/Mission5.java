public class Mission5 extends MissionFile implements Mission {

	int randomConsumer = (int) (Math.random() * 4 + 1);
	
	public String helpMission() {
		return fileLoad("Mission5.txt");
	}

	public Boolean checkMission(int idx, int fruitNum, String str) {
		System.out.println("hello");
		Boolean success = UserFile.Users.get(idx).getSuccess5();
		return success;
	}

	public String getMission(int idx) {
		String str = "<Mission 5>" + "\nYou have to go to Store and sell juice!"
				+ "\nIn Store, some consumers will be there." + "\nThey want your fruit juice!"
				+ "\nSell them some juice!" + "\n_________________________________________" + "\n\nThere are "
				+ randomConsumer + " consumers in store!" + "\nSell juices for all of them!";
		return str;
	}

	public String[] savedMission() {
		String[] myMission = new String[5];
		myMission[0] = "5";// missionNumber
		myMission[1] = "" + randomConsumer;
		myMission[2] = myMission[3] = myMission[4] = "-";
		return myMission;
	}

	public String progressMission() {
		return "There are " + randomConsumer + " consumers in store!" + "\t\tSell juices for all of them";
	}

}