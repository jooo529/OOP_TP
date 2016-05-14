import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import Home.goback_listener;

public class Mission {

	JFrame fr = new  JFrame();
	public void go_mission()
	{
		
		JPanel jp = new JPanel();
		JButton goback = new JButton("back to main");
		jp.add(goback);
		fr.getContentPane().add(BorderLayout.SOUTH,jp);
		goback.addActionListener(new goback_listener());
		goback.setBounds(700, 350, 100, 100);
		
		fr.setSize(1000, 590);
		fr.setVisible(true);
		fr.setResizable(false);
		fr.setDefaultCloseOperation(LoginFrame.EXIT_ON_CLOSE);
		
		//전체 창 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		//창을 중앙에 위치시킬 수 있다.
		int xPos = screenSize.width/2 - fr.getSize().width/2 ;
		int yPos = screenSize.height/2 - fr.getSize().height/2 ;

		fr.setLocation(xPos,yPos);
	}
	
	class goback_listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			fr.setVisible(false);
		}
	}
	
}
