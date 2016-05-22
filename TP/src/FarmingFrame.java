import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.*;
import javax.swing.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class FarmingFrame extends JFrame{

	public FarmingFrame(){
		go_farming();
	}
	ImageIcon im;
	Container container;
	JList<String> list;
	
	public void go_farming() {	//선택받은 과일이 입력받은 갯수만큼 나타나는거 구현하기

		container = this.getContentPane();
		container.setLayout(new BorderLayout());

		im = new ImageIcon("farm.png");
		JPanel back_ground = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(im.getImage(), 0, 0, null);

				g.setFont(new Font("serif", Font.BOLD, 28));
				g.drawString("test", 25, 35);
			}
		};

		JButton gochoose = new JButton("Go to choose");
		gochoose.setFont(new Font("serif", Font.BOLD, 20));
//		gochoose.addActionListener(new gochoose_listener());

		back_ground.add(gochoose);

		container.add(BorderLayout.CENTER, back_ground);
		// *

		// *

		JButton goback = new JButton("back to main");
//		goback.addActionListener(new goback_listener());

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
		menupanel.add(goback);

	}

}