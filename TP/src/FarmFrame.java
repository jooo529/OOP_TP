import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//import HomeFrame.goback_listener;
//import Home.goback_listener;

public class FarmFrame extends JFrame {

	public FarmFrame() {
		go_farm();
	}

	ImageIcon im;
	Container container;
	JList<String> list;
	
	public void go_farm()
	{
        ////////////
        container = this.getContentPane();
        container.setLayout(new BorderLayout());
        
        
		im = new ImageIcon("farm.png");
		JPanel back_ground = new JPanel(){ 
		 public void paintComponent(Graphics g) {
             g.drawImage(im.getImage(), 0, 0, null); 
             
             g.setFont(new Font("serif", Font.BOLD, 28));
             g.drawString("Which Fruit do you want to get?", 25, 35);
        }};
        
        JButton gochoose = new JButton("Go to choose");
        gochoose.setFont(new Font("serif",Font.BOLD,20));
        gochoose.addActionListener(new gochoose_listener());
        
        back_ground.add(gochoose);
        
        
        container.add(BorderLayout.CENTER,back_ground);
        //*
        
        
        //*
        
		JButton goback = new JButton("back to main");
		goback.addActionListener(new goback_listener());
		
		JPanel menupanel = new JPanel();
		
		container.add(BorderLayout.NORTH,menupanel);
		
		
		User u = new User();
		Font font = new Font("Dialog",Font.BOLD, 15); //20은 글자 크기
		

		
		JLabel userID_label = new JLabel("U s e r   :   "+ u.getId());
		userID_label.setFont(font);
		
		JLabel userMONEY_label = new JLabel("           M o n e y   :   "+ u.getMoney());
		userMONEY_label.setFont(font);
		
		JLabel userLEVEL_label = new JLabel("           L e v e l   :   "+ u.getLevel());
		userLEVEL_label.setFont(font);
		
		JLabel enter = new JLabel("                      ");
		
		

		menupanel.add(userID_label);
		menupanel.add(userLEVEL_label);
		menupanel.add(userMONEY_label);
		menupanel.add(enter);
		menupanel.add(goback);
	}

	class goback_listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			setVisible(false);
		}
	}
	
	class gochoose_listener implements ActionListener, ListSelectionListener{
		public void actionPerformed(ActionEvent e) {
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			 
			
			int xPos = screenSize.width/2 - 100;
			int yPos = screenSize.height/2 - 220;
			
			list = new JList<String>(new String[]{"Apple","Grape","Orange","Strawberry"});
			list.setVisibleRowCount(4);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.addListSelectionListener(this);
			list.setFont(new Font("Dialog",Font.BOLD, 15));
			
			JButton ok_btn = new JButton("Ok");
			ok_btn.addActionListener(new ok_listener());
			
			frame.add(list);
			frame.add(ok_btn);
			frame.setSize(200,200);
			frame.setLocation(xPos,yPos);
			frame.setVisible(true);
		}
		
		
		public void valueChanged(ListSelectionEvent e) {
			
		}
	}
	
	class ok_listener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(list.getSelectedValue()=="Apple"){
				
			}
			setVisible(false);
		}
		
	}
}
