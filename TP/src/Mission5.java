import java.util.ArrayList;

public class Mission5 extends MissionFile implements Mission{

	@Override
	public String helpMission() {
		return fileLoad("Mission5.txt");
	}

	@Override
	public void checkMission() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getMission(int idx) {
		String str = "<Mission 5>" + "\nYou have to go to Store and sell juice!"
				+ "\nIn Store, some consumers will be there." + "\nThey want your fruit juice!"
				+ "\nSell them some juice!" + "\n_________________________________________" + "\n\nThere are "
				+ randomConsumer + " cunsumers in store!" + "\nSell juices for all of them!";
		return str;
	}

	@Override
	public String[] savedMission() {
		String[] myMission = new String[3];
		myMission[0] = "4";//missionNumber
		myMission[1] = ""+randomConsumer;
		return myMission;
	}


}