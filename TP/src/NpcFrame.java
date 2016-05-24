import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class NpcFrame extends JFrame{
	
	public NpcFrame(){
		go_npc();
	}
	
	
	private Container container;
    
	private ImageIcon npcf;
	private ImageIcon tb;
	
	private JPanel window;            
	      
	       
	void go_npc()
	{
		
		
		
		Font font = new Font("Dialog",Font.BOLD, 12); //30글자 크기
		Font font_italic = new Font("Serif",Font.ITALIC+Font.BOLD,14);
		container = this.getContentPane();
		container.setLayout(null);
		window = new JPanel();//여기에 대화창패널 ->그리드...?
		window.setBackground(Color.GRAY);
		//window.setLayout(new BoxLayout(window,BoxLayout.Y_AXIS));
		window.setLayout(new GridLayout(4,1,0,0));
		
		npcf = new ImageIcon("mom.png");
		tb = new ImageIcon("textBallon_hi.png");
		JPanel npc_face = new JPanel(){ //엔피씨 얼굴나오게 할 패널
			 public void paintComponent(Graphics g) {
		            g.drawImage(npcf.getImage(), 3, 0, null); 
		            g.drawImage(tb.getImage(), 180, 30, null); 
			 }
		};;
		
		npc_face.setLayout(null);
		JButton helpButton = new JButton();
		helpButton.setFont(font);
		helpButton.addActionListener(new help_listener());
		helpButton.setIcon(new ImageIcon("Help.png"));
		
		JButton give_mission = new JButton(" G e t  M i s s o i n ");
		give_mission.setFont(font);
		give_mission.addActionListener(new get_mission_listener());
		give_mission.setIcon(new ImageIcon("get_mission.png"));
		
		JButton check_mission = new JButton(" C h e c k   M i s s i o n ");
		check_mission.setFont(font);
		check_mission.addActionListener(new check_mission_listener());
		check_mission.setIcon(new ImageIcon("check_mission.png"));
		
		JButton close_window = new JButton(" S t o p   t a l k   w i t h   N P C");
		close_window.setIcon(new ImageIcon("stop_npc.png"));
		
		close_window.setFont(font_italic);
		close_window.addActionListener(new goback_listener());
		
	
		window.add(helpButton);
		window.add(give_mission);
		window.add(check_mission);
		window.add(close_window);
		window.setBounds(0, 0, 390, 310);
		
		npc_face.setBackground(Color.LIGHT_GRAY);
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
	
	class help_listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			HelpDisplay hp = new HelpDisplay();
			hp.go();
		}
	}
	
	class get_mission_listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			getMissionDisplay gm = new getMissionDisplay();
			gm.go();
		}
	}
	class check_mission_listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			checkDisplay cd = new checkDisplay();
			cd.go();
		}
	}
	
	

}
