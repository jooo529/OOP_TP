import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Find extends UserFile implements ActionListener {

	private JTextField Name_tf,Phone_tf1,Phone_tf2;
	private JComboBox Phone_cb ;
	private JButton confirm;

	JFrame find_fr = new JFrame("Find");

	void go(){
		find_fr.setSize(500,150);
		find_fr.setVisible(true);
		find_fr.setResizable(false);
		find_fr.setDefaultCloseOperation(find_fr.DISPOSE_ON_CLOSE);
		find_fr.setLayout(new BorderLayout());
		find_fr.add(BorderLayout.NORTH,new JLabel("Put your Info"));
		  
		JPanel panel = new JPanel(new GridLayout(2,2));
		find_fr.add(BorderLayout.CENTER, panel);
		 
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
	
		JPanel panel6 = new JPanel();
		confirm = new JButton("Confirm");
		panel6.add(confirm);
		
		confirm.addActionListener(this);
		
		find_fr.add(BorderLayout.SOUTH, panel6);
		
		//전체 창 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		//창을 중앙에 위치시킬 수 있다.
		int xPos = screenSize.width/2 - find_fr.getSize().width/2 ;
		int yPos = screenSize.height/2 - find_fr.getSize().height/2 ;

		find_fr.setLocation(xPos,yPos);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		this.fileLoad();
		
		Boolean find = false;
		int userNum = -1;
		String inName, inPhone;
		Object inAnswer;
		String inputAnswer;
		
		inName = Name_tf.getText();
		inPhone = Phone_cb.getSelectedItem().toString()+  Phone_tf1.getText() + Phone_tf2.getText();
				
		for(int i=0; i<Users.size(); i++){
			if((Users.get(i).getName().equals(inName))&&(Users.get(i).getPhoneNum().equals(inPhone))) {
				find = true;
				userNum = i;
			}
		}
		if(find){
			inAnswer = JOptionPane.showInputDialog(null, "Your ID: "+Users.get(userNum).getId()+"\n"+Users.get(userNum).getUsercheckQuestion()+" ?", "Find", JOptionPane.QUESTION_MESSAGE);
			if(inAnswer != null){
				inputAnswer = (String)inAnswer;
				if(inputAnswer.equals(Users.get(userNum).getUsercheckAnswer())){
					JOptionPane.showMessageDialog(null, "Your ID: "+Users.get(userNum).getId()+"\nYour PW: "+Users.get(userNum).getPwd());
			}else{
				JOptionPane.showMessageDialog(null, "CHECK the Answer", "ERROR", JOptionPane.ERROR_MESSAGE);
			}}
		}else{
			JOptionPane.showMessageDialog(null, "CHECK NAME or PHONE", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

}

