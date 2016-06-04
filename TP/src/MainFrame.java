import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame{

	MissionFile mf = new MissionFile();
	static int idx = -1;
	
	public MainFrame(){
		go_main();
	}
	
	ImageIcon im;
	
	public String toUserInfo() {
        for(int i=0; i<UserFile.Users.size(); i++){
        	if(UserFile.Users.get(i).getIndex()>-1) idx = i;
		}		
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
		farm_button.addActionListener(new FarmButtonListener());
		
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
		home_button.addActionListener(new HomeButtonListener());

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
		store_button.addActionListener(new StoreButtonListener());
		
		JTextArea missionInfo = new JTextArea();
		missionInfo.setBounds(735, 48, 250, 220);
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
		else if (UserFile.Users.get(idx).getLevel() == 1)	missionInfo.setText(mf.fileLoad("Mission1.txt"));
		else if (UserFile.Users.get(idx).getLevel() == 2)	missionInfo.setText(mf.fileLoad("Mission2.txt"));
		else if (UserFile.Users.get(idx).getLevel() == 3)	missionInfo.setText(mf.fileLoad("Mission3.txt"));
		else if (UserFile.Users.get(idx).getLevel() == 4)	missionInfo.setText(mf.fileLoad("Mission4.txt"));
		else if (UserFile.Users.get(idx).getLevel() == 5)	missionInfo.setText(mf.fileLoad("Mission5.txt"));
		
		JButton quit_button = new JButton("Save and Quit");
		quit_button.setBounds(735, 450, 250, 80);
		quit_button.addActionListener(new SaveQuitButtonListener());
		
		
		getContentPane().add(farm_button);
		getContentPane().add(home_button);
		getContentPane().add(store_button);
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
	
	class HomeButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event)
		{
			setVisible(false);
			HomeDisplay home = new HomeDisplay();
			home.go();
		}
	}
	class FarmButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event)
		{
			//setVisible(false);
			FarmDisplay farm = new FarmDisplay();
			farm.go();
		}
	}
	class StoreButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event)
		{
			setVisible(false);
			StoreDisplay store = new StoreDisplay();
			store.go();
		}
	}
	class SaveQuitButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			for(int i=0; i<UserFile.Users.size(); i++){
				UserFile.Users.get(i).setIndex(-1);
			}
			System.exit(0);
		}
	}
	
}