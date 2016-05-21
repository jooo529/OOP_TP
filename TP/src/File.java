import java.io.*;
import java.util.*;

public class File {
	
	static ArrayList<User> Users = new ArrayList<User>(); 
	
	public void fileLoad(){
		InputStreamReader isr = null;
		BufferedReader in = null;
		StringTokenizer st;
		
		try{
				Users.clear();
				
				isr = new InputStreamReader(new FileInputStream("User.txt"));
				in = new BufferedReader(new FileReader("User.txt"));
				String str = null;
				while((str = in.readLine())!= null){
					User u = new User();
					st = new StringTokenizer(str,",");
					u.setId(st.nextToken());
					u.setPwd(st.nextToken());
					u.setName(st.nextToken());
					u.setPhoneNum(st.nextToken());
					u.setMoney(Integer.parseInt(st.nextToken()));
					u.setLevel(Integer.parseInt(st.nextToken()));
					u.setLogindata(st.nextToken());
					u.setUsercheckQuestion(st.nextToken());
					u.setUsercheckAnswer(st.nextToken());
					Users.add(u);
				}
		}catch (FileNotFoundException e) { 
			System.out.println(e.getMessage()); 
		}catch(IOException e){
			System.out.println(e.getMessage());   
		}
	}
	
	public void fileSave(){
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter("User.txt"));
			for(int i=0; i<Users.size(); i++){
				fw.write(Users.get(i).getId());
				fw.write(",");
				fw.write(Users.get(i).getPwd());
				fw.write(",");
				fw.write(Users.get(i).getName());
				fw.write(",");
				fw.write(Users.get(i).getPhoneNum());
				fw.write(",");
				fw.write(""+Users.get(i).getMoney());
				fw.write(",");
				fw.write(""+Users.get(i).getLevel());
				fw.write(",");
				fw.write(Users.get(i).getLogindata());
				fw.write(",");
				fw.write(Users.get(i).getUsercheckQuestion());
				fw.write(",");
				fw.write(Users.get(i).getUsercheckAnswer());	
				fw.newLine();
			}
				fw.close();
		}catch (Exception e) {
			System.out.println(e.getMessage()); 
		}
	}
}
