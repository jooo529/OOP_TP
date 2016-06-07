
public class Mission1 extends MissionFile implements Mission {

	int randomFruitnum = (int) (Math.random() * 5 + 1);
	int randomFruittype = (int) (Math.random() * 4);
	
	public String helpMission() {
		return fileLoad("Mission1.txt");
	}

	public Boolean checkMission(int idx, int fruitNum, String str) {
		Boolean success = false;
		if(str.equals("apple")) {
			if(fruitNum<=UserFile.Users.get(idx).getApple()) success = true;
			System.out.println("1");
		}else if(str.equals("grape")) {
			if(fruitNum<=UserFile.Users.get(idx).getGrape()) success = true;
			System.out.println("1");
		}else if(str.equals("orange")) {
			if(fruitNum<=UserFile.Users.get(idx).getOrange()) success = true;
		}else if(str.equals("strawberry")) {
			if(fruitNum<=UserFile.Users.get(idx).getStrawBerry()) success = true;
		}
		return success;
	}

	public String getMission(int idx) {
		String str = "<Mission 1>" + "\nYou have to go to Farm and get some fruit!"
				+ "\n\nGo to Farm and just enjoy FruitGame!" + "\n_________________________________________"
				+ "\n\nGet " + randomFruitnum + "  " + fruit[randomFruittype] + "!!";
		return str;
	}
	
	public String[] savedMission() {
		String[] myMission = new String[5];
		myMission[0] = "1";//missionNumber
		myMission[1] = ""+randomFruitnum;//fruitNumberYouhaveto
		myMission[2] = fruit[randomFruittype];//fruitNameYouhaveto
		myMission[3] = myMission[4] = "-";
		return myMission;
	}

	public String progressMission() {
		return "Get " + randomFruitnum + " " + fruit[randomFruittype] + "!!";
	}

}
