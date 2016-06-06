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

	private ImageIcon guest1 = new ImageIcon("guest1.png");
	private ImageIcon guest2 = new ImageIcon("guest2.png");
	private ImageIcon guest3 = new ImageIcon("guest3.png");
	private ImageIcon guest4 = new ImageIcon("guest4.png");
	private ImageIcon apple = new ImageIcon("apple1.png");
	private ImageIcon orange = new ImageIcon("orange.png");
	private ImageIcon strawberry = new ImageIcon("strawberry.png");
	private ImageIcon grape = new ImageIcon("grape.png");

	private JButton go_back = new JButton();

	private JButton juice_apple_button = new JButton();
	private JButton juice_orange_button = new JButton();
	private JButton juice_straw_button = new JButton();
	private JButton juice_grape_button = new JButton();

	private JPanel back_ground,guestP1, guestP2, guestP3, guestP4;
	
	JPanel menupanel;
	
	private JLabel userAPPLE_label = new JLabel();
	private JLabel userGRAPE_label= new JLabel();
	private JLabel userORANGE_label = new JLabel();
	private JLabel userSTRAWBERRY_label = new JLabel();
	private JLabel userMONEY_label = new JLabel();

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

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		/*get user information in user file*/
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

		/*adding ActionListener in juice button*/
		juice_button_add_Actionlistenr();
		
		/*draw images in panels*/
		drawImage();
		
		/*Juice button setting*/
		juice_button_setting();
		
		/*image panels set bounds and sizes*/
		back_ground.setLayout(null);
		go_back.setBounds(900, 400, 60, 60);
		refri.setBounds(0, 0, 300, 590);
		guestP1.setBounds(500, 300, guest1.getIconWidth(), guest1.getIconHeight());
		guestP2.setBounds(500 + guest1.getIconWidth(), 300, guest2.getIconWidth(), guest2.getIconHeight());
		guestP3.setBounds(500 + guest2.getIconWidth() + guest1.getIconWidth(), 300, guest3.getIconWidth(), guest3.getIconHeight());
		guestP4.setBounds(500 + guest3.getIconWidth() + guest2.getIconWidth() + guest1.getIconWidth(), 300, guest4.getIconWidth(), guest4.getIconHeight());
		/*that image panels set bounds and sizes is finish*/
		
		/*adding component in back_ground*/
		back_ground.add(guestP4);
		back_ground.add(guestP3);
		back_ground.add(guestP2);
		back_ground.add(guestP1);
		back_ground.add(juice_apple_button);
		back_ground.add(juice_orange_button);
		back_ground.add(juice_straw_button);
		back_ground.add(juice_grape_button);
		back_ground.add(go_back);
		back_ground.add(refri);
		/*adding component in back_ground finish*/		
		
		menupanel = userImfoPane();
		
		this.getContentPane().add(BorderLayout.NORTH, menupanel);
		this.getContentPane().add(BorderLayout.CENTER, back_ground);
		
	}
	
	/*setting juice button*/
	void juice_button_setting(){
		
		juice_apple_button.setContentAreaFilled(false);
		juice_apple_button.setDefaultCapable(false);
		juice_apple_button.setFocusPainted(false);
		juice_apple_button.setOpaque(false);
		juice_apple_button.setIcon(new ImageIcon("juice_apple.png"));
		juice_apple_button.setRolloverIcon(new ImageIcon("juice_sell.png"));
		juice_apple_button.setBackground(null);
		juice_apple_button.setBorderPainted(false);
		juice_apple_button.addActionListener(new AppleButton());
		juice_apple_button.setBounds(500, 100, 160, 160);
		juice_apple_button.setVisible(false);

		juice_orange_button.setContentAreaFilled(false);
		juice_orange_button.setDefaultCapable(false);
		juice_orange_button.setFocusPainted(false);
		juice_orange_button.setOpaque(false);
		juice_orange_button.setIcon(new ImageIcon("juice_orange.png"));
		juice_orange_button.setRolloverIcon(new ImageIcon("juice_sell.png"));
		juice_orange_button.setBackground(null);
		juice_orange_button.setBorderPainted(false);
		juice_orange_button.addActionListener(new OrangeButton());
		juice_orange_button.setBounds(500, 100, 160, 160);
		juice_orange_button.setVisible(false);
		
		juice_straw_button.setContentAreaFilled(false);
		juice_straw_button.setDefaultCapable(false);
		juice_straw_button.setFocusPainted(false);
		juice_straw_button.setOpaque(false);
		juice_straw_button.setIcon(new ImageIcon("juice_strawberry.png"));
		juice_straw_button.setRolloverIcon(new ImageIcon("juice_sell.png"));
		juice_straw_button.setBackground(null);
		juice_straw_button.setBorderPainted(false);
		juice_straw_button.addActionListener(new StrawButton());
		juice_straw_button.setBounds(500, 100, 160, 160);
		juice_straw_button.setVisible(false);
		
		juice_grape_button.setContentAreaFilled(false);
		juice_grape_button.setDefaultCapable(false);
		juice_grape_button.setFocusPainted(false);
		juice_grape_button.setOpaque(false);
		juice_grape_button.setIcon(new ImageIcon("juice_grape.png"));
		juice_grape_button.setRolloverIcon(new ImageIcon("juice_sell.png"));
		juice_grape_button.setBackground(null);
		juice_grape_button.setBorderPainted(false);
		juice_grape_button.addActionListener(new GrapeButton());
		juice_grape_button.setBounds(500, 100, 160, 160);
		juice_grape_button.setVisible(false);
		
		
	}
	
	/*adding Action Listener in juice button*/
	void juice_button_add_Actionlistenr(){
		
		juice_apple_button.addActionListener(new ActionListener() {

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
					JOptionPane.showMessageDialog(juice_apple_button, "No guest ", "Title", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				JOptionPane.showMessageDialog(juice_apple_button,
						"APPLE JUICE! "+ "\nPRICE: " + juice_price,
						"JUICE IMFOMATION", JOptionPane.INFORMATION_MESSAGE);

				UserFile.Users.get(idx).setApplebox((UserFile.Users.get(idx).getApplebox() - 1));
				UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney() + juice_price);

				juice_price=0;
				changeImfo();
				juice_apple_button.setVisible(false);
			
			}
		});

		juice_orange_button.addActionListener(new ActionListener() {

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
					JOptionPane.showMessageDialog(juice_orange_button, "No guest ", "Title", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				JOptionPane.showMessageDialog(juice_orange_button,
						"ORANGE JUICE! "+ "\nPRICE: " + juice_price,
						"JUICE IMFOMATION", JOptionPane.INFORMATION_MESSAGE);

				UserFile.Users.get(idx).setOrangebox((UserFile.Users.get(idx).getOrangebox() - 1));
				UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney() + juice_price);
	
				juice_price=0;
				changeImfo();
				juice_orange_button.setVisible(false);
			}
		});

		juice_straw_button.addActionListener(new ActionListener() {

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
					JOptionPane.showMessageDialog(juice_straw_button, "No guest ", "Title", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				JOptionPane.showMessageDialog(juice_straw_button,
						"STRAWBERRY"+ "\nPRICE: " + juice_price,
						"JUICE IMFOMATION", JOptionPane.INFORMATION_MESSAGE);

				UserFile.Users.get(idx).setStrawberrybox((UserFile.Users.get(idx).getStrawberrybox() - 1));
				UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney() + juice_price);

				juice_price=0;
				changeImfo();
				juice_straw_button.setVisible(false);
			}
		});

		juice_grape_button.addActionListener(new ActionListener() {

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
					JOptionPane.showMessageDialog(juice_grape_button, "No guest ", "Title", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				JOptionPane.showMessageDialog(juice_grape_button,
						"GRAPE JUICE! "+"\nPRICE: " + juice_price,
						"JUICE IMFOMATION", JOptionPane.INFORMATION_MESSAGE);

				UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney() + juice_price);
				UserFile.Users.get(idx).setGrapebox((UserFile.Users.get(idx).getGrapebox() - 1));
				
				juice_price=0;
				changeImfo();
				juice_grape_button.setVisible(false);
			}
		});
		
		
	}
	
	/*crate Jpanel that have user information Jlebel*/
	JPanel userImfoPane(){
		
		JPanel menupanel = new JPanel();

		Font font = new Font("Dialog", Font.BOLD, 13); // 20은 글자 크기

		JLabel userID_label = new JLabel("User   :   " + UserFile.Users.get(idx).getId());
		userID_label.setFont(font);

		userMONEY_label.setText("    Money   :   " + UserFile.Users.get(idx).getMoney());
		userMONEY_label.setFont(font);

		JLabel userLEVEL_label = new JLabel("    Level   :   " + UserFile.Users.get(idx).getLevel());
		userLEVEL_label.setFont(font);

		userAPPLE_label.setText("    Apple  BOX :   " + UserFile.Users.get(idx).getApplebox());
		userAPPLE_label.setFont(font);

		userGRAPE_label.setText("    Grape  BOX  :   " + UserFile.Users.get(idx).getGrapebox());
		userGRAPE_label.setFont(font);

		userORANGE_label.setText("    Orange  BOX  :   " + UserFile.Users.get(idx).getOrangebox());
		userORANGE_label.setFont(font);

		userSTRAWBERRY_label.setText("    Strawberry  BOX  :   " + UserFile.Users.get(idx).getStrawberrybox());
		userSTRAWBERRY_label.setFont(font);

		changeImfo();
		
		menupanel.add(userID_label);
		menupanel.add(userLEVEL_label);
		menupanel.add(userMONEY_label);
		menupanel.add(userAPPLE_label);
		menupanel.add(userGRAPE_label);
		menupanel.add(userORANGE_label);
		menupanel.add(userSTRAWBERRY_label);
		
		return menupanel;
		
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

		private JButton[] APPLE_BOX = new JButton[100];
		private JButton[] GRAPE_BOX = new JButton[100];
		private JButton[] ORANGE_BOX = new JButton[100];
		private JButton[] STRAWBERRY_BOX = new JButton[100];

		private JLabel apple_lb, orange_lb, straw_lb, grape_lb;

		public Refrigerator() {

			this.setSize(350, 590);
			this.setLayout(new GridLayout(1, 4));
			
			Font font = new Font("Dialog", Font.BOLD, 11);

			apple_lb = new JLabel("APPLE BOX");
			orange_lb = new JLabel("ORANGE BOX");
			straw_lb = new JLabel("STRAWBERRY BOX");
			grape_lb = new JLabel("GRAPE BOX");
			
			apple_lb.setFont(font);
			orange_lb.setFont(font);
			straw_lb.setFont(font);
			grape_lb.setFont(font);
			
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

			number_apple = UserFile.Users.get(idx).getApplebox();
			number_grape = UserFile.Users.get(idx).getGrapebox();
			number_orange = UserFile.Users.get(idx).getOrangebox();
			number_straw = UserFile.Users.get(idx).getStrawberrybox();

			/*add fruit name label*/
			apple_panel.add(apple_lb);
			grape_panel.add(grape_lb);
			orange_panel.add(orange_lb);
			strawberry_panel.add(straw_lb);

			/*crate fruit button*/
			for (i = 0; i < number_apple; i++) {
				APPLE_BOX[i] = new AppleButton();
				APPLE_BOX[i].setIcon(apple);

				apple_panel.add(APPLE_BOX[i]);

			}

			for (i = 0; i < number_grape; i++) {
				GRAPE_BOX[i] = new GrapeButton();
				GRAPE_BOX[i].setIcon(grape);
				grape_panel.add(GRAPE_BOX[i]);

			}

			for (i = 0; i < number_orange; i++) {
				ORANGE_BOX[i] = new OrangeButton();
				ORANGE_BOX[i].setIcon(orange);
				orange_panel.add(ORANGE_BOX[i]);

			}

			for (i = 0; i < number_straw; i++) {
				STRAWBERRY_BOX[i] = new StrawButton();
				STRAWBERRY_BOX[i].setIcon(strawberry);
				strawberry_panel.add(STRAWBERRY_BOX[i]);

			} 

			this.add(apple_panel);
			this.add(orange_panel);
			this.add(grape_panel);
			this.add(strawberry_panel);

		}

	}

	/*User information label change */
	void changeImfo() {
		userMONEY_label.setText("    Money   :   " + UserFile.Users.get(idx).getMoney());
		userAPPLE_label.setText("    Apple  BOX :   " + UserFile.Users.get(idx).getApplebox());
		userGRAPE_label.setText("    Grape  BOX  :   " + UserFile.Users.get(idx).getGrapebox());
		userORANGE_label.setText("    Orange  BOX  :   " + UserFile.Users.get(idx).getOrangebox());
		userSTRAWBERRY_label.setText("    Strawberry  BOX  :   " + UserFile.Users.get(idx).getStrawberrybox());
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
				JOptionPane.showMessageDialog(juice_apple_button, "No guest ", "Title", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			/*if juice is already exist, no perform*/
			if (juice_grape_button.isVisible() || juice_apple_button.isVisible() || juice_orange_button.isVisible()
					|| juice_straw_button.isVisible())
				return;
			
			juice_price = juice_price + 500;
			juice_apple_button.setVisible(true);
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
				JOptionPane.showMessageDialog(juice_orange_button, "No guest ", "Title", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			/*if juice is already exist, no perform*/
			if (juice_grape_button.isVisible() || juice_apple_button.isVisible() || juice_orange_button.isVisible()
					|| juice_straw_button.isVisible())
				return;

			juice_price = juice_price + 700;
			changeImfo();
			juice_orange_button.setVisible(true);
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
				JOptionPane.showMessageDialog(juice_straw_button, "No guest ", "Title", JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			/*if juice is already exist, no perform*/
			if (juice_grape_button.isVisible() || juice_apple_button.isVisible() || juice_orange_button.isVisible()
					|| juice_straw_button.isVisible())
				return;

			juice_price = juice_price + 600;
			changeImfo();
			juice_straw_button.setVisible(true);
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
				JOptionPane.showMessageDialog(juice_grape_button, "No guest ", "Title", JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			/*if juice is already exist, no perform*/
			if (juice_grape_button.isVisible() || juice_apple_button.isVisible() || juice_orange_button.isVisible()
					|| juice_straw_button.isVisible())
				return;

			juice_price = juice_price + 500;
			changeImfo();
			juice_grape_button.setVisible(true);
			setVisible(false);

		}

	}

}
