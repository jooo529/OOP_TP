import java.util.ArrayList;

public class Mission3 extends MissionFile implements Mission{

	UserFile f = new UserFile();
	
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
				+ "\n\nNow you have "+f.Users.get(idx).toStringFruit()+"\n\n put them in refrigerator!";
		
		return str;
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<String> savedMission() {
		// TODO Auto-generated method stub
		return null;
	}

}
