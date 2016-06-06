import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.*;

public class checkFrame extends JFrame {

	public checkFrame(){
		//set frame's state
		this.setSize(700,350);
		this.setTitle("Check Mission");
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(LoginFrame.DISPOSE_ON_CLOSE);
			
			//entire window's size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			  
			////locate frame in center
		int xPos = screenSize.width/2 - this.getSize().width/2 ;
		int yPos = screenSize.height/2 - this.getSize().height/2 ;

		this.setLocation(xPos,yPos);
			
		
		
		this.go_cf();
	}

	private Container container; //Frame
	
	private ImageIcon npcf; //Mom NPC's image
	private ImageIcon tb; //Mom's comment
	
	private JPanel window; // It's MISSION 1~5 <- button
	private JPanel checkmission; //if you click one of window's button, show this panel.
	private JPanel npc_face; 
	private JTextArea mission; // text of mission checking
	private JButton checkAndexit; // check and exit
	
	private Font font2 = new Font("Kristen ITC", Font.BOLD, 14);
	private Font font = new Font("Kristen ITC", Font.BOLD, 20); // 30글자 크기
	
	private JButton mission1;
	private JButton mission2;
	private JButton mission3;
	private JButton mission4;
	private JButton mission5;
	
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	
	private Border missionBorder;
	private Border emptyBorder;
	
	private UserFile f = new UserFile();
	static int idx = -1;
	static Mission[] m = new Mission[5];
	
	
	
	void go_cf() {

		try{
			for (int i = 0; i < UserFile.Users.size(); i++) {
				if (UserFile.Users.get(i).getIndex() > -1) //throw exception
					idx = i;
			} //id (who's?)
		}
		
		catch(IndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}

		container = this.getContentPane(); //Frame
		container.setLayout(null); //No layout manager

		window = new JPanel(); 
		window.setLayout(new GridLayout(5, 1, 0, 0)); // 5button will be in here

		npcf = new ImageIcon("mom.PNG"); //mom's image
		tb = new ImageIcon("textBallon_checkm.png"); //what does my mom say
		
		npc_face = new JPanel() { // in this panel - mom's face
			public void paintComponent(Graphics g) {
				g.drawImage(npcf.getImage(), 3, 0, null);
				g.drawImage(tb.getImage(), 180, 30, null); // - and what does mom say
			}
		};
		;
		
		npc_face.setLayout(null); //set mom's face panel no layout manager.
		
// mission1~mission5 -> make button
		mission1 = new JButton();
		mission1.setIcon(new ImageIcon("mission_b.png")); 
		mission1.addActionListener(new mission_b_listener());
		label1 = new JLabel("            M  i  s  s  i  o  n  1  ");
		mission1.setRolloverIcon(new ImageIcon(""));
		label1.setFont(font);
		

		mission2 = new JButton();
		mission2.setIcon(new ImageIcon("mission_b.png"));
		mission2.addActionListener(new mission_b_listener());
		mission2.setRolloverIcon(new ImageIcon(""));
		label2 = new JLabel("            M  i  s  s  i  o  n  2  ");
		label2.setFont(font);
		

		mission3 = new JButton();
		mission3.setIcon(new ImageIcon("mission_b.png"));
		mission3.addActionListener(new mission_b_listener());
		mission3.setRolloverIcon(new ImageIcon(""));
		label3 = new JLabel("            M  i  s  s  i  o  n  3  ");
		label3.setFont(font);
		

		mission4 = new JButton();
		mission4.setIcon(new ImageIcon("mission_b.png"));
		mission4.addActionListener(new mission_b_listener());
		mission4.setRolloverIcon(new ImageIcon(""));
		label4 = new JLabel("            M  i  s  s  i  o  n  4  ");
		label4.setFont(font);

		mission5 = new JButton();
		mission5.setIcon(new ImageIcon("mission_b.png"));
		mission5.addActionListener(new mission_b_listener());
		mission5.setRolloverIcon(new ImageIcon(""));
		label5 = new JLabel("            M  i  s  s  i  o  n  5  ");
		label5.setFont(font);
		
		try{	
			mission1.add(label1);
			mission2.add(label2);
			mission3.add(label3);
			mission4.add(label4);
			mission5.add(label5);
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		
		
//make button finish--		

		
		//add buttons in window!
		try{
			window.add(mission1);
			window.add(mission2);
			window.add(mission3);
			window.add(mission4);
			window.add(mission5);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}

		checkAndexit = new JButton("Ok! Thank you!");// check and exit
		checkmission = new JPanel(); //check mission!
		checkmission.setLayout(null);
		
		window.setBounds(0, 0, 390, 310);
		npc_face.setBounds(390, 0, 300, 350);
		checkAndexit.setBounds(130, 270, 130, 30);
		checkmission.setBounds(0, 0, 390, 310);
		
		

		

		
		
		mission = new JTextArea();
		mission.setLineWrap(true); //wrap line to not over block
		mission.setBounds(20, 10, 350, 250);
		mission.setFont(font2);
		
		
		try{
			container.add(window);
			container.add(npc_face);
			checkmission.add(mission);
			checkmission.add(checkAndexit);
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		
		missionBorder = BorderFactory.createLineBorder(Color.black, 3);
		emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);
		
		mission.setBorder(BorderFactory.createCompoundBorder(missionBorder, emptyBorder));
		// reference --  Make textArea's Border -> http://blog.naver.com/timberx/30111890732
	

	}
	
	class Check implements ActionListener { //check mission
		int k;
		public Check(int i){ // id
			k=i;
		}
		public void actionPerformed(ActionEvent event) {
			try{
				if(UserFile.Users.get(idx).getLevel()!=k){ //if your level is low
					JOptionPane.showMessageDialog(null, "FAULT! You aren't in level "+k+"! You lose 500Money:(", "Message", JOptionPane.INFORMATION_MESSAGE);
					UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney()-500);
					f.fileSave();
				}else {
					//미션 제대로 수행했을때와 안했을때!
					System.out.println("!!");
				}
			}
			catch(IndexOutOfBoundsException e)
			{
				e.printStackTrace();
			}
			
			setVisible(false);
		}
	}
	
	

	class mission_b_listener implements ActionListener { //
		public void actionPerformed(ActionEvent event) {
			
			m[0] = new Mission1(); //Mission 1 class
			m[1] = new Mission2(); //Mission 2 class
			m[2] = new Mission3(); //Mission 3 class
			m[3] = new Mission4(); //Mission 4 class
			m[4] = new Mission5(); //Mission 5 class
			
			
			window.setVisible(false);
			
			
			//bring mission text
			if (event.getSource() == mission1) {
				mission.setText(((Mission1) m[0]).stringCheck(1));
				checkAndexit.addActionListener(new Check(1));				
			} else if (event.getSource() == mission2) {
				mission.setText(((Mission2) m[1]).stringCheck(2));
				checkAndexit.addActionListener(new Check(2));				
			} else if (event.getSource() == mission3) {
				mission.setText(((Mission3) m[2]).stringCheck(3));
				checkAndexit.addActionListener(new Check(3));				
			} else if (event.getSource() == mission4) {
				mission.setText(((Mission4) m[3]).stringCheck(4));
				checkAndexit.addActionListener(new Check(4));				
			} else if (event.getSource() == mission5) {
				mission.setText(((Mission5) m[4]).stringCheck(5));
				checkAndexit.addActionListener(new Check(5));
			}
			
			//and show mission text
			try{
				container.remove(window);
				container.add(checkmission);
			}
			catch(NullPointerException e)
			{
				e.printStackTrace();
			}
		}
	}

}
