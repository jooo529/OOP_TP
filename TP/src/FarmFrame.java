import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;
import javax.swing.event.*;

public class FarmFrame extends GameFrame {

	public FarmFrame() {
		UserFile.Users.get(idx).setFruit(null);
		go_farm();
	}
/*----------Declare Global Variable----------*/
	ImageIcon[] im3, im4;
	Container container;
	JList<String> list;
	JFrame frame_kind, frame_number, frame_help;
	JPanel fruit_image, rotten_image;
	Timer tmr;
	boolean isClose;
	int index;
	ImageIcon i1, i2, i3, i4, im, i3_apple, i3_orange, i3_grape, i3_strawberry, i4_apple, i4_orange, i4_grape,
			i4_strawberry;
/*--------------------------------------------*/
	public void go_farm() {
		container = this.getContentPane();
		container.setLayout(new BorderLayout());
		im = new ImageIcon("farm.png");
		
		/* Create Background */
		JPanel back_ground = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(im.getImage(), 0, 0, null);
			}
		};
		/*-------------------*/
		getUserIdx();			
		/*-------------Add Label & 2 Buttons in Background----------*/
		JLabel which = new JLabel("Which Fruit do you want to get?");
		which.setFont(new Font("serif", Font.BOLD, 28));

		JButton gochoose = new JButton("Go to choose");
		gochoose.setFont(new Font("serif", Font.BOLD, 20));
		gochoose.addActionListener(new gochoose_listener());

		JButton help = new JButton("Help");
		help.setFont(new Font("serif", Font.BOLD, 20));
		help.addActionListener(new help_listener());

		back_ground.add(which);
		back_ground.add(gochoose);
		back_ground.add(new JLabel("                                                      "));
		back_ground.add(help);

		container.add(BorderLayout.CENTER, back_ground);
		/*-------------------------------------------------------------*/
		
		/*------ Create MenuPanel located in the North ----------*
		 * which has Information about User and Button to go Back*/
		JButton goback = new JButton("back to main");
		goback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		JPanel menupanel = userImfoPane(1);
		menupanel.add(goback);

		container.add(BorderLayout.NORTH, menupanel);
		/*-----------------------------------------*/
	}
	
	class gochoose_listener implements ActionListener{		//Click Button "Go to choose"
		Boolean isChoose = false;
		public void actionPerformed(ActionEvent e) {
			frame_kind = new JFrame("Choose one fruit!");
			/* Set the Location in Center where Frame appears */
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

			int xPos = screenSize.width / 2 - 175;
			int yPos = screenSize.height / 2 - 125;
			/*------------------------------------------------*/
			/* ----------------------------Create 4 Fruits List------------------------------ */
			list = new JList<String>(new String[] { "Apple", "Grape", "Orange", "Strawberry" });
			list.setVisibleRowCount(4);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setFont(new Font("Dialog", Font.BOLD, 15));
			list.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) {	//Setting Fruit
					UserFile.Users.get(idx).setFruit(list.getSelectedValue());
				}
			});
			/*--------------------------------------------------------------------------------*/
			
			JButton ok_btn = new JButton("Ok");
			ok_btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	// Click Button "Ok"
					if(UserFile.Users.get(idx).getFruit()==null) isChoose=false;
					else isChoose=true;
					if (isChoose) {		//Select Anything in List
						FarmDisplay fd = new FarmDisplay();
						fd.go_game();
						frame_kind.setVisible(false);
						setVisible(false);
					} else				//Select Nothing in List
						JOptionPane.showMessageDialog(null, "MUST CHECK ONE", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			});
			
			JButton close_btn = new JButton("Close");
			close_btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	// Click Button "Close"
					UserFile.Users.get(idx).setFruit(null);
					frame_kind.setVisible(false);
				}
			});
			
			JLabel notice = new JLabel(" Choose one which you want");
			notice.setFont(new Font("Dialog", Font.BOLD, 15));
			/* Add Components to the Frame & Appear Frame */
			frame_kind.add(BorderLayout.NORTH, list);
			frame_kind.add(BorderLayout.WEST, ok_btn);
			frame_kind.add(BorderLayout.EAST, close_btn);
			frame_kind.add(BorderLayout.CENTER, notice);
			
			frame_kind.setSize(350, 250);
			frame_kind.setLocation(xPos, yPos);
			frame_kind.setVisible(true);
			/*----------------------------*/
		}
	}

	class help_listener implements ActionListener {				// Click Button "Help"

		public void actionPerformed(ActionEvent arg0) {
			
			frame_help = new JFrame("Explanation about Farming");
			JPanel panel_help = new JPanel();
			panel_help.setLayout(new BoxLayout(panel_help, BoxLayout.Y_AXIS));
			frame_help.setResizable(false);		// Cannot change the size
			frame_help.setSize(750, 700);		
			frame_help.setVisible(true);
			/* -------Set the Location in Center where Frame appears-------- */
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

			int xPos = screenSize.width / 2 - frame_help.getSize().width / 2;
			int yPos = screenSize.height / 2 - frame_help.getSize().height / 2;
			/*----------------------------------------------------------------*/
			JLabel lbl_help = new JLabel("Each Image change automatically in random time");
			lbl_help.setFont(new Font("serif", Font.BOLD, 25));
			
			/*------------Create an Object of ImageIcon--------------*/
			i1 = new ImageIcon("first.png");
			i2 = new ImageIcon("Second.png");
			i3_apple = new ImageIcon("apple.png");
			i3_orange = new ImageIcon("orange_jy.png");
			i3_grape = new ImageIcon("grape_jy.png");
			i3_strawberry = new ImageIcon("strawberry_jy.png");
			i4_apple = new ImageIcon("appleRotten.png");
			i4_orange = new ImageIcon("orangeRotten_jy.png");
			i4_grape = new ImageIcon("grapeRotten_jy.png");
			i4_strawberry = new ImageIcon("strawberryRotten_jy.png");
			/*------Put ImageIcon in Array to be easy to handle-------*/
			im3 = new ImageIcon[4];		// 		  Fruit ImageIcon Array
			im4 = new ImageIcon[4];		// Rotten Fruit ImageIcon Array
			im3[0] = i3_apple;
			im3[1] = i3_orange;
			im3[2] = i3_grape;
			im3[3] = i3_strawberry;
			im4[0] = i4_apple;
			im4[1] = i4_orange;
			im4[2] = i4_grape;
			im4[3] = i4_strawberry;
			/*-------------------------------------------------------*/
			index = 1;

			tmr = new Timer();

			TimerTask task = new TimerTask() {	// Rotate Image

				@Override
				public void run() {
					if (isClose)
						tmr.cancel();

					if (index == 4)
						index = 0;
					i3 = im3[index];
					i4 = im4[index];
					index++;
					fruit_image.repaint();
					rotten_image.repaint();
				}

			};

			i3 = im3[0];
			i4 = im4[0];
			tmr.schedule(task, 3000, 3000);		// Do task Every 3 seconds

			JPanel first_image = new JPanel() {
				public void paintComponent(Graphics g) {
					g.drawImage(i1.getImage(), 0, 0, null);

					g.setFont(new Font("serif", Font.BOLD, 18));	
					g.drawString("This is the first image", 365, 35);
					g.drawString("Just seeds are in the ground!", 365, 55);
					g.drawString("So No changes if you click this image", 365, 95);
				}
			};
			JPanel second_image = new JPanel() {
				public void paintComponent(Graphics g) {
					g.drawImage(i2.getImage(), 0, 0, null);

					g.setFont(new Font("serif", Font.BOLD, 18));
					g.drawString("This is the second image", 365, 35);
					g.drawString("Just small tree grow!", 365, 55);
					g.drawString("So No changes if you click this image", 365, 95);
				}
			};
			fruit_image = new JPanel() {
				public void paintComponent(Graphics g) {
					g.drawImage(i3.getImage(), 0, 0, null);

					g.setFont(new Font("serif", Font.BOLD, 18));
					g.drawString("This is the third image", 365, 35);
					g.drawString("Great Fruit is ready to be harvested!", 365, 55);
					g.drawString("So Plus your number of fruit", 365, 95);
					g.drawString("if you click this image", 365, 115);
				}
			};
			rotten_image = new JPanel() {
				public void paintComponent(Graphics g) {
					g.drawImage(i4.getImage(), 0, 0, null);

					g.setFont(new Font("serif", Font.BOLD, 18));
					g.drawString("This is the last image", 365, 35);
					g.drawString("It's Rotten as you don't harvest for 8 seconds!", 365, 55);
					g.drawString("So Minus your number of fruit", 365, 95);
					g.drawString("if you click this image", 365, 115);
				}
			};
			JButton close_btn = new JButton("Close");
			close_btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					isClose = true;
					frame_help.setVisible(false);
				}
			});
			
			/* Add Components to the Pannel & Add that Panel to the Frame */
			panel_help.add(lbl_help);
			panel_help.add(first_image);
			panel_help.add(second_image);
			panel_help.add(fruit_image);
			panel_help.add(rotten_image);

			panel_help.add(close_btn);
			
			frame_help.add(panel_help);
			frame_help.setLocation(xPos, yPos);

		}

	}
}
