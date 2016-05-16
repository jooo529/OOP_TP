import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame{
	
	public MainFrame()
	{
		go_main();
	}
	
	JFrame fr = new JFrame();
	ImageIcon im;
	
	public void go_main() {
		//this.setLayout(null);
		
		//JPanel p1 = new JPanel();
		//p1.setBackground(Color.yellow);
		//p1.setLayout(null);
		//p1.setBounds(0, 0, 900, 400);
		//this.add(p1);
		
		fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		
		fr.getContentPane().add(home_button);
		fr.getContentPane().add(farm_button);
		fr.getContentPane().add(store_button);
		fr.getContentPane().add(quit_button);
		fr.getContentPane().add(mission_button);
		fr.getContentPane().add(userID_label);
		fr.getContentPane().add(userMONEY_label);
		fr.getContentPane().add(userLEVEL_label);
		
		im = new ImageIcon("main.png");
		JPanel back_ground = new JPanel(){ 
		 public void paintComponent(Graphics g) {
             g.drawImage(im.getImage(), 0, 0, null); 
        }};
      
        fr.add(BorderLayout.CENTER,back_ground);
        
		fr.setSize(1000, 590);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		//창을 중앙에 위치시킬 수 있다.
		int xPos = screenSize.width/2 - fr.getSize().width/2 ;
		int yPos = screenSize.height/2 - fr.getSize().height/2 ;

		fr.setLocation(xPos,yPos);
		fr.setVisible(true);
		
	


	}
	
	class HomeButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event)
		{
			HomeDisplay home = new HomeDisplay();
			home.go();
			//HomeFrame home = new HomeFrame();
			
		}
	}
	class FarmButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event)
		{
			FarmDisplay farm = new FarmDisplay();
			farm.go();
			//FarmFrame farm = new FarmFrame();
		}
	}
	class StoreButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event)
		{
			StoreDisplay store = new StoreDisplay();
			store.go();
			//StoreFrame store = new StoreFrame();
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