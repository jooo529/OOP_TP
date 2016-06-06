import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class HomeFrame extends JFrame {

	public HomeFrame() {
		//set frame's state
		this.setSize(1000,590);
		this.setTitle("Farming Game");
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(LoginFrame.DISPOSE_ON_CLOSE);
		
		//entire window's size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		//locate frame in center
		int xPos = screenSize.width/2 - this.getSize().width/2 ;
		int yPos = screenSize.height/2 - this.getSize().height/2 ;

		this.setLocation(xPos,yPos);
		
		this.go_home();
	}

	private UserFile f = new UserFile();
	private BufferedImage im_background;
	private ImageIcon tb;
	private JButton Exit = new JButton("Exit");
	private JButton character = new JButton();
	private Container container;
	private JPanel back_ground;
	private JPanel menupanel;
	private JButton goback;
	
	private Font font = new Font("Dialog", Font.BOLD, 15); // 20은 글자 크기
	
	static int idx = -1;
	
	public void go_home() {
		
		container = this.getContentPane();
		
		try {
			im_background = ImageIO.read(new File("HOME3.png")); //home background

		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e2){
			e2.printStackTrace();
		}
		
		
		tb = new ImageIcon("textBallon_click.png"); //NPC in home says
	

		back_ground = new JPanel() { //set image in Home
			public void paintComponent(Graphics g) {
				g.drawImage(im_background, 0, 0, 1000, 550, this);
				g.drawImage(tb.getImage(), 600, 150, null);
			}
		};

		back_ground.setLayout(null);
		container.add(BorderLayout.CENTER, back_ground);

		//to make image's background transparent, reference ->http://laonatti.net/196
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

		try{
			back_ground.add(character);
			back_ground.add(Exit);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		
		try{
			for (int i = 0; i < UserFile.Users.size(); i++) {
				if (UserFile.Users.get(i).getIndex() > -1)
					idx = i;
			}
		}
		catch(IndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}
		
		JLabel userID_label = new JLabel("U s e r   :   " + UserFile.Users.get(idx).getId());
		userID_label.setFont(font);

		JLabel userMONEY_label = new JLabel("           M o n e y   :   " + UserFile.Users.get(idx).getMoney());
		userMONEY_label.setFont(font);

		JLabel userLEVEL_label = new JLabel("           L e v e l   :   " + UserFile.Users.get(idx).getLevel());
		userLEVEL_label.setFont(font);

		JLabel enter = new JLabel("                      ");

		menupanel = new JPanel();
		try{
			menupanel.add(userID_label);
			menupanel.add(userLEVEL_label);
			menupanel.add(userMONEY_label);
			menupanel.add(enter);
			// menupanel.add(Exit);
			container.add(BorderLayout.NORTH, menupanel);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}

	}

	class button_listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			try{
				if (event.getSource() == character) {
					if(UserFile.Users.get(idx).getLevel()==0){
						JOptionPane.showMessageDialog(null, "You met Mom! LEVEL UP!", "Message", JOptionPane.INFORMATION_MESSAGE);
						UserFile.Users.get(idx).setLevel(1);
						f.fileSave();
					}
					NpcFrame np = new NpcFrame();
				} else if (event.getSource() == Exit) {
					f.fileSave();
					setVisible(false);
					MainDisplay md = new MainDisplay();
					md.go();
				}
			}
			catch(IndexOutOfBoundsException e){
				e.printStackTrace();	
			}
			catch(HeadlessException e2){
				e2.printStackTrace();
			}

		}
	}


}