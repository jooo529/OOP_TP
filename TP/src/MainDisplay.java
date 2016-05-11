import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainDisplay extends JFrame{

	JFrame fr = new  JFrame();
	
	public void go() {
		//this.setLayout(null);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//JPanel p1 = new JPanel();
		//p1.setBackground(Color.yellow);
		//p1.setLayout(null);
		//p1.setBounds(0, 0, 900, 400);
		//this.add(p1);
		JButton home_button = new JButton("Home");
		home_button.setBounds(75, 150, 100, 100);
		home_button.addActionListener(new HomeButtonListener());
		//p1.add(home_button);

		JButton farm_button = new JButton("Farm");
		farm_button.setBounds(325, 150, 100, 100);
		farm_button.addActionListener(new FarmButtonListener());
		//p1.add(farm_button);
		
		JButton store_button = new JButton("Store");
		store_button.setBounds(575, 150, 100, 100);
		store_button.addActionListener(new StoreButtonListener());
		//p1.add(store_button);
		
		JButton mission_button = new JButton("Mission");
		mission_button.setBounds(750,0,250,200);
		mission_button.addActionListener(new MissionButtonListener());
		
		User u = new User();
		JLabel userID_label = new JLabel("U s e r   :   "+u.GetID());
		JLabel userMONEY_label = new JLabel("M o n e y   :   "+u.GetearnedMoney());
		JLabel userLEVEL_label = new JLabel("L e v e l   :   "+u.getLevel());
		userID_label.setBounds(750, 200,250,66);
		userMONEY_label.setBounds(750,266,250,66);
		userLEVEL_label.setBounds(750,333,250,66);
		
		//JPanel p2 = new JPanel();
		//p2.setBackground(Color.green);
		//p2.setLayout(null);
		//p2.setBounds(0, 400, 900, 100);

		//this.add(p2);
		JButton quit_button = new JButton("Save and Quit");
		quit_button.setBounds(400, 420, 200, 50);
		quit_button.addActionListener(new SaveQuitButtonListener());
		//p2.add(quit_button);
		
		fr.setTitle("MainDisplay");
		fr.setSize(1000, 550);
		fr.setVisible(true);
		
		Main_background mainbackground = new Main_background();
		
		
		fr.getContentPane().add(home_button);
		fr.getContentPane().add(farm_button);
		fr.getContentPane().add(store_button);
		fr.getContentPane().add(quit_button);
		fr.getContentPane().add(mission_button);
		fr.add(userID_label);
		fr.add(userMONEY_label);
		fr.add(userLEVEL_label);
		fr.getContentPane().add(BorderLayout.CENTER,mainbackground);


	}
	
	class HomeButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event)
		{
			Home home = new Home();
			home.go_home();
		}
	}
	class FarmButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event)
		{
			Farm farm = new Farm();
			farm.go_farm();
		}
	}
	class StoreButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event)
		{
			Store store = new Store();
			store.go_store();
		}
	}
	class SaveQuitButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			///
			System.exit(0);
		}
	}
	class MissionButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			Mission mission = new Mission();
			mission.go_mission();
		}
		
	}

	
}