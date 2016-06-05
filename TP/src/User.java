import java.util.*;

//help from javaking75.blog.me/140190267626 ÂüÁ¶
public class User {
	
	private int index;
	private String id;
	private String pwd;
	private String name;
	private String phoneNum;
	private int money;
	private int level;//mission
	private boolean getMission;
	private String mission;
	private String[] doMission; 
	private String lastlogindata;
	private String nowlogindata;
	private String usercheckQuestion;
	private String usercheckAnswer;
	private String Fruit;//
	private int apple;
	private int grape;
	private int orange;
	private int StrawBerry;
	private ArrayList<String> FruitBox = new ArrayList<String>(); 

	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public boolean isGetMission() {
		return getMission;
	}
	public void setGetMission(boolean getMission) {
		this.getMission = getMission;
	}
	public String[] getDoMission() {
		return doMission;
	}
	public void setDoMission(String[] doMission) {
		this.doMission = doMission;
	}
	public String getLastlogindata() {
		return lastlogindata;
	}
	public void setLastlogindata(String lastlogindata) {
		this.lastlogindata = lastlogindata;
	}
	public String getNowlogindata() {
		return nowlogindata;
	}
	public void setNowlogindata(String nowlogindata) {
		this.nowlogindata = nowlogindata;
	}
	public String getUsercheckQuestion() {
		return usercheckQuestion;
	}
	public void setUsercheckQuestion(String usercheckQuestion) {
		this.usercheckQuestion = usercheckQuestion;
	}
	public String getFruit() {
		return Fruit;
	}
	public void setFruit(String fruit) {
		Fruit = fruit;
	}
	public String getUsercheckAnswer() {
		return usercheckAnswer;
	}
	public void setUsercheckAnswer(String usercheckAnswer) {
		this.usercheckAnswer = usercheckAnswer;
	}	
	public int getApple() {
		return apple;
	}
	public void setApple(int apple) {
		this.apple = apple;
	}
	public int getGrape() {
		return grape;
	}
	public void setGrape(int grape) {
		this.grape = grape;
	}
	public int getOrange() {
		return orange;
	}
	public void setOrange(int orange) {
		this.orange = orange;
	}
	public int getStrawBerry(){
		return StrawBerry;
	}
	public void setStrawBerry(int StrawBerry){
		this.StrawBerry = StrawBerry;
	}
	
	public String toStringFruit() {
		return "[apple=" + apple + ", grape=" + grape + ", orange=" + orange + ", StrawBerry=" + StrawBerry + "]";
	}
	
	@Override
	public String toString() {
		return "User [index=" + index + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", phoneNum=" + phoneNum
				+ ", money=" + money + ", level=" + level + ", getMission=" + getMission + ", mission=" + mission
				+ ", doMission=" + Arrays.toString(doMission) + ", lastlogindata=" + lastlogindata + ", nowlogindata="
				+ nowlogindata + ", usercheckQuestion=" + usercheckQuestion + ", usercheckAnswer=" + usercheckAnswer
				+ ", Fruit=" + Fruit + ", apple=" + apple + ", grape=" + grape + ", orange=" + orange + ", StrawBerry="
				+ StrawBerry + ", FruitBox=" + FruitBox + "]";
	}

}
