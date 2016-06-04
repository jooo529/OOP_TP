import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class HomeFrame extends JFrame {

	public HomeFrame() {
		go_home();
	}

	UserFile f = new UserFile();
	BufferedImage im_background;
	private ImageIcon tb;
	JButton Exit = new JButton("Exit");
	JButton character = new JButton();
	Container container;
	static int idx = -1;
	
	public void go_home() {
		try {
			im_background = ImageIO.read(new File("HOME3.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		tb = new ImageIcon("textBallon_click.png");
		container = this.getContentPane();

		JPanel back_ground = new JPanel() {
			public void paintComponent(Graphics g) {

				g.drawImage(im_background, 0, 0, 1000, 550, this);
				g.drawImage(tb.getImage(), 600, 150, null);

			}
		};

		back_ground.setLayout(null);
		container.add(BorderLayout.CENTER, back_ground);

		Exit = new JButton("Exit");

		Exit.setContentAreaFilled(false);
		Exit.setDefaultCapable(false);
		Exit.setFocusPainted(false);
		Exit.setToolTipText("exit");
		Exit.setOpaque(false);
		Exit.setIcon(new ImageIcon("button_exit.png"));
		Exit.setRolloverIcon(new ImageIcon("button_exit_s.png"));
		Exit.setBackground(null);
		Exit.setBorderPainted(false);

		Exit.setBounds(900, 400, 60, 60);
		Exit.addActionListener(new button_listener());

		character.setContentAreaFilled(false);
		character.setDefaultCapable(false);
		character.setFocusPainted(false);
		character.setToolTipText("NPC CLICK");
		character.setIcon(new ImageIcon("mom_stand.png"));
		character.setRolloverIcon(new ImageIcon("mom_stand_c.png"));
		character.setBorderPainted(false);
		character.addActionListener(new button_listener());
		character.setBounds(550, 150, 110, 300);
		character.setOpaque(false);

		back_ground.add(character);
		back_ground.add(Exit);

		JPanel menupanel = new JPanel();

		Font font = new Font("Dialog", Font.BOLD, 15); // 20은 글자 크기

		JButton goback = new JButton("back to main");

		for (int i = 0; i < UserFile.Users.size(); i++) {
			if (UserFile.Users.get(i).getIndex() > -1)
				idx = i;
		}
		JLabel userID_label = new JLabel("U s e r   :   " + UserFile.Users.get(idx).getId());
		userID_label.setFont(font);

		JLabel userMONEY_label = new JLabel("           M o n e y   :   " + UserFile.Users.get(idx).getMoney());
		userMONEY_label.setFont(font);

		JLabel userLEVEL_label = new JLabel("           L e v e l   :   " + UserFile.Users.get(idx).getLevel());
		userLEVEL_label.setFont(font);

		JLabel enter = new JLabel("                      ");

		menupanel.add(userID_label);
		menupanel.add(userLEVEL_label);
		menupanel.add(userMONEY_label);
		menupanel.add(enter);
		// menupanel.add(Exit);
		container.add(BorderLayout.NORTH, menupanel);

	}

	class button_listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			if (event.getSource() == character) {
				if(UserFile.Users.get(idx).getLevel()==0){
					JOptionPane.showMessageDialog(null, "You met Mom! LEVEL UP!", "Message", JOptionPane.INFORMATION_MESSAGE);
					UserFile.Users.get(idx).setLevel(1);
					f.fileSave();
				}
				NpcDisplay npc = new NpcDisplay();
				npc.go();
			} else if (event.getSource() == Exit) {
				f.fileSave();
				setVisible(false);
			}

		}
	}


}