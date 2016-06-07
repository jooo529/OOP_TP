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

	public checkFrame() {
		// set frame's state
		this.setSize(700, 350);
		this.setTitle("Check Mission");
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(LoginFrame.DISPOSE_ON_CLOSE);

		// entire window's size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		//// locate frame in center
		int xPos = screenSize.width / 2 - this.getSize().width / 2;
		int yPos = screenSize.height / 2 - this.getSize().height / 2;

		this.setLocation(xPos, yPos);

		this.go_cf();
	}

	private Container container; // Frame

	private ImageIcon npcf; // Mom NPC's image
	private ImageIcon tb; // Mom's comment

	private JPanel window; // It's MISSION 1~5 <- button
	private JPanel checkmission; // if you click one of window's button, show
									// this panel.
	private JPanel npc_face;
	private JTextArea mission; // text of mission checking
	private JButton checkAndexit; // check and exit

	private Font font2 = new Font("Kristen ITC", Font.BOLD, 14);
	private Font font = new Font("Kristen ITC", Font.BOLD, 20); // 30글자 크기

	private JButton mission1, mission2, mission3, mission4, mission5;
	private JLabel label1, label2, label3, label4, label5;

	private Border missionBorder;
	private Border emptyBorder;

	private UserFile f = new UserFile();
	static int idx = -1;
	static Mission[] m = new Mission[5];

	void go_cf() {

		try {
			for (int i = 0; i < UserFile.Users.size(); i++) {
				if (UserFile.Users.get(i).getIndex() > -1) // throw exception
					idx = i;
			} // id (who's?)
		}

		catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}

		container = this.getContentPane(); // Frame
		container.setLayout(null); // No layout manager

		window = new JPanel();
		window.setLayout(new GridLayout(5, 1, 0, 0)); // 5button will be in here

		npcf = new ImageIcon("mom.PNG"); // mom's image
		tb = new ImageIcon("textBallon_checkm.png"); // what does my mom say

		npc_face = new JPanel() { // in this panel - mom's face
			public void paintComponent(Graphics g) {
				g.drawImage(npcf.getImage(), 3, 0, null);
				g.drawImage(tb.getImage(), 180, 30, null); // - and what does
															// mom say
			}
		};
		;

		npc_face.setLayout(null); // set mom's face panel no layout manager.

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

		mission1.add(label1);
		mission2.add(label2);
		mission3.add(label3);
		mission4.add(label4);
		mission5.add(label5);

		// make button finish--

		// add buttons in window!
		try {
			window.add(mission1);
			window.add(mission2);
			window.add(mission3);
			window.add(mission4);
			window.add(mission5);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		checkAndexit = new JButton("Ok! Thank you!");// check and exit
		checkmission = new JPanel(); // check mission!
		checkmission.setLayout(null);

		window.setBounds(0, 0, 390, 310);
		npc_face.setBounds(390, 0, 300, 350);
		checkAndexit.setBounds(130, 270, 130, 30);
		checkmission.setBounds(0, 0, 390, 310);

		mission = new JTextArea();
		mission.setLineWrap(true); // wrap line to not over block
		mission.setBounds(20, 10, 350, 250);
		mission.setFont(font2);

		try {
			container.add(window);
			container.add(npc_face);
			checkmission.add(mission);
			checkmission.add(checkAndexit);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		missionBorder = BorderFactory.createLineBorder(Color.black, 3);
		emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);

		mission.setBorder(BorderFactory.createCompoundBorder(missionBorder, emptyBorder));
		// reference -- Make textArea's Border ->
		// http://blog.naver.com/timberx/30111890732

	}

	class Check implements ActionListener { // check mission
		int k;

		public Check(int i) { // id
			k = i;
		}

		public void actionPerformed(ActionEvent event) {
			try {
				if (UserFile.Users.get(idx).getMissionNum() != k) { // 진행하고있는 미션을 선택하지 않았을때
					JOptionPane.showMessageDialog(null, "FAULT!nYou aren't in mission " + k + "! You lose 500Money:(",
							"Message", JOptionPane.INFORMATION_MESSAGE);
					UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney() - 500);
					f.fileSave();
				} else checkMission();
			} catch (IndexOutOfBoundsException e) {
				e.printStackTrace();
			}

			setVisible(false);
		}
	}

	class mission_b_listener implements ActionListener { //
		public void actionPerformed(ActionEvent event) {

			m[0] = new Mission1(); // Mission 1 class
			m[1] = new Mission2(); // Mission 2 class
			m[2] = new Mission3(); // Mission 3 class
			m[3] = new Mission4(); // Mission 4 class
			m[4] = new Mission5(); // Mission 5 class

			window.setVisible(false);

			// bring mission text
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

			// and show mission text
			try {
				container.remove(window);
				container.add(checkmission);
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		}
	}

	public void checkMission() {
		String[] doMission = UserFile.Users.get(idx).getDoMission();
		Boolean success = false; 
		if(doMission[0].equals("1")){
			int num = Integer.parseInt(doMission[1]);
			success = m[0].checkMission(idx,num,doMission[2]);
			if(success){
				UserFile.Users.get(idx).setMissionNum(0);
				if(UserFile.Users.get(idx).getLevel()==1) ClearMission(2);
					else aboveClearMission();
			}else notClearMission();
		}else if(doMission[0].equals("2")){
			int num = Integer.parseInt(doMission[1]);
			success = ((Mission2)m[1]).checkMission(idx,Integer.parseInt(doMission[1]),Integer.parseInt(doMission[2]),
					Integer.parseInt(doMission[3]),Integer.parseInt(doMission[4]));
			if(success){
				UserFile.Users.get(idx).setMissionNum(0);
				if(UserFile.Users.get(idx).getLevel()==2) ClearMission(3);
					else aboveClearMission();
			}else notClearMission();			
		}else if(doMission[0].equals("3")){
			success = ((Mission3)m[2]).checkMission(idx,Integer.parseInt(doMission[1]),Integer.parseInt(doMission[2]),
					Integer.parseInt(doMission[3]),Integer.parseInt(doMission[4]));
			if(success){
				UserFile.Users.get(idx).setMissionNum(0);
				if(UserFile.Users.get(idx).getLevel()==3) ClearMission(4);
					else aboveClearMission();
			}else notClearMission();
		}else if(doMission[0].equals("4")){
			int num = Integer.parseInt(doMission[1]);
			success = m[3].checkMission(idx,num,doMission[2]);
			if(success){
				UserFile.Users.get(idx).setMissionNum(0);
				UserFile.Users.get(idx).setAppleJuice(0);
				UserFile.Users.get(idx).setGrapeJuice(0);
				UserFile.Users.get(idx).setOrangeJuice(0);
				UserFile.Users.get(idx).setStrawberryJuice(0);
				if(UserFile.Users.get(idx).getLevel()==4) ClearMission(5);
					else aboveClearMission();
			}else notClearMission();
		}else if(doMission[0].equals("5")){
			int num = Integer.parseInt(doMission[1]);
			success = m[4].checkMission(idx,num,doMission[2]);
			if(success){
				UserFile.Users.get(idx).setMissionNum(0);
				UserFile.Users.get(idx).setConsumerBox(null);
				if(UserFile.Users.get(idx).getLevel()==5){
					JOptionPane.showMessageDialog(null, "You clear Mission perfectly!\nYou earn 1000 Money:)","Message", JOptionPane.INFORMATION_MESSAGE);
					UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney() + 1000);
				}else aboveClearMission();
			}else {
				notClearMission();
				UserFile.Users.get(idx).setConsumerBox(null);
			}
		}
		f.fileSave();
	}

	private void ClearMission(int nextlvl) {
		JOptionPane.showMessageDialog(null, "Level Up! You clear Mission perfectly!\nYou earn 1000 Money:)","Message", JOptionPane.INFORMATION_MESSAGE);
		UserFile.Users.get(idx).setLevel(nextlvl);
		UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney() + 1000);
	}

	private void aboveClearMission() {
		JOptionPane.showMessageDialog(null, "You clear Mission perfectly!\nYou earn 300 Money:)","Message", JOptionPane.INFORMATION_MESSAGE);
		UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney() + 300);
	}

	private void notClearMission() {
		JOptionPane.showMessageDialog(null, "You don't clear Mission yet!\nYou lose 500 Money:(\nYour Mission:"
				+UserFile.Users.get(idx).getMission(),"Message", JOptionPane.INFORMATION_MESSAGE);
		UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney() - 500);
	}

}
