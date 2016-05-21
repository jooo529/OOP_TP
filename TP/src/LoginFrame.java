import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class LoginFrame extends JFrame{
	
	public LoginFrame(){
		makeLogScreen();
	}
	
	JButton login_bu;
	JLabel id_lb, pw_lb;
	JTextField id_tf;
	TextField pw_tf;
	JButton find_bu;
	JButton sign_bu;
	JButton rank_bu;
	JCheckBox save_chb;
	
	private int check=0;
	
	ImageIcon im;
	Container con;
	
	public void makeLogScreen() {
		
		con = this.getContentPane();
		con.setLayout(new BorderLayout());
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		con.add(BorderLayout.CENTER,panel1);
		
		im = new ImageIcon("login.png");
		JPanel panel1a = new JPanel(){ 
		 public void paintComponent(Graphics g) {
             g.drawImage(im.getImage(), 0, 0, null); 
        }};
		panel1.add(BorderLayout.CENTER,panel1a);
		
		JPanel panel1b = new JPanel();
		panel1b.setLayout(new BorderLayout());
		panel1.add(BorderLayout.SOUTH,panel1b); 
		
		JPanel panel1b1 = new JPanel();
		panel1b1.setLayout(new BorderLayout());
		panel1b.add(BorderLayout.WEST,panel1b1); 
		
		JPanel panel1b1a = new JPanel();
		panel1b1a.setLayout(new GridLayout(2,1,5,5));
		panel1b1.add(BorderLayout.WEST,panel1b1a); 
		
		id_lb = new JLabel("          ID    ");
		panel1b1a.add(id_lb);
		pw_lb = new JLabel("          PWD    ");
		panel1b1a.add(pw_lb);
		
		JPanel panel1b1b = new JPanel();
		panel1b1b.setLayout(new GridLayout(2,1,5,0));
		panel1b1.add(BorderLayout.CENTER,panel1b1b); 
		
		JPanel panel1b1up = new JPanel();
		id_tf = new JTextField(20);
		panel1b1up.add(id_tf);
		panel1b1b.add(panel1b1up);
		id_tf.addActionListener(new LoginListener());
		
		JPanel panel1b1down = new JPanel();
		pw_tf = new TextField(27);
		panel1b1down.add(pw_tf);
		pw_tf.setEchoChar('*');
		pw_tf.addActionListener(new LoginListener());
		panel1b1b.add(panel1b1down);
		
		//내부 오른쪽 check + button
		JPanel panel1b2 = new JPanel();
		panel1b2.setLayout(new GridLayout(2,1,5,0));
		panel1b.add(BorderLayout.EAST,panel1b2); 
		
		JPanel panel1b2up = new JPanel();
		save_chb = new JCheckBox("save ID");
		panel1b2up.add(save_chb);
		panel1b2.add(panel1b2up);
		save_chb.addItemListener(new ItemListener() {
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == 1)	check=1;
		        else check=0;
		    }
		});
		
		JPanel panel1b2down = new JPanel();
		login_bu = new JButton("LogIN");
		panel1b2down.add(login_bu);
		login_bu.addActionListener(new LoginListener());
		
		panel1b2.add(panel1b2down);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,3,5,5));
		con.add(BorderLayout.SOUTH,panel2);
		
		JPanel panel2a = new JPanel();
		find_bu = new JButton("Find");
		panel2a.add(find_bu);
		find_bu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Find fr = new Find();
				fr.go();
			}
		});
		panel2.add(panel2a);
		
		JPanel panel2b = new JPanel();
		sign_bu = new JButton("Sign up");
		panel2b.add(sign_bu);
		sign_bu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Sign fr = new Sign();
				fr.go();
			}
		});
		panel2.add(panel2b);
		
		JPanel panel2c = new JPanel();
		rank_bu = new JButton("Rank");
		panel2c.add(rank_bu);
		rank_bu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Rank fr = new Rank();
				fr.go();
			}
		});
		panel2.add(panel2c);
	}
	
	class LoginListener extends File implements ActionListener{
		public void actionPerformed(ActionEvent event)
		{
			this.fileLoad();
			Boolean login = false;
			String inputID = id_tf.getText();
			String inputPWD = pw_tf.getText();

			for(int i=0; i<Users.size(); i++){
				if((Users.get(i).getId().equals(inputID))&&(Users.get(i).getPwd().equals(inputPWD)))login=true;
			}
			if(login){
				setVisible(false);
				MainDisplay md = new MainDisplay();
				md.go();
			}else{
				JOptionPane.showMessageDialog(null, "CHECK ID or PW", "ERROR", JOptionPane.ERROR_MESSAGE);
				if(check==1) id_tf.setText(inputID);
				else id_tf.setText(null);
				pw_tf.setText(null);
			}
		}
	}

}