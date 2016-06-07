
public class Mission4 extends MissionFile implements Mission{

	int randomJuice = (int) (Math.random()*3 + 1);
	int randomFruittype = (int) (Math.random() * 4);
	
	public String helpMission() {
		return fileLoad("Mission4.txt");
	}

	public Boolean checkMission(int idx, int fruitNum, String str) {
		Boolean success = false;
		if(str.equals("apple")) {
			if(fruitNum<=UserFile.Users.get(idx).getAppleJuice()) success = true;
		}else if(str.equals("grape")) {
			if(fruitNum<=UserFile.Users.get(idx).getGrapeJuice()) success = true;
		}else if(str.equals("orange")) {
			if(fruitNum<=UserFile.Users.get(idx).getOrangeJuice()) success = true;
		}else if(str.equals("strawberry")) {
			if(fruitNum<=UserFile.Users.get(idx).getStrawberryJuice()) success = true;
		}
		return success;
	}

	public String getMission(int idx) {
		String str = "<Mission 4>" + "\nYou have to make some fruit juice!"
				+ "\nThen read recipe of Juice and make fruit juice"
				+ "\nGo to store read recipe of Juice"
				+ "\nand take some fruitboxes\nout of refrigerator.\n"
				+ "Then make fruit juice."
				+ "\n_________________________________________" + "\n\nJust make"+randomJuice+" "
				+ fruit[randomFruittype] + "juice and give it to me!";
		return str;
	}

	public String[] savedMission() {
		String[] myMission = new String[5];
		myMission[0] = "4";//missionNumber
		myMission[1] = ""+randomJuice;
		myMission[2] = fruit[randomFruittype];//fruitNameYouhaveto		
		myMission[3] = myMission[4] = "-";
		return myMission;
	}

	public String progressMission() {
		return "make " + randomJuice +" "+ fruit[randomFruittype] + " juice and give it to Mom!";
	}


}
