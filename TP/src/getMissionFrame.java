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
		go_getm();
	}
	ArrayList<String> fruit = new ArrayList<String>();
	Random random = new Random();
	UserFile uf = new UserFile();
	static int idx = -1;
	private Container container;
	private ImageIcon npcf;
	private ImageIcon tb;
	private JPanel window;
	private JPanel getmission;
	private JTextArea mission;
	private JButton getAndexit;

	private JButton mission1;
	private JButton mission2;
	private JButton mission3;
	private JButton mission4;
	private JButton mission5;
	Font font = new Font("Kristen ITC", Font.BOLD, 20); // 30글자 크기
	Font font2 = new Font("Kristen ITC", Font.BOLD, 14);

	void go_getm() {
		
		fruit.add("apple");

		fruit.add("grape");

		fruit.add("orange");
		
		fruit.add("strawberry");
		
        for(int i=0; i<UserFile.Users.size(); i++){
			if(UserFile.Users.get(i).getIndex()>-1) idx = i;
		}
		container = this.getContentPane();
		container.setLayout(null);

		window = new JPanel();// 여기에 대화창패널 ->그리드...?
		window.setBackground(Color.GRAY);
		window.setLayout(new GridLayout(5, 1, 0, 0));
		npcf = new ImageIcon("mom.PNG");
		tb = new ImageIcon("textBallon_getm.png");
		JPanel npc_face = new JPanel() { // 엔피씨 얼굴나오게 할 패널
			public void paintComponent(Graphics g) {
				g.drawImage(npcf.getImage(), 3, 0, null);
				g.drawImage(tb.getImage(), 180, 30, null);
			}
		};
		npc_face.setLayout(null);

		mission1 = new JButton();
		mission1.setIcon(new ImageIcon("mission_b.png"));
		mission1.addActionListener(new mission_b_listener());
		mission1.setRolloverIcon(new ImageIcon(""));
		JLabel label1 = new JLabel("            M  i  s  s  i  o  n  1  ");
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

		mission1.setEnabled(false);
		mission2.setEnabled(false);
		mission3.setEnabled(false);
		mission4.setEnabled(false);
		mission5.setEnabled(false);
		
		if(UserFile.Users.get(idx).getLevel()==1) mission1.setEnabled(true);
		else if(UserFile.Users.get(idx).getLevel()==2) mission2.setEnabled(true);
		else if(UserFile.Users.get(idx).getLevel()==3) mission3.setEnabled(true);
		else if(UserFile.Users.get(idx).getLevel()==4) mission4.setEnabled(true);
		else if(UserFile.Users.get(idx).getLevel()==5) mission5.setEnabled(true);
		
		window.add(mission1);
		window.add(mission2);
		window.add(mission3);
		window.add(mission4);
		window.add(mission5);

		window.setBounds(0, 0, 390, 310);

		npc_face.setBounds(390, 0, 300, 350);

		container.add(window);
		container.add(npc_face);

		getmission = new JPanel();
		getmission.setLayout(null);

		getAndexit = new JButton("Ok I got it!");
		getAndexit.addActionListener(new goback_listener());
		getAndexit.setBounds(150, 270, 90, 30);
		getmission.add(getAndexit);

		mission = new JTextArea();
		mission.setLineWrap(true);
		mission.setBounds(20, 10, 350, 250);
		getmission.add(mission);

		Border missionBorder = BorderFactory.createLineBorder(Color.black, 3);
		Border emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);
		mission.setBorder(BorderFactory.createCompoundBorder(missionBorder, emptyBorder));

		// Make textArea's Border -> http://blog.naver.com/timberx/30111890732 -
		// reference

	}
	////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////

	class goback_listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			setVisible(false);
		}
	}

	// 여기서 미션때 이용될 클래스와 연계해서 코드가 있어야될듯
	// 랜덤하게 뭔가 사오라고 해야되는데....
	// 랜덤으로 뭘 어캐 할지 text 추가 밑 변수 처리
	class mission_b_listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			int randomFruitnum = (int)(Math.random()*5+1);
			
			int randomConsumer = (int)(Math.random()*5+3);
			int randomFruittype = (int)random.nextInt(fruit.size());

			
			mission.setFont(font2);
			getmission.setBounds(0, 0, 390, 340);
			window.setVisible(false);
			container.remove(window);

			if (event.getSource() == mission1) {
				mission.setText("<Mission 1>" + "\nYou have to buy following fruitbox!"
						+ "\n\nGo to the Store and Buy following box." + "\n_________________________________________"
								+ "\n\nGet "+ randomFruitnum +"  "+fruit.get(randomFruittype)+" Box");
				container.add(getmission);
			} else if (event.getSource() == mission2) {
				mission.setText("<Mission 2>" + "\nYou have to go to Farm and get following fruit!"
						+ "\nGo to Farm and get followng fruits." + "\n_________________________________________"
								+ "\n\nGet"+ randomFruitnum +"  "+fruit.get(randomFruittype));
				container.add(getmission);
			} else if (event.getSource() == mission3) {
				mission.setText("<Mission 3>" + "\nPut your all fruits in refrigerator!"
						+ "\nRefrigerator is located in Store." + "\n_________________________________________"
								+ "\n\nNow you have ---여기에 현 과일개수 출력해주기---\n\n put them in refrigerator!");
				container.add(getmission);
			} else if (event.getSource() == mission4) {
				mission.setText("<Mission 4>" + "\nYou have to make some fruit juice!"
						+ "\nGo to store and take following fruits" + "\nout of refrigerator."
						+ "\nThen read recipe of Juice" + "\nand make following fruit's juice"
						+ "\n_________________________________________"
						+ "\n\nJust make one " + fruit.get(randomFruittype)+"juice and give it to me!");
				container.add(getmission);
			} else if (event.getSource() == mission5) {
				mission.setText("<Mission 5>" + "\nYou have to go to Store and sell juice!"
						+ "\nIn Store, some consumers will be there." + "\nThey want your fruit juice!"
						+ "\nSell them some juice!" + "\n_________________________________________"
								+ "\n\nThere are "+randomConsumer+" cunsumers in store!"
										+ "\nSell juices for all of them!");
				container.add(getmission);
			}
		}
	}

}
