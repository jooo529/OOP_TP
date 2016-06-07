import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends GameFrame{


	MissionFile mf = new MissionFile();
	User u = new User();
	
	public MainFrame(){
		go_main();
	}
	
	ImageIcon im;
	JFrame fr;
	
	public String toUserInfo() {
        getUserIdx();
        String userInfo = " -- [ ID = " + UserFile.Users.get(idx).getId() + ","
        		+ " Money = " + UserFile.Users.get(idx).getMoney()
				+ ", Level = " + UserFile.Users.get(idx).getLevel() + " ]  -- ";  
		return userInfo;
	}

	
	public void go_main() {
		
		JButton farm_button = new JButton();
		farm_button.setContentAreaFilled(false);
		farm_button.setDefaultCapable(false);
		farm_button.setFocusPainted(false);
		farm_button.setOpaque(false);
		farm_button.setIcon(new ImageIcon("farmicon.png"));
		farm_button.setRolloverIcon(new ImageIcon("farmicon_s.png"));
		farm_button.setBackground(null);
		farm_button.setBorderPainted(false);
		farm_button.setBounds(470, 360, 244, 148);
		farm_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				//setVisible(false);
				UserFile.Users.get(idx).setFruit(null);
				FarmDisplay farm = new FarmDisplay();
				farm.go();
			}
		});
		
		JButton home_button = new JButton("Home");
		home_button.setContentAreaFilled(false);
		home_button.setDefaultCapable(false);
		home_button.setFocusPainted(false);
		home_button.setOpaque(false);
		home_button.setIcon(new ImageIcon("homeicon.png"));
		home_button.setRolloverIcon(new ImageIcon("homeicon_s.png"));
		home_button.setBackground(null);
		home_button.setBorderPainted(false);
		home_button.setBounds(525, 30, 200, 190);
		home_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				setVisible(false);
				HomeFrame hf = new HomeFrame();
			}
		});

		JButton store_button = new JButton("Store");
		store_button.setContentAreaFilled(false);
		store_button.setDefaultCapable(false);
		store_button.setFocusPainted(false);
		store_button.setOpaque(false);
		store_button.setIcon(new ImageIcon("storeicon.png"));
		store_button.setRolloverIcon(new ImageIcon("storeicon_s.png"));
		store_button.setBackground(null);
		store_button.setBorderPainted(false);
		store_button.setBounds(210, 120, 200, 190);
		store_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				setVisible(false);
				StoreDisplay store = new StoreDisplay();
				store.go();
			}
		});
		
		JButton box_button = new JButton();
		box_button.setContentAreaFilled(false);
		box_button.setDefaultCapable(false);
		box_button.setFocusPainted(false);
		box_button.setOpaque(false);
		box_button.setIcon(new ImageIcon("boxes.png"));
		box_button.setRolloverIcon(new ImageIcon("boxes_c.png"));
		box_button.setBackground(null);
		box_button.setBorderPainted(false);
		box_button.setBounds(50, 300, 188, 158);
		box_button.addActionListener(new BoxButtonListener());
		
		JTextArea missionInfo = new JTextArea();
		missionInfo.setBounds(735, 48, 250, 370);
		missionInfo.setEditable(false);

		JTextField userInfo = new JTextField(toUserInfo(), JLabel.CENTER);
		Font font = new Font("Kristen ITC", Font.BOLD, 14);
		userInfo.setFont(font);
		userInfo.setEditable(false);
		userInfo.setBounds(633, 13, 352, 30);
		userInfo.setBackground(Color.BLACK);
		userInfo.setForeground(Color.ORANGE);
		
		Font font2 = new Font("Kristen ITC", Font.BOLD, 12);
		missionInfo.setFont(font2);
		missionInfo.setEditable(false);
		missionInfo.setLineWrap(true);
		
		if (UserFile.Users.get(idx).getLevel() == 0)	missionInfo.setText(mf.fileLoad("Mission0.txt"));
		else if (UserFile.Users.get(idx).getMissionNum() == 1)	
			missionInfo.setText(UserFile.Users.get(idx).getMission()+"\n--------------\n"+mf.fileLoad("Mission1.txt"));
		else if (UserFile.Users.get(idx).getMissionNum() == 2)
			missionInfo.setText(UserFile.Users.get(idx).getMission()+"\n--------------\n"+mf.fileLoad("Mission2.txt"));
		else if (UserFile.Users.get(idx).getMissionNum() == 3)
			missionInfo.setText(UserFile.Users.get(idx).getMission()+"\n--------------\n"+mf.fileLoad("Mission3.txt"));
		else if (UserFile.Users.get(idx).getMissionNum() == 4)
			missionInfo.setText(UserFile.Users.get(idx).getMission()+"\n--------------\n"+mf.fileLoad("Mission4.txt"));
		else if (UserFile.Users.get(idx).getMissionNum() == 5)
			missionInfo.setText(UserFile.Users.get(idx).getMission()+"\n--------------\n"+mf.fileLoad("Mission5.txt"));
		else missionInfo.setText("You aren't going on Mission. Get Mission!");
		
		JButton quit_button = new JButton("Save and Quit");
		quit_button.setBounds(735, 450, 250, 80);
		quit_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				for(int i=0; i<UserFile.Users.size(); i++){
					//UserFile.Users.get(i).setMissionNum(0);
					UserFile.Users.get(i).setIndex(-1);
					f.fileSave();
				}
				System.exit(0);
			}
		});
				
		getContentPane().add(farm_button);
		getContentPane().add(home_button);
		getContentPane().add(store_button);
		getContentPane().add(box_button);
		getContentPane().add(quit_button);
		getContentPane().add(missionInfo);
		getContentPane().add(userInfo);
	
		im = new ImageIcon("main.png");
		JPanel back_ground = new JPanel(){ 
		 public void paintComponent(Graphics g) {
             g.drawImage(im.getImage(), 0, 0, null); 
        }};
      
        add(BorderLayout.CENTER,back_ground);
		
	}
	
	class BoxButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event)
		{
			fr = new JFrame("Make Fruit Box!");
			fr.setLayout(new BorderLayout());
			
			
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int xPos = screenSize.width / 2 - 350;
			int yPos = screenSize.height / 2 - 190;
			
			JPanel mn = new JPanel();
			mn.add(new JLabel("apple: "+UserFile.Users.get(idx).getApple()+" "));
			mn.add(new JLabel("apple box: "+UserFile.Users.get(idx).getApplebox()+" "));
			mn.add(new JLabel("grape: "+UserFile.Users.get(idx).getGrape()+" "));
			mn.add(new JLabel("grape box: "+UserFile.Users.get(idx).getGrapebox()+" "));
			mn.add(new JLabel("orange: "+UserFile.Users.get(idx).getOrange()+" "));
			mn.add(new JLabel("orange box: "+UserFile.Users.get(idx).getOrangebox()+" "));
			mn.add(new JLabel("strawberry: "+UserFile.Users.get(idx).getStrawBerry()+" "));
			mn.add(new JLabel("strawberry box: "+UserFile.Users.get(idx).getStrawberrybox()+" "));
			
			
			JPanel pn = new JPanel();
			pn.setLayout(new GridLayout(2,2));
			
			JButton appleBox = new JButton(){
				public void paintComponent(Graphics g){
					g.drawImage(new ImageIcon("apple.png").getImage(), 0,0, null);
				}
			};
			JButton grapeBox = new JButton(){
				public void paintComponent(Graphics g){
					g.drawImage(new ImageIcon("grape_jy.png").getImage(),0,0,null);
				}
			};
			JButton orangeBox = new JButton(){
				public void paintComponent(Graphics g){
					g.drawImage(new ImageIcon("orange_jy.png").getImage(), 0,0, null);
				}
			};
			JButton strawberryBox = new JButton(){
				public void paintComponent(Graphics g){
					g.drawImage(new ImageIcon("strawberry_jy.png").getImage(),0,0,null);
				}
			};
			
			appleBox.addActionListener(new appleBoxListener());
			grapeBox.addActionListener(new grapeBoxListener());
			orangeBox.addActionListener(new orangeBoxListener());
			strawberryBox.addActionListener(new strawberryBoxListener());
			
			pn.add(appleBox);
			pn.add(grapeBox);
			pn.add(orangeBox);
			pn.add(strawberryBox);
			
			fr.add(mn, BorderLayout.NORTH);
			fr.add(pn,BorderLayout.CENTER);
			fr.setSize(700, 380);
			fr.setLocation(xPos, yPos);
			fr.setVisible(true);
			f.fileSave();
		}
	}
	class appleBoxListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(UserFile.Users.get(idx).getApple()>=4){
				UserFile.Users.get(idx).setApple(UserFile.Users.get(idx).getApple()-4);
				UserFile.Users.get(idx).setApplebox(UserFile.Users.get(idx).getApplebox()+1);
				fr.setVisible(false);
			}else{
				JOptionPane.showMessageDialog(null, "TO MAKE APPLE BOX,\nYOU NEED AT LEAST 4 APPLES", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	class grapeBoxListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(UserFile.Users.get(idx).getGrape()>=2){
				UserFile.Users.get(idx).setGrape(UserFile.Users.get(idx).getGrape()-2);
				UserFile.Users.get(idx).setGrapebox(UserFile.Users.get(idx).getGrapebox()+1);
				fr.setVisible(false);
			}else{
				JOptionPane.showMessageDialog(null, "TO MAKE GRAPE BOX,\nYOU NEED AT LEAST 2 GRAPES", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	class orangeBoxListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(UserFile.Users.get(idx).getOrange()>=4){
				UserFile.Users.get(idx).setOrange(UserFile.Users.get(idx).getOrange()-4);
				UserFile.Users.get(idx).setOrangebox(UserFile.Users.get(idx).getOrangebox()+1);
				fr.setVisible(false);
			}else{
				JOptionPane.showMessageDialog(null, "TO MAKE ORANGE BOX,\nYOU NEED AT LEAST 4 ORANGES", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	class strawberryBoxListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(UserFile.Users.get(idx).getStrawBerry()>=8){
				UserFile.Users.get(idx).setStrawBerry(UserFile.Users.get(idx).getStrawBerry()-8);
				UserFile.Users.get(idx).setStrawberrybox(UserFile.Users.get(idx).getStrawberrybox()+1);
				fr.setVisible(false);
			}else{
				JOptionPane.showMessageDialog(null, "TO MAKE STRAWBERRY BOX,\nYOU NEED AT LEAST 8 STRAWBERRYS", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
}