import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import javax.swing.*;

public class getMissionFrame extends JFrame {	

	private Container container;
	
	private ImageIcon npcf;
	
	Font font = new Font("Dialog",Font.BOLD, 15);
	
	public getMissionFrame(){
		go_gm();
	}
	
	
	void go_gm()
	{
		npcf = new ImageIcon("Char.PNG");
		JPanel npc_face = new JPanel(){ //엔피씨 얼굴나오게 할 패널
			 public void paintComponent(Graphics g) {
		            g.drawImage(npcf.getImage(), 0, 0, null); 
			 }
		};;
		
		
		JLabel npc_info = new JLabel("  I'm your mother!!  ");
		npc_info.setFont(font);
		npc_face.setBackground(Color.lightGray);
		npc_face.add(npc_info);
		
		container = this.getContentPane();
		
		////////////////////////////////////////////////////////////////////
		JButton Exit = new JButton("Exit");

		
		Exit.setContentAreaFilled(false);
		Exit.setDefaultCapable(false);
		Exit.setFocusPainted(false);
		Exit.setToolTipText("exit");
		Exit.setOpaque(false);
		Exit.setIcon(new ImageIcon("button_exit.png"));
		Exit.setRolloverIcon(new ImageIcon("button_exit_s.png"));
		Exit.setBackground(null);
		Exit.setBorderPainted(false);

		
		Exit.setBounds(700, 420 - 250 + 270, 60, 60);

		//Fire.addActionListener(this);
		//Market.addActionListener(this);
		Exit.addActionListener(new goback_listener());
		////////////////////////////////////////////////////////////////////
		
		
		JButton mission1 = new JButton(" M I S S I O N  1 ");
		JButton mission2 = new JButton(" M I S S I O N  2 ");
		JButton mission3 = new JButton(" M I S S I O N  3 ");
		JButton mission4 = new JButton(" M I S S I O N  4 ");
		JButton mission5 = new JButton(" M I S S I O N  5 ");
		JButton mission6 = new JButton(" M I S S I O N  6 ");
		JButton mission7 = new JButton(" M I S S I O N  7 ");
		mission1.setFont(font);
		mission2.setFont(font);
		mission3.setFont(font);
		mission4.setFont(font);
		mission5.setFont(font);
		mission6.setFont(font);
		mission7.setFont(font);
		
		JPanel mission_button_panel = new JPanel();
		mission_button_panel.setLayout(new BoxLayout(mission_button_panel,BoxLayout.Y_AXIS));
		mission_button_panel.add(mission1);
		mission_button_panel.add(mission2);
		mission_button_panel.add(mission3);
		mission_button_panel.add(mission4);
		mission_button_panel.add(mission5);
		mission_button_panel.add(mission6);
		mission_button_panel.add(mission7);
		
		JButton go_back = new JButton("Back");
		go_back.setFont(font);
		go_back.addActionListener(new goback_listener());
		
		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(new BorderLayout());
		eastPanel.add(BorderLayout.NORTH,npc_face);
		eastPanel.add(BorderLayout.SOUTH,Exit);
		
		container.add(BorderLayout.WEST,mission_button_panel);
		container.add(BorderLayout.EAST,eastPanel);
		
		
		
		
		
	}
	
	private void addExitButton() {
		
		

	}
	
	
	
	
	
	class goback_listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			setVisible(false);
		}
	}
	
	class mission1_listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			
		}
	}
	class mission2_listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			
		}
	}
	class mission3_listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			
		}
	}
	class mission4_listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			
		}
	}
	class mission5_listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			
		}
	}
	class mission6_listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			
		}
	}
	class mission7_listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			
		}
	}
	
	
}

