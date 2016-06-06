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

	//private Container container;
	
	private ImageIcon guest1 = new ImageIcon("guest1.png");
	private ImageIcon guest2 = new ImageIcon("guest2.png");
	private ImageIcon guest3 = new ImageIcon("guest3.png");
	private ImageIcon guest4 = new ImageIcon("guest4.png");
	private ImageIcon apple = new ImageIcon("apple1.png");
	private ImageIcon orange = new ImageIcon("orange.png");
	private ImageIcon strawberry = new ImageIcon("strawberry.png");
	private ImageIcon grape = new ImageIcon("grape.png");

	private JButton go_back = new JButton();

	private JButton apple_button = new JButton();
	private JButton orange_button = new JButton();
	private JButton straw_button = new JButton();
	private JButton grape_button = new JButton();

	private JPanel back_ground,guestP1, guestP2, guestP3, guestP4;
	private JLabel userAPPLE_label, userGRAPE_label, userORANGE_label, userSTRAWBERRY_label, userMONEY_label;

	private int number_apple = 0;
	private int number_orange = 0;
	private int number_straw = 0;
	private int number_grape = 0;
	
	private int juice_price = 0;

	private int i;
	
	public StoreFrame() {
		go_store();

	}

	public void go_store() {
		/////

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		for (int i = 0; i < UserFile.Users.size(); i++) {
			if (UserFile.Users.get(i).getIndex() > 0)
				idx = i;
		}

		Refrigerator refri = new Refrigerator();

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

		apple_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (guestP1.isVisible())
					guestP1.setVisible(false);
				else if (guestP2.isVisible())
					guestP2.setVisible(false);
				else if (guestP3.isVisible())
					guestP3.setVisible(false);
				else if (guestP4.isVisible())
					guestP4.setVisible(false);
				else {
					JOptionPane.showMessageDialog(apple_button, "No guest ", "Title", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				JOptionPane.showMessageDialog(apple_button,
						"APPLE JUICE! "+ "\nPRICE: " + juice_price,
						"JUICE IMFOMATION", JOptionPane.INFORMATION_MESSAGE);

				UserFile.Users.get(idx).setApple((UserFile.Users.get(idx).getApple() - 1));
				UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney() + juice_price);

				juice_price=0;

				apple_button.setVisible(false);
			
			}
		});

		orange_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (guestP1.isVisible())
					guestP1.setVisible(false);
				else if (guestP2.isVisible())
					guestP2.setVisible(false);
				else if (guestP3.isVisible())
					guestP3.setVisible(false);
				else if (guestP4.isVisible())
					guestP4.setVisible(false);
				else {
					JOptionPane.showMessageDialog(orange_button, "No guest ", "Title", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				JOptionPane.showMessageDialog(orange_button,
						"ORANGE JUICE! "+ "\nPRICE: " + juice_price,
						"JUICE IMFOMATION", JOptionPane.INFORMATION_MESSAGE);

				UserFile.Users.get(idx).setOrange((UserFile.Users.get(idx).getOrange() - 1));
				UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney() + juice_price);
	
				juice_price=0;
				
				orange_button.setVisible(false);
			}
		});

		straw_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (guestP1.isVisible())
					guestP1.setVisible(false);
				else if (guestP2.isVisible())
					guestP2.setVisible(false);
				else if (guestP3.isVisible())
					guestP3.setVisible(false);
				else if (guestP4.isVisible())
					guestP4.setVisible(false);
				else {
					JOptionPane.showMessageDialog(straw_button, "No guest ", "Title", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				JOptionPane.showMessageDialog(straw_button,
						"STRAWBERRY"+ "\nPRICE: " + juice_price,
						"JUICE IMFOMATION", JOptionPane.INFORMATION_MESSAGE);

				UserFile.Users.get(idx).setStrawBerry((UserFile.Users.get(idx).getStrawBerry() - 1));
				UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney() + juice_price);

				juice_price=0;
				
				straw_button.setVisible(false);
			}
		});

		grape_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (guestP1.isVisible())
					guestP1.setVisible(false);
				else if (guestP2.isVisible())
					guestP2.setVisible(false);
				else if (guestP3.isVisible())
					guestP3.setVisible(false);
				else if (guestP4.isVisible())
					guestP4.setVisible(false);
				else {
					JOptionPane.showMessageDialog(grape_button, "No guest ", "Title", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				JOptionPane.showMessageDialog(grape_button,
						"GRAPE JUICE! "+"\nPRICE: " + juice_price,
						"JUICE IMFOMATION", JOptionPane.INFORMATION_MESSAGE);

				UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney() + juice_price);
				UserFile.Users.get(idx).setGrape((UserFile.Users.get(idx).getGrape() - 1));
				
				juice_price=0;

				grape_button.setVisible(false);
			}
		});
		
		drawImage();


		back_ground.setLayout(null);
		this.getContentPane().add(BorderLayout.CENTER, back_ground);

		go_back.setBounds(900, 400, 60, 60);
		refri.setBounds(0, 0, 300, 590);
		
		/*Juice button setting*/
		apple_button.setContentAreaFilled(false);
		apple_button.setDefaultCapable(false);
		apple_button.setFocusPainted(false);
		apple_button.setOpaque(false);
		apple_button.setIcon(new ImageIcon("juice_apple.png"));
		apple_button.setRolloverIcon(new ImageIcon("juice_sell.png"));
		apple_button.setBackground(null);
		apple_button.setBorderPainted(false);
		apple_button.addActionListener(new AppleButton());
		apple_button.setBounds(500, 100, 160, 160);
		apple_button.setVisible(false);

		orange_button.setContentAreaFilled(false);
		orange_button.setDefaultCapable(false);
		orange_button.setFocusPainted(false);
		orange_button.setOpaque(false);
		orange_button.setIcon(new ImageIcon("juice_orange.png"));
		orange_button.setRolloverIcon(new ImageIcon("juice_sell.png"));
		orange_button.setBackground(null);
		orange_button.setBorderPainted(false);
		orange_button.addActionListener(new OrangeButton());
		orange_button.setBounds(500, 100, 160, 160);
		orange_button.setVisible(false);
		
		straw_button.setContentAreaFilled(false);
		straw_button.setDefaultCapable(false);
		straw_button.setFocusPainted(false);
		straw_button.setOpaque(false);
		straw_button.setIcon(new ImageIcon("juice_strawberry.png"));
		straw_button.setRolloverIcon(new ImageIcon("juice_sell.png"));
		straw_button.setBackground(null);
		straw_button.setBorderPainted(false);
		straw_button.addActionListener(new StrawButton());
		straw_button.setBounds(500, 100, 160, 160);
		straw_button.setVisible(false);
		
		grape_button.setContentAreaFilled(false);
		grape_button.setDefaultCapable(false);
		grape_button.setFocusPainted(false);
		grape_button.setOpaque(false);
		grape_button.setIcon(new ImageIcon("juice_grape.png"));
		grape_button.setRolloverIcon(new ImageIcon("juice_sell.png"));
		grape_button.setBackground(null);
		grape_button.setBorderPainted(false);
		grape_button.addActionListener(new GrapeButton());
		grape_button.setBounds(500, 100, 160, 160);
		grape_button.setVisible(false);

		
		guestP1.setBounds(500, 300, guest1.getIconWidth(), guest1.getIconHeight());
		guestP2.setBounds(500 + guest1.getIconWidth(), 300, guest2.getIconWidth(), guest2.getIconHeight());
		guestP3.setBounds(500 + guest2.getIconWidth() + guest1.getIconWidth(), 300, guest3.getIconWidth(), guest3.getIconHeight());
		guestP4.setBounds(500 + guest3.getIconWidth() + guest2.getIconWidth() + guest1.getIconWidth(), 300, guest4.getIconWidth(), guest4.getIconHeight());
		
		/*Juicy Button setting finish*/

		/*adding component in back_ground*/
		back_ground.add(guestP4);
		back_ground.add(guestP3);
		back_ground.add(guestP2);
		back_ground.add(guestP1);
		back_ground.add(apple_button);
		back_ground.add(orange_button);
		back_ground.add(straw_button);
		back_ground.add(grape_button);
		back_ground.add(go_back);
		back_ground.add(refri);
		/*adding component in back_ground finish*/
		
		JPanel menupanel = new JPanel();

		this.getContentPane().add(BorderLayout.NORTH, menupanel);

		Font font = new Font("Dialog", Font.BOLD, 15); // 20은 글자 크기

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
	
	void drawImage(){
		
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

		back_ground = new JPanel() {

			public void paintComponent(Graphics g) {
				g.drawImage(storeIm.getImage(), 300, 0, this);
			}
		};
		
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

	class Refrigerator extends JPanel {

		private JButton[] APPLE = new JButton[100];
		private JButton[] GRAPE = new JButton[100];
		private JButton[] ORANGE = new JButton[100];
		private JButton[] STRAWBERRY = new JButton[100];

		private JLabel apple_lb, orange_lb, straw_lb, grape_lb;

		public Refrigerator() {

			this.setSize(350, 590);
			this.setLayout(new GridLayout(1, 4));

			apple_lb = new JLabel("APPLE");
			orange_lb = new JLabel("ORANGE");
			straw_lb = new JLabel("STRAWBERRY");
			grape_lb = new JLabel("GRAPE");

			JPanel apple_panel = new JPanel();
			JPanel grape_panel = new JPanel();
			JPanel strawberry_panel = new JPanel();
			JPanel orange_panel = new JPanel();

			apple_panel.setLayout(new BoxLayout(apple_panel, BoxLayout.Y_AXIS));
			grape_panel.setLayout(new BoxLayout(grape_panel, BoxLayout.Y_AXIS));
			strawberry_panel.setLayout(new BoxLayout(strawberry_panel, BoxLayout.Y_AXIS));
			orange_panel.setLayout(new BoxLayout(orange_panel, BoxLayout.Y_AXIS));
			
			apple_panel.setBackground(new Color(52,121,199));
			grape_panel.setBackground(new Color(52,121,199));
			strawberry_panel.setBackground(new Color(52,121,199));
			orange_panel.setBackground(new Color(52,121,199));

			number_apple = UserFile.Users.get(idx).getApple();
			number_grape = UserFile.Users.get(idx).getGrape();
			number_orange = UserFile.Users.get(idx).getOrange();
			number_straw = UserFile.Users.get(idx).getStrawBerry();

			/*add fruit name label*/
			apple_panel.add(apple_lb);
			grape_panel.add(grape_lb);
			orange_panel.add(orange_lb);
			strawberry_panel.add(straw_lb);

			/*crate fruit button*/
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

			} 

			this.add(apple_panel);
			this.add(orange_panel);
			this.add(grape_panel);
			this.add(strawberry_panel);

		}

		class quit_listener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				f.fileSave();
				changeImfo();
				setVisible(false);
			}
		}

	}

	/*User information label change */
	void changeImfo() {
		userAPPLE_label.setText(" 			A p p l e   :   " + UserFile.Users.get(idx).getApple());
		userGRAPE_label.setText(" 			G r a p e   :   " + UserFile.Users.get(idx).getGrape());
		userORANGE_label.setText(" 			O r a n g e   :   " + UserFile.Users.get(idx).getOrange());
		userSTRAWBERRY_label.setText(" 			S t r a w b e r r y   :   " + UserFile.Users.get(idx).getStrawBerry());
		userMONEY_label.setText("           M o n e y   :   " + UserFile.Users.get(idx).getMoney());
	}
	
	
	/*Fruit Button CLASS*/
	public class AppleButton extends JButton implements ActionListener {

		public AppleButton() {

			this.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			/*if guest not exist, no perform*/
			if (!guestP1.isVisible() && !guestP2.isVisible() && !guestP3.isVisible() && !guestP4.isVisible()) {
				JOptionPane.showMessageDialog(apple_button, "No guest ", "Title", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			/*if juice is already exist, no perform*/
			if (grape_button.isVisible() || apple_button.isVisible() || orange_button.isVisible()
					|| straw_button.isVisible())
				return;
			
			juice_price = juice_price + 500;
			apple_button.setVisible(true);
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
			
			/*if guest not exist, no perform*/
			if (!guestP1.isVisible() && !guestP2.isVisible() && !guestP3.isVisible() && !guestP4.isVisible()) {
				JOptionPane.showMessageDialog(orange_button, "No guest ", "Title", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			/*if juice is already exist, no perform*/
			if (grape_button.isVisible() || apple_button.isVisible() || orange_button.isVisible()
					|| straw_button.isVisible())
				return;

			juice_price = juice_price + 700;
			changeImfo();
			orange_button.setVisible(true);
			setVisible(false);

		}

	}

	public class StrawButton extends JButton implements ActionListener {

		public StrawButton() {

			this.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			/*if guest not exist, no perform*/
			if (!guestP1.isVisible() && !guestP2.isVisible() && !guestP3.isVisible() && !guestP4.isVisible()) {
				JOptionPane.showMessageDialog(straw_button, "No guest ", "Title", JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			/*if juice is already exist, no perform*/
			if (grape_button.isVisible() || apple_button.isVisible() || orange_button.isVisible()
					|| straw_button.isVisible())
				return;

			juice_price = juice_price + 600;
			changeImfo();
			straw_button.setVisible(true);
			setVisible(false);

		}

	}

	public class GrapeButton extends JButton implements ActionListener {

		public GrapeButton() {
			this.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			/*if guest not exist, no perform*/
			if (!guestP1.isVisible() && !guestP2.isVisible() && !guestP3.isVisible() && !guestP4.isVisible()) {
				JOptionPane.showMessageDialog(grape_button, "No guest ", "Title", JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			/*if juice is already exist, no perform*/
			if (grape_button.isVisible() || apple_button.isVisible() || orange_button.isVisible()
					|| straw_button.isVisible())
				return;

			juice_price = juice_price + 500;
			changeImfo();
			grape_button.setVisible(true);
			setVisible(false);

		}

	}

}
