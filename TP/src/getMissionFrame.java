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

import java.util.ArrayList;
import java.util.Random;

public class getMissionFrame extends JFrame {

	public getMissionFrame() {
		//set frame's state
		this.setSize(700,350);
		this.setTitle("Get Mission");
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(LoginFrame.DISPOSE_ON_CLOSE);
		
		//entire window's size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		//locate frame in center
		int xPos = screenSize.width/2 - this.getSize().width/2 ;
		int yPos = screenSize.height/2 - this.getSize().height/2 ;

		this.setLocation(xPos,yPos);
		this.go_getm();
	}
	static int idx = -1;
	static Mission[] m = new Mission[5];
	
	private UserFile f = new UserFile();

	private Container container; //frame
	
	private ImageIcon npcf; //mom's face
	private ImageIcon tb; //what does mom say
	
	private JPanel window;
	private JPanel getmission;
	
	private JTextArea mission; //what is mission?
	
	private JButton getAndexit; //get mission and exit

	private JButton mission1; //mission button 1~5
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
	
	private Font font = new Font("Kristen ITC", Font.BOLD, 20); 
	private Font font2 = new Font("Kristen ITC", Font.BOLD, 14);

	
	void go_getm() {

		//who's id
		try{
			for (int i = 0; i < UserFile.Users.size(); i++) {
				if (UserFile.Users.get(i).getIndex() > -1) //who's id
					idx = i;
			}
		}
		catch(IndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}
		
		container = this.getContentPane();//frame
		container.setLayout(null);

		window = new JPanel();
		window.setBackground(Color.GRAY);
		window.setLayout(new GridLayout(5, 1, 0, 0)); // button will be in window
		window.setBounds(0, 0, 390, 310);
		
		npcf = new ImageIcon("mom.PNG"); //mom's face
		tb = new ImageIcon("textBallon_getm.png"); //what does mom say
		
		JPanel npc_face = new JPanel() { // mom's face panel
			public void paintComponent(Graphics g) {
				g.drawImage(npcf.getImage(), 3, 0, null);
				g.drawImage(tb.getImage(), 180, 30, null);
			}
		};
		npc_face.setBounds(390, 0, 300, 350);
		npc_face.setLayout(null);
		
//make button
		mission1 = new JButton();
		mission1.setIcon(new ImageIcon("mission_b.png"));
		mission1.addActionListener(new mission_b_listener());
		mission1.setRolloverIcon(new ImageIcon("")); 
		label1 = new JLabel("            M  i  s  s  i  o  n  1  ");
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
		
//make button finish
		

		mission1.setEnabled(false); //if your level is not enough to get mission, you can't click
		mission2.setEnabled(false); //mission button.
		mission3.setEnabled(false);
		mission4.setEnabled(false);
		mission5.setEnabled(false);

		try{ //get your level and make you can click button
			
			switch(UserFile.Users.get(idx).getLevel())
			{ //if your level is 5 -> you can get all mission
		      //                 4 -> 1~4 mission
			  //                 and etc....
			
				case 5:
					mission5.setEnabled(true);
				case 4:
					mission4.setEnabled(true);
				case 3:
					mission3.setEnabled(true);
				case 2:
					mission2.setEnabled(true);
				case 1:
					mission1.setEnabled(true);
				
			}
		}
		catch(IndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}
		
		
		
		try{//add mission button in window
			window.add(mission1);
			window.add(mission2);
			window.add(mission3);
			window.add(mission4);
			window.add(mission5);
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		

		

		

		getmission = new JPanel();
		getmission.setLayout(null);
		getmission.setBounds(0, 0, 390, 340);

		getAndexit = new JButton("Ok I got it!");
		getAndexit.addActionListener(new get_listener());
		getAndexit.setBounds(150, 270, 90, 30);
	

		mission = new JTextArea();
		mission.setLineWrap(true);
		mission.setBounds(20, 10, 350, 250);
		mission.setFont(font2);
		
		
		
		missionBorder = BorderFactory.createLineBorder(Color.black, 3);
		emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);
		
		mission.setBorder(BorderFactory.createCompoundBorder(missionBorder, emptyBorder));
		// reference --  Make textArea's Border -> http://blog.naver.com/timberx/30111890732
		
		try{
			getmission.add(mission);
			getmission.add(getAndexit);
			container.add(window);
			container.add(npc_face);
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		// Make textArea's Border -> http://blog.naver.com/timberx/30111890732 -
		// reference

	}
	////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////

	class get_listener implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			try{
				if(!UserFile.Users.get(idx).isGetMission()){//getMission
					UserFile.Users.get(idx).setGetMission(true);
					UserFile.Users.get(idx).setDoMission(m[UserFile.Users.get(idx).getLevel()-1].savedMission());
					//System.out.println(UserFile.Users.get(idx).toString());
				}else {
					JOptionPane.showMessageDialog(null, "FAULT! You already got the Mission! You lose 300 Money:(", "Message", JOptionPane.INFORMATION_MESSAGE);
					
					UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney()-300);
					f.fileSave();
				}
			}
			catch(IndexOutOfBoundsException e)
			{
				e.printStackTrace();
			}
			catch(HeadlessException e2){
				e2.printStackTrace();
			}
			
			//System.out.println(UserFile.Users.get(idx).toString());
			setVisible(false);
		}
	}

	class mission_b_listener implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {

			m[0] = new Mission1();
			m[1] = new Mission2();
			m[2] = new Mission3();
			m[3] = new Mission4();
			m[4] = new Mission5();

			
			window.setVisible(false);
			

			if (event.getSource() == mission1) {
				mission.setText(m[0].getMission(idx));
			} else if (event.getSource() == mission2) {
				mission.setText(m[1].getMission(idx));
			} else if (event.getSource() == mission3) {
				mission.setText(m[2].getMission(idx));
			} else if (event.getSource() == mission4) {
				mission.setText(m[3].getMission(idx));
			} else if (event.getSource() == mission5) {
				mission.setText(m[4].getMission(idx));
			}
			try{ //remove buttons and show text about mission
				container.remove(window);
				container.add(getmission);
			}
			catch(NullPointerException e)
			{
				e.printStackTrace();
			}
		}
	}

}
