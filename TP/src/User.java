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
	private String lastlogindata;
	private String nowlogindata;
	private String usercheckQuestion;
	private String usercheckAnswer;
	String Fruits[] = {"Apple", "Grapes","StrawBerry"};//
	private ArrayList<String> Fruit = new ArrayList<String>(); 

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
	public ArrayList<String> getFruit() {
		return Fruit;
	}
	public void setFruit(ArrayList<String> fruit) {
		Fruit = fruit;
	}
	public String getUsercheckAnswer() {
		return usercheckAnswer;
	}
	public void setUsercheckAnswer(String usercheckAnswer) {
		this.usercheckAnswer = usercheckAnswer;
	}

	@Override
	public String toString() {
		return "User [index=" + index + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", phoneNum=" + phoneNum
				+ ", money=" + money + ", level=" + level + ", lastlogindata=" + lastlogindata + ", nowlogindata="
				+ nowlogindata + ", usercheckQuestion=" + usercheckQuestion + ", usercheckAnswer=" + usercheckAnswer
				+ ", Fruit=" + Fruit + "]";
	}

}
