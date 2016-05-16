import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame{
	public MainFrame(){
		go_main();
	}
	
	ImageIcon im;
	
	public void go_main() {
		
		JButton farm_button = new JButton("Farm");
		farm_button.setBounds(85, 150, 100, 100);
		farm_button.addActionListener(new FarmButtonListener());
		//p1.add(farm_button);
		
		JButton home_button = new JButton("Home");
		home_button.setBounds(335, 150, 100, 100);
		home_button.addActionListener(new HomeButtonListener());
		//p1.add(home_button);

		JButton store_button = new JButton("Store");
		store_button.setBounds(585, 150, 100, 100);
		store_button.addActionListener(new StoreButtonListener());
		//p1.add(store_button);
		
		JTextArea info = new JTextArea("Mission\n\n\n\n\n\n");
		info.setBounds(735, 48, 250,75);
		
		/*User u = new User();
		JLabel userID_label = new JLabel("U s e r   :   "+u.GetID());
		JLabel userMONEY_label = new JLabel("M o n e y   :   "+u.GetearnedMoney());
		JLabel userLEVEL_label = new JLabel("L e v e l   :   "+u.getLevel());
		userID_label.setBounds(750, 200,250,66);
		userMONEY_label.setBounds(750,266,250,66);
		userLEVEL_label.setBounds(750,333,250,66);
		*/
		
		//JPanel p2 = new JPanel();
		//p2.setBackground(Color.green);
		//p2.setLayout(null);
		//p2.setBounds(0, 400, 900, 100);

		//this.add(p2);
		JButton quit_button = new JButton("Save and Quit");
		quit_button.setBounds(735, 450, 250, 80);
		quit_button.addActionListener(new SaveQuitButtonListener());
		//p2.add(quit_button);

		getContentPane().add(farm_button);
		getContentPane().add(home_button);
		getContentPane().add(store_button);
		getContentPane().add(quit_button);
		getContentPane().add(info);
	
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
			///
			System.exit(0);
		}
	}
	
}