import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignButtonListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		go();
	}

	void go(){
		SignFrame sign_fr = new SignFrame();

		sign_fr.setSize(750,370);
		sign_fr.setVisible(true);
		sign_fr.setResizable(false);
		sign_fr.setDefaultCloseOperation(SignFrame.DISPOSE_ON_CLOSE);
		
		//전체 창 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		//창을 중앙에 위치시킬 수 있다.
		int xPos = screenSize.width/2 - sign_fr.getSize().width/2 ;
		int yPos = screenSize.height/2 - sign_fr.getSize().height/2 ;

		sign_fr.setLocation(xPos,yPos);
		
	}
	
}

class SignFrame extends JFrame{

	JTextField ID_tf,PW_tf,PWc_tf,Name_tf,Phone_tf1,Phone_tf2,ucQ_tf,ucA_tf;
	JComboBox Phone_cb ;
	JButton confirm;
	
	 public SignFrame(){
	  super("Sign Up");
	  makeSignScreen();
	 }
	 
	 public void makeSignScreen(){
	  
	  this.setLayout(new BorderLayout());
	  this.add(BorderLayout.NORTH,new JLabel("Put your Info"));
	  
	  JPanel panel = new JPanel(new GridLayout(8,2));
	  this.add(BorderLayout.CENTER, panel);
	  
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
	  this.add(BorderLayout.SOUTH, panel8);
	 }
	 
}