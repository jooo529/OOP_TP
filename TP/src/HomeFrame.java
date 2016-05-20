import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.*;

public class HomeFrame extends JFrame{
	
	public HomeFrame(){
		go_home();
	}
	
	ImageIcon im;
	Container container;
	public void go_home()
	{
        container = this.getContentPane();
        container.setLayout(new BorderLayout());
       
        
		im = new ImageIcon("HOME3.png");
		JPanel back_ground = new JPanel(){ 
		 public void paintComponent(Graphics g) {
             g.drawImage(im.getImage(), 0, 0, null); 
        }};
      
       container.add(BorderLayout.CENTER,back_ground);
		
        
		JButton goback = new JButton("back to main");
		goback.addActionListener(new goback_listener());
		
			
		//메뉴패널 꾸며야될듯
		JPanel menupanel = new JPanel();
		
		container.add(BorderLayout.NORTH,menupanel);
		
		
		User u = new User();
		Font font = new Font("Dialog",Font.BOLD, 15); //20은 글자 크기
		

		
		JLabel userID_label = new JLabel("U s e r   :   "+ u.getId());
		userID_label.setFont(font);
		
		JLabel userMONEY_label = new JLabel("           M o n e y   :   "+ u.getmoney());
		userMONEY_label.setFont(font);
		
		JLabel userLEVEL_label = new JLabel("           L e v e l   :   "+ u.getLevel());
		userLEVEL_label.setFont(font);
		
		JLabel enter = new JLabel("                      ");
		
		

		menupanel.add(userID_label);
		menupanel.add(userLEVEL_label);
		menupanel.add(userMONEY_label);
		menupanel.add(enter);
		menupanel.add(goback);
		
		
		//userID_label.setBounds(750, 310,50,50);
		//userID_label.setSize(50,50);
		//userMONEY_label.setBounds(750, 370,50,50);
		//userMONEY_label.setSize(50,50);
		//userLEVEL_label.setBounds(750, 430,50,50);
		//userLEVEL_label.setSize(50,50);
		

	}
	
	class goback_listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			setVisible(false);
		}
	}


}