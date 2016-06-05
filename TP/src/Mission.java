import java.util.ArrayList;

public interface Mission {

	String fruit[] = {"apple","grape","orange","strawberry"};
	int randomFruitnum = (int) (Math.random() * 5 + 1);
	int randomConsumer = (int) (Math.random() * 5 + 3);
	int randomFruittype = (int) (Math.random() * 4);

	public String helpMission();;

	public void checkMission();

	public String getMission(int idx);

	public ArrayList<String> savedMission();

}
