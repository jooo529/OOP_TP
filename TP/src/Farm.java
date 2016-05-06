import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Farm {

	
	JFrame fr = new  JFrame();
	public void go_farm()
	{
		
		JButton goback = new JButton("back");
		goback.addActionListener(new goback_listener());
		goback.setBounds(700, 350, 100, 100);

		Farm_background farmbackground = new Farm_background();
		fr.setSize(900, 550);
		fr.setVisible(true);
		fr.getContentPane().add(goback);
	

		fr.getContentPane().add(BorderLayout.CENTER,farmbackground);
	}
	
	class goback_listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			fr.setVisible(false);
		}
	}
}
