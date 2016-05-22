import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.*;

public class HelpFrame extends JFrame{
	
	private Container container;
	JList list = new JList<String>(new String[]
			{" M i s s i o n  1 "," M i s s i o n  2 "," M i s s i o n  3 ",
					" M i s s i o n  4 "," M i s s i o n  5 "," M i s s i o n  6 "," M i s s i o n  7 "});
	private ImageIcon npcf;
	Font font = new Font("Dialog",Font.BOLD, 15);
	public HelpFrame(){
		go_help();
	}
	
	
	void go_help()
	{
		npcf = new ImageIcon("Char.PNG");
		JPanel npc_face = new JPanel(){ //엔피씨 얼굴나오게 할 패널
			 public void paintComponent(Graphics g) {
		            g.drawImage(npcf.getImage(), 0, 0, null); 
			 }
		};;
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
		Exit.addActionListener(new goback_listener());
		
		
		JLabel npc_info = new JLabel("  I'm your mother!!  ");
		npc_info.setFont(font);
		
		npc_face.setBackground(Color.lightGray);
		npc_face.add(npc_info);
		list.setFont(font);
		list.setVisibleRowCount(5); //현재 보더레이아웃 west에 박아놔서 5개만 보이는게 아니라 다보여버림
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);;
		list.addListSelectionListener(new select_listener());
		container = this.getContentPane();
		//JButton go_back = new JButton("Back");
		//go_back.addActionListener(new goback_listener());
		
		JScrollPane scroller = new JScrollPane(list);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(new BorderLayout());
		eastPanel.add(BorderLayout.NORTH,npc_face);
		eastPanel.add(BorderLayout.SOUTH,Exit);
		
		container.add(BorderLayout.WEST,scroller);
		container.add(BorderLayout.EAST,eastPanel);
		
		
		
		
		
		
	}
	
	class goback_listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			setVisible(false);
		}
	}
	
	class select_listener implements ListSelectionListener
	{

		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			int i = list.getSelectedIndex();
			
			
			switch(i)
			{
			case 0:
				//미션 1 설명
				
			case 1:
				System.out.println(i);
				
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
				//누르면 Help창  스크롤바 옆에서 보여주기로
			}
			
		}
		
	}
	
	
	

}
