import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.*;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class StoreFrame extends GameFrame {

	/* image icon */
	private ImageIcon guest1 = new ImageIcon("guest1.png");
	private ImageIcon guest2 = new ImageIcon("guest2.png");
	private ImageIcon guest3 = new ImageIcon("guest3.png");
	private ImageIcon guest4 = new ImageIcon("guest4.png");
	private ImageIcon apple = new ImageIcon("apple1.png");
	private ImageIcon orange = new ImageIcon("orange.png");
	private ImageIcon strawberry = new ImageIcon("strawberry.png");
	private ImageIcon grape = new ImageIcon("grape.png");
	private ImageIcon storeIm = new ImageIcon("Store.png");

	/* button */
	private JButton go_back = new JButton();
	private JButton cart = new JButton();
	private JButton recipe = new JButton("recipe");
	private JButton juice_apple_button = new JButton();
	private JButton juice_orange_button = new JButton();
	private JButton juice_straw_button = new JButton();
	private JButton juice_grape_button = new JButton();

	/* guest panels and back ground panel */
	private JPanel back_ground, guestP1, guestP2, guestP3, guestP4;

	/* Crating variables that have the number of fruit box */
	private int juice_price = 0;

	static ArrayList<String> consumer = new ArrayList<String>();

	/* Constructor */
	public StoreFrame() {
		go_store();

	}

	public void go_store() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		getUserIdx();

		/* Crate Refrigerator object and Panel about user information */
		Refrigerator refri = new Refrigerator();
		JPanel menupanel;

		/* setting go back button */
		go_back.setContentAreaFilled(false);
		go_back.setDefaultCapable(false);
		go_back.setFocusPainted(false);
		go_back.setOpaque(false);
		go_back.setIcon(new ImageIcon("button_exit.png"));
		go_back.setRolloverIcon(new ImageIcon("button_exit_s.png"));
		go_back.setBackground(null);
		go_back.setBorderPainted(false);
		go_back.addActionListener(new goback_listener());

		cart.setContentAreaFilled(false);
		cart.setDefaultCapable(false);
		cart.setFocusPainted(false);
		cart.setOpaque(false);
		cart.setIcon(new ImageIcon("Refri.png"));
		cart.setRolloverIcon(new ImageIcon("RefriOpen.png"));
		cart.setBackground(null);
		cart.setBorderPainted(false);
		cart.addActionListener(new CartListener());

		/* adding ActionListener in juice button */
		juice_button_add_Actionlistenr();

		/* draw images in panels */
		drawImage();

		/* Juice button setting */
		juice_button_setting();

		/* image panels set bounds and sizes */
		back_ground.setLayout(null);
		cart.setBounds(320, 30, 60, 108);
		go_back.setBounds(900, 400, 60, 60);
		refri.setBounds(0, 0, 300, 590);
		recipe.setBounds(800, 100, 60, 60);
		guestP1.setBounds(500, 300, guest1.getIconWidth(), guest1.getIconHeight());
		guestP2.setBounds(500 + guest1.getIconWidth(), 300, guest2.getIconWidth(), guest2.getIconHeight());
		guestP3.setBounds(500 + guest2.getIconWidth() + guest1.getIconWidth(), 300, guest3.getIconWidth(),
				guest3.getIconHeight());
		guestP4.setBounds(500 + guest3.getIconWidth() + guest2.getIconWidth() + guest1.getIconWidth(), 300,
				guest4.getIconWidth(), guest4.getIconHeight());
		/* that image panels set bounds and sizes is finish */

		if (UserFile.Users.get(idx).getMissionNum() == 5) {
			String str[] = UserFile.Users.get(idx).getDoMission();
			JLabel p1 = new JLabel(UserFile.Users.get(idx).getDoMission()[2]);
			p1.setBackground(Color.GRAY);
			JLabel p2 = new JLabel(UserFile.Users.get(idx).getDoMission()[3]);
			p2.setBackground(Color.GRAY);
			JLabel p3 = new JLabel(UserFile.Users.get(idx).getDoMission()[4]);
			p3.setBackground(Color.GRAY);
			JLabel p4 = new JLabel(UserFile.Users.get(idx).getDoMission()[5]);
			p4.setBackground(Color.GRAY);
			if (str[1].equals("1")) {
				guestP1.setVisible(false);	guestP2.setVisible(false);	guestP3.setVisible(false);
				p4.setBounds(guestP4.bounds().x+30,guestP4.bounds().y-60,100,100); back_ground.add(p4);
			} else if (str[1].equals("2")) {
				guestP1.setVisible(false);
				guestP2.setVisible(false);
				p3.setBounds(guestP3.bounds().x+38,guestP3.bounds().y+62,100,100); back_ground.add(p3);
				p4.setBounds(guestP4.bounds().x+30,guestP4.bounds().y-60,100,100); back_ground.add(p4);
			} else if (str[1].equals("3")) {
				guestP1.setVisible(false);
				p2.setBounds(guestP2.bounds().x,guestP2.bounds().y-62,100,100); back_ground.add(p2);
				p3.setBounds(guestP3.bounds().x+38,guestP3.bounds().y+62,100,100); back_ground.add(p3);
				p4.setBounds(guestP4.bounds().x+30,guestP4.bounds().y-60,100,100); back_ground.add(p4);
			}else{
				p1.setBounds(guestP1.bounds().x+20,guestP1.bounds().y-62,100,100); back_ground.add(p1);
				p2.setBounds(guestP2.bounds().x,guestP2.bounds().y-62,100,100); back_ground.add(p2);
				p3.setBounds(guestP3.bounds().x+38,guestP3.bounds().y+62,100,100); back_ground.add(p3);
				p4.setBounds(guestP4.bounds().x+30,guestP4.bounds().y-60,100,100); back_ground.add(p4);
			
			}
		}

		/* adding component in back_ground */
		back_ground.add(guestP4);
		back_ground.add(guestP3);
		back_ground.add(guestP2);
		back_ground.add(guestP1);
		back_ground.add(juice_apple_button);
		back_ground.add(juice_orange_button);
		back_ground.add(juice_straw_button);
		back_ground.add(juice_grape_button);
		back_ground.add(go_back);
		back_ground.add(cart);
		back_ground.add(recipe);
		back_ground.add(refri);
		/* adding component in back_ground finish */

		/* setting menupanel */
		menupanel = userImfoPane(2);

		/* adding components */
		this.getContentPane().add(BorderLayout.NORTH, menupanel);
		this.getContentPane().add(BorderLayout.CENTER, back_ground);

	}

	/* setting juice button */
	void juice_button_setting() {

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

	/* adding Action Listener in juice button */
	void juice_button_add_Actionlistenr() {

		juice_apple_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (guestP1.isVisible())
					guestP1.setVisible(false);
				else if (guestP2.isVisible())
					guestP2.setVisible(false);
				else if (guestP3.isVisible())
					guestP3.setVisible(false);
				else if (guestP4.isVisible()) {
					guestP4.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(juice_apple_button, "No guest ", "Title",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				JOptionPane.showMessageDialog(juice_apple_button, "APPLE JUICE! " + "\nPRICE: " + juice_price,
						"JUICE IMFOMATION", JOptionPane.INFORMATION_MESSAGE);

				UserFile.Users.get(idx).setAppleRefri((UserFile.Users.get(idx).getAppleRefri() - 1));
				UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney() + juice_price);
				UserFile.Users.get(idx).setAppleJuice(UserFile.Users.get(idx).getAppleJuice() + 1);
				consumer.add("apple");

				juice_price = 0;
				changeImfo(2);
				juice_apple_button.setVisible(false);

			}
		});
		//
		juice_orange_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//
				if (guestP1.isVisible())
					guestP1.setVisible(false);
				else if (guestP2.isVisible())
					guestP2.setVisible(false);
				else if (guestP3.isVisible())
					guestP3.setVisible(false);
				else if (guestP4.isVisible())
					guestP4.setVisible(false);
				else {
					JOptionPane.showMessageDialog(juice_orange_button, "No guest ", "Title",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				JOptionPane.showMessageDialog(juice_orange_button, "ORANGE JUICE! " + "\nPRICE: " + juice_price,
						"JUICE IMFOMATION", JOptionPane.INFORMATION_MESSAGE);

				UserFile.Users.get(idx).setOrangeRefri((UserFile.Users.get(idx).getOrangeRefri() - 1));
				UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney() + juice_price);
				UserFile.Users.get(idx).setOrangeJuice(UserFile.Users.get(idx).getOrangeJuice() + 1);
				consumer.add("orange");

				juice_price = 0;
				changeImfo(2);
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
					JOptionPane.showMessageDialog(juice_straw_button, "No guest ", "Title",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				JOptionPane.showMessageDialog(juice_straw_button, "STRAWBERRY" + "\nPRICE: " + juice_price,
						"JUICE IMFOMATION", JOptionPane.INFORMATION_MESSAGE);

				UserFile.Users.get(idx).setStrawberryRefri((UserFile.Users.get(idx).getStrawberryRefri() - 1));
				UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney() + juice_price);
				UserFile.Users.get(idx).setStrawberryJuice(UserFile.Users.get(idx).getStrawberryJuice() + 1);
				consumer.add("strawberry");

				juice_price = 0;
				changeImfo(2);
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
					JOptionPane.showMessageDialog(juice_grape_button, "No guest ", "Title",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				JOptionPane.showMessageDialog(juice_grape_button, "GRAPE JUICE! " + "\nPRICE: " + juice_price,
						"JUICE IMFOMATION", JOptionPane.INFORMATION_MESSAGE);

				UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney() + juice_price);
				UserFile.Users.get(idx).setGrapeRefri((UserFile.Users.get(idx).getGrapeRefri() - 1));
				UserFile.Users.get(idx).setGrapeJuice(UserFile.Users.get(idx).getGrapeJuice() + 1);
				consumer.add("grape");

				juice_price = 0;
				changeImfo(2);
				juice_grape_button.setVisible(false);
			}
		});

		recipe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(recipe,
						"<Fruit juice recipe> \n apple juice\n-needs  4 apples(=one appleBox)\n-click appleBox!\n "
								+ "orange juice\n-needs 4 oranges(=one orangeBox)\n-click orangeBox! \n"
								+ "grape juice\n-needs N 2 grapes(=one grapeBox)\n-click grapeBox! \n"
								+ "strawberry juice\n-needs 8 strawberrys(=one strawberryBox)\n-click strawberryBox!",
						"RECIPE IMFOMATION", JOptionPane.INFORMATION_MESSAGE);

			}
		});

		f.fileSave();

	}

	void drawImage() {

		guestP1 = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(guest1.getImage(), 0, 0, this);
			}
		};

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

		back_ground = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(storeIm.getImage(), 300, 0, this);
			}
		};

	}

	class goback_listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			UserFile.Users.get(idx).setConsumerBox(consumer);
			changeImfo(2);
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

		private JButton pushStack = new JButton("PUSH ALL BOX");

		JPanel apple_panel = new JPanel();
		JPanel grape_panel = new JPanel();
		JPanel strawberry_panel = new JPanel();
		JPanel orange_panel = new JPanel();

		private JLabel apple_lb, orange_lb, straw_lb, grape_lb;

		private int i;

		public Refrigerator() {

			this.setSize(350, 590);
			this.setLayout(new GridLayout(1, 4));
			this.setBackground(new Color(52, 121, 199));

			Font font = new Font("Dialog", Font.BOLD, 11);

			apple_lb = new JLabel("APPLE BOX");
			orange_lb = new JLabel("ORANGE BOX");
			straw_lb = new JLabel("STRAWBERRY BOX");
			grape_lb = new JLabel("GRAPE BOX");

			apple_lb.setFont(font);
			orange_lb.setFont(font);
			straw_lb.setFont(font);
			grape_lb.setFont(font);

			apple_panel.setLayout(new BoxLayout(apple_panel, BoxLayout.Y_AXIS));
			grape_panel.setLayout(new BoxLayout(grape_panel, BoxLayout.Y_AXIS));
			strawberry_panel.setLayout(new BoxLayout(strawberry_panel, BoxLayout.Y_AXIS));
			orange_panel.setLayout(new BoxLayout(orange_panel, BoxLayout.Y_AXIS));

			apple_panel.setBackground(new Color(52, 121, 199));
			grape_panel.setBackground(new Color(52, 121, 199));
			strawberry_panel.setBackground(new Color(52, 121, 199));
			orange_panel.setBackground(new Color(52, 121, 199));

			f.fileLoad();
			/* get user information about fruit */
			int number_apple = UserFile.Users.get(idx).getAppleRefri();
			int number_grape = UserFile.Users.get(idx).getGrapeRefri();
			int number_orange = UserFile.Users.get(idx).getOrangeRefri();
			int number_straw = UserFile.Users.get(idx).getStrawberryRefri();

			pushStack.setSize(this.getSize());
			pushStack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					add(apple_panel);
					add(grape_panel);
					add(orange_panel);
					add(strawberry_panel);
					pushStack.setVisible(false);
				}
			});

			this.add(pushStack);

			/* add fruit box name labels in panel */
			apple_panel.add(apple_lb);
			orange_panel.add(orange_lb);
			grape_panel.add(grape_lb);
			strawberry_panel.add(straw_lb);

			/* crate fruit button */
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

			} /* end of creating button */

			/* adding buttons in panel */
			// this.add(apple_panel);
			// this.add(grape_panel);
			// this.add(orange_panel);
			// this.add(strawberry_panel);

		}
	}

	/* Fruit Button CLASS */
	public class AppleButton extends JButton implements ActionListener {

		public AppleButton() {

			this.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			/* if guest not exist, no perform */
			if (!guestP1.isVisible() && !guestP2.isVisible() && !guestP3.isVisible() && !guestP4.isVisible()) {
				JOptionPane.showMessageDialog(juice_apple_button, "No guest ", "Title",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			/* if juice is already exist, no perform */
			if (juice_grape_button.isVisible() || juice_apple_button.isVisible() || juice_orange_button.isVisible()
					|| juice_straw_button.isVisible())
				return;

			/* setting juice price */
			juice_price = juice_price + 500;

			/* juice button appear */
			juice_apple_button.setVisible(true);

			/* user information change */
			changeImfo(2);

			/* fruit box button disappear */
			setVisible(false);

		}

	}

	public class OrangeButton extends JButton implements ActionListener {

		public OrangeButton() {

			this.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			/* if guest not exist, no perform */
			if (!guestP1.isVisible() && !guestP2.isVisible() && !guestP3.isVisible() && !guestP4.isVisible()) {
				JOptionPane.showMessageDialog(juice_orange_button, "No guest ", "Title",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			/* if juice is already exist, no perform */
			if (juice_grape_button.isVisible() || juice_apple_button.isVisible() || juice_orange_button.isVisible()
					|| juice_straw_button.isVisible())
				return;

			/* setting juice price */
			juice_price = juice_price + 700;

			/* juice button appear */
			juice_orange_button.setVisible(true);

			/* user information change */
			changeImfo(2);

			/* fruit box button disappear */
			setVisible(false);

		}

	}

	public class StrawButton extends JButton implements ActionListener {

		public StrawButton() {

			this.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			/* if guest not exist, no perform */
			if (!guestP1.isVisible() && !guestP2.isVisible() && !guestP3.isVisible() && !guestP4.isVisible()) {
				JOptionPane.showMessageDialog(juice_straw_button, "No guest ", "Title",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			/* if juice is already exist, no perform */
			if (juice_grape_button.isVisible() || juice_apple_button.isVisible() || juice_orange_button.isVisible()
					|| juice_straw_button.isVisible())
				return;

			/* setting juice price */
			juice_price = juice_price + 600;

			/* juice button appear */
			juice_straw_button.setVisible(true);

			/* user information change */
			changeImfo(2);

			/* fruit box button disappear */
			setVisible(false);

		}

	}

	public class GrapeButton extends JButton implements ActionListener {

		public GrapeButton() {
			this.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			/* if guest not exist, no perform */
			if (!guestP1.isVisible() && !guestP2.isVisible() && !guestP3.isVisible() && !guestP4.isVisible()) {
				JOptionPane.showMessageDialog(juice_grape_button, "No guest ", "Title",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			/* if juice is already exist, no perform */
			if (juice_grape_button.isVisible() || juice_apple_button.isVisible() || juice_orange_button.isVisible()
					|| juice_straw_button.isVisible())
				return;

			/* setting juice price */
			juice_price = juice_price + 500;

			/* juice button appear */
			juice_grape_button.setVisible(true);

			/* user information change */
			changeImfo(2);

			/* fruit box button disappear */
			setVisible(false);

		}

	}

	public class CartListener implements ActionListener {
		JFrame cartFrame = new JFrame();
		JPanel cartPanel = new JPanel();
		JPanel cartBPanel = new JPanel();
		Component cp;
		private JLabel[] APPLE_BOX = new JLabel[100];
		private JLabel[] GRAPE_BOX = new JLabel[100];
		private JLabel[] ORANGE_BOX = new JLabel[100];
		private JLabel[] STRAWBERRY_BOX = new JLabel[100];
		JButton aB, gB, oB, sB;
		JPanel apple_panel = new JPanel();
		JPanel grape_panel = new JPanel();
		JPanel strawberry_panel = new JPanel();
		JPanel orange_panel = new JPanel();
		private JLabel apple_lb, orange_lb, straw_lb, grape_lb;
		int cnA = -1;
		int cnG = -1;
		int cnO = -1;
		int cnS = -1;

		public CartListener() {
			cnA = -1;
			cnG = -1;
			cnO = -1;
			cnS = -1;
		}

		public void actionPerformed(ActionEvent arg0) {

			cartPanel.setBackground(new Color(52, 121, 199));
			cartFrame.setSize(350, 590);
			cartBPanel.setLayout(new GridLayout(1, 4));
			cartBPanel.setBackground(new Color(52, 121, 199));
			cartPanel.setLayout(new GridLayout(1, 4));
			cartPanel.setBackground(new Color(52, 121, 199));

			Font font = new Font("Dialog", Font.BOLD, 11);

			apple_lb = new JLabel("APPLE BOX");
			orange_lb = new JLabel("ORANGE BOX");
			straw_lb = new JLabel("STRAWBERRY BOX");
			grape_lb = new JLabel("GRAPE BOX");

			apple_lb.setFont(font);
			orange_lb.setFont(font);
			straw_lb.setFont(font);
			grape_lb.setFont(font);

			apple_panel.setLayout(new BoxLayout(apple_panel, BoxLayout.Y_AXIS));
			grape_panel.setLayout(new BoxLayout(grape_panel, BoxLayout.Y_AXIS));
			strawberry_panel.setLayout(new BoxLayout(strawberry_panel, BoxLayout.Y_AXIS));
			orange_panel.setLayout(new BoxLayout(orange_panel, BoxLayout.Y_AXIS));

			apple_panel.setBackground(new Color(52, 121, 199));
			grape_panel.setBackground(new Color(52, 121, 199));
			strawberry_panel.setBackground(new Color(52, 121, 199));
			orange_panel.setBackground(new Color(52, 121, 199));

			aB = new JButton();
			aB.setIcon(apple);
			aB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cnA++;
					if (UserFile.Users.get(idx).getApplebox() == 0) {
						JOptionPane.showMessageDialog(null, " 00You Put All Apple Boxes you have!", "Message",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						APPLE_BOX[cnA] = new JLabel();
						APPLE_BOX[cnA].setIcon(apple);
						apple_panel.add(APPLE_BOX[cnA]);
						UserFile.Users.get(idx).setApplebox(UserFile.Users.get(idx).getApplebox() - 1);
						UserFile.Users.get(idx).setAppleRefri(UserFile.Users.get(idx).getAppleRefri() + 1);
					}
					f.fileSave();
				}
			});
			cartBPanel.add(aB);
			gB = new JButton();
			gB.setIcon(grape);
			gB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cnG++;
					if (UserFile.Users.get(idx).getGrapebox() == 0) {
						JOptionPane.showMessageDialog(null, " 00You Put All Grape Boxes you have!", "Message",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						GRAPE_BOX[cnG] = new JLabel();
						GRAPE_BOX[cnG].setIcon(grape);
						grape_panel.add(GRAPE_BOX[cnG]);
						UserFile.Users.get(idx).setGrapebox(UserFile.Users.get(idx).getGrapebox() - 1);
						UserFile.Users.get(idx).setGrapeRefri(UserFile.Users.get(idx).getGrapeRefri() + 1);
					}
					f.fileSave();
				}
			});
			cartBPanel.add(gB);
			oB = new JButton();
			oB.setIcon(orange);
			oB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cnO++;
					if (UserFile.Users.get(idx).getOrangebox() == 0) {
						JOptionPane.showMessageDialog(null, " 00You Put All Orange Boxes you have!", "Message",
								JOptionPane.INFORMATION_MESSAGE);
					}else{	
						ORANGE_BOX[cnO] = new JLabel();
						ORANGE_BOX[cnO].setIcon(orange);
						orange_panel.add(ORANGE_BOX[cnO]);
						UserFile.Users.get(idx).setOrangebox(UserFile.Users.get(idx).getOrangebox() - 1);
						UserFile.Users.get(idx).setOrangeRefri(UserFile.Users.get(idx).getOrangeRefri() + 1);
					}
					f.fileSave();
				}
			});
			cartBPanel.add(oB);
			sB = new JButton();
			sB.setIcon(strawberry);
			sB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cnS++;
					if (UserFile.Users.get(idx).getStrawberrybox() == 0) {
						JOptionPane.showMessageDialog(null, " 00You Put All Strawberry Boxes you have!", "Message",
								JOptionPane.INFORMATION_MESSAGE);
					} else{
						STRAWBERRY_BOX[cnS] = new JLabel();
						STRAWBERRY_BOX[cnS].setIcon(strawberry);
						strawberry_panel.add(STRAWBERRY_BOX[cnS]);
						UserFile.Users.get(idx).setStrawberrybox(UserFile.Users.get(idx).getStrawberrybox() - 1);
						UserFile.Users.get(idx).setStrawberryRefri(UserFile.Users.get(idx).getStrawberryRefri() + 1);
					}
					f.fileSave();
				}
			});
			cartBPanel.add(sB);

			/* add fruit box name labels in panel */
			apple_panel.add(apple_lb);
			orange_panel.add(orange_lb);
			grape_panel.add(grape_lb);
			strawberry_panel.add(straw_lb);

			cartPanel.add(apple_panel);
			cartPanel.add(grape_panel);
			cartPanel.add(orange_panel);
			cartPanel.add(strawberry_panel);
			cartFrame.add(cartPanel);
			cartFrame.add(cartBPanel, BorderLayout.SOUTH);
			cartFrame.setVisible(true);
			cartFrame.setResizable(true);
			cartFrame.addWindowListener(new WindowAdapter() {
				public void windowClosingevent(WindowEvent e) {
					cartFrame.dispose();
					f.fileSave();
				}
			});
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			// 창을 중앙에 위치시킬 수 있다.
			int xPos = screenSize.width / 2 - cartFrame.getSize().width / 2;
			int yPos = screenSize.height / 2 - cartFrame.getSize().height / 2;
			cartFrame.setLocation(xPos - 300, yPos);
			cartFrame.invalidate();
			cartFrame.validate();
			cartFrame.repaint();
			f.fileSave();
		}
	}
}
