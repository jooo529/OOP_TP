import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class NpcFrame extends JFrame{
	
	public NpcFrame(){
		//set frame's state
		this.setSize(700,350);
		this.setTitle("NPC");
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(LoginFrame.DISPOSE_ON_CLOSE);
		
		//entire window's size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		//locate frame in center
		int xPos = screenSize.width/2 - this.getSize().width/2 ;
		int yPos = screenSize.height/2 - this.getSize().height/2 ;

		this.setLocation(xPos,yPos);
		
		this.go_npc();
	}
	
	
	private Container container;//frame
    
	private ImageIcon npcf; //mom's image
	private ImageIcon tb; //what does mom say
	
	private JPanel window;   //button will be here
	
	private JButton close_window;
	private JButton helpButton;
	private JButton give_mission;
	private JButton check_mission;
	      
	private Font font = new Font("Dialog",Font.BOLD, 12);
	private Font font_italic = new Font("Serif",Font.ITALIC+Font.BOLD,14);
	       
	void go_npc()
	{
		container = this.getContentPane();
		container.setLayout(null);
		
		window = new JPanel();//buttons in here
		window.setBackground(Color.GRAY);
		window.setLayout(new GridLayout(4,1,0,0)); //four button will be here
		window.setBounds(0, 0, 390, 310);
		
		npcf = new ImageIcon("mom.png"); //mom's image
		tb = new ImageIcon("textBallon_hi.png"); //what does mom say image
		
		JPanel npc_face = new JPanel(){ //mom's face image
			 public void paintComponent(Graphics g) {
		            g.drawImage(npcf.getImage(), 3, 0, null); 
		            g.drawImage(tb.getImage(), 180, 30, null); 
			 }
		};;
		npc_face.setLayout(null);
		npc_face.setBounds(390, 0, 300, 350);
		
//make buttons		
		helpButton = new JButton();
		helpButton.setFont(font);
		helpButton.addActionListener(new buttonlisten());
		helpButton.setIcon(new ImageIcon("Help.png"));
		
		give_mission = new JButton(" G e t  M i s s o i n ");
		give_mission.setFont(font);
		give_mission.addActionListener(new buttonlisten());
		give_mission.setIcon(new ImageIcon("get_mission.png"));
		
		check_mission = new JButton(" C h e c k   M i s s i o n ");
		check_mission.setFont(font);
		check_mission.addActionListener(new buttonlisten());
		check_mission.setIcon(new ImageIcon("check_mission.png"));
		
		close_window = new JButton(" S t o p   t a l k   w i t h   N P C");
		close_window.setIcon(new ImageIcon("stop_npc.png"));		
		close_window.setFont(font_italic);
		close_window.addActionListener(new buttonlisten());
//make button---
	
		try{
			window.add(helpButton);
			window.add(give_mission);
			window.add(check_mission);
			window.add(close_window);
			container.add(window);
			container.add(npc_face);
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}


	}
	
	class buttonlisten implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource()==close_window)
			{
				setVisible(false);
			}
			else if(event.getSource()==helpButton)
			{
				HelpFrame hp = new HelpFrame();
			}
			else if(event.getSource()==check_mission)
			{
				checkFrame checkframe = new checkFrame();
			}
			else if(event.getSource()==give_mission)
			{
				getMissionFrame getmissionframe = new getMissionFrame();
			}
		}
	}
	
	
	
	

}
