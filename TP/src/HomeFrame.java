import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


import javax.swing.*;

public class HomeFrame extends JFrame{
	
	public HomeFrame(){
		go_home();
	}
	BufferedImage im_background;
	JButton Exit = new JButton("Exit");
	JButton character = new JButton();
	Container container;
	//
	
	public void go_home()
	{
		try {
			im_background = ImageIO.read(new File("HOME3.png"));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
        container = this.getContentPane();
       
		JPanel back_ground = new JPanel(){ 
		 public void paintComponent(Graphics g) {
            
			 g.drawImage(im_background, 0, 0, 1000, 550, this);
	
        }};
      
       back_ground.setLayout(null);
       container.add(BorderLayout.CENTER,back_ground);
       
       Exit = new JButton("Exit");
       
		
		Exit.setContentAreaFilled(false);
		Exit.setDefaultCapable(false);
		Exit.setFocusPainted(false);
		Exit.setToolTipText("exit");
		Exit.setOpaque(false);
		Exit.setIcon(new ImageIcon("button_exit.png"));
		Exit.setRolloverIcon(new ImageIcon("button_exit_s.png"));
		Exit.setBackground(null);
		Exit.setBorderPainted(false);

		Exit.setBounds(900, 400, 60, 60);
		Exit.addActionListener(new button_listener());
		
		
		character.setContentAreaFilled(false);
		character.setDefaultCapable(false);
		character.setFocusPainted(false);
		character.setToolTipText("NPC CLICK");
		character.setIcon(new ImageIcon("doll_default.png"));
		character.setRolloverIcon(new ImageIcon("doll_default_s.png"));
		character.setBorderPainted(false);
		character.addActionListener(new button_listener());
		character.setBounds(400, 200, 200 , 160);		
		character.setOpaque(false);
		
		back_ground.add(character);
		back_ground.add(Exit);
		
		
		
		
        JPanel menupanel = new JPanel();

		User u = new User();
		Font font = new Font("Dialog",Font.BOLD, 15); //20은 글자 크기
		
        JButton goback = new JButton("back to main");
		
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
		//menupanel.add(Exit);
		container.add(BorderLayout.NORTH,menupanel);
		
		
	}
	
	class button_listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			
			if(event.getSource()==character)
			{
				NpcDisplay npc = new NpcDisplay();
				npc.go();
			}
			else if(event.getSource()==Exit)
			{
				setVisible(false);
			}
			
		}
	}
	
	/*class mouse_listener extends MouseAdapter
	{

		@Override
		public void mouseClicked(MouseEvent e){
			//System.out.println(e.getPoint().x +"and"+e.getPoint().y);
			if(e.getPoint().x>450&&e.getPoint().x<580&&e.getPoint().y>275&&e.getPoint().y<410){
				if(e.getClickCount() == 2){
					NpcDisplay npc = new NpcDisplay();
					npc.go();
					
				}
				
			}
			
		}


	}*/
	


}