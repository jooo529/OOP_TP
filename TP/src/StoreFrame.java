import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.awt.*;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class StoreFrame extends JFrame {

	private ImageIcon storeIm;
	private int idx;

	private UserFile f = new UserFile();

	private Container container;
	private ImageIcon guest1 = new ImageIcon("guest1.png");
	private ImageIcon guest2 = new ImageIcon("guest2.png");
	private ImageIcon guest3 = new ImageIcon("guest3.png");
	private ImageIcon guest4 = new ImageIcon("guest4.png");

	private JButton go_back = new JButton();
	private JButton juice_button = new JButton("!!!!!");
	private JPanel guestP1, guestP2, guestP3, guestP4;
	JLabel userAPPLE_label, userGRAPE_label, userORANGE_label, userSTRAWBERRY_label, userMONEY_label;

	private int number_apple = 0;
	private int number_orange = 0;
	private int number_straw = 0;
	private int number_grape = 0;
	private int juice_price = 0;
	private int juice_apple = 0;
	private int juice_grape = 0;
	private int juice_straw = 0;
	private int juice_orange = 0;
	
	private int i;

	private ImageIcon exit = new ImageIcon("button_exit_s.png");

	public StoreFrame() {
		go_store();

	}

	public void go_store() {
		/////

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		container = this.getContentPane();

		PopUpMarket refri = new PopUpMarket();

		storeIm = new ImageIcon("Store.png");

		go_back.setContentAreaFilled(false);
		go_back.setDefaultCapable(false);
		go_back.setFocusPainted(false);
		go_back.setOpaque(false);
		go_back.setIcon(new ImageIcon("button_exit.png"));
		go_back.setRolloverIcon(new ImageIcon("button_exit_s.png"));
		go_back.setBackground(null);
		go_back.setBorderPainted(false);
		go_back.addActionListener(new goback_listener());

		juice_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				if(guestP1.isVisible())
					guestP1.setVisible(false);
				else if(guestP2.isVisible())
					guestP2.setVisible(false);
				else if(guestP3.isVisible())
					guestP3.setVisible(false);
				else if(guestP4.isVisible())
					guestP4.setVisible(false);
				else{
					JOptionPane.showMessageDialog(juice_button, "No guest ", "Title", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				JOptionPane.showMessageDialog(juice_button, "Number of fruit \n APPLE: "+juice_apple
						+"\n ORANGE: "+juice_orange
						+"\n GRAPE: "+juice_grape
						+"\n STRAWBERRY: "+juice_straw
						+"\n PRICE: "+juice_price, "JUICE IMFOMATION", JOptionPane.INFORMATION_MESSAGE);
				
				
				UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney() + juice_price);
				
				juice_button.setVisible(false);
			}
		});
		guestP2 = new JPanel() {

			public void paintComponent(Graphics g) {
				g.drawImage(guest2.getImage(), 0, 0, this);
			}
		};

		guestP3 = new JPanel() {

			public void paintComponent(Graphics g) {
				g.drawImage(guest3.getImage(), 0, 0, this);
			}
		};

		guestP4 = new JPanel() {

			public void paintComponent(Graphics g) {
				g.drawImage(guest4.getImage(), 0, 0, this);
			}
		};

		guestP1 = new JPanel() {

			public void paintComponent(Graphics g) {
				g.drawImage(guest1.getImage(), 0, 0, this);
			}
		};

		JPanel back_ground = new JPanel() {

			public void paintComponent(Graphics g) {
				g.drawImage(storeIm.getImage(), 300, 0, this);
			}
		};

		back_ground.setLayout(null);
		container.add(BorderLayout.CENTER, back_ground);

		go_back.setBounds(900, 400, 60, 60);
		refri.setBounds(0, 0, 300, 590);
		juice_button.setBounds(500, 100, 100, 50);
		juice_button.setVisible(false);
		guestP1.setBounds(500, 300, guest1.getIconWidth(), guest1.getIconHeight());
		guestP2.setBounds(500+guest1.getIconWidth(), 300, guest2.getIconWidth(), guest2.getIconHeight());
		guestP3.setBounds(500+guest2.getIconWidth()+guest1.getIconWidth(), 300, guest3.getIconWidth(), guest3.getIconHeight());
		guestP4.setBounds(500+guest3.getIconWidth()+guest2.getIconWidth()+guest1.getIconWidth(), 300, guest4.getIconWidth(), guest4.getIconHeight());
		
		back_ground.add(guestP4);
		back_ground.add(guestP3);
		back_ground.add(guestP2);
		back_ground.add(guestP1);
		back_ground.add(juice_button);
		back_ground.add(go_back);
		back_ground.add(refri);

		JPanel menupanel = new JPanel();

		container.add(BorderLayout.NORTH, menupanel);

		Font font = new Font("Dialog", Font.BOLD, 15); // 20은 글자 크기

		for (int i = 0; i < UserFile.Users.size(); i++) {
			if (UserFile.Users.get(i).getIndex() > 0)
				idx = i;
		}

		JLabel userID_label = new JLabel("U s e r   :   " + UserFile.Users.get(idx).getId());
		userID_label.setFont(font);

		userMONEY_label = new JLabel("           M o n e y   :   " + UserFile.Users.get(idx).getMoney());
		userMONEY_label.setFont(font);

		JLabel userLEVEL_label = new JLabel("           L e v e l   :   " + UserFile.Users.get(idx).getLevel());
		userLEVEL_label.setFont(font);

		userAPPLE_label = new JLabel(" 			A p p l e   :   " + UserFile.Users.get(idx).getApple());
		userAPPLE_label.setFont(font);

		userGRAPE_label = new JLabel(" 			G r a p e   :   " + UserFile.Users.get(idx).getGrape());
		userGRAPE_label.setFont(font);

		userORANGE_label = new JLabel(" 			O r a n g e   :   " + UserFile.Users.get(idx).getOrange());
		userORANGE_label.setFont(font);

		userSTRAWBERRY_label = new JLabel(
				" 			S t r a w b e r r y   :   " + UserFile.Users.get(idx).getStrawBerry());
		userSTRAWBERRY_label.setFont(font);

		menupanel.add(userID_label);
		menupanel.add(userLEVEL_label);
		menupanel.add(userMONEY_label);
		menupanel.add(userAPPLE_label);
		menupanel.add(userGRAPE_label);
		menupanel.add(userORANGE_label);
		menupanel.add(userSTRAWBERRY_label);

	}

	class goback_listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			changeImfo();
			f.fileSave();
			setVisible(false);
			MainDisplay md = new MainDisplay();
			md.go();
		}
	}

	class PopUpMarket extends JPanel {

		private JButton[] APPLE = new JButton[100];
		private JButton[] GRAPE = new JButton[100];
		private JButton[] ORANGE = new JButton[100];
		private JButton[] STRAWBERRY = new JButton[100];

		private ImageIcon apple;
		private ImageIcon orange;
		private ImageIcon strawberry;
		private ImageIcon grape;
		private ImageIcon exit;
		private JLabel apple_lb,orange_lb,straw_lb,grape_lb;

		public PopUpMarket() {

			this.setSize(350, 590);
			this.setLayout(new GridLayout(1, 4));

			apple = new ImageIcon("apple1.png");
			orange = new ImageIcon("orange.png");
			strawberry = new ImageIcon("strawberry.png");
			grape = new ImageIcon("grape.png");
			
			 apple_lb = new JLabel("APPLE");
			 orange_lb = new JLabel("ORANGE");
			 straw_lb = new JLabel("STRAWBERRY");
			 grape_lb = new JLabel("GRAPE");

			//JPanel west = new JPanel();
			//JPanel east = new JPanel();
			JPanel apple_panel = new JPanel();
			JPanel grape_panel = new JPanel();
			JPanel strawberry_panel = new JPanel();
			JPanel orange_panel = new JPanel();

			apple_panel.setLayout(new BoxLayout(apple_panel, BoxLayout.Y_AXIS));
			grape_panel.setLayout(new BoxLayout(grape_panel, BoxLayout.Y_AXIS));
			strawberry_panel.setLayout(new BoxLayout(strawberry_panel, BoxLayout.Y_AXIS));
			orange_panel.setLayout(new BoxLayout(orange_panel, BoxLayout.Y_AXIS));

			number_apple = UserFile.Users.get(idx).getApple();
			number_grape = UserFile.Users.get(idx).getGrape();
			number_orange = UserFile.Users.get(idx).getOrange();
			number_straw = UserFile.Users.get(idx).getStrawBerry();
			
			apple_panel.add(apple_lb);
			grape_panel.add(grape_lb);
			orange_panel.add(orange_lb);
			strawberry_panel.add(straw_lb);			

			for (i = 0; i < number_apple; i++) {
				APPLE[i] = new AppleButton();
				APPLE[i].setIcon(apple);

				apple_panel.add(APPLE[i]);

			}

			for (i = 0; i < number_grape; i++) {
				GRAPE[i] = new GrapeButton();
				GRAPE[i].setIcon(grape);
				grape_panel.add(GRAPE[i]);

			}

			for (i = 0; i < number_orange; i++) {
				ORANGE[i] = new OrangeButton();
				ORANGE[i].setIcon(orange);
				orange_panel.add(ORANGE[i]);

			}

			for (i = 0; i < number_straw; i++) {
				STRAWBERRY[i] = new StrawButton();
				STRAWBERRY[i].setIcon(strawberry);
				strawberry_panel.add(STRAWBERRY[i]);

			}//
			
			this.add(apple_panel);
			this.add(orange_panel);
			this.add(grape_panel);
			this.add(strawberry_panel);
			//west.add(BorderLayout.WEST, apple_panel);
			//west.add(BorderLayout.EAST, grape_panel);

			//east.add(BorderLayout.WEST, orange_panel);
			//east.add(BorderLayout.EAST, strawberry_panel);

			//this.add(BorderLayout.WEST, west);
			//this.add(BorderLayout.EAST, east);

		}

		class quit_listener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				f.fileSave();
				changeImfo();
				setVisible(false);
			}
		}

	}

	void changeImfo() {
		userAPPLE_label.setText(" 			A p p l e   :   " + UserFile.Users.get(idx).getApple());
		userGRAPE_label.setText(" 			G r a p e   :   " + UserFile.Users.get(idx).getGrape());
		userORANGE_label.setText(" 			O r a n g e   :   " + UserFile.Users.get(idx).getOrange());
		userSTRAWBERRY_label.setText(" 			S t r a w b e r r y   :   " + UserFile.Users.get(idx).getStrawBerry());
		userMONEY_label.setText("           M o n e y   :   " + UserFile.Users.get(idx).getMoney());
	}

	public class AppleButton extends JButton implements ActionListener {

		public AppleButton() {

			this.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			// UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney()
			// + 500);
			if(!guestP1.isVisible()&&!guestP2.isVisible()&&!guestP3.isVisible()&&!guestP4.isVisible())
			{
				JOptionPane.showMessageDialog(juice_button, "No guest ", "Title", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			UserFile.Users.get(idx).setApple(UserFile.Users.get(idx).getApple() - 1);
			juice_price = juice_price + 500;
			juice_apple++;
			juice_button.setVisible(true);
			changeImfo();
			setVisible(false);

		}

	}

	public class OrangeButton extends JButton implements ActionListener {

		public OrangeButton() {

			this.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney()
			// + 700);
			if(!guestP1.isVisible()&&!guestP2.isVisible()&&!guestP3.isVisible()&&!guestP4.isVisible())
			{
				JOptionPane.showMessageDialog(juice_button, "No guest ", "Title", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			UserFile.Users.get(idx).setOrange((UserFile.Users.get(idx).getOrange() - 1));
			juice_orange++;
			juice_price = juice_price + 700;
			changeImfo();
			juice_button.setVisible(true);
			setVisible(false);

		}

	}

	public class StrawButton extends JButton implements ActionListener {

		public StrawButton() {

			this.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney()
			// + 600);
			if(!guestP1.isVisible()&&!guestP2.isVisible()&&!guestP3.isVisible()&&!guestP4.isVisible()){
				JOptionPane.showMessageDialog(juice_button, "No guest ", "Title", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			UserFile.Users.get(idx).setStrawBerry(UserFile.Users.get(idx).getStrawBerry() - 1);
			juice_straw++;
			juice_price = juice_price + 600;
			changeImfo();
			juice_button.setVisible(true);
			setVisible(false);

		}

	}

	public class GrapeButton extends JButton implements ActionListener {

		public GrapeButton() {
			this.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney()
			// + 800);
			if(!guestP1.isVisible()&&!guestP2.isVisible()&&!guestP3.isVisible()&&!guestP4.isVisible()){
				JOptionPane.showMessageDialog(juice_button, "No guest ", "Title", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			UserFile.Users.get(idx).setGrape(UserFile.Users.get(idx).getGrape() - 1);
			juice_grape++;
			juice_price = juice_price + 500;
			changeImfo();
			juice_button.setVisible(true);
			setVisible(false);

		}

	}

}
