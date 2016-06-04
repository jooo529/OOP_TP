import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.awt.*;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class StoreFrame extends JFrame {

	ImageIcon storeIm;
	ImageIcon fire;
	ImageIcon herb;
	ImageIcon water;
	ImageIcon tree;
	ImageIcon imim;
	private int idx;

	UserFile f = new UserFile();

	Image im;
	Container container;
	PopUpMarket MARKET = null;
	JLabel IMG;
	JButton market = new JButton();

	JLabel userAPPLE_label, userGRAPE_label, userORANGE_label, userSTRAWBERRY_label, userMONEY_label;

	int number_apple = 0;
	int number_orange = 0;
	int number_straw = 0;
	int number_grape = 0;

	int i;

	public StoreFrame() {
		go_store();

	}

	public void go_store() {
		////////////

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		container = this.getContentPane();
		// container.setLayout(new BorderLayout());

		storeIm = new ImageIcon("Store.png");
		// imim = new ImageIcon("button_fire.png");
		market.setText("SELL");

		market.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PopUpMarket a = new PopUpMarket();

			}
		});

		JPanel back_ground = new JPanel() {

			public void paintComponent(Graphics g) {
				g.drawImage(storeIm.getImage(), 0, 0, null);
				// g.drawImage( imim.getImage(), 50, 50, null);
			}
		};

		container.add(BorderLayout.CENTER, back_ground);

		market.setBackground(Color.red);

		market.setBounds(550, 150, 100, 100);
		back_ground.add(market);

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

		// JLabel enter = new JLabel(" ");

		menupanel.add(userID_label);
		menupanel.add(userLEVEL_label);
		menupanel.add(userMONEY_label);
		menupanel.add(userAPPLE_label);
		menupanel.add(userGRAPE_label);
		menupanel.add(userORANGE_label);
		menupanel.add(userSTRAWBERRY_label);

	}

	class goback_listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			setVisible(false);
		}
	}

	class PopUpMarket extends JFrame {

		JButton[] APPLE = new JButton[100];
		JButton[] GRAPE = new JButton[100];
		JButton[] ORANGE = new JButton[100];
		JButton[] STRAWBERRY = new JButton[100];

		ImageIcon apple;
		ImageIcon orange;
		ImageIcon strawberry;
		ImageIcon grape;

		public PopUpMarket() {

			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			// this.setBackground(Color.green);
			this.setSize(400, 800);
			
			Font font = new Font("Dialog", Font.BOLD, 12);

			JPanel menupanel2 = new JPanel();

			JButton goback = new JButton("back");
			JLabel price = new JLabel("\"PRICE\" APPLE: 500, ORANGE: 700, GRAPE: 800, STRAWBERRY: 600");
			price.setFont(font);
			
			goback.addActionListener(new quit_listener());
			menupanel2.add(userMONEY_label);
			menupanel2.add(goback);

			this.getContentPane().add(BorderLayout.NORTH, menupanel2);
			this.getContentPane().add(BorderLayout.SOUTH,price);

			apple = new ImageIcon("apple1.png");
			orange = new ImageIcon("orange.png");
			strawberry = new ImageIcon("strawberry.png");
			grape = new ImageIcon("grape.png");

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
			// TODO Auto-generated constructor stub
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
			// TODO Auto-generated constructor stub
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
			// TODO Auto-generated constructor stub
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
			// TODO Auto-generated constructor stub
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
