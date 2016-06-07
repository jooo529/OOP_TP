import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

import java.util.Timer;
import java.util.TimerTask;
//asdasdsad
public class FarmingFrame extends GameFrame {

	public FarmingFrame() {
		go_farming();
	}
	ImageIcon[] im;
	JButton[] ary;
	Container container;
	JList<String> list;
	JPanel fruitpanel;
	JLabel userAPPLE_label, userGRAPE_label, userORANGE_label, userSTRAWBERRY_label;

	ImageIcon i1 = new ImageIcon("first.png");
	ImageIcon i2 = new ImageIcon("Second.png");
	ImageIcon i3_APPLE = new ImageIcon("apple.png");
	ImageIcon i3_GRAPE = new ImageIcon("grape_jy.png");
	ImageIcon i3_ORANGE = new ImageIcon("orange_jy.png");
	ImageIcon i3_STRAWBERRY = new ImageIcon("strawberry_jy.png");
	ImageIcon i3;
	ImageIcon i4_APPLE = new ImageIcon("appleRotten.png");
	ImageIcon i4_GRAPE = new ImageIcon("grapeRotten_jy.png");
	ImageIcon i4_ORANGE = new ImageIcon("orangeRotten_jy.png");
	ImageIcon i4_STRAWBERRY = new ImageIcon("strawberryRotten_jy.png");
	ImageIcon i4;

	static int fruitNum = 0;
	
	public void go_farming() { // 선택받은 과일이 입력받은 갯수만큼 나타나는거 구현하기

		JPanel menupanel;
		
		container = this.getContentPane();
		container.setLayout(new BorderLayout());
		
		getUserIdx();
		
		menupanel = userImfoPane(1);
		
		container.add(BorderLayout.NORTH, menupanel);

	
		String which = UserFile.Users.get(idx).getFruit();

		if (which == "Grape") {
			i3 = i3_GRAPE;
			i4 = i4_GRAPE;
		} else if (which == "Apple") {
			i3 = i3_APPLE;
			i4 = i4_APPLE;
		} else if (which == "Orange") {
			i3 = i3_ORANGE;
			i4 = i4_ORANGE;
		} else if (which == "Strawberry") {
			i3 = i3_STRAWBERRY;
			i4 = i4_STRAWBERRY;
		}

		fruitpanel = new JPanel();
		fruitpanel.setLayout(new GridLayout(3, 3));

		container.add(BorderLayout.CENTER, fruitpanel);

		ary = new JButton[9];
		im = new ImageIcon[9];

		// ---------------------------------------------------------------------
		im[0] = i1;
		ary[0] = new JButton() {
			public void paintComponent(Graphics g) {
				g.drawImage(im[0].getImage(), 0, 0, null);
			}
		};

		im[1] = i1;
		ary[1] = new JButton() {
			public void paintComponent(Graphics g) {
				g.drawImage(im[1].getImage(), 0, 0, null);
			}
		};

		im[2] = i1;
		ary[2] = new JButton() {
			public void paintComponent(Graphics g) {
				g.drawImage(im[2].getImage(), 0, 0, null);
			}
		};
		im[3] = i1;
		ary[3] = new JButton() {
			public void paintComponent(Graphics g) {
				g.drawImage(im[3].getImage(), 0, 0, null);
			}
		};
		im[4] = i1;
		ary[4] = new JButton() {
			public void paintComponent(Graphics g) {
				g.drawImage(im[4].getImage(), 0, 0, null);
			}
		};
		im[5] = i1;
		ary[5] = new JButton() {
			public void paintComponent(Graphics g) {
				g.drawImage(im[5].getImage(), 0, 0, null);
			}
		};
		im[6] = i1;
		ary[6] = new JButton() {
			public void paintComponent(Graphics g) {
				g.drawImage(im[6].getImage(), 0, 0, null);
			}
		};
		im[7] = i1;
		ary[7] = new JButton() {
			public void paintComponent(Graphics g) {
				g.drawImage(im[7].getImage(), 0, 0, null);
			}
		};
		im[8] = i1;
		ary[8] = new JButton() {
			public void paintComponent(Graphics g) {
				g.drawImage(im[8].getImage(), 0, 0, null);
			}
		};
		// ------------------------------------------------------------------------------

		for (int k = 0; k < 9; k++) {
			ary[k].addActionListener(new reset(k));
			fruitpanel.add(ary[k]);
		}

		JButton backbtn = new JButton("Quit Farming");
		backbtn.addActionListener(new quit_listener());

		container.add(BorderLayout.SOUTH, backbtn);

		loop lp = new loop();
		lp.go();
	}
	
	class quit_listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			setVisible(false);
			JOptionPane.showMessageDialog(null, "You got "+fruitNum+" "+UserFile.Users.get(idx).getFruit()+"!", "Message", JOptionPane.INFORMATION_MESSAGE);
			UserFile.Users.get(idx).setFruit(null);
			fruitNum=0;
			f.fileSave();
			
		}
	}

	class btn_game extends TimerTask {
		int k;

		public void setK(int set) {
			k = set;
		}

		public void run() {
			im[k] = i2;
			fruitpanel.repaint();

			Timer tmr = new Timer();
			changeto3 ct3 = new changeto3();
			ct3.setK(k);

			int temp = (int) (Math.random() * 10 + 2) * 1000;
			tmr.schedule(ct3, temp);

		}

	}

	class changeto3 extends TimerTask {
		int k;

		public void setK(int set) {
			k = set;
		}

		public void run() {
			im[k] = i3;
			fruitpanel.repaint();

			Timer tmr = new Timer();
			rotten rot = new rotten();
			rot.setK(k);

			tmr.schedule(rot, 8000);
		}

	}

	class rotten extends TimerTask {
		int k;

		public void setK(int set) {
			k = set;
		}

		public void run() {
			if (im[k] == i3) {
				im[k] = i4;
				fruitpanel.repaint();
			}
		}
	}

	class loop {

		public void go() {
			int[] randtime = new int[9];

			randtime[0] = (int) (Math.random() * 10 + 2) * 1000;
			randtime[1] = (int) (Math.random() * 10 + 2) * 1000;
			randtime[2] = (int) (Math.random() * 10 + 2) * 1000;
			randtime[3] = (int) (Math.random() * 10 + 2) * 1000;
			randtime[4] = (int) (Math.random() * 10 + 2) * 1000;
			randtime[5] = (int) (Math.random() * 10 + 2) * 1000;
			randtime[6] = (int) (Math.random() * 10 + 2) * 1000;
			randtime[7] = (int) (Math.random() * 10 + 2) * 1000;
			randtime[8] = (int) (Math.random() * 10 + 2) * 1000;

			btn_game sch1 = new btn_game();
			btn_game sch2 = new btn_game();
			btn_game sch3 = new btn_game();
			btn_game sch4 = new btn_game();
			btn_game sch5 = new btn_game();
			btn_game sch6 = new btn_game();
			btn_game sch7 = new btn_game();
			btn_game sch8 = new btn_game();
			btn_game sch9 = new btn_game();

			Timer tm = new Timer();

			sch1.setK(0);
			tm.schedule(sch1, randtime[0]);
			sch2.setK(1);
			tm.schedule(sch2, randtime[1]);
			sch3.setK(2);
			tm.schedule(sch3, randtime[2]);
			sch4.setK(3);
			tm.schedule(sch4, randtime[3]);
			sch5.setK(4);
			tm.schedule(sch5, randtime[4]);
			sch6.setK(5);
			tm.schedule(sch6, randtime[5]);
			sch7.setK(6);
			tm.schedule(sch7, randtime[6]);
			sch8.setK(7);
			tm.schedule(sch8, randtime[7]);
			sch9.setK(8);
			tm.schedule(sch9, randtime[8]);

		}

	}

	class reset implements ActionListener {
		int k;

		public reset(int i) {
			k = i;
		}

		public void actionPerformed(ActionEvent e) {
			if (im[k] == i3_APPLE){
				UserFile.Users.get(idx).setApple(UserFile.Users.get(idx).getApple() + 1);
				fruitNum++;
			}else if (im[k] == i3_GRAPE){
				UserFile.Users.get(idx).setGrape(UserFile.Users.get(idx).getGrape() + 1);
				fruitNum++;
			}else if (im[k] == i3_ORANGE){
				UserFile.Users.get(idx).setOrange(UserFile.Users.get(idx).getOrange() + 1);
				fruitNum++;
			}else if (im[k] == i3_STRAWBERRY){
				UserFile.Users.get(idx).setStrawBerry(UserFile.Users.get(idx).getStrawBerry() + 1);
				fruitNum++;
			}// ------------ Increase Fruit Variable

			else if (im[k] == i4_APPLE && UserFile.Users.get(idx).getApple() > 0){
				UserFile.Users.get(idx).setApple(UserFile.Users.get(idx).getApple() - 1);
				fruitNum--;
			}else if (im[k] == i4_GRAPE && UserFile.Users.get(idx).getGrape() > 0){
				UserFile.Users.get(idx).setGrape(UserFile.Users.get(idx).getGrape() - 1);
				fruitNum--;
			}else if (im[k] == i4_ORANGE && UserFile.Users.get(idx).getOrange() > 0){
				UserFile.Users.get(idx).setOrange(UserFile.Users.get(idx).getOrange() - 1);
				fruitNum--;
			}else if (im[k] == i4_STRAWBERRY && UserFile.Users.get(idx).getStrawBerry() > 0){
				UserFile.Users.get(idx).setStrawBerry(UserFile.Users.get(idx).getStrawBerry() - 1);
				fruitNum--;
			}
			changeImfo(1);
			
			
			if (im[k] == i3 || im[k] == i4) {
				im[k] = i1;
				int randtime = (int) (Math.random() * 10 + 2) * 1000;
				btn_game sch = new btn_game();
				Timer tm = new Timer();
				sch.setK(k);
				tm.schedule(sch, randtime);
			}
		}
	}

}
