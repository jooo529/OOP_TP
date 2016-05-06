import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginFrame extends JFrame{
	public LoginFrame(){
		makeLogScreen();
	}

	JButton login_bu;
	JTextField id_tf, pw_tf;
	JButton find_bu;
	JButton sign_bu;
	JButton rank_bu;
//	JLabel save_lb;
	JCheckBox save_chb;
	
	public void makeLogScreen() {
		
		setLayout(new BorderLayout());
		
		JPanel panel0 = new JPanel();
		panel0.setLayout(new BorderLayout());
		this.add(panel0);
		
		JPanel panel1 = new JPanel(); //그림을 넣고 싶다!
		JTextArea ta = new JTextArea("------\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n-");
		
		//panel1.setLayout(null);
		JPanel panel1ta = new JPanel();
		panel1ta.add(ta);
		panel1.add(panel1ta);
		//panel1.setBounds(0, 0, 1700, 500);
		panel0.add(BorderLayout.NORTH,panel1);
		
		//내부 왼쪽 TextField 2개
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2,1));
		panel0.add(BorderLayout.WEST,panel2); 
		  
		JPanel panel2up = new JPanel();
		id_tf = new JTextField("ID",20);
		panel2up.add(id_tf);
		id_tf.addActionListener(new IdTextFieldListener());
		panel2.add(panel2up);
		 
		JPanel panel2down = new JPanel();
		pw_tf = new JTextField("PASSWORD",20);
		panel2down.add(pw_tf);
		panel2.add(panel2down);
		
		//내부 오른쪽 check + button
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(2,1));
		panel0.add(BorderLayout.CENTER,panel3);

		JPanel panel3up = new JPanel();
		save_chb = new JCheckBox("save ID");
		panel3up.add(save_chb);
		panel3.add(panel3up);
		  
		JPanel panel3down = new JPanel();
		login_bu = new JButton("LogIN");
		panel3down.add(login_bu);
		login_bu.addActionListener(new LoginButtonListener());
		panel3.add(panel3down);
		
		JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayout(1,3));
		panel0.add(BorderLayout.SOUTH,panel4);
		
		JPanel panel4left = new JPanel();
		find_bu = new JButton("Find");
		panel4left.add(find_bu);
		find_bu.addActionListener(new FindButtonListener());
		panel4.add(panel4left);
		
		JPanel panel4cent = new JPanel();
		sign_bu = new JButton("Sign up");
		panel4cent.add(sign_bu);
		sign_bu.addActionListener(new SignButtonListener());
		panel4.add(panel4cent);
		
		JPanel panel4right = new JPanel();
		rank_bu = new JButton("Rank");
		panel4right.add(rank_bu);
		rank_bu.addActionListener(new RankButtonListener());
		panel4.add(panel4right);
		
	}
	
	class LoginButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event)
		{
			setVisible(false);
			MainDisplay md = new MainDisplay();
			md.go();
		}
	}
	
	class FindButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event)
		{
			//question get password or change password
		}
	}
	
	class SignButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event)
		{
			//new display && register && new user
			JInternalFrame sign_iFr = new JInternalFrame("Sign Up");
			  
			add(sign_iFr);
		
		}
	}

	class RankButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event)
		{
			//use users information -> get ranks
		}
	}

	class IdTextFieldListener implements ActionListener{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println(id_tf.getText());
			id_tf.setText("");
			id_tf.selectAll();
			id_tf.requestFocus();
		}
	}
	
	class PwTextFieldListener implements ActionListener{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println(pw_tf.getText());
			pw_tf.setText("");
			pw_tf.selectAll();
			pw_tf.requestFocus();
		}
	}
	
}
