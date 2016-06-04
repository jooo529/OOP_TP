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
import javax.swing.JPanel;

public class StoreFrame extends JFrame {

	private ImageIcon storeIm;
	private int idx;

	private UserFile f = new UserFile();

	private Container container;
	private ImageIcon Sale = new ImageIcon("Sale_button.png");
	private JButton market = new JButton();
	private JButton go_back = new JButton();

	JLabel userAPPLE_label, userGRAPE_label, userORANGE_label, userSTRAWBERRY_label, userMONEY_label;

	private int number_apple = 0;
	private int number_orange = 0;
	private int number_straw = 0;
	private int number_grape = 0;

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

		storeIm = new ImageIcon("Store.png");
		market.setIcon(Sale);
		market.setContentAreaFilled(false);
		market.setDefaultCapable(false);
		market.setFocusPainted(false);
		market.setOpaque(false);
		market.setRolloverIcon(new ImageIcon("Sale_button_s.png"));
		market.setBackground(null);
		market.setBorderPainted(false);

		go_back.setContentAreaFilled(false);
		go_back.setDefaultCapable(false);
		go_back.setFocusPainted(false);
		go_back.setOpaque(false);
		go_back.setIcon(new ImageIcon("button_exit.png"));
		go_back.setRolloverIcon(new ImageIcon("button_exit_s.png"));
		go_back.setBackground(null);
		go_back.setBorderPainted(false);
		go_back.addActionListener(new goback_listener());

		market.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PopUpMarket a = new PopUpMarket();

			}
		});

		JPanel back_ground = new JPanel() {

			public void paintComponent(Graphics g) {
				g.drawImage(storeIm.getImage(), 0, 0, this);
			}
		};

		back_ground.setLayout(null);
		container.add(BorderLayout.CENTER, back_ground);
		
		go_back.setBounds(900, 400, 60, 60);
		market.setBounds(405, 310, Sale.getIconWidth(), Sale.getIconHeight());

		back_ground.add(market);
		back_ground.add(go_back);

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

	class PopUpMarket extends JFrame {

		private JButton[] APPLE = new JButton[100];
		private JButton[] GRAPE = new JButton[100];
		private JButton[] ORANGE = new JButton[100];
		private JButton[] STRAWBERRY = new JButton[100];

		private ImageIcon apple;
		private ImageIcon orange;
		private ImageIcon strawberry;
		private ImageIcon grape;
		private ImageIcon exit;

		public PopUpMarket() {

			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(400, 800);

			Font font = new Font("Dialog", Font.BOLD, 12);
			Font font2 = new Font("Dialog", Font.BOLD, 15);

			apple = new ImageIcon("apple1.png");
			orange = new ImageIcon("orange.png");
			strawberry = new ImageIcon("strawberry.png");
			grape = new ImageIcon("grape.png");

			JPanel menupanel2 = new JPanel();

			JButton goback = new JButton();
			goback.setContentAreaFilled(false);
			goback.setDefaultCapable(false);
			goback.setFocusPainted(false);
			goback.setOpaque(false);
			goback.setIcon(new ImageIcon("button_exit.png"));
			goback.setRolloverIcon(new ImageIcon("button_exit_s.png"));
			goback.setBackground(null);
			goback.setBorderPainted(false);
			goback.addActionListener(new quit_listener());

			JLabel price = new JLabel("\"PRICE\" APPLE: 500, ORANGE: 700, GRAPE: 800, STRAWBERRY: 600");
			price.setFont(font);

			JLabel sell = new JLabel("  Click fruit");
			sell.setFont(font2);

			menupanel2.add(sell);
			menupanel2.add(userMONEY_label);
			menupanel2.add(goback);

			this.getContentPane().add(BorderLayout.NORTH, menupanel2);
			this.getContentPane().add(BorderLayout.SOUTH, price);

			JPanel west = new JPanel();
			JPanel east = new JPanel();
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

			west.add(BorderLayout.WEST, apple_panel);
			west.add(BorderLayout.EAST, grape_panel);

			east.add(BorderLayout.WEST, orange_panel);
			east.add(BorderLayout.EAST, strawberry_panel);

			this.getContentPane().add(BorderLayout.WEST, west);
			this.getContentPane().add(BorderLayout.EAST, east);

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

			UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney() + 500);
			UserFile.Users.get(idx).setApple(UserFile.Users.get(idx).getApple() - 1);
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
			UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney() + 700);
			UserFile.Users.get(idx).setOrange((UserFile.Users.get(idx).getOrange() - 1));
			changeImfo();
			setVisible(false);

		}

	}

	public class StrawButton extends JButton implements ActionListener {

		public StrawButton() {

			this.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney() + 600);
			UserFile.Users.get(idx).setStrawBerry(UserFile.Users.get(idx).getStrawBerry() - 1);
			changeImfo();
			setVisible(false);

		}

	}

	public class GrapeButton extends JButton implements ActionListener {

		public GrapeButton() {
			this.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			UserFile.Users.get(idx).setMoney(UserFile.Users.get(idx).getMoney() + 800);
			UserFile.Users.get(idx).setGrape(UserFile.Users.get(idx).getGrape() - 1);
			changeImfo();
			setVisible(false);

		}

	}

}
