import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FindButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		go();
	}

	void go(){
		FindFrame find_fr = new FindFrame();

		find_fr.setSize(500,150);
		find_fr.setVisible(true);
		find_fr.setResizable(false);
		find_fr.setDefaultCloseOperation(FindFrame.DISPOSE_ON_CLOSE);
		
		//전체 창 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		//창을 중앙에 위치시킬 수 있다.
		int xPos = screenSize.width/2 - find_fr.getSize().width/2 ;
		int yPos = screenSize.height/2 - find_fr.getSize().height/2 ;

		find_fr.setLocation(xPos,yPos);
		
	}

}

class FindFrame extends JFrame{

	JTextField Name_tf,Phone_tf1,Phone_tf2;
	JComboBox Phone_cb ;
	JButton confirm;

	public FindFrame(){
	  super("Find");
	  makeFindScreen();
	 }
	 
	 public void makeFindScreen(){
	 
		 this.setLayout(new BorderLayout());
		 this.add(BorderLayout.NORTH,new JLabel("Put your Info"));
		  
		 JPanel panel = new JPanel(new GridLayout(2,2));
		 this.add(BorderLayout.CENTER, panel);
		 
		 panel.add(new JLabel("Name",JLabel.CENTER));
		 JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		 Name_tf = new JTextField(8);
		 panel4.add(Name_tf);
		 panel.add(panel4);
		  
		 panel.add(new JLabel("Phone",JLabel.CENTER));
		 JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		 String[] phone = {"010","011","016","019"};
		 Phone_cb = new JComboBox<String>(phone);
		 Phone_tf1 = new JTextField(4);
		 Phone_tf2 = new JTextField(4);
		 panel5.add(Phone_cb);
		 panel5.add(new JLabel("-"));
		 panel5.add(Phone_tf1);
		 panel5.add(new JLabel("-"));
		 panel5.add(Phone_tf2);
		 panel.add(panel5);
	
		 JPanel panel6 = new JPanel();
		 confirm = new JButton("Confirm");
		 panel6.add(confirm);
		 this.add(BorderLayout.SOUTH, panel6);
	 
	 }
}