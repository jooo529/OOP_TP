import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RankButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		go();
	}

	void go(){
		RankFrame rank_fr = new RankFrame();

		rank_fr.setSize(800,500);
		rank_fr.setVisible(true);
		//rank_fr.setResizable(false);
		rank_fr.setDefaultCloseOperation(RankFrame.DISPOSE_ON_CLOSE);
		
		//전체 창 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		//창을 중앙에 위치시킬 수 있다.
		int xPos = screenSize.width/2 - rank_fr.getSize().width/2 ;
		int yPos = screenSize.height/2 - rank_fr.getSize().height/2 ;

		rank_fr.setLocation(xPos,yPos);
		
	}

}

class RankFrame extends JFrame{

	JTable rank_tb;
	JScrollPane rank_sp;
	JButton back_btn;
	DefaultTableModel model;

	public RankFrame(){
	  super("Rank");
	  makeFindScreen();
	 }
	 
	 public void makeFindScreen(){
	 
		 rank_tb = new JTable(model);
		 rank_sp = new JScrollPane(rank_tb);
		 this.add(rank_sp);
	
		 back_btn = new JButton("Back");
		 back_btn.addActionListener(new RankButtonListener(){
			 public void actionPerformed(ActionEvent event){
				setVisible(false);
		}});
			
		 this.add(BorderLayout.NORTH, back_btn);
	 
	 }
}