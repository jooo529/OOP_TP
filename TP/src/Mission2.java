
public class Mission2 extends MissionFile implements Mission {

	int randomFruitnum1 = (int) (Math.random() * 4 + 1);
	int randomFruitnum2 = (int) (Math.random() * 4 + 1);
	int randomFruitnum3 = (int) (Math.random() * 4 + 1);
	int randomFruitnum4 = (int) (Math.random() * 4 + 1);

	public String helpMission() {
		return fileLoad("Mission2.txt");
	}

	public Boolean checkMission(int idx, int fruitNum, String str) {
		return false;
	}
	public Boolean checkMission(int idx, int fruitNum1,int fruitNum2,int fruitNum3,int fruitNum4 ) {
		Boolean success = false;
		if (fruitNum1 <= UserFile.Users.get(idx).getApplebox() && fruitNum2 <= UserFile.Users.get(idx).getGrapebox()
				&& fruitNum3 <= UserFile.Users.get(idx).getOrangebox()
				&& fruitNum4 <= UserFile.Users.get(idx).getStrawberrybox())	success = true;
		return success;
	}

	public String getMission(int idx) {
		String str = "<Mission 2>" + "\nYou have to make some fruitboxes!\n" + "Make " + randomFruitnum1
				+ "AppleBox(es), " + randomFruitnum2 + "GrapeBox(es),\n " + randomFruitnum3 + "orangeBox(es)"
				+ randomFruitnum4 + "StrawberrryBox(es) at least!";
		return str;
	}

	public String[] savedMission() {
		String[] myMission = new String[6];
		myMission[0] = "2";// missionNumber
		myMission[1] = "" + randomFruitnum1;// fruitNumberYouhaveto
		myMission[2] = "" + randomFruitnum2;// fruitNumberYouhaveto
		myMission[3] = "" + randomFruitnum3;// fruitNumberYouhaveto
		myMission[4] = "" + randomFruitnum4;// fruitNumberYouhaveto
		myMission[5] = "-";
		return myMission;
	}

	public String progressMission() {
		return "Make " + randomFruitnum1
				+ " AppleBox(es)+" + randomFruitnum2 + "GrapeBox(es)+" + randomFruitnum3 + "orangeBox(es)+"
				+ randomFruitnum4 + "StrawberrryBox(es) at least!";
	}

}
