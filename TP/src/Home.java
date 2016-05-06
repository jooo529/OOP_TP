import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Home {

	JFrame fr = new  JFrame();
	public void go_home()
	{
		
		JButton goback = new JButton("back");
		goback.addActionListener(new goback_listener());
		goback.setBounds(700, 350, 100, 100);
		
		
		
		
		
		Home_background homebackground = new Home_background();
		fr.setSize(900, 550);
		fr.setVisible(true);
		fr.getContentPane().add(goback);
	

		fr.getContentPane().add(BorderLayout.CENTER,homebackground);
	}
	
	class goback_listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			fr.setVisible(false);
		}
	}


}