import java.util.ArrayList;

public class Mission5 extends MissionFile implements Mission {

	int randomConsumer = (int) (Math.random() * 4 + 1);
	int randomFruittype1 = (int) (Math.random() * 4);
	int randomFruittype2 = (int) (Math.random() * 4);
	int randomFruittype3 = (int) (Math.random() * 4);
	int randomFruittype4 = (int) (Math.random() * 4);
	
	public String helpMission() {
		return fileLoad("Mission5.txt");
	}

	public Boolean checkMission(int idx, int fruitNum, String str) {
		ArrayList<String> check = new ArrayList<String>();
		check = UserFile.Users.get(idx).getConsumerBox();	
		Boolean success = true;
		if(fruitNum==1){
			if(!check.get(0).equals(UserFile.Users.get(idx).getDoMission()[5])) success = false;
		}else if(fruitNum==2){
			if(!check.get(0).equals(UserFile.Users.get(idx).getDoMission()[4])) success = false;
			if(!check.get(1).equals(UserFile.Users.get(idx).getDoMission()[5])) success = false;
		}else if(fruitNum==3){
			if(!check.get(0).equals(UserFile.Users.get(idx).getDoMission()[3])) success = false;
			if(!check.get(1).equals(UserFile.Users.get(idx).getDoMission()[4])) success = false;
			if(!check.get(2).equals(UserFile.Users.get(idx).getDoMission()[5])) success = false;
		}else if(fruitNum==4){
			if(!check.get(0).equals(UserFile.Users.get(idx).getDoMission()[2])) success = false;
			if(!check.get(1).equals(UserFile.Users.get(idx).getDoMission()[3])) success = false;
			if(!check.get(2).equals(UserFile.Users.get(idx).getDoMission()[4])) success = false;
			if(!check.get(3).equals(UserFile.Users.get(idx).getDoMission()[5])) success = false;
		}
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
		String[] myMission = new String[6];
		myMission[0] = "5";// missionNumber
		myMission[1] = "" + randomConsumer;
		myMission[2] = fruit[randomFruittype1];
		myMission[3] = fruit[randomFruittype2];
		myMission[4] = fruit[randomFruittype3];
		myMission[5] = fruit[randomFruittype4];
		return myMission;
	}

	public String progressMission() {
		return "There are " + randomConsumer + " consumers in store!" + "\t\tSell juices for all of them";
	}

}