
public class Mission3 extends MissionFile implements Mission{

	static int index;

	
	public String helpMission() {
		return fileLoad("Mission3.txt");
	}

	public Boolean checkMission(int idx, int fruitNum, String str) {
		return true;
	}
	
	public Boolean checkMission(int idx, int fruitNum1, int fruitNum2, int fruitNum3, int fruitNum4) {
		Boolean success = false;
		Boolean appleNgrape = false;
		Boolean orangeNstraw = false;
		if(fruitNum1<=UserFile.Users.get(idx).getAppleRefri()&&fruitNum2<=UserFile.Users.get(idx).getGrapeRefri()) appleNgrape = true;
		if(fruitNum3<=UserFile.Users.get(idx).getOrangeRefri()&&fruitNum4<=UserFile.Users.get(idx).getStrawberryRefri()) orangeNstraw = true;
		if(appleNgrape&&orangeNstraw) success = true;
		return success;
	}
	
	public String getMission(int idx) {
		String str = "<Mission 3>"+"\nPut your all fruits in refrigerator!"
				+ "\nRefrigerator is located in Store." + "\n_________________________________________"
				+ "\n\nNow you have "+UserFile.Users.get(idx).toStringFruitBox()+"\n\n put them in refrigerator!";
		index = idx;
		return str;
	}

	public String[] savedMission() {
		String[] myMission = new String[6];
		myMission[0] = "3";//missionNumber
		myMission[1] = ""+UserFile.Users.get(index).getApplebox();//fruitAppleboxNumbYouhaveto
		myMission[2] = ""+UserFile.Users.get(index).getGrapebox();//fruitGrapeboxNumbYouhaveto
		myMission[3] = ""+UserFile.Users.get(index).getOrangebox();//fruitOrangeboxNumbYouhaveto
		myMission[4] = ""+UserFile.Users.get(index).getStrawberrybox();//fruitStrawberryboxNumbYouhaveto
		myMission[5] = "-";
		return myMission;
	}

	public String progressMission() {
		return "Put All "+UserFile.Users.get(index).toStringFruitBox()+"Boxes in refrigeraor!";
	}
}
