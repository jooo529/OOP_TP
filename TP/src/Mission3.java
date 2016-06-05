
public class Mission3 extends MissionFile implements Mission{

	static int index;
	
	@Override
	public String helpMission() {
		return fileLoad("Mission3.txt");
	}

	@Override
	public void checkMission() {
		// TODO Auto-generated method stub
		
	}

	public String getMission(int idx) {
		String str = "<Mission 3>"+"\nPut your all fruits in refrigerator!"
				+ "\nRefrigerator is located in Store." + "\n_________________________________________"
				+ "\n\nNow you have "+UserFile.Users.get(idx).toStringFruit()+"\n\n put them in refrigerator!";
		index = idx;
		return str;
	}

	@Override
	public String[] savedMission() {
		String[] myMission = new String[3];
		myMission[0] = "3";//missionNumber
		myMission[1] = ""+UserFile.Users.get(index).getApple();//fruitAppleNumbYouhaveto
		myMission[2] = ""+UserFile.Users.get(index).getGrape();//fruitGrapeNumbYouhaveto
		myMission[3] = ""+UserFile.Users.get(index).getOrange();//fruitOrangeNumbYouhaveto
		myMission[4] = ""+UserFile.Users.get(index).getStrawBerry();//fruitStrawberryNumbYouhaveto
		return myMission;
	}

}
