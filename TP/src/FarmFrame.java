import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//import HomeFrame.goback_listener;
//import Home.goback_listener;

public class FarmFrame extends JFrame {
	
	UserFile f = new UserFile();
	private int idx;
	
	public FarmFrame() {
		go_farm();
	}

	ImageIcon im;
	Container container;
	JList<String> list;
	JFrame frame_kind;
	JFrame frame_number;
//	JTextField tf;
	boolean isChoose;

	public void go_farm() {
		////////////
		container = this.getContentPane();
		container.setLayout(new BorderLayout());

		im = new ImageIcon("farm.png");
		JPanel back_ground = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(im.getImage(), 0, 0, null);

				g.setFont(new Font("serif", Font.BOLD, 28));
				g.drawString("Which Fruit do you want to get?", 25, 35);
			}
		};

		JButton gochoose = new JButton("Go to choose");
		gochoose.setFont(new Font("serif", Font.BOLD, 20));
		gochoose.addActionListener(new gochoose_listener());

		back_ground.add(gochoose);

		container.add(BorderLayout.CENTER, back_ground);
		// *

		// *

		JButton goback = new JButton("back to main");
		goback.addActionListener(new goback_listener());

		JPanel menupanel = new JPanel();

		container.add(BorderLayout.NORTH, menupanel);

		Font font = new Font("Dialog", Font.BOLD, 15); // 20은 글자 크기

        for(int i=0; i<UserFile.Users.size(); i++){
			if(UserFile.Users.get(i).getIndex()>-1) idx = i;
		}
		JLabel userID_label = new JLabel("U s e r   :   " + UserFile.Users.get(idx).getId());
		userID_label.setFont(font);

		JLabel userMONEY_label = new JLabel("           M o n e y   :   " + UserFile.Users.get(idx).getMoney());
		userMONEY_label.setFont(font);

		JLabel userLEVEL_label = new JLabel("           L e v e l   :   " + UserFile.Users.get(idx).getLevel());
		userLEVEL_label.setFont(font);
		
		JLabel userAPPLE_label = new JLabel(" 			A p p l e   :   "+UserFile.Users.get(idx).getApple());	
		userAPPLE_label.setFont(font);
		
		JLabel userGRAPE_label = new JLabel(" 			G r a p e   :   "+UserFile.Users.get(idx).getGrape());	
		userGRAPE_label.setFont(font);
		
		JLabel userORANGE_label = new JLabel(" 			O r a n g e   :   "+UserFile.Users.get(idx).getOrange());	
		userORANGE_label.setFont(font);
		
		JLabel userSTRAWBERRY_label = new JLabel(" 			S t r a w b e r r y   :   "+UserFile.Users.get(idx).getStrawBerry());	
		userSTRAWBERRY_label.setFont(font);
		
		JLabel enter = new JLabel("                      ");

		menupanel.add(userID_label);
		menupanel.add(userLEVEL_label);
		menupanel.add(userMONEY_label);
		menupanel.add(userAPPLE_label);
		menupanel.add(userGRAPE_label);
		menupanel.add(userORANGE_label);
		menupanel.add(userSTRAWBERRY_label);
		//menupanel.add(enter);
		menupanel.add(goback);
	}

	class goback_listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			setVisible(false);
		}
	}

	class gochoose_listener implements ActionListener, ListSelectionListener {
		public void actionPerformed(ActionEvent e) {
			frame_kind = new JFrame();
			frame_kind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

			int xPos = screenSize.width / 2 - 100;
			int yPos = screenSize.height / 2 - 220;

			list = new JList<String>(new String[] { "Apple", "Grape", "Orange", "Strawberry" });
			list.setVisibleRowCount(4);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.addListSelectionListener(this);
			list.setFont(new Font("Dialog", Font.BOLD, 15));
			
			
			JButton ok_btn = new JButton("Ok");
			ok_btn.addActionListener(new ok_listener());

			JButton close_btn = new JButton("Close");
			close_btn.addActionListener(new close_listener());

			
		//	tf = new JTextField(20);
			
			JLabel notice = new JLabel(" Choose one which you want");
			notice.setFont(new Font("Dialog",Font.BOLD,15));
			
			frame_kind.add(BorderLayout.NORTH, list);
			frame_kind.add(BorderLayout.WEST, ok_btn);
			frame_kind.add(BorderLayout.EAST, close_btn);
			frame_kind.add(BorderLayout.CENTER, notice);
	//		frame_kind.add(BorderLayout.SOUTH, tf);

			frame_kind.setSize(350, 250);
			frame_kind.setLocation(xPos, yPos);
			frame_kind.setVisible(true);
		}

		public void valueChanged(ListSelectionEvent e) {
			if (!list.getValueIsAdjusting()) {
				isChoose = true;
			}
		}
	}

	class ok_listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (isChoose == true) {	//숫자만 입력받도록 다시수정해야함
				UserFile.Users.get(idx).setFruit(list.getSelectedValue());
				FarmDisplay fd = new FarmDisplay();
				fd.go_game();
				frame_kind.setVisible(false);
				setVisible(false);
			} else
				JOptionPane.showMessageDialog(null, "MUST CHECK ONE", "ERROR", JOptionPane.ERROR_MESSAGE);
		}

	}

	class close_listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame_kind.setVisible(false);
		}
	}
}
	