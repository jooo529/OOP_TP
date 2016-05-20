//help from javaking75.blog.me/140190267626 ÂüÁ¶
public class User {
	
	private String id;
	private String pwd;
	private String name;
	private String phoneNum;
	private int money;
	private int level;
	private String logindata;
	private String usercheckQuestion;
	private String usercheckAnswer;
	
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
	public int getmoney() {
		return money;
	}
	public void setEarnedMoney(int money) {
		this.money = money;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getLogindata() {
		return logindata;
	}
	public void setLogindata(String logindata) {
		this.logindata = logindata;
	}
	public String getUsercheckQuestion() {
		return usercheckQuestion;
	}
	public void setUsercheckQuestion(String usercheckQuestion) {
		this.usercheckQuestion = usercheckQuestion;
	}
	public String getUsercheckAnswer() {
		return usercheckAnswer;
	}
	public void setUsercheckAnswer(String usercheckAnswer) {
		this.usercheckAnswer = usercheckAnswer;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", pwd=" + pwd + ", name=" + name + ", phoneNum=" + phoneNum + ", money="
				+ money + ", level=" + level + ", logindata=" + logindata + ", usercheckQuestion="
				+ usercheckQuestion + ", usercheckAnswer=" + usercheckAnswer + "]";
	}

	

}
