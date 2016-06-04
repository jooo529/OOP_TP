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
		go_cf();
	}

	private Container container;

	private ImageIcon npcf;
	private ImageIcon tb;
	private JPanel window;
	private JPanel checkmission;
	private JTextArea mission;
	private JButton checkAndexit;
	Font font2 = new Font("Kristen ITC", Font.BOLD, 14);

	JButton mission1;
	JButton mission2;
	JButton mission3;
	JButton mission4;
	JButton mission5;
	Font font = new Font("Kristen ITC", Font.BOLD, 20); // 30글자 크기
	
	UserFile f = new UserFile();
	static int idx = -1;
	
	void go_cf() {

		for (int i = 0; i < UserFile.Users.size(); i++) {
			if (UserFile.Users.get(i).getIndex() > -1)
				idx = i;
		}
		
		Font font_italic = new Font("Serif", Font.ITALIC + Font.BOLD, 14);
		container = this.getContentPane();
		container.setLayout(null);

		window = new JPanel();// 여기에 대화창패널 ->그리드...?
		window.setBackground(Color.GRAY);
		window.setLayout(new GridLayout(5, 1, 0, 0));

		npcf = new ImageIcon("mom.PNG");
		tb = new ImageIcon("textBallon_checkm.png");
		JPanel npc_face = new JPanel() { // 엔피씨 얼굴나오게 할 패널
			public void paintComponent(Graphics g) {
				g.drawImage(npcf.getImage(), 3, 0, null);
				g.drawImage(tb.getImage(), 180, 30, null);
			}
		};
		;
		npc_face.setLayout(null);

		mission1 = new JButton();
		mission1.setIcon(new ImageIcon("mission_b.png"));
		mission1.addActionListener(new mission_b_listener());
		JLabel label1 = new JLabel("            M  i  s  s  i  o  n  1  ");
		mission1.setRolloverIcon(new ImageIcon(""));
		label1.setFont(font);
		mission1.add(label1);

		mission2 = new JButton();
		mission2.setIcon(new ImageIcon("mission_b.png"));
		mission2.addActionListener(new mission_b_listener());
		mission2.setRolloverIcon(new ImageIcon(""));
		JLabel label2 = new JLabel("            M  i  s  s  i  o  n  2  ");
		label2.setFont(font);
		mission2.add(label2);

		mission3 = new JButton();
		mission3.setIcon(new ImageIcon("mission_b.png"));
		mission3.addActionListener(new mission_b_listener());
		mission3.setRolloverIcon(new ImageIcon(""));
		JLabel label3 = new JLabel("            M  i  s  s  i  o  n  3  ");
		label3.setFont(font);
		mission3.add(label3);

		mission4 = new JButton();
		mission4.setIcon(new ImageIcon("mission_b.png"));
		mission4.addActionListener(new mission_b_listener());
		mission4.setRolloverIcon(new ImageIcon(""));
		JLabel label4 = new JLabel("            M  i  s  s  i  o  n  4  ");
		label4.setFont(font);
		mission4.add(label4);

		mission5 = new JButton();
		mission5.setIcon(new ImageIcon("mission_b.png"));
		mission5.addActionListener(new mission_b_listener());
		mission5.setRolloverIcon(new ImageIcon(""));
		JLabel label5 = new JLabel("            M  i  s  s  i  o  n  5  ");
		label5.setFont(font);
		mission5.add(label5);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5, 1, 0, 0));
		buttonPanel.add(mission1);
		buttonPanel.add(mission2);
		buttonPanel.add(mission3);
		buttonPanel.add(mission4);
		buttonPanel.add(mission5);

		window.add(mission1);
		window.add(mission2);
		window.add(mission3);
		window.add(mission4);
		window.add(mission5);

		window.setBounds(0, 0, 390, 310);
		npc_face.setBounds(390, 0, 300, 350);

		container.add(window);
		container.add(npc_face);

		checkmission = new JPanel();
		checkmission.setLayout(null);

		checkAndexit = new JButton("Ok! Thank you!");
		checkAndexit.setBounds(130, 270, 130, 30);
		checkmission.add(checkAndexit);

		mission = new JTextArea();
		mission.setLineWrap(true);
		mission.setBounds(20, 10, 350, 250);
		checkmission.add(mission);

		Border missionBorder = BorderFactory.createLineBorder(Color.black, 3);
		Border emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);
		mission.setBorder(BorderFactory.createCompoundBorder(missionBorder, emptyBorder));

		// Make textArea's Border -> http://blog.naver.com/timberx/30111890732 -
		// reference

	}

	class Check implements ActionListener {
		int k;
		public Check(int i){
			k=i;
		}
		public void actionPerformed(ActionEvent event) {
			if(UserFile.Users.get(idx).getLevel()!=k){
				JOptionPane.showMessageDialog(null, "FAULT! You aren't in level "+k+"! You lose 500Money:(", "Message", JOptionPane.INFORMATION_MESSAGE);
				UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney()-500);
				f.fileSave();
			}else {
				System.out.println("!!");
			}
			setVisible(false);
		}
	}

	class mission_b_listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			checkmission.setBounds(0, 0, 390, 310);
			window.setVisible(false);
			container.remove(window);
			mission.setFont(font2);
			
			if (event.getSource() == mission1) {
				mission.setText("Welcome! I'll check your mission." + "\nYou got <Mission 1>. right?"
						+ "\n_________________________________________");
				container.add(checkmission);
				checkAndexit.addActionListener(new Check(1));				
			} else if (event.getSource() == mission2) {
				mission.setText("Welcome! I'll check your mission." + "\nYou got <Mission 2>. right?"
						+ "\n_________________________________________");
				container.add(checkmission);
				checkAndexit.addActionListener(new Check(2));				
			} else if (event.getSource() == mission3) {
				mission.setText("Welcome! I'll check your mission." + "\nYou got <Mission 3>. right?"
						+ "\n_________________________________________");
				container.add(checkmission);
				checkAndexit.addActionListener(new Check(3));				
			} else if (event.getSource() == mission4) {
				mission.setText("Welcome! I'll check your mission." + "\nYou got <Mission 4>. right?"
						+ "\n_________________________________________");
				container.add(checkmission);
				checkAndexit.addActionListener(new Check(4));				
			} else if (event.getSource() == mission5) {
				mission.setText("Welcome! I'll check your mission." + "\nYou got <Mission 5>. right?"
						+ "\n_________________________________________");
				container.add(checkmission);
				checkAndexit.addActionListener(new Check(5));
			}
		}
	}

}
