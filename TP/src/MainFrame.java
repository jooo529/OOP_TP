import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

///import StoreFrame.goback_listener;

public class MainFrame extends JFrame{

	UserFile f = new UserFile();
	
	public MainFrame(){
		go_main();
	}
	
	ImageIcon im;
	
	public String toUserInfo() {
        int idx = -1;
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
		farm_button.setIcon(new ImageIcon("game_button_image.png"));
		farm_button.setRolloverIcon(new ImageIcon("game_button_image_s.png"));
		farm_button.setBackground(null);
		farm_button.setBorderPainted(false);
		farm_button.setBounds(85, 150, 100, 100);
		farm_button.addActionListener(new FarmButtonListener());
		
		JButton home_button = new JButton("Home");
		home_button.setContentAreaFilled(false);
		home_button.setDefaultCapable(false);
		home_button.setFocusPainted(false);
		home_button.setOpaque(false);
		home_button.setIcon(new ImageIcon("home_button_image.png"));
		home_button.setRolloverIcon(new ImageIcon("home_button_image_s.png"));
		home_button.setBackground(null);
		home_button.setBorderPainted(false);
		home_button.setBounds(335, 150, 100, 100);
		home_button.addActionListener(new HomeButtonListener());

		JButton store_button = new JButton("Store");
		store_button.setContentAreaFilled(false);
		store_button.setDefaultCapable(false);
		store_button.setFocusPainted(false);
		store_button.setOpaque(false);
		store_button.setIcon(new ImageIcon("market_button_image.png"));
		store_button.setRolloverIcon(new ImageIcon("market_button_image_s.png"));
		store_button.setBackground(null);
		store_button.setBorderPainted(false);
		store_button.setBounds(585, 150, 100, 100);
		store_button.addActionListener(new StoreButtonListener());
		
		JTextArea missionInfo = new JTextArea("Mission\n\n\n\n\n\n");
		missionInfo.setBounds(735, 48, 250,75);

		JTextField userInfo = new JTextField(toUserInfo(),JLabel.CENTER);
		Font font = new Font("Dialog", Font.BOLD, 14);
		userInfo.setFont(font);
		userInfo.setEditable(false);
		
		userInfo.setBounds(633, 13, 352, 30);
		userInfo.setBackground(Color.BLACK);
		userInfo.setForeground(Color.ORANGE);
		
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
			HomeDisplay home = new HomeDisplay();
			home.go();
		}
	}
	class FarmButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event)
		{
			FarmDisplay farm = new FarmDisplay();
			farm.go();
		}
	}
	class StoreButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event)
		{
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