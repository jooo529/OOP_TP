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

public class HelpFrame extends JFrame{
	
	public HelpFrame(){
		go_help();
	}
	
	private Container container;
	private BufferedImage mission_ex;
	JButton mission1;
	JButton mission2;
	JButton mission3;
	JButton mission4;
	JButton mission5;
	JTextArea textarea;
	Font font = new Font("Kristen ITC",Font.BOLD, 20); //30���� ũ��
	Font font2 = new Font("Kristen ITC",Font.BOLD, 14);
	
	
	
	void go_help()
	{
		
		
		mission1 = new JButton();
		mission1.setIcon(new ImageIcon("mission_b_300.png"));
		mission1.addActionListener(new mission_b_listener());
		mission1.setRolloverIcon(new ImageIcon(""));
		JLabel label1 = new JLabel("        M i s s i o n 1 ");
		label1.setFont(font); 
		mission1.add(label1);
		
		mission2 = new JButton();
		mission2.setIcon(new ImageIcon("mission_b_300.png"));
		mission2.addActionListener(new mission_b_listener());
		mission2.setRolloverIcon(new ImageIcon(""));
		JLabel label2 = new JLabel("        M i s s i o n 2 ");
		label2.setFont(font);
		mission2.add(label2);
		
		mission3 = new JButton();
		mission3.setIcon(new ImageIcon("mission_b_300.png"));
		mission3.addActionListener(new mission_b_listener());
		mission3.setRolloverIcon(new ImageIcon(""));
		JLabel label3 = new JLabel("        M i s s i o n 3 "); 
		label3.setFont(font);
		mission3.add(label3);
		
		mission4 = new JButton();
		mission4.setIcon(new ImageIcon("mission_b_300.png"));
		mission4.addActionListener(new mission_b_listener());
		mission4.setRolloverIcon(new ImageIcon(""));
		JLabel label4 = new JLabel("        M i s s i o n 4 ");
		label4.setFont(font);
		mission4.add(label4);
		
		mission5 = new JButton();
		mission5.setIcon(new ImageIcon("mission_b_300.png"));
		mission5.addActionListener(new mission_b_listener());
		mission5.setRolloverIcon(new ImageIcon(""));
		JLabel label5 = new JLabel("        M i s s i o n 5 ");
		label5.setFont(font);
		mission5.add(label5);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5,1,0,0));
		buttonPanel.add(mission1);
		buttonPanel.add(mission2);
		buttonPanel.add(mission3);
		buttonPanel.add(mission4);
		buttonPanel.add(mission5);
		
		container = this.getContentPane();
		container.setLayout(null);
		
		buttonPanel.setBounds(0, 0, 300, 310);
		
		try {
			mission_ex = ImageIO.read(new File("mission_ex.png"));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		JPanel textPanel = new JPanel(){
		public void paintComponent(Graphics g) {
            
			 g.drawImage(mission_ex, 0,0 , 400, 310, this);
		}};;
		textPanel.setLayout(null);
		textarea = new JTextArea(10,20);
		
		textarea.setLineWrap(true);
		JScrollPane scroller = new JScrollPane(textarea);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		textPanel.add(scroller);
		textPanel.setBounds(300, 0, 400, 310);
		scroller.setBounds(40, 55, 320, 200);
		
		
		
		container.add(buttonPanel);
		container.add(textPanel);
		//container.add(BorderLayout.EAST,eastPanel);
		
		
		
		
		
		
	}
	
	
	class mission_b_listener implements ActionListener
	{

		public void actionPerformed(ActionEvent event)
		{
			textarea.setFont(font2);
			if(event.getSource() == mission1)
			{
				textarea.setText("<Mission 1>"
						+ "\nYou have to buy some fruitbox!"
						+ "\nYou can learn 'value and variable's relation' in this mission."
						+ "\n\nEach of fruits means value,"
						+ "\nand each of boxes means variable"
						+ "\n\nIf you try to put big fruit"
						+ "\nin small box, fruit will go to pieces! "
						+ "\n\nSo, you have to put each fruit in proper box!"
						+ "\n(= you have to put value in proper variable!)"
						);
				
			}
			else if(event.getSource() == mission2)
			{
				textarea.setText("<Mission 2>"
						+ "\nYou have to go to Farm and get some fruit!"
						+ "\nGo to Farm and just enjoy FruitGame!"
						);
			}
			else if(event.getSource() == mission3)
			{
				textarea.setText("<Mission 3>"
						+ "\nPut your all fruits in refrigerator!"
						+ "\nRefrigerator is located in Store."
						+ "\n\nYou can learn Stack in this mission."
						+ "\nStack's feature is 'First In Last Out'"
						+ "\nYou will store your fruits in refrigerator."
						+ "\n\nAnd when you make fruitjuice,"
						+ "\nyou will get fruit"
						+ "\nfrom top of refrigerator!"
						+ "\n\nFirst In, Last Out!"
						);
			}
			else if(event.getSource() == mission4)
			{
				textarea.setText("<Mission 4>"
						+ "\nYou have to make some fruit juice!"
						+ "\nGo to store and take some fruits"
						+ "\nout of refrigerator."
						+ "\nThen read recipe of Juice"
						+ "\nand make fruit juice"
						+ "\nYou can learn Class and Object from this Mission."
						+ "\nClass is blueprint of an Object."
						+ "\nand Object is an instance of the class."
						+ "\n\nIn this mission, recipe will be blueprint"
						+ "\nand juice will be instance of recipe! "
						);
			}
			else if(event.getSource() == mission5)
			{
				textarea.setText("<Mission 5>"
						+ "\nYou have to go to Store and sell juice!"
						+ "\nIn Store, some consumers will be there."
						+ "\nThey want your fruit juice!"
						+ "\nSell them some juice!"
						+ "\n\nYou can learn Queue in this mission!"
						+ "\nQueue's feature is 'First In,First Out"
						+ "\nConsumer who comes first will get juice first,"
						+ "\nand go out of store first!"
						+ "\n\nFirst In, First Out!"
						);
			}
		}
	}
	
	
	
	

}
