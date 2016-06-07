
public interface Mission {

	String fruit[] = { "apple", "grape", "orange", "strawberry" };

	public String helpMission();
	public String progressMission();
	public Boolean checkMission(int idx, int Num, String str);
	public String getMission(int idx);
	public String[] savedMission();

}
