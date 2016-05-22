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
	
	private JPanel window;            
	      
	       
	void go_npc()
	{
		
		
		
		Font font = new Font("Dialog",Font.BOLD, 15); //30글자 크기
		Font font_italic = new Font("Serif",Font.ITALIC+Font.BOLD,18);
		container = this.getContentPane();//보더레이아웃
		container.setLayout(new BorderLayout());
		window = new JPanel();//여기에 대화창패널 ->그리드...?
		window.setBackground(Color.GRAY);
		//window.setLayout(new BoxLayout(window,BoxLayout.Y_AXIS));
		window.setLayout(new GridLayout(4,1,5,5));
		npcf = new ImageIcon("Char.PNG"); 
		
		JPanel npc_face = new JPanel(){ //엔피씨 얼굴나오게 할 패널
			 public void paintComponent(Graphics g) {
		            g.drawImage(npcf.getImage(), 0, 0, null); 
			 }
		};;
		
		JLabel npc_info = new JLabel("  I'm your mother!!  ");
		npc_info.setFont(font);
		JButton helpButton = new JButton(" H E L P ( Explanation about game )");
		helpButton.setFont(font);
		helpButton.addActionListener(new help_listener());
		JButton give_mission = new JButton(" G e t  M i s s o i n ");
		give_mission.setFont(font);
		give_mission.addActionListener(new get_mission_listener());
		JButton check_mission = new JButton(" C h e c k   M i s s i o n ");
		check_mission.setFont(font);
		JButton close_window = new JButton(" S t o p   t a l k   w i t h   N P C");
		close_window.setFont(font_italic);
		close_window.addActionListener(new goback_listener());
		
	
		
		//window.add(info);
		window.add(helpButton);
		window.add(give_mission);
		window.add(check_mission);
		window.add(close_window);
		npc_face.setBackground(Color.lightGray);
		npc_face.add(npc_info);
		
		container.add(BorderLayout.WEST,window);
		container.add(BorderLayout.EAST,npc_face);
		

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
	
	

}
