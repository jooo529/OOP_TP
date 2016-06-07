import java.util.*;

//help from javaking75.blog.me/140190267626 ÂüÁ¶
public class User {
	
	private int index;
	private String id, pwd;
	private String name;
	private String phoneNum;
	private int money;
	private int level;//mission
	private int missionNum;
	private String mission;
	private String[] doMission; 
	private String lastlogindata, nowlogindata;
	private String usercheckQuestion, usercheckAnswer;
	private String Fruit;//
	private int apple, grape, orange, StrawBerry;
	private int applebox, grapebox, orangebox, strawberrybox;
	private int appleJuice, grapeJuice, orangeJuice, strawberryJuice;
	private int appleRefri, grapeRefri, orangeRefri, strawberryRefri;

	private ArrayList<String> ConsumerBox = new ArrayList<String>(); 

	public ArrayList<String> getConsumerBox() {
		return ConsumerBox;
	}
	public void setConsumerBox(ArrayList<String> consumerBox) {
		ConsumerBox = consumerBox;
	}
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

	public int getMissionNum() {
		return missionNum;
	}
	public void setMissionNum(int missionNum) {
		this.missionNum = missionNum;
	}
	public String getMission() {
		return mission;
	}
	public void setMission(String mission) {
		this.mission = mission;
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
	
	public int getApplebox() {
		return applebox;
	}
	public void setApplebox(int applebox) {
		this.applebox = applebox;
	}
	public int getGrapebox() {
		return grapebox;
	}
	public void setGrapebox(int grapebox) {
		this.grapebox = grapebox;
	}
	public int getOrangebox() {
		return orangebox;
	}
	public void setOrangebox(int orangebox) {
		this.orangebox = orangebox;
	}
	public int getStrawberrybox() {
		return strawberrybox;
	}
	public void setStrawberrybox(int strawberrybox) {
		this.strawberrybox = strawberrybox;
	}
	public int getAppleJuice() {
		return appleJuice;
	}
	public void setAppleJuice(int appleJuice) {
		this.appleJuice = appleJuice;
	}
	public int getGrapeJuice() {
		return grapeJuice;
	}
	public void setGrapeJuice(int grapeJuice) {
		this.grapeJuice = grapeJuice;
	}
	public int getOrangeJuice() {
		return orangeJuice;
	}
	public void setOrangeJuice(int orangeJuice) {
		this.orangeJuice = orangeJuice;
	}
	public int getStrawberryJuice() {
		return strawberryJuice;
	}
	public void setStrawberryJuice(int strawberryJuice) {
		this.strawberryJuice = strawberryJuice;
	}

	public int getAppleRefri() {
		return appleRefri;
	}
	public void setAppleRefri(int appleRefri) {
		this.appleRefri = appleRefri;
	}
	public int getGrapeRefri() {
		return grapeRefri;
	}
	public void setGrapeRefri(int grapeRefri) {
		this.grapeRefri = grapeRefri;
	}
	public int getOrangeRefri() {
		return orangeRefri;
	}
	public void setOrangeRefri(int orangeRefri) {
		this.orangeRefri = orangeRefri;
	}
	public int getStrawberryRefri() {
		return strawberryRefri;
	}
	public void setStrawberryRefri(int strawberryRefri) {
		this.strawberryRefri = strawberryRefri;
	}
	public String toStringFruitBox() {
		return "[Applebox=" + applebox + "+ Grapebox=" + grapebox + "+ "
				+ "Orangebox=" + orangebox + "+ StrawBerrybox=" + strawberrybox + "]";
	}
	@Override
	public String toString() {
		return "User [index=" + index + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", phoneNum=" + phoneNum
				+ ", money=" + money + ", level=" + level + ", missionNum=" + missionNum + ", mission=" + mission
				+ ", doMission=" + Arrays.toString(doMission) + ", lastlogindata=" + lastlogindata + ", nowlogindata="
				+ nowlogindata + ", usercheckQuestion=" + usercheckQuestion + ", usercheckAnswer=" + usercheckAnswer
				+ ", Fruit=" + Fruit + ", apple=" + apple + ", grape=" + grape + ", orange=" + orange + ", StrawBerry="
				+ StrawBerry + ", applebox=" + applebox + ", grapebox=" + grapebox + ", orangebox=" + orangebox
				+ ", strawberrybox=" + strawberrybox + ", appleJuice=" + appleJuice + ", grapeJuice=" + grapeJuice
				+ ", orangeJuice=" + orangeJuice + ", strawberryJuice=" + strawberryJuice + ", appleRefri=" + appleRefri
				+ ", grapeRefri=" + grapeRefri + ", orangeRefri=" + orangeRefri + ", strawberryRefri=" + strawberryRefri
				+ ", ConsumerBox=" + ConsumerBox + "]";
	}
		
}
