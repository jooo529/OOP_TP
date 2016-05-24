import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import javax.swing.*;

public class checkFrame extends JFrame {	
	
	public checkFrame(){
		go_cf();
	}
	
	
	private Container container;
    
	private ImageIcon npcf;
	private ImageIcon tb;
	private JPanel window;            
	      
	JButton mission1;
	JButton mission2;
	JButton mission3;
	JButton mission4;
	JButton mission5;
	Font font = new Font("Kristen ITC",Font.BOLD, 20); //30글자 크기
	
	void go_cf()
	{
		
		
		
		
		Font font_italic = new Font("Serif",Font.ITALIC+Font.BOLD,14);
		container = this.getContentPane();
		container.setLayout(null);
		
		window = new JPanel();//여기에 대화창패널 ->그리드...?
		window.setBackground(Color.GRAY);
		window.setLayout(new GridLayout(5,1,0,0));
		
		npcf = new ImageIcon("mom.PNG"); 
		tb = new ImageIcon("textBallon_checkm.png");
		JPanel npc_face = new JPanel(){ //엔피씨 얼굴나오게 할 패널
			 public void paintComponent(Graphics g) {
		            g.drawImage(npcf.getImage(), 3, 0, null); 
		            g.drawImage(tb.getImage(), 180, 30, null); 
			 }
		};;
		npc_face.setLayout(null);
		
		mission1 = new JButton();
		mission1.setIcon(new ImageIcon("mission_b.png"));
		mission1.addActionListener(new mission_b_listener());
		JLabel label1 = new JLabel("            M  i  s  s  i  o  n  1  ");
		mission1.setRolloverIcon(new ImageIcon(""));
		label1.setFont(font);
		mission1.add(label1);
		
		mission2 = new JButton();
		mission2.setIcon(new ImageIcon("mission_b.png"));
		mission2.addActionListener(new mission_b_listener());
		mission2.setRolloverIcon(new ImageIcon(""));
		JLabel label2 = new JLabel("            M  i  s  s  i  o  n  2  ");
		label2.setFont(font);
		mission2.add(label2);
		
		mission3 = new JButton();
		mission3.setIcon(new ImageIcon("mission_b.png"));
		mission3.addActionListener(new mission_b_listener());
		mission3.setRolloverIcon(new ImageIcon(""));
		JLabel label3 = new JLabel("            M  i  s  s  i  o  n  3  ");
		label3.setFont(font);
		mission3.add(label3);
		
		mission4 = new JButton();
		mission4.setIcon(new ImageIcon("mission_b.png"));
		mission4.addActionListener(new mission_b_listener());
		mission4.setRolloverIcon(new ImageIcon(""));
		JLabel label4 = new JLabel("            M  i  s  s  i  o  n  4  ");
		label4.setFont(font);
		mission4.add(label4);
		
		mission5 = new JButton();
		mission5.setIcon(new ImageIcon("mission_b.png"));
		mission5.addActionListener(new mission_b_listener());
		mission5.setRolloverIcon(new ImageIcon(""));
		JLabel label5 = new JLabel("            M  i  s  s  i  o  n  5  ");
		label5.setFont(font);
		mission5.add(label5);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5,1,0,0));
		buttonPanel.add(mission1);
		buttonPanel.add(mission2);
		buttonPanel.add(mission3);
		buttonPanel.add(mission4);
		buttonPanel.add(mission5);
		
	

		window.add(mission1);
		window.add(mission2);
		window.add(mission3);
		window.add(mission4);
		window.add(mission5);
	
		window.setBounds(0, 0, 390, 310);
		npc_face.setBounds(390, 0, 300, 350);
		
		
		
		container.add(window);
		container.add(npc_face);
		

	}
	
	class goback_listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			setVisible(false);
		}
	}
	
	
	class mission_b_listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource() == mission1)
			{
				
			}
			else if(event.getSource() == mission2)
			{
				
			}
			else if(event.getSource() == mission3)
			{
				
			}
			else if(event.getSource() == mission4)
			{
				
			}
			else if(event.getSource() == mission5)
			{
				
			}
		}
	}
	
}
