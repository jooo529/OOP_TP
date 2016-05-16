import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import HomeFrame.goback_listener;
//import Home.goback_listener;


public class FarmFrame extends JFrame{

	public FarmFrame(){
		go_farm();
	}
	
	ImageIcon im;
	Container container;
	
	public void go_farm()
	{
        ////////////
        container = this.getContentPane();
        container.setLayout(new BorderLayout());
       
        
		im = new ImageIcon("farm.png");
		JPanel back_ground = new JPanel(){ 
		 public void paintComponent(Graphics g) {
             g.drawImage(im.getImage(), 0, 0, null); 
        }};
      
       container.add(BorderLayout.CENTER,back_ground);
		
        
		JButton goback = new JButton("back to main");
		goback.addActionListener(new goback_listener());
		
		JPanel menupanel = new JPanel();
		
		container.add(BorderLayout.NORTH,menupanel);
		
		
		User u = new User();
		Font font = new Font("Dialog",Font.BOLD, 15); //20�� ���� ũ��
		

		
		JLabel userID_label = new JLabel("U s e r   :   "+ u.GetID());
		userID_label.setFont(font);
		
		JLabel userMONEY_label = new JLabel("           M o n e y   :   "+ u.GetearnedMoney());
		userMONEY_label.setFont(font);
		
		JLabel userLEVEL_label = new JLabel("           L e v e l   :   "+ u.getLevel());
		userLEVEL_label.setFont(font);
		
		JLabel enter = new JLabel("                      ");
		
		

		menupanel.add(userID_label);
		menupanel.add(userLEVEL_label);
		menupanel.add(userMONEY_label);
		menupanel.add(enter);
		menupanel.add(goback);
	}
	
	class goback_listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			setVisible(false);
		}
	}
}
