import java.io.*;

public class MissionFile {
	public String fileLoad(String file) {
		String read = "";
		try {
			File myFile = new File(file);
			FileReader fr = new FileReader(myFile);
			String str = "";
			BufferedReader br = new BufferedReader(fr);
			while ((str = br.readLine()) != null) {
			read = read+str+"\n";
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return read;
	}
}
