import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sign extends UserFile implements ActionListener{
	
	private JTextField ID_tf,PW_tf,PWc_tf,Name_tf,Phone_tf1,Phone_tf2,ucQ_tf,ucA_tf;
	private JComboBox<String> Phone_cb ;
	JFrame sign_fr = new JFrame("Sign Up");
	
	void go(){
		JButton confirm;
		sign_fr.setSize(750,370);
		sign_fr.setVisible(true);
		sign_fr.setResizable(false);
		sign_fr.setDefaultCloseOperation(sign_fr.DISPOSE_ON_CLOSE);
		
		//전체 창 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		//창을 중앙에 위치시킬 수 있다.
		int xPos = screenSize.width/2 - sign_fr.getSize().width/2 ;
		int yPos = screenSize.height/2 - sign_fr.getSize().height/2 ;

		sign_fr.setLayout(new BorderLayout());
		sign_fr.add(BorderLayout.NORTH,new JLabel("Put your Info"));
		  
		JPanel panel = new JPanel(new GridLayout(8,2));
		sign_fr.add(BorderLayout.CENTER, panel);
		  
		panel.add(new JLabel("ID",JLabel.CENTER));
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		ID_tf = new JTextField(15);
		panel1.add(ID_tf);
		panel.add(panel1);
		  
		panel.add(new JLabel("PassWord",JLabel.CENTER));	
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		PW_tf = new JTextField(15);  
		panel2.add(PW_tf);
		panel.add(panel2);
		  
		panel.add(new JLabel("PassWord Check",JLabel.CENTER));
		JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		PWc_tf = new JTextField(15);
		panel3.add(PWc_tf);
		panel.add(panel3);
		  
		panel.add(new JLabel("Name",JLabel.CENTER));
		JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		Name_tf = new JTextField(8);
		panel4.add(Name_tf);
		panel.add(panel4);
		  
		panel.add(new JLabel("Phone",JLabel.CENTER));
		JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		String[] phone = {"010","011","016","019"};
		Phone_cb = new JComboBox<String>(phone);
		Phone_tf1 = new JTextField(4);
		Phone_tf2 = new JTextField(4);
		panel5.add(Phone_cb);
		panel5.add(new JLabel("-"));
		panel5.add(Phone_tf1);
		panel5.add(new JLabel("-"));
		panel5.add(Phone_tf2);
		panel.add(panel5);
		
		panel.add(new JLabel("UserCheck Question",JLabel.CENTER));
		JPanel panel6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		ucQ_tf = new JTextField(30);
		panel6.add(ucQ_tf);
		panel.add(panel6);
		  
		panel.add(new JLabel("UserCheck Answer",JLabel.CENTER));
		JPanel panel7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		ucA_tf = new JTextField(30);
		panel7.add(ucA_tf);
		panel.add(panel7);
		  
		JPanel panel8 = new JPanel();
		confirm = new JButton("Join Us");
		panel8.add(confirm);
		sign_fr.add(BorderLayout.SOUTH, panel8);
		  
		confirm.addActionListener(this);
	 
		sign_fr.setLocation(xPos,yPos);		

}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String inId, inPwd, inPwd2, inName, inPhone, inPhone1, inPhone2, inQ, inA;
		inId = ID_tf.getText();
		inPwd = PW_tf.getText();
		inPwd2 = PWc_tf.getText();
		inName = Name_tf.getText();
		inPhone1 = Phone_tf1.getText();
		inPhone2 = Phone_tf2.getText();
		inPhone = Phone_cb.getSelectedItem().toString()+ inPhone1 + inPhone2;
		inQ = ucQ_tf.getText();
		inA = ucA_tf.getText();
		
		this.fileLoad();
		
		if(inId.equals("")||inPwd.equals("")||inPwd2.equals("")||inName.equals("")||
				inPhone.equals("")||inQ.equals("")||inA.equals("")||Phone_tf1.getText().equals("")||Phone_tf2.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Check the Blank!", "Message", JOptionPane.INFORMATION_MESSAGE);
		}else if(!(inPwd.equals(inPwd2))){
			JOptionPane.showMessageDialog(null, "Check the PassWord", "Message", JOptionPane.INFORMATION_MESSAGE);
		}else{
			Boolean idCheck = true;
			for(int i=0; i<Users.size(); i++){
				if(inId.equals(Users.get(i).getId())){
					JOptionPane.showMessageDialog(null, "There is Same ID. Use Another ID!", "Message", JOptionPane.INFORMATION_MESSAGE);
					idCheck = false;
				}	
			}
			if(inId.length()<5){
				JOptionPane.showMessageDialog(null, "ID must be longer than 5", "Message", JOptionPane.INFORMATION_MESSAGE);
			}else if(inPwd.length()<7){
				JOptionPane.showMessageDialog(null, "Password Must be longer than 7", "Message", JOptionPane.INFORMATION_MESSAGE);
			}else if(checkInt(inName)){
				JOptionPane.showMessageDialog(null, "Check the Name", "Message", JOptionPane.INFORMATION_MESSAGE);
			}else if(!checkInt(inPhone)||inPhone1.length()>4||inPhone2.length()>4){
				JOptionPane.showMessageDialog(null, "Check the Phone Number", "Message", JOptionPane.INFORMATION_MESSAGE);
			}else if(idCheck==true){
				int confirm = JOptionPane.showConfirmDialog(null, "IS it Right?\n" + 
						"ID: "+inId + "\nPWD : "+inPwd + "\nName : " + inName +
						"\nPhone : " + inPhone + "\ncheckQuestion : " + inQ + "\ncheckAnswer : " +inA,
						"Message", JOptionPane.INFORMATION_MESSAGE );
				if(confirm == 0){
					User u = new User();
					u.setId(inId);
					u.setPwd(inPwd);
					u.setName(inName);
					u.setPhoneNum(inPhone);
					u.setLevel(1);
					u.setMoney(0);
					u.setLastlogindata("-");
					u.setNowlogindata("-");
					u.setUsercheckQuestion(inQ);
					u.setUsercheckAnswer(inA);
					Users.add(u);
					this.fileSave();
					JOptionPane.showMessageDialog(null, "Success the Register", "Message", JOptionPane.INFORMATION_MESSAGE);
					sign_fr.setVisible(false);
				}else 
					JOptionPane.showMessageDialog(null, "Fail the Register", "Message", JOptionPane.INFORMATION_MESSAGE);
			}}
		}

	private boolean checkInt(String input) {//digit:true, char: false
		char[] dataArr = input.toCharArray();
		boolean check = true;
		while(check){
			for(char num: dataArr){		
				if(!Character.isDigit(num)){
					check = false;
					break;
				}
			}break;	
		}return check;
	}
}
	