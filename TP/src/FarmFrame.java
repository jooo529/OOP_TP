import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class FarmFrame extends JFrame {
	
	UserFile f = new UserFile();
	
	private int idx;
	
	public FarmFrame() {
		go_farm();
	}

	ImageIcon[] im3,im4; 
	Container container;
	JList<String> list;
	JFrame frame_kind, frame_number, frame_help;
	JPanel fruit_image,rotten_image;
	Timer tmr;
	boolean isChoose,isClose;
	int index;
	
	ImageIcon i1,i2,i3,i4,im,
			  i3_apple,i3_orange,i3_grape,i3_strawberry,
			  i4_apple,i4_orange,i4_grape,i4_strawberry;

	public void go_farm() {
		////////////
		container = this.getContentPane();
		container.setLayout(new BorderLayout());

		im = new ImageIcon("farm.png");
		JPanel back_ground = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(im.getImage(), 0, 0, null);

//				g.setFont(new Font("serif", Font.BOLD, 28));
//				g.drawString("Which Fruit do you want to get?", 25, 35);
			}
		};

		JLabel which = new JLabel("Which Fruit do you want to get?");
		which.setFont(new Font("serif",Font.BOLD,28));
		
		JButton gochoose = new JButton("Go to choose");
		gochoose.setFont(new Font("serif", Font.BOLD, 20));
		gochoose.addActionListener(new gochoose_listener());
		
		JButton help = new JButton("Help");
		help.setFont(new Font("serif",Font.BOLD,20));
		help.addActionListener(new help_listener());
		
		back_ground.add(which);
		back_ground.add(gochoose);
		back_ground.add(new JLabel("                                                      "));
		back_ground.add(help);

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

		JLabel userLEVEL_label = new JLabel("           L e v e l   :   " + UserFile.Users.get(idx).getLevel() + "    ");
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
		menupanel.add(userAPPLE_label);
		menupanel.add(userGRAPE_label);
		menupanel.add(userORANGE_label);
		menupanel.add(userSTRAWBERRY_label);
		menupanel.add(goback);
	}

	class goback_listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			setVisible(false);
		}
	}

	class gochoose_listener implements ActionListener, ListSelectionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(UserFile.Users.get(idx).isHave_box()){
				frame_kind = new JFrame("Choose one fruit!");
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
			else
				JOptionPane.showMessageDialog(null,"You don't have Box!\nGo to main and get Boxes","Box Error", JOptionPane.ERROR_MESSAGE);
		}

		public void valueChanged(ListSelectionEvent e) {
			if (!list.getValueIsAdjusting()) {
				isChoose = true;
			}
		}
	}
	
	class help_listener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			frame_help = new JFrame("Explanation about Farming");
			JPanel panel_help = new JPanel();
			panel_help.setLayout(new BoxLayout(panel_help,BoxLayout.Y_AXIS));
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			
			int xPos = screenSize.width / 2 - 100;
			int yPos = screenSize.height / 2 - 220;
			
			JLabel lbl_help = new JLabel("Each Image change automatically in random time");
			lbl_help.setFont(new Font("serif",Font.BOLD,25));
			
			i1 = new ImageIcon("first.png");
			i2= new ImageIcon("Second.png");
			i3_apple = new ImageIcon("apple.png");
			i3_orange = new ImageIcon("orange_jy.png");
			i3_grape = new ImageIcon("grape_jy.png");
			i3_strawberry = new ImageIcon("strawberry_jy.png");
			i4_apple = new ImageIcon("appleRotten.png");
			i4_orange = new ImageIcon("orangeRotten_jy.png");
			i4_grape = new ImageIcon("grapeRotten_jy.png");
			i4_strawberry = new ImageIcon("strawberryRotten_jy.png");
			
			im3 = new ImageIcon[4];
			im4 = new ImageIcon[4];
			im3[0] = i3_apple;	im3[1] = i3_orange;		im3[2]=i3_grape;	im3[3]=i3_strawberry;
			im4[0] = i4_apple;	im4[1] = i4_orange;		im4[2]=i4_grape;	im4[3]=i4_strawberry;
			
			index=1;
			
			tmr = new Timer();
			
			TimerTask task = new TimerTask(){

				@Override
				public void run() {
					if(isClose)tmr.cancel();
					
					if(index==4)	index =0;
					i3 = im3[index];
					i4=im4[index];
					index++;
					fruit_image.repaint();
					rotten_image.repaint();
				}
				
			};
			
			i3=im3[0];	i4=im4[0];
			tmr.schedule(task,3000, 3000);
			
			
			JPanel first_image = new JPanel(){
				public void paintComponent(Graphics g){
					g.drawImage(i1.getImage(),0,0,null);
					
					g.setFont(new Font("serif", Font.BOLD, 18));
					g.drawString("This is the first image", 365,35);
					g.drawString("Just seeds are in the ground!",365,55);
					g.drawString("So No changes if you click this image", 365,95);
				}
			};
			JPanel second_image = new JPanel(){
				public void paintComponent(Graphics g){
					g.drawImage(i2.getImage(),0,0,null);
					
					g.setFont(new Font("serif", Font.BOLD, 18));
					g.drawString("This is the second image", 365, 35);
					g.drawString("Just small tree grow!",365,55);
					g.drawString("So No changes if you click this image",365,95);
				}
			};
			fruit_image = new JPanel(){
				public void paintComponent(Graphics g){
					g.drawImage(i3.getImage(), 0,0,null);
					
					g.setFont(new Font("serif", Font.BOLD, 18));
					g.drawString("This is the third image", 365, 35);
					g.drawString("Great Fruit is ready to be harvested!",365,55);
					g.drawString("So Plus your number of fruit",365,95);
					g.drawString("if you click this image", 365,115);
				}
			};
			rotten_image = new JPanel(){
				public void paintComponent(Graphics g){
					g.drawImage(i4.getImage(), 0, 0, null);
			
					g.setFont(new Font("serif", Font.BOLD, 18));
					g.drawString("This is the last image", 365, 35);
					g.drawString("It's Rotten as you don't harvest for 8 seconds!",365,55);
					g.drawString("So Minus your number of fruit",365,95);
					g.drawString("if you click this image", 365,115);
				}
			};
			JButton close_btn = new JButton("Close");
			close_btn.addActionListener(new close_btn_listener());
			
			
			panel_help.add(lbl_help);
			panel_help.add(first_image);
			panel_help.add(second_image);
			panel_help.add(fruit_image);
			panel_help.add(rotten_image);
			
			panel_help.add(close_btn);
			
			frame_help.add(panel_help);
			frame_help.setSize(750, 700);
			frame_help.setLocation(xPos, yPos);
			frame_help.setVisible(true);
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
	class close_btn_listener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			isClose = true;
			frame_help.setVisible(false);
		}
	}
}
	