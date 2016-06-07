import java.io.*;
import java.util.*;

public class UserFile {

	static ArrayList<User> Users = new ArrayList<User>();

	public void fileLoad() {
		StringTokenizer st;

		try {
			Users.clear();
			File myFile = new File("User.txt");
			FileReader fr = new FileReader(myFile);
			BufferedReader br = new BufferedReader(fr);
			String str = null;
			while ((str = br.readLine()) != null) {
				User u = new User();
				st = new StringTokenizer(str, ",");
				u.setId(st.nextToken());
				u.setPwd(st.nextToken());
				u.setName(st.nextToken());
				u.setPhoneNum(st.nextToken());
				u.setMoney(Integer.parseInt(st.nextToken()));
				u.setLevel(Integer.parseInt(st.nextToken()));
				u.setMissionNum(Integer.parseInt(st.nextToken()));
				u.setMission(st.nextToken());
				String[] doMission = {st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken()};
				u.setDoMission(doMission);
				u.setLastlogindata(st.nextToken());
				u.setNowlogindata(st.nextToken());
				u.setUsercheckQuestion(st.nextToken());
				u.setUsercheckAnswer(st.nextToken());
				u.setApple(Integer.parseInt(st.nextToken()));
				u.setGrape(Integer.parseInt(st.nextToken()));
				u.setOrange(Integer.parseInt(st.nextToken()));
				u.setStrawBerry(Integer.parseInt(st.nextToken()));
				u.setApplebox(Integer.parseInt(st.nextToken()));
				u.setGrapebox(Integer.parseInt(st.nextToken()));
				u.setOrangebox(Integer.parseInt(st.nextToken()));
				u.setStrawberrybox(Integer.parseInt(st.nextToken()));
				
//				u.setApple_box(Boolean.parseBoolean(st.nextToken()));
//				u.setGrape_box(Boolean.parseBoolean(st.nextToken()));
//				u.setOrange_box(Boolean.parseBoolean(st.nextToken()));
//				u.setStrawberry_box(Boolean.parseBoolean(st.nextToken()));
				Users.add(u);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void fileSave() {
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter("User.txt"));
			for (int i = 0; i < Users.size(); i++) {
				fw.write(Users.get(i).getId());
				fw.write(",");
				fw.write(Users.get(i).getPwd());
				fw.write(",");
				fw.write(Users.get(i).getName());
				fw.write(",");
				fw.write(Users.get(i).getPhoneNum());
				fw.write(",");
				fw.write("" + Users.get(i).getMoney());
				fw.write(",");
				fw.write("" + Users.get(i).getLevel());
				fw.write(",");
				fw.write("" + Users.get(i).getMissionNum());
				fw.write(",");
				fw.write(Users.get(i).getMission());
				fw.write(",");
				fw.write(Users.get(i).getDoMission()[0]);
				fw.write(",");
				fw.write(Users.get(i).getDoMission()[1]);
				fw.write(",");
				fw.write(Users.get(i).getDoMission()[2]);
				fw.write(",");
				fw.write(Users.get(i).getDoMission()[3]);
				fw.write(",");
				fw.write(Users.get(i).getDoMission()[4]);
				fw.write(",");
				fw.write(Users.get(i).getLastlogindata());
				fw.write(",");
				fw.write(Users.get(i).getNowlogindata());
				fw.write(",");
				fw.write(Users.get(i).getUsercheckQuestion());
				fw.write(",");
				fw.write(Users.get(i).getUsercheckAnswer());
				fw.write(",");
				fw.write("" + Users.get(i).getApple());
				fw.write(",");
				fw.write("" + Users.get(i).getGrape());
				fw.write(",");
				fw.write("" + Users.get(i).getOrange());
				fw.write(",");
				fw.write("" + Users.get(i).getStrawBerry());
				fw.write(",");
				fw.write("" + Users.get(i).getApplebox());
				fw.write(",");
				fw.write("" + Users.get(i).getGrapebox());
				fw.write(",");
				fw.write("" + Users.get(i).getOrangebox());
				fw.write(",");
				fw.write("" + Users.get(i).getStrawberrybox());
//				fw.write(",");
//				fw.write("" + Users.get(i).isApple_box());
//				fw.write(",");
//				fw.write("" + Users.get(i).isGrape_box());
//				fw.write(",");
//				fw.write("" + Users.get(i).isOrange_box());
//				fw.write(",");
//				fw.write("" + Users.get(i).isStrawberry_box());
				fw.newLine();
			}
			fw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
