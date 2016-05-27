import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import java.util.Timer;
import java.util.TimerTask;

public class FarmingFrame extends JFrame {

	public FarmingFrame() {
		go_farming();
	}

	ImageIcon[] im;
	JButton[] ary;
	Container container;
	JList<String> list;
	static int i;
	JPanel fruitpanel;

	ImageIcon i1 = new ImageIcon("first.png");
	ImageIcon i2 = new ImageIcon("Second.png");
	ImageIcon i3 = new ImageIcon("third.png");
	ImageIcon i4 = new ImageIcon("fourth.png");

	public void go_farming() { // 선택받은 과일이 입력받은 갯수만큼 나타나는거 구현하기

		container = this.getContentPane();
		container.setLayout(new BorderLayout());

		JPanel menupanel = new JPanel();

		container.add(BorderLayout.NORTH, menupanel);

		User u = new User();
		Font font = new Font("Dialog", Font.BOLD, 15); // 20은 글자 크기

		JLabel userID_label = new JLabel("U s e r   :   " + u.getId());
		userID_label.setFont(font);

		JLabel userMONEY_label = new JLabel("           M o n e y   :   " + u.getMoney());
		userMONEY_label.setFont(font);

		JLabel userLEVEL_label = new JLabel("           L e v e l   :   " + u.getLevel());
		userLEVEL_label.setFont(font);

		JLabel enter = new JLabel("                      ");

		menupanel.add(userID_label);
		menupanel.add(userLEVEL_label);
		menupanel.add(userMONEY_label);
		menupanel.add(enter);

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

		ary[0].addActionListener(new reset1());
		ary[1].addActionListener(new reset2());
		ary[2].addActionListener(new reset3());
		ary[3].addActionListener(new reset4());
		ary[4].addActionListener(new reset5());
		ary[5].addActionListener(new reset6());
		ary[6].addActionListener(new reset7());
		ary[7].addActionListener(new reset8());
		ary[8].addActionListener(new reset9());

		for (int k = 0; k < 9; k++) {
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
			
			tmr.schedule(rot,8000);
		}

	}

	class rotten extends TimerTask{
		int k;
		
		public void setK(int set){
			k = set;
		}
		
		public void run(){
			if(im[k]==i3){
				im[k]= i4;
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

	class reset1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (im[0] == i3) {
				im[0] = i1;
				int randtime = (int) (Math.random() * 10 + 2) * 1000;
				btn_game sch = new btn_game();
				Timer tm = new Timer();
				sch.setK(0);
				tm.schedule(sch, randtime);
			}
		}
	}

	class reset2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (im[1] == i3) {
				im[1] = i1;
				int randtime = (int) (Math.random() * 10 + 2) * 1000;
				btn_game sch = new btn_game();
				Timer tm = new Timer();
				sch.setK(1);
				tm.schedule(sch, randtime);
			}
		}
	}

	class reset3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (im[2] == i3) {
				im[2] = i1;
				int randtime = (int) (Math.random() * 10 + 2) * 1000;
				btn_game sch = new btn_game();
				Timer tm = new Timer();
				sch.setK(2);
				tm.schedule(sch, randtime);
			}
		}
	}

	class reset4 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (im[3] == i3) {
				im[3] = i1;
				int randtime = (int) (Math.random() * 10 + 2) * 1000;
				btn_game sch = new btn_game();
				Timer tm = new Timer();
				sch.setK(3);
				tm.schedule(sch, randtime);
			}
		}
	}

	class reset5 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (im[4] == i3) {
				im[4] = i1;
				int randtime = (int) (Math.random() * 10 + 2) * 1000;
				btn_game sch = new btn_game();
				Timer tm = new Timer();
				sch.setK(4);
				tm.schedule(sch, randtime);
			}
		}
	}

	class reset6 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (im[5] == i3) {
				im[5] = i1;
				int randtime = (int) (Math.random() * 10 + 2) * 1000;
				btn_game sch = new btn_game();
				Timer tm = new Timer();
				sch.setK(5);
				tm.schedule(sch, randtime);
			}
		}
	}

	class reset7 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (im[6] == i3) {
				im[6] = i1;
				int randtime = (int) (Math.random() * 10 + 2) * 1000;
				btn_game sch = new btn_game();
				Timer tm = new Timer();
				sch.setK(6);
				tm.schedule(sch, randtime);
			}
		}
	}

	class reset8 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (im[7] == i3) {
				im[7] = i1;
				int randtime = (int) (Math.random() * 10 + 2) * 1000;
				btn_game sch = new btn_game();
				Timer tm = new Timer();
				sch.setK(7);
				tm.schedule(sch, randtime);
			}
		}
	}

	class reset9 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (im[8] == i3) {
				im[8] = i1;
				int randtime = (int) (Math.random() * 10 + 2) * 1000;
				btn_game sch = new btn_game();
				Timer tm = new Timer();
				sch.setK(8);
				tm.schedule(sch, randtime);
			}
		}
	}
}
